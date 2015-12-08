package com.business.action.leasing.contract.approval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.BaseMessage;
import com.business.entity.base.BaseMessageToUser;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractGuaranteeMethod;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractPremiseCondition;
import com.business.entity.contract.ContractSupplierInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.cash.ContractCashDetail;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanBefore;
import com.business.entity.contract.rent.ContractCardForRent;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * 风控审核结束，将状态改为结束，21
 * 
 * @Copyright Tenwa
 */
@WorkflowAction(name = "contractApprovalEditStatusToEndAction", description = "流程修改合同结束", workflowName = "合同审批流程")
@Component(value = "contractApprovalEditStatusToEndAction")
public class ContractApprovalEditStatusToEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name = "contractApprovalStartAction")
	private ContractApprovalStartAction contractApprovalStartAction;
	
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		String contractid = variablesMap.get("contract_info.contractid");
		String contractNumber = variablesMap.get("contract_info.contractnumber");
		ContractInfo contractInfo = new ContractInfo();
		if (!"".equals(contractid) && contractid != null) {
			propertiesMap.put("contractId", contractid);
			List<ContractInfo> cInfos = this.baseService.findEntityByProperties(ContractInfo.class, propertiesMap);
			if (cInfos.size() > 0) 
			{
				contractInfo = (ContractInfo) this.baseService.updateMainEntity(ContractInfo.class, propertiesMap, variablesMap, null, "contract_info");
			} 
			else 
			{
				// 更新数据
				contractInfo = (ContractInfo) this.baseService.copyAndOverrideExistedValueFromStringMap(variablesMap, contractInfo, null, "contract_info");
				this.baseService.saveEntity(contractInfo);
			}
			variablesMap.put("framework_condition.contractid", contractInfo.getId());
			propertiesMap = new HashMap<String, Object>();
			propertiesMap.put("projId", variablesMap.get("contract_info.projid"));
			List<ProjInfo> pInfos = this.baseService.findEntityByProperties(ProjInfo.class, propertiesMap);
			if (pInfos != null && pInfos.size() > 0) {
				//德银保存项目信审批生成的合同号
				if (pInfos.get(0).getContractNumber() != null) {
					contractInfo.setContractNumber(pInfos.get(0).getContractNumber());
					variablesMap.put("contract_info.contractnumber", pInfos.get(0).getContractNumber());
				} else {
					throw new BusinessException("业务合同号不能为空!");
				}
				contractInfo.setProjId(pInfos.get(0));
				contractInfo.setContractStatus(AppStaticUtil.CONTRACT_APPROVAL);
				contractInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
				//保存业务企划提交的是否第三方代付
				contractInfo.setIsThirdPay(variablesMap.get("proj_info.isthirdpay"));
				// 保存租赁物明细的台数到contractinfo表中
				JSONArray jsonArray = new JSONArray(variablesMap.get("json_proj_equip_str").toString());
				contractInfo.setEquipcount(jsonArray.length());
				contractInfo.setPenaltyJMStatus("0");
				this.baseService.saveOrUpdateEntity(contractInfo);
				
				ProjInfo projInfo = pInfos.get(0);
				projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
				this.baseService.saveOrUpdateEntity(projInfo);
				
			} else {
				throw new BusinessException("警告:没有项目信息无法保存合同信息");
			}
			
			// 插入商务条件相关表  // 数据字典通过name属性匹配
			Map<String, String> dictDataClassMapping = new HashMap<String, String>();
			dictDataClassMapping.put("DictionaryData", "code");
			
			// 2.1商务条件 此处的商务条件统一用framework_condition 为了通用性 租金测算页面的域名都用framework_condition开头而不是表名
			this.baseService.updateOneToOneEntity(contractInfo, "contractCondition", "contractId", variablesMap, null, "framework_condition");
			
			// 2.2合同租金计划
			String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
			this.baseService.updateOneToManyCollections(contractInfo, "contractFundRentPlanBefores", ContractFundRentPlanBefore.class, "contractId", json_fund_rent_plan_str, null);

			// 2.3合同现金流
			String json_fund_cash_flow_str = variablesMap.get("json_fund_cash_flow_str");
			this.baseService.updateOneToManyCollections(contractInfo, "contractCashDetails", ContractCashDetail.class, "contractId", json_fund_cash_flow_str, null);
			// 2.4资金计划
			String json_contract_fund_charge_str = variablesMap.get("json_fund_fund_charge_str");
			this.baseService.updateOneToManyCollections(contractInfo, "fundFundChargePlans", ContractFundFundPlan.class, "contractId", json_contract_fund_charge_str, dictDataClassMapping);
//			this.baseService.updateOneToManyCollectionsNoRemoved(contractInfo, "fundFundChargePlans", ContractFundFundPlan.class, "contractId", json_contract_fund_charge_str, dictDataClassMapping);
			
			getContractQueryOption(variablesMap);
		
			// 4.租赁物明细
			if (contractInfo.getContractEquips() == null || contractInfo.getContractEquips().size() == 0) {
					String jsonEquipsString = variablesMap.get("json_proj_equip_str");
					this.baseService.updateOneToManyCollections(contractInfo, "contractEquips", ContractEquip.class, "contractId", jsonEquipsString, null);
			}
		 
		//保存contract_info.id
		variablesMap.put("contract_info.id",contractInfo.getId());
		// 6.担保单位
		String jsonProjGuaranteeMethodString = variablesMap.get("json_contract_guarantee_method_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractGuaranteeMethods", ContractGuaranteeMethod.class, "contractId", jsonProjGuaranteeMethodString, null);
		// 7.前提条件
		String json_contract_premise_str = variablesMap.get("json_contract_premise_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractPremiseConditions", ContractPremiseCondition.class, "contractId", json_contract_premise_str, null);
		// 9.合同各方
		this.baseService.updateOneToOneEntity(contractInfo, "contractSignatory", "contractId", variablesMap, null, "contract_signatory");
		//合同扣款卡号
		ContractCardForRent cardinfo = new ContractCardForRent();
		propertiesMap.clear();
		propertiesMap.put("contractId", contractInfo);
		List<ContractCardForRent> cardinfos = this.baseService.findEntityByProperties(ContractCardForRent.class, propertiesMap);
		if(cardinfos.size()>0){
			cardinfo = cardinfos.get(0);
		}
		cardinfo.setIsCard(Integer.valueOf(variablesMap.get("contract_signatory.iscard")));
		cardinfo.setBankName(variablesMap.get("contract_signatory.clientaccbank"));
		cardinfo.setCardNum(variablesMap.get("contract_signatory.clientaccnumber"));
		cardinfo.setCardName(variablesMap.get("contract_signatory.clientaccname"));
		cardinfo.setCreateDate(DateUtil.getSystemDateTime());
		cardinfo.setContractId(contractInfo);

		this.baseService.saveOrUpdateEntity(cardinfo);
		
		// 9.1供应商(合同各方)
		String json_contract_supplier_str = variablesMap.get("json_contract_supplier_str");
		this.baseService.updateOneToManyCollections(contractInfo, "contractSupplierInfos", ContractSupplierInfo.class, "contractId", json_contract_supplier_str, null);
		// 10.租金发票类型
		this.baseService.updateOneToOneEntity(contractInfo, "contractInvoiceType", "contractId", variablesMap, null, "contract_invoice_type");
		// 11.合同租金发票
		this.baseService.updateOneToOneEntity(contractInfo, "contractInvoiceInfo", "contractId", variablesMap, null, "contract_invoice_info");
		// 12.合同其他信息
		this.baseService.updateOneToOneEntity(contractInfo, "contractOtherInfo", "contractId", variablesMap, null, "contract_other_info");
		// 13.发站内信给经销商，提报GPS信息
		User user = (User) SecurityUtil.getPrincipal();
		ProjInfo projInfo=contractInfo.getProjId();
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("code", "msgtype.1");
		BaseMessage baseMessage = new BaseMessage();
		baseMessage.setMsgTitle(projInfo.getProjectName()+"提报GPS信息 ");
		baseMessage.setMsgType((DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, queryMainObjectMap).get(0));
		baseMessage.setSendDate(DateUtil.getSystemDate());
		baseMessage.setFromUser(user);
		baseMessage.setCreateDate(DateUtil.getSystemDateTime());
		baseMessage.setCreator(user);
		baseMessage.setMsgText(projInfo.getProjectName()+"已经完成合同审批，合同号为："+contractNumber+"，请提报GPS信息！");
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
				WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
				if(w!=null){
				   this.tableService.removeEntity(w);
				}
			}
			/** 流程冲突第三步-结束 */
		} 
		else 
		{
			throw new BusinessException("请输入合同号!");
		}
	}
	private void getContractQueryOption(Map<String, String> variablesMap) {
		// 合同清单选择的查询条件缓存
		String contract_word_partner_type = variablesMap.get("contract_word.partner_type");
		String contract_word_car_affiliated = variablesMap.get("contract_word.car_affiliated");
		String contract_word_mortgage_type = variablesMap.get("contract_word.mortgage_type");
		String contract_word_assurance = variablesMap.get("contract_word.assurance");
		String equip_money_totle = variablesMap.get("equip.equip_money_totle");

		variablesMap.put("contract_word_partner_type", contract_word_partner_type);
		variablesMap.put("contract_word_car_affiliated", contract_word_car_affiliated);
		variablesMap.put("contract_word_mortgage_type", contract_word_mortgage_type);
		variablesMap.put("contract_word_assurance", contract_word_assurance);
		variablesMap.put("equip_money_totle", equip_money_totle);
	}
	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// 校验合同号唯一
		String msg = "";
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		String contractNumber = variablesMap.get("contract_info.contractnumber").trim();
		variablesMap.put("contract_info.contractnumber", contractNumber);
		String id = variablesMap.get("contract_info.id");
		if (!"".equals(contractNumber)) {
			propertiesMap.put("contractNumber", contractNumber);
			List<ContractInfo> cInfos = this.baseService.findEntityByProperties(ContractInfo.class, propertiesMap);
			// 移除本条记录
			for (ContractInfo contractInfo : cInfos) {
				if (contractInfo.getId().equalsIgnoreCase(id)) {
					cInfos.remove(contractInfo);
				}
			}
			if (cInfos != null && cInfos.size() > 0) {
				msg = "您填写的合同号[" + contractNumber + "]已经存在!";
			}
		}
		return msg;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest, java.util.Map)
	 **/

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//如果退回的，信审将不再审核车架号和合同小号信息
		//variablesMap.put("json_proj_equip_str_for_credit", variablesMap.get("json_proj_equip_str"));
	}
}
