package com.tenwa.leasing.rentcalc.service.impl.evenrent;

import java.math.BigDecimal;
import java.util.List;

import com.tenwa.leasing.util.leasing.CorpusOvergeTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-3
 * @desc TODO (todo-list 本金余额列表算法实现，其它算法可在此类中重构方法)
 */
public class CorpusOvergeServiceImpl {

	/**
	 * 
	 * TODO (todo-list todo-list 本金余额计算方法)
	 * 
	 * @param calTotalCorpus
	 * @param corpusList
	 * @return
	 */
	public List getCorpusOvergeList(String calTotalCorpus, List corpusList) {

		return CorpusOvergeTools
				.getCorpusOvergeList(calTotalCorpus, corpusList);
	}


	/**
	 * 
	 * TODO (todo-list todo-list 不规则时 本金余额计算方法)
	 * 
	 * @param calTotalCorpus
	 * @param corpusList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getCorpusOvergeList(String calTotalCorpus, List corpusList,
			List corpusOver_list, String index) {

		String total = "0";// 累积每一期的本金

		for (int i = Integer.parseInt(index); i < corpusList.size(); i++) {

			total = new BigDecimal(total).add(
					new BigDecimal(corpusList.get(i).toString())).toString();

			corpusOver_list.set(i, new BigDecimal(calTotalCorpus).subtract(
					new BigDecimal(total)).toString());

		}
		return corpusOver_list;
	}
}
