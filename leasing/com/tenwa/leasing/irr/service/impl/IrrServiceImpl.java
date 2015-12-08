package com.tenwa.leasing.irr.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.CashDetailsBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.dao.IrrDetailsDAO;
import com.tenwa.leasing.irr.dao.impl.IrrDetailsDAOImpl;
import com.tenwa.leasing.irr.service.IrrDetailsService;
import com.tenwa.leasing.irr.service.IrrService;
import com.tenwa.leasing.rent.dao.ConditionDAO;
import com.tenwa.leasing.rent.dao.impl.ConditionDAOImpl;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.util.leasing.DictTools;
import com.tenwa.leasing.util.leasing.IrrTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-4
 * @desc TODO (todo-list 现金流处理总入口点实现类,调用现金流配置实现接口，构建现金流明细处理点集合点)
 */
public class IrrServiceImpl
		implements IrrService {
	Logger log=Logger.getLogger(IrrServiceImpl.class);
	/**
	 * 
	 * TODO (todo-list todo-list 合同，会计现金流处理)
	 * 
	 * @param cb
	 * @param tb
	 * @param frpb
	 * @param calType
	 *            1 是按期类型 2按月
	 * @return
	 * @throws Exception
	 */
	public ConditionBean calCashIrrFinacAndCont(ConditionBean cb,
			TabCalBean tcb, FundRentPlanBean frpb, String calType)
			throws Exception {
		//2011-11-11 现金流的处理隔月不补零
		calType="1";
		// 处理合同现金流明细
		calContrCashDetails(cb, tcb, frpb,calType);
		// 会计现金流明细
		calFinaCashDetails(cb, tcb, frpb,calType);
		//2012-4-13 修改多次起租的时候会计现金流重算
		if(tcb.getCalType().equals("onHire_more_process")){
			log.debug("==============多次起租重算现金流=====================");
			TabCalBean tcb_cont = new TabCalBean();
			tcb_cont = TbBeanTools.getTabInfo("cont_process");
			tcb_cont.setOnHire_id(tcb.getOnHire_id());
			tcb_cont.setContOrProjCValue(tcb.getContOrProjCValue());
			tcb_cont.setDocIdCoulValue(tcb.getDocIdCoulValue());
			tcb_cont.setId_1(tcb.getId_1());
			tcb_cont.setId_2(tcb.getId_2());
			tcb_cont.setIs_merger(tcb.getIs_merger());// 传递是否合并计算
			tcb_cont.setUserId(tcb.getUserId());
			
			ConditionBean cdb_t=new ConditionBean();
			FundRentPlanBean frpb_t=new FundRentPlanBean();
			String wheresql=tcb_cont.getCondition_tb()+" where " + tcb_cont.getContOrProjCName() + "='"	+ tcb_cont.getContOrProjCValue() 
				+ "' and "+tcb_cont.getDocIdCoulName()+"='"+tcb_cont.getDocIdCoulValue()+"'";
			cdb_t=new ConditionDAOImpl().getConditionBeanByContract(wheresql,tcb_cont);
			cdb_t=DictTools.getReversDict(cdb_t);
			frpb_t=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb_cont, "1");
			// 处理合同现金流明细
			calContrCashDetails(cdb_t, tcb_cont, frpb_t,calType);
			// 会计现金流明细
			calFinaCashDetails(cdb_t, tcb_cont, frpb_t,calType);
		}
		return cb;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 处理合同现金流明细)
	 * 
	 * @param cb
	 * @param tcb
	 * @param frpb
	 * @throws Exception
	 */
	private void calContrCashDetails(ConditionBean cb, TabCalBean tcb,
			FundRentPlanBean frpb, String calType) throws Exception {		
		// 处理合同配置的现金流
		IrrDetailsService ids = new IrrDetailsServiceImpl();
		
		List<CashDetailsBean> cdbList = ids.getCashDetailByCfg(tcb, "合同");
		// 租金计划现金流明细的构建
		cdbList = ids.getCashDetailByRentPlan(frpb, cdbList,1);

		// 以上操作完后，根据日期进行，重组现金流明细
		IrrCalServiceImpl icsi = new IrrCalServiceImpl();
		cdbList = icsi.getNewCashDetailsByCalType(calType, cdbList);// 按期得到新的现金流明细,如按其他现金流测算的，可以在此修改，并重写方法
		
		// 合同的保证金抵扣现金流明细构建
		cdbList = IrrTools.getRentDetailsByDeduct(cdbList, cb.getCautionDeductionMoney());
		
		// 合同的预收租金抵扣现金流明细构建
		cdbList = IrrTools.getRentDetailsByDeductBeforeRent(cdbList,cb.getExpectRentDeduction());
		
		// 最后一期留购价，期末列值更新
		cdbList = IrrTools.getCashDetailsByEndValue(cdbList, cb
				.getEquipEndValue(), cb.getNominalPrice());
		
		//2011-10-26
		//处理特殊的保证金抵扣 保证金抵扣金额小于保证金金额 最后要做一笔流出 为保证金金额减去保证金抵扣金额
		cdbList=IrrTools.getRentDetailsByDeductOut(cdbList, cb.getCautionMoney(), cb.getCautionDeductionMoney()); 
		
		//处理特殊的预收租金抵扣 预收租金抵扣金额小于预收租金金额 最后要做一笔流出 为预收租金金额减去预收租金抵扣金额
		cdbList=IrrTools.getRentDetailsByDeductBeforeRentOut(cdbList, cb.getExpectRent(), cb.getExpectRentDeduction());
		
		// 先删现金流明细,再添加现金流明细
		IrrDetailsDAO idd = new IrrDetailsDAOImpl();
		idd.deleteCashDetails(tcb, tcb.getContractCashTb());// 合同现金流明细表
		idd.addCashDetails(tcb, cdbList, tcb.getContractCashTb());
		
		// 测算新的合同 irr
		//2011-11-11 因为现金流是按期构造所以IRR不能用月计算
		//String irr = IrrTools.getIrrByPreMonth(cdbList, cb);
		String irr=IrrTools.getIrr(cdbList, cb);
		System.out.println("更新交易结构表irr:" + irr);
		
		// 更新交易结构表irr
		ConditionDAO cd = new ConditionDAOImpl();
		cd.updateConditionContIrr(tcb, irr);

		// ConditionBean cb 设置 irr属性
		cb.setIrr(new BigDecimal(irr).multiply(new BigDecimal("100")).toString());
	}


	/**
	 * 
	 * TODO (todo-list todo-list 处理会计现金流明细)
	 * 
	 * @param cb
	 * @param tcb
	 * @param frpb
	 * @throws Exception
	 */
	private void calFinaCashDetails(ConditionBean cb, TabCalBean tcb,
			FundRentPlanBean frpb, String calType) throws Exception {

		// 处理会计配置的现金流
		IrrDetailsService ids = new IrrDetailsServiceImpl();
		List<CashDetailsBean> cdbList = ids.getCashDetailByCfg(tcb, "会计");
		// 租金计划现金流明细的构建
		cdbList = ids.getCashDetailByRentPlan(frpb, cdbList,1);

		// 以上操作完后，根据日期进行，重组现金流明细
		IrrCalServiceImpl icsi = new IrrCalServiceImpl();
		cdbList = icsi.getNewCashDetailsByCalType(calType, cdbList);// 按期得到新的现金流明细,如按其他现金流测算的，可以在此修改，并重写方法

		// 最后一期留购价，期末列值更新 2012-5-7 改两项不参与计算
		//cdbList = IrrTools.getCashDetailsByEndValue(cdbList, cb
		//		.getEquip_end_value(), cb.getNominal_price());
		// 先删现金流明细,再添加现金流明细
		IrrDetailsDAO idd = new IrrDetailsDAOImpl();
		idd.deleteCashDetails(tcb, tcb.getFinacCashTb());// 会计现金流明细表
		idd.addCashDetails(tcb, cdbList, tcb.getFinacCashTb());
		// 测算新的会计 plan_irr
		//2011-11-11 因为现金流是按期构造所以IRR不能用月计算
		//String finacIrr = IrrTools.getIrrByPreMonth(cdbList, cb);
		String finacIrr=IrrTools.getIrr(cdbList, cb);
		// 更新交易结构表irr
		ConditionDAO cd = new ConditionDAOImpl();
		cd.updateConditionFinaIrr(tcb, finacIrr);

		// ConditionBean cb 设置 plan_irr属性
		cb.setPlanIrr(new BigDecimal(finacIrr).multiply(new BigDecimal("100")).toString());

	}

}
