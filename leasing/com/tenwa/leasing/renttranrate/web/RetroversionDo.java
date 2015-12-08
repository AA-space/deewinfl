package com.tenwa.leasing.renttranrate.web;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.renttranrate.service.impl.RetroversionServiceImpl;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-29
 * @desc TODO (todo-list 回滚处理)
 */
public class RetroversionDo {
	Logger	logger	= Logger.getLogger(RetroversionDo.class);


	/**
	 * 
	 * TODO (todo-list todo-list 回滚处理)
	 * 
	 * @param adjustId
	 * @param contracts
	 * @param creator
	 * @param measure_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable processRetro(String adjustId, List contracts,
			String creator, String measure_id) {

		Hashtable re_ht = new Hashtable();
		try {

			RetroversionServiceImpl rsi = new RetroversionServiceImpl();
			re_ht = rsi.processRetro(adjustId, contracts, creator, measure_id);
			
		} catch (Exception e) {
			e.printStackTrace();
			re_ht.put("isSucess", "false");
			logger.info("租金测算出现异常...");
		}

		return re_ht;

	}

}
