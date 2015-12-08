package com.business.action.leasing.project.reconsider;

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
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.BaseMessage;
import com.business.entity.base.BaseMessageToUser;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjCreditResult;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.proj.reckon.ProjCashDetail;
import com.business.entity.proj.reckon.ProjCondition;
import com.business.entity.proj.reckon.ProjFundFundPlan;
import com.business.entity.proj.reckon.ProjFundRentPlan;
import com.business.service.BaseService;
import com.business.service.reckon.ConditionDataToHisService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.UUIDUtil;
import com.kernal.utils.WebUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-17
 * @info项目复议的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projReconsiderEndAction", description = "流程结束动作", workflowName = "项目复议流程")
@Component(value = "projReconsiderEndAction")
public class ProjReconsiderEndAction implements JbpmBaseAction {
	@Resource(name="baseService")
	private BaseService baseService;
	@Resource(name="conditionDataToHisService")
	private ConditionDataToHisService  conditionDataToHisService;
	

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		String proj_id = variablesMap.get("proj_id");
		ProjInfo projInfo = (ProjInfo)this.baseService.findEntityByID(ProjInfo.class,proj_id);
//		String sql="select * from t_jbpm_workflow_info where workflow_name_ = '项目复议流程' and history_activity_name_  = '05项目被否决' and key_two_= '"+projInfo.getProjectName()+"' ";
//		JdbcTemplate jdbcTemplate = (JdbcTemplate)WebUtil.getApplicationContext().getBean("jdbcTemplate");
//		List<Map<String, Object>> rownums = jdbcTemplate.queryForList(sql);
//		if (rownums.size() > 0) {
//			System.out.println("########################复议否决结束节点不在更新数据###################################");
//		}
//		else {}
        // 立项基本表
			projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
			//客户信息
			CustInfo customerInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, variablesMap.get("proj_info.custid"));
			projInfo.setCustId(customerInfo);
			//其它信息
			this.baseService.updateOneToOneEntity(projInfo, "projOtherInfo", "projId", variablesMap,null, "proj_other_info");
			// 租金发票类型
			this.baseService.updateOneToOneEntity(projInfo, "projInvoiceType", "projId", variablesMap,null, "proj_invoice_type");
			//数据字典通过name属性匹配
			Map<String,String> dictDataClassMapping = new HashMap<String,String>();
			dictDataClassMapping.put("DictionaryData", "code");
			dictDataClassMapping.put("CustInfo", "id");
			// 租赁物明细
			String jsonEquipsString = variablesMap.get("json_proj_equip_str");//proj_info.projEquips
			this.baseService.updateOneToManyCollections(projInfo, "projEquips", ProjEquip.class, "projId", jsonEquipsString,dictDataClassMapping);
			// 担保单位
			String jsonProjGuaranteeMethodString = variablesMap.get("json_proj_guarantee_method_str");
			this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeMethods", ProjGuaranteeMethod.class, "projId", jsonProjGuaranteeMethodString,dictDataClassMapping);
			
			
			//项目评审委员会初审议复议
//		  ProjMeetingRecord pr;
//       System.out.println(variablesMap.toString());
//       Map<String,Object> properMap = new HashMap<String,Object>();
//       properMap.put("id", UUIDUtil.getUUID());
//       if(variablesMap.containsKey("proj_credit_re_record.meettype")){
//           pr=(ProjMeetingRecord) this.baseService.updateMainEntity(ProjMeetingRecord.class, properMap, variablesMap, null, "proj_credit_re_record");
//           pr.setProjId(projInfo);
//           pr.setFlowName(jbpmWorkflowHistoryInfo.getWorkflowName());
//		     this.baseService.updateEntity(pr);
//      }
//		//风险控制委员会审议复议
//		 if(variablesMap.containsKey("proj_credit_re_risk_record.meettype")){
//		 pr=(ProjMeetingRecord) this.baseService.updateMainEntity(ProjMeetingRecord.class, properMap, variablesMap, null, "proj_credit_re_risk_record");
//	     pr.setProjId(projInfo);
//	     pr.setFlowName(jbpmWorkflowHistoryInfo.getWorkflowName());
//	     this.baseService.updateEntity(pr);
//		 }
//	   //董事会审批复议
//	     if(variablesMap.containsKey("proj_credit_re_board_record.meettype")){
//		 pr=(ProjMeetingRecord) this.baseService.updateMainEntity(ProjMeetingRecord.class, properMap, variablesMap, null, "proj_credit_re_board_record");
//	     pr.setProjId(projInfo);
//	     pr.setFlowName(jbpmWorkflowHistoryInfo.getWorkflowName());
//	     this.baseService.updateEntity(pr);
//	    }
			//信审结论
			Map<String,Object> properMap = new HashMap<String,Object>();
			properMap.put("id", UUIDUtil.getUUID());
			ProjCreditResult pcr;
			pcr=(ProjCreditResult)this.baseService.updateMainEntity(ProjCreditResult.class, properMap, variablesMap, null, "proj_credit_re_result");
			pcr.setProjId(projInfo);
			pcr.setFlowName(jbpmWorkflowHistoryInfo.getWorkflowName());
			this.baseService.updateEntity(pcr);
			
			// 发站内信给经销商，提报合同审批信息
			User user = (User) SecurityUtil.getPrincipal();
			BaseMessage baseMessage = new BaseMessage();
			baseMessage.setMsgTitle(projInfo.getProjectName()+"提报合同审批信息 ");
			DictionaryData dictmsg= this.baseService.findEntityByID(DictionaryData.class,"msgtype.1");
			baseMessage.setMsgType(dictmsg);
			baseMessage.setSendDate(DateUtil.getSystemDate());
			baseMessage.setFromUser(user);
			baseMessage.setCreateDate(DateUtil.getSystemDateTime());
			baseMessage.setCreator(user);
			baseMessage.setMsgText(projInfo.getProjectName()+"已经完成项目复议，合同号为："+projInfo.getContractNumber()+"，请提报合同审批信息！");
			this.baseService.saveEntity(baseMessage);
			List<User> users = new ArrayList<User>();
			//发站内信给经销商
			if ( null == projInfo.getProjRegistrar())
			{
				users.add(user);
			}else
			{
				users.add(projInfo.getProjRegistrar());
			}
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
			//更新项目表
//		projInfo.setApproveType(pcr.getCreditResultType());
//		projInfo.setApproveDate(pcr.getProjCreditPassTime());
//		projInfo.setApproveConclusion(pcr.getCreditConclusion());
//		projInfo.setProjStatus(Integer.valueOf(pcr.getCreditResultType().getCode()));
			/*=================商务条件 ================= */
			//删除正式表
			this.baseService.removeAllEntites(projInfo.getProjFundRentPlans());
			this.baseService.removeAllEntites(projInfo.getProjCashDetails());
			this.baseService.removeAllEntites(projInfo.getProjFundFundPlans());
			this.baseService.removeEntity(projInfo.getProjCondition());
			//2.1商务条件
			this.baseService.updateOneToOneEntity(projInfo, "projCondition", "projId", variablesMap,null, "framework_condition");
			// 2.2租金计划  
			String json_fund_rent_plan_str = variablesMap.get("json_fund_rent_plan_str");
			this.baseService.updateOneToManyCollections(projInfo, "projFundRentPlans", ProjFundRentPlan.class, "projId", json_fund_rent_plan_str,null);
			// 2.3现金流  
			String json_fund_cash_flow_str = variablesMap.get("json_fund_cash_flow_str");
			this.baseService.updateOneToManyCollections(projInfo, "projCashDetails", ProjCashDetail.class, "projId", json_fund_cash_flow_str,null);
			// 2.4资金收付计划 
			String json_fund_fund_charge_str = variablesMap.get("json_fund_fund_charge_str");
			dictDataClassMapping = new HashMap<String,String>();
			dictDataClassMapping.put("DictionaryData", "code");
			this.baseService.updateOneToManyCollections(projInfo, "projFundFundPlans", ProjFundFundPlan.class, "projId", json_fund_fund_charge_str,dictDataClassMapping);
			
			this.baseService.updateEntity(projInfo);
		
//		conditionDataToHisService.saveProjConditionDataToHis(projInfo.getId(), jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"",
//				"his_proj_change", variablesMap,  "framework_condition",
//				"json_fund_rent_plan_str", null, "json_fund_cash_flow_str", null);
	
	}
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
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
