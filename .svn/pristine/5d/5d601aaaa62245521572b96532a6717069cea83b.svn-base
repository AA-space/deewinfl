package com.business.action.leasing.distributor.mortgagerecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.ehcache.hibernate.management.impl.BeanUtils;

import org.apache.commons.beanutils.PropertyUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.District;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerGuaranteeInfo;
import com.business.entity.proj.ProjInfo;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
/**
 * 
 * @author 徐云龙
 * @date 2013-8-10上午17:55:13
 * @info 经销商抵押合同事宜办理流程
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorMortgageRecordEndAction", description = "流程结束动作", workflowName = "抵押备案信息")
@Component(value = "distributorMortgageRecordEndAction")
public class DistributorMortgageRecordEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;

	/*
	 * public ProjApprovalEndAction(){ this.baseService =
	 * (ProjApprrovalDao)WebUtil.getApplicationContext().getBean("baseService"); }
	 */
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		System.out.println("variablesMap:"+variablesMap);
		DealerGuaranteeInfo   dealerGuaranteeInfo=new DealerGuaranteeInfo();
		String vndr_id = variablesMap.get("dealerguaranteeinfo.dealername1");
		CustInfo custInfo=this.baseService.findEntityByID(CustInfo.class, vndr_id);
		dealerGuaranteeInfo.setCustId(custInfo);
		dealerGuaranteeInfo.setCommPerson(variablesMap.get("dealerguaranteeinfo.dealerperson"));
		dealerGuaranteeInfo.setAddr(variablesMap.get("dealerguaranteeinfo.dealeraddress"));
		dealerGuaranteeInfo.setPhone(variablesMap.get("dealerguaranteeinfo.dealerphone"));
		dealerGuaranteeInfo.setSingleNumber(variablesMap.get("dealerguaranteeinfo.singlenumber"));
		dealerGuaranteeInfo.setSingleTime(variablesMap.get("dealerguaranteeinfo.singletime"));
		String  mortgageitem= variablesMap.get("mortgageitem");   //项目保存
	    String [] item =mortgageitem.split(",");   
        for(int j=0;j<item.length;j++)
        {
        	if(item[j].indexOf("1")>-1)
        	{
        		dealerGuaranteeInfo.setIsGuaranty(item[j]);
        	}else if(item[j].indexOf("2")>-1)
        	{
        	    dealerGuaranteeInfo.setIsMortgage(item[j]);	
        	}else if(item[j].indexOf("3")>-1)
        	{
        	    dealerGuaranteeInfo.setNotGuaranty(item[j]);	
        	}else if(item[j].indexOf("4")>-1)
        	{
        	    dealerGuaranteeInfo.setIsFair(item[j]);	
        	}else if(item[j].indexOf("5")>-1)
        	{
        	    dealerGuaranteeInfo.setIsother(item[j]);	
        	}
        }
        if (variablesMap.get("province")!= null)
        {
			District disProvince=this.baseService.findEntityByID(District.class, variablesMap.get("province"));
			dealerGuaranteeInfo.setProvince(disProvince);
        }
		if (variablesMap.get("city")!= null)
		{
			District disCity=this.baseService.findEntityByID(District.class, variablesMap.get("city"));
			dealerGuaranteeInfo.setCity(disCity);
		}
		if (variablesMap.get("county")!= null)
		{
			District disCounty=this.baseService.findEntityByID(District.class, variablesMap.get("county"));
			dealerGuaranteeInfo.setCounty(disCounty);
		}
		String  mortgagenumber= variablesMap.get("mortgagenumber");
		dealerGuaranteeInfo.setUserPlan(variablesMap.get("userplan"));
		dealerGuaranteeInfo.setTermPlan(variablesMap.get("termplan"));
		dealerGuaranteeInfo.setHandleRS(variablesMap.get("handlers"));
		String  billOfMaterial=variablesMap.get("json_dealer_doc_report");
		System.out.println("billOfMaterial:"+billOfMaterial);
		if(!"[]".equals(billOfMaterial)){
			JSONArray jsonArray = new JSONArray(billOfMaterial);
				for(int i=0;i<jsonArray.length();i++){
					JSONObject jsonObj = jsonArray.getJSONObject(i); 
					String original=jsonObj.optString("original");
					String copy=jsonObj.optString("copy");
					String memo=jsonObj.optString("memo");
					if("-".equals(original)&&"-".equals(copy)&&"-".equals(memo))
					{
						continue;
					}
					DealerGuaranteeInfo dealerGuaranteeInfo1=new DealerGuaranteeInfo();
					PropertyUtils.copyProperties(dealerGuaranteeInfo1, dealerGuaranteeInfo);
					dealerGuaranteeInfo1.setMaterialName(jsonObj.optString("materialName"));
					dealerGuaranteeInfo1.setOriginal(original);
					dealerGuaranteeInfo1.setCopy(copy);
					dealerGuaranteeInfo1.setMemo(memo);
					this.baseService.saveEntity(dealerGuaranteeInfo1);
			  }
        }
		
	}
	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	
	 /**
	 * (non-Javadoc)
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
