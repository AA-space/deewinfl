package com.business.action.leasing.fundCollection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.Department;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankProcess;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.invoice.ContractInvoiceType;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerDeptInfo;
import com.business.service.TableService;
import com.google.inject.internal.Maps;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "dealerFundCollectionStartAction", description = "流程开始动作", workflowName = "经销商资金收款")
@Component(value = "dealerFundCollectionStartAction")
public class DealerFundCollectionStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;

	private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		if(variablesMap.get("fund_ebank_process") != null){
			this.tableService.removeEntityById(FundEbankProcess.class, variablesMap.get("fund_ebank_process"));
		}
		String  ebankID = variablesMap.get("ebank_id");
		FundEbankData ebankData = this.tableService.findEntityByID(FundEbankData.class,ebankID);
		ebankData.setInuseflag("0");
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//当前经销商
		String deptid=variablesMap.get("cur_depid");
		
		Department department = (Department) this.tableService.findEntityByID(Department.class, deptid);
		variablesMap.put("depname", department.getName());
		List dilist=new ArrayList();
		Map<String,Object>propertiesMap=new HashMap<String,Object>(); 
		propertiesMap.put("dealerDept", department);
		dilist=this.tableService.findEntityByProperties(DealerDeptInfo.class, propertiesMap);
		CustInfo ci=null;
		if(dilist.size()>0){
			DealerDeptInfo di=(DealerDeptInfo)dilist.get(0);
			 ci=di.getCustId();
			variablesMap.put("dealerid", ci.getId());
			variablesMap.put("dealername", ci.getCustName());
			System.out.println(ci.getId()+":"+ci.getCustName());
		}
		
		// 网银信息
		String ebankID = variablesMap.get("ebank_id");

		FundEbankData fundBank = (FundEbankData) this.tableService.findEntityByID(FundEbankData.class, ebankID);
		fundBank.initFundEbank();
		String dealer=variablesMap.get("custdealername");
		String str= dealer+">>编号:"+fundBank.getEbdataId()+"网银金额:"+String.valueOf(fundBank.getFactMoney());
		variablesMap.put("dealer",str);
		fundBank.initFundEbank();
		fundBank.setInuseflag("inuserflag");//加入在使用这笔网银的标识
		fundBank.setModifyDate(DateUtil.getSystemDateTime());
		fundBank.setModificator(SecurityUtil.getPrincipal());
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(fundBank, null, "fund_ebank_data"));
		
		System.out.println(variablesMap);
		
		//插入网银中间表
		FundEbankProcess fundEbankProcess = new FundEbankProcess();
		fundEbankProcess.setEbdataId(fundBank);
		fundEbankProcess.setFlowUnid(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		fundEbankProcess.setProcessName(jbpmWorkflowHistoryInfo.getWorkflowDisplayName());
		fundEbankProcess.setStartDate(DateUtil.getSystemDateTime());
		fundEbankProcess.setWork_flag("0");
		fundEbankProcess.setProcessAmount(BigDecimal.ZERO);
		this.tableService.saveEntity(fundEbankProcess);
		
		variablesMap.put("fund_ebank_process", fundEbankProcess.getId());

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub

	}
}
