package com.tenwa.leasing.rentcharge.service.impl;

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
import com.tenwa.leasing.renttranrate.service.impl.FinaRentPlanServiceImpl;

/**
 * 
 * @author      SCLICX
 * @version     1.0
 * @copyright   (C) Tenwa 2011
 * @date        Dec 1, 2011
 * @desc        处理变更的时候的财务租金计划和现金流
 */
public class FinaPlanChargeServiceImpl {
	
	Logger	logger	= Logger.getLogger(FinaPlanChargeServiceImpl.class);
	
	/**
	 * 
	 * TODO 处理 财务租金计划和现金流
	 * @param tcb
	 * @param adb
	 * @param cdb
	 * @param ht
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Hashtable chargeFinaPlan(TabCalBean tcb,AdjustBean adb,ConditionBean cdb,FundRentPlanBean frpb,Hashtable ht) throws Exception{
		InterContBean icb = new InterContBean();
		icb.setStart_list(adb.getStartList().toString());
		FundRentPlanBean frpb1=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb, "1");
		frpb1.setColumn_1(null);
		frpb1.setColumn_2(null);
		//设置frpb信息
		frpb1.setModificator(adb.getCreator());
		frpb1.setModify_date(new Date().toLocaleString());
		//frpb1.setYearRate(adb.getYearRate().toString());
		//将year_rate_list更新  只要移除保存时会自动更新
		frpb1.setYear_rate_list(null);
		//调整时 要把租金调整列清空
		frpb1.setRent_adjust_list(null);
		//处理财务租金计划 这个时候不区分租金测算方法
		FinaRentPlanServiceImpl frpsi = new FinaRentPlanServiceImpl();
		frpsi.processFinacRentPlan(cdb, icb, tcb, frpb1);
		//现金流明细构建
		IrrDetailsServiceByTranImpl idsbti = new IrrDetailsServiceByTranImpl();
		icb = idsbti.processTranCashDetails(cdb, icb, tcb);
		return ht;
	}
}
