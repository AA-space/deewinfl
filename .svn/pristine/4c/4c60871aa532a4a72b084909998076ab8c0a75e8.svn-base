package com.business.action.leasing.interfacemanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.Department;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerDeptInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.SecurityUtil;
/**
 * 
 * @author 周丽梅
 * @date 2014-1-3
 * @info信息管理Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "gpsInfoStartAction", description = "流程开始动作", workflowName = "信息管理")
@Component(value = "gpsInfoStartAction")
public class GpsInfoStartAction implements JbpmBaseAction{
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public void back(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String delete(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */
		return null;
	}

	@Override
	public void end(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String save(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(HttpServletRequest request,Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
        String cont_id=variablesMap.get("cont_id");//合同id
    
           
        Map<String,String> queryMainObjectMap = new HashMap<String,String>();
		queryMainObjectMap.put("cont_id", cont_id);
		
		ContractInfo contractInfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class, cont_id);
		variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo,null, "contract_info"));
		variablesMap.put("contract_info.dealername", contractInfo.getCustDealer().getCustName());
		variablesMap.put("contract_info.custname", contractInfo.getCustId().getCustName());
		variablesMap.put("contract_info.contractnumber", contractInfo.getContractNumber());
        
		
		//Department department = (Department) this.tableService.findEntityByID(Department.class, deptid);
		//variablesMap.put("depname", department.getName());
		//List dilist=new ArrayList();
		/*Map<String,Object>propertiesMap=new HashMap<String,Object>(); 
		propertiesMap.put("dealerDept", department);
		dilist=this.tableService.findEntityByProperties(DealerDeptInfo.class, propertiesMap);
		if(dilist.size()>0){
			DealerDeptInfo di=(DealerDeptInfo)dilist.get(0);
			CustInfo ci=di.getCustId();
			variablesMap.put("dealerid", ci.getId());
			//variablesMap.put("dealername", ci.getCustName());
			System.out.println(ci.getId()+":"+ci.getCustName());
		}*/
		
		if (!contractInfo.getId().isEmpty()) {// 租赁物明细                 D:\MyJava\workspace\Byeclipse\tracywindy\WebContent\WEB-INF\tablesXml\eleasing\jsp\other\insurance_manage\list1.xml  
			variablesMap.put("json_proj_gps_str", this.tableService.getJsonArrayData("eleasing/jsp/other/insurance_manage/list1.xml", queryMainObjectMap).toString());
		}
		System.out.println(variablesMap.get("json_proj_gps_str"));
	
	}

}
