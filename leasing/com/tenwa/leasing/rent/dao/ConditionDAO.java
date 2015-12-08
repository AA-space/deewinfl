package com.tenwa.leasing.rent.dao;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.TabCalBean;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list 公用交易结构dao处理接口)
 */

public interface ConditionDAO {

	/**
	 * 
	 * TODO (todo-list todo-list 删除交易结构信息)
	 * 
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	public boolean deleteCondition(TabCalBean tcb,ConditionBean cb) throws Exception;


	/**
	 * 
	 * TODO (todo-list todo-list 新增交易结构信息)
	 * 
	 * @param cb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	public boolean addCondition(ConditionBean cb, TabCalBean tcb)
			throws Exception;


	/**
	 * 
	 * TODO (todo-list todo-list 更新合同的irr)
	 * 
	 * @param tcb
	 * @param contIrr
	 * @return
	 * @throws Exception
	 */
	public boolean updateConditionContIrr(TabCalBean tcb, String contIrr)
			throws Exception;


	/**
	 * 
	 * TODO (todo-list todo-list 更新会计的irr)
	 * 
	 * @param tcb
	 * @param finaIrr
	 * @return
	 * @throws Exception
	 */
	public boolean updateConditionFinaIrr(TabCalBean tcb, String finaIrr)
			throws Exception;
	
	/**
	 * scl 租金计划变更中使用到
	 * TODO (根据ConditionBean和TabCalBean 更新 income_number_year,income_number,lease_term)
	 * @param tcb
	 * @param cdb
	 * @return
	 * @throws Exception
	 */
	public boolean updateConditionIncomeNum(TabCalBean tcb, ConditionBean cdb)
			throws Exception ;
}
