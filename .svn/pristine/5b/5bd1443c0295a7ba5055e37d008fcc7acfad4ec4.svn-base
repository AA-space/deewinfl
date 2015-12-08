package com.tenwa.leasing.bean;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.tenwa.leasing.dao.Conn;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list 用于查询，并以列名为键，列值为值的hash形式返回)
 */
public class CommBean {
	/**
	 * 
	 * TODO (todo-list todo-list
	 * 查询一条数据，并把他封装到hashTable中，前以列名成为主键，该列的值为HashTable的值)
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	public static Hashtable<String, String> getSignBean(String sql)
			throws Exception {

		Conn conn = new Conn();
		List<Map<String, String>> rs_list = conn.executeQuery(sql);

		// 用于保存查询中的值
		Hashtable<String, String> htBean = new Hashtable<String, String>();
		if(rs_list.size()>0){
			htBean=new Hashtable(rs_list.get(0));
		}
		return htBean;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 查询所有的满足条件的值，并以列名成为主键，该列的值为HashTable的值
	 * 保存到list集合当中)
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<Hashtable<String, String>> getListBean(String sql)
			throws Exception {

		Conn conn = new Conn();
		List<Map<String, String>> rs_list = conn.executeQuery(sql);
		List<Hashtable<String, String>> list=new ArrayList<Hashtable<String,String>>();
		for(Map<String, String> rs:rs_list){
			Hashtable<String, String> temp=new Hashtable<String, String>(rs);
			list.add(temp);
		}
		return list;
	}

}
