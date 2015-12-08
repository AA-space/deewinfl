package com.tenwa.leasing.rentcharge.service.impl;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.AdjustBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.service.IrrService;
import com.tenwa.leasing.irr.service.impl.IrrServiceImpl;
import com.tenwa.leasing.rent.dao.impl.ConditionDAOImpl;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.NumTools;
import com.tenwa.leasing.util.leasing.CorpusOvergeTools;
import com.tenwa.leasing.util.leasing.DictTools;
import com.tenwa.leasing.util.leasing.RentTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-5-6
 * @desc TODO (todo-list 租金计划修改业务处理类)
 */
public class RentPlanModServiceImpl {
	Logger	logger	= Logger.getLogger(RentPlanModServiceImpl.class);

	/**
	 * 
	 * TODO (todo-list todo-list 租金计划业务处理方法)
	 * 
	 * @param contract_id
	 * @param doc_id
	 * @param creator
	 * @param calType 流程类型
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public Hashtable updatePlan(String contract_id, String doc_id,
			String creator,String calType) throws Exception {
		TabCalBean tcb=TbBeanTools.getTabInfo(calType);//先获得操作表信息 用以查询出交易结构
		//[key:scl-A]2012-12-07在租金计划修改的时候如果是客户报价则要记录下报价ID
		tcb.setDocIdCoulValue(contract_id);
		tcb.setContOrProjCValue(doc_id);
		//tcb.setTableToView();//为了配合统一的SQL语句查询 客户报价没有doc_id所以在这里查询交易结构的时候通过视图查询
		logger.info("进入方法:updatePlan 进行租金计划修改..");
		//构建从交易结构表查询的form语句,交易结构表信息获得
		ConditionDAOImpl cdi = new ConditionDAOImpl();
		String wheresql=tcb.getCondition_tb()+" where "+tcb.getContOrProjCName()
		+"='"+contract_id+"' and "+tcb.getDocIdCoulName()
		+"='"+doc_id+"'";
		ConditionBean cb = cdi.getConditionBeanByContract(wheresql,tcb);

		// 设置他的此时操作的,String measure_id
		cb.setMeasureId(doc_id);
		cb.setDocId(doc_id);
		cb.setProjId(contract_id);
		
		
		cb.setModificator(creator);
		cb.setModifyDate(DateTools.getSystemDate(0));
		
		// 得到操作表信息,类似于合同的租金测算
		tcb = TbBeanTools.getTabInfo(calType, cb);//然后用交易结构再次获取到完整的操作表信息
		// 为了后面的计算再转向
		cb = DictTools.getReversDict(cb);

		FundRentPlanBean frpb = new FundRentPlanBean();
		// 合同租金计划测算从临时表中取得
		// 租金计划可从相应的临时表去取,实际上用于明细的构建只用到租金计划的租金列，租金支付日期列,合同号与报价id
		RentPlanContrCalDAOImpl rpccdi = new RentPlanContrCalDAOImpl();
		frpb=rpccdi.getRentAndDateByTcb(tcb, "1");
		//删除并重新添加--必须要这么做 才能在多次起租的时候触发合并计算
		rpccdi.deleteRentPlan(tcb.getRentPlan_tb(), tcb, "1");
		//重构本金余额集合
		frpb.setCorpusOverage_list(CorpusOvergeTools.getCorpusOvergeList(NumTools.getSumCorpusOverage(frpb.getCorpus_list(), 1), frpb.getCorpus_list()));
		//[key:scl-A]2012-12-07在租金计划修改的时候如果是客户报价则要记录下报价ID
		frpb.setQuot_id(contract_id);
		rpccdi.addRentPlan(tcb.getRentPlan_tb(), frpb, tcb, "1", RentTools.getRentAccuracy()+"");
		Hashtable re_ht = new Hashtable();
		try{
			AdjustBean adb=new AdjustBean();
			adb.setStartList(1);
			re_ht=new FinaPlanChargeServiceImpl().chargeFinaPlan(tcb, adb, cb,frpb, re_ht);
			IrrService is = new IrrServiceImpl();
			// 1,默认按期来计算现金流irr,其它的如按月，按天，在此改参数
			cb = is.calCashIrrFinacAndCont(cb, tcb, frpb, "1");
			//2012-3-9 存入IRR值
			//cdi.updateConditionContIrr(tcb, cb.getIrr());
			//cdi.updateConditionFinaIrr(tcb, cb.getPlan_irr());
		}catch (Exception e) {;
		
			logger.error("构建现金流或者计算IRR出错!");
			e.toString();
			e.printStackTrace();	
			re_ht.put("isSucess", "false");
			re_ht.put("message", "构建现金流或者计算IRR出错!");
			return re_ht;
		}
		
		re_ht.put("isSucess", "true");
		logger.info("结束租金计划修改测算 ..");
		return re_ht;
	}
}
