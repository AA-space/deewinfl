package com.tenwa.leasing.renttranrate.service.impl;

import java.util.Date;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.AdjustBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.InterContBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.service.impl.IrrDetailsServiceByTranImpl;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.rentcalc.service.impl.RentPlanServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.eveninterest.EvenInterestPlanContrCalServiceImpl;
import com.tenwa.leasing.renttranrate.dao.impl.RentPlanDAOImpl;
import com.tenwa.leasing.renttranrate.service.RentTranRateService;
import com.tenwa.leasing.util.leasing.AdjustTools;
import com.tenwa.leasing.util.leasing.RentTools;


/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list pmt次期处理)
 */
public class PmtNextListServiceImpl
		implements RentTranRateService {
	static Logger	logger	= Logger.getLogger(PmtNextListServiceImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 次期的调息处理)
	 * 
	 * @param cb
	 * @param icb
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public InterContBean processPmtTranRate(ConditionBean cb,
			InterContBean icb, TabCalBean tcb) throws Exception {
		FundRentPlanBean frpb = new FundRentPlanBean();
		//2012-7-30 不规则的租金测算方式 尝试使用等额租金的方式调息.
		if(cb.getSettleMethod().equals("even_rent")||cb.getSettleMethod().equals("irregular_rent")){//等额租金
			frpb=evenRentTranRate(cb, icb, tcb);
		}else if (cb.getSettleMethod().equals("even_interest")){
			frpb=evenInterestTranRate(cb, icb, tcb);
			//frpb=t(cb, icb, tcb);
		}else{
			logger.warn("未知的租金测算方式("+cb.getSettleMethod()+")!不会调息!");
		}
		RentPlanServiceImpl rpsi = new RentPlanServiceImpl();
		rpsi.adjustLastRentPlan(frpb,cb.getCalTotalByFinac(),cb.getPmtEndValue());
		
		//处理财务租金计划
		FinaRentPlanServiceImpl frpsi = new FinaRentPlanServiceImpl();
		frpsi.processFinacRentPlan(cb, icb, tcb, frpb);
		
		//调息时的现金流明细构建
		IrrDetailsServiceByTranImpl idsbti = new IrrDetailsServiceByTranImpl();
		icb = idsbti.processTranCashDetails(cb, icb, tcb);
		
		Hashtable re_ht = new Hashtable();
		re_ht.put("isSucess", "true");
		logger.info("pmt 次期调息结束.....");
		return icb;
	}
	
	/**
	 * 
	 * TODO 次期的等额租金调息方法
	 * @param cb
	 * @param icb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	public FundRentPlanBean evenRentTranRate(ConditionBean cb,
			InterContBean icb, TabCalBean tcb) throws Exception {
		logger.info("pmt 次期调息.....");

		// 判断是否是从宽限期来进行处理的，正常租金测算的pmt公式需要注意其期初或者期末
		// 重新测算从当前期至最后的租金计划，并更新合同租金计划,利用实体bean测算出相应的计算时的会计irr
		// 根据新的会计irr重新计算会计租金计划
		// 构建现金流明细，租金计划现金流构建时查询相应的表来得到 并更新

		// 开始调息期数
		int startList = Integer.parseInt(icb.getStart_list()) + 1;
		// 并设置开始期数
		icb.setStart_list(String.valueOf(startList));
		
		
		// 1.构建相应的测算交易结构bean
		// 得到此时总合同的测算本金
		RentPlanDAOImpl rpdi = new RentPlanDAOImpl();
		String sCorpus_contr = rpdi.getTotalCorpus(tcb.getRentPlan_tb(),cb.getProjId(), String
				.valueOf(startList), "corpus",tcb.getDocIdCoulValue(),cb.getEquipEndValue());
		cb.setCalTotalByCont(sCorpus_contr);
		// 得到此时总会计的测算本金
//		String sCorpus_finac = rpdi.getTotalCorpus(tcb.getRentFinaPlan_tb(),cb.getProjId(), String
//				.valueOf(startList), "corpus",tcb.getDocIdCoulValue(),cb.getEquipEndValue());
		String sCorpus_finac=sCorpus_contr;
		cb.setCalTotalByFinac(sCorpus_finac);
		FundRentPlanBean frpb = new FundRentPlanBean();
		
		//此时由于测算的总的本金跟期末残值无关，故在重新设置期末残值,现金流明细构建时是从交易结构表直接取期末残值，与名义货价
		//cb.setPmtEndValue("0");
		
		//2011-07-13修改
		cb.setPmtEndValue(cb.getEquipEndValue());

		//合同租金计划处理
		ContrRentPlanServiceImpl crpsi = new ContrRentPlanServiceImpl();
		frpb=crpsi.processPmtTranRate(cb, icb, tcb, frpb);
		return frpb;
	}
	
	/**
	 * 
	 * TODO 次期的均息法调息
	 * @param cb
	 * @param icb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	public FundRentPlanBean evenInterestTranRate(ConditionBean cb,
			InterContBean icb, TabCalBean tcb) throws Exception {
		FundRentPlanBean frpb=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb, "1");
		int startList = Integer.parseInt(icb.getStart_list()) + 1;
		// 实际上均息法下的调息就是 租金计划变更所以这里构建 变更信息调用变更方法
		AdjustBean adb=new AdjustBean();
		adb.setStartList(startList);
		adb.setYearRate(Double.parseDouble(icb.getRate_adjust().toString()));
		adb.setAdjustList(Integer.parseInt(cb.getIncomeNumber())+Integer.parseInt(cb.getGrace()));
		//根据变更表信息获取condition表信息
		cb=AdjustTools.getConditionBeanByAdjustBean(cb, adb, frpb);
		//设置frpb信息
		frpb.setModificator(icb.getCreator());
		frpb.setModify_date(new Date().toLocaleString());
		frpb.setYearRate(icb.getRate_adjust().toString());
		//将year_rate_list更新  只要移除保存时会自动更新
		frpb.setYear_rate_list(null);
		//调整时 要把租金调整列清空
		frpb.setRent_adjust_list(null);
		EvenInterestPlanContrCalServiceImpl eipccs=new EvenInterestPlanContrCalServiceImpl();
		eipccs.rentPlanCalByConditionAndTab(cb, tcb, startList+"", RentTools.getRentAccuracy()+"", frpb);
		frpb=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb, "1");//重新查询出数据用于后续的会计和现金流
		return frpb;
	}
	/*
	public FundRentPlanBean t(ConditionBean cb,InterContBean icb, TabCalBean tcb)throws Exception{
		FundRentPlanBean frpb=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb, "1");
		
		List colum1=frpb.getColumn_1();
		String rato=NumTools.calculationStr(icb.getRate_adjust(), cb.getYear_rate(), NumTools.DIVIDE, 20);
		int i = Integer.parseInt(icb.getStart_list()) -1;
		for(;i<colum1.size();i++){
			colum1.set(i, NumTools.calculationStr(colum1.get(i).toString(), rato, NumTools.MULTIPLY, RentTools.getRentAccuracy()));
		}
		frpb.setColumn_1(colum1);
		AdjustBean adb=new AdjustBean();
		adb.setStartList(Integer.parseInt(icb.getStart_list())+1);
		adb.setYearRate(Double.parseDouble(icb.getRate_adjust().toString()));
		adb.setAdjustList(Integer.parseInt(cb.getIncome_number())+Integer.parseInt(cb.getGrace()));
		//根据变更表信息获取condition表信息
		cb=AdjustTools.getConditionBeanByAdjustBean(cb, adb, frpb);
		
		//用均息法下的现金流算的一个irr,把其当做后续测算的年利率
		String irr=IrrTools.getIRRByEvenInterest(cb, frpb);
		cb.setYear_rate(irr);		
		frpb=new RentPlanContrCalServiceImpl().rentPlanCalByConditionAndTab(cb, tcb,Integer.parseInt(icb.getStart_list())+1+"",  RentTools.getRentAccuracy()+"", frpb);
		return frpb;
	}*/
}
