package com.business.action.leasing.project.credit;

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
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.JBPMWorkflowHistoryInfoUser;
import com.business.entity.User;
import com.business.entity.base.BaseMessage;
import com.business.entity.base.BaseMessageToUser;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjCreditResult;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.service.reckon.ConditionDataToHisService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.UUIDUtil;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-15
 * @info项目信审的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "projCreditEndAction", description = "流程结束动作", workflowName = "项目信审流程")
@Component(value = "projCreditEndAction")
public class ProjCreditEndAction implements JbpmBaseAction {
	@Resource(name="baseService")
	private BaseService baseService;
	@Resource(name = "tableService")
	private TableService tableService;
	@Resource(name="conditionDataToHisService")
	private ConditionDataToHisService  conditionDataToHisService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第三步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.baseService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.baseService.removeEntity(w);
		}
		/** 流程冲突第三步-结束 */
		
		String proj_id = variablesMap.get("proj_info.projid");
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("projId", proj_id);
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		dictDataClassMapping.put("CustInfo", "id");
		 
		//variablesMap.put("proj_info.workFlag", AppStaticUtil.PROJ_APPROVAL.toString());
        // 立项基本表
		ProjInfo projInfo = (ProjInfo)this.baseService.updateMainEntity(ProjInfo.class, queryMainObjectMap, variablesMap,dictDataClassMapping, "proj_info");
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		
		//客户信息
		CustInfo customerInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, variablesMap.get("proj_info.custid"));
		projInfo.setCustId(customerInfo);
		//其它信息
		this.baseService.updateOneToOneEntity(projInfo, "projOtherInfo", "projId", variablesMap,null, "proj_other_info");
		// 商务条件
		this.baseService.updateOneToOneEntity(projInfo, "projCondition", "projId", variablesMap,null, "proj_condition");
		// 租金发票类型
		this.baseService.updateOneToOneEntity(projInfo, "projInvoiceType", "projId", variablesMap,null, "proj_invoice_type");

		// 租赁物明细
		String jsonEquipsString = variablesMap.get("json_proj_equip_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(projInfo, "projEquips", ProjEquip.class, "projId", jsonEquipsString,dictDataClassMapping);
		// 担保单位
		String jsonProjGuaranteeMethodString = variablesMap.get("json_proj_guarantee_method_str");
		this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeMethods", ProjGuaranteeMethod.class, "projId", jsonProjGuaranteeMethodString,dictDataClassMapping);
		//
        Map<String,Object> properMap = new HashMap<String,Object>();
        properMap.put("id", UUIDUtil.getUUID());
      //信审结论
		ProjCreditResult pcr;
		pcr=(ProjCreditResult)this.baseService.updateMainEntity(ProjCreditResult.class, properMap, variablesMap, null, "proj_credit_result");
	    pcr.setProjId(projInfo);
		pcr.setFlowName(jbpmWorkflowHistoryInfo.getWorkflowName());
		this.baseService.updateEntity(pcr);
		//初审记录
//		ProjMeetingRecord pr;
////        Map<String,String> classMap=new  HashMap<String,String>();
////        classMap.put("CustInfo", "id");
//        pr=(ProjMeetingRecord) this.baseService.updateMainEntity(ProjMeetingRecord.class,properMap, variablesMap, null, "proj_meet_record"); 
//        pr.setProjId(projInfo);
//        pr.setFlowName(jbpmWorkflowHistoryInfo.getWorkflowName());
//		this.baseService.updateEntity(pr);
	
//		//审批记录
//		 pr=(ProjMeetingRecord) this.baseService.updateMainEntity(ProjMeetingRecord.class, properMap, variablesMap, classMap, "proj_meet_record1"); 
//	     pr.setProjId(projInfo);
//	     pr.setFlowName(jbpmWorkflowHistoryInfo.getWorkflowName());
//	     this.baseService.updateEntity(pr);
//		//更新项目表
//		projInfo.setApproveType(pcr.getCreditResultType());
//		projInfo.setApproveDate(pcr.getProjCreditPassTime());
//		projInfo.setApproveConclusion(pcr.getCreditConclusion());
//		if(Integer.valueOf(pcr.getCreditResultType().getCode())==AppStaticUtil.PROJ_REPEAT){//走信审
//			
//		}
//		projInfo.setProjStatus(Integer.valueOf(pcr.getCreditResultType().getCode()));
//		System.out.println(Integer.valueOf(pcr.getCreditResultType().getCode())+"信审状态");
		
		//德银新需求，业务合同号在信审结束后生成,信审通过才分配合同号
		String contract_number="";
		if("credit_type_@12".equals(variablesMap.get("proj_info.approvetype"))){
			projInfo.setProjStatus(12);
		}//复议
		if("credit_type_@103".equals(variablesMap.get("proj_info.approvetype"))){
			projInfo.setProjStatus(103);
		}//否决
		if("credit_type_@11".equals(variablesMap.get("proj_info.approvetype"))){
		   if ( "lease_form2".equals(projInfo.getLeasForm().getCode()) )
		   {//加回租判断
			   contract_number = WorkflowUtil.getContractInfoSerialNumberForBussiness2(variablesMap,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());
		   }else
		   {
			   contract_number = WorkflowUtil.getContractInfoSerialNumberForBussiness(variablesMap,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());
		   }
		   projInfo.setContractNumber(contract_number);
		   projInfo.setProjStatus(11);//信审通过
		}
		this.baseService.saveOrUpdateEntity(projInfo);
		//导租金计划
//		conditionDataToHisService.saveProjConditionDataToHis(projInfo.getId(), jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"",
//				"his_proj_change", variablesMap,  "framework_condition",
//				"json_fund_rent_plan_str", "json_finance_rent_plan_str", "json_fund_cash_flow_str", "json_finance_cash_flow_str");
		//发送消息
		User user = (User) SecurityUtil.getPrincipal();
		queryMainObjectMap.clear();
		queryMainObjectMap.put("code", "msgtype.1");
		BaseMessage baseMessage = new BaseMessage();
		BaseMessageToUser toUser = new BaseMessageToUser();
		baseMessage.setMsgTitle(projInfo.getProjectName()+"信审结论");
		baseMessage.setMsgType((DictionaryData)this.baseService.findEntityByProperties(DictionaryData.class, queryMainObjectMap).get(0));
		baseMessage.setSendDate(DateUtil.getSystemDate());
		baseMessage.setFromUser(user);
		baseMessage.setCreateDate(DateUtil.getSystemDateTime());
		baseMessage.setCreator(user);
		String advise = "";
		if (variablesMap.get("processedAdvise")!= null && !"".equals(variablesMap.get("processedAdvise"))) {
			advise = ",信审意见为:" + variablesMap.get("processedAdvise") +";";
		}
		String text="承租客户为:"+projInfo.getCustId().getCustName()+",项目编号为:"+projInfo.getProjId()+ advise +"信审结论为:"+projInfo.getApproveType().getName();
		if("credit_type_@11".equals(variablesMap.get("proj_info.approvetype"))){
		   text+=",合同编号为："+contract_number;
		}
		baseMessage.setMsgText(text);
		this.baseService.saveEntity(baseMessage);
		List<User> users = new ArrayList<User>();
		String sql = "select u.id_  from t_users_deptroles udr "+
				 " left join t_depts_roles  r on udr.deptrole_id_=r.id_ "+
				 " left join t_users u on udr.user_id_=u.id_ "+
				 " where 1=1 " ;
	//个人分析师  编号 role0043
	String sql1conditon = " and r.role_id_='402881824094f54f0140958b5fc50108' and u.code_ <>'cs-ceshi' " ;
	//法人分析师  编号 role0042
	String sql2conditon = " and  r.role_id_='402881824094f54f0140958ae2d80107' " ;
	StringBuffer sqls = new StringBuffer();
	sqls.append(sql);
			
	//判断是法人还是自然人
	Map<String, Object> proMap = new HashMap<String, Object>();
	proMap.put("id",projInfo.getCustId().getId());
	List<CustInfo> listInfos = this.baseService.findEntityByProperties( CustInfo.class, proMap );
	String custTypes = null;    User nUser = null;
	if ( listInfos.size() > 0 ) 
	{
		  custTypes = listInfos.get(0).getCustClass().getCode();
	}
	//发站内信给经销商 \个人法人分析师       
//	if( projInfo.getProjRegistrar().getId().equals(projInfo.getProjAssist().getId()) ){
//	}else{
//		users.add(projInfo.getProjRegistrar());
//		users.add(projInfo.getProjAssist());
//	}//协办字段已取掉了此处不做判断
	     String dealeruname = projInfo.getDealeruname();
	     if(dealeruname!=null){
	    	 Map<String, Object> propertiesMap = new HashMap<String,Object>();
	    	 propertiesMap.put("username",dealeruname);
	    	 List<User> listus = this.tableService.findEntityByProperties(User.class, propertiesMap);
	    	 if(listus.size()>0){
	    		 users.add(listus.get(0));
	    	 }else{
	    		 users.add(projInfo.getProjRegistrar());
	    	 }
	     }else{
	    	 users.add(projInfo.getProjRegistrar());
	     }
		if ( "CUST_INFO_COMPANY".equalsIgnoreCase(custTypes) && custTypes != null ) {//判断法人和自然人
			String sql2 = String.valueOf(sqls.append(sql2conditon));
			List<Map<String,Object>> fx = this.baseService.queryListBySql(sql2,null);
			if ( fx.size() > 0 ) 
			{
				for( Map<String,Object> map : fx )
				{
					for( Map.Entry<String,Object> e : map.entrySet() )
					{
						  nUser = this.baseService.findEntityByID( User.class,String.valueOf(e.getValue()) );
						  users.add( nUser ); 
					}
				}
			}
		}else{
			String sql1 = String.valueOf(sqls.append(sql1conditon));
			List<Map<String,Object>> ux = this.baseService.queryListBySql(sql1,null);//走自然人
			if ( ux.size() > 0 ) 
			{
				for( Map<String,Object> map : ux )
				{
					for( Map.Entry<String,Object> e : map.entrySet() )
					{
						  nUser = this.baseService.findEntityByID( User.class,String.valueOf(e.getValue()) );
						  users.add( nUser ); 
					}
				}
			}
		}
	
		//发站内信给业务企划
		Map<String,String> queryMap = new HashMap<String,String>();
		queryMap.put("proj_info.custdealer", projInfo.getCustDealer().getId());
		if (projInfo.getCustDealer()!=null) {// 发送信息
			variablesMap.put("proj_credit_users_str", this.tableService.getJsonArrayData("eleasing/workflow/public/projCreditGetMessageUsers.xml", queryMap).toString());
			JSONArray jsonArray = new JSONArray(variablesMap.get("proj_credit_users_str"));
			for(int i=0;i<jsonArray.length();i++){
				  JSONObject jsonObj = jsonArray.getJSONObject(i);
				  users.add(this.tableService.findEntityByID(User.class,jsonObj.get("userid").toString()));
			}
		}
		
		//发站内信给信用分析师
		/*for(JBPMWorkflowHistoryInfo currentJbpmWorkflowHistoryInfo : jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getJbpmWorkflowHistoryInfos()){
 			if(null != currentJbpmWorkflowHistoryInfo.getHistoryTaskInstanceImpl()){
 				if("01信用分析师发起".equals(currentJbpmWorkflowHistoryInfo.getActivityDetail().getActivityName())){
 					for(JBPMWorkflowHistoryInfoUser jbpmWorkflowHistoryInfoUser : currentJbpmWorkflowHistoryInfo.getJbpmWorkflowHistoryInfoUsers()){
 						String endTime  = jbpmWorkflowHistoryInfoUser.getEndTime();//有结束时间证明已经处理
 						if(null != endTime){
 							String actualActor = jbpmWorkflowHistoryInfoUser.getActualActor().getId();//实际处理人
 	 						String planActor   = jbpmWorkflowHistoryInfoUser.getPlanActor().getId();//计划处理人
 	 						if(!actualActor.equals(planActor)){//委托人处理的事情
 	 							//可以同时发给两个人
 	 							users.add(this.tableService.findEntityByID(User.class, planActor));
 	 						}
 	 						else{//同一个人，没有委托他人处理
 	 							//同一个人
 	 							users.add(this.tableService.findEntityByID(User.class, planActor));
 	 						}
 						}
 					}
 					break;
 	 			}
 			}
 		
 		}*/
		//给所有信用分析师发站内信
		/*String rolename="";
		if("法人".equals(variablesMap.get("proj_info.cust_type"))){
			rolename="法人客户信用分析师";
		}else{//自然人
			rolename="个人客户信用分析师";
		}
		List<User> actorsList = new ArrayList<User>();
		String hsql = "select u from User u left join u.userDeptRoles udr left join udr.deptRole dr where dr.role.name=:ids";
		actorsList = baseService.findResultsByNamedParamHSQL(hsql, new String[] { "ids" },new Object[]{rolename});
		users.addAll(actorsList);*/
		
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
	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
