package com.tenwa.leasing.renttranrate.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.ConstantBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.InterContBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.renttranrate.dao.impl.InteCtractDAOImpl;
import com.tenwa.leasing.renttranrate.dao.impl.RentPlanDAOImpl;
import com.tenwa.leasing.util.DateTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list调息时 合同的租金计划处理)
 */
public class ContrRentPlanServiceImpl {

	static Logger	logger	= Logger.getLogger(ContrRentPlanServiceImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 根据交易结构的宽限期与调息开始期项得到新的测算宽限期)
	 * 
	 * @param grace
	 * @param startList
	 * @return
	 */
	public String getGraceByAdjust(String grace, String startList) {

		String fgrace = "0";
		// 为了要引用正常 的租金测算所以先要重新计算他的宽限期
		if (Integer.parseInt(grace) >= Integer.parseInt(startList)) {// 当调息是从宽限期开始时,得到实际的宽限期天数
			fgrace = String.valueOf(Integer.parseInt(grace)
					- Integer.parseInt(startList) + 1);
		} else {// 如果不是从宽限期开始调时
			fgrace = "0";
		}
		logger.info("新宽限期为:.." + fgrace);

		return fgrace;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 求出新的pmt测算期数)
	 * 
	 * @param incomeNumber
	 * @param startList
	 * @param grace
	 * @return
	 */
	public String getIncomeNumByAdjust(String incomeNumber, String startList,
			String grace) {
		String totalNumber = "0";
		if (Integer.parseInt(grace) >= Integer.parseInt(startList)) {// 当从宽限期开始时
			totalNumber = incomeNumber;// 正常测算时的租金期数
		} else if (Integer.parseInt(grace) < Integer.parseInt(startList)) {// 从正常的测算期项开始时
			totalNumber = String.valueOf(Integer.parseInt(incomeNumber)
					- Integer.parseInt(startList) + 1);
		}
		logger.info("新总期数为:.." + totalNumber);
		return totalNumber;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 调息时得到新的pmt测算的期初期末类型)
	 * 
	 * @param startList
	 * @param grace
	 * @param oldType
	 * @return
	 */
	public String getPeroidType(String startList, String grace, String oldType) {
		String peroidType = oldType;
		if (Integer.parseInt(grace) >= Integer.parseInt(startList)) {// 当从宽限期开始时
			peroidType = oldType;
		} else if (Integer.parseInt(grace) + 1 == Integer.parseInt(startList)) {// 当是第一期时
			peroidType = oldType;
		} else {// 当从正常的租金计划开始且不是第一期时
			peroidType = "0";// 变为期末付,利息测算时需注意的
		}

		logger.info("新起租类型为:.." + peroidType);
		return peroidType;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 计算重新测算的起租时间)
	 * 
	 * @param startList开始调息期项
	 * @param peroidType期初期末
	 * @param startDate起租时间
	 * @param currDate当前期时间
	 * @param lease_interval租金间隔
	 * @return
	 */
	public String getStartDate(String peroidType, String rentPlanDate, int leaseInterval) {
		String newStartDate = rentPlanDate;
		if ("0".equals(peroidType)) {// 期末时
			newStartDate = DateTools.dateAdd("month",0 - leaseInterval, rentPlanDate);
		}
		logger.debug("新起租日期为:....." + newStartDate);
		return newStartDate;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 当前期日期和新的日期，组合成新的计划开始日期)
	 * 
	 * @param currDate
	 * @param newDate
	 * @return
	 * @throws ParseException
	 */
	public String getNewDateByDate(String currDate, String newDate)
			throws ParseException {

		return DateTools.getDateYear(newDate) + "-"
				+ DateTools.getDateMonth(newDate) + "-"
				+ DateTools.getDateDay(currDate);

	}


	/**
	 * 
	 * TODO (todo-list todo-list 查询某一期次的计划日期)
	 * 
	 * @param tcb
	 * @param rentList
	 * @param starDate
	 * @return
	 * @throws Exception
	 */
	public String getRentListDate(TabCalBean tcb, String rentList,
			String starDate) throws Exception {
		logger.info("查询某一期次的计划日期:..");

		String currDate = "0";
		RentPlanDAOImpl rpdi = new RentPlanDAOImpl();
		currDate = rpdi.getPlanDateByWhereSql(tcb.getRentPlan_tb(), rentList,
				" and " + tcb.getContOrProjCName() + "='"
						+ tcb.getContOrProjCValue() + "' and "
						+ tcb.getDocIdCoulName() + "='"
						+ tcb.getDocIdCoulValue() + "' ");

		// 如果是从第一期 开始则前一期的日期为起租日期
		if (currDate.equals("0")) {
			currDate = starDate;
		}

		return currDate;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 调息开始的第一期特别处理)
	 * 
	 * @param cb
	 * @param icb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	public InterContBean calFirstRentPlan(ConditionBean cb, InterContBean icb,
			TabCalBean tcb) throws Exception {
		logger.info("第一期合同租金计划特别构建...");

		// 计算此时测算的总的本金
		RentPlanDAOImpl rpdi = new RentPlanDAOImpl();
		String sCorpus_contr = rpdi.getTotalCorpus(tcb.getRentPlan_tb(),cb.getProjId(), icb
				.getStart_list(), "corpus",tcb.getDocIdCoulValue(),cb.getEquipEndValue());
		cb.setCalTotalByCont(sCorpus_contr);

		// 计算宽限期
		String sgrace = getGraceByAdjust(cb.getGrace(), icb.getStart_list());

		// 查询历史当前合同当前期调息记录
		InteCtractDAOImpl icdi = new InteCtractDAOImpl();
		Hashtable ht_recoder = icdi.searcherRecoder(cb.getProjId(), icb
				.getStart_list());
		List start_dates = (List) ht_recoder.get("start_date");

		String firstInterest = "0";
		String firstRent = "0";
		String firstCorpus = "0";
		String firstCorpusOverage = "0";

		// 先判断调息是从宽限期开始还是从正常的租金计划开始
		if (Integer.parseInt(sgrace) > 0) {// 从宽限期开始时,第一期的测算只影响合同的租金计划，不影响会计的租金计划，宽限期只收利息，故算出新的利息即可
			// ，本金为0,该期的本金余额为总的测算本金

			if (!ht_recoder.isEmpty() && start_dates.size() > 0) {// 存在调息记录
				// 分段计息
				// 宽限期多次调息分段计
				firstInterest = getGraceInterestByMulti(cb, icb, tcb,
						ht_recoder);

			} else {// 不存在历史的调息记录,不分段计息

				// 得到一期的宽限期利息
				firstInterest = getGraceInterestByFirst(cb, icb, tcb);

			}

			firstRent = firstInterest;
			firstCorpus = "0";
			firstCorpusOverage = cb.getCalTotalByCont();

		} else {// 正常租金测算时开始调息

			if (!ht_recoder.isEmpty() && start_dates.size() > 0) {// 存在调息记录
				// 分段计息
				firstInterest = getInterestByMulti(cb, icb, tcb, ht_recoder);

			} else {// 不存在历史的调息记录,不分段计息

				String preDate = getRentListDate(tcb, String.valueOf(Integer
						.parseInt(icb.getStart_list()) - 1), cb.getStartDate()); // 前一期的计划日期
				String currDate = getRentListDate(tcb, String.valueOf(Integer
						.parseInt(icb.getStart_list())), cb.getStartDate()); // 当前期的计划日期

				// 得到第一期特别处理的利息
				firstInterest = getInterestByFirst(icb.getRate_original(), icb
						.getRate_adjust(), icb.getAdjustDate(), preDate,
						currDate, cb.getCalTotalByCont());

			}

			// 当期的租金是不变的
			firstRent = rpdi.getCurrentRent(icb.getStart_list(), tcb
					.getRentPlan_tb(), " and " + tcb.getContOrProjCName()
					+ "='" + tcb.getContOrProjCValue() + "' and "+tcb.getDocIdCoulName()+"='"+tcb.getDocIdCoulValue()+"'");
			// 当期的本金
			firstCorpus = new BigDecimal(firstRent).subtract(
					new BigDecimal(firstInterest)).toString();
			// 当期本金余额
			firstCorpusOverage = new BigDecimal(cb.getCalTotalByCont())
					.subtract(new BigDecimal(firstCorpus)).toString();

		}

		// 更新要调息的第一期租金计划信息
		rpdi.updateSignPlan(cb.getProjId(), icb.getStart_list(), firstRent,
				firstInterest, firstCorpus, firstCorpusOverage, icb
						.getRate_adjust(), tcb.getRentPlan_tb(), " and "
						+ tcb.getDocIdCoulName() + "='"
						+ tcb.getDocIdCoulValue() + "' ", cb.getRentScale());

		return icb;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 宽限租金计划时同一期次进行多次调息时)
	 * 
	 * @param cb
	 * @param icb
	 * @param tcb
	 * @param ht_recoder
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private String getGraceInterestByMulti(ConditionBean cb, InterContBean icb,
			TabCalBean tcb, Hashtable ht_recoder) throws Exception {
		BigDecimal binterest = new BigDecimal("0");

		String preDate = getRentListDate(tcb, String.valueOf(Integer
				.parseInt(icb.getStart_list()) - 1), cb.getStartDate()); // 前一期的计划日期
		String currDate = getRentListDate(tcb, String.valueOf(Integer
				.parseInt(icb.getStart_list())), cb.getStartDate()); // 当前期的计划日期

		// ((B11-B17)*E10+(B12-B11)*E11+(B18-B12)*E12)/(B18-B17)*G13/12*1
		// 求上下两期的天数,构建被除数
		String income_number_year = cb.getIncomeNumberYear();
		long days = DateTools.getDateDiff(currDate, preDate);
		Double dto = Double.parseDouble(cb.getCalTotalByCont()) / days / 12
				* (12 / Integer.parseInt(income_number_year));

		// 算间隔利利息值
		List start_dates = (List) ht_recoder.get("start_date");
		List before_rates = (List) ht_recoder.get("before_rate");
		List after_rates = (List) ht_recoder.get("after_rate");

		// 刚开始用前一期日期与调息记录中的日期计算
		String temp_pre_date = preDate;
		String tem_rate = "0";
		String tem_date = start_dates.get(0).toString();
		String tem_interest = "0";

		for (int i = 0; i < start_dates.size(); i++) {
			if (i == 0) {// 第一期时取最原始的利率来算
				tem_rate = before_rates.get(0).toString();
				tem_date = start_dates.get(0).toString();

			} else {

				tem_rate = before_rates.get(i).toString();
				tem_date = start_dates.get(i).toString();
				temp_pre_date = start_dates.get(i - 1).toString();

			}

			long ds = DateTools.getDateDiff(tem_date, temp_pre_date);
			double dtotalInter = Double.parseDouble(tem_rate) * ds / 100;

			tem_interest = String.valueOf(dtotalInter
					+ Double.parseDouble(tem_interest));
		}

		// 当期的间隔利息计算 （当期时间－上次调息的日期）×新的利率
		long ds_1 = DateTools.getDateDiff(icb.getAdjustDate(), start_dates.get(
				start_dates.size() - 1).toString());
		String first_interest = String.valueOf(ds_1
				* Double.parseDouble(after_rates.get(after_rates.size() - 1)
						.toString()) / 100);

		long ds_d = DateTools.getDateDiff(currDate, icb.getAdjustDate());

		first_interest = String.valueOf(Double.parseDouble(first_interest)
				+ ds_d * Double.parseDouble(icb.getRate_adjust()) / 100);
		first_interest = String
				.valueOf((Double.parseDouble(first_interest) + Double
						.parseDouble(tem_interest))
						* dto);

		return first_interest;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 正常租金计划时同一期次进行多次调息时)
	 * 
	 * @param cb
	 * @param icb
	 * @param tcb
	 * @param ht_recoder
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private String getInterestByMulti(ConditionBean cb, InterContBean icb,
			TabCalBean tcb, Hashtable ht_recoder) throws Exception {
		BigDecimal binterest = new BigDecimal("0");

		String preDate = getRentListDate(tcb, String.valueOf(Integer
				.parseInt(icb.getStart_list()) - 1), cb.getStartDate()); // 前一期的计划日期
		String currDate = getRentListDate(tcb, String.valueOf(Integer
				.parseInt(icb.getStart_list())), cb.getStartDate()); // 当前期的计划日期

		List start_dates = (List) ht_recoder.get("start_date");
		List before_rates = (List) ht_recoder.get("before_rate");
		List after_rates = (List) ht_recoder.get("after_rate");
		// 刚开始用前一期日期与调息记录中的日期计算
		String temp_pre_date = preDate;
		String tem_rate = "0";
		String tem_date = start_dates.get(0).toString();
		String tem_interest = "0";

		for (int i = 0; i < start_dates.size(); i++) {
			if (i == 0) {// 第一期时取最原始的利率来算
				tem_rate = before_rates.get(0).toString();
				tem_date = start_dates.get(0).toString();

			} else {

				tem_rate = before_rates.get(i).toString();
				tem_date = start_dates.get(i).toString();
				temp_pre_date = start_dates.get(i - 1).toString();

			}

			long days = DateTools.getDateDiff(tem_date, temp_pre_date);
			// 总测算本金*此段时间的利率*此段时间的间隔/100/360
			// double dtotalInter = Double.parseDouble(cb.getCalTotalByCont())
			// * Double.parseDouble(tem_rate) / 100
			// / Integer.parseInt(ConstantBean.RATE_ADJUSTMENT_MODULUS)
			// * days;

			BigDecimal btotalInter = new BigDecimal(cb.getCalTotalByCont())
					.multiply(new BigDecimal(tem_rate))
					.multiply(new BigDecimal(days))
					.divide(new BigDecimal("100"))
					.divide(
							new BigDecimal(ConstantBean.RATE_ADJUSTMENT_MODULUS),
							20, BigDecimal.ROUND_HALF_UP);
			tem_interest = btotalInter.add(new BigDecimal(tem_interest))
					.toString();
		}

		// 当期的间隔利息与此调息日的间隔利息计算
		String first_interest = getInterestByFirst(after_rates.get(
				after_rates.size() - 1).toString(), icb.getRate_adjust(), icb
				.getAdjustDate(), tem_date, currDate, cb.getCalTotalByCont());
		binterest = binterest.add(new BigDecimal(first_interest)).add(
				new BigDecimal(tem_interest));

		return binterest.toString();

	}


	/**
	 * 
	 * TODO (todo-list todo-list 正常租金计划在当期发生一次调息时计算当期的利息值)
	 * 
	 * @param cb
	 * @param icb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	private String getInterestByFirst(String oldRate, String newRate,
			String adjustDate, String preDate, String currDate,
			String leassMoney) throws Exception {

		// 得到天数,调息日到调息前一期的天数
		long preDays = DateTools.getDateDiff(adjustDate, preDate);
		long afterDays = DateTools.getDateDiff(currDate, adjustDate);

		// 几个日期值得到第一期相应的利息
		// 测算总本金*(原利率*(调息日期-上一期调息日期)+(当期日期-调息日期)*新利率)/100/360
		BigDecimal binterest = new BigDecimal(oldRate);
		binterest = binterest.multiply(new BigDecimal(preDays));
		binterest = binterest.add(new BigDecimal(newRate)
				.multiply(new BigDecimal(afterDays)));

		binterest = binterest.divide(new BigDecimal("100")).divide(
				new BigDecimal(ConstantBean.RATE_ADJUSTMENT_MODULUS), 20,
				BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(leassMoney));

		// double dtotalInter = Double.parseDouble(leaseMoney)
		// * Double.parseDouble(preRate) / 100 / 360 * preDays
		// + Double.parseDouble(leaseMoney)
		// * Double.parseDouble(rate) / 360 / 100 * afterDays;

		return binterest.toString();
	}


	/**
	 * 
	 * TODO (todo-list todo-list 宽限期发生一次调息时计算当期的利息值)
	 * 
	 * @param cb
	 * @param icb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	private String getGraceInterestByFirst(ConditionBean cb, InterContBean icb,
			TabCalBean tcb) throws Exception {

		String preDate = getRentListDate(tcb, String.valueOf(Integer
				.parseInt(icb.getStart_list()) - 1), cb.getStartDate()); // 前一期的计划日期
		String currDate = getRentListDate(tcb, String.valueOf(Integer
				.parseInt(icb.getStart_list())), cb.getStartDate()); // 当前期的计划日期

		long preDays = DateTools.getDateDiff(icb.getAdjustDate(), preDate);
		long afterDays = DateTools.getDateDiff(currDate, icb.getAdjustDate());
		long preAndCurrDays = DateTools.getDateDiff(currDate, preDate);// 查出当前期与上一期的时间间隔

		// 利率为％之几
		// 公式注解:((调息日期-上一期日期)*原利率+(当前期日期－调息日期)*新利率)／100/(当前期－上一期时间)／12*期新间隔月数*测算本金

		// first_interest = Tools.formatNumberDoubleScale(
		// String.valueOf((preDays * Double.parseDouble(year_rate)
		// / 100 + afterDays
		// * Double.parseDouble(rateValue) / 100)
		// / preDq
		// / 12
		// * Integer.parseInt(income_number_year)
		// * Double.parseDouble(leassMoney)), 4);

		BigDecimal binterest = new BigDecimal(icb.getRate_original())
				.multiply(new BigDecimal(preDays));
		binterest = binterest.add(new BigDecimal(afterDays)
				.multiply(new BigDecimal(icb.getRate_adjust())));
		binterest = binterest.divide(new BigDecimal("12"), 20,
				BigDecimal.ROUND_HALF_UP).divide(
				new BigDecimal(preAndCurrDays), 20, BigDecimal.ROUND_HALF_UP)
				.divide(new BigDecimal("100"), 20, BigDecimal.ROUND_HALF_UP);
		binterest = binterest.multiply(new BigDecimal(String
				.valueOf(12 / Integer.parseInt(cb.getIncomeNumberYear()))));
		binterest = binterest.multiply(new BigDecimal(cb.getCalTotalByCont()));

		return binterest.toString();
	}


	/**
	 * 
	 * TODO (todo-list todo-list 次期时的一个全新的租金测算)
	 * 
	 * @param cb
	 * @param icb
	 * @param tcb
	 * @param frpb
	 * @return
	 * @throws Exception
	 */
	public FundRentPlanBean processPmtTranRate(ConditionBean cb,
			InterContBean icb, TabCalBean tcb, FundRentPlanBean frpb)
			throws Exception {

		// 得到调整的开始期项
		int startList = Integer.parseInt(icb.getStart_list());

		// 正常测算时的租金计划 //////////////////////////////////////////////////

		// 由于调息只对交易结构表的irr产生影响，故没有对交易结构的新增操作
		// 合同租金测算

		// 设置他的合同号
		frpb.setProjOrCont(cb.getProjId());
		frpb.setCreator(cb.getCreator());
		frpb.setYearRate(cb.getYearRate());
		frpb.setQuot_id(cb.getQuotId());
		frpb.setOnHire_id(cb.getOnhireId());
		ContrRentPlanServiceImpl crpsi = new ContrRentPlanServiceImpl();
		// 总的测算期数
		String incomeNumber = crpsi.getIncomeNumByAdjust(cb.getIncomeNumber(),
				String.valueOf(startList), cb.getGrace());
		cb.setIncomeNumber(incomeNumber);
		// 期初期末
		String peroidType = crpsi.getPeroidType(String.valueOf(startList), cb
				.getGrace(), cb.getPeriodType());
		cb.setPeriodType(peroidType);
		
		// 租金计划日期构建
		RentPlanDAOImpl rpdi = new RentPlanDAOImpl();
		String currDate = rpdi.getCurrentPlanDate(cb.getProjId(), String
				.valueOf(startList));
		String newStartDate = crpsi.getStartDate(peroidType,currDate, 12 / Integer.parseInt(cb.getIncomeNumberYear()));

		// 由于从当期到退上一期时间有一定误差，即如果currDate：5.31
		// 又是期末付，则newStartDate:4.30那么后续的一切时间都变为30日来付了，所以在此应重新构建计划日期
		cb.setStartDate(crpsi.getNewDateByDate(currDate, newStartDate));

		// 为了要引用正常 的租金测算所以先要重新计算他的宽限期
		cb.setGrace(crpsi.getGraceByAdjust(cb.getGrace(), String
				.valueOf(startList)));

		// pmt期末残值测算  只是期末残值用来计算
		//cb.setPmtEndValue(String.valueOf(Double.parseDouble(cb
				//.getEquip_end_value())));
		
		//2011-04-13修改
		//cb.setPmtEndValue("0");
		
		//2011-07-13修改
		cb.setPmtEndValue(cb.getEquipEndValue());
		

		// 正常租金测算
		//RentPlanContrCalServiceImpl rpcs = new RentPlanContrCalServiceImpl();
		//frpb = rpcs.rentPlanCalByConditionAndTab(cb, tcb, String
		//		.valueOf(startList), "2", frpb);
		//等比上调租金 2011-9-15 给为等比上调租金
		RentRatioServiceImpl rrsi=new RentRatioServiceImpl();
		frpb=rrsi.eventRatioTranRentPlan(cb, frpb, tcb, icb);		
		return frpb;
	}

}
