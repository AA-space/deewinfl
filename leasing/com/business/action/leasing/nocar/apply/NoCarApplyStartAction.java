package com.business.action.leasing.nocar.apply;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.cust.CustInfoPerson;
import com.business.entity.cust.CustInfoRelatedPerson;
import com.business.entity.cust.CustStockholder;
import com.business.entity.dealer.CustInfoDealer;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.ProjOtherInfo;
import com.business.service.TableService;
import com.business.util.WorkflowUtil;
import com.kernal.annotation.WorkflowAction;
/**
 * 
 * @author 蔡雅超
 * @date 2013-7-10
 * @info项目立项流程(设备)的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "noCarApplyStartAction", description = "流程开始动作", workflowName = "项目立项流程(设备)")
@Component(value = "noCarApplyStartAction")
public class NoCarApplyStartAction implements JbpmBaseAction{
	
	@Resource(name = "tableService")
	private TableService tableService;
	 
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		try {
			Logger logger = Logger.getLogger(NoCarApplyStartAction.class
					.getName());
			/** 获得proj_id和cust_id */
			String cust_id = variablesMap.get("cust_id");
			String bussiness_type = variablesMap.get("bussiness_type");
			String bussiness_mode = variablesMap.get("bussiness_mode");
			CustInfo custInfo = null;
			if (cust_id != null) {
				custInfo = (CustInfo) this.tableService.findEntityByID(
						CustInfo.class, cust_id);
			}
			String proj_id = WorkflowUtil.getProjInfoSerialNumber(variablesMap,
					this.tableService.getBussinessDao().getHibernateTemplate(), this.tableService
					.getBussinessDao().getJdbcTemplate());
			/** 参数赋值 */
			variablesMap.put("proj_info.projid", proj_id);
			Map<String, String> queryMainObjectMap = new HashMap<String, String>();
			queryMainObjectMap.put("cust_id", cust_id);
			variablesMap.put("proj_info.custid", cust_id);
			variablesMap.put("proj_info.businesstype", bussiness_type);
			variablesMap.put("proj_info.businessmode", bussiness_mode);
			variablesMap.put("proj_info.custname", custInfo.getCustName());
			variablesMap.put("proj_info.custnumber", custInfo.getCustNumber());
			CustInfoCompany company = custInfo.getCustInfoCompany();
			if (company != null) {
				if (custInfo.getCustClass().getCode() != null) {
					if (custInfo.getCustClass().getCode().toUpperCase().equals(
							"CUST_INFO_COMPANY")) {// 法人信息
						variablesMap
								.put(
										"cust_info_company.legalrepresentative",
										company.getLegalRepresentative() != null ? company
												.getLegalRepresentative()
												: "");
						variablesMap.put("cust_info_company.taxregadd", company
								.getTaxRegAdd() != null ? company
								.getTaxRegAdd() : "");
						variablesMap.put("cust_info_company.ownership",
								(company.getOwnership() == null) ? "" : company
										.getOwnership().getName());
						variablesMap.put("cust_info_company.custscale",
								(company.getCustScale() == null) ? "" : company
										.getCustScale().getName());
						// 插入经销商
						variablesMap.put("proj_info.custdealer", (company
								.getDealerOrCompany() == null ? "" : company
								.getDealerOrCompany()));

					}
					Set<CustInfoRelatedPerson> custInfoRelatedPersons = custInfo
							.getRelatedPersons();
					for (Iterator<CustInfoRelatedPerson> iterator = custInfoRelatedPersons
							.iterator(); iterator.hasNext();) {
						CustInfoRelatedPerson custInfoRelatedPerson = iterator
								.next();
						if (custInfoRelatedPerson.getRelationship().getCode()
								.toUpperCase().equals("RELATIONSHIP_CEO")) {
							variablesMap
									.put(
											"cust_related_person.name",
											custInfoRelatedPerson
													.getRelationship() != null ? custInfoRelatedPerson
													.getRelationship()
													.getName()
													: "");// 总经理名字
							break;
						}
					}
					variablesMap.put("cust_info_company.netassets", company
							.getNetAssets() != null ? company.getNetAssets()
							.toString() : "");// 资产总额（净资产）
					variablesMap.put("cust_info_company.bizscopeprimary",
							company.getBizScopePrimary() != null ? company
									.getBizScopePrimary() : "");// 主营
					variablesMap.put("cust_info_company.bizscopesecondary",
							company.getBizScopeSecondary() != null ? company
									.getBizScopeSecondary() : "");// 兼营
				}
			} else {
				logger.info("company对象为空");
			}
			/** 多行控件 */
			// if (custStockholder!=null) {// 股东构成
			variablesMap
					.put(
							"json_stockholder_info_str",
							this.tableService
									.getJsonArrayData(
											"eleasing/workflow/stockholder/stockholder_info.xml",
											queryMainObjectMap).toString());
			// }
			// 存入租金测算数据
			variablesMap.put("framework_condition.custname", custInfo
					.getCustName());
			variablesMap.put("framework_condition.custid", cust_id);
			variablesMap.put("framework_condition.projid", proj_id);
			variablesMap.put("framework_condition.docid",
					jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl()
							.getDbid()
							+ "");
			variablesMap.put("framework_condition.process", "proj_process");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
	}

	@Override
	public String delete(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	@Override
	public void end(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	}

	@Override
	public String save(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		return null;
	}

	

	
	
	
}
