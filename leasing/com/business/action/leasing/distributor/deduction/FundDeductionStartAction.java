package com.business.action.leasing.distributor.deduction;

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
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractPremiseCondition;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.invoice.ContractInvoiceType;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerDeptInfo;
import com.business.entity.dealer.MFundFundCharge;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "fundDeductionStartAction", description = "流程开始动作", workflowName = "经销商保证金抵扣流程")
@Component(value = "fundDeductionStartAction")
public class FundDeductionStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;

	private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);

	@Override
	public String delete(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}

	@Override
	public String save(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

		
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String fundid=variablesMap.get("fundid");
		String dealerid=variablesMap.get("dealerid");
		CustInfo ci=(CustInfo)this.tableService.findEntityByID(CustInfo.class,dealerid);
		if(ci!=null){
		   variablesMap.put("dealerid", ci.getId());
		   variablesMap.put("dealername", ci.getCustName());
		}
	    MFundFundCharge mf=(MFundFundCharge)this.tableService.findEntityByID(MFundFundCharge.class, fundid);
	    Map<String,String>fieldClassMapping=new HashMap<String,String>();
		fieldClassMapping.put("CustInfo", "id");
		fieldClassMapping.put("FundEbankData", "ebdataId");
		fieldClassMapping.put("DictionaryData", "code");
		fieldClassMapping.put("MFundFundCharge", "id");
	    if(mf!=null){
	      mf.initMFundFundCharge();
	     List Flist=new ArrayList();
	     Flist.add(mf);
	  	variablesMap.put("json_fund_receiver_detail_str", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString( Flist, fieldClassMapping));
	    }
	   
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest,
	 *      java.util.Map)
	 **/

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub

	}
}
