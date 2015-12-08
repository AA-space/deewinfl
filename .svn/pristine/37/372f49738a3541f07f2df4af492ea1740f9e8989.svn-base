package com.tenwa.leasing.rentcalc.service.impl.evenrent;

import java.util.Hashtable;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.rentcalc.service.RentCalcService;


public class EvenCorpusCaleServiceImpl implements RentCalcService{

	@Override
	public Hashtable rentCal(ConditionBean cb, String calType, String userName, Object obj, String star_list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hashtable rentCalOnHire(ConditionBean cb, String calType, String userName, Object obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
//
//	static Logger	logger	= Logger.getLogger(EvenRentCalcServiceImpl.class);
//
//	@SuppressWarnings("unchecked")
//	public Hashtable rentCal(ConditionBean cb, String calType, String userName,
//			Object obj,String star_list) throws Exception {
//		logger.info("进入方法:rentCal 进行等额本金的测算..");
//		// 得到操作表信息
//		TabCalBean tcb = TbBeanTools.getTabInfo(calType, cb);
//		ConditionServiceImpl csi = new ConditionServiceImpl();
//		// 对交易结构信息处理
//		csi.addConditionByCal(tcb, cb);//更新商务条件，删除数据并新建一条记录0000000000000000000
//		FundRentPlanBean frpb = new FundRentPlanBean();
//		// 设置他的合同号
//		frpb.setProjOrCont(cb.getProjId());
//		frpb.setCreator(cb.getCreator());
//		//2012-1-11 太原特殊算法 特殊处理年利率 所以保存的时候要调用另一个方法获得原始的年利率值
//		frpb.setYearRate(cb.getYearRate());
//		frpb.setQuot_id(cb.getQuotId());
//		frpb.setRent_adjust_list(new ArrayList());// 租金调整值
//
//		// 1,表从第一期开始;2,表租金格式化为几位小数,合同租金计划测算
//		frpb = rentPlanCalByConditionAndTab(cb, tcb, star_list, RentTools.getRentAccuracy()+"", frpb);
//
//
//		// 现金流处理,返回一个财务现金流,并将财务irr赋值到交易结构plan_iir上
//		// 1,默认按期来计算现金流irr,其它的如按月，按天，在此改参数
//		// 2011-06-14修改为安月计算
//		//2011-11-11 改为按期
//		cb = calCashIrrFinacAndCont(cb, tcb, frpb, "1");
//
//		//
//		// 财务租金计划处理
//		RentPlanFinacCalServiceImpl rpfcs = new RentPlanFinacCalServiceImpl();
//		// 1,表从第一期开始;2,表租金格式化为几位小数
//		rpfcs.rentPlanCalByConditionAndTab(cb, tcb, star_list, "2", frpb);//添加财务租金计划
//
//		Hashtable re_ht = new Hashtable();
//		re_ht.put("isSucess", "true");
//
//		logger.info("结束等额租金测算方法:rentCal ..");
//		return re_ht;
//
//	}
//
//	
//	/**
//	 * 
//	 * TODO (todo-list todo-list 合同，会计现金流处理)
//	 * 
//	 * @param cb
//	 * @param tb
//	 * @param frpb
//	 * @param calType
//	 *            1 是按期类型 2按月
//	 * @return
//	 * @throws Exception
//	 */
//	public ConditionBean calCashIrrFinacAndCont(ConditionBean cb,
//			TabCalBean tcb, FundRentPlanBean frpb, String calType)
//			throws Exception {
//		//2011-11-11 现金流的处理隔月不补零
//		calType="1";
//		// 处理合同现金流明细
//		calContrCashDetails(cb, tcb, frpb,calType);//删除现金流并创建新的现金流
//		// 会计现金流明细
//		calFinaCashDetails(cb, tcb, frpb,calType);
//		//2012-4-13 修改多次起租的时候会计现金流重算
//		if(tcb.getCalType().equals("onHire_more_process")){
//			TabCalBean tcb_cont = new TabCalBean();
//			tcb_cont = TbBeanTools.getTabInfo("cont_process");
//			tcb_cont.setOnHire_id(tcb.getOnHire_id());
//			tcb_cont.setContOrProjCValue(tcb.getContOrProjCValue());
//			tcb_cont.setDocIdCoulValue(tcb.getDocIdCoulValue());
//			tcb_cont.setId_1(tcb.getId_1());
//			tcb_cont.setId_2(tcb.getId_2());
//			tcb_cont.setIs_merger(tcb.getIs_merger());// 传递是否合并计算
//			tcb_cont.setUserId(tcb.getUserId());
//			
//			ConditionBean cdb_t=new ConditionBean();
//			FundRentPlanBean frpb_t=new FundRentPlanBean();
//			String wheresql=tcb_cont.getCondition_tb()+" where " + tcb_cont.getContOrProjCName() + "='"	+ tcb_cont.getContOrProjCValue() 
//				+ "' and "+tcb_cont.getDocIdCoulName()+"='"+tcb_cont.getDocIdCoulValue()+"'";
//			cdb_t=new ConditionDAOImpl().getConditionBeanByContract(wheresql,tcb_cont);
//			cdb_t=DictTools.getReversDict(cdb_t);
//			frpb_t=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb_cont, "1");
//			// 处理合同现金流明细
//			calContrCashDetails(cdb_t, tcb_cont, frpb_t,calType);
//			// 会计现金流明细
//			calFinaCashDetails(cdb_t, tcb_cont, frpb_t,calType);
//		}
//		return cb;
//	}
//	
//	
//	/**
//	 * 
//	 * TODO (todo-list todo-list 处理会计现金流明细)
//	 * 
//	 * @param cb
//	 * @param tcb
//	 * @param frpb
//	 * @throws Exception
//	 */
//	private void calFinaCashDetails(ConditionBean cb, TabCalBean tcb,
//			FundRentPlanBean frpb, String calType) throws Exception {
//
//		// 处理会计配置的现金流
//		IrrDetailsService ids = new IrrDetailsServiceImpl();
//		List<CashDetailsBean> cdbList = ids.getCashDetailByCfg(tcb, "会计");
//		// 租金计划现金流明细的构建
//		cdbList = ids.getCashDetailByRentPlan(frpb, cdbList,1);
//
//		// 以上操作完后，根据日期进行，重组现金流明细
//		IrrCalServiceImpl icsi = new IrrCalServiceImpl();
//		cdbList = icsi.getNewCashDetailsByCalType(calType, cdbList);// 按期得到新的现金流明细,如按其他现金流测算的，可以在此修改，并重写方法
//
//		// 最后一期留购价，期末列值更新 2012-5-7 改两项不参与计算
//		//cdbList = IrrTools.getCashDetailsByEndValue(cdbList, cb
//		//		.getEquip_end_value(), cb.getNominal_price());
//		// 先删现金流明细,再添加现金流明细
//		IrrDetailsDAO idd = new IrrDetailsDAOImpl();
//		idd.deleteCashDetails(tcb, tcb.getFinacCashTb());// 会计现金流明细表
//		idd.addCashDetails(tcb, cdbList, tcb.getFinacCashTb());
//		// 测算新的会计 plan_irr
//		//2011-11-11 因为现金流是按期构造所以IRR不能用月计算
//		//String finacIrr = IrrTools.getIrrByPreMonth(cdbList, cb);
//		String finacIrr=IrrTools.getIrr(cdbList, cb);
//		// 更新交易结构表irr
//		ConditionDAO cd = new ConditionDAOImpl();
//		cd.updateConditionFinaIrr(tcb, finacIrr);
//
//		// ConditionBean cb 设置 plan_irr属性
//		cb.setPlanIrr(new BigDecimal(finacIrr).multiply(new BigDecimal("100")).toString());
//
//	}
//	
//	/**
//	 * 
//	 * TODO (todo-list todo-list 处理合同现金流明细)
//	 * 
//	 * @param cb
//	 * @param tcb
//	 * @param frpb
//	 * @throws Exception
//	 */
//	private void calContrCashDetails(ConditionBean cb, TabCalBean tcb,
//			FundRentPlanBean frpb, String calType) throws Exception {		
//		// 处理合同配置的现金流
//		IrrDetailsService ids = new IrrDetailsServiceImpl();
//		
//		List<CashDetailsBean> cdbList = ids.getCashDetailByCfg(tcb, "合同");
//		// 租金计划现金流明细的构建
//		cdbList = ids.getCashDetailByRentPlan(frpb, cdbList,1);
//
//		// 以上操作完后，根据日期进行，重组现金流明细
//		IrrCalServiceImpl icsi = new IrrCalServiceImpl();
//		cdbList = icsi.getNewCashDetailsByCalType(calType, cdbList);// 按期得到新的现金流明细,如按其他现金流测算的，可以在此修改，并重写方法
//		
//		// 合同的保证金抵扣现金流明细构建
//		cdbList = IrrTools.getRentDetailsByDeduct(cdbList, cb.getCautionDeductionMoney());
//		
//		// 合同的预收租金抵扣现金流明细构建
//		cdbList = IrrTools.getRentDetailsByDeductBeforeRent(cdbList,cb.getExpectRentDeduction());
//		
//		// 最后一期留购价，期末列值更新
//		cdbList = IrrTools.getCashDetailsByEndValue(cdbList, cb
//				.getEquipEndValue(), cb.getNominalPrice());
//		
//		//2011-10-26
//		//处理特殊的保证金抵扣 保证金抵扣金额小于保证金金额 最后要做一笔流出 为保证金金额减去保证金抵扣金额
//		cdbList=IrrTools.getRentDetailsByDeductOut(cdbList, cb.getCautionMoney(), cb.getCautionDeductionMoney()); 
//		
//		//处理特殊的预收租金抵扣 预收租金抵扣金额小于预收租金金额 最后要做一笔流出 为预收租金金额减去预收租金抵扣金额
//		cdbList=IrrTools.getRentDetailsByDeductBeforeRentOut(cdbList, cb.getExpectRent(), cb.getExpectRentDeduction());
//		
//		// 先删现金流明细,再添加现金流明细
//		IrrDetailsDAO idd = new IrrDetailsDAOImpl();
//		idd.deleteCashDetails(tcb, tcb.getContractCashTb());// 合同现金流明细表
//		idd.addCashDetails(tcb, cdbList, tcb.getContractCashTb());
//		
//		// 测算新的合同 irr
//		//2011-11-11 因为现金流是按期构造所以IRR不能用月计算
//		//String irr = IrrTools.getIrrByPreMonth(cdbList, cb);
//		
//		for(CashDetailsBean cdb : cdbList){
//			System.out.println(cdb.getPlan_date() + "=========现金流==========：" + cdb.getNet_flow());
//		}
//		
//		String irr=IrrTools.getIrr(cdbList, cb);
//		System.out.println("更新交易结构表irr:" + irr);
//		
//		// 更新交易结构表irr
//		ConditionDAO cd = new ConditionDAOImpl();
//		cd.updateConditionContIrr(tcb, irr);
//
//		// ConditionBean cb 设置 irr属性
//		cb.setIrr(new BigDecimal(irr).multiply(new BigDecimal("100")).toString());
//	}
//
//	/**
//	 * 
//	 * TODO (todo-list todo-list 起租时实现方法)
//	 * 
//	 * @param cb
//	 * @param calType
//	 * @param userName
//	 * @param obj
//	 * @return
//	 * @throws Exception
//	 */
//	public Hashtable rentCalOnHire(ConditionBean cb, String calType,
//			String userName, Object obj) throws Exception {
//
//		logger.info("进入方法:rentCalOnHire 进行起租时的租金的测算..");
//		//起租时只重新保存交易结构信息，更改租金计划支付日期，更改现金流明细
//		
//		// 得到操作表信息
//		TabCalBean tcb = TbBeanTools.getTabInfo(calType, cb);
//		ConditionServiceImpl csi = new ConditionServiceImpl();
//		// 对交易结构信息处理
//		csi.addConditionByCal(tcb, cb);
//		// 合同租金测算
//		//RentPlanContrCalServiceImpl rpcs = new RentPlanContrCalServiceImpl();
//
//		//查询他的租金计划
//		RentPlanContrCalDAOImpl rpccdi = new RentPlanContrCalDAOImpl();
//		FundRentPlanBean frpb = rpccdi.getRentAndDateByTcb(tcb, "1");
//		//FundRentPlanBean frpb = new FundRentPlanBean();
//		// 设置他的合同号
//		frpb.setProjOrCont(cb.getProjId());
//		frpb.setCreator(cb.getCreator());
//		//2012-1-11 太原特殊算法 特殊处理年利率 所以保存的时候要调用另一个方法获得原始的年利率值
//		frpb.setYearRate(cb.getYearRate());
//		frpb.setQuot_id(cb.getQuotId());
//		frpb.setRent_adjust_list(new ArrayList());// 租金调整值
//		
//		//根据交易结构重新算出的租金计划日期
//		// 日期类返回租金列表
//		PlanDateServiceImpl pdsi = new PlanDateServiceImpl();
//		frpb.setPlanDate_list(pdsi.getPlanDateList(cb, String.valueOf(frpb
//				.getRent_list().size())));
//		//更新租金计划 的时间
//		rpccdi.updateRentPlanDate(tcb.getRentPlan_tb(),tcb, "1", frpb.getPlanDate_list());
//		//更新会计的租金计划时间
//		rpccdi.updateRentPlanDate(tcb.getRentFinaPlan_tb(), tcb, "1", frpb.getPlanDate_list());
//		
//		// 现金流处理,返回一个财务现金流,并将财务irr赋值到交易结构plan_iir上
//		IrrService is = new IrrServiceImpl();
//		// 1,默认按期来计算现金流irr,其它的如按月，按天，在此改参数
//		// 2011-06-14修改为安月计算
//		//2011-11-11 改为按期
//		cb = calCashIrrFinacAndCont(cb, tcb, frpb, "1");
//		
//		
//		Hashtable re_ht = new Hashtable();
//		re_ht.put("isSucess", "true");
//
//		logger.info("结束等额租金起租时测算方法:rentCalOnHire ..");
//		return re_ht;
//	}
//	
//	
//	/**
//	 * 
//	 * TODO (todo-list todo-list 合同租金测算)
//	 * 
//	 * @param cb
//	 * @param tcb
//	 * @return
//	 * @throws Exception
//	 */
//	public FundRentPlanBean rentPlanCalByConditionAndTab(ConditionBean cb, TabCalBean tcb, String startList, String rentScale, FundRentPlanBean frpb) throws Exception {
//
//		logger.info("合同租金计划生成....方法rentPlanCalByConditionAndTab");
//		// 根据表信息进行对表数据的清除操作
//		RentPlanContrCalDAOImpl rpcd = new RentPlanContrCalDAOImpl();
//		rpcd.deleteRentPlan(tcb.getRentPlan_tb(), tcb, startList);//删除租金计划
//
//		// 得到正常pmt租金测算后的租金计划
//		getPmtRentPlan(cb, frpb);
//		
//		// 调用保存的操作
//		rpcd.addRentPlan(tcb.getRentPlan_tb(), frpb, tcb, startList, rentScale);//保存新的租金计划
//		logger.info("合同租金计划生成成功....方法rentPlanCalByConditionAndTab");
//		// 返回租金计划实体 bean
//		return frpb;
//	}
//	
//	
//	/**
//	 * 
//	 * TODO (todo-list todo-list 正常pmt租金测算后的租金计划)
//	 * 
//	 * @param cb
//	 * @param frpb
//	 */
//	private void getPmtRentPlan(ConditionBean cb, FundRentPlanBean frpb) {
//		logger.info("正常 租金测算开始..(getPmtRentPlan)" + "t");
//		
//		try {
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			CalculationCondition condition = new CalculationConditionImpl();
//			condition.copyConditionBeanValues(cb);
//			List<RentPlanInfo> rentPlanList = RentCalculateUtil.calculateForSameCorpus(condition);
//			
//			BigDecimal corpusOverage = condition.getLeaseAmt();
//			BigDecimal corpusOverage2 = condition.getLeaseAmt();
//			
//			List<String> reateList = new ArrayList<String>();//利息列表
//			List<String> rentList = new ArrayList<String>();//租金列表
//			List<String> planDateList = new ArrayList<String>();//日期列表
//			List<String> interestList = new ArrayList<String>();//业务利息列表
//			List<String> corpusList = new ArrayList<String>();//业务本金列表
//			List<String> corpusOverageList = new ArrayList<String>();//业务本金剩余列表
//			
//			List<String> interestFinacList = new ArrayList<String>();//财务利息列表
//			List<String> corpusFinacList = new ArrayList<String>();//财务本金列表
//			List<String> corpusFinacReminList = new ArrayList<String>();//财务本金剩余列表
//			
//			for(RentPlanInfo rpi : rentPlanList){
//				planDateList.add(dateFormat.format(rpi.getDate()));//租金日起列表
//				rentList.add(rpi.getRent().toString());//租金列表
//				
//				interestList.add(rpi.getBussinessInterest().toString());//业务利息列表
//				corpusList.add(rpi.getBussinessCorpus().toString());//业务本金列表
//				
//				interestFinacList.add(rpi.getFinanceInterest().toString());//财务利息列表
//				corpusFinacList.add(rpi.getFinanceCorpus().toString());//财务本金列表
//				
//				corpusOverageList.add(corpusOverage.toString());//业务本金剩余
//				corpusFinacReminList.add(corpusOverage2.toString());//财务剩余本金列表
//				
//				reateList.add(cb.getYearRate());//年利率列表
//				
//				corpusOverage = corpusOverage.subtract(rpi.getBussinessCorpus());//业务本金剩余值
//				corpusOverage2 = corpusOverage2.subtract(rpi.getFinanceCorpus());//财务本金剩余
//				
//				System.out.println(rpi.getId() + "\t" + dateFormat.format(rpi.getDate()) + "\t" + rpi.getFinanceCorpus() + "\t" + rpi.getFinanceInterest() + "\t" + rpi.getBussinessCorpus() + "\t" + rpi.getBussinessInterest());
//			}
//			frpb.setPlanDate_list(planDateList);
//			frpb.setRent_list(rentList);
//			frpb.setColumn_1(corpusList);
//			frpb.setColumn_2(interestList);
//			frpb.setInterest_finac_list(interestFinacList);
//			frpb.setCorpus_finac_list(corpusFinacList);
//			frpb.setCorpusOverage_list(corpusOverageList);
//			frpb.setCorpusOverage_finac_list(corpusFinacReminList);
//			frpb.setYear_rate_list(reateList);
//			
//			frpb.setCorpus_list(corpusFinacList);
//			frpb.setInterest_list(interestFinacList);
//			
//			
//			logger.info("正常 租金测算结束..(getPmtRentPlan)");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
}
