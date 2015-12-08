package com.tenwa.leasing.renttranrate.service.impl;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.InterContBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rent.dao.impl.ConditionDAOImpl;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.rentcalc.service.impl.ConditionServiceImpl;
import com.tenwa.leasing.renttranrate.dao.impl.CashDetailHisDAOImpl;
import com.tenwa.leasing.renttranrate.dao.impl.ConditionTranDAOImpl;
import com.tenwa.leasing.renttranrate.dao.impl.FundRentHisDAOImpl;
import com.tenwa.leasing.renttranrate.dao.impl.FundStanInterDAOImpl;
import com.tenwa.leasing.renttranrate.dao.impl.RentPlanDAOImpl;
import com.tenwa.leasing.renttranrate.service.TransRateService;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author shf
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list 调息时处理类)
 */
public class RentTranRateServiceImpl {
	static Logger logger = Logger.getLogger(RentTranRateServiceImpl.class);

	/**
	 * 
	 * TODO (todo-list todo-list 判断此合同可否进行此次调息)
	 * 
	 * @param contract_id
	 * @param adjustDate
	 * @param adjustType
	 * @return 可以调息返回true 不可以调息返回false
	 * @throws Exception
	 */
	public boolean isAdjustByContract(String contract_id, String startList, ConditionBean cb) throws Exception {
		logger.info("进行合同是否可以此次调息的判断.....");
		ConditionTranDAOImpl ctdi = new ConditionTranDAOImpl();

		if (!ctdi.isTransByContr(contract_id, startList)) {// 调息方式或利率方式来判断可否调息
			return false;
		}

		if (null == startList || "".equals(startList) || Integer.parseInt(startList) < 1) {// 对租金计划进行判断
			return false;
		}

		// 如果是次期时
		if (cb.getAdjustStyle() != null && "next_list".equals(cb.getAdjustStyle()) && Integer.parseInt(startList) + 1 > Integer.parseInt(cb.getIncomeNumber())) {// 次期时
			logger.info(startList + "次期..");
			return false;
		}

		return true;

	}

	/**
	 * 
	 * TODO (todo-list todo-list 调息处理)
	 * 
	 * @param adjustId
	 * @param id
	 * @param creator
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, String> processTransRate(String adjustId, String id, String contractId, String creator, String measure_id) throws Exception {
		logger.info("开始进行调息处理....");
		Hashtable re_ht = new Hashtable();
		Object msgs = re_ht.get("message");
		ConditionDAOImpl cdi = new ConditionDAOImpl();
		// /根据调息id获得央行调息记录
		FundStanInterDAOImpl fsid = new FundStanInterDAOImpl();
		Hashtable adjst_info = fsid.getStandInfoById(adjustId);


			// 构建从交易结构表查询的form语句
			String wheresql = " contract_condition  where contract_id ='" + id + "' ";
			TabCalBean tcbTemp = TbBeanTools.getTabInfo("cont_process");
			ConditionBean cb = cdi.getConditionBeanByContract(wheresql, tcbTemp);
			// 因为这里的cb 是查的正式表 所以要该掉contract_id
			cb.setContractId(contractId);
			// 设置他的此时操作的,String measure_id
			cb.setMeasureId(measure_id);
			cb.setDocId(measure_id);
			cb.setCreator(creator);// 当前操作人修改
			cb.setModificator(creator);
	
			cb.setCreateDate(DateTools.getSystemDate(0));
			cb.setModifyDate(DateTools.getSystemDate(0));
	
			// 根据调息方式得到他的新的调日期
			String newDate = TransDateServiceImpl.getNewDateByAdjustType(cb.getAdjustStyle(), adjst_info.get("start_date").toString());
	
			logger.info("调息开始时间...." + newDate);
			RentPlanDAOImpl rpdi = new RentPlanDAOImpl();
			// 得到调息开始变更的期数，次期除外
			String startList = rpdi.getStartListByDate(newDate, id);
			logger.info("调息开始期项...." + startList);
			// 2011-11-10 如果 开始期项之后的的利率不一样 则不允许调息
	
			logger.info("进行合同是否可以此次调息的判断.....");
			ConditionTranDAOImpl ctdi = new ConditionTranDAOImpl();
	
			String msg = "";
			if (!ctdi.isTransByContr(id, startList)) {// 调息方式或利率方式来判断可否调息
				msg += "\\n合同号:" + contractId + "不满足调息规则!\\n调息开始期项之后的期数中利率不相同.\\n未进行调息.";
			} else if (null == startList || "".equals(startList) || Integer.parseInt(startList) < 1) {// 对租金计划进行判断
				msg += "\\n合同号:" + contractId + "不满足调息规则!\\n调息日期不在合同租赁期限内.\\n未进行调息.";
			} else if (cb.getAdjustStyle() != null && "next_list".equals(cb.getAdjustStyle()) && Integer.parseInt(startList) + 1 > Integer.parseInt(cb.getIncomeNumber())) {// 次期时
				msg += "\\n合同号:" + contractId + "不满足调息规则!\\n次期调息合同且调息开始期数为合同最后一期.\\n未进行调息.";
			} else{
				// 从此开始初使化交易结构相应的租金计划，现金流明细等数据
				
				// 得到操作表信息,由于他是走流程且操作的都是合同临时表所以类似于合同审批流程
				TabCalBean tcb = TbBeanTools.getTabInfo("cont_process", cb);
				
				// 初使化数据到相应的临时表中/////////////////////////////
				// 租金计划,交易结构
				
				ConditionServiceImpl csi = new ConditionServiceImpl();
				// 对交易结构信息处理
				csi.addConditionByCal(tcb, cb);
				
				// 初使化租金计划数据到临时表
				RentPlanContrCalDAOImpl rpccdi = new RentPlanContrCalDAOImpl();
				
				// 由于有些列值要取当前系统的，所以在此构建
				Hashtable colHt = new Hashtable();
				colHt.put("user", creator);
				colHt.put("measure_id", measure_id);
				colHt.put("contract_id", contractId);
				
				// 先删除临时表中的数据,由于是初使化数据所以要整个租金计划都删除，所以从第一期开始
				RentPlanContrCalDAOImpl rpccd = new RentPlanContrCalDAOImpl();
				rpccd.deleteRentPlan(tcb.getRentPlan_tb(), tcb, "0");
				rpccdi.addRentInfoBySql(" contract_fund_rent_plan_temp ", " contract_fund_rent_plan ", " where contract_id='" + id + "' ", colHt);
				
				// //2011-04-07修改会计租金计划修改
				// rpccd.deleteRentPlan(tcb.getRentFinaPlan_tb(),tcb, "0");
				// rpccdi.addRentInfoBySql(" contract_fina_rent_plan_temp "," contract_fina_rent_plan "," where contract_id='"
				// + ids.get(i).toString() + "' ",colHt);
				
				// 由于现金流明细是重新构建，故他们不须初使化数据
				RateCalTranServiceImpl rcti = new RateCalTranServiceImpl();
				/*
				 * 2011-11-10 只有加点的调息,加点规则为开始调息的期项对应的利率加上央行本次调整幅度值 如果 开始期项之后的的利率不一样
				 * 则不允许调息 String newRate = rcti.getNewRate(cb.getRate_float_type(),
				 * cb .getLease_term(), cb.getRate_float_amt(), adjst_info);
				 */
				// 先前年利率从租金计划表中去查询
				String old_year_rate = rpdi.getCurrentYearRate(id, startList);
				String newRate = rcti.getNewRate(cb.getRateFloatType(), cb.getLeaseTerm(), old_year_rate, cb.getRateFloatAmt(), adjst_info);
				logger.info("调息新利率...." + newRate);
				
				// 新的测算利率
				cb.setYearRate(newRate);
				
				// 添加租金计划，现金流明细前历史记录//////////////////此时先不用
				// addRentAndCashInfo(adjustId, contracts.get(i).toString(), creator, "前");
				
				InterContBean icb = new InterContBean();
				
				icb.setContract_id(contractId);
				icb.setAdjust_id(adjustId);
				icb.setStart_list(startList);
				
				icb.setRate_original(old_year_rate);
				icb.setRate_adjust(newRate);
				icb.setCreator(creator);
				icb.setOld_irr(cb.getIrr());
				icb.setOld_plan_irr(cb.getPlanIrr());
				icb.setAdjustDate(newDate);
				icb.setMeasure_id(measure_id);
				
				// 根据测算方式分支来处理
				// ////////////////////////
				TransRateService trs = null;
				// 不管什么租金测算类型都用等比 2011-9-15 修改
				// if ("even_rent".equals(cb.getSettle_method())) {// 等额租金时
				trs = new PmtTransRateServiceImpl();
				icb = trs.processPmtTranRate(cb, icb, tcb);
				// }
				
				// 添加调息后租金计划和现金流信息 暂不用
				// addRentAndCashInfo(adjustId, contracts.get(i).toString(),
				// creator,
				// "后");
				
				// /2013-10-17 用框架的代码保存调整值
				// 添加合同与调息相关的记录
				// InteCtractDAOImpl icdi = new InteCtractDAOImpl();
				// icdi.deleteInteCtractInfo(contracts.get(i).toString(),
				// adjustId,measure_id);
				// icdi.addInteCtractInfo(icb);
				re_ht.put("isOver", "true");
				re_ht.put("startList", icb.getStart_list());
				re_ht.put("oldRate", icb.getRate_original());
				re_ht.put("newRate", icb.getRate_adjust());
				re_ht.put("oldIrr", icb.getOld_irr());
				re_ht.put("newIrr", icb.getNew_irr());
				re_ht.put("oldPlanIrr", icb.getOld_plan_irr());
				re_ht.put("newPlanIrr", icb.getNew_plan_irr());
				re_ht.put("adjustDate", icb.getAdjustDate());
				
			}
	
		re_ht.put("message", msg);
		re_ht.put("isSucess", "true");
		return re_ht;

	}

	/**
	 * 
	 * TODO (todo-list todo-list 添加租金计划 或现金流历史记录)
	 * 
	 * @param adjustId
	 * @param contract_id
	 * @param creator
	 * @param status
	 * @throws Exception
	 */
	private void addRentAndCashInfo(String adjustId, String contract_id, String creator, String status) throws Exception {
		// 添加租金计划，现金流明细后历史记录

		FundRentHisDAOImpl frhi = new FundRentHisDAOImpl();
		CashDetailHisDAOImpl cdhdi = new CashDetailHisDAOImpl();

		// frhi.deleteRentHisInfo(adjustId, contract_id, status);
		// frhi.addRentHisInfo(adjustId, contract_id, status, creator);

		// 添加后，租金现金流信息
		// 合同
		cdhdi.deleteCashHisInfo(adjustId, contract_id, "contract_cash_detail_his", status);

		cdhdi.addCashHisInfo(adjustId, contract_id, "contract_cash_detail_his", "contract_cash_detail", status, creator);

		cdhdi.deleteCashHisInfo(adjustId, contract_id, "contract_finance_cash_detail_his", status);
		// 会计的
		cdhdi.addCashHisInfo(adjustId, contract_id, "contract_finance_cash_detail_his", "contract_finance_cash_detail", status, creator);
	}

}
