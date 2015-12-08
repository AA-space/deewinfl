package com.tenwa.leasing.renttranrate.service.impl;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.InterContBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.service.impl.IrrDetailsServiceByTranImpl;
import com.tenwa.leasing.renttranrate.dao.impl.RentPlanDAOImpl;
import com.tenwa.leasing.renttranrate.service.RentTranRateService;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list pmt次日调息处理)
 */
public class PmtNextDayServiceImpl
		implements RentTranRateService {
	static Logger	logger	= Logger.getLogger(PmtNextListServiceImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 次日调息理类)
	 * 
	 * @param cb
	 * @param icb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public InterContBean processPmtTranRate(ConditionBean cb,
			InterContBean icb, TabCalBean tcb) throws Exception {
		logger.info("pmt 次日调息.....");

		// a. 对第一期特别处理
		// a处理完后，重新conditionBean的新的测算本金(从当前期开始得到他的本金剩余而不是从当期开召始查询出来的本金和)之类的
		// 重新InterContBean的开始日期
		// 后面的调息内容类似于次期的调息

		// 开始调息期数
		int startList = Integer.parseInt(icb.getStart_list());
		// 并设置开始期数
		icb.setStart_list(String.valueOf(startList));

		// 1.构建相应的测算交易结构bean
		// 得到此时总合同的测算本金
		RentPlanDAOImpl rpdi = new RentPlanDAOImpl();
		String sCorpus_contr = rpdi.getTotalCorpus(tcb.getRentPlan_tb(),cb.getProjId(), String
				.valueOf(startList), "corpus",tcb.getDocIdCoulValue(),cb.getEquipEndValue());
		cb.setCalTotalByCont(sCorpus_contr);
//		// 得到此时总会计的测算本金
//		String sCorpus_finac = rpdi.getTotalCorpus(tcb.getRentFinaPlan_tb(),cb.getProjId(), String
//				.valueOf(startList), "corpus" ,tcb.getDocIdCoulValue(),cb.getEquipEndValue());
//		cb.setCalTotalByFinac(sCorpus_finac);
		//德银没有会计
		String sCorpus_finac=sCorpus_contr;
		cb.setCalTotalByFinac(sCorpus_finac);

		// 合同租金计划调息处理
		ContrRentPlanServiceImpl crpsi = new ContrRentPlanServiceImpl();
		// ///处理第一期的租金计划
		icb = crpsi.calFirstRentPlan(cb, icb, tcb);

		// 由于财务的租金计划第一期不发生变化，故财务的测算总值无须变化,因为此时操作的是临时表
//		String corpusOverage = rpdi.getCurrentCorpusOverage(cb.getProjId(),
//				String.valueOf(startList), " contract_fund_rent_plan ", "");
//		cb.setCalTotalByCont(corpusOverage);

		// 重新计算测算本金，调息开始期项等
		icb.setStart_list(String
				.valueOf(Integer.parseInt(icb.getStart_list()) + 1));

		// 此时由于测算的总的本金跟期末残值无关，故在重新设置期末残值
		//cb.setPmtEndValue("0");
		
		//2011-07-13修改
		cb.setPmtEndValue(cb.getEquipEndValue());

		FundRentPlanBean frpb = new FundRentPlanBean();
		
		if (!(Integer.parseInt(icb.getStart_list()) + 1 >= Integer.parseInt(cb
				.getIncomeNumber()))) {
			// 合同租金计划处理
			crpsi.processPmtTranRate(cb, icb, tcb, frpb);

			//德银没有会计
			// 得到此时总会计的测算本金,因为财务变化的生金是发生在一期所以他的测算本金得重新构建
//			sCorpus_finac = rpdi.getTotalCorpus(tcb.getRentFinaPlan_tb(), cb
//					.getProjId(), icb.getStart_list(), "corpus", tcb
//					.getDocIdCoulValue(), cb.getEquipEndValue());
//			cb.setCalTotalByFinac(sCorpus_finac);
//
//			// 处理财务租金计划
//			FinaRentPlanServiceImpl frpsi = new FinaRentPlanServiceImpl();
//			frpsi.processFinacRentPlan(cb, icb, tcb, frpb);
		}
		// 调息时的现金流明细构建
		IrrDetailsServiceByTranImpl idsbti = new IrrDetailsServiceByTranImpl();
		icb = idsbti.processTranCashDetails(cb, icb, tcb);

		// 重新设置他的开始日期
		icb.setStart_list(String.valueOf(startList));
		Hashtable re_ht = new Hashtable();
		re_ht.put("isSucess", "true");
		logger.info("pmt 次日调息结束.....");
		return icb;
	}
}
