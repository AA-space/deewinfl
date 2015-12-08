package com.tenwa.leasing.bean;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-15
 * @desc TODO (todo-list 常量类,用于保存系统当中的一些常量)
 */
public class ConstantBean {

	public static  String	RATE_ADJUSTMENT_MODULUS	= "360";	// 算天利率的计算系数
	public static  int   Query_Page_Proc=1;						//分页时调用 存储过程的查询方式
	public static  int   Query_Page_Local=2;					//分页时调用 在本地写查询语句的方式
	
	public static int SMSEXECUTIME=1000*60*5;//5分钟执行一次
}
