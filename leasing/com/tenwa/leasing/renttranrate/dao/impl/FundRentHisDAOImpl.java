package com.tenwa.leasing.renttranrate.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.tenwa.leasing.dao.Conn;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 调息时租金计划历史表DAo)
 */
public class FundRentHisDAOImpl {

	static Logger	logger	= Logger.getLogger(FundRentHisDAOImpl.class);


//	/**
//	 * 
//	 * TODO (todo-list todo-list 调息前删除所对应的历史数据)
//	 * 
//	 * @param adjustId
//	 * @param contract_id
//	 * @return
//	 * @throws Exception
//	 */
//	public boolean deleteRentHisInfo(String tbName,String adjustId, String contract_id,
//			String mod_status) throws Exception {
//
//		Conn conn = new Conn();
//		String sql = " delete "+tbName+" where contract_id='"
//				+ contract_id
//				+ "' and mod_reason='调息' and doc_id='' and mod_status='"
//				+ mod_status + "'" + adjustId + "'";
//
//		logger.info("删除相对应的租金历史记录：" + sql);
//		conn.executeUpdate(sql);
//		DaoUtil.closeRSOrConn(null, conn);
//		return true;
//	}


//	/**
//	 * 
//	 * TODO (todo-list todo-list 添加租金计划历史记录)
//	 * 
//	 * @param adjustId
//	 * @param contract_id
//	 * @param status
//	 *            前或后
//	 * @return
//	 * @throws Exception
//	 */
//	public boolean addRentHisInfo(String tbName,String frmTb,String adjustId, String contract_id,
//			String status, String user) throws Exception {
//
//		Conn conn = new Conn();
//
//		String sql = "insert into "+tbName+"(";
//		sql += "[doc_id] ";
//		sql += ",[contract_id]";
//		sql += ",[rent_list]";
//		sql += ",[plan_date]";
//		sql += ",[rent]";
//		sql += ",[rent_adjust]";
//		sql += ",[corpus]";
//		sql += ",[year_rate]";
//		sql += ",[interest]";
//		sql += ",[rent_overage]";
//		sql += ",[corpus_overage]";
//		sql += ",[interest_overage]";
//		sql += ",[penalty_overage]";
//		sql += ",[penalty]";
//		sql += ",[corpus_finac]";
//		sql += ",[interest_finac]";
//		sql += ",[corpus_overage_finac]";
//		sql += ",[creator]";
//		sql += ",[create_date]";
//		sql += ",[Column_1]";
//		sql += ",[Column_2]";
//		sql += ",[Column_3]";
//		sql += ",[Column_4]";
//		sql += ",[Column_5]";
//		sql += ",[Column_6]";
//		sql += ",[Column_7]";
//		sql += ",[Column_8]";
//		sql += ",[Column_9]";
//		sql += ",[Column_10]";
//		sql += ",[status]";
//		sql += ",[quot_id]";
//		sql += ",[mod_status]";
//		sql += ",[mod_reason]) select ";
//		sql += "'" + adjustId + "' ";
//		sql += ",[contract_id]";
//		sql += ",[rent_list]";
//		sql += ",[plan_date]";
//		sql += ",[rent]";
//		sql += ",[rent_adjust]";
//		sql += ",[corpus]";
//		sql += ",[year_rate]";
//		sql += ",[interest]";
//		sql += ",[rent_overage]";
//		sql += ",[corpus_overage]";
//		sql += ",[interest_overage]";
//		sql += ",[penalty_overage]";
//		sql += ",[penalty]";
//		sql += ",[corpus_finac]";
//		sql += ",[interest_finac]";
//		sql += ",[corpus_overage_finac]";
//		sql += ",'" + user + "'";
//		sql += ",getdate()";
//
//		sql += ",[Column_1]";
//		sql += ",[Column_2]";
//		sql += ",[Column_3]";
//		sql += ",[Column_4]";
//		sql += ",[Column_5]";
//		sql += ",[Column_6]";
//		sql += ",[Column_7]";
//		sql += ",[Column_8]";
//		sql += ",[Column_9]";
//		sql += ",[Column_10]";
//		sql += ",[status]";
//		sql += ",[quot_id]";
//		sql += ",'" + status + "'";
//		sql += ",'调息' from "+frmTb+" 	 where contract_id='" + contract_id
//				+ "' order by rent_list ";
//
//		logger.info("添加相对应的租金历史记录：" + sql);
//		conn.executeUpdate(sql);
//		DaoUtil.closeRSOrConn(null, conn);
//		return true;
//	}


	/**
	 * 
	 * TODO (todo-list todo-list 根据合同号与调息id查询他最新的操作id)
	 * 
	 * @param adjustId
	 * @param contract_id
	 * @return
	 * @throws Exception
	 */
	public String getNewProcessIdByAdjustId(String adjustId, String contract_id)
			throws Exception {

		logger.info("查询回滚的操作id....");
		// 数据库操作对象
		Conn conn = new Conn();
		String sql = "select MAX(processId), processId from fund_rent_plan_his  ";
		sql += " where contract_id='" + contract_id + "' and doc_id='"
				+ adjustId + "' group by processId order by processId desc";

		String processId = "";
		List<Map<String, String>> rs_list = conn.executeQuery(sql,"此次回滚的操作id查询....");
		for(Map<String, String> rs:rs_list){
			processId = rs.get("processid");
			processId=processId.substring(0,6);
		}
		logger.info("此次回滚的操作id...." + processId);
//		DaoUtil.closeRSOrConn(rs, conn);
		return processId;
	}
	/**
	 * 
	 * TODO (todo-list todo-list 根据合同号与调息id查询他的doc_id)
	 * 
	 * @param adjustId
	 * @param contract_id
	 * @return
	 * @throws Exception
	 */
	public String getDocIdByAdjustId(String adjustId, String contract_id)
	throws Exception {
		
		logger.info("查询上次的调息doc_id....");
		// 数据库操作对象
		Conn conn = new Conn();
		String sql = "select doc_id from dbo.fund_adjust_interest_contract  ";
		sql += " where contract_id='" + contract_id + "' and adjust_id='"
		+ adjustId + "'";
		
		String doc_id = "";
		List<Map<String, String>> rs_list = conn.executeQuery(sql,"上次调息的docid查询....");
		for(Map<String, String> rs:rs_list){
			doc_id = rs.get("doc_id");
		}
		logger.info("上次调息的docId...." + doc_id);
		//DaoUtil.closeRSOrConn(rs, conn);
		return doc_id;
	}

}
