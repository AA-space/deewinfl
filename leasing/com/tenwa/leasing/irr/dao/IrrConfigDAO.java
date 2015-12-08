package com.tenwa.leasing.irr.dao;

import java.util.List;

import com.tenwa.leasing.bean.CashConfigBean;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-3
 * @desc TODO (todo-list 现金流处理配置操作DAO)
 */
public interface IrrConfigDAO {
	public List<CashConfigBean> getConfigInfo(String occu_type)
			throws Exception;

}
