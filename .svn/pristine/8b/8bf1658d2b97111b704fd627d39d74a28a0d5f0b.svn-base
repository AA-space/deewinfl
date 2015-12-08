/**
 * 项目名称：    系统名称
 * 包名：              com.business.serviceImpl.cust
 * 文件名：         CustServiceImpl.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-5-18-下午12:30:07
 * Copyright：2013XX公司-版权所有
 **/

package com.business.serviceImpl.check;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.ContractLimitInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPayCollect;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.insurance.ContractInsuranceSureInfo;
import com.business.entity.proj.ProjInfo;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.business.service.check.CheckStartingWorkFlowServer;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.google.inject.internal.Maps;


/**
 * @author Jason
 * @date 2013-5-21
 * @info 
 */
@Service(value = "checkStartingWorkFlowService")
public class CheckStartingWorkFlowServiceImpl extends AbstractBaseServiceImpl implements CheckStartingWorkFlowServer {

	//租金类计划流程
	private final String[] rentString = {"租金计划变更","租金计划修改","期末保证金抵扣","调息","合同中途终止","租金回笼流程"};
	//资金类流程
	private final String[] chargeString = {"资金计划变更流程","付款流程","收款流程","实际投放流程"};
	
	private final String[] equipString = {"设备验收流程",};
	
	@Resource
	private BaseDao baseDao;
	
	@Resource(name = "tableService")
	private TableService tableService;

	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}

	@Override
	public List<Map<String, String>> getWorkFlowStatus(String seriesNumber) throws DataAccessException, Exception {
		String sql = "select tl.workflow_display_name_ as workflowName, " 
						+ "tl.processinstance_state_ as status, " 
						+ "tr.realname " 
						+ "from (select * " 
						+ "      from t_jbpm_workflow_info "
						+ "      where jbpm4_hist_actinst_dbid_ is not null " 
						+ "      and (processinstance_state_ = '待处理' or processinstance_state_ = '草稿') " 
						+ "      and key_one_ = '" + seriesNumber + "') tl "
						+ "inner join (select tll.jbpmworkflowhistoryinfo_id_, trr.realname_ || '（' || trr.username_ || '）' as realname " 
						+ "           from (select * "
						+ "                from t_jbpm_workflow_infos_users " 
						+ "                where end_time_ is null) tll " 
						+ "left join (select * from t_users) trr "
						+ "           on trr.id_ = tll.plan_actor_user_id_) tr "
						+ "on tr.jbpmworkflowhistoryinfo_id_ = tl.id_ ";
		List rows = this.baseDao.getJdbcTemplate().queryForList(sql);
		List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
		Map<String,String> returnMap = new HashMap<String, String>();
		Iterator it = rows.iterator();   
		while(it.hasNext()) {   
		    Map rowMap = (Map) it.next();
		    rowList.add(rowMap);
		} 
		
		//取id一个结果
		/*if(!rowList.isEmpty()){
			returnMap = rowList.get(0);
		}*/
		return rowList;
	}

	@Override
	public Map<String, String> checkWorkFlow(HttpServletRequest request) throws DataAccessException, Exception {
		 Map<String, String> returnMap  = new HashMap<String, String>();
		//项目id,必传递项目
    	String projID = request.getParameter("projID");
    	String contractID = request.getParameter("contractID");
    	String workFlow =request.getParameter("workFlow");
    	String status = request.getParameter("status");
    
    	//是否通过验证,数组为不通过原因
    	Set<String> checkStats = new HashSet<String>();
    	String failreason = null;
    	ProjInfo projInfo = null;
    	ContractInfo contractInfo = null;
    	Integer workFlowFlag = null;
    	String seriesNumber = null;
		int realityStatus = -1;
		
    	//根据前台传输的条件判断是否符合条件
    	if(projID != null){
    		projInfo = (ProjInfo) this.baseDao.findEntityByID(ProjInfo.class, projID);
    		workFlowFlag = projInfo.getWorkFlag();
    		seriesNumber = projInfo.getProjId();
    		realityStatus = projInfo.getProjStatus();
    	} else if(contractID != null){
    		contractInfo = (ContractInfo) this.baseDao.findEntityByID(ContractInfo.class, contractID);
    		workFlowFlag = contractInfo.getWorkFlag();
    		seriesNumber = contractInfo.getContractId();
    		realityStatus = contractInfo.getContractStatus();
    	} else{
			throw new BusinessException("流程发起检查中的项目ID【projID】或合同ID【contractID】不能为空");
    	}
    	
    	//是否处项目在流程中
    	if(workFlow != null ){
    		if(workFlowFlag != Integer.parseInt(workFlow)){
    			checkStats.add("workFlow");
    		}
    	}
    	
		// 流程状态
		if (status != null) {
			if (!isInStatus(status, realityStatus)) {
				checkStats.add("status");
			}
		}

    	//如果项目处在流程中，得出流程状态
    	if((checkStats.contains("workFlow") && workFlowFlag == 1)){
    		List<Map<String,String>> statusList= this.getWorkFlowStatus(seriesNumber);
    		//Iterator it = statusList.iterator();
    		if(statusList!=null&&statusList.size()>0){//孙传良增加非空判断
    			returnMap =  statusList.get(0);
    		}
    		
    	}
    	
    	if(!checkStats.isEmpty()){
			failreason = checkStats.toString();
			failreason = failreason.substring(1,failreason.length()-1).replace(" ", "");
    	}
		if(failreason!= null){
			returnMap.put("failreason", failreason);
		}
		return returnMap;
	}

	@Override
	public Map<String, String> checkContractStart(HttpServletRequest request) throws DataAccessException, Exception {
		 Map<String, String> returnMap  = new HashMap<String, String>();
	    	String projID = request.getParameter("projID");
	    	String currentAmt = request.getParameter("currentAmt");
	    	returnMap.put("result", "success");
	    	
	    	
	    	ProjInfo projInfo = (ProjInfo) this.baseDao.findEntityByID(ProjInfo.class, projID);
			
			//合同总设备款
			Map<String,Object> propertiesMap = new HashMap<String, Object>();
			propertiesMap.put("projId", projInfo);
			List<ContractInfo> contractInfos = this.baseDao.findEntityByProperties(ContractInfo.class, propertiesMap);
			
			if(contractInfos.size() > 0){//状态为21而且 合同款大于等于设备款
				//项目设备款
				BigDecimal projEquipAmt = projInfo.getProjCondition().getEquipAmt();
				BigDecimal contractEquipAmt =BigDecimal.ZERO;
				
				Iterator it = contractInfos.iterator();
				int number = 0;
				while(it.hasNext()) {   
					ContractInfo contractInfo = (ContractInfo) it.next();
					if(contractInfo.getContractCondition() != null ){
						//判断状态
						int contractStatus = contractInfo.getContractStatus();
						if( contractStatus >15 && contractStatus < 100){
							contractEquipAmt =contractEquipAmt.add( contractInfo.getContractCondition().getEquipAmt());
							number++;
						}
					}
				} 
				
				//当前发起设备金额 当有合同审批第一步提交时,有金额
			if (currentAmt != null) {
				contractEquipAmt = contractEquipAmt.add(new BigDecimal(
						currentAmt));
				if (projEquipAmt.compareTo(contractEquipAmt) < 0) {
					returnMap.put("result", "error");
					returnMap.put("contractEquipAmt", contractEquipAmt
							.toString());
					returnMap.put("projEquipAmt", projEquipAmt.toString());
					returnMap.put("number", String.valueOf(number));

				}
				//合同审批发起时没有金额
			} else {
				if (projEquipAmt.compareTo(contractEquipAmt) <= 0) {
					returnMap.put("result", "error");
					returnMap.put("contractEquipAmt", contractEquipAmt
							.toString());
					returnMap.put("projEquipAmt", projEquipAmt.toString());
					returnMap.put("number", String.valueOf(number));

				}
			} 
		}
		return returnMap;
	}
	@Override
	public Map<String, String> checkContractOnhireStart(HttpServletRequest request) throws DataAccessException, Exception {
		Map<String, String> returnMap  = new HashMap<String, String>();
		String contractId = request.getParameter("contract_id");
		System.out.println(contractId+"=-=-=-=-=");
		ContractInfo contractInfo = this.baseDao.findEntityByID(ContractInfo.class,contractId);
		Map<String,Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("contractId", contractInfo);
		List<ContractInsuranceSureInfo> contractInsuranceSureInfos = this.baseDao.findEntityByProperties(ContractInsuranceSureInfo.class, propertiesMap);
		//System.out.println(contractInsuranceSureInfos.get(0).getIsSure()+"=-=-=-=-=-=");
		String isGPS = gpsInstalled(contractId);
		//判断保险方式
		if(contractInsuranceSureInfos.size() > 0 && contractInsuranceSureInfos != null){
			returnMap.put("result","1");
		}else{
			returnMap.put("result","-1");
		}
		//GPS 没有安装
		if(isGPS=="-4"){
			returnMap.put("result","-4");
		}
		
		
		 //实际收取首付款
	     Map<String, String> model = Maps.newHashMap(); 
	     model.put("contract_id", contractId);
	     //model.put("fee_type", "feetype5");
	     
	     JSONArray jsonArray = this.tableService.getJsonArrayData("eleasing/workflow/public/fundfundPlanSelectfirstmoney.xml", model);
	     //JSONObject jsonObj  plan_first_fact_money
	     if(jsonArray.length()>0){
	    	 BigDecimal planmoney=new BigDecimal(jsonArray.getJSONObject(0).get("plan_money").toString());
	    	 BigDecimal factmoney=new BigDecimal(jsonArray.getJSONObject(0).get("plan_first_fact_money").toString());
	    	 
	        System.out.println("收取首付款:"+planmoney+"==="+factmoney);
	        if(factmoney.compareTo(planmoney)==-1){
	        	returnMap.put("result","-5");
	        }
	     }
	     
	     //投放问题处理
	     /*String iscredit = creditOut(contractId);
	    	 
    	 if(iscredit =="equipAmt_lt")
    	 {
    		 returnMap.put("result","equipAmt_lt"); //返回设备款【小于等于】 放车额度 +电汇金额 卡住不能投放
    	 }*/
		return returnMap;
	}
	
	/**
	 * GPS是否安装检测
	 * @param contractId
	 * @return
	 * @throws Exception
	 */
	private String gpsInstalled(String contractId) throws Exception {
		String messge = "";
			String  hsql = "FROM GPSInfo GPS  where 1=1 and GPS.isGPS='0' and GPS.contractId.id=?";
			List<ContractEquip> contractEquipList = this.baseDao.findResultsByHSQL(hsql, contractId);
			//该合同没有GPS信息
			if(contractEquipList.isEmpty()){
				messge = "-4";
				return messge;
			}else{
				messge = "4";
				return messge;
			}
	}
	/**
	 * 实际投放放款问题
	 * @param contractId
	 * @return
	 * @throws Exception
	 */
	private String creditOut(String contractId) throws Exception {
		String messge = "";
		String  hsql = "FROM ContractCondition cd  where 1=1 and cd.contractId.id=?";
		List<ContractCondition> contractConditionlist = this.baseDao.findResultsByHSQL(hsql, contractId);
		
		//放车额度 
		String hsql2 ="from ContractLimitInfo cl   where 1=1 and cl.contractId.id=? ";
		List<ContractLimitInfo> contractLimitInfolist = this.baseDao.findResultsByHSQL(hsql2, contractId);
		BigDecimal limitMoney = BigDecimal.ZERO;
		
		//汇总值
		BigDecimal  totalmoney= BigDecimal.ZERO;
		
		//该合同没有实际投放放款信息
		if(contractConditionlist.isEmpty()){
			messge = "no";
			return messge;
		}else{
			BigDecimal  equipAmt= contractConditionlist.get(0).getEquipAmt(); //设备款
			System.out.println("##########################");
			System.out.println("contractId:"+contractId);
			System.out.println("##########################");
			System.out.println("equipAmt:"+equipAmt);
			
			//已投放金额
			BigDecimal payMoney =BigDecimal.ZERO;
			String yhql="from ContractFundFundPayCollect where 1=1 and contractId.id=?";
			List<ContractFundFundPayCollect> contractFundFundPayCollectlist = this.baseDao.findResultsByHSQL(yhql, contractId);
			if ( contractFundFundPayCollectlist.size() > 0 )
			{
				for (int i = 0; i < contractFundFundPayCollectlist.size(); i++)
				{
					payMoney = payMoney.add(contractFundFundPayCollectlist.get(i).getPlanMoney());
				}
			}
			if (payMoney.compareTo(equipAmt)>=0)
			{
				messge = "equipAmt_lt"; //卡住不允许投放
			}
			/*
			//电汇金额
			BigDecimal  cable_transfer= BigDecimal.ZERO;
			String hsql3 ="from ContractFundFundPlan  where 1=1 and contractId.id=? and feeType.code=?";
			List<ContractFundFundPlan> contractFundFundPlanlist = this.baseDao.findResultsByHSQL(hsql3, contractId,"feetype10");
			
			if ( contractLimitInfolist.size() > 0)
			{
				for ( int i=0; i<contractLimitInfolist.size(); i++)
				{
					limitMoney = limitMoney.add(contractLimitInfolist.get(i).getLimitMoney());//放车额度
				}
			}
			System.out.println("##########################");
			System.out.println("limitMoney:"+limitMoney);//打印放车额度
			int counts = 0;//判断条数
			if( !limitMoney.equals(BigDecimal.ZERO) ) //判断额度为零点情况
			{
				String hqllimit="from ContractFundFundCharge cg   where 1=1 and cg.contractId.id=? ";
				List<ContractFundFundCharge> ContractFundFundChargelist = this.baseDao.findResultsByHSQL(hqllimit, contractId);
				counts = ContractFundFundChargelist.size();//判断条数
			}
			
			if ( contractFundFundPlanlist.get(0) !=null )
			{
				cable_transfer = contractFundFundPlanlist.get(0).getPlanMoney().subtract(limitMoney); //电汇金额=计划投放值-放车额度
			}
			System.out.println("##########################");
			System.out.println("cable_transfer:"+cable_transfer);
			System.out.println("##########################");
			
		    totalmoney = cable_transfer.add(limitMoney); //放车额度 +电汇金额  与 设备款比较
			System.out.println("totalmoney:"+totalmoney);
			System.out.println("##########################");
			if (totalmoney.compareTo(equipAmt) ==-1) 
			{
				messge = "totoal_lt"; //放车额度 +电汇金额 小于设备款
			}
			else if(counts > 0)
			{
				if (totalmoney.compareTo(equipAmt) >=0)
				{
					messge = "equipAmt_lt";//与上相反  卡住不允许投放
				}
			}
			else if (counts==0)
			{
				messge ="-5";//说明未收首付
			}
			*/
			else
			{
				messge ="1";
			}
			return messge;
		}
	}
	
	@Override
	public Map<String, String> checkCharge(HttpServletRequest request) throws DataAccessException, Exception {
		 Map<String, String> returnMap  = new HashMap<String, String>();
		//项目id,必传递项目
    	String contractID = request.getParameter("contractID");
    	String chargeWorkFlow = request.getParameter("workFlow");
    	String chargeStatus = request.getParameter("status");
    
    	//是否通过验证,数组为不通过原因
    	Set<String> checkStats = new HashSet<String>();
    	String failreason = null;
    	ContractInfo contractInfo = null;
    	Integer chargeWorkFlowFlag = null;
    	String seriesNumber = null;
		int chargeRealityStatus = -1;
		
    	//根据前台传输的条件判断是否符合条件
    	if(contractID != null){
    		contractInfo = (ContractInfo) this.baseDao.findEntityByID(ContractInfo.class, contractID);
    		seriesNumber = contractInfo.getContractId();
    		chargeRealityStatus = contractInfo.getContractStatus();
    		if(chargeWorkFlow != null){
    			Set<ContractFundFundPlan> fundFundChargePlans = contractInfo.getFundFundChargePlans();
    			Iterator it = fundFundChargePlans.iterator();
    			if(it.hasNext()) {//设备集合中，如有一个设备状态为1，则都为1.所以只取一个。
    				ContractFundFundPlan fundFundChargePlan = (ContractFundFundPlan) it.next();
    				chargeWorkFlowFlag = fundFundChargePlan.getWorkFlag();
				}
    		}
    	} 
    	
    	//项目资金是否在流程中
    	if(chargeWorkFlowFlag != null){
    		if(chargeWorkFlowFlag != Integer.parseInt(chargeWorkFlow)){
    			checkStats.add("workFlow");
    		}
    	}
    	
    	// 流程状态
		if (chargeStatus != null) {
			if (!isInStatus(chargeStatus, chargeRealityStatus)) {
				checkStats.add("status");
			}
		}
    	//如果项目处在流程中，得出流程状态
    	if((checkStats.contains("workFlow") && chargeWorkFlowFlag == 1)){
    		if(this.getWorkFlowStatus(seriesNumber).size()>0){
	    		  returnMap = this.getWorkFlowStatus(seriesNumber).get(0);
	    	}
    	}
    	
    	if(!checkStats.isEmpty()){
			failreason = checkStats.toString();
			failreason = failreason.substring(1,failreason.length()-1).replace(" ", "");
    	}
		if(failreason!= null){
			returnMap.put("failreason", failreason);
		}
		return returnMap;
	}

	@Override
	public Map<String, String> checkRent(HttpServletRequest request) throws DataAccessException, Exception {
		 Map<String, String> returnMap  = new HashMap<String, String>();
			//项目id,必传递项目
	    	String contractID = request.getParameter("contractID");
	    	String rentWorkFlow = request.getParameter("workFlow");
	    	String rentStatus = request.getParameter("status");
	    
	    	//是否通过验证,数组为不通过原因
	    	Set<String> checkStats = new HashSet<String>();
	    	String failreason = null;
	    	ContractInfo contractInfo = null;
	    	Integer rentWorkFlowFlag = null;
	    	String seriesNumber = null;
			int rentRealityStatus = -1;
			
	    	//根据前台传输的条件判断是否符合条件
	    	if(contractID != null){
	    		contractInfo = (ContractInfo) this.baseDao.findEntityByID(ContractInfo.class, contractID);
	    		seriesNumber = contractInfo.getContractId();
	    		rentRealityStatus = contractInfo.getContractStatus();
	    		if(rentWorkFlow != null){
	    			Set<ContractFundRentPlan> contractFundRentPlans = contractInfo.getContractFundRentPlans();
	    			Iterator it = contractFundRentPlans.iterator();
	    			if(it.hasNext()) {//设备集合中，如有一个设备状态为1，则都为1.所以只取一个。
	    				ContractFundRentPlan contractFundRentPlan = (ContractFundRentPlan) it.next();
	    				rentWorkFlowFlag = contractFundRentPlan.getWorkFlag();
					}
	    		}
	    	} 
	    	
	    	//项目资金是否在流程中
	    	if(rentWorkFlowFlag != null){
	    		if(rentWorkFlowFlag != Integer.parseInt(rentWorkFlow)){
	    			checkStats.add("workFlow");
	    		}
	    	}
	    	
	    	// 流程状态
			if (rentStatus != null) {
				if (!isInStatus(rentStatus, rentRealityStatus)) {
					checkStats.add("status");
				}
			}
	    	//如果项目处在流程中，得出流程状态
	    	if((checkStats.contains("workFlow") && rentWorkFlowFlag == 1)){
	    		returnMap = this.getWorkFlowStatus(seriesNumber).get(0);
	    	}
	    	
	    	if(!checkStats.isEmpty()){
				failreason = checkStats.toString();
				failreason = failreason.substring(1,failreason.length()-1).replace(" ", "");
	    	}
			if(failreason!= null){
				returnMap.put("failreason", failreason);
			}
			return returnMap;
	}

	@Override
	public Map<String, String> checkEquip(HttpServletRequest request) throws DataAccessException, Exception {
		 Map<String, String> returnMap  = new HashMap<String, String>();
			//项目id,必传递项目
	    	String contractID = request.getParameter("contractID");
	    	String equipWorkFlow = request.getParameter("workFlow");
	    	String equipStatus = request.getParameter("status");
	    
	    	//是否通过验证,数组为不通过原因
	    	Set<String> checkStats = new HashSet<String>();
	    	String failreason = null;
	    	ContractInfo contractInfo = null;
	    	Integer equipWorkFlowFlag = null;
	    	String seriesNumber = null;
			int equipRealityStatus = -1;
			
	    	//根据前台传输的条件判断是否符合条件
	    	if(contractID != null){
	    		contractInfo = (ContractInfo) this.baseDao.findEntityByID(ContractInfo.class, contractID);
	    		seriesNumber = contractInfo.getContractId();
	    		equipRealityStatus = contractInfo.getContractStatus();
	    		if(equipWorkFlow != null){
	    			Set<ContractEquip> contractEquips = contractInfo.getContractEquips();
	    			Iterator it = contractEquips.iterator();
	    			if(it.hasNext()) {//设备集合中，如有一个设备状态为1，则都为1.所以只取一个。
	    				ContractEquip contractEquip = (ContractEquip) it.next();
	    				equipWorkFlowFlag = contractEquip.getWorkFlag();
					}
	    		}
	    	} 
	    	
	    	//项目资金是否在流程中
	    	if(equipWorkFlowFlag != null){
	    		if(equipWorkFlowFlag != Integer.parseInt(equipWorkFlow)){
	    			checkStats.add("workFlow");
	    		}
	    	}
	    	
	    	// 流程状态
			if (equipStatus != null) {
				if (!isInStatus(equipStatus, equipRealityStatus)) {
					checkStats.add("status");
				}
			}
	    	//如果项目处在流程中，得出流程状态
	    	if((checkStats.contains("workFlow") && equipWorkFlowFlag == 1)){
	    		returnMap = this.getWorkFlowStatus(seriesNumber).get(0);
	    	}
	    	
	    	if(!checkStats.isEmpty()){
				failreason = checkStats.toString();
				failreason = failreason.substring(1,failreason.length()-1).replace(" ", "");
	    	}
			if(failreason!= null){
				returnMap.put("failreason", failreason);
			}
			return returnMap;
	}
	
	/**
	 * 判断是否在状态是否在规定的状态中
	 * @param status 传入条件 格式：status = "LessThan:30;GreaterThan:20";
	 * @param realityStatus 项目目前实际状态
	 * @return
	 */
	public Boolean isInStatus(String status, Integer realityStatus) {
		// isInStatus一旦为false 可以退出循环
		Boolean isInStatus = true;
		
		//Equal：等于，NotEqual，不等于，GreaterThanEqual大于等于，LessThanEqual 小与等于， LessThan小与，GreaterThan 大于
    	List<Map<String,String>> conditionList = new ArrayList<Map<String,String>>();
    	if(status != null){
    		String[] _temCondition = status.split(";");
    		for (int i = 0; i < _temCondition.length; i++) {
    			Map<String,String> condiMap = new HashMap<String, String>();
    			String[] _tem =  _temCondition[i].split(":");
        		condiMap.put("operator", _tem[0]);
        		condiMap.put("expectStatus",_tem[1]);
        		conditionList.add(condiMap);
			}
    	}
		
		
		for (int i = 0; i < conditionList.size(); i++) {
			int expectStatus = Integer.parseInt(conditionList.get(i).get("expectStatus"));
			String operator = conditionList.get(i).get("operator");
			if (operator.equals("Equal")) {
				if (realityStatus == expectStatus) {
				} else {
					return false;
				}
			} else if (operator.equals("NotEqual")) {
				if (realityStatus != expectStatus) {
				} else {
					return false;
				}
			} else if (operator.equals("GreaterThanEqual")) {
				if (realityStatus >= expectStatus) {
				} else {
					return false;
				}
			} else if (operator.equals("LessThanEqual")) {
				if (realityStatus <= expectStatus) {
				} else {
					return false;
				}
			} else if (operator.equals("LessThan")) {
				if (realityStatus < expectStatus) {
				} else {
					return false;
				}
			} else if (operator.equals("GreaterThan")) {
				if (realityStatus > expectStatus) {
				} else {
					return false;
				}
			}
		}

		return isInStatus;
	}

}
