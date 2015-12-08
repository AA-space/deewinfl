package com.tenwa.leasing.renttranrate.dao.impl;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.tenwa.leasing.dao.Conn;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list央行基准利率信息Dao操作)
 */
public class FundStanInterDAOImpl {

	/**
	 * 
	 * TODO (todo-list todo-list 根据央行调息的id，查询他的利率信息)
	 * 
	 * @param adjustId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Hashtable getStandInfoById(String adjustId) throws Exception {
		// 数据库操作对象
		Conn conn = new Conn();
		String sql = " 	select  start_date_ ,case when rate_half is null then 0 else rate_half end rate_half," +
				"case when rate_one is null then 0 else rate_one end rate_one," +
				"case when rate_three is null then 0 else rate_three end rate_three," +
				"case when rate_five is null then 0 else rate_five end rate_five," +
				"case when rate_abovefive is null then 0 else rate_abovefive end rate_abovefive," +
				"case when base_rate_half is null then 0 else base_rate_half end base_rate_half," +
				"case when base_rate_one is null then 0 else base_rate_one end  base_rate_one," +
				"case when base_rate_three is null then 0 else base_rate_three end  base_rate_three," +
				"case when base_rate_five is null then 0 else base_rate_five end  base_rate_five," +
				"case when base_rate_abovefive is null then 0 else base_rate_abovefive end base_rate_abovefive  from fund_standard_interest where id='"
				+ adjustId + "' ";

		Hashtable hmp = new Hashtable();
		List<Map<String, String>> rs_list = conn.executeQuery(sql);
		if(rs_list.size()>0){
			Map<String, String> rs=rs_list.get(0);
			hmp.put("start_date", rs.get("start_date_"));
			hmp.put("rate_half", rs.get("rate_half"));
			hmp.put("rate_one", rs.get("rate_one"));
			hmp.put("rate_three", rs.get("rate_three"));

			hmp.put("rate_five", rs.get("rate_five"));
			hmp.put("rate_abovefive", rs.get("rate_abovefive"));
			hmp.put("base_rate_half", rs.get("base_rate_half"));
			hmp.put("base_rate_one", rs.get("base_rate_one"));

			hmp.put("base_rate_three", rs.get("base_rate_three"));
			hmp.put("base_rate_five", rs.get("base_rate_five"));
			hmp.put("base_rate_abovefive", rs.get("base_rate_abovefive"));
		}
//		DaoUtil.closeRSOrConn(rs, conn);
		return hmp;
	}

}
