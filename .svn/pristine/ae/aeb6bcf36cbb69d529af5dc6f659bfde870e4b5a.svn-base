package com.business.action.leasing.contract.finish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.daoImpl.AbstractBaseDaoImpl;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.asset.FundEbankData;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author 蔡雅超
 * @date 2013-8-7
 * @info合同结束的Action
 * @Copyright 
 * Tenwa
 */
@WorkflowAction(name = "contractFinishStartAction", description = "流程开始动作", workflowName = "合同结束流程")
@Component(value = "contractFinishStartAction")
public class ContractFinishStartAction implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	 @SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(AbstractBaseDaoImpl.class);
	 @SuppressWarnings("unused")
	@Override
		public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
			
		 Logger logger=Logger.getLogger(ContractFinishStartAction.class.getName());
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
			CustInfo  cust;
			ContractInfo contractinfo;
			contractinfo=(ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contractid);
			cust=(CustInfo)this.tableService.findEntityByID(CustInfo.class, cust_id);
			List<FundEbankData> list_ebank=new ArrayList<FundEbankData>();
			HashMap<String,Object> propertiesMap=new HashMap<String,Object>();
			String HQL="";
			HashMap<String,String> fieldClassMap=new HashMap<String,String>();
			fieldClassMap.put("DictionaryData", "name");
			fieldClassMap.put("User", "id");
			fieldClassMap.put("ProjInfo", "projId");
			fieldClassMap.put("FundEbankData", "ebdataId");
			fieldClassMap.put("ContractInfo", "contractId");
			fieldClassMap.put("FundFundChargePlan", "paymentId");
			//加入客户信息   
			 variablesMap.put("contract_info.custname",cust.getCustName());
			 variablesMap.put("contract_info.custnumber",cust.getCustNumber());
			 
			 String contract_id = variablesMap.get("contract_id");
			 Map<String, String> queryMainObjectMap1 = new HashMap<String, String>();
			 queryMainObjectMap1.put("contract_id", contract_id);
			 queryMainObjectMap1.put("equipAmt", contractinfo.getContractCondition().getEquipAmt().toString());
			 if (!contractinfo.getContractEquips().isEmpty()) {// 租赁物明细
					variablesMap.put("json_proj_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_equip.xml", queryMainObjectMap1).toString());
					System.out.println(variablesMap.get("json_proj_equip_str"));
			 }
			 if(contractinfo!=null){
				//加入合同基本信息
				variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractinfo, null, "contract_info"));
				variablesMap.put("contract_info.projid",contractinfo.getProjId().getProjId());
				HQL=" from DictionaryData AS DD where DD.belongDictionary.code=? ";
				List<DictionaryData> listpayType=new ArrayList<DictionaryData>();
				//查出资金状态
				listpayType=this.tableService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
				HashMap<String,DictionaryData> mapPayType=new HashMap<String,DictionaryData>();
				for(DictionaryData dd:listpayType){
					mapPayType.put(dd.getCode(), dd);
				}
				//资金收款计划
				HQL=" from ContractFundFundPlan as fc  where fc.contractId.contractId=? and fc.payType.code=? and fc.invalid=?";
			    List<ContractFundFundPlan> fundPlan=new ArrayList<ContractFundFundPlan>();
			    fundPlan=this.tableService.findResultsByHSQL(HQL,contractinfo.getContractId() ,"pay_type_in","0");
			    List<ContractFundFundPlan> fundPlanR=new ArrayList<ContractFundFundPlan>();
			    for(ContractFundFundPlan fplan:fundPlan){
			    	fplan.receiverAllMoney(mapPayType);
			        fundPlanR.add(fplan);
			    }
			   if(fundPlanR.size()>0){  
				   variablesMap.put("json_receiverchargeplan_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMap, ""));
			   }
//				资金付款计划
			    fundPlan=this.tableService.findResultsByHSQL(HQL,contractinfo.getContractId() ,"pay_type_out","0");
			    fundPlanR.clear();
			    for(ContractFundFundPlan fplan:fundPlan){
			    	fplan.receiverAllMoney(mapPayType);
			        fundPlanR.add(fplan);
			    }
			   if(fundPlanR.size()>0){  
				   variablesMap.put("json_paychargeplan_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMap, ""));
			   }
		/*	   BigDecimal rate=null;
				   rate=contractinfo.getContractCondition()!=null?contractinfo.getContractCondition().getPenaRate():BigDecimal.ZERO;
				//当前时间
				String cur_date=DateUtil.getSystemDate();*/
				
				/*BigDecimal rate = new BigDecimal("0.00");// 罚息利率
				String cur_date = DateUtil.getSystemDate();
				int freeDefaInterDay = 0;
				rate = new BigDecimal(StringUtil.nullToString(contractinfo.getContractCondition().getPenaRate(), "0.00"));
				freeDefaInterDay = Integer.parseInt(StringUtil.empty2Other(contractinfo.getContractCondition().getFreeDefaInterDay(), "0"));

				*/
				
				//租金回笼计划
				Map<String,String>  queryMainObjectMap =new HashMap<String,String>();
				queryMainObjectMap.put("contract_id",contractid);
				String fund_rent_plans = this.tableService.getJsonArrayData("eleasing/workflow/fund/fund_income/fundIncomePlan.xml", queryMainObjectMap).toString();
				System.out.println("fund_rent_plans:"+fund_rent_plans);
				if ( fund_rent_plans.length() > 0 && null != fund_rent_plans)
				{
					variablesMap.put("fund_rent_plans",fund_rent_plans);
				}
				
				/*HQL="from ContractFundRentPlan as cp where cp.contractId.contractId=? order by  cp.rentList";
				List<ContractFundRentPlan> crentlist=new ArrayList<ContractFundRentPlan>();
				List<ContractFundRentPlan> lastrentlist=new ArrayList<ContractFundRentPlan>();
				crentlist=this.tableService.findResultsByHSQL(HQL, contractinfo.getContractId());
				if(crentlist.size()>0){
					for(ContractFundRentPlan oneRentPlan:crentlist){
						oneRentPlan.initContractFundRentPlan(mapPayType,cur_date,rate,freeDefaInterDay);
						lastrentlist.add(oneRentPlan);
					}
					variablesMap.put("fund_rent_plans", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(lastrentlist, fieldClassMap, ""));
			    }*/
				//资金收款历史
				   List<ContractFundFundCharge> chargeList=new ArrayList<ContractFundFundCharge>();
				   HQL=" from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.payType.code=?";
				   chargeList=this.tableService.findResultsByHSQL(HQL, contractinfo.getContractId(),"pay_type_in");
				   if(chargeList.size()>0){
				    	variablesMap.put("json_receiverchargehistory_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeList, fieldClassMap, ""));
				    }
				//资金付款历史
				   HQL=" from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.payType.code=?";
				   chargeList=this.tableService.findResultsByHSQL(HQL, contractinfo.getContractId(),"pay_type_out");
				   if(chargeList.size()>0){
				    	variablesMap.put("json_contract_fund_payment_history_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeList, fieldClassMap, ""));
				    }
				//租金回笼历史
				HQL="from ContractFundRentInCome as cp where cp.contractId.contractId=? order by  cp.planList";
				List<ContractFundRentPlan> crentincomelist=new ArrayList<ContractFundRentPlan>();
				crentincomelist=this.tableService.findResultsByHSQL(HQL,contractinfo.getContractId());
				if(crentincomelist.size()>0){
				   variablesMap.put("fund_income_history", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(crentincomelist,fieldClassMap, ""));
				}
				 //加入合同物件信息
				 Set<ContractEquip> contractEquips=contractinfo.getContractEquips();
				 for(ContractEquip equip:contractEquips){
					 variablesMap.put("contract_equip.contractid",equip.getContractId().getContractId());
					 if(contractinfo.getProjDept() != null){
						 variablesMap.put("contract_info.projectdept",contractinfo.getProjDept().getName());
					 }
				 }
				//合同非正常结束信息
				//variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(ContractEndInfo.class, null,"contract_end_info"));
				//合同租赁物件
				variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractinfo.getContractEquips(), null,"contract_equip"));
			}else{
				logger.info("contractinfo对象为空");
			}
			//合同登记
				String json_reg_list_str= this.tableService.getJsonArrayData("eleasing/workflow/contract/doc_send_info.xml", queryMainObjectMap1).toString();
				System.out.println("json_reg_list_str:############################"+json_reg_list_str);
				variablesMap.put("json_reg_list_str",json_reg_list_str);

			
		}
	 
	 @Override
	public String delete(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		/** 流程冲突第二步-结束 */
		if (StringUtils.isNotEmpty(variablesMap.get("workFlowFlag"))) {
			WorkFlowFlag w = this.tableService.findEntityByID(WorkFlowFlag.class, variablesMap.get("workFlowFlag"));
			this.tableService.removeEntity(w);
		}
		/** 流程冲突第二步-结束 */
		return null;
	}

	@Override
	public void end(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {}

	@Override
	public String save(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		
		return null;
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
