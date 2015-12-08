package com.tenwa.leasing.rent.dao.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.AdjustBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.dao.Conn;
import com.tenwa.leasing.dao.DaoUtil;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.NumTools;
import com.tenwa.leasing.util.leasing.DictTools;
import com.tenwa.leasing.util.leasing.RentTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-2-17
 * @desc TODO (todo-list 公用的租金计划dao处理类,合同的)
 */

public class RentPlanContrCalDAOImpl {

	static Logger	logger	= Logger.getLogger(RentPlanContrCalDAOImpl.class);
	
	/**
	 * 
	 * TODO (todo-list todo-list 根据表信息，合同租金计划信息 添加合同租金计划信息)
	 * 
	 * @param fpb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public boolean addRentPlan(String tbName,FundRentPlanBean fpb, TabCalBean tcb,
			String startList, String rentScale) throws Exception {
		String sql = "";
		Conn conn = new Conn();

		if (fpb != null && fpb.getRent_list() != null
				&& fpb.getRent_list().size() > 0) {
			List rent_list = fpb.getRent_list();// 租金列表

			List planDate_list = fpb.getPlanDate_list();// 日期列表
			List corpus_list = fpb.getCorpus_list();// 本金列表
			List corpusOverage_list = fpb.getCorpusOverage_list();// 本金余额列表
			List interest_list = fpb.getInterest_list();// 利息列表
			List year_rate_list = new ArrayList();
			List rent_adjust = fpb.getRent_adjust_list();// 租金调整列

			int flag = 1;// 是否添加租金调整列
			if (null == rent_adjust
					|| (null != rent_adjust && rent_adjust.size() == 0)||rent_adjust.get(0)==null) {
				flag = 0;
			}
			if (fpb.getYear_rate_list_s() == null|| (null != fpb.getYear_rate_list_s() && fpb.getYear_rate_list_s().size() == 0)) {
				for (int i = 0; i < fpb.getRent_list().size(); i++) {
					year_rate_list.add(fpb.getYearRate_s());
				}
			} else {
				if( fpb.getYear_rate_list_s().size()!= fpb.getRent_list().size()){
					for (int i = fpb.getYear_rate_list_s().size()-1; i >=Integer.parseInt(startList)-1; i--) {
						year_rate_list.add(0, fpb.getYear_rate_list_s().get(i));
					}
				}else{
					year_rate_list = fpb.getYear_rate_list_s();
				}
				
			}
			//Column_1和Column_2 是均息法下的均息法本息,暂时只有在均息法的测算中会处理,
			//所以其他的地方直接赋值本息
			if(fpb.getColumn_1()==null||fpb.getColumn_1().size()==0){
				fpb.setColumn_1(fpb.getCorpus_list());
				fpb.setColumn_2(fpb.getInterest_list());
			}			
			for (int i =0; i < rent_list.size(); i++) {

				sql += " INSERT INTO " + tbName + " (";
				sql += " id,";
				sql += " " + tcb.getDocIdCoulName() + "";
				sql += "," + tcb.getContOrProjCName() + "";
				sql += ",rent_list";
				sql += ",plan_date";
				sql += ",rent";
				sql += ",corpus";
				sql += ",year_rate";
				sql += ",interest";
				sql += ",corpus_overage";
				if(!tbName.contains("fina")){
					//INTEREST_BUSINESS,CORPUS_BUSINESS
					sql += ",CORPUS_BUSINESS";
					sql += ",INTEREST_BUSINESS";
				}

//				sql += ",creator";
//				sql += ",create_date";
//				sql += ",modify_date";
//				sql += ",modificator";
//				sql += ",Column_1";
//				sql += ",Column_2";
//				sql += ",Column_3";
//				sql += ",Column_4";
//				sql += ",Column_5";
//				sql += ",Column_6";
//				sql += ",Column_7";
//				sql += ",Column_8";
//				sql += ",Column_9";
//				sql += ",Column_10";
				sql += ",quot_id";
				sql += ",onhire_id";
//				sql += ",id_1";
//				sql += ",id_2";
				if (flag > 0) {
					sql += ",rent_adjust";
				}
				sql += ") VALUES (";
				sql += "'" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() + "',";
				sql += "'" + tcb.getDocIdCoulValue() + "',";
				sql += "'" + tcb.getContOrProjCValue() + "',";
				sql += startList + ",";
				sql += "'" + planDate_list.get(i).toString() + "',";
				sql += NumTools.formatNumberDoubleScale(rent_list.get(i)
						.toString(), Integer.parseInt(rentScale))
						+ ",";
				sql += NumTools.formatNumberDoubleScale(corpus_list.get(i)
						.toString(), 2)
						+ ",";
				sql += NumTools.formatNumberDoubleScale(year_rate_list.get(i).toString(), 8)
						+ ",";
				sql += NumTools.formatNumberDoubleScale(interest_list.get(i)
						.toString(), 2)
						+ ",";
				sql += NumTools.formatNumberDoubleScale(corpusOverage_list.get(
						i).toString(), 2)
						+ ",";

//				sql += "'" + fpb.getCreator() + "',";
//				sql += "getdate(),";
//				sql += "'" + fpb.getModify_date() + "',";
//				sql += "'" + fpb.getModificator() + "',";
				
				if(!tbName.contains("fina")){
					sql += "'" + NumTools.formatNumberDoubleScale(fpb.getColumn_1().get(i).toString(),2) + "',";
					sql += "'" + NumTools.formatNumberDoubleScale(fpb.getColumn_2().get(i).toString(),2) + "',";
				}
//				sql += "'" + fpb.getColumn_3() + "',";
//				sql += "'" + fpb.getColumn_4() + "',";
//				sql += "'" + fpb.getColumn_5() + "',";
//				sql += "'" + fpb.getColumn_6() + "',";
//				sql += "'" + fpb.getColumn_7() + "',";
//				sql += "'" + fpb.getColumn_8() + "',";
//				sql += "'" + fpb.getColumn_9() + "',";
//				sql += "'" + fpb.getColumn_10() + "', ";
				sql += "'" + fpb.getQuot_id() + "', ";
				sql += "'" + tcb.getOnHire_id() + "' ";
//				sql += "'" + tcb.getId_1() + "', ";
//				sql += "'" + tcb.getId_2() + "' ";
				if (flag > 0) {
					sql += ",'"
							+ NumTools.formatNumberDoubleScale(rent_adjust.get(
									i).toString(), 2);
					sql += "'";
				}
				sql += ") ";

				startList = String.valueOf(Integer.parseInt(startList) + 1);
				conn.executeUpdate(sql,"流程类型:"+tcb.getCalType()+"|=====|table:"+tbName+"添加租金计划语句...");
				sql="";
			}
		}

		DaoUtil.closeRSOrConn(null, conn);
		//如果是多次起租,那么合同表租金计划要做汇总 
		if(tcb.getCalType().equals("onHire_more_process")){
			TabCalBean tcb_cont=new TabCalBean();
			tcb_cont=TbBeanTools.getTabInfo("cont_process");
			tcb_cont.setOnHire_id(tcb.getOnHire_id());
			tcb_cont.setContOrProjCValue(tcb.getContOrProjCValue());
			tcb_cont.setDocIdCoulValue(tcb.getDocIdCoulValue());
			tcb_cont.setId_1(tcb.getId_1());
			tcb_cont.setId_2(tcb.getId_2());
			tcb_cont.setIs_merger(tcb.getIs_merger());//传递是否合并计算
			//判断是操作合同租金计划还是会计租金计划
			if (tcb.getRentPlan_tb().equals(tbName)){
				logger.info("业务租金计划表的合并");
				return insertRentPlanOnHire(tcb_cont,fpb.getPlanDate_list().get(0).toString());
			}
			//如果是合并计算那么会计租金计划会重算不需要合并
			if (tcb.getRentFinaPlan_tb().equals(tbName)){
				logger.info("会计租金计划表的合并");
				return insertFinaRentPlanOnHire(tcb_cont,fpb.getPlanDate_list().get(0).toString());
			}
			
		}
		return true;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 根据表表信息对租金计划表进行删除操作)
	 * 
	 * @param tcb
	 * @param startList开始期项
	 * @return
	 * @throws Exception
	 */
	public boolean deleteRentPlan(String tbName,TabCalBean tcb, String startList)
			throws Exception {
		Conn conn = new Conn();
		String sql = " delete " + tbName + " where "
				+ tcb.getContOrProjCName() + "='" + tcb.getContOrProjCValue()
				+ "' and " + tcb.getDocIdCoulName() + "='"
				+ tcb.getDocIdCoulValue() + "' and rent_list>=" + startList;
		//报价编号
		if (tcb.getOnHire_id()!=null&&!"".equals(tcb.getOnHire_id())) {
			sql +=" and onhire_id='"+tcb.getOnHire_id()+"'";
		}
		//2011-04-07两id添加
		if (tcb.getId_1()!=null&&!"".equals(tcb.getId_1())) {
			sql +=" and id_1='"+tcb.getId_1()+"'";
		}
		if (tcb.getId_2()!=null&&!"".equals(tcb.getId_2())) {
			sql +=" and id_2='"+tcb.getId_2()+"'";
		}
		//logger.info("删除租金计划sql：" + sql);
		conn.executeUpdate(sql,"流程类型:"+tcb.getCalType()+"删除租金计划...");
		logger.info("删除租金计划成功....");
		DaoUtil.closeRSOrConn(null, conn);
		//如果是多次起租,那么合同表也要做同样的操作
		/*if(tcb.getCalType().equals("onHire_more_process")){
			TabCalBean tcb_cont=new TabCalBean();
			tcb_cont=TbBeanTools.getTabInfo("cont_process");
			tcb_cont.setContOrProjCValue(tcb.getContOrProjCValue());
			tcb_cont.setDocIdCoulValue(tcb.getDocIdCoulValue());
			deleteRentPlan(tcb_cont.getRentPlan_tb(), tcb_cont, startList);
			return true;
		}*/
		return true;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 根据表信息，从数据库中读取租金计划信息，合同的)
	 * 
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public FundRentPlanBean getRentAndDateByTcb(TabCalBean tcb, String startList)
			throws Exception {
		// TODO Auto-generated method stub
		FundRentPlanBean frpb = new FundRentPlanBean();
		Conn conn = new Conn();
		String sql = " select * from " + tcb.getRentPlan_tb() + " where "+ tcb.getContOrProjCName() + "='" + tcb.getContOrProjCValue();
		if(tcb.getDocIdCoulValue()!=null&&!tcb.getDocIdCoulValue().equals("")){
			sql+= "' and " + tcb.getDocIdCoulName() + "='"	+ tcb.getDocIdCoulValue() ;
		}
		sql+= "' and rent_list>=" + startList;

		//报价编号
		String where="";
		if (tcb.getOnHire_id()!=null&&!"".equals(tcb.getOnHire_id())) {
			where +=" and onhire_id='"+tcb.getOnHire_id()+"'";
		}
		//2011-04-07两id添加
		if (tcb.getId_1()!=null&&!"".equals(tcb.getId_1())) {
			where +=" and id_1='"+tcb.getId_1()+"'";
		}
		if (tcb.getId_2()!=null&&!"".equals(tcb.getId_2())) {
			where +=" and id_2='"+tcb.getId_2()+"'";
		}
		sql+=where+" order by plan_date asc";
		List<Map<String,String>> rs_list = conn.executeQuery(sql,"查询租金计划sql：");
		List planDate_list = new ArrayList(); // 租金计划日期
		List rent_list = new ArrayList(); // 租金列表
		List corpus_list = new ArrayList(); // 本金列表
		List corpusOverage_list = new ArrayList(); // 本金余额列表
		List interest_list = new ArrayList(); // 利息列表
		List rent_adjust_list = new ArrayList(); // 租金调整列表
		List corpus_finac_list = new ArrayList(); // 财务本金列表
		List corpusOverage_finac_list = new ArrayList(); // 财务本金余额列表
		List interest_finac_list = new ArrayList(); // 财务利息列表
		List year_rate_list = new ArrayList();// 年利率
		//均息法下的本息
		List column_1=new ArrayList();
		List column_2=new ArrayList();
		//while (rs.next()) 
		for(Map<String,String> rs : rs_list)
		{
			planDate_list.add(rs.get("plan_date"));
			rent_list.add(rs.get("rent"));
			corpus_list.add(rs.get("corpus"));
			corpusOverage_list.add(rs.get("corpus_overage"));
			interest_list.add(rs.get("interest"));
			rent_adjust_list.add(rs.get("rent_adjust"));
			//corpus_finac_list.add(rs.getString("corpus_finac"));
			//corpusOverage_finac_list.add(rs.getString("corpus_overage_finac"));
			//interest_finac_list.add(rs.getString("interest_finac"));
			year_rate_list.add(rs.get("year_rate"));
			column_1.add(rs.get("corpus_business"));
			column_2.add(rs.get("interest_business"));
		}
		frpb.setPlanDate_list(planDate_list);
		frpb.setRent_list(rent_list);
		frpb.setCorpus_list(corpus_list);
		frpb.setCorpusOverage_list(corpusOverage_list);
		frpb.setInterest_list(interest_list);
		frpb.setRent_adjust_list(rent_adjust_list);
		frpb.setCorpus_finac_list(corpus_finac_list);
		frpb.setCorpusOverage_finac_list(corpusOverage_finac_list);
		frpb.setInterest_finac_list(interest_finac_list);
		frpb.setYear_rate_list(year_rate_list);
		frpb.setColumn_1(column_1);
		frpb.setColumn_2(column_2);
		//DaoUtil.closeRSOrConn(rs, conn);
		return frpb;
	}


	/**
	 * 
	 * TODO (todo-list todo-list 添加租金计划到某张表)
	 * 
	 * @param toTb所要添加数据的表
	 * @param frTb从那张表提取数据
	 * @param wherefrsql源数据库的where条件
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public boolean addRentInfoBySql(String toTb, String frTb,
			String wherefrsql, Hashtable colHt) throws Exception {

		// 数据库操作对象
		Conn conn = new Conn();
		String sql = "INSERT INTO " + toTb + " (id,doc_id ";
		sql += ",contract_id";
		sql += ",rent_list";
		sql += ",plan_date";
		sql += ",rent";
		sql += ",rent_adjust";
		sql += ",corpus";
		sql += ",year_rate";
		sql += ",interest";
		sql += ",rent_overage";
		sql += ",corpus_overage";
		sql += ",interest_overage";
		sql += ",corpus_business";
		sql += ",interest_business";
//		sql += ",Column_3";
//		sql += ",Column_4";
//		sql += ",Column_5";
//		sql += ",Column_6";
//		sql += ",Column_7";
//		sql += ",Column_8";
//		sql += ",Column_9";
//		sql += ",Column_10";
		sql += ",quot_id ";
		sql += ",onhire_id ) ";
//		sql += ",id_1  ";
//		sql += ",id_2)  ";
		sql += "SELECT sys_guid(),'" + colHt.get("measure_id").toString() + "' ";
		sql += ", '" + colHt.get("contract_id").toString() + "'";
		sql += ",rent_list";
		sql += ",plan_date";
		sql += ",rent";
		sql += ",rent_adjust";
		sql += ",corpus";
		sql += ",year_rate";
		sql += ",interest";
		sql += ",rent_overage";
		sql += ",corpus_overage";
		sql += ",interest_overage";
		sql += ",corpus_business";
		sql += ",interest_business";
//		sql += ",Column_3";
//		sql += ",Column_4";
//		sql += ",Column_5";
//		sql += ",Column_6";
//		sql += ",Column_7";
//		sql += ",Column_8";
//		sql += ",Column_9";
//		sql += ",Column_10";
		sql += ",quot_id";
		sql += ",onhire_id  ";
//		sql += ",id_1  ";
//		sql += ",id_2  ";
		sql +=" FROM " + frTb + wherefrsql;

		conn.executeUpdate(sql,"添加租金计划 从表"+frTb+"到表"+toTb+" ");
		DaoUtil.closeRSOrConn(null, conn);
		return true;

	}


	/**
	 * 
	 * TODO (todo-list todo-list 现金流明细构建时查询租金计划信息)
	 * 
	 * @param tbName
	 * @param wheresql
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public FundRentPlanBean getRentInfoForCash(String tbName, String wheresql)
			throws Exception {

		FundRentPlanBean frp = new FundRentPlanBean();
		List planDateList = new ArrayList();
		List planRentList = new ArrayList();
		String sql = " select (case when rent is null then 0 else rent end) rent,plan_date from "
				+ tbName + " where " + wheresql;
		Conn conn = new Conn();
		List<Map<String,String>> rs_list = conn.executeQuery(sql,"租金计划现金流所需数据查询....");
		for(Map<String,String> rs:rs_list){
			planDateList.add(rs.get("plan_date"));
			planRentList.add(rs.get("rent"));
		}

		frp.setPlanDate_list(planDateList);
		frp.setRent_list(planRentList);
		//DaoUtil.closeRSOrConn(rs, conn);

		return frp;
	}


	/**
	 * 
	 * TODO (todo-list todo-list起租时的更新租金计划日期信息)
	 * 
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public boolean updateRentPlanDate(String tbName,TabCalBean tcb, String startList,
			List dateList) throws Exception {
		Conn conn = new Conn();

		String sql = "";

		for (int i = 0; i < dateList.size(); i++) {
			sql += "  update " + tbName + " set plan_date='"
					+ dateList.get(i).toString() + "' where "
					+ tcb.getContOrProjCName() + "='"
					+ tcb.getContOrProjCValue() + "' and "
					+ tcb.getDocIdCoulName() + "='" + tcb.getDocIdCoulValue()
					+ "' and rent_list=" + startList;
			//报价编号
			if (!"".equals(tcb.getOnHire_id())) {
				sql +=" and onhire_id='"+tcb.getOnHire_id()+"'";
			}
			//2011-04-07两id添加
			if (!"".equals(tcb.getId_1())) {
				sql +=" and id_1='"+tcb.getId_1()+"'";
			}
			if (!"".equals(tcb.getId_2())) {
				sql +=" and id_2='"+tcb.getId_2()+"'";
			}
			startList = String.valueOf(Integer.parseInt(startList)+1);
		}
		conn.executeUpdate(sql,tcb.getCalType(),"更新租金计划时间sql：");
		DaoUtil.closeRSOrConn(null, conn);
		//如果是多次起租,那么合同表也要做同样的操作
		if(tcb.getCalType().equals("onHire_more_process")){
			TabCalBean tcb_cont=new TabCalBean();
			tcb_cont=TbBeanTools.getTabInfo("cont_process");
			tcb_cont.setContOrProjCValue(tcb.getContOrProjCValue());
			tcb_cont.setDocIdCoulValue(tcb.getDocIdCoulValue());
			if (tcb.getRentPlan_tb().equals(tbName)){
				tbName=tcb_cont.getRentPlan_tb();
			}
			if (tcb.getRentFinaPlan_tb().equals(tbName)){
				tbName=tcb_cont.getRentFinaPlan_tb();
			}
			updateRentPlanDate(tbName, tcb_cont, startList, dateList);
			return true;
		}
		return true;
	}
	
	/**
	 * 业务租金计划合并
	 * 多次起租时合并插入 在这里做的是字段相加,如果字段类型改变会导致相加之和数据有误
	 * 多次起租合并测算时
	 * @param tcb
	 * @param star_date 第一期租金计划日期
	 * @return
	 * @throws Exception
	 */
	public boolean insertRentPlanOnHire(TabCalBean tcb,String star_date)throws Exception{
		
		//数据来源 合同正式表
		TabCalBean src_tcb_cont=TbBeanTools.getTabInfo("cont_process");
		src_tcb_cont.setTableToFormal();//转换为正式表
		src_tcb_cont.setTableToView();//转换为视图
		//构建查询汇总的表--正式表
		String table="(select plan_date,rent_list,rent,corpus,interest,corpus_overage,year_rate,rent_adjust,corpus_business,interest_business from "+
		src_tcb_cont.getRentPlan_tb()+" where "+src_tcb_cont.getContOrProjCName()+"='"+tcb.getContOrProjCValue()+"'";
		//如果是合并计算 那么正式表中起租日之后的 未回笼就不在加入合并
		if(tcb.getIs_merger().equals("是")){
			table+=" and (plan_date<'"+star_date+"' or status!='未回笼')";;
		}
		table+=") union all ";
		//多次起租表
		TabCalBean onHire_tcb=TbBeanTools.getTabInfo("onHire_more_process");
		table+="(select plan_date,rent_list,rent,corpus,interest,corpus_overage,year_rate,rent_adjust,corpus_business,interest_business from "+
		onHire_tcb.getRentPlan_tb()+" where "+tcb.getContOrProjCName()+"='"+tcb.getContOrProjCValue()+
		"' and "+tcb.getDocIdCoulName()+"='"+tcb.getDocIdCoulValue()+"'";
		//报价编号
		if (!"".equals(tcb.getOnHire_id())) {
			table +=" and onhire_id='"+tcb.getOnHire_id()+"'";
		}
		if (!"".equals(tcb.getId_1())) {
			table +=" and id_1='"+tcb.getId_1()+"'";
		}
		if (!"".equals(tcb.getId_2())) {
			table +=" and id_2='"+tcb.getId_2()+"'";
		}
		table+=")";
		//union 之后总汇总 这里要注意year_rate 为取平均数,因为 利率不同的不允许分次起租
		table="(select '"+tcb.getContOrProjCValue()+"' as "+tcb.getContOrProjCName()+
		",'"+tcb.getDocIdCoulValue()+"' as "+tcb.getDocIdCoulName()+
		",plan_date,sum(rent_list) as rent_list,sum(rent) as rent,sum(corpus) as corpus,sum(interest) as interest"+
		",sum(corpus_overage) as corpus_overage,avg(year_rate) as year_rate,sum(rent_adjust) as rent_adjust,"+
		"sum(corpus_business) as column_1,sum(interest_business) as column_2 from("+table+") as rs group by plan_date) as temp";
		//构建用来查询的bean
		TabCalBean select_tcb=TbBeanTools.getTabInfo("cont_process");
		select_tcb.setContOrProjCValue(tcb.getContOrProjCValue());
		select_tcb.setDocIdCoulValue(tcb.getDocIdCoulValue());
		select_tcb.setRentPlan_tb(table);
		FundRentPlanBean frpb =getRentAndDateByTcb(select_tcb,"1");
		//删除
		deleteRentPlan(tcb.getRentPlan_tb(), tcb, "1");
		frpb.setRent_adjust_list(null);//汇总不记录调整列
		//插入
		addRentPlan(tcb.getRentPlan_tb(), frpb, tcb, "1", RentTools.getRentAccuracy()+"");
		//因为在均息下本金在合并后有差异.所以要做最后一期的调整
		String sql="";
		String where="";
		sql="select sum(corpus_business) as column_1,max(rent_list) as rent_list,max(plan_date) as plan_date,min(plan_date) s_plan_date,max(plan_date) e_plan_date,count(id) as num from "+tcb.getRentPlan_tb();
		where=" where "+
		tcb.getContOrProjCName()+"='"+tcb.getContOrProjCValue()+"' and "+tcb.getDocIdCoulName()+"='"+tcb.getDocIdCoulValue()+"'";
		//报价编号
		if (!"".equals(tcb.getOnHire_id())) {
			where +=" and onhire_id='"+tcb.getOnHire_id()+"'";
		}
		if (!"".equals(tcb.getId_1())) {
			where +=" and id_1='"+tcb.getId_1()+"'";
		}
		if (!"".equals(tcb.getId_2())) {
			where +=" and id_2='"+tcb.getId_2()+"'";
		}
		Conn db=new Conn();
		
		List<Map<String,String>> rs_list =db.executeQuery(sql+where);
		String column_1="";
		String rent_list="";
		String end_date="";
		String leas_term="";
		String num="";
		for(Map<String,String> rs : rs_list){
			column_1=rs.get("column_1");
			rent_list=rs.get("rent_list");
			end_date=rs.get("plan_date");
			leas_term=DateTools.getDateDiffMonth(rs.get("s_plan_date"), rs.get("e_plan_date"))+"";
			num=rs.get("num");
			sql="select sum(corpus) as corpus from "+tcb.getRentPlan_tb();
			List<Map<String,String>> rs_inner_list =db.executeQuery(sql+where+" and rent_list<"+rent_list);
			for(Map<String,String> s_inner : rs_inner_list){
				String corpus=s_inner.get("corpus");
				sql="update "+tcb.getRentPlan_tb()+" set corpus="+column_1+"-"+corpus+where+" and rent_list="+rent_list;
				db.executeUpdate(sql);
				sql="update "+tcb.getRentPlan_tb()+" set interest=rent-corpus "+where+" and rent_list="+rent_list;
				db.executeUpdate(sql);
			}
		}
		//因为多次起租合并了contract_condition中的值 所有有一些字段要在有了合并的租金计划之后才能做更新
		sql="update "+tcb.getCondition_tb()+" set End_date='"+end_date+"',Lease_term="+leas_term+",Income_number="+num+"-grace"+where;
		db.executeUpdate(sql, "多次起租中在获得了汇总租金计划之后更新交易结构表");
		DaoUtil.closeRSOrConn(null, db);
		return true;
	}
	
	/**
	 * 会计租金计划合并
	 * 多次起租时合并插入 在这里做的是字段相加,如果字段类型改变会导致相加之和数据有误
	 * 多次起租合并测算时
	 * @param tcb
	 * @param star_date 第一期租金计划日期
	 * @return
	 * @throws Exception
	 */
	public boolean insertFinaRentPlanOnHire(TabCalBean tcb,String star_date)throws Exception{
		
		//数据来源 合同正式表
		TabCalBean src_tcb_cont=TbBeanTools.getTabInfo("cont_process");
		src_tcb_cont.setTableToFormal();//转换为正式表
		src_tcb_cont.setTableToView();//转换为视图
		//构建查询汇总的表--正式表
		String table="(select plan_date,rent_list,rent,corpus,interest,corpus_overage,year_rate,rent_adjust,corpus_business,interest_business from "+
		src_tcb_cont.getRentFinaPlan_tb()+" where "+src_tcb_cont.getContOrProjCName()+"='"+tcb.getContOrProjCValue()+"'";
		//如果是合并计算 那么正式表中起租日之后的 未回笼就不在加入合并
		if(tcb.getIs_merger().equals("是")){
			table+=" and (plan_date<'"+star_date+"' or status!='未回笼')";;
		}
		table+=") union all ";
		//多次起租表
		TabCalBean onHire_tcb=TbBeanTools.getTabInfo("onHire_more_process");
		table+="(select plan_date,rent_list,rent,corpus,interest,corpus_overage,year_rate,rent_adjust,corpus_business,interest_business from "+
		onHire_tcb.getRentFinaPlan_tb()+" where "+tcb.getContOrProjCName()+"='"+tcb.getContOrProjCValue()+
		"' and "+tcb.getDocIdCoulName()+"='"+tcb.getDocIdCoulValue()+"'";
		//报价编号
		if (!"".equals(tcb.getOnHire_id())) {
			table +=" and onhire_id='"+tcb.getOnHire_id()+"'";
		}
		if (!"".equals(tcb.getId_1())) {
			table +=" and id_1='"+tcb.getId_1()+"'";
		}
		if (!"".equals(tcb.getId_2())) {
			table +=" and id_2='"+tcb.getId_2()+"'";
		}
		table+=")";
		//union 之后总汇总 这里要注意year_rate 为取平均数,因为 利率不同的不允许分次起租
		table="(select '"+tcb.getContOrProjCValue()+"' as "+tcb.getContOrProjCName()+
		",'"+tcb.getDocIdCoulValue()+"' as "+tcb.getDocIdCoulName()+
		",plan_date,sum(rent_list) as rent_list,sum(rent) as rent,sum(corpus) as corpus,sum(interest) as interest"+
		",sum(corpus_overage) as corpus_overage,avg(year_rate) as year_rate,sum(rent_adjust) as rent_adjust,"+
		"sum(corpus_business) as column_1,sum(interest_business) as column_2 from("+table+") as rs group by plan_date) as temp";
		//构建用来查询的bean
		TabCalBean select_tcb=TbBeanTools.getTabInfo("cont_process");
		select_tcb.setContOrProjCValue(tcb.getContOrProjCValue());
		select_tcb.setDocIdCoulValue(tcb.getDocIdCoulValue());
		select_tcb.setRentPlan_tb(table);
		FundRentPlanBean frpb =getRentAndDateByTcb(select_tcb,"1");
		//删除
		deleteRentPlan(tcb.getRentFinaPlan_tb(), tcb, "1");
		frpb.setRent_adjust_list(null);//汇总不记录调整列
		//插入
		addRentPlan(tcb.getRentFinaPlan_tb(), frpb, tcb, "1", RentTools.getRentAccuracy()+"");
		//因为在均息下本金在合并后有差异.所以要做最后一期的调整
		String sql="";
		String where="";
		sql="select sum(corpus) as column_1,max(rent_list) as rent_list from "+tcb.getRentFinaPlan_tb();
		where=" where "+
		tcb.getContOrProjCName()+"='"+tcb.getContOrProjCValue()+"' and "+tcb.getDocIdCoulName()+"='"+tcb.getDocIdCoulValue()+"'";
		//报价编号
		if (!"".equals(tcb.getOnHire_id())) {
			where +=" and onhire_id='"+tcb.getOnHire_id()+"'";
		}
		if (!"".equals(tcb.getId_1())) {
			where +=" and id_1='"+tcb.getId_1()+"'";
		}
		if (!"".equals(tcb.getId_2())) {
			where +=" and id_2='"+tcb.getId_2()+"'";
		}
		Conn db=new Conn();
		List<Map<String,String>> rs_list =db.executeQuery(sql+where);
		for(Map<String,String> rs : rs_list){
			String column_1=rs.get("column_1");
			String rent_list=rs.get("rent_list");
			sql="select sum(corpus) as corpus from "+tcb.getRentFinaPlan_tb();
			List<Map<String,String>> rs_inner_list =db.executeQuery(sql+where+" and rent_list<"+rent_list);
			for(Map<String,String> rs_inner : rs_inner_list){
				String corpus=rs_inner.get("corpus");
				sql="update "+tcb.getRentFinaPlan_tb()+" set corpus="+column_1+"-"+corpus+where+" and rent_list="+rent_list;
				db.executeUpdate(sql);
				sql="update "+tcb.getRentFinaPlan_tb()+" set interest=rent-corpus "+where+" and rent_list="+rent_list;
				db.executeUpdate(sql);
			}
		}
		//DaoUtil.closeRSOrConn(null, db);
		return true;
	}
	
	/**
	 * 
	 * TODO 根据起租日 付租方式 租赁期限 更新 租金计划中的最后一期租金支付日
	 * @param tcb
	 */
	public void updateEndPlanDate(TabCalBean tcb){
		String sql="select start_date_,income_number_year,lease_term from "+tcb.getCondition_tb()
		+" where "+tcb.getContOrProjCName()+"='"+tcb.getContOrProjCValue()+"' and "+tcb.getDocIdCoulName()
		+"='"+tcb.getDocIdCoulValue()+"'";
		Conn db=new Conn();
		//ResultSet rs;
		String star_date="";
		try {
			List<Map<String,String>> rs_list =db.executeQuery(sql);
			ConditionBean cb=new ConditionBean();
			for(Map<String,String> rs : rs_list){
				cb.setStartDate(rs.get("start_date_"));
				cb.setIncomeNumberYear(rs.get("income_number_year"));
				cb.setLeaseTerm(rs.get("lease_term"));
				DictTools.getReversDict(cb);
				if (cb.getPeriodType().equals("1")) {
					star_date = DateTools.dateAdd("month",Integer.parseInt(cb.getLeaseTerm())- 12/ Integer.parseInt(cb.getIncomeNumberYear()), cb.getStartDate());
				} else if (cb.getPeriodType().equals("0")) {
					star_date = DateTools.dateAdd("month", Integer.parseInt(cb.getLeaseTerm()), cb.getStartDate());
				}
				sql="select max(rent_list)rent_list from "+tcb.getRentPlan_tb()
				+" where "+tcb.getContOrProjCName()+"='"+tcb.getContOrProjCValue()+"' and "+tcb.getDocIdCoulName()
				+"='"+tcb.getDocIdCoulValue()+"'";
				List<Map<String,String>>  rs_inner_list = db.executeQuery(sql);
				for(Map<String,String> rs_inner : rs_inner_list){
					sql="update "+tcb.getRentPlan_tb()+" set plan_date='"+star_date+"' where "+tcb.getContOrProjCName()+"='"+tcb.getContOrProjCValue()+"' and "+tcb.getDocIdCoulName()
				+"='"+tcb.getDocIdCoulValue()+"' and rent_list="+rs_inner.get("rent_list");
					db.executeUpdate(sql,"变更或者调息 根据起租日更新最后一期租金支付日");
				}
			}
		} catch (Exception e) {
			logger.error("变更或者调息 根据起租日更新最后一期租金支付日失败!");
			e.printStackTrace();
			e.toString();			
		}
	}
	
	/**
	 * 合同中途终止修改最后一期利息
	 * @param fpb
	 * @param adb
	 * @param tcb
	 * @throws Exception
	 */
	public void updateDataByRentList(FundRentPlanBean fpb,AdjustBean adb,TabCalBean tcb) throws Exception{
		String sql="update "+tcb.getRentPlan_tb()
		+" set  "
		+"  rent= "+fpb.getRent_list().get(adb.getAdjustList()-1)
		+" , interest= "+fpb.getInterest_list().get(adb.getAdjustList()-1)
		+" , Interest_Business= "+fpb.getInterest_list().get(adb.getAdjustList()-1)
		+" where "+ tcb.getContOrProjCName() + "='" + tcb.getContOrProjCValue();
		if(tcb.getDocIdCoulName()!=null&&!tcb.getDocIdCoulName().equals("")){
			sql+= "' and " + tcb.getDocIdCoulName() + "='"	+ tcb.getDocIdCoulValue()+"'" ;
		}
		sql+=" and rent_list ="+adb.getStartList();
		Conn db=new Conn();
		db.executeUpdate(sql, "合同中途终止修改最后一期利息");
		db.close();
	}
	
	
	/**
	 * 
	 * TODO (todo-list todo-list 根据表信息，合同租金计划信息 添加合同租金计划信息)
	 * 
	 * @param fpb
	 * @param tcb
	 * @return
	 * @throws Exception
	 */
	public boolean addRentPlanMonopolize(String tbName,FundRentPlanBean fpb, TabCalBean tcb, String startList, String rentScale) throws Exception {
		String sql = "";
		Conn conn = new Conn();

		if (fpb != null && fpb.getRent_list() != null
				&& fpb.getRent_list().size() > 0) {
			List rent_list = fpb.getRent_list();// 租金列表

			List planDate_list = fpb.getPlanDate_list();// 日期列表
			List corpus_list = fpb.getCorpus_list();// 本金列表
			List corpusOverage_list = fpb.getCorpusOverage_list();// 本金余额列表
			List interest_list = fpb.getInterest_list();// 利息列表
			List year_rate_list = new ArrayList();
			List rent_adjust = fpb.getRent_adjust_list();// 租金调整列

			int flag = 1;// 是否添加租金调整列
			if (null == rent_adjust
					|| (null != rent_adjust && rent_adjust.size() == 0)||rent_adjust.get(0)==null) {
				flag = 0;
			}
			if (fpb.getYear_rate_list_s() == null|| (null != fpb.getYear_rate_list_s() && fpb.getYear_rate_list_s().size() == 0)) {
				for (int i = 0; i < fpb.getRent_list().size(); i++) {
					year_rate_list.add(fpb.getYearRate_s());
				}
			} else {
				if( fpb.getYear_rate_list_s().size()!= fpb.getRent_list().size()){
					for (int i = fpb.getYear_rate_list_s().size()-1; i >=Integer.parseInt(startList)-1; i--) {
						year_rate_list.add(0, fpb.getYear_rate_list_s().get(i));
					}
				}else{
					year_rate_list = fpb.getYear_rate_list_s();
				}
				
			}
			//Column_1和Column_2 是均息法下的均息法本息,暂时只有在均息法的测算中会处理,
			//所以其他的地方直接赋值本息
			if(fpb.getColumn_1()==null||fpb.getColumn_1().size()==0){
				fpb.setColumn_1(fpb.getCorpus_list());
				fpb.setColumn_2(fpb.getInterest_list());
			}			
			for (int i =0; i < rent_list.size(); i++) {

				sql += " INSERT INTO " + tbName + " (";
				sql += " id,";
				sql += " " + tcb.getDocIdCoulName() + "";
				sql += "," + tcb.getContOrProjCName() + "";
				sql += ",rent_list";
				sql += ",plan_date";
				sql += ",rent";
				sql += ",corpus";
				sql += ",year_rate";
				sql += ",interest";
				sql += ",corpus_overage";
				sql += ",CORPUS_BUSINESS";
				sql += ",INTEREST_BUSINESS";
				sql += ",quot_id";
				sql += ",onhire_id";
				
				sql += ") VALUES (";
				sql += "'" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() + "',";
				sql += "'" + tcb.getDocIdCoulValue() + "',";
				sql += "'" + tcb.getContOrProjCValue() + "',";
				sql += startList + ",";
				sql += "'" + planDate_list.get(i).toString() + "',";
				sql += NumTools.formatNumberDoubleScale(rent_list.get(i)
						.toString(), Integer.parseInt(rentScale))
						+ ",";
				sql += NumTools.formatNumberDoubleScale(corpus_list.get(i)
						.toString(), 2)
						+ ",";
				sql += NumTools.formatNumberDoubleScale(year_rate_list.get(i).toString(), 8)
						+ ",";
				sql += NumTools.formatNumberDoubleScale(interest_list.get(i)
						.toString(), 2)
						+ ",";
				sql += NumTools.formatNumberDoubleScale(corpusOverage_list.get(
						i).toString(), 2)
						+ ",";
				sql += "'" + NumTools.formatNumberDoubleScale(corpus_list.get(i).toString(),2) + "',";
				sql += "'" + NumTools.formatNumberDoubleScale(interest_list.get(i).toString(),2) + "',";
				sql += "'" + fpb.getQuot_id() + "', ";
				sql += "'" + tcb.getOnHire_id() + "' ";
				
				sql += ") ";

				startList = String.valueOf(Integer.parseInt(startList) + 1);
				conn.executeUpdate(sql,"流程类型:"+tcb.getCalType()+"|=====|table:"+tbName+"添加租金计划语句...");
				sql="";
			}
		}

		DaoUtil.closeRSOrConn(null, conn);
		return true;
	}
	
	/**
	 * 
	 * <p>提前终止买断比例为100情况下，后续分摊为0的租金计划做删除操作...。</p>
	 * @author sea
	 * @param contract_id
	 * @param doc_id
	 */
	public void deleteContractFundRentPlan(String contract_id,String doc_id){
		String sql = "delete contract_fund_rent_plan_temp  where contract_id = '"+contract_id+"'  and doc_id = '"+doc_id+"' ";
		sql = sql + "  and rent <= 0  and corpus <= 0 and interest <= 0 ";
		Conn conn = new Conn();
		try {
			conn.executeUpdate(sql, "提前终止买断比例为100情况下，后续分摊为0的租金计划做删除操作...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void saveDataFromSql(String sql){
		Conn conn = new Conn();
		try {
			conn.executeUpdate(sql,"根据买断日期新增一期租金计划语句...");
			DaoUtil.closeRSOrConn(null, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * <p>取合同租金计划总记录数。</p>
	 * @author sea
	 * @param adb
	 * @return
	 * @throws Exception
	 */
	public Integer serchMaxNumber(AdjustBean adb) throws Exception{
		Integer maxlist = 0;
		Conn conn = new Conn();
		String sql = " select nvl(count(a.contract_id),0) as maxlist from contract_fund_rent_plan a   ";
		sql = sql + " left join contract_info b on b.id = a.contract_id ";
		sql = sql + " where  b.contract_Id = '"+adb.getContractId()+"' ";
		List<Map<String,String>> rs = conn.executeQuery(sql, "合同终止情况下查询该合同的最大期项最为买断测算时的结束期项...");
		
		if(rs.size() > 0){
			Map<String,String> map = rs.get(0);
			maxlist = Integer.parseInt( map.get("maxlist") );
		}
		DaoUtil.closeRSOrConn(null, conn);
		
		return maxlist;
	}
}
