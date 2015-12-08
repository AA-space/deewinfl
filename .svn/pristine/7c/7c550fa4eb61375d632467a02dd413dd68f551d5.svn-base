package com.tenwa.leasing.renttranrate.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.tenwa.leasing.dao.Conn;

/**
 * 
 * @author 孙传良
 * @version 2.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-21
 * @desc TODO 通过传入的合同号 判断 改合同是否满足调息或者变更的要求
 */
public class ConditionTranDAOImpl {

	static Logger	logger	= Logger.getLogger(ConditionTranDAOImpl.class);


	/**
	 * 
	 * 判断是否可以调息
	 * 
	 * @param contractId 合同号
	 * @param startList 开始期数
	 * @return 可以调息返回 true 否则返回 false
	 * @throws Exception
	 */
	public boolean isTransByContr(String contractId,String startList) throws Exception {

		logger.info("合同是否可调息的验证开始...");
		boolean a = false;
		a=isMoreYearRateContr(contractId, startList);
		if(a){//只要有一个为真就不能调息
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 
	 * 判断是否可以变更
	 * 
	 * @param contractId 合同号
	 * @return 可以返回 true 否则返回 false
	 * @throws Exception
	 */
	public boolean isChargeByContr(String contractId) throws Exception {

		logger.info("合同是否可调息的验证开始...");
		boolean a = false;
		boolean b = false;
		//[KEY:scl-A]2012-11-21 取消限制
		//a=isIrregularRentContr(contractId);
		//b=isMoreOnHireRentContr(contractId);
		if(a||b){//只要有一个为真就不能变更
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 
	 * TODO 判断该合同从指定期数之后的利率是不是同一个值
	 * @param contractId 合同号
	 * @param startList 开始期数
	 * @return 如果是 则放回 true 否则返回 false
	 * @throws Exception
	 */
	public boolean isMoreYearRateContr(String  contractId,String startList)throws Exception {
		boolean b = false;
		Conn conn = new Conn();
		String sql="";
		sql="select count(distinct year_rate) as num from contract_fund_rent_plan where contract_id='"+contractId+"' and rent_list>"+startList;
		List<Map<String, String>> rs_list  = conn.executeQuery(sql,"判断这个合同次期之后的利率是否一致!");
		for(Map<String, String> rs:rs_list){
			if(Integer.parseInt(rs.get("num"))>1){//不同利率大于1
				logger.info("合同：" + contractId + "不可以调息!因为从"+startList+"期之后利率有不同的值,无法进行调息.");
				b = true;
			}
		}
		return b;
	}
	/**
	 * 
	 * TODO 判断这个合同是不是不规则的租金测算方式 
	 * @param contractId 合同号
	 * @return 如果是 则放回 true 否则返回 false
	 */
	public boolean isIrregularRentContr(String  contractId)throws Exception {
		boolean b = false;
		Conn conn = new Conn();
		String sql="";
		sql="select * from contract_condition where contract_id='"+contractId+"' and settle_method='irregular_rent'";
		List<Map<String, String>> rs_list =conn.executeQuery(sql, "判断是不是不规则");
		if(!rs_list.isEmpty()){
			logger.info("合同：" + contractId + "的租金测算方式为不规则!");
			b = true;
		}
		//DaoUtil.closeRSOrConn(rs, conn);
		return b;
	}
	
	/**
	 * 
	 * TODO 判断这个合同是不是多次起租的合同
	 * @param contractId 合同号
	 * @return 如果是 则放回 true 否则返回 false
	 */
	public boolean isMoreOnHireRentContr(String  contractId)throws Exception {
		boolean b = false;
		Conn conn = new Conn();
		String sql="";
		sql="select * from onhire_condition where contract_id='"+contractId+"'";
		List<Map<String, String>> rs_list=conn.executeQuery(sql, "判断是不是多次起租的合同");
		if(!rs_list.isEmpty()){
			logger.info("合同：" + contractId + "为多次起租!");
			b = true;
		}
		//DaoUtil.closeRSOrConn(rs, conn);
		return b;
	}
}
