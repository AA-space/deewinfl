package com.business.action.leasing.distributor.limitManager;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerCreditInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.google.inject.internal.Maps;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;

/**
 * 
 * @author 邱明
 * @date 2013-6-24上午17:55:13
 * @info 经销商合同管理
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorLimitManagerStartAction", description = "流程开始动作", workflowName = "经销商额度管理")
@Component(value = "distributorLimitManagerStartAction")
public class DistributorLimitManagerStartAction implements JbpmBaseAction {
	Logger logger=Logger.getLogger(DistributorLimitManagerStartAction.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String cust_id = variablesMap.get("cust_id");
		
		CustInfo custInfo=(CustInfo)this.baseService.findEntityByID(CustInfo.class, cust_id);
		variablesMap.put("cust_info.custname",custInfo.getCustName());
		variablesMap.put("cust_info.custnumber",custInfo.getCustNumber());
		variablesMap.put("cust_info.id", custInfo.getId());
		Map<String,String>classFieldMapping=new HashMap<String,String>();
		classFieldMapping.put("DictionaryData", "code");
		Map<String,Object> propertiesMap=new HashMap<String,Object>();
		propertiesMap.put("custId", custInfo);
		propertiesMap.put("isNow", "0");
		DealerCreditInfo ci;
	    List lcredit=this.baseService.findEntityByProperties(DealerCreditInfo.class, propertiesMap);
	    if (lcredit.size()>0){
	    	ci=(DealerCreditInfo)lcredit.get(0);
	    	variablesMap.putAll(this.baseService.getEntityPropertiesToStringMap(ci, classFieldMapping,"dealer_credit_info"));
	    }
	    
	  //经销商额度
//	  BigDecimal creditmoney=new BigDecimal(variablesMap.get("dealer_credit_info.creditmoney"));
//	  Map<String, String> income = Maps.newHashMap(); 
//	  income.put("cust_id",cust_id);
//	  String firstpayment = this.tableService.getJsonArrayData("eleasing/jsp/dealer_manage/dealer_credit_money_new.xml", income).toString();
//	  JSONArray jsonArray = new JSONArray(firstpayment);
//	  if(jsonArray.length()>0){
//		  JSONObject jsonObj = jsonArray.getJSONObject(0);
//		  variablesMap.put("dealer_credit_info.credituse", jsonObj.get("userrent").toString());
//		  variablesMap.put("dealer_credit_info.creditlast",creditmoney.subtract(new BigDecimal(jsonObj.get("userrent").toString())).toString());
//	  }else{
//		  variablesMap.put("dealer_credit_info.credituse", "0");
//		  variablesMap.put("dealer_credit_info.creditlast",variablesMap.get("dealer_credit_info.creditmoney"));
//	  }
	    String sql ="select s,diyarent from credit_info where dealer= '"+cust_id+"'";
		List<Map<String, Object>> maplist = this.tableService.getBussinessDao().getJdbcTemplate().queryForList(sql);
		for ( Map<String, Object> m :maplist )
		{
			for ( String key :m.keySet() )
			{	 
				if ( "s".equalsIgnoreCase(key) )
					variablesMap.put("dealer_credit_info.creditlast", m.get(key).toString());
				if ( "diyarent".equalsIgnoreCase(key) )
				{
					if ( null == m.get(key) )
						variablesMap.put("dealer_credit_info.credituse", "0");
					else
						variablesMap.put("dealer_credit_info.credituse", m.get(key).toString());
				}
			}
		}
	    variablesMap.remove("dealer_credit_info.adjustcreditmoney");
	    variablesMap.remove("dealer_credit_info.adjustcreditstardate");
	    variablesMap.remove("dealer_credit_info.adjustcreditenddate");
	    variablesMap.remove("dealer_credit_info.adjustmode");
	    variablesMap.remove("dealer_credit_info.adjustreason");
	    variablesMap.remove("dealer_credit_info.adjustdate");
		variablesMap.put("current_date", DateUtil.getSystemDate());
	   System.out.println(variablesMap.toString());
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
