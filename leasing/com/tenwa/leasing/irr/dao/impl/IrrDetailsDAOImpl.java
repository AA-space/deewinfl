package com.tenwa.leasing.irr.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.CashDetailsBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.dao.Conn;
import com.tenwa.leasing.dao.DaoUtil;
import com.tenwa.leasing.irr.dao.IrrDetailsDAO;
import com.tenwa.leasing.rent.dao.impl.ConditionDAOImpl;
import com.tenwa.leasing.util.NumTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-4
 * @desc TODO (todo-list Irr现金流明细DAO实现类)
 */
public class IrrDetailsDAOImpl
		implements IrrDetailsDAO {
	static Logger logger = Logger.getLogger(TbBeanTools.class);

	/**
	 * 
	 * TODO (todo-list todo-list 添加现金流明细记录)
	 * 
	 * @param tb
	 * @param cdsList
	 * @param tabName
	 *            所操作的表
	 * @return
	 * @throws Exception
	 */
	public boolean addCashDetails(TabCalBean tcb,
			List<CashDetailsBean> cdsList, String tabName) throws Exception {
		// TODO Auto-generated method stub
		Conn conn = new Conn();
		String sql = "";

		for (CashDetailsBean cdb : cdsList) {
			sql += "INSERT INTO " + tabName + " (id,"
					+ tcb.getContOrProjCName() + "";
			sql += ",onhire_id";
			sql += ",plan_date";
			sql += ",fund_in";
			sql += ",fund_in_details";
			sql += ",fund_out";
			sql += ",fund_out_details";
			sql += ",net_flow";
//			sql += ",creator";
//			sql += ",create_date";
			sql += "," + tcb.getDocIdCoulName() + ",quot_id";
			sql +=" )VALUES ('"+UUID.randomUUID().toString().replaceAll("-", "").toUpperCase()+"',";
			sql += "'" + tcb.getContOrProjCValue() + "'";
			sql += ",'" + tcb.getOnHire_id() + "'";
			sql += ",'" + cdb.getPlan_date() + "'";
			sql += "," + NumTools.formatNumberDoubleScale(cdb.getFund_in(), 2)
					+ "";
			sql += ",'" + (cdb.getFund_in_details().equals("")?"-":cdb.getFund_in_details()) + "'";
			sql += "," + NumTools.formatNumberDoubleScale(cdb.getFund_out(), 2)
					+ "";

			sql += ",'" + (cdb.getFund_out_details().equals("")?"-":cdb.getFund_out_details()) + "'";
			sql += "," + NumTools.formatNumberDoubleScale(cdb.getNet_flow(), 2)
					+ "";

//			sql += ",'" + tcb.getUserId() + "'";
//			sql += ",getdate()";
			sql += ",'" + tcb.getDocIdCoulValue() + "',";
			sql += "'" + tcb.getQuot_id() + "'";
			sql +=") ";

			conn.executeUpdate(sql,"流程类型:"+tcb.getCalType()+"添加现金流语句...");
			sql="";
		}
		DaoUtil.closeRSOrConn(null, conn);
		//如果是多次起租,那么现金流要做汇总 
		if(tcb.getCalType().equals("onHire_more_process")){
			TabCalBean tcb_cont = new TabCalBean();
			tcb_cont = TbBeanTools.getTabInfo("cont_process");
			tcb_cont.setOnHire_id(tcb.getOnHire_id());
			tcb_cont.setContOrProjCValue(tcb.getContOrProjCValue());
			tcb_cont.setDocIdCoulValue(tcb.getDocIdCoulValue());
			tcb_cont.setId_1(tcb.getId_1());
			tcb_cont.setId_2(tcb.getId_2());
			tcb_cont.setIs_merger(tcb.getIs_merger());// 传递是否合并计算
			tcb_cont.setUserId(tcb.getUserId());
			
			//判断要不要合并 第一次 发起多次起租流程的时候不需要合并 判断标准为 多次起租交易结构正式表中有没有这个合同的数据
			TabCalBean tempTcb=null;
			String wheresql="";
			ConditionBean cb=new ConditionBean();			
			tempTcb=TbBeanTools.getTabInfo("onHire_more_process");
			tempTcb.setTableToFormal();//转为正式表
			wheresql=tempTcb.getCondition_tb()+" where  "+tempTcb.getContOrProjCName()+"='"+
			tcb.getContOrProjCValue()+"'";
			cb=new ConditionDAOImpl().getConditionBeanByContract(wheresql,tempTcb);
			if(cb==null||cb.getEquipAmt().equals("")){//从多次起租正式交易结构表中没有查到数据
				logger.info("-----------------------------第一次起租,现金流不需要合并!");
				if (tabName.equals(tcb.getContractCashTb())) {
					tabName = tcb_cont.getContractCashTb();
				} else if (tabName.equals(tcb.getFinacCashTb())) {
					tabName = tcb_cont.getFinacCashTb();
				}
				deleteCashDetails(tcb_cont, tabName);//先删除
				return addCashDetails(tcb_cont, cdsList, tabName);
			} else {
				logger.info("进入现金流的合并!");
				return insertCashDetailsOnHire(tcb_cont, cdsList.get(0).getPlan_date().toString(), tabName);
			}
		}
		return true;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 删除现金流明细记录)
	 * 
	 * @param tb
	 * @param tabName
	 *            所操作的表
	 * @return
	 * @throws Exception
	 */
	public boolean deleteCashDetails(TabCalBean tcb, String tabName)
			throws Exception {
		Conn conn = new Conn();
		String sql = " delete " + tabName + " where "
				+ tcb.getContOrProjCName() + "='" + tcb.getContOrProjCValue()
				+ "' and " + tcb.getDocIdCoulName() + "='"
				+ tcb.getDocIdCoulValue() + "'";
		conn.executeUpdate(sql,"删除现金流sql..:");
		DaoUtil.closeRSOrConn(null, conn);
		return true;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 根据现金流配置信息构建明细)
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<CashDetailsBean> getcDetailsBySql(String sql,String quot_id) throws Exception {
		Conn conn = new Conn();
		List<Map<String, String>> rs_list  = conn.executeQuery(sql,"配置现金流构建..");

		List<CashDetailsBean> cdbList = new ArrayList<CashDetailsBean>();
		for (Map<String, String> rs:rs_list) {

			CashDetailsBean cdb = new CashDetailsBean();
			cdb.setContract_id(rs.get("corp"));
			cdb.setPlan_date(rs.get("sdate"));
			cdb.setQuot_id(quot_id);

			if ("in".equals(rs.get("inorout"))) {// 流入时

				cdb.setFund_in(rs.get("feename"));

				if (null != rs.get("feename")
						&& !"".equals(rs.get("feename"))
						&& Double.parseDouble(rs.get("feename")) > 0) {// 当费用大于0时
					cdb.setFund_in_details(rs.get("feenamedes") + "："
							+ NumTools.formatNumberDouble(Double.parseDouble(rs.get("feename")))+"；");
				}

				cdb.setFund_out("0");
				cdb.setFund_out_details("");

			} else {

				cdb.setFund_out(rs.get("feename"));

				if (null != rs.get("feename")
						&& !"".equals(rs.get("feename"))
						&& Double.parseDouble(rs.get("feename")) > 0) {// //当费用大于0时
					cdb.setFund_out_details(rs.get("feenamedes") + "："
							+ NumTools.formatNumberDouble(Double.parseDouble(rs.get("feename")))+"；");
				}

				cdb.setFund_in("0");
				cdb.setFund_in_details("");
			}

			cdb.setNet_flow(new BigDecimal(cdb.getFund_in()).subtract(
					new BigDecimal(cdb.getFund_out())).toString());
			cdbList.add(cdb);

		}

		logger.info("配置现金流构建成功..");
		//DaoUtil.closeRSOrConn(rs, conn);
		return cdbList;
	}

	/**
	 * 
	 * 多次起租时合并插入 在这里做的是字段相加,如果字段类型改变会导致相加之和数据有误
	 * 多次起租合并测算时
	 * @param tcb
	 * @param star_date 第一期租金计划日期
	 * @return
	 * @throws Exception
	 */
	public boolean insertCashDetailsOnHire(TabCalBean tcb, String star_date,
			String tabName) throws Exception {
		
		String addString="||";
		// 数据来源 合同正式表
		TabCalBean src_tcb_cont = TbBeanTools.getTabInfo("cont_process");
		src_tcb_cont.setTableToFormal();// 转换为正式表
		src_tcb_cont.setTableToView();// 转换为视图
		// 多次起租表
		TabCalBean onHire_tcb = TbBeanTools.getTabInfo("onHire_more_process");
		String src_tableName = "";// 用来查询的正式表
		String insert_table="";//用来插入的表
		if (tabName.equals(onHire_tcb.getContractCashTb())) {
			src_tableName = src_tcb_cont.getContractCashTb();
			insert_table=tcb.getContractCashTb();
		} else if (tabName.equals(onHire_tcb.getFinacCashTb())) {
			src_tableName = src_tcb_cont.getFinacCashTb();
			insert_table=tcb.getFinacCashTb();
		}
		String where1 = " where " + src_tcb_cont.getContOrProjCName() + "='"
				+ tcb.getContOrProjCValue() + "'";
		String where2 = " where " + tcb.getContOrProjCName() + "='"
				+ tcb.getContOrProjCValue() + "' and " + tcb.getDocIdCoulName()
				+ "='" + tcb.getDocIdCoulValue() + "'";
		if (!"".equals(tcb.getOnHire_id())) {
			where2 += " and onhire_id='" + tcb.getOnHire_id() + "'";
		}
		if (tcb.getIs_merger().equals("是")) {
			where1 += " and plan_date<='" + star_date + "'";;
		}
		// 删除
		deleteCashDetails(tcb, insert_table);
		// 插入
		String sql = "";
		sql += "INSERT INTO " + insert_table + " (id,"
				+ tcb.getContOrProjCName() + "";
		sql += ",onhire_id";
		sql += ",plan_date";
		sql += ",fund_in";
		sql += ",fund_in_details";
		sql += ",fund_out";
		sql += ",fund_out_details";
		sql += ",net_flow";
//		sql += ",creator";
//		sql += ",create_date";
		sql += "," + tcb.getDocIdCoulName() + ",quot_id";
		sql += " )";
		sql += "select '"+UUID.randomUUID().toString().replaceAll("-", "").toUpperCase()+"',"
				+ "case when con."+src_tcb_cont.getContOrProjCName()+" is null then onhire."+onHire_tcb.getContOrProjCName()
				+"else con."+src_tcb_cont.getContOrProjCName()+" end ) as contract_id,'"+tcb.getOnHire_id()+"'," +
						"cas when con.plan_date is null then  onhire.plan_date else con.plan_date end as plan_date"
				+ ",cas when con.fund_in is null then 0 else con.fund_in end +" +
						" case when onhire.fund_in is null then 0 else onhire.fund_in end as fund_in"
				+ ",case when con.fund_in_details is null then ' ' else con.fund_in_details  end+"+addString+"'　'"+addString+
				"case when onhire.fund_in_details is null then '' else onhire.fund_in_details end as fund_in_details"
				+ ",case when con.fund_out is null  then 0 else con.fund_out end +"+
				"case when onhire.fund_out is null then 0 else onhire.fund_out end  as fund_out"
				+ ",case when con.fund_out_details is null then '' else con.fund_out_details end "+addString+"'　'"+addString+
				"case when onhire.fund_out_details is null then '' else onhire.fund_out_details end as fund_out_details"
				+ ",case when con.net_flow is null then 0 else con.net_flow+case when onhire.net_flow is null 0 then onhire.net_flow end  as net_flow"
//				+ ",'" + tcb.getUserId() + "'"
//				+ ",getdate()"
				+ ",'" + tcb.getDocIdCoulValue() + "',"
				+ "'" + tcb.getQuot_id() + "'"
				+ " from ("
				+ " select "
				+ onHire_tcb.getContOrProjCName()+",onhire_id,plan_date,fund_in,fund_in_details,fund_out,fund_out_details,net_flow"
				+ " from "+tabName+where2
				+ ") as onhire "
				+ "FULL OUTER join("
				+ "select "
				+ src_tcb_cont.getContOrProjCName()+",onhire_id,plan_date,fund_in,fund_in_details,fund_out,fund_out_details,net_flow"
				+ " from "+src_tableName+where1
				+ ") as con on(onhire."+src_tcb_cont.getContOrProjCName()+"=con."+onHire_tcb.getContOrProjCName()+" and onhire.plan_date=con.plan_date)";
		Conn db = new Conn();
		db.executeUpdate(sql,"流程类型:"+tcb.getCalType()+"添加现金流语句...");
		DaoUtil.closeRSOrConn(null, db);
		return true;
	}
}
