package com.tenwa.leasing.irr.service.impl;

import java.util.List;

import com.tenwa.leasing.bean.CashConfigBean;
import com.tenwa.leasing.bean.CashDetailsBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.dao.IrrConfigDAO;
import com.tenwa.leasing.irr.dao.IrrDetailsDAO;
import com.tenwa.leasing.irr.dao.impl.IrrConfigDAOImpl;
import com.tenwa.leasing.irr.dao.impl.IrrDetailsDAOImpl;
import com.tenwa.leasing.irr.service.IrrDetailsService;
import com.tenwa.leasing.util.NumTools;
import com.tenwa.leasing.util.leasing.IrrTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-4
 * @desc TODO (todo-list 现金流明细实现类)
 */
public class IrrDetailsServiceImpl
		implements IrrDetailsService {

	/**
	 * 
	 * TODO (todo-list todo-list 根据配置信息整理配置现金流信息)
	 * 
	 * @param tcb
	 * @param occu_type
	 *            合同或者会计
	 * @return
	 * @throws Exception
	 */
	public List<CashDetailsBean> getCashDetailByCfg(TabCalBean tcb,
			String occu_type) throws Exception {

		// 配置现金流信息
		IrrConfigDAO icd = new IrrConfigDAOImpl();
		List<CashConfigBean> configList = icd.getConfigInfo(occu_type);
		// 根据配置现金流信息，读取相应的表数据构建配置现金流明细
		// 得到配置现金流所要执行的sql
	//	IrrCalServiceImpl icsi = new IrrCalServiceImpl();
		//String sql = icsi.getCfgCashSqlByCfgAndTb(configList, tcb);
		String sql = IrrTools.getCfgCashSqlByCfgAndTb(configList, tcb);

		IrrDetailsDAO idd = new IrrDetailsDAOImpl();
		return idd.getcDetailsBySql(sql,tcb.getQuot_id());
	}


	/**
	 * 
	 * TODO (todo-list todo-list 租金计划现金流明细构建)
	 * 
	 * @param frpb
	 * @param cdbList
	 * @param startList 开始期项
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CashDetailsBean> getCashDetailByRentPlan(FundRentPlanBean frpb,
			List<CashDetailsBean> cdbList,int startList) throws Exception {

		List rent_list = frpb.getRent_list();
		List date_list = frpb.getPlanDate_list();

		for (int i =startList-1; i < rent_list.size(); i++) {

			CashDetailsBean cdb = new CashDetailsBean();
			cdb.setContract_id(frpb.getProjOrCont());
			cdb.setPlan_date(date_list.get(i).toString());
			cdb.setQuot_id(frpb.getQuot_id());

			cdb.setFund_in(rent_list.get(i).toString());
			cdb.setFund_in_details("租金：" + NumTools.formatNumberDouble(Double.parseDouble(NumTools.formatNumberDoubleScale(rent_list.get(i).toString(),2))));

			cdb.setFund_out("0");
			cdb.setFund_out_details("");

			cdb.setNet_flow(rent_list.get(i).toString());
			cdbList.add(cdb);

		}

		return cdbList;
	}
}
