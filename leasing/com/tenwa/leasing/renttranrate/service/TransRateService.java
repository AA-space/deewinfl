package com.tenwa.leasing.renttranrate.service;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.InterContBean;
import com.tenwa.leasing.bean.TabCalBean;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 不同测算方式实现接口声明)
 */
public interface TransRateService  {

	/**
	 * 
	 * TODO (todo-list todo-list 调息处理方法)
	 * 
	 * @param cb
	 * @param icb
	 * @return
	 * @throws Exception
	 */
	public InterContBean processPmtTranRate(ConditionBean cb, InterContBean icb,TabCalBean tcb)
			throws Exception;

}
