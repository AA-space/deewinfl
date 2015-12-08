package com.tenwa.leasing.renttranrate.service.impl;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-31
 * @desc TODO (todo-list 租金回滚时对租金计划临时表数据操作)
 */
public class RetrRentPlanServiceImpl {
	Logger	logger	= Logger.getLogger(RetrRentPlanServiceImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 租金计划从历史表中初使化到临时表中)
	 * 
	 * @param tcb
	 * @param adjust_id
	 * @param creator
	 * @param processId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public boolean processRentPlanFromHis(TabCalBean tcb, String adjust_id,
			String creator, String processId) throws Exception {

		logger.info("回滚流程租金计划临时表数据初使化开始......");

		// 由于有些列值要取当前系统的，所以在此构建
		Hashtable colHt = new Hashtable();
		colHt.put("user", creator);
		colHt.put("measure_id", tcb.getDocIdCoulValue());

		// 先删除临时表中的数据,由于是初使化数据所以要整个租金计划都删除，所以从第一期开始
		RentPlanContrCalDAOImpl rpccd = new RentPlanContrCalDAOImpl();
		rpccd.deleteRentPlan(tcb.getRentPlan_tb(),tcb, "1");
		// 应该是租金历史表中调整前（调息id,状态 前，且是最新的）
		String whereSql = " where contract_id='" + tcb.getContOrProjCValue()
				+ "' and doc_id='" + adjust_id
				+ "' and mod_status='前' and processId='" + processId + "' ";
		rpccd.addRentInfoBySql(" fund_rent_plan_temp ", " fund_rent_plan_his ",
				whereSql, colHt);
		
		
		
//		会计租金计划初使化 先删除临时表中的数据,由于是初使化数据所以要整个租金计划都删除，所以从第一期开始

		rpccd.deleteRentPlan(tcb.getRentFinaPlan_tb(),tcb, "1");
		// 应该是租金历史表中调整前（调息id,状态 前，且是最新的）
		  whereSql = " where contract_id='" + tcb.getContOrProjCValue()
				+ "' and doc_id='" + adjust_id
				+ "' and mod_status='前' and processId='" + processId + "' ";
		rpccd.addRentInfoBySql(" fina_rent_plan_temp ", " fina_rent_plan_his ",
				whereSql, colHt);
		
		logger.info("回滚流程租金计划临时表数据初使化结束......");
		return true;
	}
	/**
	 * 
	 * TODO (todo-list todo-list 租金计划从历史表中初使化到临时表中)
	 * 
	 * @param tcb
	 * @param adjust_id
	 * @param creator
	 * @param processId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public boolean processRentPlanFromHis(TabCalBean tcb,
			String creator, String doc_id) throws Exception {
		
		logger.info("回滚流程租金计划临时表数据初使化开始......");
		
		// 由于有些列值要取当前系统的，所以在此构建
		Hashtable colHt = new Hashtable();
		colHt.put("user", creator);
		colHt.put("measure_id", tcb.getDocIdCoulValue());
		
		// 先删除临时表中的数据,由于是初使化数据所以要整个租金计划都删除，所以从第一期开始
		RentPlanContrCalDAOImpl rpccd = new RentPlanContrCalDAOImpl();
		rpccd.deleteRentPlan(tcb.getRentPlan_tb(),tcb, "1");
		// 应该是租金历史表中调整前（调息id,状态 前，且是最新的）
		String whereSql = " where contract_id='" + tcb.getContOrProjCValue()
		+ "' and doc_id='" + doc_id
		+ "' and mod_status='前' ";
		rpccd.addRentInfoBySql(" fund_rent_plan_temp ", " fund_rent_plan_his ",
				whereSql, colHt);
		
		
		
//		会计租金计划初使化 先删除临时表中的数据,由于是初使化数据所以要整个租金计划都删除，所以从第一期开始
		
		rpccd.deleteRentPlan(tcb.getRentFinaPlan_tb(),tcb, "1");
		// 应该是租金历史表中调整前（调息id,状态 前，且是最新的）
		whereSql = " where contract_id='" + tcb.getContOrProjCValue()
		+ "' and doc_id='" + doc_id
		+ "' and mod_status='前' ";
		rpccd.addRentInfoBySql(" fina_rent_plan_temp ", " fina_rent_plan_his ",
				whereSql, colHt);
		
		logger.info("回滚流程租金计划临时表数据初使化结束......");
		return true;
	}
}
