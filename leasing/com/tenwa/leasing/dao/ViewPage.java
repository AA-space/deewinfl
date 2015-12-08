package com.tenwa.leasing.dao;

import java.sql.ResultSet;
import java.util.Hashtable;

import org.apache.log4j.Logger;

public class ViewPage {
	private Conn	db;
	private ResultSet	rs;
	private Logger		logger	= Logger.getLogger(ViewPage.class);
	
	public ViewPage(Conn db) {
		super();
		this.db = db;
	}

	/**
	 * 孙传良
	 * TODO (分页查询入口 通过type 值 调用不同的查询方式)
	 * @param param 
	 * 参数集合 Hashtable
	 * key=sql 为查询的SQL语句 
	 * key=orderby 为查询的排序字段
	 * key=page 为查询第几页
	 * key=pagesize 为每页显示多少条数据
	 * @param type 查询使用类型 
	 * 当为传入 ConstantBean.Query_Page_Proc 则用存储过程的方式
	 * 当为传入 ConstantBean.Query_Page_Local 则用本地写查询语句的方式
	 * @return 返回Hashtable 其中key=total_num_tenwa 可以取得总记录数 key=rs可以获得对应的结果集
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Hashtable executeQueryPage(Hashtable param,int type)throws Exception{
		String sql="";
		String orderby="";
		int page =0;
		int pagesize=0;
		try{
			sql=param.get("sql").toString();
			//logger.debug("sql:"+sql);
			orderby=param.get("orderby").toString();
			//logger.debug("orderby:"+orderby);
			page=Integer.parseInt(param.get("page").toString());
			//logger.debug("page:"+page);
			pagesize=Integer.parseInt(param.get("pagesize").toString());
			//logger.debug("pagesize:"+pagesize);
		}catch (Exception e) {
			logger.error("获取查询参数出错!");
			e.printStackTrace();
			return null;
		}
		if(sql.length()>4000){
			throw new Exception("sql参数长度超过4000!");
		}
		if(orderby.length()<1){
			throw new Exception("排序字段不能为空!");
		}
		if(page==0||pagesize==0){
			page=1;
			pagesize=15;
		}
		Hashtable ht=new Hashtable();
		try{
			switch (type) {
				case 1:
					try{
						//logger.debug("调用executeQueryPageProc方法进行分页查询!");
						ht=this.executeQueryPageProc(sql, orderby, page, pagesize);
					}catch(Exception e){
						//logger.info("调用executeQueryPageProc方法进行分页查询出错!尝试调用executeQueryPageLocal方法");
						ht=this.executeQueryPageLocal(sql, orderby, page, pagesize);
						e.printStackTrace();
					}
					break;
				case 2:
					try{
						//logger.debug("调用executeQueryPageLocal方法进行分页查询!");
						ht=this.executeQueryPageLocal(sql, orderby, page, pagesize);
					}catch(Exception e){
						//logger.info("调用executeQueryPageLocal方法进行分页查询出错!尝试调用executeQueryPageProc方法");
						ht=this.executeQueryPageProc(sql, orderby, page, pagesize);
						e.printStackTrace();
					}
					break;
				default:
					//logger.debug("没有传入查询类型!");
					try{
						//logger.debug("调用executeQueryPageLocal方法进行分页查询!");
						ht=this.executeQueryPageLocal(sql, orderby, page, pagesize);
					}catch(Exception e){
						//logger.info("调用executeQueryPageLocal方法进行分页查询出错!尝试调用executeQueryPageProc方法");
						ht=this.executeQueryPageProc(sql, orderby, page, pagesize);
						e.printStackTrace();
					}
					break;
			}
		}catch(Exception e){
			logger.error("分页查询出错,请检查SQL语句!");
			logger.error(e);
		}
		return ht;
	}
	
	/**
	 * 孙传良
	 * TODO (用于分页的独立查询  调用存储过程)
	 * @param sql 查询语句
	 * @param orderby 排序字段
	 * @param page 待显示页码
	 * @param num 每页显示条数
	 * @return Hashtable 其中key=total_num_tenwa 可以取得总记录数 key=rs可以获得对应的结果集
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Hashtable executeQueryPageProc(String sql,String orderby,int page ,int num) throws Exception {
		if(sql.length()>4000){
			throw new Exception("sql参数长度超过4000!");
		}
		if(orderby.length()<1){
			throw new Exception("排序字段不能为空!");
		}
		if(page==0||num==0){
			page=1;
			num=15;
		}
		Hashtable ht=new Hashtable();
		int intRowCount=0;
		String sql_t="";
		sql=sql.replaceAll("'","''");
		//logger.debug(sql_t);
		sql_t="exec dbo.goPage N'"+sql+"',N'"+orderby+"',"+page+","+num;
		//logger.debug(sql_t);
//		rs=db.executeQuery(sql_t);
//		if(rs.next()){
//			intRowCount=rs.getInt("total_num_tenwa");//读取总页数
//			rs.previous();//游标返回上一行
//		}
//		ht.put("total_num_tenwa", intRowCount);
//		ht.put("rs", rs);
		return ht;
	}
	
	/**
	 * 孙传良
	 * TODO (用于分页的独立查询  在JAVA类中做对应的查询)
	 * @param sql 查询语句
	 * @param orderby 排序字段
	 * @param page 待显示页码
	 * @param num 每页显示条数
	 * @return Hashtable 其中key=total_num_tenwa 可以取得总记录数 key=rs可以获得对应的结果集
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Hashtable executeQueryPageLocal(String sql,String orderby,int page ,int num) throws Exception {
		if(sql.length()>4000){
			throw new Exception("sql参数长度超过4000!");
		}
		if(orderby.length()<1){
			throw new Exception("排序字段不能为空!");
		}
		if(page==0||num==0){
			page=1;
			num=15;
		}
		Hashtable ht=new Hashtable();
		int intRowCount=0;
		String sql_temp="";
		sql_temp="select count(1) as total_num_tenwa from ("+sql+") as rs";
		//logger.debug(sql_temp);
//		rs=db.executeQuery(sql_temp);
//		if(rs.next()){
//			intRowCount=rs.getInt("total_num_tenwa");//读取总页数
//			if(intRowCount<((page-1)*num)){//如果总记录数小于当前页显示的数据就从第一页开始显示
//				page=1;
//			}
//			sql_temp="select * from (SELECT row_number() OVER (ORDER BY "+orderby+") AS row_num_tenwa,* from ("+
//			sql+") as table_tenwa) as rs_tenwa where row_num_tenwa>="+
//			((page-1)*num)+" and row_num_tenwa<"+(page*num+1);
//			//logger.debug(sql_temp);
//			rs=db.executeQuery(sql_temp);
//			ht.put("rs", rs);
//		}else{
//			ht.put("rs", rs);
//		}
		ht.put("total_num_tenwa", intRowCount);
		return ht;
	}
}
