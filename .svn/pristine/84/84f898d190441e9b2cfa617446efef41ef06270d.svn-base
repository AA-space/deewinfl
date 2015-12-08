package com.tenwa.leasing.irr.service;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-4
 * @desc TODO (todo-list 现金流处理总入口点,其它的现金流可用它来声明，并实例化)
 */
public interface IrrService {

	/**
	 * 
	 * TODO (todo-list todo-list 现金流处理方法)
	 * 
	 * @param cb 交易结构bean	
	 * @param tb 
	 * @param frpb 租金计划bean
	 * @param calType  现金流处理方式 1 代表按照期处理, 2 代表按照月处理
	 * @return
	 * @throws Exception
	 */
	public ConditionBean calCashIrrFinacAndCont(ConditionBean cb,
			TabCalBean tb, FundRentPlanBean frpb, String calType)
			throws Exception;

}
