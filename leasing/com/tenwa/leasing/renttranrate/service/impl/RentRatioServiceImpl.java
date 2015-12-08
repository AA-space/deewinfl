package com.tenwa.leasing.renttranrate.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.InterContBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.rentcalc.service.impl.RentPlanServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.CorpusOvergeServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.CorpusServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.InterestCalServiceImpl;
import com.tenwa.leasing.util.NumTools;
import com.tenwa.leasing.util.leasing.RentTools;

/**
 * 
 * @author      SCLICX
 * @version     1.0
 * @copyright   (C) Tenwa 2011
 * @date        Sep 14, 2011
 * @desc        TODO 等比法调息
 */
public class RentRatioServiceImpl {
	
	static Logger	logger	= Logger.getLogger(RentRatioServiceImpl.class);
	
	/**
	 * 
	 * TODO 等比进行调息, 通过循环等比调整租金 然后获得现金流对应的年利率和调息后的比较 如果相等则调息结束
	 * @param cb 
	 * @param frpb
	 * @param tcb
	 * @param icb
	 * @return
	 * @throws Exception
	 */
	public FundRentPlanBean eventRatioTranRentPlan(ConditionBean cb,FundRentPlanBean frpb
			,TabCalBean tcb,InterContBean icb)throws Exception {
		RentPlanContrCalDAOImpl rpcdi=new RentPlanContrCalDAOImpl();
		//获得租金计划
		FundRentPlanBean frpb_temp=rpcdi.getRentAndDateByTcb(tcb, "1");
		// 设置他的合同号
		frpb_temp.setProjOrCont(cb.getProjId());
		frpb_temp.setCreator(cb.getCreator());
		frpb_temp.setYearRate(cb.getYearRate());
		frpb_temp.setQuot_id(cb.getQuotId());
		frpb_temp.setOnHire_id(cb.getOnhireId());
		//构建现金流
		ArrayList<HashMap<String, String>> alCash = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> temp;
		List rent_list=frpb_temp.getRent_list();//租金列表
		List corpus_list=frpb_temp.getCorpus_list();//本金列表
		List interest_list=frpb_temp.getInterest_list();//利息列表
		List column_1=frpb_temp.getColumn_1();//均息法下的利息列表
		List column_2=frpb_temp.getColumn_2();//均息法下的利息列表
		List year_rate_list=frpb_temp.getYear_rate_list();
		//为了避免在非均息法下没有给column_1 和column_2 赋值 在这里初始化
		if(column_1==null||column_1.size()==0||column_1.get(0).toString().equals("")){
			column_1=frpb_temp.getCorpus_list();
			column_2=frpb_temp.getInterest_list();
		}
		Double corpus_total=0.0;
		String corpuTotal=NumTools.getSumCorpusOverage(corpus_list, 1);
		for(int i=Integer.parseInt(icb.getStart_list())-1;i<rent_list.size();i++){
			temp=new HashMap<String, String>();
			temp.put("net_flow", rent_list.get(i).toString());
			alCash.add(i+1-Integer.parseInt(icb.getStart_list()), temp);
			corpus_total=corpus_total+Double.parseDouble(corpus_list.get(i).toString());
		}
		//设置第一笔负金额
		temp=new HashMap<String, String>();
		temp.put("net_flow", "-"+corpus_total);
		alCash.add(0, temp);
		
		String iavg="1";//等比上调的比例
		RateCalTranServiceImpl rcts=new RateCalTranServiceImpl();
		//2012-5-7 调息的时候也要传入365/360处理过的利率
		iavg=rcts.getAdjustRatioByCash(alCash, cb.getYearRate(), cb.getIncomeNumberYear());
		List rent_list_temp=new ArrayList();
		List interest_list_temp=new ArrayList();
		List corpus_list_temp=new ArrayList();
		if(iavg!=null&&!iavg.equals("")){
			//获得上调的等比比例之后开始等比上调租金 让后用租金减去本金就得每期利息
			//从开始调整期项开始上调
			for(int i=Integer.parseInt(icb.getStart_list())-1;i<rent_list.size();i++){
				String temp_rent=new BigDecimal(rent_list.get(i).toString()).multiply(
						new BigDecimal(iavg)).setScale(RentTools.getRentAccuracy(), BigDecimal.ROUND_HALF_UP).toString();
				rent_list.set(i,temp_rent);
				rent_list_temp.add(temp_rent);
				/*
				String interest_temp=new BigDecimal(temp_rent).subtract(
						new BigDecimal(corpus_list.get(i).toString())).setScale(
								RentTools.getRentAccuracy(), BigDecimal.ROUND_HALF_UP).toString();
				interest_list.set(i, interest_temp);
				interest_temp=new BigDecimal(temp_rent).subtract(
						new BigDecimal(column_1.get(i).toString())).setScale(
								RentTools.getRentAccuracy(), BigDecimal.ROUND_HALF_UP).toString();
				column_2.set(i, interest_temp);	*/
				year_rate_list.set(i, icb.getRate_adjust());
			}
			//重新计算 利息
			interest_list_temp=new InterestCalServiceImpl().getInterestLsit(rent_list_temp, cb.getCalTotalByCont(), icb.getRate_adjust(), "0", "0", cb.getIncomeNumberYear(), cb.getPmtEndValue());
			
			for(int i=Integer.parseInt(icb.getStart_list())-1;i<rent_list.size();i++){
				interest_list.set(i, interest_list_temp.get(i+1-Integer.parseInt(icb.getStart_list())));
			}
			corpus_list_temp=new CorpusServiceImpl().getCorpusList(rent_list, interest_list);
			//调整完成之后赋值 
			//因为只改过租金 和利息
			frpb_temp.setRent_list(rent_list);
			frpb_temp.setInterest_list(interest_list);
			frpb_temp.setCorpus_list(corpus_list_temp);
			frpb_temp.setColumn_1(corpus_list_temp);
			frpb_temp.setColumn_2(interest_list);
			frpb_temp.setYear_rate_list(year_rate_list);
			frpb=frpb_temp;
			//2011-06-20修改 本金，利息格式化，并调整最后一期的本金值
			RentPlanServiceImpl rpsi = new RentPlanServiceImpl();
			rpsi.adjustLastRentPlan(frpb,corpuTotal,cb.getPmtEndValue());			
			//2011-06-20 格式化 本金余额类
			CorpusOvergeServiceImpl cosi = new CorpusOvergeServiceImpl();
			frpb.setCorpusOverage_list(cosi.getCorpusOvergeList(corpuTotal, frpb.getCorpus_list()));
			
			//先删除
			rpcdi.deleteRentPlan(tcb.getRentPlan_tb(), tcb, "1");
			//保存租金计划
			rpcdi.addRentPlan(tcb.getRentPlan_tb(), frpb, tcb, "1", RentTools.getAccuracy()+"");
		}else{
			logger.error("调息时获取合同"+tcb.getContOrProjCValue()+"的等比上调比例失败!");
			return frpb_temp;
		}
		return frpb;
	}
}
