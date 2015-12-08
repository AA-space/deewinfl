package com.tenwa.leasing.renttranrate.web;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.renttranrate.service.impl.RentTranRateServiceImpl;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 调息时页面调用控制类)
 */
public class RentTranRateDo {

	Logger	logger	= Logger.getLogger(RentTranRateDo.class);


	/**
	 * 
	 * TODO (todo-list todo-list 调息时页面调用方法)
	 * 
	 * @param adjustId
	 *            央行调息记录id
	 * @param contracts
	 *            所要调息的合同集合
	 * @param creator
	 *            调息时当前系统登陆人
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable processTransRate(String adjustId, List ids,List contractIds,
			String creator,String measure_id) {

		Hashtable re_ht = new Hashtable();

		try {

//			RentTranRateServiceImpl rtrsi = new RentTranRateServiceImpl();
//			re_ht = rtrsi.processTransRate(adjustId, ids,contractIds, creator,measure_id);
		} catch (Exception e) {
			e.printStackTrace();
			re_ht.put("isSucess", "false");
			re_ht.put("message", "调息过程中出现异常,可能的原因为:"+e.toString());
			logger.info("调息出现异常...");
		}
		
		return re_ht;
	}
}
