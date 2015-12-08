package com.business.action.leasing.contract.approval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.Department;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.JBPMWorkflowHistoryInfoUser;
import com.business.entity.User;
import com.business.entity.UserDepartment;
import com.business.entity.base.BaseMessage;
import com.business.entity.base.BaseMessageToUser;
import com.business.entity.contract.ContractGuaranteeMethod;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractPremiseCondition;
import com.business.entity.contract.ContractSupplierInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.cash.ContractFinaCashDetail;
import com.business.entity.contract.reckon.fina.ContractFinaRentPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerDeptInfo;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.reckon.ConditionDataToHisService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author 孙传良
 * @date 2013-4-18下午05:17:35
 * @info 流程结束的时候触发的action 在这个action中保存流程信息
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "contractApprovalEndAction", description = "流程结束动作", workflowName = "合同审批流程")
@Component(value = "contractApprovalEndAction")
public class ContractApprovalEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name="conditionDataToHisService")
	private ConditionDataToHisService  conditionDataToHisService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/**
		 * 合同审批流程结束需要保存的信息伪码
		 * 1.合同表 contract_info
		 * 2.合同租金测算结果
		 * 	2.1商务条件
		 * 	2.2合同租金计划
		 * 	2.3合同现金流
		 * 	2.4会计租金计划
		 * 	2.5会计现金流
		 * 	2.6资金计划
		 * 3.计算合同表商务条件表中endDate并保存 
		 * 4.租赁物明细
		 * 5.抵押物
		 * 6.担保
		 * 7.前提条件
		 * 8.合同清单
		 * 9.合同各方
		 * 	9.1供应商(合同各方)
		 * 10.租金发票类型
		 * 11.合同租金发票
		 * 12.合同其他信息
		 */
		User user = (User) SecurityUtil.getPrincipal();
		//System.out.println(user.getId() + "**********" + user.getUsername());
		
		//设置为资料补齐
		String proj_id = variablesMap.get("proj_id");
		ProjInfo projInfo = this.baseService.findEntityByID(ProjInfo.class, proj_id);
		projInfo.setDataComplete(1);
		this.baseService.saveEntity(projInfo);
		
		//发站内信给经销商，提报GPS信息
		/*Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		//User user = (User) SecurityUtil.getPrincipal();
		queryMainObjectMap.put("code", "msgtype.1");
		BaseMessage baseMessage = new BaseMessage();
		//BaseMessageToUser toUser = new BaseMessageToUser();
		baseMessage.setMsgTitle(projInfo.getProjectName()+"提报GPS信息 ");
		baseMessage.setMsgType((DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, queryMainObjectMap).get(0));
		baseMessage.setSendDate(DateUtil.getSystemDate());
		baseMessage.setFromUser(user);
		baseMessage.setCreateDate(DateUtil.getSystemDateTime());
		baseMessage.setCreator(user);
		baseMessage.setMsgText(projInfo.getProjectName()+"已经完成合同审批，请提报GPS信息！");
		this.baseService.saveEntity(baseMessage);
		List<User> users = new ArrayList<User>();
		//发站内信给经销商
		if(projInfo.getProjRegistrar().getId().equals(projInfo.getProjAssist().getId())){
			users.add(projInfo.getProjRegistrar());
		}else{
			users.add(projInfo.getProjRegistrar());
			users.add(projInfo.getProjAssist());
		}
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
		
		/*Set<UserDepartment> deptSet = user.getUserDepts();
		Map<String,Object> Map = new HashMap<String,Object>();
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		
		String contractId = variablesMap.get("contract_info.contractid");
		variablesMap.put("contract_info.id", variablesMap.get("contract_info.id"));
		ContractInfo contractInfo=new ContractInfo();
		if(!"".equals(contractId)){
			propertiesMap.put("contractId", contractId);
			List<ContractInfo> cInfos=this.baseService.findEntityByProperties(ContractInfo.class, propertiesMap);
			if(cInfos!=null&&cInfos.size()>0){
				contractInfo=cInfos.get(0);
				//如果当前登录人为经销商,则插入cust_dealer
				for (UserDepartment userDepartment : deptSet) {
					Department department = userDepartment.getDept();
					Map.put("dealerDept", department);
					List<DealerDeptInfo> list = this.baseService.findEntityByProperties(DealerDeptInfo.class, Map);
					if(list != null && list.size() > 0){
						contractInfo.setCustDealer(list.get(0).getCustId());
						break;
					}
				}
				contractInfo.setContractStatus(AppStaticUtil.CONTRACT_APPROVAL);
				
				this.baseService.updateEntity(contractInfo);
			}
		}
		//客户信息
		CustInfo customerInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, variablesMap.get("contract_info.custid"));
		contractInfo.setCustId(customerInfo);
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		
		// 2.1商务条件  此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
		//this.baseService.updateOneToOneEntity(contractInfo, "contractCondition", "contractId", variablesMap,null, "framework_condition");
		// 2.2合同租金计划
		
		//String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
		//this.baseService.updateOneToManyCollections(contractInfo, "contractFundRentPlans", ContractFundRentPlan.class, "contractId", json_fund_rent_plan_str,null);
		List<ContractFundRentPlan> fundRentPlans=new ArrayList<ContractFundRentPlan>(fundRentPlanSets);
		Collections.sort(fundRentPlans, new Comparator<ContractFundRentPlan>() {
			@Override
			public int compare(ContractFundRentPlan o1, ContractFundRentPlan o2) {
				return o1.getPlanDate().compareTo(o2.getPlanDate());
			}
			
		});*/
		// 2.3合同现金流
		//String json_fund_cash_flow_str = variablesMap.get("json_fund_cash_flow_str");
		//this.baseService.updateOneToManyCollections(contractInfo, "contractCashDetails", ContractCashDetail.class, "contractId", json_fund_cash_flow_str,null);
		// 2.4资金计划
		//String json_contract_fund_charge_str = variablesMap.get("json_fund_fund_charge_str");
		//this.baseService.updateOneToManyCollections(contractInfo, "fundFundChargePlans", ContractFundFundPlan.class, "contractId", json_contract_fund_charge_str,dictDataClassMapping);
		/* 2.5会计租金计划
		String json_finance_rent_plan_str = variablesMap.get("json_finance_rent_plan_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractFinaRentPlans", ContractFinaRentPlan.class, "contractId", json_finance_rent_plan_str,null);
		 2.6会计现金流
		String json_finance_cash_flow_str = variablesMap.get("json_finance_cash_flow_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractFinaCashDetails", ContractFinaCashDetail.class, "contractId", json_finance_cash_flow_str,null);
		 3.计算合同(项目)和商务条件中的endDate和startDate
		contractInfo.setStartDate(condition.getStartDate());
		contractInfo.setEndDate(fundRentPlans.get(fundRentPlans.size()-1).getPlanDate());
		condition.setEndDate(contractInfo.getEndDate());
		// 4.租赁物明细
		String jsonEquipsString = variablesMap.get("json_proj_equip_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractEquips", ContractEquip.class, "contractId", jsonEquipsString,null);
		// 5.抵押物信息
//		String jsonprojGuaranteeEquipString = variablesMap.get("json_contract_guarantee_equip_str");
//		this.baseService.updateOneToManyCollections(contractInfo, "contractGuaranteeEquips", ContractGuaranteeEquip.class, "contractId", jsonprojGuaranteeEquipString,dictDataClassMapping);
		// 6.担保单位
		String jsonProjGuaranteeMethodString = variablesMap.get("json_contract_guarantee_method_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractGuaranteeMethods", ContractGuaranteeMethod.class, "contractId", jsonProjGuaranteeMethodString,null);
		// 7.前提条件
		String json_contract_premise_str = variablesMap.get("json_contract_premise_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractPremiseConditions", ContractPremiseCondition.class, "contractId", json_contract_premise_str,null);
		// 8.合同清单   
		//String json_contract_list_str = variablesMap.get("json_contract_list_str");
		//this.baseService.updateOneToManyCollections(contractInfo, "contractwords", ContractWord.class, "contractId", json_contract_list_str,dictDataClassMapping);
		// 9.合同各方 
		this.baseService.updateOneToOneEntity(contractInfo, "contractSignatory", "contractId", variablesMap, null, "contract_signatory");
		//  9.1供应商(合同各方)
		String json_contract_supplier_str = variablesMap.get("json_contract_supplier_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractSupplierInfos", ContractSupplierInfo.class, "contractId", json_contract_supplier_str,null);
		// 10.租金发票类型
		this.baseService.updateOneToOneEntity(contractInfo, "contractInvoiceType", "contractId", variablesMap, null, "contract_invoice_type");
		// 11.合同租金发票
		this.baseService.updateOneToOneEntity(contractInfo, "contractInvoiceInfo", "contractId", variablesMap, null, "contract_invoice_info");
		// 12.合同其他信息
		this.baseService.updateOneToOneEntity(contractInfo, "contractOtherInfo", "contractId", variablesMap,null, "contract_other_info");
		*/
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
