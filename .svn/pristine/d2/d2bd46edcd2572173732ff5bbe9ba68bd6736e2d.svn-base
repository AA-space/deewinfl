package com.tenwa.leasing.rentcharge.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.tenwa.leasing.rentcharge.dao.RentChargeDAO;
import com.tenwa.leasing.rentcharge.dao.impl.RentChargeDAOImpl;
import com.tenwa.leasing.rentcharge.service.RentChargeService;
import com.tenwa.leasing.util.BigTools;
import com.tenwa.leasing.util.LeasingException;
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
 * @desc        TODO (todo-list 正常租金变更现实主体类,通过对conditionbean和adjustbean的处理再调用租金测算类完成变更)
 */
public class RentChargeServiceImpl implements RentChargeService {

	Logger logger=Logger.getLogger(RentChargeServiceImpl.class);
	
	/**
	 * 正常租金变更现实主方法
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Hashtable rentChargeCal(AdjustBean adb,String calType,Hashtable ht,Object obj)throws Exception {
		logger.debug("进入变更主体方法:rentChargeCal");
		//保存AdjustBean
		RentChargeDAO rcd=new RentChargeDAOImpl();
		try{
			rcd.deleteAjust(adb);
		}catch (Exception e) {
			ht.put("isSucess", "false");
			//添加捕获到的错误信息
			List erro=new ArrayList();
			erro=(List)ht.get("error");
			erro.add("删除fund_rent_adjust出错:"+e.toString());
			ht.put("error", erro);
			return ht;
		}
		try{
			int ini=0;
			ini=rcd.addAjust(adb);
			if(ini==0){
				ht.put("isSucess", "false");
				List erro=new ArrayList();
				erro=(List)ht.get("error");
				erro.add("没有成功添加fund_rent_adjust记录!");
				ht.put("error", erro);
			}
		}catch (Exception e) {
			ht.put("isSucess", "false");
			//添加捕获到的错误信息
			List erro=new ArrayList();
			erro=(List)ht.get("error");
			erro.add("添加fund_rent_adjust出错:"+e.toString());
			ht.put("error", erro);
			return ht;
		}
		//获得condition表信息
		ConditionBean cdb=new ConditionBean();//交易结构表
		TabCalBean tcb=TbBeanTools.getTabInfo(calType, adb);
		String wheresql=tcb.getCondition_tb()+" where "+tcb.getContOrProjCName()
		+"='"+tcb.getContOrProjCValue()+"' and "+tcb.getDocIdCoulName()
		+"='"+tcb.getDocIdCoulValue()+"'";
		if(adb.getOnHireId()!=null&&!adb.getOnHireId().equals("")){
			wheresql+=" and onHire_id='"+adb.getOnHireId()+"'";
		}
		ConditionDAOImpl cddao=new ConditionDAOImpl();
		cdb=cddao.getConditionBeanByContract(wheresql,tcb);
		//宽限期 要临时存来下 在后续的变更中暂时无法确定是否会修改 且该值用于后续的计算还款次数
		
		int grace=0;
		if(cdb.getGrace()!=null){
			Integer.parseInt(cdb.getGrace());
		}
		//租金计划变更 或者提前结清不平移租金计划日期 2012-5-7
		cdb.setChangeDate(false);
		//转换为测算可用bean
		cdb=DictTools.getReversDict(cdb);
		//获得租金计划表信息
		FundRentPlanBean frpb=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb, "1");
		
		//设置frpb信息
		frpb.setModificator(adb.getCreator());
		frpb.setModify_date(new Date().toLocaleString());
		frpb.setYearRate(adb.getYearRate().toString());
		//将year_rate_list更新  只要移除保存时会自动更新
		frpb.setYear_rate_list(null);
		//调整时 要把租金调整列清空
		frpb.setRent_adjust_list(null);
		
		try{
			//根据变更表信息获取condition表信息
			cdb=AdjustTools.getConditionBeanByAdjustBean(cdb, adb, frpb);
		}catch (Exception e) {
			e.printStackTrace();
			List error=new ArrayList();
			ht.put("isSucess", "false");
			error=(List)ht.get("error");
			error.add("根据变更表信息获取condition表信息失败:"+e.toString());
			ht.put("error", error);
			return ht;
		}
		cdb.setFirstPlanDate(cdb.getStartDate());//修改第一期租金支付日为起租日		
		try{
			//调用租金测算的构建租金计划方法
			RentPlanContrCalServiceImpl rpcs=null;
			//等额租金法
			if ("even_rent".equals(cdb.getSettleMethod()) ){
				//为了让等额租金中覆盖这两个值所以要滞空  
				frpb.setColumn_1(null);
				frpb.setColumn_2(null);
				rpcs = new RentPlanContrCalServiceImpl();
			}else if ("even_interest".equals(cdb.getSettleMethod())){//均息法
				rpcs=new EvenInterestPlanContrCalServiceImpl();
			}else if("irregular_rent".equals(cdb.getSettleMethod())){//不规则
				//[KEY:scl]2013-1-8 如果是提前结清的话不规则按照等额租金法默认计算
				if(adb.getAdjustType().equals("his_contract_end")){//合同中途终止
					frpb.setColumn_1(null);
					frpb.setColumn_2(null);
					rpcs = new RentPlanContrCalServiceImpl();
				}else{
					rcd.deleteAjust(adb);//不允许变更就删除变更记录
					ht.put("isSucess", "false");
					List error=new ArrayList();
					error=(List)ht.get("error");
					error.add("\\n租金测算方法为不规则的租金计划不允许进行租金计划变更!\\n请在租金计划修改流程中实现相关操作!\\n已删除此次变更操作记录.");
					ht.put("error", error);
					return ht;
				}
			}
			
			/**
			 * sea注释：
			 * 1.约定终止日（买断日期）输入时间规则是大于等于今天
			 * 2.本金中途买断情况下，约定终止日（买断日期）与租金现有计划中冒一期日期不重合，则说明
			 * 需要租金计划中新增一行租金计划用于标识本金买断的情况，该行记录利息为0，后续租金计划需重新测算，
			 * 因新增一行租金计划会占用原本的还款周期中的一期，例如：买断日期之后存在10期还款，但是因为本金买断情况下需多增一期，
			 * 因此还款期数为11期，因此这里的开始日期做操作：cdb.setStartDate(frpb.getPlanDate_list().get(adb.getStartList()-2).toString());
			 * 原因是：从本金买断日期开始前去做完整的租金测算，这种情况下会进行正确的本利金拆分，拆分结束后，将多余的第一期使用本金买断的计划替换掉，
			 * 即为正确的完整的买断后租金计划
			 * 
			 * RentChargeDo类278行代码附件实现修改操作
			 */
			if(adb.getAdjustType().equals("his_contract_end") && !adb.getPaydayAdjust().equals( frpb.getPlanDate_list().get(adb.getStartList()-1) ) ){
				cdb.setStartDate(frpb.getPlanDate_list().get(adb.getStartList()-2).toString());
				frpb = rpcs.rentPlanCalByConditionAndTab(cdb, tcb,String.valueOf(adb.getStartList()+1), RentTools.getRentAccuracy()+"", frpb);
			}else{
				frpb = rpcs.rentPlanCalByConditionAndTab(cdb, tcb,String.valueOf(adb.getStartList()), RentTools.getRentAccuracy()+"", frpb);
			}
			
			//租金计划变更的时候单独修改第一期租金支付日			
			//new RentPlanContrCalDAOImpl().updateEndPlanDate(tcb);
		}catch (Exception e) {
			e.printStackTrace();
			List error=new ArrayList();
			ht.put("isSucess", "false");
			error=(List)ht.get("error");
			error.add("处理租金计划失败:"+e.toString());
			ht.put("error", error);
			return ht;
		}
		
		try{
			ht=new FinaPlanChargeServiceImpl().chargeFinaPlan(tcb, adb, cdb,frpb, ht);
		}catch (LeasingException e) {
			List error=new ArrayList();
			ht.put("isSucess", "false");
			error=(List)ht.get("error");
			error.add(e.getMessage());
			ht.put("error", error);
			return ht;
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
			//还原数据字典
			cdb.setIncomeNumber((adb.getAdjustList()-grace)+"");//还款次数要减去宽限期
			cdb.setLeaseTerm(String.valueOf(adb.getAdjustList()*(12/Integer.parseInt(cdb.getIncomeNumberYear()))));
			cdb.setYearRate(adb.getYearRate().toString());
			cdb=DictTools.getPersiDict(cdb);
			cddao.updateConditionIncomeNum(tcb,cdb);//更新
			//[KEY:scl-A]2012-12-6 租金计划变更的时候单独修改最后一期租金支付日 
			if(!adb.getAdjustType().equals("his_contract_end")){//[KEY:scl]2013-1-8合同中途终止不更新最后一期租金支付日
				new RentPlanContrCalDAOImpl().updateEndPlanDate(tcb);
			}
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
