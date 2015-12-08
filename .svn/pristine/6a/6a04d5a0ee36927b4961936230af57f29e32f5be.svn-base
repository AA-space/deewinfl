package com.tenwa.leasing.renttranrate.service.impl;

import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.dao.IrrDetailsDAO;
import com.tenwa.leasing.irr.dao.impl.IrrDetailsDAOImpl;
import com.tenwa.leasing.renttranrate.dao.impl.CashDetailsRetrDAOImpl;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-31
 * @desc TODO (todo-list 对现金流明细的初使)
 */
public class RetrCashPlanServiceImpl {
	/**
	 * 
	 * TODO (todo-list todo-list 现金流明细从历史表中初使化到临时表中)
	 * 
	 * @param tcb
	 * @param creator
	 * @param processId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public boolean processCashPlanFromHis(TabCalBean tcb, String creator,
			String processId) throws Exception {


		// 先删现金流明细,再添加现金流明细
		IrrDetailsDAO idd = new IrrDetailsDAOImpl();
		idd.deleteCashDetails(tcb, tcb.getContractCashTb());// 合同现金流明细表
		// 合同 现金流明细从临时表中读取
		CashDetailsRetrDAOImpl cdrd = new CashDetailsRetrDAOImpl();
		cdrd.addCashPlanFromHis(tcb, creator, processId, tcb
				.getContractCashTb(), " contract_cash_detail_his ");

		// 财务现金流明细处理
		idd.deleteCashDetails(tcb, tcb.getFinacCashTb());// 财务现金流明细表
		cdrd.addCashPlanFromHis(tcb, creator, processId, tcb.getFinacCashTb(),
				" contract_finance_cash_detail_his ");
		return true;
	}
	/**
	 * 
	 * TODO (todo-list todo-list 现金流明细从历史表中初使化到临时表中)
	 * 
	 * @param tcb
	 * @param creator
	 * @param processId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public boolean processCashPlanFromHisByDocId(TabCalBean tcb, String creator,
			String docId) throws Exception {
		
		
		// 先删现金流明细,再添加现金流明细
		IrrDetailsDAO idd = new IrrDetailsDAOImpl();
		idd.deleteCashDetails(tcb, tcb.getContractCashTb());// 合同现金流明细表
		// 合同 现金流明细从临时表中读取
		CashDetailsRetrDAOImpl cdrd = new CashDetailsRetrDAOImpl();
		cdrd.addCashPlanFromHis(tcb, creator, docId, tcb
				.getContractCashTb(), " contract_cash_detail_his ");
		
		// 财务现金流明细处理
		idd.deleteCashDetails(tcb, tcb.getFinacCashTb());// 财务现金流明细表
		cdrd.addCashPlanFromHis(tcb, creator, docId, tcb.getFinacCashTb(),
		" contract_finance_cash_detail_his ");
		return true;
	}
}
