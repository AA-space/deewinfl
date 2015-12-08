package com.business.action.leasing.contract.onhire;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.BusException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.BaseMessage;
import com.business.entity.base.BaseMessageToUser;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractFinstartdate;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquipAcceptance;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.reckon.ConditionDataToHisService;
import com.business.service.reckon.ContractFundPlanDataTohisService;
import com.business.service.vouchersFactory.ContractOnHireService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;


@WorkflowAction(name = "contractOnHireEndAction", description = "流程结束动作", workflowName = "合同起租流程")
@Component(value = "contractOnHireEndAction")
public class ContractOnHireEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name="conditionDataToHisService")
	private ConditionDataToHisService  conditionDataToHisService;
	@Resource(name="ContractFundPlanDataTohisService")
	private ContractFundPlanDataTohisService contractFundPlanDataTohisService;
	@Resource(name="contractOnHireService")
	private ContractOnHireService contractOnHireService;
	
	
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}
	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String contract_id = variablesMap.get("contract_info.contractid");
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("contractId", contract_id);
		variablesMap.remove("contract_info.projid");
		variablesMap.put("contract_info.workflag", AppStaticUtil.WORKFLOW_OFF.toString());
		// 1.合同基本信息
		ContractInfo contractInfo=(ContractInfo)this.baseService.findEntityByID(ContractInfo.class, variablesMap.get("contract_info.id"));
		this.baseService.copyAndOverrideExistedValueFromStringMap(variablesMap, contractInfo,null);
		this.baseService.updateEntity(contractInfo);
		
		//1.1 保存验收信息
		ContractEquipAcceptance equipAcceptance = new ContractEquipAcceptance();
		this.baseService.copyAndOverrideExistedValueFromStringMap(variablesMap, equipAcceptance, null, "equip_acceptance");
		equipAcceptance.setContractId(contractInfo);
		this.baseService.saveEntity(equipAcceptance);
		
		//1.2contract_fund_rent_plan_before拷贝到contract_fund_rent_plan表中
		String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractFundRentPlans", ContractFundRentPlan.class, "contractId", json_fund_rent_plan_str,null);
				
		//1,3更新商务条件、租金计划、现金流
		String docId=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		conditionDataToHisService.saveContractConditionDataToHis(contractInfo.getId(), docId, "his_contract_onhire", variablesMap, "framework_condition",
						"json_fund_rent_plan_str", "", "json_fund_cash_flow_str", "");
		//1.4更新资金计划
		contractFundPlanDataTohisService.saveContractConditionDataToHis(contractInfo.getId(), docId, "his_contract_onhire", variablesMap, "json_fund_fund_charge_str", "");
			
		//2.签约日期
		variablesMap.remove("contract_info.workflag");
		variablesMap.put("contract_info.id", variablesMap.get("contract_info.id"));
		this.baseService.updateOneToOneEntity(contractInfo, "contractOtherInfo", "contractId", variablesMap,null, "contract_other_info");
		//3.入历史表
		//String docId=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		//conditionDataToHisService.saveContractConditionDataToHis(contractInfo.getId(), docId, "his_contract_onhire", variablesMap, "framework_condition",
		//		"json_fund_rent_plan_str", "", "json_fund_cash_flow_str", "");
		//4.资金计划
		//contractFundPlanDataTohisService.saveContractConditionDataToHis(contractInfo.getId(), docId, "his_contract_onhire", variablesMap, "json_fund_fund_charge_str", "");
		//5.合同起租信息表
		ContractFinstartdate finstartdate = new ContractFinstartdate();
		finstartdate.setContractId(contractInfo);
		finstartdate.setStartDate(variablesMap.get("framework_condition.startdate"));
		finstartdate.setStartMoney(new BigDecimal(variablesMap.get("framework_condition.equipamt")));
		finstartdate.setStartType("合同起租");
		this.baseService.saveEntity(finstartdate);
		
		//统计租金
		BigDecimal sum=BigDecimal.ZERO;
		//统计租金利息
		BigDecimal totalInterest=BigDecimal.ZERO;
		String jsonRentString = variablesMap.get("json_fund_rent_plan_str");//json_fund_rent_plan_str 
		JSONArray jsonArray = new JSONArray(jsonRentString);
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			sum=sum.add(new BigDecimal(jsonObj.getDouble("rent")));
			totalInterest=totalInterest.add(new BigDecimal(jsonObj.getDouble("interest")));
		}
		// 13.发站内信给经销商，提报GPS信息
		User user = (User) SecurityUtil.getPrincipal();
		ProjInfo projInfo=contractInfo.getProjId();
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("code", "msgtype.1");
		BaseMessage baseMessage = new BaseMessage();
		baseMessage.setMsgTitle(projInfo.getProjectName()+"提报合同起租信息 ");
		baseMessage.setMsgType((DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, queryMap).get(0));
		baseMessage.setSendDate(DateUtil.getSystemDate());
		baseMessage.setFromUser(user);
		baseMessage.setCreateDate(DateUtil.getSystemDateTime());
		baseMessage.setCreator(user);
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		propertiesMap.put("id",contractInfo.getId());
		String hsq = "from ContractEquipAcceptance where contractId.id=?";
		List<ContractEquipAcceptance> contractEquipAcceptances = this.baseService.findResultsByHSQL(hsq,contractInfo.getId());
		String accptdate = "";
		if ( contractEquipAcceptances.size() > 0 )
		{
			 accptdate = contractEquipAcceptances.get(0).getAcceptDate();
		}
		String hsql = "from ContractFundRentPlan where contractId.id=?";
		List<ContractFundRentPlan> contractFundRentPlans = this.baseService.findResultsByHSQL(hsql,contractInfo.getId());
		BigDecimal brent = BigDecimal.ZERO;
		if( contractFundRentPlans.size() > 0 ){
			brent = contractFundRentPlans.get(0).getRent();
		}
		baseMessage.setMsgText(projInfo.getProjectName()+"已经完成合同起租，合同号为："+contractInfo.getContractNumber()+",起租日为："+accptdate+",每期租金："+brent+"，请确认信息！");
		this.baseService.saveEntity(baseMessage);
		List<User> users = new ArrayList<User>();
		//发站内信给经销商
//		if(projInfo.getProjRegistrar().getId().equals(projInfo.getProjAssist().getId())){
//		}else{
//			users.add(projInfo.getProjRegistrar());
//			users.add(projInfo.getProjAssist());
//		}
		users.add(projInfo.getProjRegistrar());
		Set<BaseMessageToUser> set = new HashSet<BaseMessageToUser>();
		BaseMessageToUser baseMessageToUser = null;
		for (int i = 0; i < users.size(); i++) {
			baseMessageToUser = new BaseMessageToUser();
			baseMessageToUser.setMsgID(baseMessage);
			baseMessageToUser.setReadStatus("1");
			baseMessageToUser.setReadUser(users.get(i));
			baseMessageToUser.setCreateDate(DateUtil.getSystemDateTime());
			baseMessageToUser.setCreator(user);
			set.add(baseMessageToUser);
		}
		this.baseService.saveAllEntities(set);
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		
		
		/** 凭证生成-开始*/
		//1. 生成凭证：确认+客户+车款	
		String leasform=contractInfo.getLeasForm().getCode();
		//回租凭证
		if("lease_form2".equals(leasform)){
			contractOnHireService.createVoucherforLeaseback(contractInfo, finstartdate);
		}else{
		    contractOnHireService.createVoucher(contractInfo, finstartdate);
		}
		
		//2.生成凭证：确认+客户+首付款
		Map<String, String> dataMap=new HashMap<String, String>();
		dataMap.put("firstpaymenttotal", variablesMap.get("framework_condition.firstpaymenttotal"));//首付款合计
		dataMap.put("firstpayment", variablesMap.get("framework_condition.firstpayment"));//起租租金
		dataMap.put("cautionmoney", variablesMap.get("framework_condition.cautionmoney"));//保证金
		dataMap.put("nominalprice", variablesMap.get("framework_condition.nominalprice"));//留购价
		dataMap.put("gpsmoney", variablesMap.get("framework_condition.gpsmoney"));//GPS
		dataMap.put("insuremoney", variablesMap.get("framework_condition.insuremoney"));//保险费
		dataMap.put("otherincome", variablesMap.get("framework_condition.otherincome"));//其他费用
		dataMap.put("handlingchargemoney", variablesMap.get("framework_condition.handlingchargemoney"));//手续费
		
		
		contractOnHireService.createVoucherFirstPay(contractInfo, dataMap, finstartdate);
		
		//3.生成凭证：确认+客户+起租租金 
		dataMap.clear();
		dataMap.put("cleanleasemoney", variablesMap.get("framework_condition.cleanleasemoney"));//融资额
		dataMap.put("totalInterest",String.valueOf(totalInterest));//租金利息合计
		dataMap.put("firstpayment", variablesMap.get("framework_condition.firstpayment"));//首付款
		dataMap.put("equipamt", variablesMap.get("framework_condition.equipamt"));//设备款
		dataMap.put("renttotalmoney", variablesMap.get("framework_condition.renttotalmoney"));//租金总额
		
		//回租凭证
		if("lease_form2".equals(leasform)){
			contractOnHireService.createVoucherOnHireRentforLeaseback(contractInfo, dataMap, finstartdate);
		}else{
		    contractOnHireService.createVoucherOnHireRent(contractInfo,dataMap,finstartdate);
		}
		
		//4.凭证： 确认+客户+租金利息
		/*contractOnHireService.createVoucherInterest(contractInfo, sum, totalInterest);*/
		/** 凭证生成-结束*/
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
