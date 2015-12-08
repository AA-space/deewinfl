package com.tenwa.leasing.rentcharge.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.AdjustBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rent.dao.impl.ConditionDAOImpl;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.rentcalc.service.impl.eveninterest.EvenInterestPlanContrCalServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.RentPlanContrCalServiceImpl;
import com.tenwa.leasing.rentcharge.service.RentChargeService;
import com.tenwa.leasing.util.ArrayTools;
import com.tenwa.leasing.util.leasing.AdjustTools;
import com.tenwa.leasing.util.leasing.DictTools;
import com.tenwa.leasing.util.leasing.RentTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author      SCLICX
 * @version     1.0
 * @copyright   (C) Tenwa 2011
 * @date        Mar 28, 2011
 * @desc        TODO (todo-list 不规则租金变更现实主体类,通过对conditionbean和不规则租金list的处理再调用租金测算类完成变更)
 */
public class DeviRentChargeServiceImpl
		implements RentChargeService {
	Logger logger=Logger.getLogger(DeviRentChargeServiceImpl.class);
	@SuppressWarnings("unchecked")
	public Hashtable rentChargeCal(AdjustBean adb, String calType,
			Hashtable ht, Object obj) throws Exception {
		logger.debug("进入变更主体方法:rentChargeCal");
		
		ConditionBean cdb=new ConditionBean();//交易结构表
		TabCalBean tcb=TbBeanTools.getTabInfo(calType, adb);
		String wheresql=tcb.getCondition_tb()+" where "+tcb.getContOrProjCName()
		+"='"+tcb.getContOrProjCValue()+"' and "+tcb.getDocIdCoulName()
		+"='"+tcb.getDocIdCoulValue()+"'";
		ConditionDAOImpl cddao=new ConditionDAOImpl();
		cdb=cddao.getConditionBeanByContract(wheresql,tcb);
		//租金计划变更 或者提前结清不平移租金计划日期 2012-5-7
		cdb.setChangeDate(false);
		//转换为测算可用bean
		cdb=DictTools.getReversDict(cdb);
		//获得租金计划表信息 因为用租金计划来算剩余总本金 所以要查询全部的租金计划
		FundRentPlanBean frpb=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb, "1");
		//根据变更表信息获取condition表信息
		cdb=AdjustTools.getConditionBeanByAdjustBean(cdb, adb, frpb);
		frpb.setRent_adjust_list(ArrayTools.arrayToList((String [])obj));//租金调整列值
		
		try{
			
			//调用不规则租金测算的构建租金计划方法
			RentPlanContrCalServiceImpl rpcs=null;
			if ("even_rent".equals(cdb.getSettleMethod()) ){
				//为了让等额租金中覆盖这两个值所以要滞空 
				frpb.setColumn_1(null);
				frpb.setColumn_2(null);
				rpcs = new RentPlanContrCalServiceImpl();
			}else if ("even_interest".equals(cdb.getSettleMethod())){//均息法
				rpcs=new EvenInterestPlanContrCalServiceImpl();
			}else if("irregular_rent".equals(cdb.getSettleMethod())){//不规则
				ht.put("isSucess", "false");
				List error=new ArrayList();
				error=(List)ht.get("error");
				error.add("\\n租金测算方法为不规则的租金计划不允许进行租金计划变更!\\n请在租金计划修改流程中实现相关操作!\\n已删除此次变更操作记录.");
				ht.put("error", error);
				return ht;
			}
			frpb = rpcs.rentPlanCalByDevi(cdb, tcb, adb.getStartList()+"",RentTools.getRentAccuracy()+"", frpb,obj);
			//租金计划变更的时候单独修改第一期租金支付日
			//new RentPlanContrCalDAOImpl().updateEndPlanDate(tcb);
		}catch (Exception e) {
			e.printStackTrace();
			List error=new ArrayList();
			ht.put("isSucess", "false");
			error=(List)ht.get("error");
			error.add("调用不规则租金测算的构建租金计划方法失败:"+e.toString());
			ht.put("error", error);
			return ht;
		}
		
		try{
			ht=new FinaPlanChargeServiceImpl().chargeFinaPlan(tcb, adb, cdb,frpb, ht);
		}catch (Exception e) {
			e.printStackTrace();
			List error=new ArrayList();
			ht.put("isSucess", "false");
			error=(List)ht.get("error");
			error.add("处理会计租金计划或者现金流失败:"+e.toString());
			ht.put("error", error);
			return ht;
		}
		
		//转换为保存bean并保存
		try{
			//[KEY:scl-A]2012-11-21 在租金计划调整的时候如果在代码中已经更新过IRR等值 
			//则此处不需要删除再插入 否则会 在租金计划变更中做租金调整时丢失还租次数等值
			//cdb=DictTools.getPersiDict(cdb);
			//cddao.deleteCondition(tcb,cdb);//先删除
			//cddao.addCondition(cdb, tcb);//后保存
		}catch (Exception e) {
			e.printStackTrace();
			List error=new ArrayList();
			ht.put("isSucess", "false");
			error=(List)ht.get("error");
			error.add("转换为保存bean并先删后存失败:"+e.toString());
			ht.put("error", error);
			return ht;
		}
		ht.put("isSucess", "true");
		return ht;
	}

}
