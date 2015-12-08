package com.tenwa.leasing.util.leasing;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list 利率计算类)
 */
public class RateTools {

	static Logger	logger	= Logger.getLogger(RateTools.class);


	/**
	 * 计算每一期测算时的利率值
	 * 
	 * @Title: getPreRate
	 * @Description:
	 * @param
	 * @param calcRate所要计算的年利率或irr
	 * @param
	 * @param lease_interval
	 *            租金间隔
	 * @param
	 * @return
	 * @return String
	 * @throws
	 */
	@SuppressWarnings("unused")
	public static String getPreRate(String calcRate, String lease_interval) {

		BigDecimal rateDecimal = new BigDecimal(calcRate);

		try {

//			logger.info("===="
//					+ rateDecimal.divide(new BigDecimal("100"), 20,
//							BigDecimal.ROUND_HALF_UP));
			
			rateDecimal = rateDecimal.divide(new BigDecimal("100"), 20,
					BigDecimal.ROUND_HALF_UP).divide(new BigDecimal("12"), 20,
					BigDecimal.ROUND_HALF_UP).multiply(
					new BigDecimal(String.valueOf(12 / Integer
							.parseInt(lease_interval))));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rateDecimal.toString();
	}
	/**
	 * 计算每月利率值
	 * 
	 * @Title: getPreRate
	 * @Description:
	 * @param
	 * @param calcRate所要计算的年利率或irr
	 * @param
	 * @param lease_interval
	 *            租金间隔
	 * @param
	 * @return
	 * @return String
	 * @throws
	 */
	@SuppressWarnings("unused")
	public static String getPreMonthRate(String calcRate) {
		
		BigDecimal rateDecimal = new BigDecimal(calcRate);
		
		try {
			rateDecimal = rateDecimal.divide(new BigDecimal("100"), 20,
					BigDecimal.ROUND_HALF_UP).divide(new BigDecimal("12"), 20,
							BigDecimal.ROUND_HALF_UP);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rateDecimal.toString();
	}

}
