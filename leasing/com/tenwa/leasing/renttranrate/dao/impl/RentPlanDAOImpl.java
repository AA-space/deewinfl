package com.tenwa.leasing.renttranrate.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.tenwa.leasing.dao.Conn;
import com.tenwa.leasing.dao.DaoUtil;
import com.tenwa.leasing.util.NumTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO (todo-list 调息时租金计划操作DAO)
 */
public class RentPlanDAOImpl {
	static Logger	logger	= Logger.getLogger(RentPlanDAOImpl.class);


	/**
	 * 
	 * TODO (todo-list todo-list 根据合同号，调息开始日期处算出此次该合同调息的开始期项)
	 * 
	 * @param adjustDate
	 * @param contract_id
	 * @return
	 * @throws Exception
	 */
	public String getStartListByDate(String adjustDate, String contract_id)
			throws Exception {

		// 数据库操作对象
		Conn conn = new Conn();
		String sql = " select case when min(rent_list) is null then 0 else min(rent_list) end t from contract_fund_rent_plan where contract_id='"
				+ contract_id
				+ "' and plan_date>'"
				+ adjustDate
				//调息和回笼 没有关系 所以不需要有回笼状态的条件
				//+ "',120) and dbo.getPlanStatus(contract_id,rent_list)='未回笼'";
				+ "'";
		List<Map<String, String>> rs_list = conn.executeQuery(sql,"得到调息开始期项..:");
		String minRent_list = "";
		if(rs_list.size()>0){
			minRent_list = rs_list.get(0).get("t");
		}
		return minRent_list;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 查询当前期的利率值)
	 * 
	 * @param contract_id
	 * @param startList
	 * @return
	 * @throws Exception
	 */
	public String getCurrentYearRate(String contract_id, String startList)
			throws Exception {

		// 数据库操作对象
		Conn conn = new Conn();
		String sql = " select case when year_rate is null then 0 else year_rate end year_rate from contract_fund_rent_plan where contract_id='"
				+ contract_id
				+ "' and rent_list = " + startList+"+1";
		List<Map<String, String>> rs_list = conn.executeQuery(sql,"得到调息开始期项原利率:");
		String year_rate = "";
		if(rs_list.size()>0){
			year_rate = rs_list.get(0).get("year_rate");
		}
		return year_rate;
	}


	/**
	 * 2011-07-13修改添加参数equipEndValue期末余值
	 * TODO (todo-list todo-list 查询当前调息开始时的所有的测算本金)
	 * 
	 * @param contract_id
	 * @param startList
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public String getTotalCorpus(String tbName,String contract_id, String startList,
			String columnName,String doc_id,String equipEndValue) throws Exception {

		// 数据库操作对象
		Conn conn = new Conn();

		String sql = " select  sum(" + columnName
				+ ") scorpus from "+tbName+" where contract_id='"
				+ contract_id + "' and rent_list>='" + startList + "' and doc_id='"+doc_id+"'";
		List<Map<String, String>> rs_list =  conn.executeQuery(sql,"得到调息所测算的本金:" );
		String scorpus = "";
		if(rs_list.size()>0){
			scorpus = rs_list.get(0).get("scorpus");
			if(scorpus==null||scorpus.equals("")||scorpus.equals("null")){
				scorpus="0";
			}
		}
		//2011-07-13添加
		scorpus=NumTools.formatNumberDoubleScale(new BigDecimal(equipEndValue).add(new BigDecimal(scorpus)).toString(),2);
		return scorpus;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 查询当前期的利率值)
	 * 
	 * @param contract_id
	 * @param startList
	 * @return
	 * @throws Exception
	 */
	public String getCurrentPlanDate(String contract_id, String startList)
			throws Exception {

		// 数据库操作对象
		Conn conn = new Conn();
		String sql = " select plan_date from contract_fund_rent_plan where contract_id=(select id from contract_info where contract_id='"
				+ contract_id + "') and rent_list = " + startList;
		List<Map<String, String>> rs_list = conn.executeQuery(sql,"得到调息当前期的计划日期:");
		String plan_date = "";
		if(rs_list.size()>0){
			plan_date = rs_list.get(0).get("plan_date");
		}
		return plan_date;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 根据合同号，期项查询,查询条件查询出此期项的计划支付日期)
	 * 
	 * @param tbName
	 * @param wheresql
	 * @return
	 * @throws Exception
	 */
	public String getPlanDateByWhereSql(String tbName, String rentList,
			String wheresql) throws Exception {
		// 数据库操作对象
		Conn conn = new Conn();
		String sql = "select plan_date from "
				+ tbName + " where 1=1  and rent_list='" + rentList + "' "+wheresql;
		List<Map<String, String>> rs_list = conn.executeQuery(sql);
		String sDate = "";
		if(rs_list.size()>0){
			sDate = rs_list.get(0).get("plan_date");
		}
		return sDate;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 查询当前期的租金值)
	 * 
	 * 
	 * @param startList
	 * @param tbName
	 * @param whereSql
	 * @return
	 * @throws Exception
	 */
	public String getCurrentRent(String startList, String tbName,
			String whereSql) throws Exception {

		// 数据库操作对象
		Conn conn = new Conn();
		String sql = " select rent from " + tbName + " where "
				+ " rent_list = " + startList + whereSql;
		List<Map<String, String>> rs_list = conn.executeQuery(sql,"得到调息当前期的租金值:");
		String rent = "";
		if(rs_list.size()>0){
			rent = rs_list.get(0).get("rent");
			if(rent==null||rent.equals("")||rent.equals("null")){
				rent="0";
			}
		}
		return rent;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 更新调息当前期的租金值)
	 * 
	 * @param contract_id
	 * @param rent_list
	 * @param rent
	 * @param interest
	 * @param corpus
	 * @param corpusOverge
	 * @param year_rate
	 * @param tbName
	 * @param whereSql
	 * @param rentScale
	 * @return
	 * @throws Exception
	 */
	public boolean updateSignPlan(String contract_id, String rent_list,
			String rent, String interest, String corpus, String corpusOverge,
			String year_rate, String tbName, String whereSql, String rentScale)
			throws Exception {

		String sql = "";

		sql += "  update " + tbName + " set interest='"
				+ NumTools.formatNumberDoubleScale(interest, 2) + "',corpus='"
				+ NumTools.formatNumberDoubleScale(corpus, 2)

				+ "',rent='" + NumTools.formatNumberDoubleScale(rent, 2)
				+ "',year_rate='"
				+ NumTools.formatNumberDoubleScale(year_rate, 6)

				+ "',corpus_overage='"
				+ NumTools.formatNumberDoubleScale(corpusOverge, 2)
				+ "' where rent_list='" + rent_list + "' and contract_id='"
				+ contract_id + "' " + whereSql;

		Conn conn = new Conn();
		conn.executeUpdate(sql,"更新调息当前期的租金值:" );
		DaoUtil.closeRSOrConn(null, conn);
		return true;

	}
	
	
	

	/**
	 * 
	 * TODO (todo-list todo-list 查询当前期的剩余本金)
	 * 
	 * @param contract_id
	 * @param startList
	 * @return
	 * @throws Exception
	 */
	public String getCurrentCorpusOverage(String contract_id, String startList,String tbName,String whereSql)
			throws Exception {

		// 数据库操作对象
		Conn conn = new Conn();
		String sql = " select  corpus_overage from "+tbName+" where contract_id='"
				+ contract_id + "' and rent_list = " + startList+whereSql;
		List<Map<String, String>> rs_list = conn.executeQuery(sql,"得到调息当前期的剩余本金:");
		String corpus_overage = "";
		if(rs_list.size()>0){
			corpus_overage = rs_list.get(0).get("corpus_overage");
			if(corpus_overage==null||corpus_overage.equals("")||corpus_overage.equals("null")){
				corpus_overage="0";
			}
		}
		return corpus_overage;
	}


}
