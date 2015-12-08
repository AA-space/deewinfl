package com.tenwa.leasing.rentcalc.service.impl.evenrent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.util.NumTools;
import com.tenwa.leasing.util.leasing.InterestTools;
import com.tenwa.leasing.util.leasing.RateTools;
import com.tenwa.leasing.util.leasing.RentTools;

/**
 * 
 * @author SHIHONGFEI
 * @version 1.0
 * @copyright (C) TENWA 2011
 * @date 2011-3-3
 * @desc TODO (todo-list 租金测算利息计算类,如有宽限期，延迟期等利息特殊算法也在此类中重构方法来实现)
 */
public class InterestCalServiceImpl {

	private static Logger	logger	= Logger.getLogger(InterestCalServiceImpl.class);


	/**
	 * 
	 * TODO (正常租金测算 获得 利息list列表)
	 * @param rent_list
	 * @param leaseMoney
	 * @param calRate
	 * @param periodType
	 * @param sgrace
	 * @param Income_number_year
	 * @param endValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getInterestLsit(List rent_list, String leaseMoney,
			String calRate, String periodType, String sgrace,
			String Income_number_year,String endValue) {

		// 第一期的特别处理，包括期初期末等利息的特别处理

		// 用于保留利息
		List interests = new ArrayList();
		String corpus_total = "0";
		// 该期的利息
		String inte = "0";
		String corpus = "0";
		String corpus_overage = "0";
		// 本金余额,
		corpus_overage = new BigDecimal(leaseMoney).toString();

		// 1.根据年利率等信息，
		// 中的getPreRate得到测算的租金利率
		//logger.debug("合同租金计划利率:"+calRate);
		String preRate = RateTools.getPreRate(calRate, Income_number_year);
		//logger.debug("合同租金计划利率:"+preRate);
		// 得到宽限期利息
		int grace = getGraceInterest(sgrace, rent_list, interests);

		for (int i = grace; i < rent_list.size(); i++) {// 循环租金list

			if ("1".equals(periodType) && i == grace) {// 第一期且是期初时

				// 第一期利息计算，如有特别的计算则可在此写方法
				// firstCorpusAndInteCal(corpus, inte,
				// rent_list.get(i).toString());
				//期初时第一期本金的精度和租金的精度是一样的
				corpus = new BigDecimal(rent_list.get(i).toString()).setScale(RentTools.getRentAccuracy(), BigDecimal.ROUND_HALF_UP).toString();
				inte = "0";

			} else {

				// 利息
				inte = new BigDecimal(corpus_overage).multiply(
						new BigDecimal(preRate)).toString();// 剩余本金*利率

				// 本金, 租金-利息
				corpus = new BigDecimal(rent_list.get(i).toString()).subtract(
						new BigDecimal(inte)).toString();// 租金-利息
			}

			// 最后一期的利息=剩余的利息总合,本金仍然=租金-利息
			if (i == rent_list.size() - 1) {
				// 本金 --总的本金-以前的本金和-期末残值
				corpus = new BigDecimal(leaseMoney).subtract(
						new BigDecimal(corpus_total)).subtract(new BigDecimal(endValue)).toString();
				
				//2011-06-27修改
				//corpus = new BigDecimal(leaseMoney).subtract(new BigDecimal(corpus_total)).toString();
						//.subtract(new BigDecimal(endValue)).toString();

				// 利息
				inte = new BigDecimal(rent_list.get(i).toString()).subtract(
						new BigDecimal(corpus)).toString();

			}
			// 计算中的本金和
			corpus_total = new BigDecimal(corpus_total).add(
					new BigDecimal(corpus)).toString();

			// 本金余额
			corpus_overage = new BigDecimal(corpus_overage).subtract(
					new BigDecimal(corpus)).toString();

			// 添加list
			interests.add(inte);
			//logger.debug("合同第"+i+"利息:"+inte);
		}

		return interests;
	}

	/**
	 * 
	 * TODO ( 租金调整下的利息测算方法)
	 * @param rent_list 租金列表
	 * @param leaseMoney 最原始的测算本金,如果宽限期不调整则和corpusCon相同
	 * @param corpusCon 宽限期调整过之后的测算总本金
	 * @param year_rate 年利率集合
	 * @param periodType 期初/期末
	 * @param sgrace 宽限期
	 * @param Income_number_year 年还款次数
	 * @param endValue 期末残值
	 * @param obj 调整租金
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getInterestLsit(List rent_list, String leaseMoney,String corpusCon,
			List<String> year_rate, String periodType, String sgrace,
			String Income_number_year,String endValue,Object obj) {

		// 第一期的特别处理，包括期初期末等利息的特别处理

		// 用于保留利息
		List interests = new ArrayList();
		String corpus_total = "0";
		// 该期的利息
		String inte = "0";
		String corpus = "0";
		String corpus_overage = "0";
		// 本金余额, 
		corpus_overage = new BigDecimal(corpusCon).toString();//9950

		// 1.根据年利率等信息，
		// 中的getPreRate得到测算的租金利率
		String preRate ="";// RateTools.getPreRate(calRate, Income_number_year);

		// 得到宽限期利息
		int grace = Integer.parseInt(sgrace);
		interests=getGraceInterest(year_rate,leaseMoney , RentTools.getAdjustRentList(obj), grace,Income_number_year);
		leaseMoney=corpus_overage;//9950
		for (int i = grace; i < rent_list.size(); i++) {// 循环租金list
			preRate=RateTools.getPreRate(year_rate.get(i), Income_number_year);
			if ("1".equals(periodType) && i == grace) {// 第一期且是期初时

				// 第一期利息计算，如有特别的计算则可在此写方法
				// firstCorpusAndInteCal(corpus, inte,
				// rent_list.get(i).toString());

				corpus = rent_list.get(i).toString();
				inte = "0";

			} else {

				// 利息
				inte = new BigDecimal(corpus_overage).multiply(
						new BigDecimal(preRate)).toString();// 剩余本金*利率

				// 本金, 租金-利息
				corpus = new BigDecimal(rent_list.get(i).toString()).subtract(
						new BigDecimal(inte)).toString();// 租金-利息
			}

			// 最后一期的利息=剩余的利息总合,本金仍然=租金-利息
			if (i == rent_list.size() - 1) {
				// 本金 --总的本金-以前的本金和-期末残值
				corpus = new BigDecimal(leaseMoney).subtract(
						new BigDecimal(corpus_total)).subtract(new BigDecimal(endValue)).toString();
				
				//2011-06-27修改
				//corpus = new BigDecimal(leaseMoney).subtract(new BigDecimal(corpus_total)).toString();
						//.subtract(new BigDecimal(endValue)).toString();

				// 利息
				inte = new BigDecimal(rent_list.get(i).toString()).subtract(
						new BigDecimal(corpus)).toString();

			}
			// 计算中的本金和
			corpus_total = new BigDecimal(corpus_total).add(
					new BigDecimal(corpus)).toString();

			// 本金余额
			corpus_overage = new BigDecimal(corpus_overage).subtract(
					new BigDecimal(corpus)).toString();

			// 添加list
			interests.add(inte);

		}

		return interests;
	}
	/**
	 * 
	 * TODO (todo-list todo-list 宽限期利息)
	 * 
	 * @param cb
	 * @param rent_list
	 * @param interests
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int getGraceInterest(String sgrace, List rent_list, List interests) {
		// 判断宽限期,计算宽限期利息
		int grace = Integer.parseInt(sgrace);
		for (int i = 0; i < grace; i++) {
			interests.add(rent_list.get(i));
		}
		return grace;
	}

	/**
	 * 
	 * TODO (租金调整下的宽限期利息方法)
	 * @param cb
	 * @param l_rent_adjust
	 * @param grace
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List getGraceInterest(List<String> year_rate,String corpus,List l_rent_adjust,int grace,String income_number_year) {
		List devGrace=new ArrayList();
		String preRate ="";
		//因为宽限期不多,就每一期单独计算
		/*for(int i=0;i<grace;i++){			
			devGrace.add(new BigDecimal(corpus).multiply(new BigDecimal(preRate)).toString());
			if(!l_rent_adjust.get(i).toString().equals("")){//如果调整就要计算剩余本金
				
				corpus=new BigDecimal(corpus).subtract(new BigDecimal(l_rent_adjust.get(i).toString())
				.subtract(new BigDecimal(corpus).multiply(new BigDecimal(preRate)))).toString();				
			}
		}
		//cb.setCalTotalByCont(corpus);//宽限期之后的本金总值
		return devGrace;
		*/
		//2011-11-14 宽限期调整 不对后续测试有任何影响
		for(int i=0;i<grace;i++){
			preRate=RateTools.getPreRate(year_rate.get(i), income_number_year);
			if(l_rent_adjust.get(i).toString().equals("")){
				devGrace.add(new BigDecimal(corpus).multiply(new BigDecimal(preRate)).toString());
			}else{
				devGrace.add(l_rent_adjust.get(i).toString());
			}
		}
		return devGrace;
	}

	/**
	 * 
	 * TODO (todo-list todo-list 第一期本金与利息计算时)
	 * 
	 * @param corpus
	 * @param inte
	 * @param rent
	 */
	private void firstCorpusAndInteCal(String corpus, String inte, String rent) {
		corpus = rent;
		inte = "0";
	}


	 /**
		 * 
		 * TODO (todo-list todo-list 得到财务利息列表)
		 * 
		 * @param cb
		 * @param rent_list
		 * @param leaseMoney
		 * @return
		 */
	@SuppressWarnings("unchecked")
	public List getFinacInterestLsit(ConditionBean cb, List rent_list,
			String leaseMoney) {
		//[KEY:scl]2012-12-24 因为出现 手续费分摊在后面过高 所以采用 不包含宽限期的隐藏IRR做本息计算 所以在宽限期的时候 不分摊手续费
//		String preRate = RateTools.getPreRate(cb.getPlan_irr(), cb
//				.getIncome_number_year());
		String preRate = RateTools.getPreRate(cb.getNoGraceIRR(), cb.getIncomeNumberYear());		
		logger.info("财务利率：" + cb.getNoGraceIRR()+"总本金:"+leaseMoney+"计算利率：" + preRate);

		// 用于保留利息
		List interests = new ArrayList();
		String corpus_total = "0";
		// 该期的利息
		String inte = "0";
		String corpus = "0";
		String corpus_overage = "0";
		// 本金余额
		corpus_overage = new BigDecimal(leaseMoney).toString();

		//[KEY:scl]2012-12-24 手续费分摊比例
		BigDecimal rent_total=new BigDecimal(NumTools.getSumCorpusOverage(rent_list, 1)).multiply(new BigDecimal(cb.getGraceMultiply()));
		for (int i = 0; i < rent_list.size(); i++) {// 循环租金list

			if ("1".equals(cb.getPeriodType()) && i == 0) {// 第一期且是期初时
				// 第一期利息计算，如有特别的计算则可在此写方法调用
				corpus = rent_list.get(i).toString();
				inte = "0";				
			} else {
				if(Integer.parseInt(cb.getGrace())>i){//在会计租金计划中宽限期的利息就等于租金
					//利息=租金+手续/总期数[key:scl]马经理调整的在宽限期中手续费分摊额为手续/总期数
//					inte=new BigDecimal(rent_list.get(i).toString()).add(
//							new BigDecimal(cb.getHandling_charge_money()).divide(
//									new BigDecimal(cb.getIncome_number()).add(new BigDecimal(cb.getGrace())),
//									20,BigDecimal.ROUND_HALF_UP)).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
					//[KEY:scl]2012-12-24 款期限的手续费分摊为 租金/总租金*手续费
					inte=new BigDecimal(rent_list.get(i).toString()).add(
							new BigDecimal(rent_list.get(i).toString()).divide(rent_total,20, BigDecimal.ROUND_HALF_UP)
							.multiply(new BigDecimal(cb.getHandlingChargeMoney()))
							).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
				}else{
					// 利息
					inte = new BigDecimal(corpus_overage).multiply(
						new BigDecimal(preRate)).setScale(RentTools.getInterestAccuracy(), BigDecimal.ROUND_HALF_UP).toString();// 剩余本金*利率
				}
				// 本金, 租金-利息
				corpus = new BigDecimal(rent_list.get(i).toString()).subtract(
						new BigDecimal(inte)).setScale(RentTools.getAccuracy(), BigDecimal.ROUND_HALF_UP).toString();// 租金-利息
			}

			// 最后一期的利息=剩余的利息总合,本金仍然=租金-利息
			if (i == rent_list.size() - 1) {
				// 本金 --总的本金-以前的本金和-期末残值
				corpus = new BigDecimal(cb.getCalTotalByFinac()).subtract(
						new BigDecimal(corpus_total)).subtract(new BigDecimal(cb.getPmtEndValue())).setScale(RentTools.getAccuracy(), BigDecimal.ROUND_HALF_UP).toString();
				//logger.info("cb.getPmtEndValue():财务利息："+cb.getPmtEndValue());
				
				//2011-06-27修改
				//corpus = new BigDecimal(leaseMoney).subtract(new BigDecimal(corpus_total)).toString();
						//.subtract(new BigDecimal(endValue)).toString();
				

				// 利息
				inte = new BigDecimal(rent_list.get(i).toString()).subtract(
						new BigDecimal(corpus)).setScale(RentTools.getAccuracy(), BigDecimal.ROUND_HALF_UP).toString();

			}
			// 计算中的本金和
			corpus_total = new BigDecimal(corpus_total).add(
					new BigDecimal(corpus)).setScale(RentTools.getAccuracy(), BigDecimal.ROUND_HALF_UP).toString();

			// 本金余额
			corpus_overage = new BigDecimal(corpus_overage).subtract(
					new BigDecimal(corpus)).setScale(RentTools.getAccuracy(), BigDecimal.ROUND_HALF_UP).toString();

			// 添加list
			interests.add(inte);
		}

		return interests;
	}

	/**
	 * 2013-1-6 孙传良  在计算会计利息的时候 采用财务利息加手续费分摊值来计算 会计利息
	 * @param cb 商务条件bean
	 * @param frpb  租金计划bean 本次测算出来的bean
	 * @param frpb_old  租金计划bean  数据库中bean 主要用于计算已分摊手续费
	 * @param startList 计算开始期项(调息和租金计划变更的话就是对于的开始期项,如果是租金测算就是1)
	 * @return 返回会计利息
	 */
	public List<String> getFinacInterestLsitNew(ConditionBean cb,FundRentPlanBean frpb,FundRentPlanBean frpb_old, int startList){
		List<String> interest=new ArrayList<String>();
		BigDecimal handling_charge_money_total=new BigDecimal(cb.getHandlingChargeMoney());//总手续费
		if(handling_charge_money_total.compareTo(BigDecimal.ZERO)==0){//偷懒做法,如果没有手续费就返回财务利息  因为 财务利息和会计利息就差在手续费上
			interest=new ArrayList<String>(frpb.getInterest_list());
		}else{//开始计算手续费分摊值
			List<String> handling_charge_money_share=new ArrayList<String>();
			handling_charge_money_share=new InterestTools().getHandlingChargeMoneyShare(cb, frpb,frpb_old, startList);
			for(int i=0;i<frpb.getInterest_list().size();i++){
				interest.add(NumTools.calculationStr(frpb.getInterest_list().get(i).toString()
						, handling_charge_money_share.get(i).toString()	, NumTools.ADD, 2));
			}
		}
		return interest;
	}
	/**
	 * 
	 * TODO scl 不规则租金调整,根据利率List和rent_list算每期的利息
	 * @param rent_list 租金集合
	 * @param year_rate_list 利率集合 需要转换为对应的租金间隔的利率
	 * @param leaseMoney 剩余本金
	 * @param calRate 精确小数位
	 * @param periodType 期初/期末
	 * @return interests 利息集合
	 */
	@SuppressWarnings("unchecked")
	public List getInterestLsit(List rent_list,List year_rate_list,
			String leaseMoney,String calRate,String periodType) {

		// 用于保留利息
		List interests = new ArrayList();
		String corpus_total = "0";
		// 该期的利息
		String inte = "0";
		String corpus = "0";
		String corpus_overage = "0";
		// 本金余额,
		corpus_overage = new BigDecimal(leaseMoney).toString();

		for (int i = 0; i < rent_list.size(); i++) {// 循环租金list
			// 第一期的特别处理，包括期初期末等利息的特别处理
			if ("1".equals(periodType)&&i==0) {// 第一期且是期初时

				// 第一期利息计算，如有特别的计算则可在此写方法
				// firstCorpusAndInteCal(corpus, inte,
				// rent_list.get(i).toString());

				corpus = rent_list.get(i).toString();
				inte = "0";

			} else {

				// 利息
				inte = new BigDecimal(corpus_overage).multiply(
						new BigDecimal(year_rate_list.get(i).toString())).toString();// 剩余本金*利率

				// 本金, 租金-利息
				corpus = new BigDecimal(rent_list.get(i).toString()).subtract(
						new BigDecimal(inte)).toString();// 租金-利息
			}

			// 最后一期的利息=剩余的利息总合,本金仍然=租金-利息
			if (i == rent_list.size() - 1) {
				// 本金 --总的本金-以前的本金和
				corpus = new BigDecimal(leaseMoney).subtract(
						new BigDecimal(corpus_total)).toString();

				// 利息
				inte = new BigDecimal(rent_list.get(i).toString()).subtract(
						new BigDecimal(corpus)).toString();

			}
			// 计算中的本金和
			corpus_total = new BigDecimal(corpus_total).add(
					new BigDecimal(corpus)).toString();

			// 本金余额
			corpus_overage = new BigDecimal(corpus_overage).subtract(
					new BigDecimal(corpus)).toString();

			// 添加list
			interests.add(inte);

		}

		return interests;
	}

	/**
	 *  scl
	 * TODO (todo-list todo-list 获得均息法下的利息列表 均息法 不区分期初期末的利息)
	 * @param leaseMoney 总本金
	 * @param lease_term 租赁期限
	 * @param Income_number 还款次数
	 * @param endValue 剩余本金
	 * @param calRate 年利率
	 * @param grace_list 宽限期内的利息值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getInterestLsit(String leaseMoney,String lease_term,String Income_number,String endValue,
			String calRate,List grace_list) {

		String interest="";
		if(Double.parseDouble(calRate)!=0){
			interest=(new BigDecimal(leaseMoney).subtract(new BigDecimal(endValue))).multiply(
				new BigDecimal(calRate).divide(new BigDecimal("100"))).multiply(
						new BigDecimal(lease_term).divide(new BigDecimal("12"),20,BigDecimal.ROUND_HALF_UP)).divide(
						new BigDecimal(Income_number),20,BigDecimal.ROUND_HALF_UP).setScale(
						RentTools.getInterestAccuracy(), BigDecimal.ROUND_HALF_UP).toString();//均息法下的利息值
		}else{
			interest="0.0";
		}
		for(int i=0;i<Integer.parseInt(Income_number);i++){
			grace_list.add(interest);
		}
		logger.debug("本金总额"+leaseMoney+"租赁期限"+lease_term+"还款次数"+Income_number+"利息"+interest);
		return grace_list;
	}
}
