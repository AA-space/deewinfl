package com.tenwa.leasing.rentcalc.service.impl.evenrent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.AdjustBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.rentcalc.service.impl.RentPlanServiceImpl;
import com.tenwa.leasing.util.NumTools;
import com.tenwa.leasing.util.leasing.IrrTools;
import com.tenwa.leasing.util.leasing.RateTools;
import com.tenwa.leasing.util.leasing.RentTools;

/*******************************************************************************
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-4
 * @desc TODO (todo-list 合同租金测算运算点)
 */
public class RentPlanContrCalServiceImpl {
	static Logger	logger	= Logger.getLogger(RentPlanContrCalServiceImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 合同租金测算)
	 * 
	 * @param cb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	public FundRentPlanBean rentPlanCalByConditionAndTab(ConditionBean cb,
			TabCalBean tcb, String startList, String rentScale,
			FundRentPlanBean frpb) throws Exception {

	
		logger.info("合同租金计划生成....方法rentPlanCalByConditionAndTab");
		// 根据表信息进行对表数据的清除操作
		RentPlanContrCalDAOImpl rpcd = new RentPlanContrCalDAOImpl();
		rpcd.deleteRentPlan(tcb.getRentPlan_tb(),tcb, startList);

		// 得到正常pmt租金测算后的租金计划
		getPmtRentPlan(cb, frpb);
		//2011-12-6 为了配合均息法下的第二次测算需要租金计划bean中的利息列表所以在这里添加进入
		frpb.setYear_rate_list(new ArrayList<String>());
		for (int i = 0; i < frpb.getRent_list().size(); i++) {
			frpb.getYear_rate_list().add(cb.getYearRate());
		}
		// 调用保存的操作
		rpcd.addRentPlan(tcb.getRentPlan_tb(),frpb, tcb, startList, rentScale);
		logger.info("合同租金计划生成成功....方法rentPlanCalByConditionAndTab");
		// 返回租金计划实体 bean
		return frpb;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 正常pmt租金测算后的租金计划)
	 * 
	 * @param cb
	 * @param frpb
	 */
	private void getPmtRentPlan(ConditionBean cb, FundRentPlanBean frpb) {
		logger.info("正常 租金测算开始..(getPmtRentPlan)"+"t");

		// 租金类返回租金列表
		RentalServiceImpl rsi = new RentalServiceImpl();
		frpb.setRent_list(rsi.getRentListByCond(cb));

		// 日期类返回租金列表
		PlanDateServiceImpl pdsi = new PlanDateServiceImpl();
		frpb.setPlanDate_list(pdsi.getPlanDateList(cb, String.valueOf(frpb
				.getRent_list().size())));
		// 利息类返回租金列表
		InterestCalServiceImpl icsi = new InterestCalServiceImpl();
		frpb.setInterest_list(icsi.getInterestLsit(frpb.getRent_list(), cb
				.getCalTotalByCont(), cb.getYearRate(), cb.getPeriodType(),
				cb.getGrace(), cb.getIncomeNumberYear(),cb.getPmtEndValue()));

		// 本金类返回租金列表
		CorpusServiceImpl csi = new CorpusServiceImpl();
		frpb.setCorpus_list(csi.getCorpusList(frpb.getRent_list(), frpb
				.getInterest_list()));
		
		//2011-06-20修改 本金，利息格式化，并调整最后一期的本金值
		RentPlanServiceImpl rpsi = new RentPlanServiceImpl();
		rpsi.adjustLastRentPlan(frpb,cb.getCalTotalByCont(),cb.getPmtEndValue());
		
		// 本金余额类返回租金列表
		CorpusOvergeServiceImpl cosi = new CorpusOvergeServiceImpl();

		frpb.setCorpusOverage_list(cosi.getCorpusOvergeList(cb
				.getCalTotalByCont(), frpb.getCorpus_list()));
		//将租金计划进行去重处理
		try{
			uniqueFundRentPlan(frpb);
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("正常 租金测算结束..(getPmtRentPlan)");
	}
	
	private void uniqueFundRentPlan(FundRentPlanBean frpb) throws Exception{
		List<String>planDate_list = changeListToUnique(frpb,"getPlanDate_list");
		List<String>rent_list = changeListToUnique(frpb,"getRent_list");
		List<String>corpus_list = changeListToUnique(frpb,"getCorpus_list");
		List<String>corpusOverage_list = changeListToUnique(frpb,"getCorpusOverage_list");
		List<String>interest_list = changeListToUnique(frpb,"getInterest_list");
		List<String>rent_adjust_list = changeListToUnique(frpb,"getRent_adjust_list");
		frpb.setRent_list(rent_list);
		frpb.setPlanDate_list(planDate_list);
		frpb.setInterest_list(interest_list);
		frpb.setCorpus_list(corpus_list);
		frpb.setCorpusOverage_list(corpusOverage_list);
		frpb.setRent_adjust_list(rent_adjust_list);
	}
	private List<String> changeListToUnique(FundRentPlanBean frpb,String getMethod) throws Exception{
		List<String> list = frpb.getPlanDate_list();
		List<String> infoList =  (List)frpb.getClass().getMethod(getMethod).invoke(frpb);
		Map<String, String> uniqueMap = new HashMap<String, String>();
		for(int i = 0 ; i < list.size() ; i++){
			try{
				uniqueMap.put(list.get(i), infoList.get(i));
			}catch(Exception e){
				uniqueMap.put(list.get(i), "");
			}
		}
		List<String> returnList = new ArrayList<String>();
		for(String key : uniqueMap.keySet()){
			returnList.add(uniqueMap.get(key));
		}
		return returnList;
	}

	/**
	 * 
	 * TODO (todo-list todo-list 合同不规则租金测算)
	 * 
	 * @param cb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public FundRentPlanBean rentPlanCalByDevi(ConditionBean cb, TabCalBean tcb,
			String startList, String rentScale, FundRentPlanBean frpb,
			Object obj) throws Exception {
		

		// 根据表信息进行对表数据的清除操作
		RentPlanContrCalDAOImpl rpcd = new RentPlanContrCalDAOImpl();
		rpcd.deleteRentPlan(tcb.getRentPlan_tb(),tcb, startList);
		String leas_income=cb.getCalTotalByCont();
		// 租金类返回租金列表
		RentalServiceImpl rsi = new RentalServiceImpl();
		
		frpb.setRent_list(rsi.getDeviRentList(cb, obj,frpb.getYear_rate_list()));

		// 日期类返回日期列表
		PlanDateServiceImpl pdsi = new PlanDateServiceImpl();
		frpb.setPlanDate_list(pdsi.getPlanDateList(cb, String.valueOf(frpb
				.getRent_list().size())));

		// 利息类返回利息列表 因为在算租金的时候已经改变了测算总本金但是在算利息的时候其实要用最开始的总本金算
		InterestCalServiceImpl icsi = new InterestCalServiceImpl();
		frpb.setInterest_list(icsi.getInterestLsit(frpb.getRent_list(), leas_income,cb.getCalTotalByCont(), frpb.getYear_rate_list(), cb.getPeriodType(),
				cb.getGrace(), cb.getIncomeNumberYear(),cb.getPmtEndValue(),obj));

		// 本金类返回本金列表
		CorpusServiceImpl csi = new CorpusServiceImpl();
		frpb.setCorpus_list(csi.getCorpusList(frpb.getRent_list(), frpb
				.getInterest_list()));

		// 本金余额类返回本金余额列表
		CorpusOvergeServiceImpl cosi = new CorpusOvergeServiceImpl();

		frpb.setCorpusOverage_list(cosi.getCorpusOvergeList(cb
				.getCalTotalByCont(), frpb.getCorpus_list()));
		
		//2011-06-20修改 本金，利息格式化，并调整最后一期的本金值
		RentPlanServiceImpl rpsi = new RentPlanServiceImpl();
		rpsi.adjustLastRentPlan(frpb,leas_income,cb.getPmtEndValue());
		

		// 调用保存的操作
		rpcd.addRentPlan(tcb.getRentPlan_tb(),frpb, tcb, startList, rentScale);

		// 返回租金计划实体 bean
		return frpb;

	}
	
	/**
	 * scl
	 * TODO (租金计划变更的不规则租金调整)
	 * @param cb --
	 * @param tcb 表信息bean
	 * @param startList 开始调整期项
	 * @param rentScale 精确小数位数
	 * @param adb AdjustBean 调整bean
	 * @param obj 不规则租金计划调整值数组对象
	 * @return FundRentPlanBean 租金计划
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public FundRentPlanBean rentPlanCalByDevi(ConditionBean cb, TabCalBean tcb,
			String rentScale, AdjustBean adb,
			Object obj) throws Exception {
		
		//查询获取租金计划
		FundRentPlanBean frpb=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb, adb.getStartList().toString());
		//设置修改信息
		frpb.setModificator(adb.getCreator());
		frpb.setModify_date(new Date().toLocaleString());
		//将调整列设置到FundRentPlanBean中
		frpb.setRent_adjust_list(RentTools.getAdjustRentList(obj));
		// 根据表信息进行对表数据的清除操作
		RentPlanContrCalDAOImpl rpcd = new RentPlanContrCalDAOImpl();
		rpcd.deleteRentPlan(tcb.getRentPlan_tb(),tcb, adb.getStartList().toString());
		
		//总本金
		BigDecimal bd=new BigDecimal("0");
		for(int i=0;i<frpb.getCorpus_list().size();i++){
			bd=bd.add(new BigDecimal(frpb.getCorpus_list().get(i).toString()));
		}
		//处理每期年利率
		List year_rate_list=new ArrayList();
		for(int i=0;i<frpb.getYear_rate_list().size();i++){
			year_rate_list.add(
		 RateTools.getPreRate(frpb.getYear_rate_list().get(i).toString(), cb
				 .getIncomeNumberYear()));
		}
		cb.setCalTotalByCont(bd.toString());
		
		//2011-07-13修改
		//cb.setPmtEndValue("0");
		cb.setPmtEndValue(cb.getEquipEndValue());
		// 租金类返回租金列表
		RentalServiceImpl rsi = new RentalServiceImpl();
		frpb.setRent_list(rsi.getDeviRentList(cb,year_rate_list, obj));

		String periodType="0";//期初期末设置 1为期初 0为期末
		//只有当要调整的是第一期,且商务条件设置为期初时不规则租金调整的利息算法才需要把他设置为期初,否则都要规整为期末
		if((adb.getStartList().equals(1)||adb.getStartList()==1)&&cb.getPeriodType().equals("1")){
			periodType="1";
		}
		// 利息类返回租金列表
		InterestCalServiceImpl icsi = new InterestCalServiceImpl();
		frpb.setInterest_list(icsi.getInterestLsit(frpb.getRent_list(), year_rate_list, cb.getCalTotalByCont(),
				RentTools.getInterestAccuracy()+"", periodType));

		// 本金类返回租金列表
		CorpusServiceImpl csi = new CorpusServiceImpl();
		frpb.setCorpus_list(csi.getCorpusList(frpb.getRent_list(), frpb
				.getInterest_list()));

		// 本金余额类返回租金列表
		CorpusOvergeServiceImpl cosi = new CorpusOvergeServiceImpl();

		frpb.setCorpusOverage_list(cosi.getCorpusOvergeList(cb
				.getCalTotalByCont(), frpb.getCorpus_list()));
		
		//2011-06-20修改 本金，利息格式化，并调整最后一期的本金值
		RentPlanServiceImpl rpsi = new RentPlanServiceImpl();
		rpsi.adjustLastRentPlan(frpb,cb.getCalTotalByCont(),cb.getPmtEndValue());
		

		// 调用保存的操作
		rpcd.addRentPlan(tcb.getRentPlan_tb(),frpb, tcb, adb.getStartList().toString(), rentScale);

		// 返回租金计划实体 bean
		return frpb;

	}
	
	/**
	 * 
	 * TODO (todo-list todo-list 均息法下的租金测算,计算出租本息)
	 * @param cb 交易结构bean
	 * @param frpb  租金计划bean
	 */
	@SuppressWarnings("unchecked")
	public void rentPlanEvenInterestCal(ConditionBean cb, FundRentPlanBean frpb){
		//在这之前计算均息法下的本息.
		//获得利率
		String preRate = RateTools.getPreRate(cb.getYearRate(), cb
				.getIncomeNumberYear());		
		List<String> rent_list=new ArrayList<String>();
		List corpus=new ArrayList();
		List interest=new ArrayList();
		List grace_list = new ArrayList();
		//用等额租金法的宽限期方法计算出宽限期租金
		//grace_list = new RentalServiceImpl().getGraceRentList(cb, grace_list, preRate);
		//均息法下不管宽限期是多少,宽限期内的利息要和其他的期项保持一致,所以这里要除以还款次数加宽限期数
		//2012-9-22 均息法下计算每期利息 都需要用租赁总本金,而不是剩余本金
		//因为在传入的frpb 中就已经是所有的租金计划数据了  所以 直接从这个类中获取租赁总本金
		String leas_money_total="";
		if(frpb.getColumn_1()!=null){
			leas_money_total=NumTools.getSumCorpusOverage(frpb.getColumn_1(), 1);		
		}else{
			leas_money_total=cb.getCalTotalByCont();//因为不确定此处在租金测算时是否会有值,所以这里判断如果没有值就用交易结果中的本金替代
		}
		interest=new InterestCalServiceImpl().getInterestLsit(
				leas_money_total,cb.getLeaseTerm(), Integer.parseInt(cb.getIncomeNumber())+Integer.parseInt(cb.getGrace())+"",
				cb.getPmtEndValue(), cb.getYearRate(),grace_list);
		corpus=new CorpusServiceImpl().getCorpusList(
				cb.getCalTotalByCont(), cb.getIncomeNumber(),cb.getPmtEndValue(),cb.getGrace());
		
		//调整本息 并返回租金列表
		rent_list=new RentalServiceImpl().getRentListByCond(cb.getCalTotalByCont(), cb.getPmtEndValue(), corpus, interest);
		//根据元整后的租金重新元整本息
		
		frpb.setColumn_1(corpus);
		frpb.setColumn_2(interest);	
		frpb.setRent_list(rent_list);//此处设置这个值在后续会被覆盖掉 但是他的值其实是一样的
		//用均息法下的现金流算的一个irr,把其当做后续测算的年利率
		String irr=IrrTools.getIRRByEvenInterest(cb, frpb);
		cb.setYearRate(irr);
		//覆盖利率计划用于后续的测算 因为不规则计算需要利率集合
		List<String> year_rate=new ArrayList<String>();
		//此处不能用rent_list作为限制循环的条件 因为在算IRR的时候 引用传递的时候会改变rent_list大小.....切忌 耻辱啊....被这个给忽悠了.
		for (int i = 0; i < frpb.getCorpus_list().size(); i++) {
			year_rate.add(irr);
		}
		frpb.setYear_rate_list(year_rate);
		logger.info("均息法之后用于测算的IRR是:"+cb.getYearRate());
	}

	/**
	 * 
	 * TODO (todo-list todo-list 均息法下的 不规则 租金测算,计算出租本息)
	 * @param cb 交易结构bean
	 * @param frpb  租金计划bean
	 */
	@SuppressWarnings("unchecked")
	public void rentPlanEvenInterestCal(ConditionBean cb, FundRentPlanBean frpb,Object obj){
		//先按照正常的算出租金计划
		new RentPlanContrCalServiceImpl().rentPlanEvenInterestCal(cb, frpb);
		//得到租金调整集合
		List l_rent_adjust=RentTools.getAdjustRentList(obj);
		//2011-11-14 宽限期内租金调整时 调整值就是利息值
		for(int i=0;i<Integer.parseInt(cb.getGrace());i++){
			if(!l_rent_adjust.get(i).equals("")){
				frpb.getColumn_2().set(i, l_rent_adjust.get(i).toString());
			}
		}
		//得到现有租金列表
		//这里不能用bean中的租金列表,因为在rentPlanEvenInterestCal中算过现金流这个值已经被处理过
		List rent_list=new ArrayList();
		//得到现有本金列表
		List corpus_list=frpb.getColumn_1();
		//得到现有利息列表
		List interest_list=frpb.getColumn_2();
		String corpus_adjust_total="0";//被调整的总本金
		//根据调整租金计算本息.
		for(int i=0;i<corpus_list.size();i++){
			String rent_temp=l_rent_adjust.get(i).toString();
			if(!rent_temp.equals("")){
				String corpus_temp=NumTools.formatNumberDoubleScale(Double.parseDouble(rent_temp)
				-Double.parseDouble(interest_list.get(i).toString())+"",RentTools.getInterestAccuracy());
				corpus_list.set(i, corpus_temp);
				corpus_adjust_total=NumTools.formatNumberDoubleScale(Double.parseDouble(corpus_adjust_total)
						+Double.parseDouble(corpus_temp)+"",RentTools.getAccuracy());
			}
		}
		//用剩余本金做本金均摊
		String corpus_no_adjust="0";
		String income_number=Integer.parseInt(cb.getIncomeNumber())-RentTools.getAdjustIds(l_rent_adjust,cb.getGrace()).length+"";
		corpus_no_adjust=(new BigDecimal(cb.getCalTotalByCont()).subtract(
				new BigDecimal(cb.getPmtEndValue())).subtract(new BigDecimal(corpus_adjust_total)))
				.divide(new BigDecimal(income_number), RentTools.getAccuracy(), BigDecimal.ROUND_HALF_UP).toString();
		String [] adjus_index=RentTools.getNoAdjustIds(l_rent_adjust, cb.getGrace());
		//设置未调整的本金
		for(int i=0;i<adjus_index.length;i++){
			corpus_list.set(Integer.parseInt(adjus_index[i]), corpus_no_adjust);
		}
		//调整本息 并返回租金列表
		rent_list=new RentalServiceImpl().getRentListByCond(cb.getCalTotalByCont(), cb.getPmtEndValue(), corpus_list, interest_list);
		frpb.setColumn_1(corpus_list);
		frpb.setColumn_2(interest_list);
		frpb.setRent_list(rent_list);//此处设置这个值在后续会被覆盖掉 但是他的值其实是一样的
		//用均息法下的现金流算的一个irr,把其当做后续测算的年利率
		String irr=IrrTools.getIRRByEvenInterest(cb, frpb);
		cb.setYearRate(irr);
		//覆盖利率计划用于后续的测算 因为不规则计算需要利率集合
		List<String> year_rate=new ArrayList<String>();
		for (int i = 0; i < frpb.getCorpus_list().size(); i++) {
			year_rate.add(irr);
		}
		frpb.setYear_rate_list(year_rate);
		logger.info("均息法租金调整之后用于测算的IRR是:"+cb.getYearRate());
	}
}
