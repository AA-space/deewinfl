package com.tenwa.leasing.irr.service.impl;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.CashDetailsBean;
import com.tenwa.leasing.util.leasing.IrrTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-4
 * @desc TODO (todo-list 有关irr算法处理类)
 */
public class IrrCalServiceImpl {
	private static Logger	logger	= Logger.getLogger(IrrCalServiceImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 根据现金流明细（租金与配置信息的），现金流计算方法（按月，按天，按期等）)
	 * 
	 * @param calType
	 * @param ccfbList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CashDetailsBean> getNewCashDetailsByCalType(String calType,
			List<CashDetailsBean> ccfbList) {
		// 得到重复时间的现金流
		if ("1".equals(calType)) {// 按期时,默认
			Hashtable ht_date = IrrTools.remoRepDate(ccfbList, 7);// 由于他是显示年月字段
			// 调用现金流明细构建
			logger.debug("现金流明细按期构建..");
			return IrrTools.getNetCashByDate(ht_date, ccfbList);

		} else if ("2".equals(calType)) {// 按月等处理
			// 重新构建ccfbList
			return new IrrCalByMonthServiceImpl().getNewCashDetailsByCalType(ccfbList);
		}

		return null;

	}

}
