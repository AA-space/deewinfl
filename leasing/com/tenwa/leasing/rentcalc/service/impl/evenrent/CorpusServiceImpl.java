package com.tenwa.leasing.rentcalc.service.impl.evenrent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.util.leasing.CorpusTools;
import com.tenwa.leasing.util.leasing.RentTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-3
 * @desc TODO (todo-list 本金测算类，其他方法测试得到的本金，都在此方法中重构并返回本金列表)
 */
public class CorpusServiceImpl {
	private static Logger	logger	= Logger.getLogger(CorpusServiceImpl.class);
	/**
	 * 
	 * TODO (todo-list todo-list 等额租金本金测算方法)
	 * 
	 * @param rent_list
	 * @param corpus_list
	 * @return
	 */
	public List getCorpusList(List rent_list, List inter_list) {
		return CorpusTools.getCorpusList(rent_list, inter_list);
	}

	/**
	 *  scl
	 * TODO (todo-list todo-list 获得均息法下的利息列表 均息法 不区分期初期末的利息)
	 * @param leaseMoney 总本金
	 * @param Income_number 还款次数
	 * @param endValue 剩余本金
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getCorpusList(String leaseMoney,String Income_number,String endValue,String grace) {
		int grace_i=Integer.parseInt(grace);
		String corpus=(new BigDecimal(leaseMoney).subtract(new BigDecimal(endValue))).divide(
				new BigDecimal(Income_number),20,BigDecimal.ROUND_HALF_UP).setScale(
				RentTools.getCorpusAccuracy(), BigDecimal.ROUND_HALF_UP).toString();//均息法下的本金值
		List corpus_l=new ArrayList();
		for(int i=0;i<Integer.parseInt(Income_number)+grace_i;i++){
			if(i<grace_i){
				corpus_l.add("0.0");//宽限期本金为0
			}else{
				corpus_l.add(corpus);
			}
		}
		logger.debug("本金总额"+leaseMoney+"还款次数"+Income_number+"本金"+corpus);
		return corpus_l;
	}
	
	/**
	 * 
	 * TODO (todo-list todo-list 不规则租金测算本金测算)
	 * 
	 * @param rent_list
	 * @param inter_list
	 * @param corp_list
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getCorpusList(List rent_list, List inter_list, List corp_list,
			String index) {

		for (int i = Integer.parseInt(index); i < rent_list.size(); i++) {
			corp_list.set(i, new BigDecimal(rent_list.get(i).toString())
					.subtract(new BigDecimal(inter_list.get(i).toString()))
					.toString());
		}
		return corp_list;
	}
}
