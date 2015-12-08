package com.tenwa.leasing.rent.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kernal.utils.UUIDUtil;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.dao.Conn;
import com.tenwa.leasing.dao.DaoUtil;
import com.tenwa.leasing.rent.dao.ConditionDAO;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.NumTools;
import com.tenwa.leasing.util.leasing.RentTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list 公用交易结构dao处理类)
 */

public class ConditionDAOImpl
		implements ConditionDAO {

	Logger	logger	= Logger.getLogger(ConditionDAOImpl.class);


	/**
	 * 修改前代码备份代码,防止后期又改回来，方法名deleteCondition后缀加上了BAK
	 * 下方deleteCondition是新改的代码
	 * TODO (todo-list todo-list 根据测算的表信息对相应的交易结构表进行删除操作)
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	public boolean deleteConditionBAK(TabCalBean tcb,ConditionBean cb) throws Exception {

		Conn conn = new Conn();
		String sql = " delete " + tcb.getCondition_tb() + " where "
				+ tcb.getContOrProjCName() + "='" + tcb.getContOrProjCValue()
				+ "' and " + tcb.getDocIdCoulName() + "='"
				+ tcb.getDocIdCoulValue() + "'";
		//报价编号
		if (!"".equals(cb.getOnhireId())) {
			sql +=" and onhire_id='"+cb.getOnhireId()+"'";
		}
		//2011-04-07两id添加
		if (!"".equals(cb.getId_1())) {
			sql +=" and id_1='"+cb.getId_1()+"'";
		}
		if (!"".equals(cb.getId_2())) {
			sql +=" and id_2='"+cb.getId_2()+"'";
		}

		conn.executeUpdate(sql,"流程类型:",tcb.getCalType(),"交易结构删除语句...");
		//logger.debug("删除交易结构成功...");
		DaoUtil.closeRSOrConn(null, conn);
		//如果是多次起租,那么合同表也要做同样的操作
		/*if(tcb.getCalType().equals("onHire_more_process")){
			TabCalBean tcb_cont=new TabCalBean();
			tcb_cont=TbBeanTools.getTabInfo("cont_process", cb);
			deleteCondition(tcb_cont,cb);
			return true;
		}*/
		return true;
	}
	
	/**
	 * 
	 * ( 根据测算的表信息对相应的交易结构表进行删除操作)
	 * 
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	public boolean deleteCondition(TabCalBean tcb, ConditionBean cb) throws Exception {

		Conn conn = new Conn();
		//徐云龙修改
		//String sql = " delete " + tcb.getCondition_tb() + " where " + tcb.getContOrProjCName() + "='" + tcb.getContOrProjCValue() + "' and doc_id='" + tcb.getDocId() + "'";
		// 报价编号
		String sql = " delete " + tcb.getCondition_tb() + " where  doc_id='" + tcb.getDocIdCoulValue() + "'";
		//徐云龙修改
		//		if (!"".equals(cb.getOnhireId())) {
//			sql += " and onhire_id='" + cb.getOnhireId() + "'";
//		}
        System.out.println(sql);
		conn.executeUpdate(sql, "流程类型:", tcb.getCalType(), "交易结构删除语句...");
		// logger.debug("删除交易结构成功...");
		// 如果是多次起租,那么合同表也要做同样的操作
		/*
		 * if(tcb.getCalType().equals("onHire_more_process")){ TabCalBean
		 * tcb_cont=new TabCalBean();
		 * tcb_cont=TbBeanTools.getTabInfo("cont_process", cb);
		 * deleteCondition(tcb_cont,cb); return true; }
		 */
		return true;
	}
	

	/**
	 * 
	 * TODO (todo-list todo-list 根据表，交易结构信息添加交易结构信息到数据库中)
	 * //2012-1-11 太原特殊算法 特殊处理年利率 所以保存的时候要调用另一个方法获得原始的年利率值
	 * @param cb
	 * @param tcb
	 * @return
	 */
	public boolean addCondition(ConditionBean cb, TabCalBean tcb)
			throws Exception {
		Conn conn = new Conn();
		String sql = " INSERT INTO " + tcb.getCondition_tb() + "";
		sql += "   (id," + tcb.getDocIdCoulName() + " ";
		sql += "," + tcb.getContOrProjCName() + " ";
		sql += ",equip_amt ";
		sql += ",lease_amt ";
		sql += " ,lease_amt_date ";
		sql += ",first_payment_ratio ";
		sql += ",first_payment ";
		sql += ",clean_lease_money ";
		sql += " ,lease_money ";
		sql += "  ,year_rate ";
		sql += "  ,period_type ";
		sql += "  ,income_number_year ";
		sql += " ,income_number ";
		sql += " ,lease_term ";
		sql += " ,settle_method ";
		sql += "  ,start_date_ ";
		sql += " ,nominal_price ";
		sql += ",pena_rate ";
		sql += ",rate_float_type ";
		sql += ",rate_float_amt ";
		sql += ",adjust_style ";
		sql += " ,caution_money_ratio ";
		sql += ",caution_money ";
		sql += " ,caution_deduction_ratio ";
		sql += ",caution_deduction_money ";
		sql += " ,handling_charge_money_ratio ";
		sql += " ,handling_charge_money ";
		sql += " ,insurer ";
		sql += ",INSURE_MONEY ";
		sql += " ,management_money_ratio ";
		sql += ",management_money ";
		sql += " ,irr ";
		sql += ",plan_irr ";
		sql += ",return_amt ";
		sql += ",first_payment_total ";
		sql += ",income_day ";
		sql += ",before_interest ";
		sql += ",rate_adjustment_modulus ";
		sql += ",delay_ ";
		sql += ",grace ";
		sql += ",other_income ";
		sql += ",other_expenditure ";
//		sql += ",creator ";
//		sql += ",create_date ";
//		sql += ",modify_date ";
//		sql += ",modificator ";
		sql += ",CUST_CAUTION_MONEY_RATIO ";
		sql += ",CUST_CAUTION_MONEY ";
		sql += ",SUPPLIER_CAUTION_MONEY_RATIO ";
		sql += ",SUPPLIER_CAUTION_MONEY ";
		sql += ",FIRST_PLAN_DATE ";
		sql += ",EXPECT_RENT_RATIO ";
		sql += ",EXPECT_RENT ";
		sql += ",EXPECT_RENT_DEDUCTION_RATIO ";
		sql += ",EXPECT_RENT_DEDUCTION ";
		sql += ",LAST_CORPUS ";

		sql += ",free_defa_inter_day ";
		sql += ",equip_end_value ";
		sql += ",is_before_interest ";
		sql += ",quot_id ";
		//sql += ",id_1 ";
		//sql += ",id_2 ";
		sql += ",onhire_id ";
		sql += ",end_date ";
		sql += ",actual_start_date ";
		sql += ",accounting_start_date ";

		sql += ") ";
		sql += "VALUES(";
		sql += "'" +UUIDUtil.getUUID() + "',";
		sql += "'" + tcb.getDocIdCoulValue() + "',";
		sql += "'" + tcb.getContOrProjCValue() + "',";
		sql += "'" + cb.getEquipAmt() + "',";
		sql += "'" + cb.getLeaseAmt() + "',";
		sql += "'" + cb.getLeaseAmtDate() + "',";

		sql += "'" + cb.getFirstPaymentRatio() + "',";
		sql += "'" + cb.getFirstPayment() + "',";
		sql += "'" + cb.getCleanLeaseMoney() + "',";
		sql += "'" + cb.getLeaseMoney() + "',";
		sql += "'" + cb.getYearRate() + "',";
		sql += "'" + cb.getPeriodType() + "',";
		sql += "'" + cb.getIncomeNumberYear() + "',";
		sql += "'" + cb.getIncomeNumber() + "',";
		sql += "'" + cb.getLeaseTerm() + "',";
		sql += "'" + cb.getSettleMethod() + "',";

		sql += "'" + cb.getStartDate() + "',";
		sql += "'" + cb.getNominalPrice() + "',";
		sql += "'" + cb.getPenaRate() + "',";
		sql += "'" + cb.getRateFloatType() + "',";
		sql += "'" + cb.getRateFloatAmt() + "',";

		sql += "'" + cb.getAdjustStyle() + "',";
		sql += "'" + cb.getCautionMoneyRatio() + "',";
		sql += "'" + cb.getCautionMoney() + "',";
		sql += "'" + cb.getCautionDeductionRatio() + "',";
		sql += "'" + cb.getCautionDeductionMoney() + "',";

		sql += "'" + cb.getHandlingChargeRatio() + "',";
		sql += "'" + cb.getHandlingChargeMoney() + "',";
		sql += "'" + cb.getInsurer() + "',";
		sql += "'" + cb.getInsurance() + "',";
		sql += "'" + cb.getManagementMoneyRatio() + "',";

		sql += "'" + cb.getManagementMoney() + "',";
		sql += "" + cb.getIrr() + ",";
		sql += "" + cb.getPlanIrr() + ",";
		sql += "'" + cb.getReturnAmt() + "',";
		sql += "'" + cb.getFirstPaymentTotal() + "',";

		sql += "'" + cb.getIncomeDay() + "',";
		sql += "'" + cb.getBeforeInterest() + "',";
		sql += "'" + cb.getRateAdjustmentModulus() + "',";
		sql += "'" + cb.getDelay() + "',";

		sql += "'" + cb.getGrace() + "',";
		sql += "'" + cb.getOtherIncome() + "',";
		sql += "'" + cb.getOtherExpenditure() + "',";
//		sql += "'" + cb.getCreator() + "',";
//		sql += "getdate(),";
//
//		sql += "'" + cb.getModify_date() + "',";
//		sql += "'" + cb.getModificator() + "',";
		sql += "'" + cb.getCustCautionMoneyRatio() + "',";
		sql += "'" + cb.getCustCautionMoney() + "',";
		sql += "'" + cb.getSupplierCautionMoneyRatio() + "',";

		sql += "'" + cb.getSupplierCautionMoney() + "',";
		sql += "'" + cb.getFirstPlanDate() + "',";
		sql += "'" + cb.getExpectRentRatio() + "',";
		sql += "'" + cb.getExpectRent() + "',";
		sql += "'" + cb.getExpectRentDeductionRatio() + "',";

		sql += "'" + cb.getExpectRentDeduction() + "',";
		sql += "'" + cb.getLastCorpus() + "'";

		sql += ",'" + cb.getFreeDefaInterDay() + "'";
		sql += ",'" + cb.getEquipEndValue() + "'";
		sql += ",'" + cb.getIsBeforeInterest() + "'";
		sql += ",'" + cb.getQuotId() + "'";
		//sql += ",'" + cb.getId_1() + "'";
		//sql += ",'" + cb.getId_2() + "'";
		sql += ",'" + cb.getOnhireId() + "'";
		sql += ",'" + DateTools.getNullDate(cb.getEndDate()) + "'";
		sql += ",'" + DateTools.getNullDate(cb.getActualStartDate()) + "'";
		sql += ",'" + DateTools.getNullDate(cb.getAccountingStartDate()) + "'";

		sql += ")";
		conn.executeUpdate(sql,"流程类型:"+tcb.getCalType()+"交易结构新增语句...");
		//logger.info("交易结构新成功....");
		DaoUtil.closeRSOrConn(null, conn);
		//如果是多次起租,那么合同表也要做同样的操作
		if(tcb.getCalType().equals("onHire_more_process")){
			TabCalBean tcb_cont=new TabCalBean();
			tcb_cont=TbBeanTools.getTabInfo("cont_process", cb);
			addConditionOHire(tcb_cont,cb);
			return true;
		}
		return true;
	}
	
	/**
	 * 
	 * TODO 多次起租中交易结构表要合并 就是拿本次起租的交易结构和之前的合并.如果之前没有就直接用本次的.
	 * @param tcb 操作表
	 * @return 返回布尔型表示是否操作成功
	 * @throws Exception
	 */
	public boolean addConditionOHire(TabCalBean tcb,ConditionBean onHCb)
	throws Exception {
		ConditionBean onHireCb=new ConditionBean();//为了防止引用传递不能对传入变量做任何赋值操作
		//从正式表中获取之前的交易结构信息  如果没有就表示是第一次起租.直接插入
		TabCalBean tempTcb=null;
		String wheresql="";
		ConditionBean cb=new ConditionBean();
		//判断要不要合并 第一次 发起多次起租流程的时候不需要合并 判断标准为 多次起租交易结构正式表中有没有这个合同的数据
		tempTcb=TbBeanTools.getTabInfo("onHire_more_process");//cont_process
		tempTcb.setTableToFormal();//转为正式表
		wheresql=tempTcb.getCondition_tb()+" where  "+tempTcb.getContOrProjCName()+"='"+
		tcb.getContOrProjCValue()+"'";
		cb=getConditionBeanByContract(wheresql,tempTcb);
		if(cb==null||cb.getEquipAmt().equals("")){//从多次起租正式交易结构表中没有查到数据
			logger.info("第一次起租,交易结构不需要合并!");
			onHireCb=onHCb;
		}else{//不是第一次起租 需要合并
			logger.info("开始合并交易结构:");
			onHireCb.setAdjustStyle(onHCb.getAdjustStyle());
			onHireCb.setCreateDate(onHCb.getCreateDate());
			onHireCb.setCreator(onHCb.getCreator());
			onHireCb.setDelay(onHCb.getDelay());
			onHireCb.setDocId(onHCb.getDocId());
			onHireCb.setGrace(onHCb.getGrace());
			onHireCb.setFreeDefaInterDay(onHCb.getFreeDefaInterDay());
			onHireCb.setId(onHCb.getId());
			onHireCb.setId_1(onHCb.getId_1());
			onHireCb.setId_2(onHCb.getId_2());
			onHireCb.setIncomeDay(onHCb.getIncomeDay());
			onHireCb.setIncomeNumberYear(onHCb.getIncomeNumberYear());
			onHireCb.setInsurer(onHCb.getInsurer());
			onHireCb.setIsBeforeInterest(onHCb.getIsBeforeInterest());
			
			onHireCb.setMeasureId(onHCb.getMeasureId());
			onHireCb.setOnhireId(onHCb.getOnhireId());
			onHireCb.setPenaRate(onHCb.getPenaRate());
			onHireCb.setPeriodType(onHCb.getPeriodType());
			onHireCb.setRateAdjustmentModulus(onHCb.getRateAdjustmentModulus());
			onHireCb.setRateFloatAmt(onHCb.getRateFloatAmt());
			onHireCb.setRateFloatType(onHCb.getRateFloatType());
			onHireCb.setRentScale(onHCb.getRentScale());
			onHireCb.setSettleMethod(onHCb.getSettleMethod());
			onHireCb.setStartDate(onHCb.getStartDate());
			onHireCb.setYearRate(onHCb.getYearRate());
			onHireCb.setFirstPlanDate(onHCb.getFirstPlanDate());
			tempTcb=TbBeanTools.getTabInfo("cont_process");
			tempTcb.setTableToFormal();//转为正式表
			wheresql=tempTcb.getCondition_tb()+" where  "+tempTcb.getContOrProjCName()+"='"+
			tcb.getContOrProjCValue()+"'";
			cb=getConditionBeanByContract(wheresql,tempTcb);
			if(cb!=null&&!cb.getEquipAmt().equals("")){//开始合并两个交易结构
				//相加的一段可以考虑用SQL语句实现.特殊的才用代码做的. 考虑到SQL数据转换不方便暂时先用EXECL拉出下面所有相加的代码
				int accuracy=RentTools.getAccuracy();//默认精确到两位
				char type=NumTools.ADD;//默认为加法
				onHireCb.setEquipAmt(NumTools.calculationStr(cb.getEquipAmt(), onHCb.getEquipAmt(), type, accuracy));
				onHireCb.setLeaseAmt(NumTools.calculationStr(cb.getLeaseAmt(), onHCb.getLeaseAmt(), type, accuracy));
				onHireCb.setFirstPayment(NumTools.calculationStr(cb.getFirstPayment(), onHCb.getFirstPayment(), type, accuracy));
				onHireCb.setCleanLeaseMoney(NumTools.calculationStr(cb.getCleanLeaseMoney(), onHCb.getCleanLeaseMoney(), type, accuracy));
				onHireCb.setLeaseMoney(NumTools.calculationStr(cb.getLeaseMoney(), onHCb.getLeaseMoney(), type, accuracy));
				onHireCb.setNominalPrice(NumTools.calculationStr(cb.getNominalPrice(), onHCb.getNominalPrice(), type, accuracy));
				onHireCb.setCautionMoney(NumTools.calculationStr(cb.getCautionMoney(), onHCb.getCautionMoney(), type, accuracy));
				onHireCb.setCautionDeductionMoney(NumTools.calculationStr(cb.getCautionDeductionMoney(), onHCb.getCautionDeductionMoney(), type, accuracy));
				onHireCb.setHandlingChargeMoney(NumTools.calculationStr(cb.getHandlingChargeMoney(), onHCb.getHandlingChargeMoney(), type, accuracy));
				onHireCb.setInsurance(NumTools.calculationStr(cb.getInsurance(), onHCb.getInsurance(), type, accuracy));
				onHireCb.setManagementMoney(NumTools.calculationStr(cb.getManagementMoney(), onHCb.getManagementMoney(), type, accuracy));
				onHireCb.setReturnAmt(NumTools.calculationStr(cb.getReturnAmt(), onHCb.getReturnAmt(), type, accuracy));
				onHireCb.setFirstPaymentTotal(NumTools.calculationStr(cb.getFirstPaymentTotal(), onHCb.getFirstPaymentTotal(), type, accuracy));
				onHireCb.setBeforeInterest(NumTools.calculationStr(cb.getBeforeInterest(), onHCb.getBeforeInterest(), type, accuracy));
				onHireCb.setRateAdjustmentModulus(NumTools.calculationStr(cb.getRateAdjustmentModulus(), onHCb.getRateAdjustmentModulus(), type, accuracy));
				onHireCb.setOtherIncome(NumTools.calculationStr(cb.getOtherIncome(), onHCb.getOtherIncome(), type, accuracy));
				onHireCb.setOtherExpenditure(NumTools.calculationStr(cb.getOtherExpenditure(), onHCb.getOtherExpenditure(), type, accuracy));
				onHireCb.setPmtEndValue(NumTools.calculationStr(cb.getPmtEndValue(), onHCb.getPmtEndValue(), type, accuracy));
				onHireCb.setCalTotalByCont(NumTools.calculationStr(cb.getCalTotalByCont(), onHCb.getCalTotalByCont(), type, accuracy));
				onHireCb.setCalTotalByFinac(NumTools.calculationStr(cb.getCalTotalByFinac(), onHCb.getCalTotalByFinac(), type, accuracy));
				onHireCb.setEquipEndValue(NumTools.calculationStr(cb.getEquipEndValue(), onHCb.getEquipEndValue(), type, accuracy));
				onHireCb.setCustCautionMoney(NumTools.calculationStr(cb.getCustCautionMoney(), onHCb.getCustCautionMoney(), type, accuracy));
				onHireCb.setSupplierCautionMoney(NumTools.calculationStr(cb.getSupplierCautionMoney(), onHCb.getSupplierCautionMoney(), type, accuracy));
				onHireCb.setExpectRent(NumTools.calculationStr(cb.getExpectRent(), onHCb.getExpectRent(), type, accuracy));
				onHireCb.setExpectRentDeduction(NumTools.calculationStr(cb.getExpectRentDeduction(), onHCb.getExpectRentDeduction(), type, accuracy));
				//特殊
				onHireCb.setModifyDate(onHCb.getCreateDate());
				onHireCb.setModificator(onHCb.getCreator());
				onHireCb.setCreator(cb.getCreator());
				onHireCb.setCreateDate(cb.getCreateDate());
				onHireCb.setLeaseAmtDate(cb.getLeaseAmtDate());
				onHireCb.setLastCorpus("");
				//待定
				onHireCb.setAccountingStartDate(cb.getAccountingStartDate());
				onHireCb.setActualStartDate(cb.getActualStartDate());
				//计算比例
				accuracy=6;
				onHireCb.setFirstPaymentRatio(NumTools.calculationStr(NumTools.calculationStr(onHireCb.getFirstPayment(), onHireCb.getEquipAmt(), NumTools.DIVIDE, 10),"100",NumTools.MULTIPLY,accuracy));
				onHireCb.setCautionMoneyRatio(NumTools.calculationStr(NumTools.calculationStr(onHireCb.getCautionMoney(), onHireCb.getEquipAmt(), NumTools.DIVIDE, 10),"100",NumTools.MULTIPLY,accuracy));
				onHireCb.setCautionDeductionRatio(NumTools.calculationStr(NumTools.calculationStr(onHireCb.getCautionDeductionMoney(), onHireCb.getEquipAmt(), NumTools.DIVIDE, 10),"100",NumTools.MULTIPLY,accuracy));
				onHireCb.setHandlingChargeRatio(NumTools.calculationStr(NumTools.calculationStr(onHireCb.getHandlingChargeMoney(), onHireCb.getEquipAmt(), NumTools.DIVIDE, 10),"100",NumTools.MULTIPLY,accuracy));
				onHireCb.setManagementMoneyRatio(NumTools.calculationStr(NumTools.calculationStr(onHireCb.getManagementMoney(), onHireCb.getEquipAmt(), NumTools.DIVIDE, 10),"100",NumTools.MULTIPLY,accuracy));
				//2012-4-13 预留字段的比例计算				
				onHireCb.setCustCautionMoneyRatio(NumTools.calculationStr(NumTools.calculationStr(onHireCb.getCustCautionMoney(), onHireCb.getEquipAmt(), NumTools.DIVIDE, 10),"100",NumTools.MULTIPLY,accuracy));
				onHireCb.setSupplierCautionMoneyRatio(NumTools.calculationStr(NumTools.calculationStr(onHireCb.getSupplierCautionMoney(), onHireCb.getEquipAmt(), NumTools.DIVIDE, 10),"100",NumTools.MULTIPLY,accuracy));
				onHireCb.setExpectRentRatio(NumTools.calculationStr(NumTools.calculationStr(onHireCb.getExpectRent(), onHireCb.getEquipAmt(), NumTools.DIVIDE, 10),"100",NumTools.MULTIPLY,accuracy));
				onHireCb.setExpectRentDeductionRatio(NumTools.calculationStr(NumTools.calculationStr(onHireCb.getExpectRentDeduction(), onHireCb.getEquipAmt(), NumTools.DIVIDE, 10),"100",NumTools.MULTIPLY,accuracy));
				
				//下面的字段要在租金测算合并完成之后做处理
				//onHireCb.setEnd_date(NumTools.calculationStr(cb.getEnd_date(), onHireCb.getEnd_date(), type, accuracy));
				//onHireCb.setLease_term(NumTools.calculationStr(cb.getLease_term(), onHireCb.getLease_term(), type, accuracy));
				//onHireCb.setIncome_number(NumTools.calculationStr(cb.getIncome_number(), onHireCb.getIncome_number(), type, accuracy));
			}
		}
		//先删后加
		deleteCondition(tcb, onHireCb);
		return addCondition(onHireCb, tcb);
	}

	/**
	 * 
	 * TODO (todo-list todo-list 根据表信息，财务irr更新合同irr)
	 * 
	 * @param tcb
	 * @param contIrr
	 * @return
	 */
	public boolean updateConditionContIrr(TabCalBean tcb, String contIrr)
			throws Exception {

		Conn conn = new Conn();
		String sql = "update " + tcb.getCondition_tb() + " set irr="
				+ NumTools.formatNumberDoubleScale(contIrr, 8) + "*100  where "
				+ tcb.getContOrProjCName() + "='" + tcb.getContOrProjCValue()
				+ "' and " + tcb.getDocIdCoulName() + "='"
				+ tcb.getDocIdCoulValue() + "'";
		//报价编号
		if (!"".equals(tcb.getOnHire_id())) {
			sql +=" and onhire_id='"+tcb.getOnHire_id()+"'";
		}
		//2011-04-07两id添加
		if (!"".equals(tcb.getId_1())) {
			sql +=" and id_1='"+tcb.getId_1()+"'";
		}
		if (!"".equals(tcb.getId_2())) {
			sql +=" and id_2='"+tcb.getId_2()+"'";
		}
		conn.executeUpdate(sql,"流程类型:"+tcb.getCalType()+"更新交易结构:");
		DaoUtil.closeRSOrConn(null, conn);
		//如果是多次起租,那么合同表也要做同样的操作
		if(tcb.getCalType().equals("onHire_more_process")){
			TabCalBean tcb_cont=new TabCalBean();
			tcb_cont=TbBeanTools.getTabInfo("cont_process");
			tcb_cont.setContOrProjCValue(tcb.getContOrProjCValue());
			tcb_cont.setDocIdCoulValue(tcb.getDocIdCoulValue());
			updateConditionContIrr(tcb_cont,contIrr);
			return true;
		}
		return true;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 根据表信息，更新会计irr)
	 * 
	 * @param tcb
	 * @param finaIrr
	 * @return
	 */

	public boolean updateConditionFinaIrr(TabCalBean tcb, String finaIrr)
			throws Exception {

		Conn conn = new Conn();
		String sql = "update " + tcb.getCondition_tb() + " set plan_irr="
				+ NumTools.formatNumberDoubleScale(finaIrr, 8) + "*100  where "
				+ tcb.getContOrProjCName() + "='" + tcb.getContOrProjCValue()
				+ "' and " + tcb.getDocIdCoulName() + "='"
				+ tcb.getDocIdCoulValue() + "'";
		//报价编号
		if (!"".equals(tcb.getOnHire_id())) {
			sql +=" and onhire_id='"+tcb.getOnHire_id()+"'";
		}
		//2011-04-07两id添加
		if (!"".equals(tcb.getId_1())) {
			sql +=" and id_1='"+tcb.getId_1()+"'";
		}
		if (!"".equals(tcb.getId_2())) {
			sql +=" and id_2='"+tcb.getId_2()+"'";
		}
		conn.executeUpdate(sql,"流程类型:"+tcb.getCalType()+"更新交易结构:");
		DaoUtil.closeRSOrConn(null, conn);
		//如果是多次起租,那么合同表也要做同样的操作
		if(tcb.getCalType().equals("onHire_more_process")){
			TabCalBean tcb_cont=new TabCalBean();
			tcb_cont=TbBeanTools.getTabInfo("cont_process");
			tcb_cont.setContOrProjCValue(tcb.getContOrProjCValue());
			tcb_cont.setDocIdCoulValue(tcb.getDocIdCoulValue());
			updateConditionFinaIrr(tcb_cont,finaIrr);
			return true;
		}
		return true;
	}

	/**
	 * scl 租金计划变更中使用到
	 * TODO (根据ConditionBean和TabCalBean 更新 income_number_year,income_number,lease_term)
	 * @param tcb
	 * @param cdb
	 * @return
	 * @throws Exception
	 */
	public boolean updateConditionIncomeNum(TabCalBean tcb, ConditionBean cb)
			throws Exception {
		Conn conn = new Conn();
		String sql = "update " + tcb.getCondition_tb() + " set income_number='"+
				cb.getIncomeNumber()+"', lease_term='"+
				cb.getLeaseTerm()+"',year_rate='"+cb.getYearRate()+"' where "
				+ tcb.getContOrProjCName() + "='" + tcb.getContOrProjCValue()
				+ "' and " + tcb.getDocIdCoulName() + "='"
				+ tcb.getDocIdCoulValue() + "'";
		//报价编号
		if (!"".equals(cb.getOnhireId())) {
			sql +=" and onhire_id='"+cb.getOnhireId()+"'";
		}
		//2011-04-07两id添加
		if (!"".equals(cb.getId_1())) {
			sql +=" and id_1='"+cb.getId_1()+"'";
		}
		if (!"".equals(cb.getId_2())) {
			sql +=" and id_2='"+cb.getId_2()+"'";
		}
		conn.executeUpdate(sql,"流程类型:"+tcb.getCalType()+"更新交易结构:");
		DaoUtil.closeRSOrConn(null, conn);
		//如果是多次起租,那么合同表也要做同样的操作
		if(tcb.getCalType().equals("onHire_more_process")){
			TabCalBean tcb_cont=new TabCalBean();
			tcb_cont=TbBeanTools.getTabInfo("cont_process", cb);
			updateConditionIncomeNum(tcb_cont,cb);
			return true;
		}
		return true;
	}
	
	/**
	 * 
	 * TODO (todo-list todo-list 根据查取交易结构信息)
	 * 
	 * @param contract_id
	 * @return
	 * @throws Exception
	 */
	public ConditionBean getConditionBeanByContract(String wheresql,TabCalBean tcb)
			throws Exception {

		// 数据库操作对象
		Conn conn = new Conn();
		ConditionBean cb = new ConditionBean();
		//ResultSet rs = null;
		String sql = "SELECT id";
		sql += ","+tcb.getDocIdCoulName();
		sql += ","+tcb.getContOrProjCName();
		sql += ",equip_amt";
		sql += ",lease_amt";
		sql += ",lease_amt_date";
		sql += ",first_payment_ratio";
		sql += ",first_payment";
		sql += ",clean_lease_money";
		sql += ",lease_money";
		sql += ",year_rate";
		sql += ",period_type";
		sql += ",income_number_year";
		sql += ",income_number";
		sql += ",lease_term";
		sql += ",settle_method";
		sql += ",start_date_";
		sql += ",nominal_price";
		sql += ",pena_rate";
		sql += ",rate_float_type";
		sql += ",rate_float_amt";
		sql += ",adjust_style";
		sql += ",caution_money_ratio";
		sql += ",caution_money";
		sql += ",caution_deduction_ratio";
		sql += ",caution_deduction_money";
		sql += ",handling_charge_money_ratio";
		sql += ",handling_charge_money";
		sql += ",insurer";
		sql += ",INSURE_MONEY";
		sql += ",management_money_ratio";
		sql += ",management_money";
		sql += ",irr";
		sql += ",plan_irr";
		sql += ",return_amt";
		sql += ",first_payment_total";
		sql += ",income_day";
		sql += ",before_interest";
		sql += ",rate_adjustment_modulus";
		sql += ",delay_";
		sql += ",grace";
		sql += ",other_income";
		sql += ",other_expenditure";
//		sql += ",creator";
//		sql += ",create_date";
//		sql += ",modify_date";
//		sql += ",modificator";
		sql += ",LAST_CORPUS";
		sql += ",CUST_CAUTION_MONEY_RATIO";
		sql += ",CUST_CAUTION_MONEY";
		sql += ",SUPPLIER_CAUTION_MONEY_RATIO";
		sql += ",SUPPLIER_CAUTION_MONEY";
		sql += ",FIRST_PLAN_DATE";
		sql += ",EXPECT_RENT_RATIO";
		sql += ",EXPECT_RENT";
		sql += ",EXPECT_RENT_DEDUCTION_RATIO";
		sql += ",EXPECT_RENT_DEDUCTION";
		sql += ",free_defa_inter_day";
		sql += ",equip_end_value";
		sql += ",is_before_interest";
		//sql += ",id_1";
		//sql += ",id_2";
		sql += ",onhire_id";
		sql += ",end_date";
		sql += ",actual_start_date";
		sql += ",accounting_start_date";
		
		
		sql += ",quot_id FROM " + wheresql;
		
		List<Map<String,String>> rs_list = conn.executeQuery(sql,"查询交易结构表信息..");
        int len = rs_list.size();
		if(len > 0 ) {
			Map<String, String> rs = rs_list.get(0);
			cb.setId(rs.get("id"));
			cb.setMeasureId(rs.get(tcb.getDocIdCoulName()));
			cb.setDocId(rs.get(tcb.getDocIdCoulName()));
			cb.setProjId(rs.get(tcb.getContOrProjCName()));
			cb.setEquipAmt(rs.get("equip_amt"));

			cb.setLeaseAmt(rs.get("lease_amt"));
			cb.setLeaseAmtDate(rs.get("lease_amt_date"));
			cb.setFirstPaymentRatio(rs.get("first_payment_ratio"));
			cb.setFirstPayment(rs.get("first_payment"));

			cb.setCleanLeaseMoney(rs.get("clean_lease_money"));
			cb.setLeaseMoney(rs.get("lease_money"));
			cb.setYearRate(rs.get("year_rate"));
			cb.setPeriodType(rs.get("period_type"));

			cb.setIncomeNumberYear(rs.get("income_number_year"));
			cb.setIncomeNumber(rs.get("income_number"));
			cb.setLeaseTerm(rs.get("lease_term"));
			cb.setSettleMethod(rs.get("settle_method"));

			cb.setStartDate(DateTools.getDBDateStr(rs.get("start_date_")));
			cb.setNominalPrice(rs.get("nominal_price"));
			cb.setPenaRate(rs.get("pena_rate"));
			cb.setRateFloatType(rs.get("rate_float_type"));

			cb.setRateFloatAmt(rs.get("rate_float_amt"));
			cb.setAdjustStyle(rs.get("adjust_style"));
			cb.setCautionMoneyRatio(rs.get("caution_money_ratio"));
			cb.setCautionMoney(rs.get("caution_money"));

			cb.setCautionDeductionRatio(rs
					.get("caution_deduction_ratio"));
			cb.setCautionDeductionMoney(rs
					.get("caution_deduction_money"));
			cb.setHandlingChargeRatio(rs.get("handling_charge_money_ratio"));
			cb.setHandlingChargeMoney(rs.get("handling_charge_money"));

			cb.setInsurer(rs.get("insurer"));
			cb.setInsurance(rs.get("insure_money"));
			cb
					.setManagementMoneyRatio(rs
							.get("management_money_ratio"));
			cb.setManagementMoney(rs.get("management_money"));

			cb.setIrr(rs.get("irr"));
			cb.setPlanIrr(rs.get("plan_irr"));
			cb.setReturnAmt(rs.get("return_amt"));
			cb.setFirstPaymentTotal(rs.get("first_payment_total"));

			cb.setIncomeDay(rs.get("income_day"));
			cb.setBeforeInterest(rs.get("before_interest"));
			cb.setRateAdjustmentModulus(rs
					.get("rate_adjustment_modulus"));

			cb.setDelay(rs.get("delay_"));
			cb.setGrace(rs.get("grace"));
			cb.setOtherIncome(rs.get("other_income"));
			cb.setOtherExpenditure(rs.get("other_expenditure"));

//			cb.setCreator(rs.getString("creator"));
//			cb.setCreate_date(rs.getString("create_date"));
//			cb.setModify_date(rs.getString("modify_date"));
//			cb.setModificator(rs.getString("modificator"));

			cb.setLastCorpus(rs.get("last_corpus"));
			cb.setCustCautionMoneyRatio(rs.get("cust_caution_money_ratio"));
			cb.setCustCautionMoney(rs.get("cust_caution_money"));
			cb.setSupplierCautionMoneyRatio(rs.get("supplier_caution_money_ratio"));

			cb.setSupplierCautionMoney(rs.get("supplier_caution_money"));
			cb.setFirstPlanDate(rs.get("first_plan_date"));
			cb.setExpectRentRatio(rs.get("expect_rent_ratio"));
			cb.setExpectRent(rs.get("expect_rent"));

			cb.setExpectRentDeductionRatio(rs.get("expect_rent_deduction_ratio"));
			cb.setExpectRentDeduction(rs.get("expect_rent_deduction"));
			cb.setFreeDefaInterDay(rs.get("free_defa_inter_day"));
			cb.setEquipEndValue(rs.get("equip_end_value"));

			cb.setIsBeforeInterest(rs.get("is_before_interest"));
			cb.setQuotId(rs.get("quot_id"));
			//cb.setId_1(rs.get("id_1"));
			//cb.setId_2(rs.get("id_2"));
			cb.setOnhireId(rs.get("onhire_id"));
			cb.setEndDate(DateTools.getDBDateStr(rs.get("end_date")));
			cb.setActualStartDate(DateTools.getDBDateStr(rs.get("actual_start_date")));
			cb.setAccountingStartDate(DateTools.getDBDateStr(rs.get("accounting_start_date")));
			
			// cb.setPmtEndValue(String.valueOf(Double.parseDouble(cb
			// .getEquip_end_value())
			// + Double.parseDouble(cb.getNominal_price())));//
			// 租金测算pmt公式后期测算代入的值,相当于期末残值,默认为0==设备残值+名义货价
			//			
			// 2011－03－31修改不加名义货价
			cb.setPmtEndValue(String.valueOf(Double.parseDouble(cb
					.getEquipEndValue())));// 租金测算pmt公式后期测算代入的值,相当于期末残值,默认为0==设备残值
			
			cb.setCalTotalByCont(NumTools.calculationStr(cb.getEquipAmt(), cb.getFirstPayment(), NumTools.SUBTRACT, 2));
			//cb.setCalTotalByCont(String.valueOf(Double.parseDouble(cb
			//		.getEquip_amt())
			//		- Double.parseDouble(cb.getFirst_payment())));// 租金测总本金合同==设备款－首付款
			cb.setCalTotalByFinac(NumTools.calculationStr(cb.getCleanLeaseMoney(), cb.getCautionMoney(), NumTools.ADD, 2));
			//cb.setCalTotalByFinac(String.valueOf(Double.parseDouble(cb
			//		.getClean_lease_money())
			//		+ Double.parseDouble(cb.getCaution_money())));// 租金测总本金会计==净融资额
			// +保证金

		}
		else
		{
			cb=null;
		}
		//DaoUtil.closeRSOrConn(rs, conn);
		return cb;
	}
	
	
	
	/**
	 * 
	 * TODO (todo-list todo-list 根据查取交易结构信息)
	 * 
	 * @param contract_id
	 * @return
	 * @throws Exception
	 */
	public ConditionBean getConditionBeanByProj(String wheresql)
			throws Exception {

		// 数据库操作对象
		Conn conn = new Conn();
		ConditionBean cb = new ConditionBean();
		String sql = "SELECT id";
		sql += ",doc_id";
		sql += ",proj_id";
		sql += ",equip_amt";
		sql += ",lease_amt";
		sql += ",lease_amt_date";
		sql += ",first_payment_ratio";
		sql += ",first_payment";
		sql += ",clean_lease_money";
		sql += ",lease_money";
		sql += ",year_rate";
		sql += ",period_type";
		sql += ",income_number_year";
		sql += ",income_number";
		sql += ",lease_term";
		sql += ",settle_method";
		sql += ",start_date_";
		sql += ",nominal_price";
		sql += ",pena_rate";
		sql += ",rate_float_type";
		sql += ",rate_float_amt";
		sql += ",adjust_style";
		sql += ",caution_money_ratio";
		sql += ",caution_money";
		sql += ",caution_deduction_ratio";
		sql += ",caution_deduction_money";
		sql += ",handling_charge_money_ratio";
		sql += ",handling_charge_money";
		sql += ",insurer";
		sql += ",INSURE_MONEY";
		sql += ",management_money_ratio";
		sql += ",management_money";
		sql += ",irr";
		sql += ",plan_irr";
		sql += ",return_amt";
		sql += ",first_payment_total";
		sql += ",income_day";
		sql += ",before_interest";
		sql += ",rate_adjustment_modulus";
		sql += ",delay_";
		sql += ",grace";
		sql += ",other_income";
		sql += ",other_expenditure";
//		sql += ",creator";
//		sql += ",create_date";
//		sql += ",modify_date";
//		sql += ",modificator";
		sql += ",LAST_CORPUS";
		sql += ",CUST_CAUTION_MONEY_RATIO";
		sql += ",CUST_CAUTION_MONEY";
		sql += ",SUPPLIER_CAUTION_MONEY_RATIO";
		sql += ",SUPPLIER_CAUTION_MONEY";
		sql += ",FIRST_PLAN_DATE";
		sql += ",EXPECT_RENT_RATIO";
		sql += ",EXPECT_RENT";
		sql += ",EXPECT_RENT_DEDUCTION_RATIO";
		sql += ",EXPECT_RENT_DEDUCTION";
		sql += ",free_defa_inter_day";
		sql += ",equip_end_value";
		sql += ",is_before_interest";
		//sql += ",id_1";
		//sql += ",id_2";
		sql += ",onhire_id";
		sql += ",end_date";
		sql += ",actual_start_date";
		sql += ",accounting_start_date";
		
		
		sql += ",quot_id FROM " + wheresql;

	    List<Map<String,String>> rs_list = conn.executeQuery(sql,"查询调息时交易结构表信息..");

		for (Map<String,String> rs : rs_list) {

			cb.setId(rs.get("id"));
			cb.setMeasureId(rs.get("doc_id"));
			cb.setProjId(rs.get("proj_id"));
			cb.setEquipAmt(rs.get("equip_amt"));

			cb.setLeaseAmt(rs.get("lease_amt"));
			cb.setLeaseAmtDate(rs.get("lease_amt_date"));
			cb.setFirstPaymentRatio(rs.get("first_payment_ratio"));
			cb.setFirstPayment(rs.get("first_payment"));

			cb.setCleanLeaseMoney(rs.get("clean_lease_money"));
			cb.setLeaseMoney(rs.get("lease_money"));
			cb.setYearRate(rs.get("year_rate"));
			cb.setPeriodType(rs.get("period_type"));

			cb.setIncomeNumberYear(rs.get("income_number_year"));
			cb.setIncomeNumber(rs.get("income_number"));
			cb.setLeaseTerm(rs.get("lease_term"));
			cb.setSettleMethod(rs.get("settle_method"));

			cb.setStartDate(DateTools.getDBDateStr(rs.get("start_date_")));
			cb.setNominalPrice(rs.get("nominal_price"));
			cb.setPenaRate(rs.get("pena_rate"));
			cb.setRateFloatType(rs.get("rate_float_type"));

			cb.setRateFloatAmt(rs.get("rate_float_amt"));
			cb.setAdjustStyle(rs.get("adjust_style"));
			cb.setCautionMoneyRatio(rs.get("caution_money_ratio"));
			cb.setCautionMoney(rs.get("caution_money"));

			cb.setCautionDeductionRatio(rs
					.get("caution_deduction_ratio"));
			cb.setCautionDeductionMoney(rs
					.get("caution_deduction_money"));
			cb.setHandlingChargeRatio(rs.get("handling_charge_money_ratio"));
			cb.setHandlingChargeMoney(rs.get("handling_charge_money"));

			cb.setInsurer(rs.get("insurer"));
			cb.setInsurance(rs.get("insure_money"));
			cb
					.setManagementMoneyRatio(rs
							.get("management_money_ratio"));
			cb.setManagementMoney(rs.get("management_money"));

			cb.setIrr(rs.get("irr"));
			cb.setPlanIrr(rs.get("plan_irr"));
			cb.setReturnAmt(rs.get("return_amt"));
			cb.setFirstPaymentTotal(rs.get("first_payment_total"));

			cb.setIncomeDay(rs.get("income_day"));
			cb.setBeforeInterest(rs.get("before_interest"));
			cb.setRateAdjustmentModulus(rs
					.get("rate_adjustment_modulus"));

			cb.setDelay(rs.get("delay_"));
			cb.setGrace(rs.get("grace"));
			cb.setOtherIncome(rs.get("other_income"));
			cb.setOtherExpenditure(rs.get("other_expenditure"));

//			cb.setCreator(rs.get("creator"));
//			cb.setCreate_date(rs.get("create_date"));
//			cb.setModify_date(rs.get("modify_date"));
//			cb.setModificator(rs.get("modificator"));

			cb.setLastCorpus(rs.get("last_corpus"));
			cb.setCustCautionMoneyRatio(rs.get("cust_caution_money_ratio"));
			cb.setCustCautionMoney(rs.get("cust_caution_money"));
			cb.setSupplierCautionMoneyRatio(rs.get("supplier_caution_money_ratio"));

			cb.setSupplierCautionMoney(rs.get("supplier_caution_money"));
			cb.setFirstPlanDate(rs.get("first_plan_date"));
			cb.setExpectRentRatio(rs.get("expect_rent_ratio"));
			cb.setExpectRent(rs.get("expect_rent"));

			cb.setExpectRentDeductionRatio(rs.get("expect_rent_deduction_ratio"));
			cb.setExpectRentDeduction(rs.get("expect_rent_deduction"));
			cb.setFreeDefaInterDay(rs.get("free_defa_inter_day"));
			cb.setEquipEndValue(rs.get("equip_end_value"));

			cb.setIsBeforeInterest(rs.get("is_before_interest"));
			cb.setQuotId(rs.get("quot_id"));
			//cb.setId_1(rs.get("id_1"));
			//cb.setId_2(rs.get("id_2"));
			cb.setOnhireId(rs.get("onhire_id"));
			cb.setEndDate(DateTools.getDBDateStr(rs.get("end_date")));
			cb.setActualStartDate(DateTools.getDBDateStr(rs.get("actual_start_date")));
			cb.setAccountingStartDate(DateTools.getDBDateStr(rs.get("accounting_start_date")));
			
			

			// cb.setPmtEndValue(String.valueOf(Double.parseDouble(cb
			// .getEquip_end_value())
			// + Double.parseDouble(cb.getNominal_price())));//
			// 租金测算pmt公式后期测算代入的值,相当于期末残值,默认为0==设备残值+名义货价
			//			
			// 2011－03－31修改不加名义货价
			cb.setPmtEndValue(String.valueOf(Double.parseDouble(cb
					.getEquipEndValue())));// 租金测算pmt公式后期测算代入的值,相当于期末残值,默认为0==设备残值

			cb.setCalTotalByCont(String.valueOf(Double.parseDouble(cb
					.getEquipAmt())
					- Double.parseDouble(cb.getFirstPayment())));// 租金测总本金合同==设备款－首付款
			cb.setCalTotalByFinac(String.valueOf(Double.parseDouble(cb
					.getCleanLeaseMoney())
					+ Double.parseDouble(cb.getCautionMoney())));// 租金测总本金会计==净融资额
			// +保证金

		}
		//DaoUtil.closeRSOrConn(rs, conn);
		return cb;
	}

	

}
