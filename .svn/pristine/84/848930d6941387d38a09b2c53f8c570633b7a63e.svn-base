package com.tenwa.leasing.rentcalc.service.impl.evenrent;

import java.util.ArrayList;
import java.util.List;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.util.DateTools;
import com.tenwa.leasing.util.leasing.PlanDateTools;


/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-3
 * @desc TODO (todo-list 租金计划支付日期处理类)
 */
public class PlanDateServiceImpl {

	/**
	 * 
	 * TODO (todo-list todo-list 调用工具类，进行租金计划时间的计算)
	 * 
	 * @param cb
	 * @param rentListSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getPlanDateList(ConditionBean cb, String rentListSize) {
		List<String> date_List=new ArrayList<String>();
		//2011-11-14 因为多了一个第一期租金支付日 所以要特殊处理
		/*
		return PlanDateTools.getPlanDtList(rentListSize, cb.getPeriod_type(),
				"0", String.valueOf(12 / Integer.parseInt(cb
						.getIncome_number_year())), cb.getStart_date());
		 */
		//2011-11-17 在非正常的租金测算中(如变更,调息)都是构建虚拟的ConditionBean 进行的测算 这个时候不能让第一期租金支付日参与计算
		//因为没有额外的参数做判断,所以暂时认为如果是正常测算那么第一期租金支付日肯定在起租日之后反之则为非正常测算
		//2012-5-7 在ConditionBean 中添加了字段isChangeDate 来限定是否进行租金计划的支付日平移
		//if(DateTools.dateDiff("day", cb.getStart_date(), cb.getColumn_6())>0&&cb.isChangeDate()){
		//[KEY:scl-A]2012-11-21只要第一期租金支付日和起租日不相同就应该进入
//		if(DateTools.dateDiff("day", cb.getStart_date(), cb.getColumn_6())!=0&&cb.isChangeDate()){
//			//用第一期租金支付日算
//			String star_date=cb.getColumn_6();
//			//因为第一期租金支付日就是 实际上的第一期租金的支付日期  所以为了调用后面的方法要把他倒推成起租日
//			if(cb.getPeriod_type().equals("0")){//期末的话要往前推一期
//				star_date=DateTools.dateAdd("month", 0-12/Integer.parseInt(cb.getIncome_number_year()), star_date);
//			}
//			date_List=PlanDateTools.getPlanDtList(rentListSize, cb.getPeriod_type(),
//				"0", String.valueOf(12 / Integer.parseInt(cb.getIncome_number_year())), star_date);
//			//根据起租日修改最后一期租金支付日
//			System.out.println("||||||"+cb.getLease_term());
//			if(cb.getPeriod_type().equals("1")){//期初的话要往前推一期
//				star_date=DateTools.dateAdd("month", Integer.parseInt(cb.getLease_term())-12 / Integer.parseInt(cb.getIncome_number_year()), cb.getStart_date());
//			}else if(cb.getPeriod_type().equals("0")){
//				star_date=DateTools.dateAdd("month", Integer.parseInt(cb.getLease_term()), cb.getStart_date());
//			}
//			date_List.set(date_List.size()-1, star_date);
//		}else{
//			date_List=PlanDateTools.getPlanDtList(rentListSize, cb.getPeriod_type(),
//					"0", String.valueOf(12 / Integer.parseInt(cb
//							.getIncome_number_year())), cb.getStart_date());
//		}
//		return date_List;
		
		//[KEYY:scl-B]2013-3-15 按照上面的算法 如果客户强制要求期末支付且起租日和第一期租金支付日是同一天时,租金计划还是会按照起租日来算而不是按照第一期租金支付日算 所以做如下调整
		boolean dataRecokn=true;//默认按照起租日算 否则按照第一期租金支付日算  理论上这次修改之后就可以统一为所有的计算都按照第一期租金支付日算 但是为了兼容性和不可以预计性考虑还是保留两个算法
		if("".equals(cb.getStartDate())){
			if("".equals(cb.getFirstPlanDate())){
				return null;
			}else{
				dataRecokn=false;
			}
		}else{
			if(cb.isChangeDate()){
				dataRecokn=false;
			}
			if("".equals(cb.getFirstPlanDate())){
				dataRecokn=true;
			}
		}
		if(dataRecokn){
			date_List=PlanDateTools.getPlanDtList(rentListSize, cb.getPeriodType(),
					"0", String.valueOf(12 / Integer.parseInt(cb
							.getIncomeNumberYear())), cb.getStartDate());
		}else{
			//用第一期租金支付日算
			String star_date=cb.getFirstPlanDate();
			//因为第一期租金支付日就是 实际上的第一期租金的支付日期  所以为了调用后面的方法要把他倒推成起租日
			if(cb.getPeriodType().equals("0")){//期末的话要往前推一期
				star_date=DateTools.dateAdd("month", 0-12/Integer.parseInt(cb.getIncomeNumberYear()), star_date);
			}
			date_List=PlanDateTools.getPlanDtList(rentListSize, cb.getPeriodType(),
				"0", String.valueOf(12 / Integer.parseInt(cb.getIncomeNumberYear())), star_date);
			//根据起租日修改最后一期租金支付日
			System.out.println("||||||"+cb.getLeaseTerm());
			
			/** sea 2013-11-06 应甲方要求租金计划最后一期日期同之前偿还日期一致 因此以下几句代码占时注释掉，需求提出人：德银焦** ，修改批准：胡，执行人：sea
			if(cb.getPeriodType().equals("1")){//期初的话要往前推一期
				star_date=DateTools.dateAdd("month", Integer.parseInt(cb.getLeaseTerm())-12 / Integer.parseInt(cb.getIncomeNumberYear()), cb.getStartDate());
			}else if(cb.getPeriodType().equals("0")){
				star_date=DateTools.dateAdd("month", Integer.parseInt(cb.getLeaseTerm()), cb.getStartDate());
			}
			date_List.set(date_List.size()-1, star_date);
			 */
		}
		return date_List;
	}
}
