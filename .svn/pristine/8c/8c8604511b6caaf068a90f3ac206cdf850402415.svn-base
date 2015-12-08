package com.business.action.leasing.cardhire;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.base.BaseFile;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentInComeTemp;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.business.service.vouchersFactory.ContractOnHireService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;

/**
 * 
 * @author 孙传良
 * @date 2013-9-11上午12:16:13
 * @info
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "cardHireEndAction", description = "流程结束动作", workflowName = "租金批量核销(卡扣)")
@Component(value = "cardHireEndAction")
public class CardHireEndAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name="contractOnHireService")
	private ContractOnHireService contractOnHireService;
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	
		System.out.println(variablesMap);
		String fileid=variablesMap.get("cardhire.uploadid");
		String docId=variablesMap.get("cardhire.docid"); 
		List<ContractFundRentInComeTemp> tempList=new ArrayList<ContractFundRentInComeTemp>();
		List<ContractFundRentInCome> incomeList=new ArrayList<ContractFundRentInCome>();
		BaseFile bf=this.tableService.findEntityByID(BaseFile.class, fileid);
		Map<String, Object> propertiesMap=new HashMap<String, Object>();
		propertiesMap.put("upId", bf);
		propertiesMap.put("docId", docId);
		tempList=this.tableService.findEntityByProperties(ContractFundRentInComeTemp.class, propertiesMap);
		for (ContractFundRentInComeTemp incomeTemp : tempList) {
			ContractFundRentInCome inCome=new ContractFundRentInCome();
			BeanUtils.copyProperties(incomeTemp, inCome);
			inCome.setCreateDate(DateUtil.getSystemDate());
			incomeList.add(inCome);
		}
		
		this.tableService.saveAllEntities(incomeList);
		 
		//将文件导出的状态设置成2，表示此文件已经完成了导入。

		bf.setExportNumber(2);
		
		
		Set<String> cardHireDownFileIdSet = new HashSet<String>();
		
		for (int i = 0; i < incomeList.size(); i++) {
			ContractFundRentInCome income = incomeList.get(i);
			cardHireDownFileIdSet.add(income.getPlanId().getCardExportStatus());
		}
		
		//添加失败的卡扣id
		
		JSONArray jsonArray = new JSONArray(variablesMap.get("card_fail"));
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			String contract_id = jsonObject.getString("contract_id");
			Integer rentList = jsonObject.getInt("rentlist");
		/*	Map<String, Object> properMap = new HashMap<String, Object>(); 
			properMap.put("contract_id", contract_id);
			properMap.put("rentList", rentList);*/
			String renthql = "SELECT cardExportStatus FROM ContractFundRentPlan WHERE contractId.id = '"+contract_id+ "'  AND rentList = " + rentList;
			
			List<String>  exoprtIds = this.tableService.findResultsByHSQL(renthql);
			cardHireDownFileIdSet.addAll(exoprtIds);
		}
		
		final List<String> cardHireDownFileIdList = new ArrayList<String>();
		cardHireDownFileIdList.addAll(cardHireDownFileIdSet);
		
		

		
		/**将租金计划中此卡扣的状态取消*/
		//String sql = "UPDATE CONTRACT_FUND_RENT_PLAN T SET CARD_EXPORT_STATUS ='0'  WHERE CARD_EXPORT_STATUS = '" + bf.getId() + "'";
		String sql = "UPDATE CONTRACT_FUND_RENT_PLAN T SET CARD_EXPORT_STATUS ='0'  WHERE CARD_EXPORT_STATUS = ?";
		
		this.tableService.getBussinessDao().getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, cardHireDownFileIdList.get(i));
			}
			
			@Override
			public int getBatchSize() {
				return cardHireDownFileIdList.size();
			}
		});
		
		
		/** 流程冲突第三步-结束 */
		
		String delSql = "DELETE T_WORK_FLOW_FLAG WHERE WORK_FLOW_NAME = '租金批量核销(卡扣)' AND WORK_FLOW_INSTANCE = ?";
		
		this.tableService.getBussinessDao().getJdbcTemplate().batchUpdate(delSql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, cardHireDownFileIdList.get(i));
			}
			
			@Override
			public int getBatchSize() {
				return cardHireDownFileIdList.size();
			}
		});
		 
		
		/** 流程冲突第三步-结束 */
		
	    /** 卡扣-凭证生成-开始*/
	     
		contractOnHireService.cardHireVoucher(incomeList);
	     
		
		 /** 卡扣-凭证生成-结束*/
		
		//throw new BusinessException("1");
		
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
		
	}

}
