package com.tenwa.leasing.rentcharge.web;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.tenwa.leasing.rentcharge.service.impl.RentPlanModServiceImpl;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-5-6
 * @desc TODO (todo-list 租金计划修改)
 */
public class RentPlanModDo {

	Logger	logger	= Logger.getLogger(RentPlanModDo.class);


	/**
	 * 
	 * TODO (todo-list todo-list 租金计划修改)
	 * @param contract_id
	 * @param doc_id
	 * @param creator
	 * @param calType 流程类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable updatePlan(String contract_id, String doc_id,
			String creator,String calType) {

		Hashtable re_ht = new Hashtable();
		try {
			RentPlanModServiceImpl rpmsi = new RentPlanModServiceImpl();
			re_ht =rpmsi.updatePlan(contract_id, doc_id, creator,calType);
			re_ht.put("message", "租金测算成功!");
		} catch (Exception e) {

			e.printStackTrace();
			re_ht.put("isSucess", "false");
			re_ht.put("message", "租金测算出现异常!");
			logger.warn("租金测算出现异常...");
		}
		return re_ht;
	}

}
