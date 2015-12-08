package com.tenwa.leasing.rentcalc.web;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.rentcalc.dao.impl.RentCalQuitPrice;
import com.tenwa.leasing.rentcalc.service.RentCalcService;
import com.tenwa.leasing.rentcalc.service.impl.eveninterest.DeviEvenInterestCalServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.eveninterest.EvenInterestCalcServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.DeviRentCalServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.EvenRentCalcServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.irregularrent.IrregularRentCalServiceImpl;
import com.tenwa.leasing.util.leasing.DictTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-28
 * @desc TODO (todo-list 用于接收租金测算参数，并调用相应的业务规则进行测算)
 */
public class RentCalcDo {
	Logger	logger	= Logger.getLogger(RentCalcDo.class);
	
	/**
	 * 
	 * TODO (todo-list todo-list 租金测算调用入口点)
	 * @param cb
	 * @param calType 流程类型  
	 * @param userName测算人
	 * @param obj其它参数的传递
	 * @return
	 */
	@SuppressWarnings("all")
	public Hashtable rentCal(ConditionBean cb, String calType, String userName, Object obj) {
		// domino传参说明：docId,proj_id(项目号或合同号)，processType(流程类型:项目：proj_process;合同：cont_process;起租：onHire_process;项目只读:proj_ready_process;合同只读:cont_ready_process;报价:quoted_price)
		// 1.首先判断 流程类型是起租还是立项，合同审批 如果是起租则是更改时间，其他的重新测算
		// 2.判断相应的测算方法 等额租金，不规则测算
		// 先判断测算方式，然后流程类型
		// 进行数组计算
		cb = DictTools.getReversDict(cb);
		RentCalcService rcs = null;
		Hashtable re_ht = new Hashtable();
		String quotId = "";
		try {
			// 如是报价流程且是新增时
			if ("quoted_price".equals(calType) && "".equals(cb.getQuotId())) {
				// 生成报价编号
				RentCalQuitPrice rcqp = new RentCalQuitPrice();
				quotId = rcqp.getQuitPriceId(cb.getDocId());
				logger.info("生成的报价id：" + quotId);
				// 设置proj_id,报价id
				cb.setProjId(quotId);
				cb.setQuotId(quotId);
			}
			//等额租金法
			if ("even_rent".equals(cb.getSettleMethod()) && null == obj) {// 当交易结构点测算时 
				rcs = new EvenRentCalcServiceImpl();
				// 如果是起租时，由于只更改了起租日期，所以不须要重新测算
				if ("onHire_process".equals(calType)) {// 起租时
					re_ht = rcs.rentCalOnHire(cb, calType, userName, obj);
				} else {
					re_ht = rcs.rentCal(cb, calType, userName, obj,"1");
				}
			} else if ("even_rent".equals(cb.getSettleMethod()) && null != obj) {// 不规则,租金计划上的测算按钮时
				rcs = new DeviRentCalServiceImpl();
				//re_ht = rcs.rentCal(cb, calType, userName, obj);
				if ("onHire_process".equals(calType)) {// 起租时
					re_ht = rcs.rentCalOnHire(cb, calType, userName, obj);
				} else {
					re_ht = rcs.rentCal(cb, calType, userName, obj,"1");
				}
			}
			//均息法
			if ("even_interest".equals(cb.getSettleMethod()) && null == obj) {// 当交易结构点测算时
				rcs = new EvenInterestCalcServiceImpl();
				// 如果是起租时，由于只更改了起租日期，所以不须要重新测算
				if ("onHire_process".equals(calType)) {// 起租时
					re_ht = rcs.rentCalOnHire(cb, calType, userName, obj);
				} else {
					re_ht = rcs.rentCal(cb, calType, userName, obj,"1");
				}
			} else if ("even_interest".equals(cb.getSettleMethod()) && null != obj) {// 不规则,租金计划上的测算按钮时
				rcs = new DeviEvenInterestCalServiceImpl();
				//re_ht = rcs.rentCal(cb, calType, userName, obj);				
				if ("onHire_process".equals(calType)) {// 起租时
					re_ht = rcs.rentCalOnHire(cb, calType, userName, obj);
				} else {
					re_ht = rcs.rentCal(cb, calType, userName, obj,"1");
				}				
			}
			//不规则
			if("irregular_rent".equals(cb.getSettleMethod())){
				rcs = new IrregularRentCalServiceImpl();
				// 如果是起租时，由于只更改了起租日期，所以不须要重新测算
				if ("onHire_process".equals(calType)) {// 起租时
					re_ht = rcs.rentCalOnHire(cb, calType, userName, obj);
				} else {
					re_ht = rcs.rentCal(cb, calType, userName, obj,"1");
				}
			}
			
			if(re_ht.get("message")==null||re_ht.get("message").toString().equals("")){
				re_ht.put("message", "租金测算成功!");
			}
		} catch (Exception e) {
			re_ht.put("isSucess", "false");
			re_ht.put("message", "租金测算失败!");
			logger.warn("租金测算出现异常...");
			logger.error(e.toString());
			e.printStackTrace();
		}
		// 将报价id返回
		re_ht.put("quotId", quotId);
		logger.debug("租金测算方法结束...");
		return re_ht;
	}

}
