package com.tenwa.leasing.util.leasing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;




/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list 本金余额测算)
 */
public class CorpusOvergeTools {

	/**
	 * 
	 * @param leaseMoney总的测算本金
	 * @param corpusList
	 *            每一期的本金
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static  List getCorpusOvergeList(String leaseMoney, List corpusList) {
		String total = "0.00";// 累积每一期的本金
		List corps = new ArrayList();
		for (int i = 0; i < corpusList.size(); i++) {

			total = new BigDecimal(total).add(
					new BigDecimal(corpusList.get(i).toString())).setScale(RentTools.getCorpusAccuracy(),BigDecimal.ROUND_HALF_UP).toString();
			BigDecimal temp=new BigDecimal(leaseMoney).subtract(new BigDecimal(total)).setScale(RentTools.getAccuracy(),BigDecimal.ROUND_HALF_UP);
			if(i==corpusList.size()-1){//最后一期的本金余额肯定是0
				temp=new BigDecimal("0");
			}
			corps.add(temp.toString());
		}
		return corps;
	}
}
