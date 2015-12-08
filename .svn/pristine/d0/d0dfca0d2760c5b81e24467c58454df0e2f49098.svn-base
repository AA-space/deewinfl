package com.business.action.leasing.contract.terminate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.business.action.JbpmBaseAction;
import com.business.action.leasing.contract.approval.ContractApprovalStartAction;
import com.business.entity.DictionaryData;
import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.User;
import com.business.entity.base.WorkFlowFlag;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.kernal.annotation.WorkflowAction;
import com.kernal.utils.DateUtil;
import com.kernal.utils.MathUtil;
import com.kernal.utils.SecurityUtil;
import com.kernal.utils.StringUtil;

@WorkflowAction(name = "contractTerminateStartAction", description = "流程开始动作", workflowName = "合同中途终止流程")
@Component(value = "contractTerminateStartAction")
public class ContractTerminateStartAction  implements JbpmBaseAction {
	@Resource(name = "tableService")
	private TableService tableService;
	@Resource(name="contractApprovalStartAction")
	private ContractApprovalStartAction contractApprovalStartAction;
	
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
	@Override
	public void start(HttpServletRequest request, Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		//合同基本信息
		//资金收款计划
		//资金付款计划
		//租金回笼计划
		//资金收款历史
		//资金付款历史
		//租金回笼历史
		//剩余保证金计算
		String contractid = variablesMap.get("contract_id");
		
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
		
		String cust_id = variablesMap.get("cust_id");
		ContractInfo contractInfo = (ContractInfo)this.tableService.findEntityByID(ContractInfo.class, contractid);
		variablesMap.put("law_d", contractInfo.getContractSignatory()==null?"":contractInfo.getContractSignatory().getLeasePerson());
		CustInfo cust = (CustInfo)this.tableService.findEntityByID(CustInfo.class, cust_id);
		String HQL="";
		HashMap<String,String> fieldClassMap=new HashMap<String,String>();
		fieldClassMap.put("DictionaryData", "name");
		fieldClassMap.put("User", "id");
		fieldClassMap.put("ProjInfo", "projId");
		fieldClassMap.put("FundEbankData", "ebdataId");
		fieldClassMap.put("ContractInfo", "contractId");
		fieldClassMap.put("FundFundChargePlan", "paymentId");
		String doc_id = jbpmWorkflowHistoryInfo.getHistoryProcessInstanceImpl().getDbid() + "";
		contractApprovalStartAction.saveConditionDataToTemp(contractInfo, doc_id, tableService);
		
		String contract_id = variablesMap.get("contract_id");
		Map<String, String> queryMainObjectMap1 = new HashMap<String, String>();
		queryMainObjectMap1.put("contract_id", contract_id);
		if (!contractInfo.getContractEquips().isEmpty()) {// 租赁物明细
			variablesMap.put("json_proj_equip_str", this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_equip2.xml", queryMainObjectMap1).toString());
			System.out.println(variablesMap.get("json_proj_equip_str"));
		}
		if(contractInfo!=null){
			// 加入合同基本信息
			variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(contractInfo, null, "contract_info"));
			// 加入客户信息   
			variablesMap.put("contract_info.custname",cust.getCustName());
			variablesMap.put("contract_info.custnumber",cust.getCustNumber());
			variablesMap.put("contract_info.custid", cust.getId());
			variablesMap.put("contract_info.projid", contractInfo.getProjId().getProjId());
			HQL=" from DictionaryData AS DD where DD.belongDictionary.code=? ";
			List<DictionaryData> listpayType=new ArrayList<DictionaryData>();
			//查出资金状态
			listpayType=this.tableService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
			HashMap<String,DictionaryData> mapPayType=new HashMap<String,DictionaryData>();
			for(DictionaryData dd:listpayType){
				mapPayType.put(dd.getCode(), dd);
			}
			//资金收款计划
			BigDecimal planMoneyIn = BigDecimal.ZERO;
			BigDecimal factmoneyIn = BigDecimal.ZERO;
			BigDecimal planMoneyOut = BigDecimal.ZERO;
			BigDecimal factmoneyOut = BigDecimal.ZERO;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date systemDate = dateFormat.parse(DateUtil.getSystemDate());
			Date planDate = null;
			HQL=" from ContractFundFundPlan as fc where fc.contractId.contractId=? and fc.payType.code=? and fc.invalid=?";
		    List<ContractFundFundPlan> fundPlan=new ArrayList<ContractFundFundPlan>();
		    fundPlan=this.tableService.findResultsByHSQL(HQL,contractInfo.getContractId() ,"pay_type_in","0");
		    List<ContractFundFundPlan> fundPlanR=new ArrayList<ContractFundFundPlan>();
		    for(ContractFundFundPlan fplan:fundPlan){
		    	fplan.receiverAllMoney(mapPayType);
		        fundPlanR.add(fplan);
		        System.out.println(fplan.getPlanDate());
		        planDate = dateFormat.parse(fplan.getPlanDate());
		        if(planDate.before(systemDate)){
		        	planMoneyIn = planMoneyIn.add(fplan.getPlanMoney());
		        }
		    }
		   if(fundPlanR.size()>0){  
			   variablesMap.put("json_receiverchargeplan_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMap, ""));
		   }
			//资金付款计划
		    fundPlan=this.tableService.findResultsByHSQL(HQL,contractInfo.getContractId() ,"pay_type_out","0");
		    fundPlanR.clear();
		    for(ContractFundFundPlan fplan:fundPlan){
		    	fplan.receiverAllMoney(mapPayType);
		        fundPlanR.add(fplan);
		        planDate = dateFormat.parse(fplan.getPlanDate());
		        if(planDate.before(systemDate)){
		        	planMoneyOut = planMoneyOut.add(fplan.getPlanMoney());
		        }
		    }
		   if(fundPlanR.size()>0){  
			   variablesMap.put("json_paychargeplan_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(fundPlanR, fieldClassMap, ""));
		   }
		/*   //罚息利率
		   BigDecimal rate;
		   rate=contractInfo.getContractCondition()!=null?contractInfo.getContractCondition().getPenaRate():BigDecimal.ZERO;
			//当前时间
			String cur_date=DateUtil.getSystemDate();
			//免罚息天数 
			int freeDefaInterDay = 0;
			ContractCondition condition = contractInfo.getContractCondition();
			freeDefaInterDay =0;// condition.getFreeDefaInterDay() != null ? condition.getFreeDefaInterDay():0;
			*/
			
			
			BigDecimal rate = new BigDecimal("0.00");// 罚息利率
			String cur_date = DateUtil.getSystemDate();
			int freeDefaInterDay = 0;
			rate = new BigDecimal(StringUtil.nullToString(contractInfo.getContractCondition().getPenaRate(), "0.00"));
			freeDefaInterDay = Integer.parseInt(StringUtil.empty2Other(contractInfo.getContractCondition().getFreeDefaInterDay(), "0"));

			
			
			
			//租金回笼计划
			BigDecimal rentPlanMoneyExpire = BigDecimal.ZERO;//到期租金
			BigDecimal rentFactmoneyExpire = BigDecimal.ZERO;
			BigDecimal rentPlanMoneyW = BigDecimal.ZERO;//未到期租金
			BigDecimal rentFactmoneyW = BigDecimal.ZERO;
			HQL="from ContractFundRentPlan as cp where cp.contractId.contractId=? order by  cp.rentList";
			List<ContractFundRentPlan> crentlist=new ArrayList<ContractFundRentPlan>();
			List<ContractFundRentPlan> lastrentlist=new ArrayList<ContractFundRentPlan>();
			crentlist=this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId());
			if(crentlist.size()>0){
				for(ContractFundRentPlan oneRentPlan:crentlist){
					oneRentPlan.initContractFundRentPlan(mapPayType,cur_date,rate,freeDefaInterDay);
					lastrentlist.add(oneRentPlan);
					planDate = dateFormat.parse(oneRentPlan.getPlanDate());
					if(planDate.before(systemDate)){
						rentPlanMoneyExpire = rentPlanMoneyExpire.add(oneRentPlan.getRent());
			        }
				}
				variablesMap.put("fund_rent_plans", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(lastrentlist, fieldClassMap, ""));
		    }
			//资金收款历史
		    List<ContractFundFundCharge>chargeList=new ArrayList<ContractFundFundCharge>();
		    HQL=" from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.payType.code=?";
		    chargeList=this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId(),"pay_type_in");
		    for (ContractFundFundCharge contractFundFundCharge : chargeList) {
				planDate = dateFormat.parse(contractFundFundCharge.getFactDate());
				if(planDate.before(systemDate)){
					factmoneyIn = factmoneyIn.add(contractFundFundCharge.getFactMoney());
				}
			}
		    if(chargeList.size()>0){
		    	variablesMap.put("json_receiverchargehistory_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeList, fieldClassMap, ""));
		    }
			//资金付款历史
			HQL=" from ContractFundFundCharge as fc where fc.contractId.contractId=? and fc.payType.code=?";
			chargeList=this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId(),"pay_type_out");
			for (ContractFundFundCharge contractFundFundCharge : chargeList) {
				planDate = dateFormat.parse(contractFundFundCharge.getFactDate());
				if(planDate.before(systemDate)){
					factmoneyOut = factmoneyOut.add(contractFundFundCharge.getFactMoney());
				}
			}
			if(chargeList.size()>0){
			    variablesMap.put("json_contract_fund_payment_history_str",this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(chargeList, fieldClassMap, ""));
			}
			//租金回笼历史
			HQL="from ContractFundRentInCome as cp where cp.contractId.contractId=? order by  cp.planList";
			List<ContractFundRentPlan> crentincomelist=new ArrayList<ContractFundRentPlan>();
			crentincomelist=this.tableService.findResultsByHSQL(HQL,contractInfo.getContractId());
			if(crentincomelist.size()>0){
			   variablesMap.put("fund_income_history", this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(crentincomelist,fieldClassMap, ""));
			}
			// 租金计划相关数据
			
			Map<String, String> queryMainObjectMap = new HashMap<String, String>();
			queryMainObjectMap.put("contract_id", contractInfo.getId());
			queryMainObjectMap.put("equipAmt", contractInfo.getContractCondition().getEquipAmt().toString());
			String json_fund_rent_plan_str= this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_fund_rent_plan.xml", queryMainObjectMap).toString();
			//变更基本信息
			variablesMap.put("fund_rent_adjust.contractid", contractInfo.getId());
			variablesMap.put("fund_rent_adjust.contract", contractInfo.getContractId());
			variablesMap.put("fund_rent_adjust.docid", doc_id);
			variablesMap.put("fund_rent_adjust.nowdate", DateUtil.getSystemDate());
			variablesMap.put("fund_rent_adjust.adjustlist", contractInfo.getContractFundRentPlans().size()+"");
			variablesMap.put("fund_rent_adjust.paydayadjust", DateUtil.getSystemDate());
			variablesMap.put("fund_rent_adjust.yearrate", contractInfo.getContractCondition()!=null?contractInfo.getContractCondition().getYearRate().toString():"");
			variablesMap.put("fund_rent_adjust.adjusttype", "his_contract_end");
			variablesMap.put("json_fund_rent_plan_str",json_fund_rent_plan_str);
			//variablesMap.put("fund_rent_adjust.otherin",(planMoneyIn.subtract(factmoneyIn).abs()).toString());
			//variablesMap.put("fund_rent_adjust.otherout",(planMoneyOut.subtract(factmoneyOut).abs()).toString());
			
			variablesMap.put("fund_rent_adjust.otherin","0");
			variablesMap.put("fund_rent_adjust.otherout","0");
			variablesMap.put("fund_rent_adjust.handlingcharge","3000");//违约手续费默认3000
			variablesMap.put("fund_rent_adjust.advancerate","100"); 
			variablesMap.put("fund_rent_adjust.paydayadjust",DateUtil.getSystemDate()); 
			
			
			//剩余保证金计算
			getMargin(variablesMap, contractInfo.getContractId());
			
		}
			/*String curday=DateUtil.getSystemTimeByFormat("yyyy-MM-dd HH:mm:ss"); 
		   while(!curday.equals("2014-10-30 18:30:00"))
		   { 
		    curday=DateUtil.getSystemTimeByFormat("yyyy-MM-dd HH:mm:ss"); 
		   } */


	}
	private void getMargin(Map<String, String> variablesMap, String contractid)
			throws Exception {
		String HQL;
		//保证金信息 (用到的表：CONTRACT_FUND_FUND_CHARGE(合同资金实收表),CONTRACT_FUND_RENT_INCOME(租金回笼实际))
		//总保证金 = Sum((收支金额+费用调整)*1.00) 条件= 合同号&费用类型&收付方式（收）
		HQL = "select sum((nvl(cffc.factMoney,0.00)+nvl(cffc.feeAdjust,0.00))*1) from ContractFundFundCharge cffc where cffc.contractId.contractId=? and cffc.feeType.code=? and cffc.payType.code=?";
		List zbzj = tableService.findResultsByHSQL(HQL,contractid,"feetype2","pay_type_in");
		String cautionmoney = zbzj.get(0)==null?"0.00":zbzj.get(0).toString();
		System.out.println("总保证金cautionmoney="+cautionmoney);
		
		//已还保证金 = Sum((收支金额+费用调整)*1.00) 条件= 合同号&费用类型&收付方式（付）
		HQL = "select sum((nvl(cffc.factMoney,0.00)+nvl(cffc.feeAdjust,0.00))*-1) from ContractFundFundCharge cffc where cffc.contractId.contractId=? and cffc.feeType.code=? and cffc.payType.code=?";
		List yhbzj = tableService.findResultsByHSQL(HQL,contractid,"feetype2","pay_type_out" );
		String _incomecaution = yhbzj.get(0)==null?"0.00":yhbzj.get(0).toString();
		System.out.println("已还保证金 _incomecaution="+_incomecaution);
		
		//已抵扣保证金=  租金回笼实收表里面的 回笼租金+回笼罚息的和  条件 合同编号，结算方式=保证金抵扣租金
		HQL = "select sum(nvl(cfri.rent,0.00))+sum(nvl(cfri.penalty,0.00)) from ContractFundRentInCome cfri where cfri.contractId.contractId=? and cfri.balanceMode.code=?";
		List ydkbzj = tableService.findResultsByHSQL(HQL,contractid,"PayFund7");
		String _deduction = ydkbzj.get(0)==null?"0.00":ydkbzj.get(0).toString();
		System.out.println("已抵扣保证金=_deduction="+_deduction);
		
		//剩余保证金 = 总保证金-已还保证金-已抵扣保证金
		System.out.println("cautionmoney==="+MathUtil.parseDecimal(cautionmoney,3));
		Double surplusmoney = MathUtil.parseDecimal(cautionmoney,3) - MathUtil.parseDecimal(_incomecaution,3) - MathUtil.parseDecimal(_deduction,3);
		System.out.println("surplusmoney="+surplusmoney);
		variablesMap.put("fund_rent_adjust.deductible", surplusmoney+"0");
	}
	
	@Override
	public void back(HttpServletRequest request,
			Map<String, String> variablesMap,JBPMWorkflowHistoryInfo jbpmWorkflowHistoryInfo) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
