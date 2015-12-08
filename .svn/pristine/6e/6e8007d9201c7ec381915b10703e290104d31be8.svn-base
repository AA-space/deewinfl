package com.tenwa.leasing.renttranrate.service.impl;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.InterContBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.service.impl.IrrServiceByTranImpl;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.RentPlanFinacCalServiceImpl;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 调息时会计的租金计划处理)
 */
public class FinaRentPlanServiceImpl {

	static Logger	logger	= Logger.getLogger(FinaRentPlanServiceImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 财务调息处理)
	 * 
	 * @param cb
	 * @param icb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	public InterContBean processFinacRentPlan(ConditionBean cb,
			InterContBean icb, TabCalBean tcb, FundRentPlanBean frpb)
			throws Exception {

		// 得到此时财务计算的irr
		IrrServiceByTranImpl isbti = new IrrServiceByTranImpl();
		// 1,默认按期来计算现金流irr,
		isbti.getAdjustFinacIrr(cb, tcb, frpb, "1", icb.getStart_list());

		// 财务租金计划处理
		RentPlanFinacCalServiceImpl rpfcs = new RentPlanFinacCalServiceImpl();
		// 1,表从第一期开始;2,表租金格式化为几位小数
		rpfcs.rentPlanCalByConditionAndTab(cb, tcb, icb.getStart_list(), "2",frpb);

		return icb;
	}

}
