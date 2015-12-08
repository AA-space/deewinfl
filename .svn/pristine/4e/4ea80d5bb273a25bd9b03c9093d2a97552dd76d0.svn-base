package com.tenwa.leasing.util.leasing;

import java.util.List;

/**
 * 
 * @author      SHIHONGFEI
 * @version     1.0
 * @copyright   (C) TENWA 2011
 * @date        2011-2-17
 * @desc        TODO (todo-list 打印租金计划信息)
 */
public class PrintRentInfoTools {
	public static void printRentInfo(List retn_list, List interest_list,
			List corp_list, List corp__overage_list, List l_inte_mark,
			List l_corpus_market, List l_corpus_overage_market) {
		// 0,1，其他值 等额租金,不规则测算,手工调整时，为2时等额本金，先不做考虑

		System.out.println(" rent" + " \t corpus" + " \t interest "
				+ " \t corpus_overage" + " \t interest_market"
				+ " \t corpus_market " + " \t corpus_overage_market");

		for (int j = 0; j < retn_list.size(); j++) {
			System.out.println(retn_list.get(j) + "\t" + corp_list.get(j)
					+ "\t" + interest_list.get(j) + "\t"
					+ corp__overage_list.get(j) + "\t" + l_inte_mark.get(j)
					+ "\t" + l_corpus_market.get(j) + "\t"
					+ l_corpus_overage_market.get(j) + "\t");
		}
	}
	
	public static void printRentInfo(List rent_list, List interest_list,
			List corp_list,List plan_date) {
		// 0,1，其他值 等额租金,不规则测算,手工调整时，为2时等额本金，先不做考虑

		System.out.println(" plan_date" + " \t rent" + " \t corpus "+ " \t interest" );

		for (int j = 0; j < rent_list.size(); j++) {
			System.out.println(plan_date.get(j).toString()
					+"\t "+rent_list.get(j).toString()
					+"\t "+corp_list.get(j).toString()
					+"\t "+interest_list.get(j).toString());
		}
	}
}
