package com.business.action.leasing.project_nocar.credit_nocar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjChangeInfo;
import com.business.entity.proj.ProjCreditResult;
import com.business.entity.proj.ProjGuaranteeEquip;
import com.business.entity.proj.ProjGuaranteeMethod;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.equip.ProjEquip;
import com.business.entity.project_nocar.credit_nocar.ProjDirectorRecord;
import com.business.entity.project_nocar.credit_nocar.ProjFileInfo;
import com.business.entity.project_nocar.credit_nocar.ProjLetterConclusion;
import com.business.entity.project_nocar.credit_nocar.ProjLetterRecord;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.service.reckon.ConditionDataToHisService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.DateUtil;


@WorkflowAction(name = "projCreditNocarEndAction", description = "流程结束动作", workflowName = "项目信审非车业务")
@Component(value = "projCreditNocarEndAction")
public class ProjCreditNocarEndAction implements JbpmBaseAction {
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name="conditionDataToHisService")
	private ConditionDataToHisService  conditionDataToHisService;
	
	@Override
	public void start(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//承租人所需资料清单数据
		String proj_id = variablesMap.get("proj_info.projid");
		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */
		
		Map<String,Object> queryMainObjectMap = new HashMap<String,Object>();
		queryMainObjectMap.put("projId", proj_id);
		
		//数据字典通过name属性匹配
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		dictDataClassMapping.put("DictionaryData", "code");
		dictDataClassMapping.put("CustInfo", "id");
		
        // 立项基本表
		ProjInfo projInfo = (ProjInfo)this.baseService.updateMainEntity(ProjInfo.class, queryMainObjectMap, variablesMap,dictDataClassMapping, "proj_info");
		//立项结束时间
		projInfo.setEndDate(DateUtil.getSystemDateTime());
		//设置流程状态为流程完毕
		projInfo.setWorkFlag(AppStaticUtil.WORKFLOW_OFF);
		
		//保存信审结论
		ProjCreditResult pcr=new ProjCreditResult();
	    pcr.setProjId(projInfo);
	    DictionaryData creditResultType=this.baseService.findEntityByID(DictionaryData.class, variablesMap.get("proj_info_credittype"));
	    pcr.setCreditResultType(creditResultType);
	    pcr.setProjCreditPassTime(variablesMap.get("proj_credit_re_result.projcreditpasstime"));
	    pcr.setCreditConclusion(variablesMap.get("proj_credit_re_result.creditconclusion"));
		pcr.setFlowName(jbpmWorkflowHistoryInfo.getWorkflowName());
		this.baseService.saveOrUpdateEntity(pcr);
		
		//德银新需求，业务合同号在信审结束后生成,信审通过才分配合同号
		String contract_number="";
		if("credit_type_@12".equals(variablesMap.get("proj_info_credittype"))){
			projInfo.setProjStatus(12);
		}//复议
		if("credit_type_@103".equals(variablesMap.get("proj_info_credittype"))){
			projInfo.setProjStatus(103);
		}//否决
		if("credit_type_@11".equals(variablesMap.get("proj_info_credittype"))){
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
		
		// 租赁物明细
		String jsonEquipsString = variablesMap.get("json_proj_equip_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(projInfo, "projEquips", ProjEquip.class, "projId", jsonEquipsString,dictDataClassMapping);
		// 担保单位
		String jsonProjGuaranteeMethodString = variablesMap.get("json_proj_guarantee_detail_str");
		this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeMethods", ProjGuaranteeMethod.class, "projId", jsonProjGuaranteeMethodString,dictDataClassMapping);
		// 抵押人信息
		String jsonGuarString = variablesMap.get("json_proj_guaranty_detail_str");//proj_info.projEquips
		this.baseService.updateOneToManyCollections(projInfo, "projGuaranteeEquips", ProjGuaranteeEquip.class, "projId", jsonGuarString,dictDataClassMapping);
		//文件清单
		String fileDetailString= variablesMap.get("id_json_proj_file_detail_str");
		this.baseService.updateOneToManyCollections(projInfo, "projFileInfos", ProjFileInfo.class, "projId", fileDetailString,dictDataClassMapping);
		//信审结论
		/*String conclusionDetailString = variablesMap.get("json_proj_conclusion_detail_str");
		this.baseService.updateOneToManyCollections(projInfo, "projLetterConclusion", ProjLetterConclusion.class, "projId", conclusionDetailString,dictDataClassMapping);

		//信审会记录
		String letterDetailString = variablesMap.get("json_proj_letter_detail_str");
		this.baseService.updateOneToManyCollections(projInfo, "projLetterRecord", ProjLetterRecord.class, "projId", letterDetailString,dictDataClassMapping);

		//董事会记录
		String directorDetailString = variablesMap.get("json_proj_director_detail_str");
		this.baseService.updateOneToManyCollections(projInfo, "projDirectorRecord", ProjDirectorRecord.class, "projId", directorDetailString,dictDataClassMapping);
		*/
	}

	@Override
	public String save(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
