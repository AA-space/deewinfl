

 /**
 * 项目名称：    系统名称
 * 包名：              com.business.controller
 * 文件名：         JbpmController.java
 * 版本信息：    1.0.0
 * 创建日期：     2012-10-23-下午04:47:46
 * Copyright：2012XX公司-版权所有
 **/

package com.business.controller;


import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.jbpm.api.Deployment;
import org.jbpm.api.RepositoryService;
import org.jbpm.pvm.internal.history.model.HistoryProcessInstanceImpl;
import org.jbpm.pvm.internal.repository.DeploymentImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.entity.ActivityDetail;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.JbpmWorkflowDesigner;
import com.business.entity.User;
import com.business.exception.BusinessException;
import com.business.exception.JbpmException;
import com.business.model.InitiatorEnum;
import com.business.model.JdbcModel;
import com.business.service.JbpmService;
import com.jbpm.utils.JBPMUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.RemoteUtil;
import com.kernal.utils.StringUtil;
import com.kernal.utils.WebUtil;


 /**
 * 类名称：     JbpmController
 * 类描述：     
 * 创建人：     tracywindy
 * 修改人：     tracywindy
 * 修改时间：2012-10-23 下午04:47:46
 * 修改备注：
 * @version 1.0.0
 **/
@Controller(value="jbpmController")
@RequestMapping(value="/**/jbpm")
public class JbpmController extends BaseController {
   @Resource(name="jbpmService")
   private JbpmService jbpmService ;
   
   @RequestMapping(value="/getWorkflowInfo.action")
   public String getWorkflowInfo(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   String jhiCompletedTaskImplId = request.getParameter("jhiCompletedTaskImplId");
	   String historyProcessInstanceImplDbid = request.getParameter("historyProcessInstanceImplDbid");
	   String infoFlag = request.getParameter("infoFlag");
	   String toPage = "";
	   try {
		if(("advise".equals(infoFlag))){
			   //意见信息列表
			   request.setAttribute("processedHistoryLogInfoList",this.jbpmService.getProcessedHistoryLogInfoList(historyProcessInstanceImplDbid) );
			   toPage = "getWorkflowAdviseDetail.jsp";
		   }
		   else if(("history".equals(infoFlag))){
			   //历史信息列表
			   request.setAttribute("processedHistoryLogInfoList",this.jbpmService.getProcessedHistoryLogInfoList(historyProcessInstanceImplDbid) );
			   toPage = "getWorkflowHistoryWindow.jsp";
		   }
		   else if(("next".equals(infoFlag))){
			   //下一步list
			   request.setAttribute("next_activityTaskUsersList", this.jbpmService.getNextActivityTaskUsersList(request,jhiCompletedTaskImplId));
			   toPage = "getWorkflowNextActivityTaskUsersWindow.jsp";
		   }
		   else if(("back".equals(infoFlag))){
			   //回退list 
			   request.setAttribute("back_activityTaskUsersList", this.jbpmService.getBackActivityTaskUsersList(request,jhiCompletedTaskImplId));
			   toPage = "getWorkflowBackActivityTaskUsersWindow.jsp";
		   }
		   else if(("all".equals(infoFlag))){
			   //任意路由
			   request.setAttribute("all_activityTaskUsersList", this.jbpmService.getAllActivityTaskUsersList(request,jhiCompletedTaskImplId));
			   toPage = "getWorkflowAllActivityTaskUsersWindow.jsp";
		   }
	}catch (JbpmException je) {
		String ajaxCallBackScript = "javascript:window.top.alert('"+je.getMessage()+"');if(window.top.loadMask)window.top.loadMask.hide();window.top.jQuery('#id_loadMaskContainer').hide();";
		this.ajaxReturn(response, ajaxCallBackScript);
		return null;
	} 
	 catch (Exception e) {
		e.printStackTrace();
	 }
     return "solutions/workflow/jbpm-core/"+toPage;
   }
   @RequestMapping(value="/getDesignerSavedDiagramInfo.action")
   public String getDesignerSavedDiagramInfo(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String designerId     = modelData.get("id");
	   String workflow_name  = modelData.get("workflow_name");
	   String workflow_designerWorkflowJsonString = "{}";
	   JbpmWorkflowDesigner jbpmWorkflowDesigner = null;
	   String attachParam = "";
	   if(null != designerId){
		   jbpmWorkflowDesigner = this.jbpmService.findEntityByID(JbpmWorkflowDesigner.class, designerId);
	   }else{
		   String hsql = "from JbpmWorkflowDesigner jwfd where jwfd.workflowName = ? ";
		   List<JbpmWorkflowDesigner> queryList = this.jbpmService.findResultsByHSQL(hsql, workflow_name);
		   if(0 < queryList.size()){
			   jbpmWorkflowDesigner = queryList.get(0);
		   }
	   }
	   if(null != jbpmWorkflowDesigner){
		   workflow_designerWorkflowJsonString = jbpmWorkflowDesigner.getDesignerWorkflowJson();
		   attachParam+="?id="+jbpmWorkflowDesigner.getId();
		   request.setAttribute("maxDotX",jbpmWorkflowDesigner.getMaxDotX());
		   request.setAttribute("maxDotY",jbpmWorkflowDesigner.getMaxDotY());
	   }
	   request.setAttribute("workflow_designerWorkflowJsonString", workflow_designerWorkflowJsonString);
	   return "solutions/workflow/jbpm-designer/jbpm4-4-designer.jsp"+attachParam;
   }
   @RequestMapping(value="/getProjSummaryHistoryInfos.action")
   public String getProjSummaryHistoryInfos(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String keyOne     = modelData.get("keyOne");
	   String proj_id    = modelData.get("proj_id");
	   List<JBPMWorkflowHistoryInfo> projSummaryHistoryInfos = this.jbpmService.getProjSummary(keyOne,proj_id);
	   request.setAttribute("projSummaryHistoryInfos", projSummaryHistoryInfos);
	   return "solutions/workflow/jbpm-core/projSummary.jsp";
   }
   @RequestMapping(value="/getDealerSummaryHistoryInfos.action")
   public String getDealerSummaryHistoryInfos(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String keyFive     = modelData.get("keyFive");
	   List<JBPMWorkflowHistoryInfo> dealerSummaryHistoryInfos = this.jbpmService.getDealerSummary(keyFive);
	   request.setAttribute("projSummaryHistoryInfos", dealerSummaryHistoryInfos);
	   return "solutions/workflow/jbpm-core/projSummary.jsp";
   }
@RequestMapping(value="/getNodeConfigInfo.action")
   public String getNodeConfigInfo(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String workflowDefinition = modelData.get("workflowDefinition");
	   String nodeType           = modelData.get("nodeType");
	   String nodeName           = modelData.get("nodeName");
	   String returnInfo = nodeType+" ，"+nodeName;
	   if(!"task".equalsIgnoreCase(nodeType)){
	   }else{
		       returnInfo = "节点名称：<font color='red'>"+nodeName+"</font>";
			   String processInstanceId  = URLDecoder.decode(modelData.get("processInstanceId"),"UTF-8");
			   Map<String,Object> propertiesMap = new HashMap<String,Object>();
			   JbpmWorkflowDesigner  jbpmWorkflowDesigner =  null;
			   DeploymentImpl  deploymentImpl =  null;
			   HistoryProcessInstanceImpl historyProcessInstanceImpl = null;
		
			   if(!"-1".equals(processInstanceId)){
				   propertiesMap.put("processInstanceId", processInstanceId);
				   historyProcessInstanceImpl = this.jbpmService.findEntityByProperties(HistoryProcessInstanceImpl.class, propertiesMap).get(0);
				   workflowDefinition         = historyProcessInstanceImpl.getProcessDefinitionId();
				   propertiesMap.clear();
				   propertiesMap.put("workflowDefinition", workflowDefinition);
				   jbpmWorkflowDesigner = this.jbpmService.findEntityByProperties(JbpmWorkflowDesigner.class, propertiesMap).get(0);
				   deploymentImpl = jbpmWorkflowDesigner.getDeploymentImpl();
			   }else{
				    String deployId =  modelData.get("deployId");
					if(deployId.matches("^\\d+$"))
					{
						RepositoryService repositoryService = JBPMUtil.getRepositoryService();
						List<Deployment> l = repositoryService.createDeploymentQuery().deploymentId(deployId).list();
						if(l.size()>0){
							deploymentImpl  = (DeploymentImpl)l.get(0);
							jbpmWorkflowDesigner = deploymentImpl.getJbpmWorkflowDesigner();
						}
					}
					else
					{
						jbpmWorkflowDesigner = (JbpmWorkflowDesigner)this.jbpmService.findEntityByID(JbpmWorkflowDesigner.class, deployId);
						deploymentImpl = jbpmWorkflowDesigner.getDeploymentImpl();
					}
			   }
			  
			   if(null != deploymentImpl){
				   String hsql = "from ActivityDetail ad where ad.deploymentImpl.id = ? and ad.activityType = ? and activityName = ?";
				   List<ActivityDetail> curentActivityList = this.jbpmService.findResultsByHSQL(hsql,deploymentImpl.getDbid(),nodeType,nodeName);
				   if(0 ==  curentActivityList.size()){
					   returnInfo = "<font color='red'>节点配置信息不存在！</font>";
					   this.output(response, returnInfo);
					   return null;
				   }
				   ActivityDetail curentActivity =  (ActivityDetail)curentActivityList.get(0);
				   String actorType = curentActivity.getActorType();
				   String actorValue = curentActivity.getActorValue();
				   String actorTypeChinese = InitiatorEnum.valueOf(actorType.toUpperCase()).getChineseName();
				   String displayActorValue = curentActivity.getDisplayActorValue();
				   returnInfo = (returnInfo+"<br/>参与人类型：<font color='red'>"+actorTypeChinese+"</font><br/>参与人设定值：<font color='red'>"+StringUtil.empty2Other(StringUtil.empty2Other(displayActorValue, actorValue),"无指定"))+"</font>";
				   String jbpmWorkflowHistoryInfoUserId = StringUtil.nullToString(request.getParameter("jbpmWorkflowHistoryInfoUserId"));
				   if((!"-1".equals(processInstanceId))&&!((jbpmWorkflowHistoryInfoUserId.isEmpty())&&("submitRelation".equals(actorType)))){
					  String processInstanceDBID = ""+historyProcessInstanceImpl.getDbid();
					  modelData.putAll(JBPMUtil.getProcessInstanceHistoryData(this.jbpmService.getBussinessDao().getHibernateTemplate(), processInstanceDBID));
					  List<User> actors = JBPMUtil.getActorsListByActivitySetting(request,curentActivity, processInstanceId, actorType, actorValue, modelData, this.jbpmService, "actor");
				      StringBuffer sbString = new StringBuffer(returnInfo+"<br/>解析的人员列表：<font color='red'>");
				      int index = 0;
					  for(User actor : actors){
						  if(index++>0){
							  sbString.append(" ");
						  }
						  sbString.append(actor.getRealname()+"（"+actor.getUsername()+"）");
				      }
					  sbString.append("</font>");
					  returnInfo = sbString.toString();
				   }
			   }
	   }
	   this.output(response, returnInfo);
	   return null;
   }
   @SuppressWarnings("unchecked")
   @RequestMapping(value="/updateSerialNoSql.action")
   public String testHibernateEntityFlush(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   HibernateTemplate hibernateTemplate = (HibernateTemplate)WebUtil.getApplicationContext().getBean("hibernateTemplate");
	   DetachedCriteria criteria = DetachedCriteria.forClass(JBPMWorkflowHistoryInfo.class);
	   List<JBPMWorkflowHistoryInfo> infos = (List<JBPMWorkflowHistoryInfo>)hibernateTemplate.findByCriteria(criteria);
	   final FileOutputStream fos = new FileOutputStream(WebUtil.getWebContextRealPath()+"updateSerialNoSql.sql");
	   for(JBPMWorkflowHistoryInfo info : infos){
		   String processInstanceDBID = info.getHistoryProcessInstanceImpl().getDbid()+"";
		       Map<String,String> m = new HashMap<String,String>();
		       JBPMUtil.getVariablesInfo(hibernateTemplate, processInstanceDBID, null,m);
		       String updateSql = ("update t_jbpm_workflow_info set key_one_='"+m.get("SerialNo")+"' where id_ = '"+info.getId()+"';");
		       fos.write(updateSql.getBytes());
		       fos.write(System.getProperty("line.separator").getBytes());
	   }
	   fos.close();
	   this.output(response,"生成成功");
	   return null;
	}
   
   @RequestMapping(value="/getWorkflowActions.action")
   public String getWorkflowActions(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String paramWorkflowName     = modelData.get("paramWorkflowName");
	   this.output(response, "{datas:"+this.jbpmService.getWorkflowActions(paramWorkflowName)+"}");
	   return null;
   }
   @RequestMapping(value="/getWorkflowRejectBeanNames.action")
   public String getWorkflowRejectBeanNames(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   /*Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String sourceWorkflowName     = modelData.get("sourceWorkflowName");
	   String rejectWorkflowName     = modelData.get("rejectWorkflowName");*/
	   this.output(response, this.jbpmService.getWorkflowRejectBeanName(false,null,null).toString());
	   return null;
   }
   @RequestMapping(value="/removeWorkflowAllProcessInstance.action")
   public String removeWorkflowAllProcessInstance(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String workflowName     = modelData.get("paramWorkflowName");
	   int    version          = Integer.parseInt(modelData.get("paramWorkflowVersion"));
	   this.jbpmService.removeWorkflowAllProcessInstance(request,workflowName, version);
	   return null;
   }
   
   @RequestMapping(value="/saveKeyToWorkflow.action")
   public String saveKeyToWorkflow(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String designerId         = modelData.get("designerId");
	   String keyOne = modelData.get("keyOne");
	   String keyTwo  = modelData.get("keyTwo");
	   String keyThree  = modelData.get("keyThree");
	   String keyFour  = modelData.get("keyFour");
	   String keyFive  = modelData.get("keyFive");
	   String keySix  = modelData.get("keySix");
	   String keySeven  = modelData.get("keySeven");
	   String keyEight  = modelData.get("keyEight");
	   String keyNine  = modelData.get("keyNine");
	   String keyTen  = modelData.get("keyTen");
	   
	   this.jbpmService.saveKeyToWorkflow(designerId, keyOne, keyTwo, keyThree, keyFour, keyFive, keySix, keySeven, keyEight, keyNine, keyTen);
	   return null;
   }
   @RequestMapping(value="/delegateSingleWorkflow.action")
   public String delegateSingleWorkflow(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String id          = modelData.get("id");
	   String deploymentId = modelData.get("deploymentId");
	   String delegateUserId  = modelData.get("delegateUserId");
	   String startDate  = modelData.get("startDate");
	   String endDate  = modelData.get("endDate");
	   String grantMethod  = modelData.get("grantMethod");
	   this.jbpmService.delegateSingleWorkflow(id, deploymentId, delegateUserId, startDate, endDate, grantMethod);
	   return null;
   }
   @RequestMapping(value="/delegateCheckedWorkflows.action")
   public String delegateCheckedWorkflows(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String delegateUserId  = modelData.get("delegateUserId");
	   String startDate  = modelData.get("startDate");
	   String endDate  = modelData.get("endDate");
	   String grantMethod  = modelData.get("grantMethod");
	   String checkedIds  = modelData.get("checkedIds");
	   String checkedDeploymentIds  = modelData.get("checkedDeploymentIds");
	   this.jbpmService.delegateCheckedWorkflows(checkedIds, checkedDeploymentIds, delegateUserId, startDate, endDate, grantMethod);
	   return null;
   }
   @RequestMapping(value="/delegateAllWorkflows.action")
   public String delegateAllWorkflows(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String delegateUserId  = modelData.get("delegateUserId");
	   String startDate  = modelData.get("startDate");
	   String endDate  = modelData.get("endDate");
	   String grantMethod  = modelData.get("grantMethod");
	   this.jbpmService.delegateAllWorkflows(delegateUserId, startDate, endDate, grantMethod);
	   return null;
   }
   @RequestMapping(value="/removeSingleDelegatedWorkflow.action")
   public String removeSingleDelegatedWorkflow(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = modelData.get("id");
	   this.jbpmService.removeSingleDelegatedWorkflow(id);
	   return null;
   }
   @RequestMapping(value="/removeCheckedDelegatedWorkflows.action")
   public String removeCheckedDelegatedWorkflows(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String checkedIds = modelData.get("checkedIds");
	   this.jbpmService.removeCheckedDelegatedWorkflows(checkedIds);
	   return null;
   }
   @RequestMapping(value="/removeAllDelegatedWorkflows.action")
   public String removeAllDelegatedWorkflows(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   this.jbpmService.removeAllDelegatedWorkflows();
	   return null;
   }
   @RequestMapping(value="/removeDesignedWorkflow.action")
   public String removeDesignedWorkflow(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   String designedId = QueryUtil.getRequestParameterMapByAjax(request).get("designedId");
	   this.jbpmService.removeDesignedWorkflow(designedId);
	   return null;
   }
   @RequestMapping(value="/workflowSynchronized.action")
   public String workflowSynchronized(HttpServletRequest request,HttpServletResponse response) throws Exception{
	  String deployId = QueryUtil.getRequestParameterMapByAjax(request).get("deployId");
	  String returnInfo = "流程同步成功";
	  Locale locale = WebUtil.getSessionLocale();
	  try{
		  this.jbpmService.updateWorkflowSynchronized(deployId,locale);
	  }catch(Exception e){
		  e.printStackTrace();
		  returnInfo = e.getMessage();
	  }
	  this.output(response, returnInfo) ;
	  RemoteUtil.remoteWorkflowSynchronized(deployId);
	  return null;
   }
   @RequestMapping(value="/transferedJpdlXmlByWorkflowDesigner.action")
   public String transferedJpdlXmlByWorkflowDesigner(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String returnInfo = "保存成功";
	   try 
	   {
		  String id = this.jbpmService.transferedJpdlXmlByWorkflowDesigner(modelData);
		  returnInfo = "保存成功,"+id;
	   } 
	   catch (Exception e) 
	   {
			e.printStackTrace();
			returnInfo = e.getMessage();
	   }
	   this.output(response,returnInfo);
	   return null;
   }
   
   @RequestMapping(value="/queryDeployedWorkflows.action")
   public String queryDeployedWorkflows(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   request.setAttribute("deployedWorkflows", this.jbpmService.queryDeployedWorkflows());
	   return "solutions/workflow/jbpm-core/listProcessDefinitions.jsp";
   }
   @RequestMapping(value="/deployWorkflow.action")
   public String deployWorkflow(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   String designedId = QueryUtil.getRequestParameterMapByAjax(request).get("designedId");
	   this.jbpmService.deployWorkflow(designedId);
	   return null;
   }
   @RequestMapping(value="/removeDeployedWorkflow.action")
   public String removeDeployedWorkflow(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String deployId = modelData.get("deployId");
	   String designedId = modelData.get("designedId");
	   this.jbpmService.removeDeployedWorkflow(designedId,Long.parseLong(deployId));
	   return null;
   }
   @RequestMapping(value="/getDeployedWorkflowDiagram.action")
   public String getDeployedWorkflowDiagram(HttpServletRequest request,HttpServletResponse response) throws Exception{
	    String deployId = QueryUtil.getRequestParameterMapByAjax(request).get("deployId");
	    byte[] workflowPictureByteData = this.jbpmService.getDeployedWorkflowDiagramDatas(deployId);
	    ServletOutputStream sos = response.getOutputStream();
	    sos.write(workflowPictureByteData, 0, workflowPictureByteData.length);
		sos.flush();
		sos.close();
	   return null;
   }
   @RequestMapping(value="/getActivedRects.action")
   public String getActivedRects(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String processInstanceId = modelData.get("processInstanceId");
	   String deployId = modelData.get("deployId");
	   Map<String,String> map = this.jbpmService.getActivedRects(deployId,processInstanceId);
	   this.setAllKeyToRequestAttributeByMap(request, map);
	   String toPage = "";
	   String jpdlVersion = map.get("jpdlVersion");
	   if("4.4".equals(jpdlVersion))
	   {
		   toPage = "solutions/workflow/jbpm-designer/jbpm4-4-diagram.jsp";
	   }
	   else if("4.3".equals(jpdlVersion))
	   {
		   toPage = "solutions/workflow/jbpm-designer/jbpm4-3-diagram.jsp";
	   }
	   return toPage;
   }
   @RequestMapping(value="/getActivityCoordinates.action")
   public String getActivityCoordinates(HttpServletRequest request,HttpServletResponse response) throws Exception{
	   String processInstanceId = QueryUtil.getRequestParameterMapByAjax(request).get("processInstanceId");
	   request.setAttribute("activityCoordinatesList", this.jbpmService.getActivityCoordinates(processInstanceId));
	   return "solutions/workflow/jbpm-core/activePicture.jsp";
   }
   @RequestMapping(value="/saveChangeToActivity.action")
   public String saveChangeToActivity(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String id = model.get("id");
	   this.jbpmService.saveChangeToActivity(id,model);
	   return null;
   }
   @RequestMapping(value="/startDeployedProcess.action")
   public String startDeployedProcess(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
	   String processDefinitionId = model.get("processDefinitionId");
	   if(null == processDefinitionId)return null;
	   String reuturnInfo = "<script type='text/javascript'>" +
		   		/*"window.opener.rejectWindowDiv = window.opener.document.getElementById('id_rejectWindowDiv');" +
		  		"if(!window.opener.rejectLoadMask)try{window.opener.rejectLoadMask = new window.opener.tracywindyLoadMask(window.opener.document.body,'');}catch(e){}" +
		   		"if(!window.opener.rejectWindowDiv ){" +
		   		"window.opener.rejectWindowDiv  = window.opener.document.createElement('div');" +
		   		"window.opener.rejectWindowDiv.id='id_rejectWindowDiv';" +
		   		"window.opener.rejectWindowDiv.style.position='absolute';" +
		   		"window.opener.rejectWindowDiv.style.top='20%';" +
		   		"window.opener.rejectWindowDiv.style.left='40%';" +
		   		"window.opener.rejectWindowDiv.style.lineHeight='40px';" +
		   		"window.opener.rejectWindowDiv.style.border='1px solid #DDD';" +
		   		"window.opener.rejectWindowDiv.style.width='200px';" +
		   		"window.opener.rejectWindowDiv.style.padding='10px';" +
		   		"window.opener.rejectWindowDiv.style.height='100px';" +
		   		"window.opener.rejectWindowDiv.style.background='#FFFFFF';" +
		   		"window.opener.rejectWindowDiv.style.zIndex=10000000;" +
		   		"window.opener.rejectWindowDiv.style.overflow='auto';" +
		   		"window.opener.document.body.appendChild(window.opener.rejectWindowDiv );" +
		   		"}" +*/
		   		"if(window.opener.rejectLoadMask)window.opener.rejectLoadMask.show();" +
		   		"if(window.opener.rejectWindowDiv){window.opener.rejectWindowDiv.style.display='block';" +
		   		"window.opener.rejectWindowDiv.innerHTML=('已经发起的冲突流程：<a href=\"javascript:void(0);\" class=\"btn btn-primary\" onclick=\"this.parentNode.style.display=&quot;none&quot;;if(window.rejectLoadMask)window.rejectLoadMask.hide();\">关闭</a>" +
		   		"<div style=\"color:red;padding-top:4px;text-indent:20px;\">{0}</div>');"
		   		+";window.opener=null;window.open('','_self');window.close();}</script>";
	   String formPath = "";	   
	   try{
	     formPath = this.jbpmService.startDeployedProcess(request, processDefinitionId, model);
	   }catch(BusinessException be)
	   {
		   formPath = ""+be.getMessage();
		   this.ajaxReturn(response, reuturnInfo.replace("已经发起的冲突流程：", "").replace("{0}", formPath));
	       return null;
	   }
	   if(StringUtil.nullToString(formPath).startsWith("@@_@@WORKFLOWREJECTED:")){
		   this.ajaxReturn(response, reuturnInfo.replace("{0}", formPath.substring("@@_@@WORKFLOWREJECTED:".length())));
	       return null;
	   }
	   this.setAllKeyToRequestAttributeByMap(request, model);
	   model.put("requestFormPath", formPath);
	   String returnFormPath = "solutions/workflow/jbpm-core/commonWorkflow.jsp";
	   this.setAllKeyToRequestAttributeByMap(request, model);
	   return returnFormPath;
   }
   @RequestMapping(value="/requestProcessTaskForm.action")
   public String requestProcessTaskForm(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
	   String currentTaskId = modelData.get("currentTaskId");
	   
	   String formPath = "";
		try
		{
			formPath = this.jbpmService.updateRequestProcessTaskForm(request, currentTaskId, modelData);
		}catch(Exception e)
		{
			e.printStackTrace();
			String ajaxCallBackScript = "<script type='text/javascript'>alert('该任务已被处理！');window.close();</script>";
			this.ajaxReturn(response, ajaxCallBackScript);
			return null;
		}
	   modelData.put("requestFormPath", formPath);
	   String returnFormPath = "solutions/workflow/jbpm-core/commonWorkflow.jsp";
	   this.setAllKeyToRequestAttributeByMap(request, modelData);
	   return returnFormPath;
   }
   @RequestMapping(value="/preivewProcessTaskForm.action")
   public String preivewProcessTaskForm(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
	   modelData.put("isViewHistoryTask","true");
	   modelData.put("isCompletedTask","true");
	   modelData.put("isPreivewTask","true");
	   String currentTaskId = modelData.get("currentTaskId");
	   
	   String formPath = "";
	   try
	   {
		   formPath = this.jbpmService.updateRequestProcessTaskForm(request, currentTaskId, modelData);
	   }catch(Exception e)
	   {
		   e.printStackTrace();
		   String ajaxCallBackScript = "<script type='text/javascript'>alert('该任务已被处理！');window.close();</script>";
		   this.ajaxReturn(response, ajaxCallBackScript);
		   return null;
	   }
	   modelData.put("requestFormPath", formPath);
	   String returnFormPath = "solutions/workflow/jbpm-core/commonWorkflowPrint.jsp";
	   this.setAllKeyToRequestAttributeByMap(request, modelData);
	   return returnFormPath;
   }
   @RequestMapping(value="/viewHistoryProcessForm.action")
   public String viewHistoryProcessForm(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
	   modelData.put("isViewHistoryTask","true");
	   modelData.put("isCompletedTask","true");
	   String currentTaskId = modelData.get("currentTaskId");
	   
	   String formPath = "";
	   try
	   {
		   formPath = this.jbpmService.updateRequestProcessTaskForm(request, currentTaskId, modelData);
	   }catch(Exception e)
	   {
		   e.printStackTrace();
		   String ajaxCallBackScript = "<script type='text/javascript'>alert('该任务已被处理！');window.close();</script>";
		   this.ajaxReturn(response, ajaxCallBackScript);
		   return null;
	   }
	   modelData.put("requestFormPath", formPath);
	   String returnFormPath = "solutions/workflow/jbpm-core/commonWorkflow.jsp";
	   this.setAllKeyToRequestAttributeByMap(request, modelData);
	   return returnFormPath;
   }
   @RequestMapping(value="/submitProcessedForm.action")
   public String submitProcessedForm(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	    Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
	    String currentTaskId = modelData.get("currentTaskId");
		String returnResult = "";
		String ajaxCallBackScript = "";
		try
		{
			returnResult = this.jbpmService.submitProcessedTaskForm(request,currentTaskId, modelData);
			ajaxCallBackScript = "<script type='text/javascript'>window.top.ajaxCallBack('"+returnResult+"',false);if(window.top.loadMask)window.top.loadMask.hide();window.top.jQuery('#id_loadMaskContainer').hide();</script>";
			if("true".equalsIgnoreCase(modelData.get("assignmentIsSilentModel"))){
				ajaxCallBackScript = "<script type='text/javascript'>window.top.ajaxCallBack('"+returnResult+"',true);if(window.top.loadMask)window.top.loadMask.hide();window.top.jQuery('#id_loadMaskContainer').hide();</script>";
			}
			this.ajaxReturn(response, ajaxCallBackScript);
			return null;
		}	
		catch(BusinessException be)
		{
			ajaxCallBackScript = be.getMessage();
		}
		catch(JbpmException je)
		{
			ajaxCallBackScript = je.getMessage();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ajaxCallBackScript = e.getMessage();
		}
		ajaxCallBackScript = "<script type='text/javascript'>window.top.alert('"+ajaxCallBackScript+"');if(window.top.loadMask)window.top.loadMask.hide();window.top.jQuery('#id_loadMaskContainer').hide();</script>";
		this.ajaxReturn(response, ajaxCallBackScript);
		return null;
   }
   @RequestMapping(value="/removeReadPersonToTask.action")
   public String removeReadPersonToTask(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String readedAdvise =  modelData.get("processedAdvise");
	   String jbpmWorkflowHistoryInfoId =  modelData.get("jbpmWorkflowHistoryInfoId");
	   this.jbpmService.removeReadPersonToTask(jbpmWorkflowHistoryInfoId, readedAdvise);
	   return null;
   }
   @RequestMapping(value="/removeSignaturePersonToTask.action")
   public String removeSignaturePersonToTask(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String signaturedAdvise =  modelData.get("processedAdvise");
	   String jbpmWorkflowHistoryInfoId =  modelData.get("jbpmWorkflowHistoryInfoId");
	   this.jbpmService.removeSignaturePersonToTask(jbpmWorkflowHistoryInfoId, signaturedAdvise);
	   return null;
   }
   @RequestMapping(value="/removeProcessInstance.action")
   public String removeProcessInstance(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   
	   String processInstanceDBIDs = modelData.get("processInstanceDBID");
	   for(String processInstanceDBID : processInstanceDBIDs.split(",")){
		   this.jbpmService.removeProcessInstance(request, processInstanceDBID);
	   }
	   return null;
   }
   @RequestMapping(value="/getAuthDesignedWorkflowList.action")
   public String getAuthDesignedWorkflowList(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	  // Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   //request.setAttribute("authDesignedWorkflowList", this.jbpmService.getAuthDesignedWorkflowList(modelData,false));
	   request.setAttribute("authDesignedWorkflowList", this.jbpmService.findEntities(JbpmWorkflowDesigner.class));
	   return "solutions/workflow/jbpm-core/authDesignedWorkflowRequest.jsp";
   }
   @RequestMapping(value="/getAuthViewDesignedWorkflowList.action")
   public String getViewAuthDesignedWorkflowList(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   request.setAttribute("authViewDesignedWorkflowList", this.jbpmService.getAuthDesignedWorkflowList(modelData,true));
	   return "solutions/workflow/jbpm-core/authViewDesignedWorkflowRequest.jsp";
   }
   
   @RequestMapping(value="/getAuthWorkflowJson.action")
   public String getAuthDesignedWorkflowJson(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   request.setAttribute("authDesignedWorkflowList", this.jbpmService.getAuthDesignedWorkflowList(modelData,false));
	   return "solutions/workflow/jbpm-core/authWorkflowJson.jsp";
   }
   @RequestMapping(value="/updateWorkflowConfigSynchronized.action")
   public String updateWorkflowConfigSynchronized(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Locale locale = WebUtil.getSessionLocale();
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String type = modelData.get("type");
	   String host = modelData.get("host");
	   String port = modelData.get("port");
	   String dbname = modelData.get("dbname");
	   String user = modelData.get("user");
	   String password = modelData.get("password");
	   String updateWorkflowIds = modelData.get("updateWorkflowIds");
	   this.jbpmService.updateWorkflowConfigSynchronized(type, host, port, dbname, user, password, updateWorkflowIds,locale);
	   return null;
   }
   @RequestMapping(value="/updatePendingUserToOther.action")
   public String updatePendingUserToOther(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
	   int changePlanUserFlag               = Integer.parseInt(modelData.get("changeplanuserflag"));
	   String jbpmWorkflowHistoryInfoUserId = modelData.get("actorid");
	   String taskType 						= modelData.get("tasktype");
	   String planUserId                    = modelData.get("planuserid");
	   String changeToUserId                = modelData.get("changetouserid");
	   String returnInfo = this.jbpmService.updatePendingUserToOther(changePlanUserFlag,taskType, jbpmWorkflowHistoryInfoUserId, planUserId, changeToUserId);
	   String ajaxCallBackScript = "<script type='text/javascript'>window.parent.submitCallBack('"+returnInfo+"')</script>";
	   this.ajaxReturn(response, ajaxCallBackScript);
	   return null;
   }
   @RequestMapping(value="/getDeployedWorkflowsTreeData.action")
   public String getDeployedWorkflowsTreeData(HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String init  = modelData.get("init");
	   JSONArray jsonArr = new JSONArray();
	   if(null != init){
		   String hsql = " select distinct jt from JbpmWorkflowDesigner jd left join jd.type jt order by jt.position";
		   List<DictionaryData>  workflowTypes = this.jbpmService.findResultsByHSQL(hsql);
		   for(DictionaryData dictionaryData : workflowTypes){
			   JSONObject jsonObj = dictionaryData.getJsonObjectDictionaryData(dictionaryData);
			   jsonArr.put(jsonObj);
		   }
	   }else{
		   String typeId  = modelData.get("typeId");
		   DictionaryData worflowType = (DictionaryData)this.jbpmService.findEntityByID(DictionaryData.class, typeId);
		   jsonArr = worflowType.getJbpmWorkflowDesignersJsonArray();
	   }
	   this.output(response, jsonArr.toString());
	   return null;
   }
   ///************同步流程**************/////
	@RequestMapping(value="/getSynchronizedWorkflowDesignersTreeData.action")
	public String getSynchronizedWorkflowDesignersTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	   Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
	   String type = modelData.get("type");
	   String host = modelData.get("host");
	   String port = modelData.get("port");
	   String dbname = modelData.get("dbname");
	   String user = modelData.get("user");
	   String password = modelData.get("password");
	   JdbcModel jdbcModel = new JdbcModel(type,host,port,dbname,user,password);
	   JdbcTemplate fromJdbcTemplate = jdbcModel.getJdbcTemplate();
	   final JSONArray workflowDesignerJsonArray = new JSONArray();
	   String sql = "select t_jbpm_designer_transfer.id_,display_name_,version_ from t_jbpm_designer_transfer left join t_dicts_datas on t_dicts_datas.id_ = t_jbpm_designer_transfer.type_"
	   		+ " where 1 = 1 ";
	   String selectedUserIds = modelData.get("selectedUserIds");
	   String queryText       = modelData.get("queryText");
	   //List<String> params = new ArrayList<String>();
	   //List<Object> values = new ArrayList<Object>();
	   if(null != selectedUserIds){
			//params.add("ids");
			String ids = StringUtil.toSqlJoinString(selectedUserIds,",");
			sql+=" AND t_jbpm_designer_transfer.id_ not in("+ids+") ";
		}
	   if(null != queryText){
			String whereCondition = " AND ( UPPER(workflow_name_) like '%"+queryText.toUpperCase()+"%'  "
					+ " OR  UPPER(display_name_) like '%"+queryText.toUpperCase()+"%' ) ";
			sql+=whereCondition;
	   }
       for(Map m : fromJdbcTemplate.queryForList(sql)){
    	   JSONObject obj = new JSONObject();
    	   obj.put("id",m.get("id_").toString());
    	   obj.put("text", m.get("display_name_").toString()+"-"+m.get("version_").toString());
    	   JSONObject attributesJsonObj = new JSONObject();
   		   attributesJsonObj.put("type","synchronizedWorkflowDesigners");
   		   obj.put("attributes", attributesJsonObj);
    	   workflowDesignerJsonArray.put(obj);
       }
	   this.output(response, workflowDesignerJsonArray.toString());
	   return null;
	}
	@RequestMapping(value="/getSynchronizedWorkflowDesignersSelectedTreeData.action")
	public String getSynchronizedWorkflowDesignersSelectedTreeData(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
		String selectedUserIds = modelData.get("selectedUserIds");
		if(null == selectedUserIds){
			this.output(response, "[]");
			return null;
		}
		String type = modelData.get("type");
		String host = modelData.get("host");
		String port = modelData.get("port");
		String dbname = modelData.get("dbname");
		String user = modelData.get("user");
		String password = modelData.get("password");
		JdbcModel jdbcModel = new JdbcModel(type,host,port,dbname,user,password);
		JdbcTemplate fromJdbcTemplate = jdbcModel.getJdbcTemplate();
		final JSONArray workflowDesignerJsonArray = new JSONArray();
		String sql = "select t_jbpm_designer_transfer.id_,display_name_,version_ from t_jbpm_designer_transfer left join t_dicts_datas on t_dicts_datas.id_ = t_jbpm_designer_transfer.type_"
				+ " where 1 = 1 ";
		if(null != selectedUserIds){
				//params.add("ids");
				String ids = StringUtil.toSqlJoinString(selectedUserIds,",");
				sql+=" AND t_jbpm_designer_transfer.id_ in("+ids+") ";
		}
	    for(Map m : fromJdbcTemplate.queryForList(sql)){
	    	   JSONObject obj = new JSONObject();
	    	   obj.put("id",m.get("id_").toString());
	    	   obj.put("text", m.get("display_name_").toString()+"-"+m.get("version_").toString());
	    	   JSONObject attributesJsonObj = new JSONObject();
	   		   attributesJsonObj.put("type","synchronizedWorkflowDesigners");
	   		   obj.put("attributes", attributesJsonObj);
	    	   workflowDesignerJsonArray.put(obj);
	    }
		this.output(response, workflowDesignerJsonArray.toString());
		return null;
	}
}
