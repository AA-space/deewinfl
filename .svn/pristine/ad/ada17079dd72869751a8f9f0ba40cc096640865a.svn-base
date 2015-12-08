package com.tenwa.leasing.renttranrate.service.impl;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rent.dao.impl.ConditionDAOImpl;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-23
 * @desc TODO (todo-list 交易结构调息时处理)
 */
public class ConditionTranServicesImpl {

	/**
	 * 
	 * TODO (todo-list todo-list 调息时用于计算现金流明细的交易结构bean的构建)
	 * 
	 * @param cbCal测算时的实体bean
	 * @param wheresql所要查询的表
	 * @return
	 * @throws Exception
	 */
	public ConditionBean getCondCashBean(ConditionBean cbCal, String wheresql,TabCalBean tcb)
			throws Exception {
		ConditionDAOImpl cdi = new ConditionDAOImpl();
		ConditionBean cb = cdi.getConditionBeanByContract(wheresql,tcb);
		// 由于他此时的当前操作人，操作时间，修改人，修改时间变化，故在此要重新设置

		cb.setMeasureId(cbCal.getMeasureId());
		cb.setCreator(cb.getCreator());
		cb.setModificator(cb.getCreator());
		cb.setModifyDate(cb.getModifyDate());

		return cb;
	}

}
