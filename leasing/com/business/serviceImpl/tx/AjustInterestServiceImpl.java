package com.business.serviceImpl.tx;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.cash.ContractCashDetailHis;
import com.business.entity.contract.reckon.cash.ContractCashDetailTemp;
import com.business.entity.contract.reckon.condition.ContractConditionHis;
import com.business.entity.contract.reckon.condition.ContractConditionTemp;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanHis;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanTemp;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContract;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContractHis;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContractTemp;
import com.business.entity.cust.CustInfo;
import com.business.entity.interest.FundStandardInterest;
import com.business.service.TableService;
import com.business.service.reckon.ConditionDataToHisService;
import com.business.service.tx.AjustInterestService;
/**
 * @author Chennes
 * 2013-10-22下午11:48:23
 */
@Service(value = "ajustInterestService")
public class AjustInterestServiceImpl implements AjustInterestService {
	
	@Resource(name="tableService")
	private TableService tableService;

	/**
	 * 交易结构his表（调息前）-->交易结构temp表
	 */
	@Override
	public void updateCopyConditionFromHisToTemp(Map<String, String> model) throws Exception{
		//商务条件历史表
		
		String already_json_val 				= model.get("already_json_val");
		JSONArray jsonArray     				= new JSONArray(already_json_val);
		String his1ContractId  					= "";
		String his1DocId                        = "";
		String his1ModStatus                    = "";
		ContractConditionTemp contractcondition = null;
		List<ContractConditionHis> his1 		= null;
		String contractid                       = "";
		String oldDocid                         = "";
		String newDocid                         = "";
		JSONObject jsonObj = null;
		for(int i=0;i<jsonArray.length();i++){
			jsonObj 		  = jsonArray.getJSONObject(i);
			contractid 		  = jsonObj.get("id").toString();
			oldDocid 		  = jsonObj.get("docid").toString();
			his1ContractId 	  = contractid;
			his1DocId 		  = oldDocid;
			his1ModStatus 	  = "his_status_before";
			contractcondition = new ContractConditionTemp();
			his1 = this.tableService.findResultsByHSQL(" from ContractConditionHis cch where cch.contractId.id=? and cch.docId=? and cch.modStatus.code=?", his1ContractId,his1DocId,his1ModStatus);
			
			contractid 		  = getContractID(contractid);
			this.tableService.updateByHSQL("delete from ContractConditionTemp where contractId = ? and docId = ?", contractid,oldDocid);
			if(!his1.isEmpty()){
				this.tableService.copyAndOverrideExistedValueFromObject(his1.get(0), contractcondition);
				newDocid = model.get("docid");
				contractcondition.setDocId(newDocid);
				contractcondition.setContractId(contractid);
				this.tableService.saveEntity(contractcondition);
			}
		}
		emptyTheVariable(newDocid,oldDocid,already_json_val,jsonArray,his1ContractId,his1DocId,his1ModStatus,contractcondition,his1,contractid,jsonObj);
	}

	/**
	 * 央行调息记录表（调息前）-->到央行调息临时表FUND_ADJUST_INTEREST_CONTRACT to FUND_ADJUST_INTEREST_C_TEMP
	 */
	@Override
	public void updateCopyFundAdjustInterestContractFromHisToTemp(
			Map<String, String> model) throws Exception {
		String requestAdjustId                = model.get("adjustId");
		String already_json_val               = model.get("already_json_val");
		JSONArray jsonArray                   = new JSONArray(already_json_val);
		List<FundAdjustInterestContract> faic = null;
		FundAdjustInterestContractTemp faict  = null;
		FundAdjustInterestContract fundAdjust = null;
		BigDecimal bigd                       = null;
		JSONObject jsonObj                    = null;
		String contractid                     = "";
		String oldDocid                          = "";
		String newDocid                          = "";
		String adjustid                       = "";
		//1.----Start插入数据到 调息临时表
		String hsql = " FROM FundAdjustInterestContract faic WHERE faic.contractId.id =? AND faic.adjustId.id=?";
		for(int i=0;i<jsonArray.length();i++){
			bigd        = new BigDecimal(0);
			jsonObj     = jsonArray.getJSONObject(i);
			contractid  = jsonObj.get("id").toString();
			oldDocid    = jsonObj.get("docid").toString();
			adjustid    = requestAdjustId;
			faic        = this.tableService.findResultsByHSQL(hsql,contractid,adjustid);
			faict       = new FundAdjustInterestContractTemp();
			this.tableService.copyAndOverrideExistedValueFromObject(faic.get(0),faict);
			/*
			 * 将正式表的数据复制到 临时表 然后将  调息后 数据变成调息钱前的数据  调息前的数据 变成调息后的数据
			 * {header:'调息前利率',name:'rateoriginal'},
			 * {header:'调息后利率',name:'rateadjust'},
			 * {header:'调息前内部收益率',name:'oldirr'},
			 * {header:'调息后内部收益率',name:'newirr'},
			 */
			fundAdjust  = faic.get(0);
			newDocid = model.get("docid");
			faict.setDocId       (newDocid);
			faict.setRateOriginal(fundAdjust.getRateAdjust()  ==null?bigd:fundAdjust.getRateAdjust());
			faict.setRateAdjust  (fundAdjust.getRateOriginal()==null?bigd:fundAdjust.getRateOriginal());
			faict.setOldIrr      (fundAdjust.getNewIrr()      ==null?bigd:fundAdjust.getNewIrr());
			faict.setNewIrr      (fundAdjust.getOldIrr()      ==null?bigd:fundAdjust.getOldIrr());
			faict.setNewPlanIrr  (fundAdjust.getOldPlanIrr()  ==null?bigd:fundAdjust.getOldPlanIrr());
			faict.setOldPlanIrr  (fundAdjust.getNewPlanIrr()  ==null?bigd:fundAdjust.getNewPlanIrr());
			this.tableService.updateByHSQL("delete from FundAdjustInterestContractTemp where contractId.id = ? and docId = ?", contractid,oldDocid);
			this.tableService.saveEntity(faict);
		}
		emptyTheVariable(requestAdjustId,newDocid,oldDocid,already_json_val,jsonArray,faic,faict,fundAdjust,bigd,jsonObj,contractid,adjustid,hsql);

	}

	@Override
	public void updateCopyConditionFromTempToHis(Map<String, String> model)
			throws Exception {
		
		
	}

	/**
	 * 调息开始
	 * 将央行调息记录临时表 copy到 央行调息记录表
	 */
	@Override
	public void updateCopyFundAdjustInterestContractTempToRecord(
			Map<String, String> model) throws Exception {
		String docid    = model.get("docid");
		String adjustid = model.get("adjustid");
		Map<String, Object> propertiesMap=new HashMap<String, Object>();
System.out.println("调息开始将央行调息记录临时表 copy到 央行调息记录表adjustid="+adjustid);		
		FundStandardInterest fsi=this.tableService.findEntityByID(FundStandardInterest.class, adjustid);
		propertiesMap.put("adjustId", fsi);
		propertiesMap.put("docId", docid);
		List<FundAdjustInterestContractTemp> faictList = this.tableService.findEntityByProperties(FundAdjustInterestContractTemp.class, propertiesMap);
		FundAdjustInterestContract faic = null;
		for (FundAdjustInterestContractTemp temp : faictList) {
			faic = new FundAdjustInterestContract();
			BeanUtils.copyProperties(temp,faic);
			faic.setContractId(temp.getContractId());
			faic.setAdjustId(fsi);
			faic.setStatus("rate_change_over");
			this.tableService.saveEntity(faic);
		}
		emptyTheVariable(docid,adjustid,propertiesMap,fsi,faictList,faic,model);
	}

	/**
	 *# 回滚
	 * 1.把调息记录临时表FUND_ADJUST_INTEREST_C_TEMP 的数据写入 FUND_ADJUST_INTEREST_CONTRACT,并写入最新的数据 状态为 回滚
     *        把 FUND_ADJUST_INTEREST_CONTRACT 之前对应的调息的记录 改为  调息回滚
	 */
	@Override
	public void updateFundAdjustInterestContract(Map<String, String> model)
			throws Exception {
		String datas      = model.get("json_pranayama_to_roll_back_the_record_str");
		System.out.println("#######:"+datas);
		JSONArray jsonArray 	= new JSONArray(datas);
		JSONObject jsonObj		= null;
		List<FundAdjustInterestContractTemp> fundadjustinterestcontracttemp = null;
		FundAdjustInterestContractTemp temp = null;
		List<FundAdjustInterestContract> faicList = null;
		FundAdjustInterestContract fundAdjustInterestContract = null;
		String adjustid = "";
		String status = "";
		String contractID = "";
		String docID = "";
		for(int i=0;i<jsonArray.length();i++){
			jsonObj = jsonArray.getJSONObject(i);
			//得到合同号
			contractID = jsonObj.get("adjust_contractid").toString();
			//得到流水号
			docID      = jsonObj.get("docid").toString();
			fundadjustinterestcontracttemp = this.tableService.findResultsByHSQL(" FROM FundAdjustInterestContractTemp faict WHERE faict.contractId.id =? AND faict.docId=?", contractID,docID);
			temp = fundadjustinterestcontracttemp.get(0);
			fundAdjustInterestContract = new FundAdjustInterestContract();
			this.tableService.copyAndOverrideExistedValueFromObject(temp, fundAdjustInterestContract);
			fundAdjustInterestContract.setStatus("rate_change_rollback");
			this.tableService.saveEntity(fundAdjustInterestContract);
			adjustid = temp.getAdjustId().getId();
			status = temp.getStatus();
			//adjustid 状态为调息后
			faicList = this.tableService.findResultsByHSQL(" from FundAdjustInterestContract faic where faic.adjustId.id=? and faic.status=?", adjustid,status);
			fundAdjustInterestContract = faicList.get(0);
			fundAdjustInterestContract.setStatus("rate_change_rolled_finished");
			this.tableService.updateEntity(fundAdjustInterestContract);
				
		}
		
		emptyTheVariable(datas,fundadjustinterestcontracttemp,fundAdjustInterestContract,model);
	}

	@Override
	public void updateCopyTxAllTempToHis(Map<String,String> variablesMap,ConditionDataToHisService conditionDataToHisService) throws Exception {
		//获取被选中的调息条目所有合同号集合
		String datas = "";
		//得到是调息或者回滚字段
		String table_for_his_type = variablesMap.get("table_for_his_type");
		if("his_rate_change_back".equals(table_for_his_type)){
			datas = variablesMap.get("json_pranayama_to_roll_back_the_record_str");
		}
		if("his_rate_change".equals(table_for_his_type)){
			datas = variablesMap.get("json_current_regulating_of_breathing_str");
		}
		
		//##############################################
		//DATA的docid和contract_id不匹配
		
		
		JSONArray jsonArray 	= new JSONArray(datas);
		JSONObject jsonObj		= null;
		String framework_condition     = "framework_condition";
		String json_fund_rent_plan_str = "json_fund_rent_plan_str";
		String json_fund_cash_flow_str = "json_fund_cash_flow_str";
		Map<String, String> queryMainObjectMap = new HashMap<String, String>();
		String whereContractid         = "";
		String whereDocid              = "";
		ContractInfo contractInfo      = null;
		
		
		String contractID = "";
		//得到流水号
		String docID = variablesMap.get("docid");
		for(int i=0;i<jsonArray.length();i++){
				jsonObj = jsonArray.getJSONObject(i);
				//得到合同号
				contractID = jsonObj.get("adjust_contractid").toString();
				contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, contractID);
				whereContractid = contractInfo.getContractId();
				whereDocid      = docID;
				queryMainObjectMap.put("contract_id", whereContractid);
				queryMainObjectMap.put("doc_id", whereDocid);
				//商务条件临时表
				List<ContractConditionTemp> contractconditiontemp = this.tableService.findResultsByHSQL(" from ContractConditionTemp cct where cct.contractId=? and cct.docId=?", whereContractid,whereDocid);
				System.out.println("contractconditiontemp==null?"+contractconditiontemp.isEmpty());
				System.out.println("contract_id="+queryMainObjectMap.get("contract_id"));
				System.out.println("doc_id="+queryMainObjectMap.get("doc_id"));
				
				if(!contractconditiontemp.isEmpty()){
					variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractconditiontemp.get(0), null, framework_condition));
				}	
					CustInfo customerInfo = contractInfo.getCustId();
					// 设置租金测算参数为合同审批
					variablesMap.put("framework_condition.contractid", contractInfo.getContractId());
					variablesMap.put("framework_condition.process", "cont_process");
					variablesMap.put("framework_condition.custname", customerInfo.getCustName());
					variablesMap.put("framework_condition.custid", customerInfo.getCustNumber());
					variablesMap.put("framework_condition.docid", docID);
					variablesMap.put("framework_condition.onhireid", "");
					variablesMap.put("framework_condition.projid", "");
					//得到租金计划临时表数据
					
					variablesMap.put(json_fund_rent_plan_str, this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_fund_rent_plan_temp_of_tx.xml", queryMainObjectMap).toString());
					System.out.println("######################");
					System.out.println(variablesMap.get("json_fund_rent_plan_str"));
					
					
					//得到现金流临时表数据
					variablesMap.put(json_fund_cash_flow_str, this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_fund_cash_flow_temp.xml", queryMainObjectMap).toString());
					variablesMap.remove("framework_condition.id");
					System.out.println("json_fund_rent_plan_str="+variablesMap.get(json_fund_rent_plan_str));
					System.out.println("json_fund_cash_flow_str="+variablesMap.get(json_fund_cash_flow_str));
					
					conditionDataToHisService.saveContractConditionDataToHis(contractID, docID, table_for_his_type, variablesMap, framework_condition,
					json_fund_rent_plan_str, "", json_fund_cash_flow_str, "");
			
			}
		
		emptyTheVariable(framework_condition,json_fund_rent_plan_str,json_fund_cash_flow_str,queryMainObjectMap,whereContractid,whereDocid,contractInfo);
		
	}


	@Override
	public void updateCopyFundRentCashFromTempToHis(Map<String, String> model)
			throws Exception {
		
	}

	@Override
	public void updateCopyFundRentPlanFromTempToHis(Map<String, String> model)
			throws Exception {
		
	}

	/**
	 * 现金流his表（调息前）-->现金流temp表
	 */
	@Override
	public void updateCopyFundRentCashFromHisToTemp(Map<String, String> model) throws Exception {
		
		String already_json_val = model.get("already_json_val");
		JSONArray jsonArray 	= new JSONArray(already_json_val);
		String his3ContractId 	= ""; 
		String his3docId 		= ""; 
		String his3modStatus 	= ""; 
		JSONObject jsonObj		= null;
		String contractid		= "";
		String oldDocid            = "";
		String newDocid            = "";
		List<ContractFundRentPlanHis> his3 = null;
		ContractCashDetailTemp contractcashdetailtemp = null;
		for(int i=0;i<jsonArray.length();i++){
			jsonObj            = jsonArray.getJSONObject(i);
			contractid         = jsonObj.get("id").toString();
			oldDocid		   = jsonObj.get("docid").toString();
			his3ContractId 	   = contractid;
			his3docId          = oldDocid;
			his3modStatus      = "his_status_before";
			//现金流
			his3 = this.tableService.findResultsByHSQL(" from ContractCashDetailHis ccdh where ccdh.contractId.id=? and ccdh.docId=? and ccdh.modStatus.code=?", his3ContractId,his3docId,his3modStatus);
			contractcashdetailtemp = new ContractCashDetailTemp();
			contractid = getContractID(contractid);
			this.tableService.updateByHSQL("delete from ContractCashDetailTemp where contractId = ? and docId = ?", contractid,oldDocid);
			if(!his3.isEmpty()){
				this.tableService.copyAndOverrideExistedValueFromObject(his3.get(0),contractcashdetailtemp);
				newDocid = model.get("docid");
				contractcashdetailtemp.setDocId(newDocid);
				contractcashdetailtemp.setContractId(contractid);
				this.tableService.saveEntity(contractcashdetailtemp);
			}
		}
		emptyTheVariable(oldDocid,newDocid,already_json_val,jsonArray,his3ContractId,his3docId,his3modStatus,his3modStatus,jsonObj,contractid,his3,contractcashdetailtemp);

	}

	/**
	 * 租金计划his表（调息前）-->租金计划temp表 
	 */
	@Override
	public void updateCopyFundRentPlanFromHisToTemp(Map<String, String> model) throws Exception {
		
		String already_json_val = model.get("already_json_val");
		JSONArray jsonArray 	= new JSONArray(already_json_val);
		String his2ContractId 	= ""; 
		String his2docId 		= ""; 
		String his2modStatus 	= ""; 
		JSONObject jsonObj		= null;
		String contractid		= "";
		String oldDocid         = "";
		String newDocid         = "";
		List<ContractFundRentPlanHis> his2 = null;
		ContractFundRentPlanTemp contractfundrentplan = null;
		for(int i=0;i<jsonArray.length();i++){
			jsonObj        		 = jsonArray.getJSONObject(i);
			contractid     		 = jsonObj.get("id").toString();
			//老的docid
			oldDocid			 = jsonObj.get("docid").toString();
			his2ContractId 		 = contractid;
			his2docId        	 = oldDocid;
			his2modStatus        = "his_status_before";
			his2                 = this.tableService.findResultsByHSQL(" from ContractFundRentPlanHis cfrp where cfrp.contractId.id=? and cfrp.docId=? and cfrp.modStatus.code=?", his2ContractId,his2docId,his2modStatus);
			contractfundrentplan = new ContractFundRentPlanTemp();
			contractid           = getContractID(contractid);
System.out.println("租金计划his表（调息前）-->租金计划temp表 contractid="+contractid+"oldDocid="+oldDocid);
			this.tableService.updateByHSQL("DELETE from ContractFundRentPlanTemp where contractId = ? and docId = ?", contractid,oldDocid);
			if(!his2.isEmpty()){
				this.tableService.copyAndOverrideExistedValueFromObject(his2.get(0),contractfundrentplan);
				//新的docid
				newDocid = model.get("docid");
				contractfundrentplan.setDocId(newDocid);
				contractfundrentplan.setContractId(contractid);
				this.tableService.saveEntity(contractfundrentplan);
			}
		}
		emptyTheVariable(newDocid,oldDocid,already_json_val,jsonArray,jsonObj,contractid,his2ContractId,his2docId,his2modStatus,his2,contractfundrentplan);
	}

	@Override
	public void removeConditionFromHisToTemp(Map<String, String> model) throws Exception{
		String docid            = "";
		String already_json_val = model.get("already_json_val");
		JSONArray jsonArray = new JSONArray(already_json_val);
		JSONObject jsonObj = null;
		String contractid = null;
		for(int i=0;i<jsonArray.length();i++){
			jsonObj = jsonArray.getJSONObject(i);
			contractid  = jsonObj.get("id").toString();
			docid       = jsonObj.get("docid").toString();
System.out.println("交易结构临时表删除：contractid="+contractid+"docid="+docid);
			contractid = getContractID(contractid);
			this.tableService.updateByHSQL("DELETE from ContractConditionTemp where contractId = ? and docId = ?", contractid,docid);
		}
		emptyTheVariable(docid,already_json_val,jsonArray,jsonObj,contractid);
	}

	@Override
	public void removeFundAdjustInterestCTemp(Map<String, String> model)throws Exception {
		
		String docid            = "";
		String already_json_val = model.get("already_json_val");
		JSONArray jsonArray = new JSONArray(already_json_val);
		JSONObject jsonObj = null;
		String contractid = null;
		for(int i=0;i<jsonArray.length();i++){
			jsonObj = jsonArray.getJSONObject(i);
			contractid = jsonObj.get("id").toString();
			docid   = jsonObj.get("docid").toString();
System.out.println("央行记录临时表删除转化前：contractid="+contractid+"oldDocid="+docid);
			this.tableService.updateByHSQL("DELETE from FundAdjustInterestContractTemp where contractId.id = ? and docId = ?", contractid,docid);
		}
		emptyTheVariable(docid,already_json_val,jsonArray,jsonObj,contractid,model);
	}

	/**
	 * 根据合同id得到合同编号
	 * @param contractid
	 * @return
	 * @throws Exception
	 */
	private String getContractID(String contractid) throws Exception {
		ContractInfo contractinfo = this.tableService.findEntityByID(ContractInfo.class, contractid);
		contractid = contractinfo.getContractId();
		return contractid;
	}

	@Override
	public void removeFundRentCashFromHisToTemp(Map<String, String> model) throws Exception{
		String docid            = "";
		String already_json_val = model.get("already_json_val");
		JSONArray jsonArray = new JSONArray(already_json_val);
		JSONObject jsonObj = null;
		String contractid = null;
		for(int i=0;i<jsonArray.length();i++){
			jsonObj = jsonArray.getJSONObject(i);
			contractid = jsonObj.get("id").toString();
			docid      = jsonObj.get("docid").toString();
			contractid = getContractID(contractid);
			this.tableService.updateByHSQL("DELETE from ContractCashDetailTemp where contractId = ? and docId = ?", contractid,docid);
		}
		emptyTheVariable(docid,already_json_val,jsonArray,jsonObj,contractid);
	}

	/**
	 * 清空对象
	 * @param obj
	 */
	private void emptyTheVariable(Object ... obj) {if(obj!=null){for(Object o : obj){if(o != null){o = null;}}}}

	@Override
	public void removeFundRentPlanFromHisToTemp(Map<String, String> model) throws Exception {
		String docid            = "";
		String already_json_val = model.get("already_json_val");
		JSONArray jsonArray = new JSONArray(already_json_val);
		JSONObject jsonObj = null;
		String contractid = null;
		for(int i=0;i<jsonArray.length();i++){
			jsonObj = jsonArray.getJSONObject(i);
			contractid = jsonObj.get("id").toString();
			docid      = jsonObj.get("docid").toString();
System.out.println("央行记录临时表删除转化前：contractid="+contractid+"docid="+docid);
			contractid = getContractID(contractid);
			this.tableService.updateByHSQL("DELETE from ContractFundRentPlanTemp where contractId = ? and docId = ?", contractid,docid);
		}
		emptyTheVariable(docid,already_json_val,jsonArray,jsonObj,contractid);

	}

	@Override
	public void updateCondition(Map<String, String> model) {

	}

	@Override
	public void updateFundRentCash(Map<String, String> model) {

	}

	@Override
	public void updateFundRentPlan(Map<String, String> model) {

	}

	@Override
	public void updateStatusTo(Map<String, String> model) {

	}

}
