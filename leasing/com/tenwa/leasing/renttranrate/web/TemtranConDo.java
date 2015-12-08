package com.tenwa.leasing.renttranrate.web;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.renttranrate.service.impl.TemtranConService;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-4-22
 * @desc TODO (todo-list 对调息临时表中的合同信息进行操作)
 */
public class TemtranConDo {

	Logger	logger	= Logger.getLogger(TemtranConDo.class);


	/**
	 * 
	 * TODO (todo-list todo-list 调息撤销时页面调用方法)
	 * 
	 * @param adjustId
	 *            央行调息记录id
	 * @param contracts
	 *            所要调息的合同集合
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable cancelTransCont(String adjustId, List contracts,
			String measure_id) {

		Hashtable re_ht = new Hashtable();

		try {
			
			TemtranConService tcs = new TemtranConService();
			re_ht=tcs.cancelTransCont(adjustId, contracts, measure_id);
			

		} catch (Exception e) {

			e.printStackTrace();
			re_ht.put("isSucess", "false");
			logger.info("调息或回滚撤销出现异常...");
		}

		return re_ht;
	}

}
