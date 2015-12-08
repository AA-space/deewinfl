package com.business.action.leasing.distributor.drawback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankData;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.MFundFundCharge;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "disDrawbackStartAction", description = "流程开始动作", workflowName = "经销商保证金退款流程")
@Component(value = "disDrawbackStartAction")
public class DisDrawbackStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	 private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
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
		//经销信息
		//加载资金计划
		//历史收款明细
		//网银信息
		
		String  cust_id=variablesMap.get("cust_id");
		CustInfo  cust;
		//经销商信息
		cust=(CustInfo)this.tableService.findEntityByID(CustInfo.class,cust_id);
		variablesMap.put("cust_info.custname", cust.getCustName());
		variablesMap.put("cust_info.id", cust.getId());
	   //查出历时收款明细	
	    Map<String,Object> propertiesMap=new HashMap<String,Object>();
		List<MFundFundCharge>list_mfund=new ArrayList<MFundFundCharge>();
		propertiesMap.put("dealerId", cust);
		//propertiesMap.put("PID", null);
		String HQL="from MFundFundCharge  mf where mf.dealerId.id='"+cust_id+"' and mf.PID is null";
		list_mfund=this.tableService.findResultsByHSQL(HQL);
		List<MFundFundCharge>temp_mfund=new ArrayList<MFundFundCharge>();
		for(MFundFundCharge mf:list_mfund){
			mf.initMFundFundCharge();
			//初始化保证金收款
			temp_mfund.add(mf);
		}
		Map<String,String>fieldClassMapping=new HashMap<String,String>();
		fieldClassMapping.put("CustInfo", "id");
		fieldClassMapping.put("FundEbankData", "ebdataId");
		fieldClassMapping.put("DictionaryData", "code");
		fieldClassMapping.put("MFundFundCharge", "id");
		if(temp_mfund.size()>0){
			variablesMap.put("json_receiverchargehistory_str", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(temp_mfund, fieldClassMapping));
		}
	    
	    
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
