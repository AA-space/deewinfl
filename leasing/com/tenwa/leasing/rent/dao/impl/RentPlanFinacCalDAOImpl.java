package com.tenwa.leasing.rent.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.dao.Conn;
import com.tenwa.leasing.dao.DaoUtil;
import com.tenwa.leasing.util.NumTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-4
 * @desc TODO (todo-list 会计租金计划持久化操作)
 */
public class RentPlanFinacCalDAOImpl {
	static Logger	logger	= Logger.getLogger(RentPlanFinacCalDAOImpl.class);
	/**
	 * 
	 * TODO (todo-list todo-list 更新财务的租金计划)
	 * 
	 * @param fpb
	 * @param tcb
	 * @param startList
	 * @param rentScale
	 * @return
	 * @throws Exception
	 */
	public boolean updateRentPlan(FundRentPlanBean fpb, TabCalBean tcb,
			String startList, String rentScale) throws Exception {

		String sql = "";
		Conn conn = new Conn();

		if (fpb != null && fpb.getRent_list() != null
				&& fpb.getRent_list().size() > 0) {

			List corpus_list = fpb.getCorpus_finac_list();// 本金列表
			List corpusOverage_list = fpb.getCorpusOverage_finac_list();// 本金余额列表
			List interest_list = fpb.getInterest_finac_list();// 利息列表

			for (int i = 0; i < corpus_list.size(); i++) {

				sql += " UPDATE " + tcb.getRentPlan_tb()
						+ " SET ";
				sql += " corpus_finac ="
						+ NumTools.formatNumberDoubleScale(corpus_list.get(i)
								.toString(), 2) + ", ";
				sql += " interest_finac ="
						+ NumTools.formatNumberDoubleScale(interest_list.get(i)
								.toString(), 2) + ", ";
				sql += " corpus_overage_finac ="
						+ NumTools.formatNumberDoubleScale(corpusOverage_list
								.get(i).toString(), 2) + "";
				sql += " WHERE " + tcb.getDocIdCoulName() + "='"
						+ tcb.getDocIdCoulValue() + "' and "
						+ tcb.getContOrProjCName() + "='"
						+ tcb.getContOrProjCValue() + "' and rent_list='"
						+ startList + "'";
				//报价编号
				if (!"".equals(tcb.getOnHire_id())) {
					sql +=" and onhire_id='"+tcb.getOnHire_id()+"'";
				}
				startList = String.valueOf(Integer.parseInt(startList) + 1);

			}

		}

		conn.executeUpdate(sql,"流程类型:"+tcb.getCalType()+"更新财务租金计划:");
		DaoUtil.closeRSOrConn(null, conn);
		//如果是多次起租,那么合同表也要做同样的操作
		if(tcb.getCalType().equals("onHire_more_process")){
			TabCalBean tcb_cont=new TabCalBean();
			tcb_cont=TbBeanTools.getTabInfo("cont_process");
			tcb_cont.setContOrProjCValue(tcb.getContOrProjCValue());
			tcb_cont.setDocIdCoulValue(tcb.getDocIdCoulValue());
			updateRentPlan(fpb, tcb_cont, startList, rentScale);
			return true;
		}
		return true;
	}

}
