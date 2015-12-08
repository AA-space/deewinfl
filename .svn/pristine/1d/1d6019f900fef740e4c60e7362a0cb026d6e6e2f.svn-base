package com.tenwa.leasing.renttranrate.service.impl;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rent.dao.impl.ConditionDAOImpl;
import com.tenwa.leasing.renttranrate.dao.impl.FundRentHisDAOImpl;
import com.tenwa.leasing.renttranrate.dao.impl.InteCtractDAOImpl;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-31
 * @desc TODO (todo-list 调息回滚处理)
 */
public class RetroversionServiceImpl {
	Logger	logger	= Logger.getLogger(RetroversionServiceImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 回滚处理)
	 * 
	 * @param adjustId
	 * @param contracts
	 * @param creator
	 * @param measure_id
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	public Hashtable processRetro(String adjustId, List contracts,
			String creator, String measure_id) throws Exception {
		logger.info("回滚处理开始...");
		Hashtable re_ht = new Hashtable();

		// 1.根据合同号，measureId去删临时表数据，根据合同号，调息id查询出租金计划历史的最新记录,放到临时表
		// 2.根据合同号，measureId去删临时表数据，根据合同号，调息id查询出现金流明细（会计，财务）历史的最新记录,放到临时表
		// 3.根据合同号，measureId去删除临时表数据，从正式表中读取调息合同关联信息到临时表fund_adjust_interest_contract_temp中的status为否,
		// isRetro为是,添加回滚人，回滚时间;

		for (int i = 0; i < contracts.size(); i++) {
			String contractId = contracts.get(i).toString();
			// 租金计划或现金流明细操作的表跟合同测算的相同故可以用合同的流程来得到所操作的表的信息

			ConditionBean cb = new ConditionBean();
			cb.setProjId(contractId);
			cb.setDocId(measure_id);
			TabCalBean tcb = TbBeanTools.getTabInfo("cont_process", cb);
			
		
			
			
			// 根据合同号，调息id查询此合同的最新租金计划信息历史信息,即操作id
			FundRentHisDAOImpl frhdi = new FundRentHisDAOImpl();
			//String processId=frhdi.getNewProcessIdByAdjustId(adjustId, contractId);
			String docId=frhdi.getDocIdByAdjustId(adjustId, contractId);
			
			//2011-05-17修改,取得最新的doc_id
			
			
			//交易结构信息 his表读取 更新
			ConditionDAOImpl cdi = new ConditionDAOImpl();
//			 构建从交易结构表查询的form语句
			String wheresql = " contract_condition_his where contract_id='"
					+ contractId + "' and doc_id='" + docId	+ "' and mod_status='前' "; 
			TabCalBean tcbTemp=TbBeanTools.getTabInfo("cont_process");
			ConditionBean cbTemp = cdi.getConditionBeanByContract(wheresql,tcbTemp);
			
			cbTemp.setProjId(contractId);
			cbTemp.setDocId(measure_id);
			//添加到temp表中
			cdi.addCondition(cbTemp, tcb);
			
			
			// 租金计划从his表初使化到临时表
			RetrRentPlanServiceImpl rrpsi = new RetrRentPlanServiceImpl();
			rrpsi.processRentPlanFromHis(tcb,  creator, docId);
			
			
			// 现金流明细从his表初使化到临时表
			RetrCashPlanServiceImpl rcpsi = new RetrCashPlanServiceImpl();
			rcpsi.processCashPlanFromHisByDocId(tcb, creator, docId);
			
			//调息合同变更关联信息初使化
			// 添加合同与调息相关的记录
			InteCtractDAOImpl icdi = new InteCtractDAOImpl();
			icdi.deleteInteCtractInfo(contractId, adjustId, measure_id);
			icdi.addInteCInfoFrmFactTb(contractId, adjustId,  creator,measure_id,docId);

			
	
					 
		}

		re_ht.put("isSucess", "true");
		logger.info("回滚处理结束...");

		return re_ht;

	}
}
