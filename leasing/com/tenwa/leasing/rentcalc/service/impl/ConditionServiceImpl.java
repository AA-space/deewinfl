package com.tenwa.leasing.rentcalc.service.impl;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rent.dao.ConditionDAO;
import com.tenwa.leasing.rent.dao.impl.ConditionDAOImpl;
import com.tenwa.leasing.util.leasing.DictTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-4
 * @desc TODO (todo-list 交易结构现金流irr更新，交易结构数据进行添加等调用处理类)
 */
public class ConditionServiceImpl {

	/**
	 * 
	 * TODO (todo-list todo-list //租金测算时先删除，后新增交易结构信息)
	 * 
	 * @param tcb
	 * @param cb
	 * @return
	 * @throws Exception
	 */
	public boolean addConditionByCal(TabCalBean tcb, ConditionBean cb)
			throws Exception {
		// 删除
		ConditionDAO cd = new ConditionDAOImpl();
		cd.deleteCondition(tcb,cb);
		// 新增
		// 数所字典转化
		cb = DictTools.getPersiDict(cb);
		cd.addCondition(cb, tcb);
		// 为了后面的计算再转向
		cb = DictTools.getReversDict(cb);

		return true;
	}

}
