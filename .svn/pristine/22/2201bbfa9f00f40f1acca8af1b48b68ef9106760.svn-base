package com.tenwa.leasing.renttranrate.dao.impl;

import org.apache.log4j.Logger;

import com.tenwa.leasing.dao.Conn;
import com.tenwa.leasing.dao.DaoUtil;
import com.tenwa.leasing.util.DateTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 现金流明细历史)
 */
public class CashDetailHisDAOImpl {

	static Logger	logger	= Logger.getLogger(CashDetailHisDAOImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 调息前删除所对应的现金流明细历史数据)
	 * 
	 * @param adjustId
	 * @param contract_id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteCashHisInfo(String adjustId, String contract_id,
			String tbName,String mod_status) throws Exception {

		Conn conn = new Conn();
		String sql = " delete " + tbName + " where contract_id='" + contract_id
				+ "' and mod_reason='调息' and doc_id='" + adjustId + "' and mod_status='"+mod_status+"'";

		conn.executeUpdate(sql,"删除相对应的现金流历史记录：");
		DaoUtil.closeRSOrConn(null, conn);
		return true;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 调息添加所对应的现金流明细历史数据)
	 * 
	 * @param adjustId
	 * @param contract_id
	 * @param tbTo
	 * @param tbFrom
	 * @param status
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean addCashHisInfo(String adjustId, String contract_id,
			String tbTo, String tbFrom, String status, String user)
			throws Exception {

		Conn conn = new Conn();
		String sql = "insert into " + tbTo + "(contract_id";
		sql += ",plan_date";
		sql += ",fund_in";
		sql += ",fund_in_details";
		sql += ",fund_out";
		sql += ",fund_out_details";
		sql += ",net_flow";
		sql += ",creator";
		sql += ",create_date";
		sql += ",doc_id";
		sql += ",mod_reason";
		sql += ",status ) select contract_id";
		sql += ",plan_date";
		sql += ",fund_in";
		sql += ",fund_in_details";
		sql += ",fund_out";
		sql += ",fund_out_details";
		sql += ",net_flow";
		sql += ",'" + user + "'";
		sql += ","+DateTools.getSystemDate(1);
		sql += " ,'调息','" + status + "' from  " + tbFrom + " order by id";

		conn.executeUpdate(sql,"添加相对应的现金流历史记录：");
		DaoUtil.closeRSOrConn(null, conn);
		return true;
	}

}
