package com.tenwa.leasing.rentcalc.service;

import java.util.Hashtable;

import com.tenwa.leasing.bean.ConditionBean;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-2
 * @desc TODO (todo-list 租金测算方式接口)
 */
public interface RentCalcService {
	/**
	 * 
	 * TODO (todo-list todo-list 不同租金测算实现接口)
	 * 
	 * @param cb
	 * @param calType
	 * @param userName
	 * @param obj
	 * @return
	 * @throws Exception
	 */

	public Hashtable rentCal(ConditionBean cb, String calType, String userName,
			Object obj,String star_list) throws Exception;


	/**
	 * 
	 * TODO (todo-list todo-list 起租时要实现的方法)
	 * 
	 * @param cb
	 * @param calType
	 * @param userName
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Hashtable rentCalOnHire(ConditionBean cb, String calType,
			String userName, Object obj) throws Exception;

}
