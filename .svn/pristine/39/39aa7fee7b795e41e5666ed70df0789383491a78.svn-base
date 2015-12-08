package com.tenwa.leasing.renttranrate.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.util.leasing.IrrTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 调息时的利率计算)
 */
public class RateCalTranServiceImpl {
	static Logger logger = Logger.getLogger(RateCalTranServiceImpl.class);

	/**
	 * 央行浮动比例调息
	 * 
	 * @param lease_term
	 *            期限
	 * @param adjust
	 *            央行利率
	 * @param adjust_point
	 *            利率调整值
	 * @return
	 */
	public String getRateByProportion(int leaseTerm, Hashtable adjust, String oldYearRate) {
		String rateBase = "0";// 基准利率
		String floatPoint = "0";// 基准利率上涨点，原来是5调倒6，则上张点是6-5=1
		int leaseTermValue = leaseTerm;
		if (leaseTermValue <= 6) {// 六个月以内
			rateBase = adjust.get("base_rate_half").toString();
			floatPoint = adjust.get("rate_half").toString();
		} else if (leaseTermValue <= 12) {// 一年以内
			rateBase = adjust.get("base_rate_one").toString();
			floatPoint = adjust.get("rate_one").toString();
		} else if (leaseTermValue <= 36) {// 二年到三年之间时
			rateBase = adjust.get("base_rate_three").toString();
			floatPoint = adjust.get("rate_three").toString();
		} else if (leaseTermValue <= 60) {// 四，五年之间时
			rateBase = adjust.get("base_rate_five").toString();
			floatPoint = adjust.get("rate_five").toString();
		} else {// 五年以上时
			rateBase = adjust.get("base_rate_abovefive").toString();
			floatPoint = adjust.get("rate_abovefive").toString();
		}
		// 新年利率 = 原年利率*调息后基准利率/调息前基准利率。
		BigDecimal adjustBefore = new BigDecimal(rateBase);
		BigDecimal adjustAfter = adjustBefore.add(new BigDecimal(floatPoint));
		BigDecimal newYearRate = new BigDecimal(oldYearRate).multiply(adjustAfter).divide(adjustBefore, 6, BigDecimal.ROUND_HALF_UP);
		return newYearRate.toString();
	}

	/**
	 * 按央行利率加点
	 * 
	 * @param lease_term
	 *            期限
	 * @param year_rate
	 *            年利率
	 * @return
	 */
	public String getRateByPoint(int leaseTerm, Hashtable adjust, String oldYearRate) {
		String floatPoint = "0";
		if (leaseTerm <= 6) {
			floatPoint = adjust.get("rate_half").toString();
		} else if (leaseTerm <= 12) {
			floatPoint = adjust.get("rate_one").toString();
		} else if (leaseTerm <= 36) {
			floatPoint = adjust.get("rate_three").toString();
		} else if (leaseTerm <= 60) {
			floatPoint = adjust.get("rate_five").toString();
		} else {
			floatPoint = adjust.get("rate_abovefive").toString();
		}
		// 计算他的利率值,在央行的基础上加多少点
		floatPoint = new BigDecimal(floatPoint).add(new BigDecimal(oldYearRate)).toString();
		// 返回的是%之多少
		return floatPoint;
	}

	/**
	 * 计算出该合同的新利率
	 * 
	 * @param floatType
	 *            调息方式
	 * @param lease_term
	 *            期限
	 * @param old_year_rate
	 *            旧利率
	 * @param adjust_value
	 *            调整值
	 * @param adjust
	 *            央行利率
	 * @return
	 */
	public String getNewRate(String floatType, String lease_term, String old_year_rate, String adjust_value, Hashtable adjust) {
		String newRate = "0";
		int leaseTerm = Integer.parseInt(lease_term);
		if ("proportion".equals(floatType)) {// 按央行利率浮动时
			newRate = getRateByProportion(leaseTerm, adjust, old_year_rate);
		} else if ("add".equals(floatType)) {// 按央利率加点时
			newRate = getRateByPoint(leaseTerm, adjust, old_year_rate);
		} else {// 固定利率
			newRate = old_year_rate;
		}
		return newRate;

	}

	/**
	 * 
	 * TODO 2011-9-14 调息改为等比上调,该方法算出在这次调息中等比上调的比例值
	 * 
	 * @param al
	 *            现金流 用HashMap key为net_flow 存的每期的值
	 * @param newRate
	 *            新年利率
	 * @param income_number_year
	 *            年还款次数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getAdjustRatioByCash(List al, String newRate, String income_number_year) {
		logger.info("传入测算iavg的参数:新的利率" + newRate + "--年还租次数：" + income_number_year);
		double dnewRate = 0.0;
		double dsubRate = 0.0;
		double iavg = 1.1;
		ArrayList alcash = new ArrayList();
		if (newRate != null && !newRate.equals("")) {
			dnewRate = Double.parseDouble(newRate);
		} else {
			logger.error("调息过程中出错:新的年利率为空!");
			return "1";
		}
		double dmaxavg = 1.9;// 初始化最大比率
		double dminavg = 0.1;// 初始化最小比率
		int flag = 0;
		while (new BigDecimal(dnewRate - dsubRate).abs().doubleValue() > 0.000000001 && flag < 100) {
			alcash = new ArrayList();
			alcash.add(al.get(0));// 第一笔负值始终不变
			for (int i = 1; i < al.size(); i++) {// 把后续每期二分法等比上调直到反推出来的年利率等于新的年利率
				// System.out.println("  iiii-->"+i);
				HashMap hm = (HashMap) al.get(i);
				HashMap hmTemp = new HashMap();
				BigDecimal bigDecimal = new BigDecimal(String.valueOf(hm.get("net_flow")));

				bigDecimal = bigDecimal.multiply(new BigDecimal(iavg));
				// System.out.println(bigDecimal);
				hmTemp.put("net_flow", String.valueOf(bigDecimal));
				alcash.add(hmTemp);
			}

			String subRate = IrrTools.getRateByFlow(alcash, income_number_year);
			logger.debug("等比为" + iavg + ",测算利率为:" + subRate);
			if (subRate != null && !subRate.equals("")) {
				dsubRate = Double.parseDouble(subRate);
			}
			// 2012-6-27 如果测算出来的IRR 超过100 则认为是无效值 这个时候可能是等比的区间过大
			if (dsubRate >= 100) {
				dminavg = iavg;
				iavg = (dmaxavg + iavg) / 2;
			} else {
				if (new BigDecimal(dnewRate - dsubRate).doubleValue() < 0) {
					dmaxavg = iavg;
					iavg = (iavg + dminavg) / 2;
				} else if (new BigDecimal(dnewRate - dsubRate).doubleValue() > 0) {
					dminavg = iavg;
					iavg = (dmaxavg + iavg) / 2;
				}
			}
			// logger.info("iavg:"+iavg+";dmaxavg"+dmaxavg+";dminavg"+dminavg);
			flag++;
			// logger.info("批量调息修改以及调息测算iavg:"+iavg);
		}
		return String.valueOf(iavg);
	}
}
