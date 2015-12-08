package com.business.action.leasing.cardhire;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.BaseFile;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.business.service.cardhire.ContractCardHireService;
import com.kernal.annotation.WorkflowAction;

/**
 * 
 * @author 孙传良
 * @date 2013-9-11上午12:15:14
 * @info
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "cardHireStartAction", description = "流程开始动作", workflowName = "租金批量核销(卡扣)")
@Component(value = "cardHireStartAction")
public class CardHireStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name = "cardHireService")
	private ContractCardHireService cardHireService;
	
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//如果流程被删除 则需要删除临时表的数据已还原 剩余金额
		String fileid=variablesMap.get("cardhire.uploadid");
		String docId=variablesMap.get("cardhire.docid");
		Map<String, String>modeldata =new HashMap<String, String>();
		modeldata.put("fileid", fileid);
		modeldata.put("docid", docId);
		String msg=this.cardHireService.deleteCardHireToIncomeControl(modeldata);
		
		BaseFile bf=this.tableService.findEntityByID(BaseFile.class, fileid);
		bf.setExportNumber(0);
		this.tableService.saveOrUpdateEntity(bf);
		return msg;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		String fileid=variablesMap.get("fileid");
		BaseFile bf=new BaseFile();
		String doc_id=jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"";
		bf=(BaseFile) this.tableService.findEntityByID(BaseFile.class, fileid);
		
		if(bf.getExportNumber() > 0){
			throw new BusinessException("上传的卡扣数据已经在处理或者已经处理完毕,请核实.");
		}
		//将导出设置成1，表示正在核销
		bf.setExportNumber(1);
		variablesMap.put("cardhire.docid",doc_id);
		variablesMap.put("cardhire.docname", bf.getCreateDate()+"上传卡扣数据核销");
		variablesMap.put("cardhire.uploadid",fileid);
		variablesMap.put("cardhire.uploaddate", bf.getCreateDate());
		variablesMap.put("cardhire.uploaduser", bf.getCreator().getRealname());
		
		String hire_date = null;
		String hire_date_sql = "select ccri.incomeDate from ContractCardRentIncome  ccri where ccri.upLoadId.id = ? AND ccri.incomeStatus = 0";
		List<String> hire_date_list  = this.tableService.findResultsByHSQL(hire_date_sql, fileid);
		if(hire_date_list.size()  > 0) {
			hire_date = hire_date_list.get(0);
			variablesMap.put("hire_date",hire_date.substring(0, 10));
		}
		else 
		{
			String hire_date_sql2 = "select ccri.incomeDate from ContractCardRentIncome  ccri where ccri.upLoadId.id = ? ";
			List<String> hire_date_list2  = this.tableService.findResultsByHSQL(hire_date_sql2, fileid);
			if ( hire_date_list2.size() > 0 ) {
				hire_date = hire_date_list2.get(0);
				variablesMap.put("hire_date",hire_date.substring(0, 10));
			}
		}
		System.out.println("##############################" + hire_date);
		
		String hsql = "select sum(ccri.incomeMoney) as im, sum(ccri.lastMoney) as lm, COUNT(ID) as success from ContractCardRentIncome  ccri where ccri.upLoadId.id = ? AND ccri.incomeStatus = 0";
		List<Object[]> valsObjectsList  = this.tableService.findResultsByHSQL(hsql, fileid);
		Object[] valsObjects = valsObjectsList.get(0);
		BigDecimal im = (BigDecimal)valsObjects[0];
		BigDecimal lm = (BigDecimal)valsObjects[1];
		Long success = (Long) valsObjects[2];
		if(im!=null){
			variablesMap.put("cardhire.incomemoneysum", String.valueOf(im.doubleValue()));
		}
		if(lm!=null){
			variablesMap.put("cardhire.lastmoneysum",String.valueOf(lm.doubleValue()) );
		}
		if( success != null )
		{
			variablesMap.put("cardhire.success", success.toString());
		}
	}

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}
}
