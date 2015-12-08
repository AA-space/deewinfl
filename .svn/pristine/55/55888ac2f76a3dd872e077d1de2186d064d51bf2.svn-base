package com.tenwa.leasing.util.leasing;



import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.AdjustBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.renttranrate.service.impl.ContrRentPlanServiceImpl;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.NumTools;

public class AdjustTools {
	static Logger logger = Logger.getLogger(AdjustTools.class);
	/**
	 * 
	 * TODO (更加Adjustbean把conditionbean重置)
	 * @param cdb conditionbean 交易结构bean 
	 * @param adb Adjustbean 租金变更bean 
	 * @param frpb FundRentPlanBean 租金计划bean 
	 * @return conditionbean 重置之后的交易结构bean 
	 * @throws Exception 
	 */
	public static ConditionBean getConditionBeanByAdjustBean(ConditionBean cdb,AdjustBean adb,FundRentPlanBean frpb) throws Exception{
		//重置cdb中信息
		//重置付款类型
		//cdb.setIncome_number_year(adb.getIncomeNumberYear());
		//重构宽限期
		int grace=Integer.parseInt(cdb.getGrace());
		if(grace-adb.getStartList()>=0){
			grace=grace-adb.getStartList()+1;
		}else{
			grace=0;
		}
		cdb.setGrace(grace+"");
		//重置付租方式
		ContrRentPlanServiceImpl crpsi=new ContrRentPlanServiceImpl();
		cdb.setPeriodType(crpsi.getPeroidType(adb.getStartList().toString(),cdb.getGrace(),cdb.getPeriodType()));
		//重构还款次数
		int income_number_year=Integer.parseInt(cdb.getIncomeNumberYear());
		cdb.setIncomeNumber(crpsi.getIncomeNumByAdjust(adb.getAdjustList().toString(), adb.getStartList().toString(), cdb.getGrace()));
		//重构租赁期限
		String incoms_num=NumTools.calculationStr(grace+"", cdb.getIncomeNumber(), NumTools.ADD, 0);
		cdb.setLeaseTerm(NumTools.calculationStr(12/income_number_year+"", incoms_num, NumTools.MULTIPLY, 0));
		//cdb.setLease_term(String.valueOf(adb.getAdjustList()*(12/income_number_year)));
		//重置起租日
		String start_date="";
		if(adb.getPaydayAdjust()==null||adb.getPaydayAdjust().equals("")){
			//如果变更调整中的日期为空,那么就以开始调整期数当期为起租日
			start_date=frpb.getPlanDate_list().get(adb.getStartList()-1).toString();
		}else{
			start_date=adb.getPaydayAdjust();
		}
		//cdb.setStart_date(start_date);
		String newStartDate = crpsi.getStartDate(cdb.getPeriodType(), start_date, 12/income_number_year);
		newStartDate = DateTools.getDBDateStr(newStartDate);
		cdb.setStartDate(newStartDate);
		//重置利率
		if(adb.getYearRate()!=null&&adb.getYearRate()>0){
			cdb.setYearRate(String.valueOf(adb.getYearRate()));
		}
		//剩余测算总本金 为开始调整(包括当期)之后的本金总和
		 String clean_lease_money="";
		 //2011-12-1 因为均息法和等额租金的剩余本金总额字段不一样所以要判断
		 if ("even_rent".equals(cdb.getSettleMethod()) ){
			 clean_lease_money=NumTools.getSumCorpusOverage(frpb.getCorpus_list(), adb.getStartList());
		 }else if ("even_interest".equals(cdb.getSettleMethod())){//均息法
			 clean_lease_money=NumTools.getSumCorpusOverage(frpb.getColumn_1(), adb.getStartList());
		 }else{//[KEY:scl-A]2012-11-22其他的方式默认为本金
			 clean_lease_money=NumTools.getSumCorpusOverage(frpb.getCorpus_list(), adb.getStartList());
		 }
		//2011-07-13修改 总本金+期末余值
		 clean_lease_money =NumTools.calculationStr(clean_lease_money, cdb.getEquipEndValue(), NumTools.ADD, 2);
		
		// 租金测算pmt公式后期测算代入的值,相当于期末残值,默认为0==设备残值+名义货价
		//cdb.setPmtEndValue("0");
		
		//2011-07-13修改
		cdb.setPmtEndValue(cdb.getEquipEndValue());
		
		//cdb.setPmtEndValue(String.valueOf(Double.parseDouble(cdb.getEquip_end_value())+Double.parseDouble(cdb.getNominal_price())));
		// 租金测总本金合同
		cdb.setCalTotalByCont(clean_lease_money);
		
		// 租金测总本金会计,2011-07-13修改 计算错误－－》应是财务本金之和＋期末余值
		//cdb.setCalTotalByFinac(String.valueOf(Double.parseDouble(clean_lease_money)+Double.parseDouble(cdb.getCaution_money())));
		//cdb.setCalTotalByFinac(NumTools.calculationStr(clean_lease_money, cdb.getEquip_end_value(), NumTools.ADD, 2));
		//2012-09-22 财务本金始终取值为财务本金字段不区分均息法和等额
		//cdb.setCalTotalByFinac(NumTools.calculationStr(NumTools.getSumCorpusOverage(frpb.getCorpus_list(), adb.getStartList()), cdb.getEquip_end_value(), NumTools.ADD, 2));
		//[KEY:scl-A]2012-11-19 会计租金计划用于测算的其实是财务本金,但是财务本金虽然取值为财务本金这一列,但是实际上上面说的财务本金字段应该是会计租金计划中的本金.
		//但是会计租金计划在后来的测算中已经分开为另一个表.所以这里要从新到会计租金计划中抓取本金值.
		FundRentPlanBean finacBean=new FundRentPlanBean();
		TabCalBean tcb=TbBeanTools.getTabInfo("cont_process", adb);
		tcb.setRentPlan_tb(tcb.getRentFinaPlan_tb());//将合同租金计划表设置为会计租金计划表
		finacBean=new RentPlanContrCalDAOImpl().getRentAndDateByTcb(tcb,"1");
		cdb.setCalTotalByFinac(NumTools.calculationStr(NumTools.getSumCorpusOverage(finacBean.getCorpus_list(), adb.getStartList()), cdb.getEquipEndValue(), NumTools.ADD, 2));
		logger.debug("变更测算本金"+cdb.getCalTotalByCont()+"财务本金:"+cdb.getCalTotalByFinac());
		
		return cdb;
	}
}
