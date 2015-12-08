package com.business.action.leasing.project.reconsider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.base.BaseMessage;
import com.business.entity.base.BaseMessageToUser;
import com.business.entity.proj.ProjGuaranteeEquip;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.service.BaseService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;

@WorkflowAction(name = "projReconsiderEditAction", description = "流程修改动作", workflowName = "项目复议流程")
@Component(value = "projReconsiderEditAction")
public class ProjReconsiderEditAction implements JbpmBaseAction {
	@Resource(name="baseService")
	private BaseService baseService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		String proj_id = variablesMap.get("proj_info.projid");
		Map<String,Object> propertiesMap = new  HashMap<String,Object>();
		propertiesMap.put("proj_id",proj_id);
		ProjInfo projInfo =(ProjInfo)this.baseService.getNewOrUpdateObject(ProjInfo.class, propertiesMap);
		//将work_flag赋值为1（1：流程中 0：非流程中）
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		this.baseService.updateEntity(projInfo);
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
//		this.save(request, variablesMap,jbpmWorkflowHistoryInfo);
		
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		System.out.print("dd");
		
		/*
		String proj_id = variablesMap.get("proj_info.proj_id");
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("proj_id", proj_id);
        // 立项基本表
		ProjInfo projInfo = (ProjInfo)this.baseService.updateMainEntity(ProjInfo.class, queryMainObjectMap, variablesMap,null, "proj_info");
		//更改项目状态为流程进行中
		
		// 商务条件
		this.baseService.updateOneToOneEntity(projInfo, "projCondition", "proj_id", variablesMap,null,"proj_condition");
		// 租金发票类型
		this.baseService.updateOneToOneEntity(projInfo, "projInvoiceType", "proj_id", variablesMap,null, "proj_invoice_type");
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		dictDataClassMapping.put("CustomerInfo", "customerName");
		// 租赁物明细
		String jsonEquipsString = variablesMap.get("json_proj_equip_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(projInfo, "projEquips", ProjEquip.class, "proj_id", jsonEquipsString,dictDataClassMapping);
		// 添加新的租金计划
		String jsonFundFundRentPlanString = variablesMap.get("json_fund_rent_plan_str");//proj_info.projFundFundRentPlans
		this.baseService.updateOneToManyCollections(projInfo, "projFundFundRentPlans", ProjFundRentPlan.class, "proj_id", jsonFundFundRentPlanString,dictDataClassMapping);
		// 现金流量表
		String jsonprojFundRentCashString = variablesMap.get("json_fund_rent_cash_str");
		this.baseService.updateOneToManyCollections(projInfo, "projFundRentCashs", ProjCashDetail.class, "proj_id", jsonprojFundRentCashString,dictDataClassMapping);
		// 抵押物信息
		String jsonprojGuaranteeEquipString = variablesMap.get("json_proj_guarantee_equip_str");
		this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeEquips", ProjGuaranteeEquip.class, "proj_id", jsonprojGuaranteeEquipString,dictDataClassMapping);
		// 担保单位
		String jsonProjGuaranteeMethodString = variablesMap.get("json_proj_guarantee_method_str");
		this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeMethods", ProjGuaranteeMethod.class, "proj_id", jsonProjGuaranteeMethodString,dictDataClassMapping);
		*/
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String proj_id = variablesMap.get("proj_id");
        // 立项基本表
		ProjInfo projInfo = (ProjInfo)this.baseService.findEntityByID(ProjInfo.class,proj_id);
		
		// 发站内信给经销商，提报合同审批信息
		User user = (User) SecurityUtil.getPrincipal();
		BaseMessage baseMessage = new BaseMessage();
		baseMessage.setMsgTitle(projInfo.getProjectName()+"复议信息");
		DictionaryData dictmsg= this.baseService.findEntityByID(DictionaryData.class,"msgtype.1");
		baseMessage.setMsgType(dictmsg);
		baseMessage.setSendDate(DateUtil.getSystemDate());
		baseMessage.setFromUser(user);
		baseMessage.setCreateDate(DateUtil.getSystemDateTime());
		baseMessage.setCreator(user);
		baseMessage.setMsgText(projInfo.getProjectName()+"未完成项目复议,该项目已被否决!");
		this.baseService.saveEntity(baseMessage);
		List<User> users = new ArrayList<User>();
		//发站内信给经销商
		users.add(projInfo.getProjRegistrar());
		/*if(projInfo.getProjRegistrar().getId().equals(projInfo.getProjAssist().getId())){
		}else{
			users.add(projInfo.getProjRegistrar());
			users.add(projInfo.getProjAssist());
		}*/
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
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		this.baseService.saveOrUpdateEntity(projInfo);
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
