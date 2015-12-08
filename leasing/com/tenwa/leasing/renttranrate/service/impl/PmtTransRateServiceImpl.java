package com.tenwa.leasing.renttranrate.service.impl;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.InterContBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.renttranrate.service.RentTranRateService;
import com.tenwa.leasing.renttranrate.service.TransRateService;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 等额租金调息)
 */
public class PmtTransRateServiceImpl
		implements TransRateService {

	/**
	 * 
	 * TODO (todo-list todo-list 该合同的交易结构信息,合同调息记录信息
	 * 
	 * @param cb
	 * @param icb
	 * @throws Exception
	 */
	public InterContBean processPmtTranRate(ConditionBean cb,
			InterContBean icb, TabCalBean tcb) throws Exception {

		RentTranRateService rtrs = null;
		// 判断调息方式,根据调息方式,调用不同的处理类
		// 由于次日，次年算法无异，不同的是第一期所算利息的日期不一样，从调息日期得到第一期开始期项不一样之外，其它的处理是一样的
		// 而调息日期的决定，开始日期的得到从上一级处理也处理好了，故在此次日，次年，次月的实现类一样
		if (null != cb && null != cb.getAdjustStyle()
				&& !"".equals(cb.getAdjustStyle())) {

			if ("next_day".equals(cb.getAdjustStyle())) {// 次日
				rtrs = new PmtNextDayServiceImpl();

			} else if ("next_month".equals(cb.getAdjustStyle())) {// 次月
			// rtrs = new PmtNextMonthServiceImpl();

				rtrs = new PmtNextDayServiceImpl();

			} else if ("next_year".equals(cb.getAdjustStyle())) {// 次年
			// rtrs = new PmtNextYearServiceImpl();

				rtrs = new PmtNextDayServiceImpl();

			} else if ("next_list".equals(cb.getAdjustStyle())) {// 次期
				//2011-11-10 只有次期的调息
				rtrs = new PmtNextListServiceImpl();

			}
			icb = rtrs.processPmtTranRate(cb, icb, tcb);
		}

		return icb;

	}

}
