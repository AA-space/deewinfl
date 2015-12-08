package com.business.action.leasing.fundPayment;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.JBPMWorkflowHistoryInfoUser;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundPayCautionmoney;
import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "fundPaymentEditFiveAction", description = "流程编辑动作，保证金支付明细", workflowName = "付款流程")
@Component(value = "fundPaymentEditFiveAction")
public class FundPaymentEditFiveAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;

	private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		ContractInfo contractinfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, variablesMap.get("contract_id"));
		//CustInfo cust = (CustInfo) this.tableService.findEntityByID(CustInfo.class, variablesMap.get("cust_id"));
		String json_contract_fund_payment_now_str = variablesMap.get("json_contract_fund_payment_now_str");

		List<ContractFundPayCautionmoney> ContractFundFundPayCollectList = new ArrayList<ContractFundPayCautionmoney>();
		
		//保证金
		DictionaryData feeType = this.tableService.findEntityByID(DictionaryData.class, "feetype2");
	
		//企划
		User planned = null;
		//财务
		User accountant = null;
		for(JBPMWorkflowHistoryInfo currentJbpmWorkflowHistoryInfo : jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getJbpmWorkflowHistoryInfos()){
 			if(null != currentJbpmWorkflowHistoryInfo.getHistoryTaskInstanceImpl()){
 				System.out.println(currentJbpmWorkflowHistoryInfo.getActivityDetail().getActivityName());
 				if("01业务企划岗发起".equals(currentJbpmWorkflowHistoryInfo.getActivityDetail().getActivityName())){
 					for(JBPMWorkflowHistoryInfoUser jbpmWorkflowHistoryInfoUser : currentJbpmWorkflowHistoryInfo.getJbpmWorkflowHistoryInfoUsers()){
 						String endTime  = jbpmWorkflowHistoryInfoUser.getEndTime();//有结束时间证明已经处理
 						if(null != endTime){
 							User actualActor = jbpmWorkflowHistoryInfoUser.getActualActor();//实际处理人
 	 						User planActor   = jbpmWorkflowHistoryInfoUser.getPlanActor();//计划处理人
 	 						if(!actualActor.equals(planActor)){//委托人处理的事情
 	 							planned = planActor;
 	 						}
 	 						else{//同一个人，没有委托他人处理
 	 							planned = planActor;
 	 						}
 						}
 					}
 					break;
 	 			}
 				if("04租赁业务会计审核".equals(currentJbpmWorkflowHistoryInfo.getActivityDetail().getActivityName())){
 					for(JBPMWorkflowHistoryInfoUser jbpmWorkflowHistoryInfoUser : currentJbpmWorkflowHistoryInfo.getJbpmWorkflowHistoryInfoUsers()){
 						String endTime  = jbpmWorkflowHistoryInfoUser.getEndTime();//有结束时间证明已经处理
 						if(null != endTime){
 							User actualActor = jbpmWorkflowHistoryInfoUser.getActualActor();//实际处理人
 							User planActor   = jbpmWorkflowHistoryInfoUser.getPlanActor();//计划处理人
 							if(!actualActor.equals(planActor)){//委托人处理的事情
 								accountant = planActor;
 							}
 							else{//同一个人，没有委托他人处理
 								accountant = planActor;
 							}
 						}
 					}
 					break;
 				}
 			}
 		
 		}
		
		
		
		
		
		
		JSONArray jsonFundPaymentArray = new JSONArray(json_contract_fund_payment_now_str);
		for (int i = 0; i < jsonFundPaymentArray.length(); i++) {
			JSONObject jsonFundPayment = (JSONObject) jsonFundPaymentArray.opt(i);
			//保证金
			if("feetype2".equals(jsonFundPayment.get("feetype")))
			{
				ContractFundPayCautionmoney collect = new ContractFundPayCautionmoney();
				String pid = jsonFundPayment.optString("pid");
				String rollback = jsonFundPayment.optString("rollback");
				
				if(pid != null && rollback != null && rollback.equals("1")){//如果是红冲，跳过
					continue;
				} 
				collect.setContractId(contractinfo);
				//collect.setCreditMoney(new BigDecimal(jsonFundPayment.optString("creditmoney")));
				collect.setDocId(variablesMap.get("jbpmWorkflowHistoryInfoUserId"));
				collect.setExportFlag(0);
				collect.setFeeType(feeType);
				collect.setPaymentId(jsonFundPayment.optString("paymentid"));
				collect.setPayObj(jsonFundPayment.optString("factobject"));
				collect.setPlanDate(jsonFundPayment.optString("factdate"));
				collect.setPlanMoney(new BigDecimal(jsonFundPayment.optString("factmoney")));
				collect.setClientAccnumber(jsonFundPayment.optString("clientaccnumber"));
				collect.setClientAccount(jsonFundPayment.optString("clientaccount"));
				collect.setClientBank(jsonFundPayment.optString("clientbank"));
				//collect.setServiceFees(new BigDecimal(jsonFundPayment.optInt("servicefees")));
				collect.setPlanned(planned);
				collect.setAccountant(accountant);
				
				
				collect.setCreateDate(DateUtil.getSystemDateTime());
				collect.setCreator((User)SecurityUtil.getPrincipal());
				collect.setEquipcount(jsonFundPayment.optInt("equipcount"));
				
				ContractFundFundPayCollectList.add(collect);
			}
		}
		if(ContractFundFundPayCollectList.size()>0){
		    this.tableService.saveAllEntities(ContractFundFundPayCollectList);
		}
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}
}
