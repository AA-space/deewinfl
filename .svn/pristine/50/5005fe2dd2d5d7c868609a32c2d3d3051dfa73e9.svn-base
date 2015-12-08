package com.tenwa.leasing.renttranrate.service.impl;

import com.tenwa.leasing.util.DateTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 调息时的日期处理)
 */
public class TransDateServiceImpl {
	/**
	 * 
	 * TODO (todo-list todo-list 根据调息方式，调息开始时间计算实际调息开始日期)
	 * 
	 * @param adjustType
	 * @param adjustDate
	 * @return
	 * @throws Exception
	 */

	public static String getNewDateByAdjustType(String adjustType, String adjustDate)
			throws Exception {

		String sdate = adjustDate;
		if ("next_year".equals(adjustType)) {
			// 根据调息日得到他的下一年
			sdate = DateTools.getYearFirstDay(adjustDate);
		}
		if ("next_month".equals(adjustType)) {
			// 月的第一天
			sdate = DateTools.getMonthFirstDay(adjustDate);
		}
		return sdate;

	}
}
