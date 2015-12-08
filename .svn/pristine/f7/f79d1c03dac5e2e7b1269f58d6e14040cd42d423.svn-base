package com.tenwa.leasing.renttranrate.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.InterContBean;
import com.tenwa.leasing.dao.Conn;
import com.tenwa.leasing.dao.DaoUtil;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.NumTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 调息时合同与央行调息记录相关的表信息操作)
 */
public class InteCtractDAOImpl {
	static Logger	logger	= Logger.getLogger(InteCtractDAOImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 调息时删除相应的央行与合同相对应的记录信息)
	 * 
	 * @param contract_id
	 * @param adjust_id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteInteCtractInfo(String contract_id, String adjust_id)
			throws Exception {

		Conn conn = new Conn();
		String sql = " delete fund_adjust_interest_c_temp where contract_id='"
				+ contract_id + "' and adjust_id='" + adjust_id + "'";

		conn.executeUpdate(sql,"删除调息时的合同与央行调息时的对应记录：" );
		DaoUtil.closeRSOrConn(null, conn);
		return true;

	}


	/**
	 * 
	 * TODO (todo-list todo-list 调息时添加相应的央行与合同相对应的记录信息)
	 * 
	 * @param icb
	 * @return
	 * @throws Exception
	 */
	public boolean addInteCtractInfo(InterContBean icb) throws Exception {

		Conn conn = new Conn();
		String sql = " INSERT INTO fund_adjust_interest_c_temp (contract_id";

		sql += ",adjust_id";
		sql += ",start_list";
		sql += ",rate_original";
		sql += ",rate_adjust";
		sql += ",creator";
		sql += ",create_date";
		sql += ",modificator";
		sql += ",modify_date";
		sql += ",old_irr";
		sql += ",new_irr";
		sql += ",old_plan_irr";
		sql += ",new_plan_irr ";
		sql += ",adjust_date ";
		sql += ",status ";
		sql += ",doc_id ";
		sql += ",mod_reason ";
		sql += ") VALUES ('";

		sql += icb.getContract_id() + "'";
		sql += ",'" + icb.getAdjust_id() + "'";
		sql += ",'" + icb.getStart_list() + "'";
		sql += ",'"
				+ NumTools.formatNumberDoubleScale(icb.getRate_original(), 6)
				+ "'";
		sql += ",'" + NumTools.formatNumberDoubleScale(icb.getRate_adjust(), 6)
				+ "'";
		sql += ",'" + icb.getCreator() + "'";
		sql += ",getdate()";
		sql += ",'" + icb.getCreator() + "'";
		sql += ",getdate()";
		sql += ",'" + NumTools.formatNumberDoubleScale(icb.getOld_irr(), 6)
				+ "'";
		sql += ",'" + NumTools.formatNumberDoubleScale(icb.getNew_irr(), 6)
				+ "'";
		sql += ",'"
				+ NumTools.formatNumberDoubleScale(icb.getOld_plan_irr(), 6)
				+ "'";
		sql += ",'"
				+ NumTools.formatNumberDoubleScale(icb.getNew_plan_irr(), 6)
				+ "','" + DateTools.getDBDateStr(icb.getAdjustDate()) + "'";

		sql += ",'否'";
		sql += ",'" + icb.getMeasure_id() + "'";
		sql += ",'调息'";
		sql += ")";

		conn.executeUpdate(sql,"添加调息时的合同与央行调息时的对应记录：" );
		DaoUtil.closeRSOrConn(null, conn);
		return true;

	}


	/**
	 * 
	 * TODO (todo-list todo-list 查询当前合同，当前期项所发生的变更与调息的记录(待修改确认...))
	 * 
	 * @param contract_id
	 * @param rent_list_start
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Hashtable searcherRecoder(String contract_id, String rent_list_start)
			throws Exception {
		Conn conn = new Conn();
		Hashtable ht = new Hashtable();
		List start_date = new ArrayList();
		List before_rate = new ArrayList();
		List after_rate = new ArrayList();
		String sql = "";

		// 由于涉及到租金变更同样也发生到同一期，故在此后须改成从视图中查询
		sql = " select rate_original,rate_adjust,adjust_date from fund_adjust_interest_contract where contract_id=(select id from contract_info where contract_id='"
				+ contract_id
				+ "') and start_list='"
				+ rent_list_start
				+ "'   order by id ";

		logger.info("查询当前合同在当前期数是否存在多次调息的记录：" + sql);
		
		List<Map<String, String>> rs_list = conn.executeQuery(sql);
		for(Map<String, String> rs:rs_list){
			start_date.add(rs.get("adjust_date"));
			before_rate.add(rs.get("rate_original"));
			after_rate.add(rs.get("rate_adjust"));
		}

		ht.put("start_date", start_date);
		ht.put("before_rate", before_rate);
		ht.put("after_rate", after_rate);

		return ht;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 添加调息合同相关联的记录)
	 * 
	 * @param contract_id
	 * @param adjust_id
	 * @param processId
	 * @param creator
	 * @param measure_id
	 * @return
	 * @throws Exception
	 */
	public boolean addInteCInfoFrmFactTb(String contract_id, String adjust_id,
			 String creator, String measure_id,String doc_id)
			throws Exception {

		Conn conn = new Conn();
		String sql = " INSERT INTO fund_adjust_interest_c_temp (contract_id";
		sql += ",adjust_id";
		sql += ",start_list";
		sql += ",rate_original";
		sql += ",rate_adjust";
		sql += ",creator";
		sql += ",create_date";
		sql += ",modificator";
		sql += ",modify_date";
		sql += ",old_irr";
		sql += ",new_irr";
		sql += ",old_plan_irr";
		sql += ",new_plan_irr";
		sql += ",doc_id";
		sql += ",adjust_date";
		sql += ",mod_reason";
		sql += ",status)";

		sql += " SELECT contract_id";
		sql += ",adjust_id";
		sql += ",start_list";
		sql += ",rate_adjust";
		sql += ",rate_original";
		sql += ",'" + creator + "'";
		sql += ","+DateTools.getSystemDate(1);
		sql += ",'" + creator + "'";
		sql += ","+DateTools.getSystemDate(1);
		sql += ",new_irr";
		sql += ",old_irr";
		sql += ",new_plan_irr";
		sql += ",old_plan_irr";
		sql += ",'" + measure_id + "'";
		sql += ",adjust_date";
		sql += ",'回滚'";
		sql += ",'否'";

		sql += " FROM fund_adjust_interest_contract where contract_id='"
				+ contract_id + "' and  doc_id='" + doc_id
				+ "' and adjust_id='" + adjust_id + "' ";

		logger.info("添加调息时的合同与央行调息时的对应记录（回滚时调用）：" + sql);
		conn.executeUpdate(sql);
		DaoUtil.closeRSOrConn(null, conn);
		return true;

	}


	/**
	 * 
	 * TODO (todo-list todo-list 调息时删除相应的央行与合同相对应的记录信息)
	 * 
	 * @param contract_id
	 * @param adjust_id
	 * @param measure_id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteInteCtractInfo(String contract_id, String adjust_id,
			String measure_id) throws Exception {

		Conn conn = new Conn();
		String sql = " delete fund_adjust_interest_c_temp where contract_id='"
				+ contract_id
				+ "' and adjust_id='"
				+ adjust_id
				+ "' and doc_id='" + measure_id + "' ";

		logger.info("删除调息时的合同与央行调息时的对应记录：" + sql);
		conn.executeUpdate(sql);
		DaoUtil.closeRSOrConn(null, conn);
		return true;

	}


	/**
	 * 
	 * TODO (todo-list todo-list 根据调息id查询是否存在一些合同在走流程)
	 * 
	 * @param adjust_id
	 * @return
	 * @throws SQLException
	 */
	public String getCountByAdjustId(String adjust_id,String doc_id) throws Exception {
		Conn conn = new Conn();
		String sql = " select count(*) ct from fund_adjust_interest_c_temp where adjust_id='"+adjust_id+"'  and status='否' and doc_id!='"+doc_id+"'";
		String count = "0";
		List<Map<String, String>> rs_list = conn.executeQuery(sql,"查询未走完流程的调息记录或回滚记录...");
		if(rs_list.size()>0){
			count = rs_list.get(0).get("ct");
		}
		return count;
	}
}
