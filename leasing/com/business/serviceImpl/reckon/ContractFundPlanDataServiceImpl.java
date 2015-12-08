package com.business.serviceImpl.reckon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.business.entity.DictionaryData;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.fund.ContractFundFundPlanHis;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.reckon.ContractFundPlanDataService;
import com.google.common.collect.Maps;
import com.kernal.utils.UUIDUtil;

@Service(value = "ContractFundPlanDataService")
public class ContractFundPlanDataServiceImpl implements ContractFundPlanDataService{
	@Resource(name = "baseService")
	private BaseService baseService;
	Logger logger=Logger.getLogger(ContractFundPlanDataServiceImpl.class);
	@Override
	public void saveContractConditionData(String contractId, String docId,
			String hisType, Map<String, String> datas, String fundFundPlanKeyOne,
			String fundFundPlanKeyTwo) throws Exception {
		ContractInfo contractInfo = (ContractInfo)this.baseService.findEntityByID(ContractInfo.class, contractId);
		//先设定入历史表的类型
		Map<String, Object> whereMap=new HashMap<String, Object>();
		DictionaryData hisBefore=new DictionaryData();
		DictionaryData hisAfter=new DictionaryData();
		DictionaryData hisTypeDict=new DictionaryData();
		whereMap.put("code", "his_status_before");
		hisBefore=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		whereMap.put("code", "his_status_after");
		hisAfter=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		whereMap.put("code", hisType);
		hisTypeDict=(DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		//合同资金计划保存历史表(前)
		Set<ContractFundFundPlan> contractFundFundPlans = contractInfo.getFundFundChargePlans();
		List<ContractFundFundPlanHis> fundFundPlanHiss=new ArrayList<ContractFundFundPlanHis>();
		for (ContractFundFundPlan contractFundFundPlan : contractFundFundPlans) {
			ContractFundFundPlanHis fundFundPlanHis=new ContractFundFundPlanHis();
			BeanUtils.copyProperties(contractFundFundPlan, fundFundPlanHis);
			fundFundPlanHis.setModStatus(hisBefore);
			fundFundPlanHis.setModReason(hisTypeDict);
			fundFundPlanHis.setId(null);
			fundFundPlanHis.setDocId(docId);
			fundFundPlanHiss.add(fundFundPlanHis);
		}
		this.baseService.saveAllEntities(fundFundPlanHiss);
		
		//合同资金计划
		String json_fund_fund_plan_str = "";
		JSONArray jsonArray = null;
		if(fundFundPlanKeyOne != null && !"".equals(fundFundPlanKeyOne)){
			json_fund_fund_plan_str = datas.get(fundFundPlanKeyOne);
			jsonArray = new JSONArray(json_fund_fund_plan_str);
		}
		if(fundFundPlanKeyTwo != null && !"".equals(fundFundPlanKeyTwo)){
			json_fund_fund_plan_str = datas.get(fundFundPlanKeyTwo);
			JSONArray jsonArrayTwo = new JSONArray(json_fund_fund_plan_str);
			for(int i=0;i<jsonArrayTwo.length();i++){
				JSONObject jsonObj = jsonArrayTwo.getJSONObject(i);
				jsonArray.put(jsonObj);
			}
		}
		List<String> jsonFundPlanListOld = new ArrayList<String>();
		List<String> jsonFundPlanListNew = new ArrayList<String>();
		String newString = "";
		String oldString = "";
		String hql = "";
		for (int i = 0; i < jsonArray.length(); i++) {
			hql = "from ContractFundFundPlan as cf where cf.contractId.id=? and cf.invalid=?";
			List<ContractFundFundPlan> fundFundPlanList = this.baseService.findResultsByHSQL(hql,contractInfo.getId(),"0");
			if(fundFundPlanList != null && fundFundPlanList.size() > 0){
				for (ContractFundFundPlan contractFundFundPlan : fundFundPlanList) {
					jsonFundPlanListOld.add(contractFundFundPlan.getPaymentId());
					oldString += contractFundFundPlan.getPaymentId();
				}
			}
			break;
		}
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject =  (JSONObject) jsonArray.get(i);
			String payment_id = jsonObject.getString("paymentid");
			jsonFundPlanListNew.add(payment_id);
			newString += payment_id;
		}
		ContractFundFundPlan oldFundFundPlanId = null;
		hql = "from ContractFundFundPlan as cf where cf.paymentId=? and cf.invalid=?";
		for (int i = 0; i < jsonFundPlanListNew.size(); i++) {
			JSONObject jsonObject =  (JSONObject) jsonArray.get(i);
			if(oldString.contains(jsonFundPlanListNew.get(i))){
				System.out.println(jsonFundPlanListNew.get(i));
				List<ContractFundFundPlan> list = this.baseService.findResultsByHSQL(hql, jsonFundPlanListNew.get(i),"0");
				oldFundFundPlanId = list.get(0);
				jsonObject.put("id", oldFundFundPlanId.getId());
				List<String> jsonFundList=new ArrayList<String>();
				jsonFundList.add(jsonObject.toString());
				this.baseService.updateOneToManyCollectionsNoRemoved(contractInfo, "fundFundChargePlans", ContractFundFundPlan.class, "contractId", jsonFundList.toString(),null);
				//System.out.println("更新已有的资金计划");
			}else{
				jsonObject.put("id", UUIDUtil.getUUID());
				List<String> jsonFundList=new ArrayList<String>();
				jsonFundList.add(jsonObject.toString());
				//System.out.println(jsonFundList);
				this.baseService.updateOneToManyCollectionsNoRemoved(contractInfo, "fundFundChargePlans", ContractFundFundPlan.class, "contractId", jsonFundList.toString(),null);
				//System.out.println("新增的资金计划");
			}
		}
		if(jsonFundPlanListNew.size() < jsonFundPlanListOld.size()){
			for (int i = 0; i < jsonFundPlanListOld.size(); i++) {
				if(newString.contains(jsonFundPlanListOld.get(i))){
					//System.out.println("已存在的资金计划");
				}else{
					/*
					try {
						if(jsonFundPlanListOld.get(i) !=null)
						{
							List<ContractFundFundPlan> listc=this.baseService.findResultsByHSQL(hql, jsonFundPlanListOld.get(i),"0");
							if (listc.size() > 0)
							{
								oldFundFundPlanId = listc.get(0);
								this.baseService.removeEntity(oldFundFundPlanId);
							}
						}
					} catch (Exception e) {
						throw new BusinessException(e.getMessage());
					}
					*/
					//System.out.println("删除旧的资金计划");
				}
			}	
		}
		//合同资金计划保存历史表(后)
		//contractInfo = (ContractInfo)this.baseService.findEntityByID(ContractInfo.class, contractId);//再查一次更新数据
		//contractFundFundPlans = contractInfo.getFundFundChargePlans();
		hql = "from ContractFundFundPlan as cf where cf.contractId.id=? and cf.invalid=?";
		List<ContractFundFundPlan> FundFundPlans = this.baseService.findResultsByHSQL(hql, contractInfo.getId(),"0");
		fundFundPlanHiss=new ArrayList<ContractFundFundPlanHis>();
		for (ContractFundFundPlan contractFundFundPlan : FundFundPlans) {
			ContractFundFundPlanHis fundFundPlanHis=new ContractFundFundPlanHis();
			BeanUtils.copyProperties(contractFundFundPlan, fundFundPlanHis);
			fundFundPlanHis.setModStatus(hisAfter);
			fundFundPlanHis.setModReason(hisTypeDict);
			fundFundPlanHis.setId(null);
			fundFundPlanHis.setDocId(docId);
			fundFundPlanHiss.add(fundFundPlanHis);
		}
		this.baseService.saveAllEntities(fundFundPlanHiss);
	}

}
