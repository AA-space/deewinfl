package com.tenwa.leasing.irr.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.CashDetailsBean;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.leasing.IrrTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-6-14
 * @desc TODO (todo-list 以月来算现金流明细)
 */
public class IrrCalByMonthServiceImpl {
	Logger	logger	= Logger.getLogger(IrrCalByMonthServiceImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 请完善对方法的功能的详细描述，方法需要的参数描述，返回值说明，异常说明)
	 * 
	 * @param ccfbList
	 *            现金流明细
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CashDetailsBean> getNewCashDetailsByCalType(
			List<CashDetailsBean> ccfbList) {
		logger.info("进入按月现金流算irr测算方法..");
		// 返回现金流明细对象
		List<CashDetailsBean> retList = new ArrayList<CashDetailsBean>();

		Hashtable ht_date = IrrTools.remoRepDate(ccfbList, 7);// 由于他是显示年月字段
		// 调用现金流明细构建
		logger.info("现金流明细按月构建..");
		// 将同一个月的发生金额合并
		List<CashDetailsBean> listNew = IrrTools.getNetCashByDate(ht_date,ccfbList);
		// 判断是不是有间隔月，如有，则是原来值，如没有，则重新构建现金流明细
		if (listNew != null && listNew.size() > 0) {

			CashDetailsBean bcb = listNew.get(0);
			CashDetailsBean ecb = listNew.get(listNew.size() - 1);
			// 由于他只取了年月保存的所以后面默认加日
			String beginDate = bcb.getPlan_date() + "-01";
			String endDate = ecb.getPlan_date() + "-01";
			long diffMonth = DateTools.dateDiff("month", beginDate, endDate);
			logger.info("现金流跨付月数:" + diffMonth + "beginDate:" + beginDate
					+ ";endDate:" + endDate);

			String contract_id = bcb.getContract_id(); // 合同号
			String quot_id = bcb.getQuot_id();// 报价编号

			// 根据日期list，月间隔重新组建租金List
			for (int i = 0; i <= diffMonth; i++) {
				String newDate = DateTools.dateAdd("month", i, beginDate);
				

				// 判断此日期是否是在相应的新的时间集合当中
				int index = getSeat(listNew,newDate.substring(0, 7));
				if (index>-1) {// 包含时
					retList.add(listNew.get(index));
					
				} else {// 不在时以0来补充
					
					CashDetailsBean cdbNew = new CashDetailsBean();
					cdbNew.setContract_id(contract_id);
					cdbNew.setQuot_id(quot_id);
					cdbNew.setPlan_date(newDate.substring(0, 7));
					cdbNew.setFund_in("0");
					cdbNew.setFund_in_details("");
					cdbNew.setFund_out("0");
					cdbNew.setFund_out_details("");
					cdbNew.setNet_flow("0");
					retList.add(cdbNew);
				}
			}
		}
		return retList;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 返回一个元素的下标值)
	 * 
	 * @param inList
	 * @param element
	 * @return
	 */
	public static int getSeat(List<CashDetailsBean> lcb, String element) {
		int i = 0;
		int flag = 0;
		for (i = 0; i < lcb.size(); i++) {
			CashDetailsBean cb = lcb.get(i);
			if (element.equals(cb.getPlan_date().substring(0,7))) {
				flag++;
				break;
				
			}
		}
		
		if (flag==0) {
			i=-1;
		}
		return i;

	}
}
