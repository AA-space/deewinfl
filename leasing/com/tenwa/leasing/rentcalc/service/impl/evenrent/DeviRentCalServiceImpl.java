package com.tenwa.leasing.rentcalc.service.impl.evenrent;

import java.util.Hashtable;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.service.IrrService;
import com.tenwa.leasing.irr.service.impl.IrrServiceImpl;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.rentcalc.service.RentCalcService;
import com.tenwa.leasing.util.ArrayTools;
import com.tenwa.leasing.util.leasing.DictTools;
import com.tenwa.leasing.util.leasing.RentTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-7
 * @desc TODO (todo-list 不规则租金测算)
 */
public class DeviRentCalServiceImpl
		implements RentCalcService {

	/**
	 * 
	 * TODO (todo-list todo-list 不规则租金测算，最主要的是构建合同租金计划实体bean其它的可如等额租金处理)
	 * 
	 * @param cb
	 * @param calType
	 * @param userName
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Hashtable rentCal(ConditionBean cb, String calType, String userName,
			Object obj,String star_list) throws Exception {
		// 得到操作表信息
		TabCalBean tcb = TbBeanTools.getTabInfo(calType, cb);
		// 对交易结构信息处理
		cb = DictTools.getReversDict(cb);
		// 合同租金测算
		RentPlanContrCalServiceImpl rpcs = new RentPlanContrCalServiceImpl();

		FundRentPlanBean frpb = new FundRentPlanBean();
		//因为在不规则中算回去年利率时是以全部租金计划为基础的所以从1开始
		frpb=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb, "1");//初始化租金计划bean并获得年利率集合
		//等额租金下要清除该值
		frpb.setColumn_1(null);
		frpb.setColumn_2(null);
		// 设置他的合同号
		frpb.setProjOrCont(cb.getProjId());
		frpb.setCreator(cb.getCreator());
		//2012-1-11 太原特殊算法 特殊处理年利率 所以保存的时候要调用另一个方法获得原始的年利率值
		frpb.setYearRate(cb.getYearRate());
		frpb.setQuot_id(cb.getQuotId());
		
		frpb.setRent_adjust_list(ArrayTools.arrayToList((String [])obj));//租金调整列值
		
		// 1,表从第一期开始;2,表租金格式化为几位小数,合同租金计划测算

		// 不规则修改处//////////////////////////
		frpb = rpcs.rentPlanCalByDevi(cb, tcb, star_list,RentTools.getRentAccuracy()+"", frpb,obj);
		// ////////////////

		// // 调用保存的操作
		// // 根据表信息进行对表数据的清除操作
		// RentPlanContrCalDAOImpl rpcd = new RentPlanContrCalDAOImpl();
		// rpcd.addRentPlan(frpb, tcb, "1", "2");

		// 现金流处理,返回一个财务现金流,并将财务irr赋值到交易结构plan_iir上
		IrrService is = new IrrServiceImpl();
		// 1,默认按期来计算现金流irr,其它的如按月，按天，在此改参数
		// 2011-06-14修改为安月计算
		//2011-11-14 改为按期
		cb = is.calCashIrrFinacAndCont(cb, tcb, frpb, "1");

		//
		// 财务租金计划处理
		RentPlanFinacCalServiceImpl rpfcs = new RentPlanFinacCalServiceImpl();
		// 1,表从第一期开始;2,表租金格式化为几位小数
		rpfcs.rentPlanCalByConditionAndTab(cb, tcb, star_list, "2", frpb);
		Hashtable re_ht = new Hashtable();
		re_ht.put("isSucess", "true");
		return re_ht;

	}
	/**
	 * 
	 * TODO (todo-list todo-list 起租时实现方法)
	 * 
	 * @param cb
	 * @param calType
	 * @param userName
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Hashtable rentCalOnHire(ConditionBean cb, String calType, String userName, Object obj) throws Exception {
		// TODO Auto-generated method stub
		//由于他的处理与等额租金的是一样的，故调用同一个方法
		return new EvenRentCalcServiceImpl().rentCalOnHire(cb, calType, userName, obj);
	}

}
