package com.business.action.leasing.distributor.limitManager;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.BaseFile;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerCreditInfo;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
/**
 * 
 * @author 邱明
 * @date 2013-6-24上午17:55:13
 * @info 经销商合同管理
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "distributorLimitManagerEndAction", description = "流程结束动作", workflowName = "经销商额度管理")
@Component(value = "distributorLimitManagerEndAction")
public class DistributorLimitManagerEndAction implements JbpmBaseAction {
	@Resource(name="tableService")
	private TableService baseService;


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
		 String flowunid=String.valueOf(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid());
		String cust_id=variablesMap.get("cust_info.id");
		CustInfo custinfo=(CustInfo)this.baseService.findEntityByID(CustInfo.class, cust_id);
		Map<String,Object> propertiesMap=new HashMap<String,Object>();
		propertiesMap.put("custId", null);
		Map<String,String>classFieldMapping=new HashMap<String,String>();
		classFieldMapping.put("DictionaryData", "id");
		classFieldMapping.put("CustInfo", "id");
		classFieldMapping.put("Department", "id");
		variablesMap.put("DEALER_CREDIT_INFO.isnow", "0");
		//2.插入授信额度，把数据库中已有的授信设为历史
	    String HQL="update DealerCreditInfo di set di.isNow=1 where di.custId.id='"+cust_id+"'";
	    this.baseService.getBussinessDao().getHibernateTemplate().bulkUpdate(HQL);
	    DealerCreditInfo di=new DealerCreditInfo();
	    this.baseService.copyAndOverrideExistedValueFromStringMap(variablesMap, di, classFieldMapping, "DEALER_CREDIT_INFO");
	    di.setId(null);
	    BigDecimal CMoney=di.getCreditMoney();
	    String bdate=di.getCreateDate();
	    String edate=di.getCreditEndDate();
	    di.setCreditMoney(di.getAdjustCreditMoney());
	    di.setCreditStarDate(di.getAdjustCreditStarDate());
	    di.setCreditEndDate(di.getAdjustCreditEndDate());
	    di.setAdjustCreditMoney(CMoney);
	    di.setAdjustCreditStarDate(bdate);
	    di.setAdjustCreditEndDate(edate);
	    this.baseService.saveOrUpdateEntity(di);
	  //插入通知函
		String fileliststr=variablesMap.get("json_word_list_str");
        if(!fileliststr.equalsIgnoreCase("[]")){
        	  classFieldMapping.clear();
        	  classFieldMapping.put("FileTemplate", "id");
        	  ObjectMapper jsonMapper = new ObjectMapper(); 
     		  JSONArray jsonArray = new JSONArray(fileliststr);
     		  for(int i=0;i<jsonArray.length();i++){
  			     JSONObject jsonObj = jsonArray.getJSONObject(i);
  			     Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
  			     BaseFile bf=new BaseFile();
  			     this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], bf, classFieldMapping, true);
                 bf.setId(null);
  			     this.baseService.saveOrUpdateEntity(bf);
     		} 
        }
//保存资料清单
	    
	    Map<String, String> map=new HashMap<String, String>();
		String  docReportStr = variablesMap.get("json_dealer_doc_report_str");
		JSONObject savedDataJsonObj = new JSONObject(docReportStr);  
		Iterator<String> iter =  savedDataJsonObj.keys();
		while(iter.hasNext()){
			String key = iter.next();
			map.put(key,  savedDataJsonObj.getString(key).toString());
		}
		this.baseService.savedTree2TableData(map.get("savedDataKey").toString(),map.get("valuesMapping").toString(),map);
		
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
