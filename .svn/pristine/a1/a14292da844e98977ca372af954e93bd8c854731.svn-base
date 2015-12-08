package com.tenwa.leasing.rentcalc.service.impl.eveninterest;

import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.service.IrrService;
import com.tenwa.leasing.irr.service.impl.IrrServiceImpl;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.rentcalc.service.RentCalcService;
import com.tenwa.leasing.rentcalc.service.impl.ConditionServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.PlanDateServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.RentPlanFinacCalServiceImpl;
import com.tenwa.leasing.util.leasing.RentTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-2
 * @desc TODO (todo-list 均息法测算)
 */
public class EvenInterestCalcServiceImpl
		implements RentCalcService {

	static Logger	logger	= Logger.getLogger(EvenInterestCalcServiceImpl.class);


	@SuppressWarnings("unchecked")
	public Hashtable rentCal(ConditionBean cb, String calType, String userName,
			Object obj,String star_list) throws Exception {
		logger.info("进入方法:rentCal 进行均息法的测算..");
		// 得到操作表信息
		TabCalBean tcb = TbBeanTools.getTabInfo(calType, cb);
		ConditionServiceImpl csi = new ConditionServiceImpl();
		// 对交易结构信息处理
		csi.addConditionByCal(tcb, cb);
		// 合同租金测算
		EvenInterestPlanContrCalServiceImpl rpcs = new EvenInterestPlanContrCalServiceImpl();
		FundRentPlanBean frpb =new FundRentPlanBean();
		//FundRentPlanBean frpb =rpcs.getEvenInterest(cb);
		// 设置他的合同号
		frpb.setProjOrCont(cb.getProjId());
		frpb.setCreator(cb.getCreator());
		frpb.setYearRate(cb.getYearRate());
		frpb.setQuot_id(cb.getQuotId());
		frpb.setRent_adjust_list(new ArrayList());// 租金调整值

		// 1,表从第一期开始;2,表租金格式化为几位小数,合同租金计划测算
		frpb = rpcs.rentPlanCalByConditionAndTab(cb, tcb, star_list,RentTools.getRentAccuracy()+"", frpb);

		// // 调用保存的操作
		// // 根据表信息进行对表数据的清除操作
		// RentPlanContrCalDAOImpl rpcd = new RentPlanContrCalDAOImpl();
		// rpcd.addRentPlan(frpb, tcb, "1", "2");

		// 现金流处理,返回一个财务现金流,并将财务irr赋值到交易结构plan_iir上
		IrrService is = new IrrServiceImpl();
		// 1,默认按期来计算现金流irr,其它的如按月，按天，在此改参数
		// 2011-06-14修改为安月计算
		//2011-11-14 改为按期
		cb = is.calCashIrrFinacAndCont(cb, tcb, frpb, "1");

		//
		// 财务租金计划处理
		RentPlanFinacCalServiceImpl rpfcs = new RentPlanFinacCalServiceImpl();
		// 1,表从第一期开始;2,表租金格式化为几位小数
		rpfcs.rentPlanCalByConditionAndTab(cb, tcb,star_list, "2", frpb);

		Hashtable re_ht = new Hashtable();
		re_ht.put("isSucess", "true");

		logger.info("结束均息法的测算方法:rentCal ..");
		return re_ht;

	}


	/**
	 * 
	 * TODO (todo-list todo-list 起租时实现方法)
	 * 
	 * @param cb
	 * @param calType
	 * @param userName
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Hashtable rentCalOnHire(ConditionBean cb, String calType,
			String userName, Object obj) throws Exception {

		logger.info("进入方法:rentCalOnHire 进行起租时的均息法测算..");
		//起租时只重新保存交易结构信息，更改租金计划支付日期，更改现金流明细
		
		// 得到操作表信息
		TabCalBean tcb = TbBeanTools.getTabInfo(calType, cb);
		ConditionServiceImpl csi = new ConditionServiceImpl();
		// 对交易结构信息处理
		csi.addConditionByCal(tcb, cb);
		// 合同租金测算
		//RentPlanContrCalServiceImpl rpcs = new RentPlanContrCalServiceImpl();

		//查询他的租金计划
		RentPlanContrCalDAOImpl rpccdi = new RentPlanContrCalDAOImpl();
		FundRentPlanBean frpb = rpccdi.getRentAndDateByTcb(tcb, "1");
		//FundRentPlanBean frpb = new FundRentPlanBean();
		// 设置他的合同号
		frpb.setProjOrCont(cb.getProjId());
		frpb.setCreator(cb.getCreator());
		frpb.setYearRate(cb.getYearRate());
		frpb.setQuot_id(cb.getQuotId());
		frpb.setRent_adjust_list(new ArrayList());// 租金调整值
		
		//根据交易结构重新算出的租金计划日期
		// 日期类返回租金列表
		PlanDateServiceImpl pdsi = new PlanDateServiceImpl();
		frpb.setPlanDate_list(pdsi.getPlanDateList(cb, String.valueOf(frpb
				.getRent_list().size())));
		//更新租金计划 的时间
		rpccdi.updateRentPlanDate(tcb.getRentPlan_tb(),tcb, "1", frpb.getPlanDate_list());
		//更新会计的租金计划时间
		rpccdi.updateRentPlanDate(tcb.getRentFinaPlan_tb(), tcb, "1", frpb.getPlanDate_list());
		

		// 1,表从第一期开始;2,表租金格式化为几位小数,合同租金计划测算
		//frpb = rpcs.rentPlanCalByConditionAndTab(cb, tcb, "1", "2", frpb);



		// 现金流处理,返回一个财务现金流,并将财务irr赋值到交易结构plan_iir上
		IrrService is = new IrrServiceImpl();
		// 1,默认按期来计算现金流irr,其它的如按月，按天，在此改参数
///// 2011-06-14修改为安月计算
		cb = is.calCashIrrFinacAndCont(cb, tcb, frpb, "2");
		

//		//
//		// 财务租金计划处理
//		RentPlanFinacCalServiceImpl rpfcs = new RentPlanFinacCalServiceImpl();
//		// 1,表从第一期开始;2,表租金格式化为几位小数
//		rpfcs.rentPlanCalByConditionAndTab(cb, tcb, "1", "2", frpb);

		
		
		Hashtable re_ht = new Hashtable();
		re_ht.put("isSucess", "true");

		logger.info("结束均息法起租时测算方法:rentCalOnHire ..");
		return re_ht;
	}
}
