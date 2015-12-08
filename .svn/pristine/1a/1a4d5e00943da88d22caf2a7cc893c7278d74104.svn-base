package com.tenwa.leasing.renttranrate.service.impl;

import java.util.Hashtable;
import java.util.List;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.dao.impl.IrrDetailsDAOImpl;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.renttranrate.dao.impl.InteCtractDAOImpl;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-4-22
 * @desc TODO (todo-list 调息或回滚撤销操作)
 */
public class TemtranConService {

	@SuppressWarnings("unchecked")
	public Hashtable cancelTransCont(String adjustId, List contracts,
			String measure_id) throws Exception {

		ConditionBean cb = new ConditionBean();
		cb.setDocId(measure_id);

		RentPlanContrCalDAOImpl rpccd = new RentPlanContrCalDAOImpl();

		for (int i = 0; i < contracts.size(); i++) {
			String contract_id = contracts.get(i).toString();
			cb.setProjId(contract_id);
			// 得到操作表信息,由于他是走流程且操作的都是合同临时表所以类似于合同审批流程
			TabCalBean tcb = TbBeanTools.getTabInfo("cont_process", cb);
			//临时 表合同租金计划的清理
			rpccd.deleteRentPlan(tcb.getRentPlan_tb(), tcb, "0");
			//临时 表会计租金计划的清理
			rpccd.deleteRentPlan(tcb.getRentFinaPlan_tb(), tcb, "0");
			
			//现金流明细表
			IrrDetailsDAOImpl idd = new IrrDetailsDAOImpl();
			idd.deleteCashDetails(tcb,  tcb.getContractCashTb());//合同
			idd.deleteCashDetails(tcb, tcb.getFinacCashTb());//会计
			
			//调息合同相关联的表
			InteCtractDAOImpl icd = new InteCtractDAOImpl();
			icd.deleteInteCtractInfo(contract_id,adjustId,measure_id);
		}

		Hashtable re_ht = new Hashtable();
		re_ht.put("isSucess", "true");
		return re_ht;

	}

}
