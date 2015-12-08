package com.tenwa.leasing.util.leasing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.CashConfigBean;
import com.tenwa.leasing.bean.CashDetailsBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.LeasingException;
import com.tenwa.leasing.util.NumTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list 现金流处理)
 */
public class IrrTools {
	static Logger logger = Logger.getLogger(IrrTools.class);
	private static int NUM = 0;// IRR递归计算 计数器
	private final static int NUM_MAX = 10;// IRR最多递归计算次数
	private static BigDecimal IRR_MIN = new BigDecimal("0");// IRR最小值
	private static BigDecimal IRR_MAX = new BigDecimal("1");// IRR最大值

	/**
	 * 
	 * TODO (todo-list todo-list 根据配置信息构建现金流执行语句,如有其它现金流信息的可在此构建时修改)
	 * 
	 * @param cfgb_list
	 * @param tcb
	 * @return
	 */
	public static String getCfgCashSqlByCfgAndTb(
			List<CashConfigBean> cfgb_list, TabCalBean tcb) {

		String sql = " ";
		for (CashConfigBean ccfb : cfgb_list) {
			sql += " select  "+(ccfb.getFee_name().equals("")?"'0'":ccfb.getFee_name())+" as feeName,'" + ccfb.getFee_name_des()
					+ "' as feeNameDes,'" + ccfb.getInOrOut()
					+ "' as inOrout," + ccfb.getOccu_date()
					+ " as sdate,'" + tcb.getContOrProjCValue()
					+ "' as cOrp";
			sql += " from " + tcb.getCondition_tb() + " where "
					+ tcb.getContOrProjCName() + "='"
					+ tcb.getContOrProjCValue() + "' and "
					+ tcb.getDocIdCoulName() + "='" + tcb.getDocIdCoulValue();
			sql += "' union ";
		}
		// 如果是合并起租 要加上之前的剩余本金最为现金流的组成部分
		if (tcb.getIs_merger().equals("是")) {
			sql += "";
		}
		if (sql.indexOf("union") > -1) {
			sql = sql.substring(0, sql.length() - 6);
		}
		sql="select * from ("+sql+") rrss where case when feeName is null then 0 else feeName end  <>0";
		sql += " order by sdate asc";
		logger.debug("现金流配置信息读取sql:" + sql);
		return sql;
	}

	/**
	 * 
	 * TODO (todo-list todo-list 得到去除重复的时间集合，返回一个含有一个时间，对应他的现金集合的下标的键值对
	 * ,如按天则substring(0, 7)需处理)
	 * 
	 * @param ccfbList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Hashtable remoRepDate(List<CashDetailsBean> ccfbList,
			int dtlen) {
		Hashtable htDate = new Hashtable();
		// List dtList = new ArrayList();
		String str = "";
		for (int i = 0; i < ccfbList.size(); i++) {

			CashDetailsBean ccfb = ccfbList.get(i);
			if (!htDate.containsKey(ccfb.getPlan_date().substring(0, dtlen))) {
				htDate.put(ccfb.getPlan_date().toString().substring(0, dtlen),
						String.valueOf(i));
				// dtList.add(ccfb.getPlan_date());
			} else {
				str = (String) htDate.get(ccfb.getPlan_date().toString()
						.substring(0, dtlen));
				str = str + "," + String.valueOf(i);
				htDate.put(ccfb.getPlan_date().toString().substring(0, dtlen),
						str);
			}
		}
		return htDate;

	}

	/**
	 * 
	 * TODO (todo-list todo-list 根据时间得到新的现金流集合 )
	 * 
	 * @param ht_date
	 * @return
	 */
	public static List<CashDetailsBean> getNetCashByDate(Hashtable ht_date,
			List<CashDetailsBean> cdbList) {
		// /HashMap map = this.dateIdenInfo();
		List<CashDetailsBean> listNew = new ArrayList<CashDetailsBean>();

		Object[] obj = ht_date.keySet().toArray();
		Arrays.sort(obj); // 按键值排序

		for (int i = 0; i < obj.length; i++) {
			// logger.debug("=key=" + obj[i].toString());
			// logger.debug("=value=" + ht_date.get(obj[i].toString()));

			String[] strArray = ht_date.get(obj[i].toString()).toString()
					.split(",");

			// 总金额,得到同一时间的总金额d
			// 构建新的现金流明细
			CashDetailsBean cdb = new CashDetailsBean();

			String contract_id = ""; // 合同号
			String plan_date = obj[i].toString();// 日期
			String fund_in = "0"; // 流入量

			String fund_in_details = ""; // 流入量清单
			String fund_out = "0"; // 流出量
			String fund_out_details = ""; // 流出量清单
			String net_flow = "0"; // 净流量
			String quot_id = "";// 报价编号

			for (int j = 0; j < strArray.length; j++) {

				// cdbList
				CashDetailsBean cdbOld = cdbList.get(Integer
						.parseInt(strArray[j].toString()));
				contract_id = cdbOld.getContract_id();

				fund_in = new BigDecimal(fund_in).add(
						new BigDecimal(cdbOld.getFund_in())).toString();
				fund_in_details = fund_in_details + cdbOld.getFund_in_details();

				fund_out = new BigDecimal(fund_out).add(
						new BigDecimal(cdbOld.getFund_out())).toString();
				fund_out_details = fund_out_details
						+ cdbOld.getFund_out_details();

				net_flow = new BigDecimal(fund_in).subtract(
						new BigDecimal(fund_out)).toString();

				quot_id = cdbOld.getQuot_id();

			}
			cdb.setContract_id(contract_id);
			cdb.setPlan_date(plan_date);
			cdb.setFund_in(fund_in);
			cdb.setFund_in_details(fund_in_details);

			cdb.setFund_out(fund_out);
			cdb.setFund_out_details(fund_out_details);
			cdb.setNet_flow(net_flow);
			cdb.setQuot_id(quot_id);

			listNew.add(cdb);

		}
		// 返回新的现金流明细
		return listNew;

	}

	/**
	 * 根据租金现金流，偿还间隔，租金间隔，年还款次数测算irr
	 * 
	 * @param l_inflow_pour所有现金流入流出
	 * @param chjg偿还间隔
	 * @param zjjg租金间隔
	 * @param nhkcs年还款次数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getIRR(List l_inflow_pour, String chjg, String zjjg,
			String nhkcs) {
		chjg = chjg.equals("") ? "0" : chjg;
		zjjg = zjjg.equals("") ? "0" : zjjg;
		nhkcs = nhkcs.equals("") ? "0" : nhkcs;
		for (int i = 0; i < l_inflow_pour.size(); i++) {
			 //logger.debug("现金流:"+(i+1)+"-->"+l_inflow_pour.get(i));
		}
		// 参数说明：l_inflow_pour=所有现金流入流出（流入为正，流出为负），chjg=偿还间隔，
		// zjjg=租金间隔,nhkcs=年还款次数
		// BigDecimal year_number = new BigDecimal("3");//偿还间隔
		BigDecimal year_number = new BigDecimal(chjg);// 偿还间隔
		// BigDecimal rent_interval = new BigDecimal("3");//每期租金间隔
		BigDecimal rent_interval = new BigDecimal(zjjg);// 每期租金间隔
		BigDecimal tmp = new BigDecimal("1");
		BigDecimal irr = new BigDecimal("0");
		BigDecimal tmp1 = IRR_MIN;
		BigDecimal tmp2 = IRR_MAX;
		BigDecimal bigdec_1 = new BigDecimal("1");
		BigDecimal bigdec_2 = new BigDecimal("2");
		int j = 0;
		try {
			while (tmp.abs().compareTo(new BigDecimal("0.000001")) == 1
					&& j < 100) {

				// logger.debug(NUM+"|"+j+"|tmp:"+tmp+":IRR_MIN:"+tmp1+"IRR:"+irr+"IRR_MAX:"+tmp2);
				tmp = new BigDecimal(l_inflow_pour.get(0).toString());
				for (int i = 1; i < l_inflow_pour.size(); i++) {

					tmp = tmp.add(new BigDecimal(l_inflow_pour.get(i)
							.toString()).divide(new BigDecimal(Math.pow(irr
							.add(bigdec_1).doubleValue(), i)), 20,
							BigDecimal.ROUND_HALF_UP));
				}
				if (tmp.doubleValue() > 0) {
					tmp1 = irr;
					irr = irr.add(tmp2).divide(bigdec_2, 20,
							BigDecimal.ROUND_HALF_UP);
				}
				if (tmp.doubleValue() < 0) {
					tmp2 = irr;
					irr = irr.add(tmp1).divide(bigdec_2, 20,
							BigDecimal.ROUND_HALF_UP);
				}
				j++;
			}
			irr = irr.multiply(year_number).divide(rent_interval, 20,
					BigDecimal.ROUND_HALF_UP);
			// irr = irr.multiply(new BigDecimal("4"));

//			// 2012-3-9 添加IRR递归计算
//			if (NUM < NUM_MAX) {// 在允许迭代次数之内
//				// 如果计算出来的IRR和本次预设的IRR最大值一样
//				// 则认为真实IRR比本次默认IRR大 可以通过把区间设置为上次IRR最小值和上次默认IRR值为区间再次计算
//				// 相反如果和最小值一样则把区间设置为默认值到最大值
//				BigDecimal temp_irr = new BigDecimal("2");
//				boolean dg = false;
//				if (irr.compareTo(IRR_MAX) == 0) {
//					NUM++;
//					IRR_MAX = IRR_MAX.divide(temp_irr, 20,
//							BigDecimal.ROUND_HALF_UP);
//					dg = true;
//				}
//				if (irr.compareTo(IRR_MIN) == 0) {
//					NUM++;
//					IRR_MIN = IRR_MAX.divide(temp_irr, 20,
//							BigDecimal.ROUND_HALF_UP);
//					dg = true;
//				}
//				if (dg) {
//					irr = new BigDecimal(getIRR(l_inflow_pour, chjg, zjjg,
//							nhkcs));
//					//logger.debug(NUM+":" + irr);
//					return irr.toString();
//				}
//			}
			irr = irr.multiply(new BigDecimal(nhkcs));
			return irr.toString().equals("") ? "0" : irr.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	/**
	 * XIRR计算公式 参数1 l_inflow_pour 是对于的现金流,参数2l_date 是对于的现金流时间 这个需要一一对于. <br>
	 * 这个算法对于的是EXECL中的XIRR算法.可以用于精确到日的 日IRR计算
	 * 
	 * @param l_inflow_pour
	 *            现金流List
	 * @param l_date
	 *            对应的日期List
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getXIRR(List l_inflow_pour, List l_date) {
		BigDecimal tmp = new BigDecimal("1");
		BigDecimal irr = new BigDecimal("0.5");
		BigDecimal tmp1 = new BigDecimal("0");
		BigDecimal tmp2 = new BigDecimal("1");
		BigDecimal bigdec_1 = new BigDecimal("1");
		BigDecimal bigdec_2 = new BigDecimal("2");
		int j = 0;
		try {
			while (tmp.abs().doubleValue() > 0.0000000001 && j < 200) {
				tmp = new BigDecimal(l_inflow_pour.get(0).toString());
				String date0 = l_date.get(0).toString();
				for (int i = 1; i < l_inflow_pour.size(); i++) {
					Long quot = DateTools.getDateDiff(l_date.get(i).toString(),
							date0);
					BigDecimal rate2 = new BigDecimal(quot / 365.0);
					tmp = tmp.add(new BigDecimal(l_inflow_pour.get(i)
							.toString()).divide(
							new BigDecimal(Math.pow(irr.add(bigdec_1)
									.doubleValue(), rate2.doubleValue())), 20,
							BigDecimal.ROUND_HALF_UP));
				}
				if (tmp.doubleValue() > 0) {
					tmp1 = irr;
					irr = irr.add(tmp2).divide(bigdec_2, 20,
							BigDecimal.ROUND_HALF_UP);
				}
				if (tmp.doubleValue() < 0) {
					tmp2 = irr;
					irr = irr.add(tmp1).divide(bigdec_2, 20,
							BigDecimal.ROUND_HALF_UP);
				}
				j++;
			}
			return irr.toString().equals("") ? "0" : irr.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "0";
	}

	/**
	 * 
	 * TODO (todo-list todo-list 得到保证金抵扣现金流明细)
	 * 
	 * @param rent_list
	 * @param caut_money
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<CashDetailsBean> getRentDetailsByDeduct(
			List<CashDetailsBean> cdbList, String caut_money) {
		double d_total = 0;
		double dcaut = Double.parseDouble(caut_money);
		String int_s = "";// 用于记录下标的
		if (Double.parseDouble(caut_money) > 0) {
			// 得到可以抵扣的列表的下标值
			int_s = getIdsByDeduct(cdbList, caut_money, d_total, int_s);
			String[] i_array = int_s.split(",");// 保存可以抵扣的租金下标
			for (int j = 0; j < i_array.length; j++) {
				CashDetailsBean cdb = cdbList.get(Integer.parseInt(i_array[j]));
				double temp_rent = Double.parseDouble(cdb.getFund_in());// 用于保存的租金
				if (Double.parseDouble(cdb.getFund_in()) < dcaut) { // 如果租金小于保证金抵扣金额

					// 现金流明细处理
					cdb.setFund_out(cdb.getFund_in());
					cdb.setFund_out_details(cdb.getFund_out_details()
							+ "保证金抵扣："
							+ NumTools.formatNumberDouble(Double
									.parseDouble(NumTools
											.formatNumberDoubleScale(cdb
													.getFund_in(), 2)))+ "；");
					cdb.setNet_flow("0");
					// 重新设置该元素的值
					cdbList.set(Integer.parseInt(i_array[j]), cdb);

				} else {
					if (dcaut > 0) {
						// 现金流明细处理
						cdb.setFund_out(String.valueOf(dcaut));
						cdb.setFund_out_details(cdb.getFund_out_details()
								+ "保证金抵扣："
								+ NumTools.formatNumberDouble(Double
										.parseDouble(NumTools
												.formatNumberDoubleScale(String
														.valueOf(dcaut), 2)))
								+ "；");
						cdb.setNet_flow(String.valueOf(Double.parseDouble(cdb
								.getFund_in())
								- dcaut));
						// 重新设置该元素的值
						cdbList.set(Integer.parseInt(i_array[j]), cdb);
					}
				}
				dcaut = dcaut - temp_rent;// 修改保证金抵扣的值
			}
		}
		return cdbList;
	}

	/**
	 * 
	 * TODO 保证金抵扣金额小于保证金金额 最后要做一笔流出 为保证金金额减去保证金抵扣金额)
	 * 
	 * @param cdbList
	 *            现金流
	 * @param caution_money
	 *            保证金
	 * @param caution_deduction_money
	 *            保证金抵扣金额
	 * @return 返回处理完成的现金流
	 */
	@SuppressWarnings("unchecked")
	public static List<CashDetailsBean> getRentDetailsByDeductOut(
			List<CashDetailsBean> cdbList, String caution_money,
			String caution_deduction_money) {
		double caution = Double.parseDouble(NumTools.getZeroStr(caution_money));
		double caution_deduction = Double.parseDouble(NumTools
				.getZeroStr(caution_deduction_money));
		double loss_money = caution - caution_deduction;
		if (loss_money > 0) {// 保证金金额大于保证金抵扣金额才进入此段
			// 得到最后一期现金流明细对象
			CashDetailsBean cdb = cdbList.get(cdbList.size() - 1);
			// 更新流入，净流量值
			// if (caution_deduction > 0) {// 保证金抵扣金额大于0时
			// 现金流明细处理
			cdb.setFund_out(String.valueOf((Double.parseDouble(cdb
					.getFund_out()) + loss_money)));
			cdb.setFund_out_details(cdb.getFund_out_details()
					+ "保证金退还："
					+ NumTools.formatNumberDouble(Double.parseDouble(NumTools
							.formatNumberDoubleScale(
									String.valueOf(loss_money), 2))) + "；");
			cdb.setNet_flow(String.valueOf(Double.parseDouble(cdb.getFund_in())
					- Double.parseDouble(cdb.getFund_out())));
			// 重新设置此元素的值
			cdbList.set(cdbList.size() - 1, cdb);
		}
		return cdbList;
	}

	/**
	 * 
	 * TODO (todo-list todo-list 得到预收租金抵扣现金流明细)
	 * 
	 * @param rent_list
	 * @param rentbefore_money
	 * @return
	 * @throws LeasingException 
	 */
	@SuppressWarnings("unchecked")
	public static List<CashDetailsBean> getRentDetailsByDeductBeforeRent(
			List<CashDetailsBean> cdbList, String rentbefore_money) throws LeasingException {
		double d_total = 0;
		double dcaut = Double.parseDouble(rentbefore_money);
		String int_s = "";// 用于记录下标的
		if (Double.parseDouble(rentbefore_money) > 0) {
			// 得到可以抵扣的列表的下标值
			int_s = getIdsByDeduct(cdbList, rentbefore_money, d_total, int_s);
			if(int_s==null||int_s.equals("")||int_s.length()<1){
				throw new LeasingException("预收租金抵扣超出正常范围!");
			}
			String[] i_array = int_s.split(",");// 保存可以抵扣的租金下标
			for (int j = 0; j < i_array.length; j++) {
				CashDetailsBean cdb = cdbList.get(Integer.parseInt(i_array[j]));
				double temp_rent = Double.parseDouble(cdb.getFund_in());// 用于保存的租金

				if (Double.parseDouble(cdb.getFund_in()) < dcaut) {
					// 现金流明细处理
					cdb.setFund_out(cdb.getFund_in());
					cdb.setFund_out_details(cdb.getFund_out_details()
							+ "预收租金抵扣："
							+ NumTools.formatNumberDouble(Double
									.parseDouble(NumTools
											.formatNumberDoubleScale(cdb
													.getFund_in(), 2)))+ "；");
					cdb.setNet_flow("0");
					// 重新设置该元素的值
					cdbList.set(Integer.parseInt(i_array[j]), cdb);

				} else {
					// 现金流明细处理
					if (dcaut > 0) {
						cdb.setFund_out(String.valueOf(dcaut));
						cdb.setFund_out_details(cdb.getFund_out_details()
								+ "预收租金抵扣："
								+ NumTools.formatNumberDouble(Double
										.parseDouble(NumTools
												.formatNumberDoubleScale(String
														.valueOf(dcaut), 2)))
								+ "；");
						cdb.setNet_flow(String.valueOf(Double.parseDouble(cdb
								.getFund_in())
								- dcaut));
						// 重新设置该元素的值
						cdbList.set(Integer.parseInt(i_array[j]), cdb);
					}
				}
				dcaut = dcaut - temp_rent;// 修改预收租金抵扣的值
			}
		}
		return cdbList;
	}

	/**
	 * 
	 * TODO 预收租金抵扣金额小于预收租金金额 最后要做一笔流出 为预收租金金额减去预收租金抵扣金额)
	 * 
	 * @param cdbList
	 *            现金流
	 * @param Column_8
	 *            预收租金
	 * @param Column_10
	 *            预收租金抵扣金额
	 * @return 返回处理完成的现金流
	 */
	@SuppressWarnings("unchecked")
	public static List<CashDetailsBean> getRentDetailsByDeductBeforeRentOut(
			List<CashDetailsBean> cdbList, String Column_8, String Column_10) {
		double Before_rent = Double.parseDouble(NumTools.getZeroStr(Column_8));
		double Before_rent_deduction = Double.parseDouble(NumTools
				.getZeroStr(Column_10));
		double loss_money = Before_rent - Before_rent_deduction;
		if (loss_money > 0) {// 预收租金金额大于预收租金抵扣金额进入
			// 得到最后一期现金流明细对象
			CashDetailsBean cdb = cdbList.get(cdbList.size() - 1);
			// 更新流入，净流量值
			// 现金流明细处理
			cdb.setFund_out(String.valueOf((Double.parseDouble(cdb
					.getFund_out()) + loss_money)));
			cdb.setFund_out_details(cdb.getFund_out_details()
					+ "预收租金退还："
					+ NumTools.formatNumberDouble(Double.parseDouble(NumTools
							.formatNumberDoubleScale(
									String.valueOf(loss_money), 2))) + "；");
			cdb.setNet_flow(String.valueOf(Double.parseDouble(cdb.getFund_in())
					- Double.parseDouble(cdb.getFund_out())));
			// 重新设置此元素的值
			cdbList.set(cdbList.size() - 1, cdb);
		}
		return cdbList;
	}

	/**
	 * 
	 * TODO (todo-list todo-list 得到可以保证金抵扣的租金下标值)
	 * 
	 * @param cdbList
	 * @param caut_money
	 * @param d_total
	 * @param int_s
	 * @return
	 */
	private static String getIdsByDeduct(List<CashDetailsBean> cdbList,
			String caut_money, double d_total, String int_s) {
		for (int i = cdbList.size() - 1; i >= 0; i--) {
			CashDetailsBean cdb = cdbList.get(i);
			d_total = d_total
					+ Double.parseDouble(cdb.getNet_flow().toString());
			if (d_total > 0) {
				int_s += i + ",";
			}
			logger.debug(d_total + "...");
			if (d_total > Double.parseDouble(caut_money)) {
				break;
			}
		}
		int_s = int_s.indexOf(",") > -1 ? int_s
				.substring(0, int_s.length() - 1) : int_s;// 得到可以抵扣的租金的下标
				logger.debug(int_s + "==");
		return int_s;
	}

	/**
	 * 
	 * TODO (todo-list todo-list 对最后一项现金流明细进行整理,如有变更的可以重写此方法)
	 * 
	 * @param cdbList
	 * @param equip_end_value
	 * @param nominal_price
	 * @return
	 */
	public static List<CashDetailsBean> getCashDetailsByEndValue(
			List<CashDetailsBean> cdbList, String equip_end_value,
			String nominal_price) {
		// 得到最后一期现金流明细对象
		CashDetailsBean cdb = cdbList.get(cdbList.size() - 1);
		// 更新流入，净流量值
		if (null != equip_end_value && !"".equals(equip_end_value)
				&& Double.parseDouble(equip_end_value) > 0) {// 期末残值大于0时
			cdb.setFund_in(String.valueOf(Double.parseDouble(cdb.getFund_in())
					+ Double.parseDouble(equip_end_value)));

			cdb.setFund_in_details(cdb.getFund_in_details()
					+ "；期末余值："
					+ NumTools.formatNumberDouble(Double.parseDouble(NumTools
							.formatNumberDoubleScale(equip_end_value, 2))));

			cdb.setNet_flow(String.valueOf(Double
					.parseDouble(cdb.getNet_flow())
					+ Double.parseDouble(equip_end_value)));
		}

		if (null != nominal_price && !"".equals(nominal_price)
				&& Double.parseDouble(nominal_price) > 0) {// 名义货价大于0时
			cdb.setFund_in(String.valueOf(Double.parseDouble(cdb.getFund_in())
					+ Double.parseDouble(nominal_price)));
			cdb.setFund_in_details(cdb.getFund_in_details()
					+ "；留购价："
					+ NumTools.formatNumberDouble(Double.parseDouble(NumTools
							.formatNumberDoubleScale(nominal_price, 2))) + "；");
			cdb.setNet_flow(String.valueOf(Double
					.parseDouble(cdb.getNet_flow())
					+ Double.parseDouble(nominal_price)));
		}

		// 重新设置此元素的值

		cdbList.set(cdbList.size() - 1, cdb);
		return cdbList;

	}

	/**
	 * 
	 * TODO (todo-list todo-list 现金流明细构建)
	 * 
	 * @param cdbList
	 * @param cb
	 * @return
	 */
	public static String getIrr(List<CashDetailsBean> cdbList, ConditionBean cb) {

		// 得到租金列表
		List rent_list = getRentListByCashDetails(cdbList);
		// 调用计算irr的公式
		return IrrTools.getIRR(rent_list, String.valueOf(12 / Integer
				.parseInt(cb.getIncomeNumberYear())), String
				.valueOf(12 / Integer.parseInt(cb.getIncomeNumberYear())), cb
				.getIncomeNumberYear());

	}

	/**
	 * 
	 * TODO (todo-list todo-list 现金流明细构建)
	 * 
	 * @param cdbList
	 * @param cb
	 * @return
	 */
	public static String getIrrByPreMonth(List<CashDetailsBean> cdbList,
			ConditionBean cb) {

		// 得到租金列表
		List rent_list = getRentListByCashDetails(cdbList);
		// 调用计算irr的公式
		return IrrTools.getIRR(rent_list, String.valueOf(12 / Integer
				.parseInt(cb.getIncomeNumberYear())), String
				.valueOf(12 / Integer.parseInt(cb.getIncomeNumberYear())), cb
				.getIncomeNumberYear());

	}

	/**
	 * 
	 * TODO (todo-list todo-list 根据现金流明细得到新的租金列表，用于算irr值)
	 * 
	 * @param cdbList
	 */
	@SuppressWarnings("unchecked")
	private static List getRentListByCashDetails(List<CashDetailsBean> cdbList) {
		List rent_list = new ArrayList();
		for (CashDetailsBean cdb : cdbList) {
			rent_list.add(cdb.getNet_flow());
		}
		return rent_list;
	}

	/**
	 * 
	 * TODO (todo-list todo-list 算出均息法下的均息法租金列表的irr,并把其当做年利率传递做第二次正常租金测算)
	 * 
	 * @param cb
	 *            交易结构bean
	 * @param frpb
	 *            租金集合bean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getIRRByEvenInterest(ConditionBean cb,
			FundRentPlanBean frpb) {
		String irr = "";
		List l_inflow_pour = new ArrayList();// 现金流
		List rent_list = frpb.getRent_list();
		// 2011-11-14 均息法有宽限期的时候 宽限期累的租金不能加入现金流计算
		int grace = Integer.parseInt(cb.getGrace());
		grace = grace > 0 ? grace : 0;
		// 构建第一笔负金额
		String leasing_money=cb.getReckonType().equals("reckon")?cb.getCalTotalByCont():cb.getCalTotalByFinac();
		if (cb.getPeriodType().equals("1")) {// 期初就加上第一笔金额
			//2012-09-22 这里构建第一笔现金流的时候要用财务本金构建.因为在租金计划变更的时候计算现金流时的IRR中其实为财务本金
			l_inflow_pour.add(new BigDecimal("-" +leasing_money).add(
					new BigDecimal(rent_list.get(grace).toString()).setScale(
							RentTools.getAccuracy(),
							BigDecimal.ROUND_HALF_UP)).toString());
			rent_list.remove(0);
		} else {
			l_inflow_pour.add("-" + leasing_money);
		}

		for (int i = grace; i < rent_list.size(); i++) {
			l_inflow_pour.add(rent_list.get(i).toString());
		}
		irr = IrrTools.getIRR(l_inflow_pour, String.valueOf(12 / Integer
				.parseInt(cb.getIncomeNumberYear())), String
				.valueOf(12 / Integer.parseInt(cb.getIncomeNumberYear())), cb
				.getIncomeNumberYear());
		irr = Double.parseDouble(irr) * 100.0 + "";
		return irr;
	}

	/**
	 * 
	 * TODO (根据现金流获得对应的年利率)
	 * 
	 * @param alCash
	 *            现金流 用HashMap key为net_flow 存的每期的值
	 * @param income_number_year
	 *            年还款次数
	 * @return 返回年利率 保留六位小数 例如 8.123456% 则返回 8.123456
	 */
	@SuppressWarnings("unchecked")
	public static String getRateByFlow(ArrayList alCash,
			String income_number_year) {
		// 根据现金流获取年利率
		ArrayList alirr = new ArrayList();
		for (int i = 0; i < alCash.size(); i++) {
			HashMap hm = (HashMap) alCash.get(i);
			alirr.add(new BigDecimal((String) hm.get("net_flow")));
		}
		return NumTools.formatNumberDoubleScale(Double.parseDouble(getIRR(
				alirr, "1", "1", income_number_year))
				* 100 + "", 6);
	}
}
