package com.business.action.leasing.fundCollection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankProcess;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.google.inject.internal.Maps;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

/**
 * @author Toybaby
 * 
 *         2012-12-26下午01:17:43 email toybaby@mail2.tenwa.com.cn function:
 * 
 */
@WorkflowAction(name = "fundCollectionStartAction", description = "流程开始动作", workflowName = "收款流程")
@Component(value = "fundCollectionStartAction")
public class FundCollectionStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	
	 private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);
	@Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		this.tableService.removeEntityById(FundEbankProcess.class, variablesMap.get("fund_ebank_process"));
		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */
		String  ebankID = variablesMap.get("ebank_id");
		if ( null != ebankID )
		{
			FundEbankData ebankData = this.tableService.findEntityByID(FundEbankData.class,ebankID);
			ebankData.setInuseflag("0");
		}
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
	}

	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//合同基本信息
		//加载资金计划
		//历史收款明细
		//网银信息
		String  ebankID=variablesMap.get("ebank_id");
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
			String workFlowNameB = workFlowInfoMap.get("workFlowName");;
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
		
		
		
		String  cust_id=variablesMap.get("cust_id");
		DictionaryData dicdpayType;
		String paytype="pay_type_in";
		CustInfo  cust;
		ContractInfo contractinfo;
		contractinfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contractid);
		
		DictionaryData paytypeDict = (DictionaryData) this.tableService.findEntityByID(DictionaryData.class, paytype);
		//设置资金计划为流程中
/*		Set<FundFundChargePlan> fundFundChargePlans = contractinfo.getFundFundChargePlans();
		Iterator<FundFundChargePlan> it = fundFundChargePlans.iterator();
		while (it.hasNext()) {
			FundFundChargePlan fundFundChargePlan = (FundFundChargePlan) it.next();
			fundFundChargePlan.setWorkFlag(AppStaticUtil.WORKFLOW_ON);
		}*/
		cust=(CustInfo)this.tableService.findEntityByID(CustInfo.class, cust_id);
		List<FundEbankData> list_ebank=new ArrayList<FundEbankData>();
		HashMap<String,Object>propertiesMap=new HashMap<String,Object>();
		propertiesMap.put("id", ebankID);
		String HQL="";
		Map fieldClassMap= Maps.newHashMap();
		fieldClassMap.put("DictionaryData", "code");
		fieldClassMap.put("User", "id");
		fieldClassMap.put("ProjInfo", "projId");   
		if(contractinfo!=null){
			//加入客户信息   
			 variablesMap.put("contract_info.custname",cust.getCustName());
			 variablesMap.put("contract_info.custnumber",cust.getCustNumber());
			 //加入合同基本信息
		     variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractinfo, fieldClassMap, "contract_info"));
		    list_ebank=this.tableService.findEntityByProperties(FundEbankData.class, propertiesMap);
			FundEbankData fundBank = null;
			if(list_ebank.size()>0){
				fundBank=list_ebank.get(0);
				fundBank.setInuseflag("inuserflag");//加入在使用这笔网银的标识
				fundBank.setModifyDate(DateUtil.getSystemDateTime());
				fundBank.setModificator(SecurityUtil.getPrincipal());
				fundBank.initFundEbank();
				variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(fundBank, null, "fund_ebank_data"));
			}
			HQL=" from DictionaryData AS DD where DD.belongDictionary.code=? ";
			List<DictionaryData> listpayType=new ArrayList<DictionaryData>();
			//查出资金状态
			listpayType=this.tableService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
			HashMap<String,DictionaryData> mapPayType=new HashMap<String,DictionaryData>();
			for(DictionaryData dd:listpayType){
				mapPayType.put(dd.getCode(), dd);
			}
			//计划 
			//计划表显示需要显示那些计划已收，哪些未收，哪些收多少----invalid 没有作废的资金计划
		    HQL=" from ContractFundFundPlan as fc where fc.contractId.id=? and fc.payType.code=?and fc.invalid=?";
		    List<ContractFundFundPlan> fundPlan=new ArrayList<ContractFundFundPlan>();
		    
		    fundPlan=this.tableService.findResultsByHSQL(HQL, contractinfo.getId() ,paytype,"0");
		    List<ContractFundFundPlan> fundPlanR=new ArrayList<ContractFundFundPlan>();
		    for(ContractFundFundPlan fplan:fundPlan){
		    	fplan.receiverAllMoney(mapPayType);
		        fundPlanR.add(fplan);
		    }
		    HashMap<String,String>fieldClassMapping=new HashMap<String,String>();
		    fieldClassMapping.put("ContractInfo", "contractId");
		    fieldClassMapping.put("DictionaryData", "code");
		   if(fundPlanR.size()>0){  
			   variablesMap.put("json_receiverchargeplan_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMapping, ""));
		   }
		   //实收表
		    List<ContractFundFundCharge>chargeList=new ArrayList<ContractFundFundCharge>();
		    
			HQL = " from ContractFundFundCharge as fc where  fc.payType.code=? and fc.contractId.id=? order by fc.fundFundChargePlan.paymentId";
		    chargeList=this.tableService.findResultsByHSQL(HQL, paytype, contractid);
		    fieldClassMapping.clear(); 
		    fieldClassMapping.put("ContractInfo", "contractId");
		    fieldClassMapping.put("DictionaryData", "code");
		    fieldClassMapping.put("ContractFundFundPlan.paymentId", "paymentId");
		    fieldClassMapping.put("FundEbankData", "ebdataId");
		    fieldClassMapping.put("User", "realname");
		    if(chargeList.size()>0){
		    	//String json_receiverchargehistory_str = this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeList, fieldClassMapping, "");
		    	String json_receiverchargehistory_str = this.tableService.getCollectionJsonString(chargeList,fieldClassMapping);
		    	variablesMap.put("json_receiverchargehistory_str",json_receiverchargehistory_str);
		    }
		    
			//插入网银中间表
			FundEbankProcess fundEbankProcess = new FundEbankProcess();
			fundEbankProcess.setContractId(contractid);
			fundEbankProcess.setDealerID(contractinfo.getCustDealer().getId());
			fundEbankProcess.setEbdataId(fundBank);
			fundEbankProcess.setFlowUnid(jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid()+"");
			fundEbankProcess.setProcessName(jbpmWorkflowHistoryInfo.getWorkflowDisplayName());
			fundEbankProcess.setStartDate(DateUtil.getSystemDateTime());
			fundEbankProcess.setWork_flag("0");
			fundEbankProcess.setProcessAmount(BigDecimal.ZERO);
			this.tableService.saveEntity(fundEbankProcess);
			
			variablesMap.put("fund_ebank_process", fundEbankProcess.getId());
			
/*		    {name:'dealername', header:'经销商名称'},
		       {name:'custname', header:'客户名称'},
			   {name:'contractname', header:'合同号'},
			   {name:'contractid', header:'合同id',hidden:true},
			   {name:'limitmoney', header:'额度金额',nullable:false}*/
			
			//插入额度内容
			String json_fund_limit_str = "[{dealername:\""+contractinfo.getCustDealer().getCustName()+"\", contractname:\""+contractinfo.getContractNumber()+"\", custname:\""+cust.getCustName()+"\", contractid:\""+contractinfo.getId()+"\"}]";
			
			
			variablesMap.put("json_fund_limit_str", json_fund_limit_str);
		    
		}
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
