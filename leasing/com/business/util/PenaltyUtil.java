package com.business.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
/**
 * 
 * @author 计算租罚息
 * 
 */
public class PenaltyUtil {
	private static Logger  log=Logger.getLogger(PenaltyUtil.class);
	/**
	 * 
	* @author 作者 xuyunlong
	* @version 创建时间：2013-10-29 下午07:22:54 
	* 参数rentplan:租金计划
	*    cur_date:计划罚息日
	*    rate:罚息利率
	*    freeDefaInterDay：免罚息天数据
	*    isRent：true以租金计算罚息 false以本金计算罚息
	 */
	public static List<BigDecimal> getRentPenalty(ContractFundRentPlan rentPlan,String cur_date, BigDecimal rate,int freeDefaInterDay,boolean isRent) {

		String plan_date=rentPlan.getPlanDate();//租金计划日期
		if("2014-06-15".equals(plan_date)){
			System.out.println("cur_date:"+cur_date+"<-rate->"+rate+"<-freeDefaInterDay->"+freeDefaInterDay);
		}
		
	     String hireDate="";//核销日期
	     List<BigDecimal> Penaltys=new ArrayList<BigDecimal>();
	     //计算租金计划日期和当前时间的时间差
		 long difC=Tools.dateDiff("day", plan_date, cur_date);
		 long difp=0;
		 BigDecimal bdifc=new BigDecimal(difC);
		 BigDecimal recieverpenalty= new BigDecimal(0.00);//实收罚息
		 BigDecimal penalty= new BigDecimal(0.00);//罚息
		 BigDecimal rentOver=rentPlan.getRent();//租金
		 Map<String,BigDecimal> rentincome=new HashMap<String,BigDecimal>();//时收
		 if (difC<=0 || difC<freeDefaInterDay){
			 //计划日期大于当前给定日期
			 Penaltys.add(BigDecimal.ZERO);
			 Penaltys.add(BigDecimal.ZERO);
		 }else{
		 if(rentPlan.getContractFundRentInComes().size()>0){
			//已经回笼过
			for(ContractFundRentInCome fc:rentPlan.getContractFundRentInComes()){
				//计划已回笼的罚息和罚息调整的合计
				if(fc.getPenalty().compareTo(BigDecimal.ZERO)>0 ){
					recieverpenalty = recieverpenalty.add(fc.getPenalty());
				}
				if(fc.getPenaltyAdjust().compareTo(BigDecimal.ZERO)>0){
					recieverpenalty = recieverpenalty.add(fc.getPenaltyAdjust());
				}
				//对回笼的租金进行按回笼日期计划合计并进行安排
				hireDate=fc.getHireDate();
				if(isRent==true){
				if(fc.getRent().compareTo(BigDecimal.ZERO)!=0){
				   if(rentincome.containsKey(hireDate)){
					   BigDecimal temp=rentincome.get(hireDate);
					   temp= temp.add(fc.getRent()).setScale(2, BigDecimal.ROUND_HALF_UP);
					   if(temp.compareTo(BigDecimal.ZERO)<=0){
						   rentincome.remove("hireDate");
					   }
					   rentincome.put(hireDate,temp);
				   }else{
					  rentincome.put(hireDate, fc.getRent().setScale(2, BigDecimal.ROUND_HALF_UP));
				   }
				}}else{
					if(fc.getCorpus().compareTo(BigDecimal.ZERO)!=0){
						   if(rentincome.containsKey(hireDate)){
							   BigDecimal temp=rentincome.get(hireDate);
							   temp= temp.add(fc.getCorpus()).setScale(2, BigDecimal.ROUND_HALF_UP);
							   if(temp.compareTo(BigDecimal.ZERO)<=0){
								   rentincome.remove("hireDate");
							   }
							   rentincome.put(hireDate,temp);
						   }else{
							  rentincome.put(hireDate, fc.getCorpus().setScale(2, BigDecimal.ROUND_HALF_UP));
						   }
						}	
				}
			 }	
				Set<String> hireDates=rentincome.keySet();
				TreeSet<String> TreehireDate=new TreeSet<String>(new Comparator<String>() {
					@Override	
					public int compare(String arg0, String arg1) {
						 long difC=Tools.dateDiff("day", arg0, arg1);
						 if(difC<0){return 1;}
						 if(difC>0){return -1;}
						 return 0;
					}
				});	
				TreehireDate.addAll(hireDates);
				Iterator<String> iterator=TreehireDate.iterator();
				log.debug(TreehireDate.toString());
				log.debug(rentincome.toString());
				//分段计算罚息
				 while(iterator.hasNext()){
					 hireDate=iterator.next().toString();
				   //  log.debug(plan_date+":"+hireDate+":"+cur_date);
					 difC=Tools.dateDiff("day", plan_date, hireDate);//核销时间和上次核销的时间的时间差
					 difp=Tools.dateDiff("day", hireDate, cur_date);
					 //当次核销时间上上次核销（或租金计划时间）和当前截止时间前
					 if(difC<=0){
						 rentOver=rentOver.subtract(rentincome.get(hireDate)).setScale(2, BigDecimal.ROUND_HALF_UP);;
					 }
					 //当次核销时间在上次核销（或租金计划时间）和当前截止时间之间
					 if(difC>0 && difp>=0){
							penalty= penalty.add(ComputerPenaltyByFomula(rentOver,rate,new BigDecimal(difC)));
					     rentOver=rentOver.subtract(rentincome.get(hireDate)).setScale(2, BigDecimal.ROUND_HALF_UP);
					  }
				     //上次核销时间上当前截止时间之间后前
				      difC=Tools.dateDiff("day", plan_date, cur_date);
				      difp=Tools.dateDiff("day", cur_date, hireDate);
				      if(difC>0&& difp>=0){
				    	 	 penalty=penalty.add(ComputerPenaltyByFomula(rentOver,rate,new BigDecimal(difC)));	
					    }
					 plan_date=hireDate;
				 }
				 
				 difC=Tools.dateDiff("day", plan_date, cur_date);
				 if(difC>0){
					 if(rentOver.floatValue()>0){
					 penalty= penalty.add(ComputerPenaltyByFomula(rentOver,rate,new BigDecimal(difC)));	
				 }}
				 log.debug(penalty.toString());
			   penalty=penalty.subtract(recieverpenalty);
			   Penaltys.add(penalty.setScale(2, BigDecimal.ROUND_HALF_UP));
			   Penaltys.add(recieverpenalty.setScale(2, BigDecimal.ROUND_HALF_UP));
		 }else{
			 //没有回笼过
			 if(rentPlan.getRent()==null){
				 Penaltys.add(BigDecimal.ZERO);
				 Penaltys.add(BigDecimal.ZERO);
			}else{
				if(isRent==true){
				   rentOver=rentPlan.getRent(); 
				}else{
					 rentOver=rentPlan.getCorpus(); 	
				}
				penalty=ComputerPenaltyByFomula(rentOver,rate,bdifc);
			    Penaltys.add( penalty.setScale(2, BigDecimal.ROUND_HALF_UP));
			    Penaltys.add(BigDecimal.ZERO);
			}
		 }	 }
		 return Penaltys;
		 
	}
	public static BigDecimal ComputerPenaltyByFomula(BigDecimal rent,BigDecimal rate,BigDecimal difdate){
		System.out.println(rent.toString()+"*"+rate.toString()+"/360"+"*"+difdate.toString()+"/1000");
		BigDecimal penalty=BigDecimal.ZERO;
		penalty=rent.multiply(rate);
		//penalty=penalty.divide(new BigDecimal(360),6, BigDecimal.ROUND_HALF_EVEN);
		penalty=penalty.multiply(difdate);
		penalty=penalty.divide(new BigDecimal("10000"),6, BigDecimal.ROUND_HALF_EVEN);
		return penalty.setScale(2, BigDecimal.ROUND_HALF_UP);	 
	}
	public static void main(String[] args){
		log.debug(Tools.dateDiff("day", "2012-3-9", "2012-3-10"));
		BigDecimal penalty=new BigDecimal("1.00");
		BigDecimal penalty1=new BigDecimal("55.00") ;
		penalty=penalty.add(penalty1);
		log.debug(penalty.doubleValue());
		
	}
}
