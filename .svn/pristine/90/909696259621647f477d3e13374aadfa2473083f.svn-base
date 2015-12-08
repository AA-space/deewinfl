package com.tenwa.leasing.util.leasing;

import com.tenwa.leasing.bean.ConditionBean;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-10
 * @desc TODO (todo-list 数据库字典，程序中翻译过程)
 */
public class DictTools {

	/**
	 * 
	 * TODO (todo-list todo-list 将交易结构表的一些数据库字典信息翻译成可以程序运行的)
	 * 
	 * @param cb
	 * @return
	 */
	public static ConditionBean getReversDict(ConditionBean cb) {

		// 付租类型
		if (null != cb.getIncomeNumberYear()
				&& "income_1".equals(cb.getIncomeNumberYear())) {
			cb.setIncomeNumberYear("12");
		} else if (null != cb.getIncomeNumberYear()
				&& "income_3".equals(cb.getIncomeNumberYear())) {
			cb.setIncomeNumberYear("4");
		} else if (null != cb.getIncomeNumberYear()
				&& "income_6".equals(cb.getIncomeNumberYear())) {
			cb.setIncomeNumberYear("2");
		} else if (null != cb.getIncomeNumberYear()
				&& "income_12".equals(cb.getIncomeNumberYear())) {
			cb.setIncomeNumberYear("1");
		} else if (null != cb.getIncomeNumberYear()
				&& "income_2".equals(cb.getIncomeNumberYear())) {
			cb.setIncomeNumberYear("6");
		}

		// 起租类型
		if (null != cb.getPeriodType()
				&& "period_type_0".equals(cb.getPeriodType())) {// 期初
			cb.setPeriodType("1");
		} else if (null != cb.getPeriodType()
				&& "period_type_1".equals(cb.getPeriodType())) {// 期末时
			cb.setPeriodType("0");
		}

		return cb;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 持久化交易结构调用反转)
	 * 
	 * @param cb
	 * @return
	 */
	public static ConditionBean getPersiDict(ConditionBean cb) {

		// 付租类型
		if (null != cb.getIncomeNumberYear()
				&& "12".equals(cb.getIncomeNumberYear())) {
			cb.setIncomeNumberYear("income_1");
		} else if (null != cb.getIncomeNumberYear()
				&& "4".equals(cb.getIncomeNumberYear())) {
			cb.setIncomeNumberYear("income_3");
		} else if (null != cb.getIncomeNumberYear()
				&& "2".equals(cb.getIncomeNumberYear())) {
			cb.setIncomeNumberYear("income_6");
		} else if (null != cb.getIncomeNumberYear()
				&& "1".equals(cb.getIncomeNumberYear())) {
			cb.setIncomeNumberYear("income_12");

		} else if (null != cb.getIncomeNumberYear()
				&& "6".equals(cb.getIncomeNumberYear())) {
			cb.setIncomeNumberYear("income_2");
		}

		// 起租类型
		if (null != cb.getPeriodType() && "1".equals(cb.getPeriodType())) {// 期初
			cb.setPeriodType("period_type_0");
		} else if (null != cb.getPeriodType()
				&& "0".equals(cb.getPeriodType())) {// 期末时
			cb.setPeriodType("period_type_1");
		}

		return cb;
	}

}
