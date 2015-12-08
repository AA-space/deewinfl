package com.business.serviceImpl.transferInterest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.business.action.leasing.contract.approval.ContractApprovalStartAction;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContractTemp;
import com.business.entity.interest.FundStandardInterest;
import com.business.service.TableService;
import com.business.service.transferInterest.TransferInterestService;
import com.tenwa.leasing.renttranrate.service.impl.RentTranRateServiceImpl;

/**
 * 调息的实现类
 * @author 孙传良
 * @date 2013-10-17下午04:23:39
 * @info
 * @Copyright 
 * Tenwa
 */
@Service(value = "transferInterestService")
public class TransferInterestServiceImpl implements TransferInterestService {

	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name="contractApprovalStartAction")
	private ContractApprovalStartAction contractApprovalStartAction;
	
	@Override
	public String updateConditionByTransferInterest(String adjustId,
			String docId, String contractId) throws Exception {
		FundStandardInterest fsi = (FundStandardInterest)this.tableService.findEntityByID(FundStandardInterest.class, adjustId);
		ContractInfo contractInfo = this.tableService.findEntityByID(ContractInfo.class, contractId);
		//不是同一个事物不能在这里初始化数据
//		contractApprovalStartAction.saveConditionDataToTemp(contractInfo, docId, tableService);//构建数据到临时表中
		//进行调息
		Hashtable<String,String> re_ht = new Hashtable<String,String>();
		RentTranRateServiceImpl rtrsi = new RentTranRateServiceImpl();
		re_ht = rtrsi.processTransRate(adjustId, contractInfo.getId(), contractInfo.getContractId(), "",docId);
		if("true".equals(re_ht.get("isSucess"))){
			if("true".equals(re_ht.get("isOver"))){
				FundAdjustInterestContractTemp faict=new FundAdjustInterestContractTemp();
				faict.setContractId(contractInfo);
				faict.setAdjustId(fsi);
				faict.setDocId(docId);
				faict.setStartList(Integer.parseInt(re_ht.get("startList")));
				faict.setRateOriginal(new BigDecimal(re_ht.get("oldRate")));
				faict.setRateAdjust(new BigDecimal(re_ht.get("newRate")));
				faict.setOldIrr(new BigDecimal(re_ht.get("oldIrr")));
				faict.setNewIrr(new BigDecimal(re_ht.get("newIrr")));
				faict.setOldPlanIrr(new BigDecimal(re_ht.get("oldPlanIrr")));
				faict.setNewPlanIrr(new BigDecimal(re_ht.get("newPlanIrr")));
				faict.setAdjustDate(re_ht.get("adjustDate"));
				//增加调息状态
				faict.setModReason("his_rate_change");
				faict.setStatus("rate_change_in");
				this.tableService.saveEntity(faict);
			}
		}
		if(re_ht.get("message")==null||re_ht.get("message").isEmpty()){
			re_ht.put("message","调息处理成功!");
		}
		return re_ht.get("message");
	}

	@Override
	public String removeConditionByTransferInterest(String adjustId,
			String docId, String contractId)throws Exception  {
		ContractInfo contractInfo = this.tableService.findEntityByID(ContractInfo.class, contractId);
		contractApprovalStartAction.removeConditionDataFromTemp(contractInfo.getContractId(), docId, tableService);
		Map<String, Object> propertiesMap=new HashMap<String, Object>();
		propertiesMap.put("contractId", contractInfo);
		propertiesMap.put("docId", docId);
		List<FundAdjustInterestContractTemp> faict=this.tableService.findEntityByProperties(FundAdjustInterestContractTemp.class, propertiesMap);
		if(!faict.isEmpty()){
			this.tableService.removeAllEntites(faict);
		}
		return "撤销调息成功!";
	}

}
