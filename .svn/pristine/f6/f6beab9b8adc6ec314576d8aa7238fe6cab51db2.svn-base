package com.tenwa.leasing.rentcalc.service.impl.eveninterest;



import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.AdjustBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.RentPlanContrCalServiceImpl;

/**
 * 
 * @author      SCLICX
 * @version     1.0
 * @copyright   (C) Tenwa 2011
 * @date        Nov 29, 2011
 * @desc        均息法的租金计划变更实现类
 */
public class EvenInterestPlanContrCalServiceImpl
		extends RentPlanContrCalServiceImpl {
	static Logger	logger	= Logger.getLogger(EvenInterestPlanContrCalServiceImpl.class);
	@Override
	public FundRentPlanBean rentPlanCalByConditionAndTab(ConditionBean cb,
			TabCalBean tcb, String startList, String rentScale,
			FundRentPlanBean frpb) throws Exception {
		//因为均息法的时候会改变cb中的year_rate所以要把该值保存下来
		String year_rate=cb.getYearRate();
		//调用均息法下的租金测算算出业务的租金计划
		new RentPlanContrCalServiceImpl().rentPlanEvenInterestCal(cb, frpb);
		//按照正常的等额租金进行均息法下的第二次租金测算.
		//2012-09-22做第二次测算时的是要把财务本金赋值给测算本金
		if(!cb.getReckonType().equals("reckon")){
			cb.setCalTotalByCont(cb.getCalTotalByFinac());
		}
		frpb=super.rentPlanCalByConditionAndTab(cb, tcb, startList, rentScale, frpb);
		//如果有宽限期,就要做宽限期下的租金调整
		int grace=Integer.parseInt(cb.getGrace());
		int income_number=Integer.parseInt(cb.getIncomeNumber());
		//第二次测算则把利率改回去
		cb.setYearRate(year_rate);
		if(grace>0){//如果有宽限期 就再做一次宽限期里的租金调整
			Object obj=new Object();
			//构建租金调整变量
			String temp[]=new String[grace+income_number];			
			for(int i=0;i<temp.length;i++){
				if(i<grace){
					temp[i]=frpb.getColumn_2().get(i).toString();
				}else{
					temp[i]="";
				}
			}
			obj=temp;
			// 合同租金测算
			//EvenInterestPlanContrCalServiceImpl rpcs = new EvenInterestPlanContrCalServiceImpl();
			// 不规则修改处//////////////////////////			
			frpb = super.rentPlanCalByDevi(cb, tcb, startList, rentScale, frpb, obj);
		}
		return frpb;
	}

	@Override
	public FundRentPlanBean rentPlanCalByDevi(ConditionBean cb, TabCalBean tcb,
			String rentScale, AdjustBean adb, Object obj) throws Exception {
		// TODO Auto-generated method stub
		return super.rentPlanCalByDevi(cb, tcb, rentScale, adb, obj);
	}

	@Override
	public FundRentPlanBean rentPlanCalByDevi(ConditionBean cb, TabCalBean tcb,
			String startList, String rentScale, FundRentPlanBean frpb,
			Object obj) throws Exception {
		//因为均息法的时候会改变cb中的year_rate所以要把该值保存下来
		String year_rate=cb.getYearRate();
		// 在这之前处理点均息法的下本息调整  然后引用正常的租金调整
		new RentPlanContrCalServiceImpl().rentPlanEvenInterestCal(cb, frpb,obj);
		//2012-09-22做第二次测算时的是要把财务本金赋值给测算本金
		if(!cb.getReckonType().equals("reckon")){
			cb.setCalTotalByCont(cb.getCalTotalByFinac());
		}
		//第二次测算则把利率改回去
		cb.setYearRate(year_rate);
		//如果有宽限期,就要做宽限期下的租金调整
		int grace=Integer.parseInt(cb.getGrace());
		int income_number=Integer.parseInt(cb.getIncomeNumber());
		if(grace>0){//如果有宽限期 就再做一次宽限期里的租金调整
			//Object obj=new Object();
			//构建租金调整变量
			String temp[]=new String[grace+income_number];			
			for(int i=0;i<temp.length;i++){
				if(i<grace){
					temp[i]=frpb.getColumn_2().get(i).toString();
				}else{
					temp[i]=((String[])obj)[i];
				}
			}
			obj=temp;
			// 合同租金测算
			//EvenInterestPlanContrCalServiceImpl rpcs = new EvenInterestPlanContrCalServiceImpl();
			// 不规则修改处//////////////////////////
			//第二次测算则把利率改回去
			//cb.setYear_rate(year_rate);
			//frpb = super.rentPlanCalByDevi(cb, tcb, startList, rentScale, frpb, obj);
		}
		return super.rentPlanCalByDevi(cb, tcb, startList, rentScale, frpb, obj);
	}
}
