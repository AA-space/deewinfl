package com.business.action.leasing.fundPayEquipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractPremiseCondition;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.invoice.ContractInvoiceType;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoAccount;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.google.inject.internal.Maps;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.AppStaticUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.WebUtil;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "fundPayEquipmentStartAction", description = "流程开始动作", workflowName = "实际投放流程")
@Component(value = "fundPayEquipmentStartAction")
public class FundPayEquipmentStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;

	private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);

	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap, JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */

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
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
	    //加载合同基本信息
		//加载付款条件
		//加载投放计划
		//资金收款名细
		//已投入名细
		//本次投入计划
		//租金发票类型
		String  contractid=variablesMap.get("contract_id");
		/**
		 * 流程冲突共三步
		 * 1、起始位置添加第一步，如**startAction
		 * 2、删除流程实例时添加第二部 ,**startAction中delete方法
		 * 3、结束流程里添加第三步, 例**endAction中添加
		 * 注意：例如经销资金收款中，第一步插入冲突表时，需要插入多个，不需要第二步，第三步也需要删除多个
		 * 		workFlowFlag插入时已逗号分隔。
		 * 
		 * 流程冲突第一步-开始*/
		String workFlowName = jbpmWorkflowHistoryInfo.getWorkflowName(); 
		
		//查询冲突 
		String hql = "SELECT new Map(WF.workNumber as workNumber, WF.workFlowName as workFlowName,WF.workFlowInstance AS workFlowInstance, WF.beginUser AS beginUser) FROM  WorkFlowFlag AS WF , ExclusionInfo AS EI  WHERE WF.workFlowName = EI.workFlowNameB AND EI.workFlowNameA = '"+workFlowName+"' AND WF.workNumber = '"+ contractid +"'";
		List<Map<String,String>> workFlowFlagList =  this.tableService.findResultsByHSQL(hql);
		if (workFlowFlagList.size() > 0){
			Map<String, String> workFlowInfoMap = workFlowFlagList.get(0);
			User beginUser = this.tableService.findEntityByID(User.class, workFlowInfoMap.get("beginUser"));
			String workFlowNameB = workFlowInfoMap.get("workFlowName");
			throw new BusinessException("该条流程与【"+workFlowNameB+"】流程不能同时发起,请与流程发起人:【"+beginUser.getRealname()+"】联系查看详情");
		}
		
		//将本条流程记录插入到冲突表
		WorkFlowFlag workFlowFlag = new WorkFlowFlag();
		workFlowFlag.setBeginUser(SecurityUtil.getPrincipal().getId());
		workFlowFlag.setStatus(1);
		workFlowFlag.setWorkFlowInstance(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
		workFlowFlag.setWorkFlowName(workFlowName);
		workFlowFlag.setWorkNumber(contractid);
		this.tableService.saveEntity(workFlowFlag);

		variablesMap.put("workFlowFlag", workFlowFlag.getId());
		/** 流程冲突第一步-结束*/
		
		// 获取经销商的主账号信息
		ContractInfo cc = this.tableService.findEntityByID(ContractInfo.class,
				contractid);
		/*判断发起投放的条件 =============合同审批在03-2合同审核岗审核这个步骤不予投放*/
		  String sql="SELECT * from t_jbpm_workflow_info  left join contract_info ci " +
				" on ci.contract_id = t_jbpm_workflow_info.key_one_ " +
				"where workflow_name_ = '合同审批流程'" +
				"and history_activity_name_ ='04业务部合同审核岗寄送' and ci.id= '"+contractid+"' ";
		  
		JdbcTemplate jdbcTemplate = (JdbcTemplate)WebUtil.getApplicationContext().getBean("jdbcTemplate");
		List<Map<String, Object>> rownums = jdbcTemplate.queryForList(sql);
		if (rownums.size() > 0){
			log.info("##############该合同已到【04业务部合同审核岗寄送】步骤可发起投放#############");
		}
		else
		{
			String sql2="SELECT * from t_jbpm_workflow_info  left join contract_info ci " +
			" on ci.contract_id = t_jbpm_workflow_info.key_one_ " +
			"where workflow_name_ = '合同审批流程'" +
			" and   history_activity_name_='03-2合同审核岗审核(确认数据无误)' and ci.id= '"+contractid+"' ";
	  
			JdbcTemplate jdbcTemplate2 = (JdbcTemplate)WebUtil.getApplicationContext().getBean("jdbcTemplate");
			List<Map<String, Object>> rownums2 = jdbcTemplate2.queryForList(sql2);
			if(rownums2.size() > 0)
			{
				throw new BusinessException("合同审批流程在【03-2合同审核岗审核(确认数据无误)】步骤,请确认相关手续后发起投放!");
			}
		}
		Map<String, Object> listmap = new HashMap<String, Object>();
		listmap.put("custId", cc.getCustDealer());
		listmap.put("isMain", "0");
		List<CustInfoAccount> listacc = this.tableService
				.findEntityByProperties(CustInfoAccount.class, listmap);
		if (listacc.size() > 0) {
			variablesMap.put("dealer_bankName", listacc.get(0).getBankName());
			variablesMap.put("dealer_account", listacc.get(0).getAccount());
			variablesMap.put("dealer_accNumber", listacc.get(0).getAccNumber());
		}
		//获取租赁物台数
		Map<String, Object> propertiesMap=new HashMap<String, Object>();
		propertiesMap.put("contractId", cc);
		List<ContractEquip> listequip=this.tableService.findEntityByProperties(ContractEquip.class, propertiesMap);
		int equipcount=0;
		if(listequip.size()>0){
			for (int i=0;i<listequip.size();i++){
				ContractEquip cequip=listequip.get(i);
				System.out.println(cequip.getEquipClass().getId());
				if("equip_class_2".equals(cequip.getEquipClass().getId())){
				}else{
					equipcount++;
				}
			}
		}
		variablesMap.put("equipcount",String.valueOf(equipcount));

		String  cust_id=variablesMap.get("cust_id");
		CustInfo  cust;
		ContractInfo contractinfo;
		DictionaryData dicdpayType;
	    String paytype="pay_type_out";
	    String HQL="";
		contractinfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contractid);
		
		//设置资金计划为流程中
		Set<ContractFundFundPlan> fundFundChargePlans = contractinfo.getFundFundChargePlans();
		Iterator<ContractFundFundPlan> it = fundFundChargePlans.iterator();
		while (it.hasNext()) {
			ContractFundFundPlan fundFundChargePlan = (ContractFundFundPlan) it.next();
			fundFundChargePlan.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
		}
		
		cust=(CustInfo)this.tableService.findEntityByID(CustInfo.class, cust_id);
		HashMap fieldClassMap=new HashMap<String,String>();
		fieldClassMap.put("DictionaryData", "code");
		fieldClassMap.put("User", "id");
		fieldClassMap.put("ProjInfo", "projId");
		if(contractinfo!=null){
			 //加入客户信息
			 variablesMap.put("contract_info.custname",cust.getCustName());
			 variablesMap.put("contract_info.custnumber",cust.getCustNumber());
			 //加入合同基本信息
		     variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractinfo, fieldClassMap, "contract_info"));
			 //查出资金状态
			 HQL=" from DictionaryData AS DD where DD.belongDictionary.code=? ";
			 List<DictionaryData> listpayType=new ArrayList<DictionaryData>();
			 listpayType=this.tableService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
			 HashMap<String,DictionaryData> mapPayType=new HashMap<String,DictionaryData>();
			 for(DictionaryData dd:listpayType){
				  mapPayType.put(dd.getCode(), dd);
			  }
			  //投放前提条件
			  HQL="from ContractPremiseCondition as cc where cc.contractId=?";
			  List<ContractPremiseCondition> contractPCondtion=new ArrayList<ContractPremiseCondition>();
			  contractPCondtion=this.tableService.findResultsByHSQL(HQL, contractinfo);
			  if( contractPCondtion.size()>0){
			       variablesMap.put("json_contract_premise_str", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(contractPCondtion, null, ""));
		       }
		     //投入设备款计划
			 HQL=" from ContractFundFundPlan as fc where fc.contractId.id=? and fc.payType.code=? and fc.feeType.code=? and fc.invalid=?";
			 List<ContractFundFundPlan> fundPlan=new ArrayList<ContractFundFundPlan>();
			 fundPlan=this.tableService.findResultsByHSQL(HQL, contractid ,paytype,"feetype10","0");
			 List<ContractFundFundPlan> fundPlanR=new ArrayList<ContractFundFundPlan>();
			 for(ContractFundFundPlan fplan:fundPlan){
			    fplan.receiverAllMoney(mapPayType);
			    fundPlanR.add(fplan);
			 }
			 HashMap<String,String>fieldClassMapping=new HashMap<String,String>();
			 fieldClassMapping.put("ContractInfo", "contractId");
			 fieldClassMapping.put("DictionaryData", "code");
		     if(fundPlanR.size()>0){  
			    variablesMap.put("json_leasing_delivery_plan_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMapping, ""));
		     }
		 
		     
		     //实际收取首付款
		     Map<String, String> model = Maps.newHashMap(); 
		     model.put("contract_id", contractid);
		     //model.put("fee_type", "feetype5");
		     
		     String firstpayment = this.tableService.getTableJsonData("eleasing/workflow/public/fundfundPlanSelectfirstmoney.xml", model);
		     
		     variablesMap.put("firstpayment", firstpayment);
		    //资金收款明细
		    List<ContractFundFundCharge>chargeList=new ArrayList<ContractFundFundCharge>();
		    HQL=" from ContractFundFundCharge as fc where fc.contractId.id=? and fc.payType.code=?";
		    chargeList=this.tableService.findResultsByHSQL(HQL, contractid,"pay_type_in");
		    fieldClassMapping.clear(); 
		    fieldClassMapping.put("ContractInfo", "contractId");
		    fieldClassMapping.put("DictionaryData", "code");
		    //fieldClassMapping.put("ContractFundFundPlan", "paymentId");
		    fieldClassMapping.put("ContractFundFundPlan.paymentId", "paymentId");
		    fieldClassMapping.put("FundEbankData", "ebdataId");
		    fieldClassMapping.put("User", "realname");
		    if(chargeList.size()>0){
			   //variablesMap.put("json_fundfundcharge_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeList, fieldClassMapping, ""));
		    	String json_fundfundcharge_str = this.tableService.getCollectionJsonString(chargeList,fieldClassMapping);
		    	variablesMap.put("json_fundfundcharge_str",json_fundfundcharge_str);
		    }
		    //设备款已投放
		    List<ContractFundFundCharge>chargeListEquip=new ArrayList<ContractFundFundCharge>();
		   HQL=" from ContractFundFundCharge as fc where fc.contractId.id=? and fc.payType.code=? and fc.feeType.code=?";
		    chargeListEquip=this.tableService.findResultsByHSQL(HQL,contractid,paytype,"feetype10");
		    if(chargeListEquip.size()>0){
				 variablesMap.put("json_contract_fund_payment_history_str",this.tableService.getCollectionJsonString(chargeListEquip, fieldClassMapping));
			}
		    //发票类型
			HQL="from ContractInvoiceType as ct where ct.contractId.contractId=?";
			List<ContractInvoiceType> cinvoicetype=new ArrayList<ContractInvoiceType>();
			cinvoicetype=this.tableService.findResultsByHSQL(HQL, contractinfo.getContractId());
			if(cinvoicetype.size()>0){
				 variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(cinvoicetype.get(0), fieldClassMap, "contract_invoice_type"));
			}
			}
	    System.out.println(variablesMap);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.business.action.JbpmBaseAction#back(javax.servlet.http.HttpServletRequest,
	 *      java.util.Map)
	 **/

	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,
			JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub

	}
}
