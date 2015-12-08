package com.business.action.leasing.distributor.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankProcess;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.MFundFundCharge;
import com.business.service.BaseService;
import com.ctc.wstx.util.DataUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;


@WorkflowAction(name = "disGuaranteefirstAction", description = "第一步结束动作", workflowName = "经销商保证金收款流程")
@Component(value = "disGuaranteefirstAction")
public class DisGuaranteefirstAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		    
		    String flowunid=String.valueOf(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid());
		    String custid=variablesMap.get("cust_info.id");
		    CustInfo ci=(CustInfo)this.baseService.findEntityByID(CustInfo.class, custid);
		   	 // 实收
		    Map<String,String>classFieldMapping=new HashMap<String,String>();
		    classFieldMapping.put("DictionaryData", "code");
		    classFieldMapping.put("FundEbankData", "ebdataId");
		    //删除过程中数据
		    String HQL="from FundEbankProcess fe where fe.flowUnid=?";
		    List<FundEbankProcess> fps=new ArrayList<FundEbankProcess>();
		    fps=this.baseService.findResultsByHSQL(HQL, flowunid);
		    //this.baseService.removeAllEntites(fps);
			String jsonFundString = variablesMap.get("json_receivercharge_str");//proj_info.projEquips
			ObjectMapper jsonMapper = new ObjectMapper(); 
			JSONArray jsonArray = new JSONArray(jsonFundString);
			JSONArray newjsonArray = new JSONArray();
			List<String> jsonFundList=new ArrayList<String>();
			for(int i=0;i<jsonArray.length();i++){
				  JSONObject jsonObj = jsonArray.getJSONObject(i);
				  jsonObj.remove("id");    
				  Map[] newSetMaps = jsonMapper.readValue("["+jsonObj.toString()+"]", Map[].class);
				  MFundFundCharge mc=new MFundFundCharge();
				  this.baseService.copyAndOverrideExistedValueFromStringMap(newSetMaps[0], mc, classFieldMapping);
				  mc.setDealerId(ci);
				  if(mc.getSettleMethod().getCode().equalsIgnoreCase("PayFund9")){
					  //红冲则不插process表
				  }else{
					 // 插process表
				        FundEbankProcess fp=new FundEbankProcess();
				        fp.setEbdataId(mc.getEbankNumber());//网银编号
				        fp.setDealerID(mc.getDealerId().getId());//经销商编号
				        fp.setFlowUnid(flowunid);
				        fp.setProcessName(jbpmWorkflowHistoryInfo.getProcessDefinitionId());
				        fp.setProcessAmount(mc.getFactMoney());
				        fp.setStartDate(DateUtil.getSystemDate());
				        fp.setWork_flag("0");
				        this.baseService.saveOrUpdateEntity(fp);
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
