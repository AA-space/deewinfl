package com.business.action.leasing.contract_nocar.approval_nocar;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;


@WorkflowAction(name = "contractApprovalNoCarStartAction", description = "流程开始动作", workflowName = "合同审批流程非车业务")
@Component(value = "contractApprovalNoCarStartAction")
public class ContractApprovalNoCarStartAction implements JbpmBaseAction {

	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public void back(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {

	}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String proj_id = variablesMap.get("proj_id");
		variablesMap.put("proj_id", proj_id);
		ProjInfo projInfo =(ProjInfo) this.baseService.findEntityByID(ProjInfo.class, proj_id);
		CustInfo customerInfo = projInfo.getCustId();
		
		projInfo.setWorkFlag(1);
		this.tableService.updateEntity(projInfo);
		
		//生成合同编号
		String contract_id = WorkflowUtil.getContractInfoSerialNumber(variablesMap,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());
		
		//合同基本信息
		//步骤二(获取项目基本信息)
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo,null, "contract_info"));
		variablesMap.put("rawValue_contract_info.projdept", projInfo.getProjDept().getName());
		variablesMap.put("rawValue_contract_info.projregistrar", projInfo.getProjRegistrar()==null?"":projInfo.getProjRegistrar().getRealname());
		variablesMap.put("rawValue_contract_info.projmanage", projInfo.getProjManage()==null?"":projInfo.getProjManage().getRealname());
		variablesMap.put("rawValue_contract_info.projassist", projInfo.getProjAssist()==null?"":projInfo.getProjAssist().getRealname());
	
		
		variablesMap.put("contract_info.id", "");
		variablesMap.put("project_info.projId", projInfo.getProjId());
		variablesMap.put("project_info.id", projInfo.getId());
		variablesMap.put("contract_info.contractstatus", projInfo.getProjStatus().toString());
		variablesMap.put("contract_info.proj_id", projInfo.getProjId());
		variablesMap.put("contract_info.contractid", contract_id);
		
		CustInfo cinfo=projInfo.getCustId();
		if(cinfo!=null){
			variablesMap.put("contract_info.custname",cinfo.getCustName());
			variablesMap.put("contract_info.custid",cinfo.getId());
			variablesMap.put("contract_info.custInfo",cinfo.getId());
			variablesMap.put("contract_info.custnumber",cinfo.getCustNumber());
			variablesMap.put("contract_info.custclass",cinfo.getCustClass().getId());
		}
		
		
		//德银新需求，合同审批业务合同编号重proj_info表中获取，在项目信审接受后保存contract_number。
		//1.项目立项后，合同审批，不插contract_number到contractinfo表
		//2.项目信审后，合同审批，取proj_info表中获取contract_number。
		//String contract_number = WorkflowUtil.getContractInfoSerialNumberForBussiness(variablesMap,this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService.getBussinessDao().getJdbcTemplate());
		String contract_number="";
		if(projInfo.getContractNumber()!=null){
			 contract_number=projInfo.getContractNumber();
		}
		variablesMap.put("contract_info.contractnumber",contract_number);
		
		//项目查询参数
		Map<String,String> queryMainObjectMap = new HashMap<String,String>();
		queryMainObjectMap.put("proj_id", proj_id);
		
		if(!projInfo.getProjEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_contract_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_equip.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjGuaranteeMethods().isEmpty()) {// 担保单位
			variablesMap.put("json_contract_guarantee_detail_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_guarantee_method.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjGuaranteeEquips().isEmpty()) {// 抵押物清单
			variablesMap.put("json_contract_guaranty_detail_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_guarantee_equip.xml", queryMainObjectMap).toString());
		}
		
		//步骤四
		//为了租金测算的通用性此处的名字不用contract_codition 而用framework_condition
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(projInfo.getProjCondition(),null, "framework_condition"));
		//设置租金测算参数为合同审批
		//获得一个流水号
		String doc_id=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		variablesMap.put("framework_condition.contractid",contract_id);
		variablesMap.put("framework_condition.process", "cont_process");
		variablesMap.put("framework_condition.custname",customerInfo.getCustName());
		variablesMap.put("framework_condition.custid",customerInfo.getId());
		variablesMap.put("framework_condition.docid",doc_id);
		variablesMap.put("framework_condition.onhireid","");
		
		// 因为这里是按照XML配置查询 所以在合同审批发起的时候数据是从项目表来的 所以这里的xml配置的是项目的XML
		if (!projInfo.getProjFundRentPlans().isEmpty()) {// 租金计划
			variablesMap.put("json_fund_rent_plan_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_rent_plan.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjCashDetails().isEmpty()) {// 合同现金流
			variablesMap.put("json_fund_cash_flow_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_cash_flow.xml", queryMainObjectMap).toString());
		}
		if (!projInfo.getProjFundFundPlans().isEmpty()) {//项目资金计划
			variablesMap.put("json_fund_fund_charge_str", this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/proj_fund_fund_plan.xml", queryMainObjectMap).toString());
		}
	}
}
