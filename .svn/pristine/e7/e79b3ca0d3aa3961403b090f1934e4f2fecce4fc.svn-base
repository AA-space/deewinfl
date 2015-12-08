package com.tenwa.leasing.renttranrate.dao.impl;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.dao.Conn;
import com.tenwa.leasing.dao.DaoUtil;
import com.tenwa.leasing.util.DateTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-31
 * @desc TODO (todo-list 现金流明细回滚时操作)
 */
public class CashDetailsRetrDAOImpl {
	Logger	logger	= Logger.getLogger(CashDetailsRetrDAOImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 从历史表读取相应的现金流数据到临时表中)
	 * 
	 * @param tcb
	 * @param contract_id
	 * @param adjust_id
	 * @param creator
	 * @param measure_id
	 * @param toTb
	 * @param frTb
	 * @return
	 * @throws Exception 
	 */
	public boolean addCashPlanFromHis(TabCalBean tcb,  String creator,String docId,  String toTb,
			String frTb) throws Exception {
		
		String whereSql = " where contract_id='"
			+ tcb.getContOrProjCValue()
			+ "' and status='前' and doc_id='"+docId+"' ";
		

		Conn conn = new Conn();
		String sql = " INSERT INTO " + toTb + "(contract_id ";
		sql += ",plan_date";
		sql += ",fund_in";
		sql += ",fund_in_details";
		sql += ",fund_out";
		sql += ",fund_out_details";
		sql += ",net_flow";
		sql += ",creator";
		sql += ",create_date";
		sql += ",modificator";
		sql += ",modify_date";
		sql += ",doc_id";
		sql += " ) SELECT contract_id";
		sql += ",plan_date";
		sql += ",fund_in";
		sql += ",fund_in_details";
		sql += ",fund_out";
		sql += ",fund_out_details";
		sql += ",net_flow";
		sql += ",'"+creator+"'";
		sql += ","+DateTools.getSystemDate(1);
		sql += ",'"+creator+"'";
		sql += ","+DateTools.getSystemDate(1);
		sql += ",'"+tcb.getDocIdCoulValue()+"'";
		sql += " FROM "+frTb+whereSql;

		conn.executeUpdate(sql,"添加现金流历史记录...：" );
		DaoUtil.closeRSOrConn(null, conn);
		return true;

	}
}
