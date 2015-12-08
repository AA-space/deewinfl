package com.tenwa.leasing.rentcharge.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import oracle.net.aso.l;

import org.apache.log4j.Logger;

import com.business.util.MoneyUtils;
import com.tenwa.leasing.bean.AdjustBean;
import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.FundRentPlanBean;
import com.tenwa.leasing.bean.InterContBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.irr.service.impl.IrrDetailsServiceByTranImpl;
import com.tenwa.leasing.rent.dao.impl.ConditionDAOImpl;
import com.tenwa.leasing.rent.dao.impl.RentPlanContrCalDAOImpl;
import com.tenwa.leasing.rentcharge.service.RentChargeService;
import com.tenwa.leasing.rentcharge.service.impl.DeviRentChargeServiceImpl;
import com.tenwa.leasing.rentcharge.service.impl.RentChargeServiceImpl;
import com.tenwa.leasing.renttranrate.dao.impl.ConditionTranDAOImpl;
import com.tenwa.leasing.util.BigTools;
import com.tenwa.leasing.util.NumTools;
import com.tenwa.leasing.util.leasing.RateTools;
import com.tenwa.leasing.util.leasing.TbBeanTools;



/**
 * 
 * @author      SCLICX
 * @version     1.0
 * @copyright   (C) Tenwa 2011
 * @date        Mar 23, 2011
 * @desc        TODO (租金计划变更,接受页面参数,并实现变更内容)
 */
public class RentChargeDo {
	Logger	logger	= Logger.getLogger(RentChargeDo.class);
	/**
	 * 
	 * TODO (租金计划变更方法,接受页面参数)
	 * @param aj 租金计划变更Bean
	 * @param calType 流程名 项目为proj_process合同为cont_process
	 */
	@SuppressWarnings("unchecked")
	public Hashtable rentChargeCal(AdjustBean adb,String calType,Object obj){
		
		logger.debug("进入变更方法");
		//------------------------------------------------------------------------------------------------------------------------------------------合同本金买断新需求处理开始：
		RentPlanContrCalDAOImpl rpccdi = new RentPlanContrCalDAOImpl();
		if(adb.getAdjustType().equals("his_contract_end")){//合同中途终止
			try {
				Integer maxlist = rpccdi.serchMaxNumber(adb);
				//这里应该将合同终止下的adjustList设置为该合同对应租金计划的最大一期
				adb.setAdjustList(maxlist);
				logger.info("maxlist:"+maxlist);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//------------------------------------------------------------------------------------------------------------------------------------------合同本金买断
		
		Hashtable ht=new Hashtable();
		//初始化ht
		ht.put("isSucess", "false");
		List error=new ArrayList();
		error.add("");
		ht.put("error", error);
		//logger.debug(adb);
		RentChargeService rcs;
		//判断是否可以变更
		ConditionTranDAOImpl ctd = new ConditionTranDAOImpl();
		try {
			//[KEY:scl]2012-1-4提前结清不做该判定
			if(!adb.getAdjustType().equals("his_contract_end")){//合同中途终止
				if(!ctd.isChargeByContr(adb.getContractId().toString())){
					logger.info("合同"+adb.getContractId()+"不满足变更规则.");
					error=new ArrayList();
					error.add("该合同可能是不规则租金测算方法或者为多次起租合同,不能按照特定条件变更!");
					ht.put("error", error);
					return ht;
				}
			}else{
				logger.info("合同中途终止不做规则判定.");
			}
		} catch (Exception e) {
			logger.error("合同"+adb.getContractId()+"在判断是否满足变更规则时出现错误!");
			e.toString();
			e.printStackTrace();
			error=new ArrayList();
			error.add("出现了一个没有捕获的异常("+e.toString()+").\\n一般不会出现该异常.请重新尝试,或者联系管理员!");
			ht.put("error", error);
			return ht;
		}
		
		try{
			if(null == obj){//正常的租金计划变更,
				rcs=new RentChargeServiceImpl();
				ht=rcs.rentChargeCal(adb,calType,ht,obj);
			}else{//不规则租金进化变更,租金调整按钮
				rcs=new DeviRentChargeServiceImpl();
				ht=rcs.rentChargeCal(adb,calType,ht,obj);				
			}
			
			//合同中途终止修改最后一起租金计划
			if(adb.getAdjustType().equals("his_contract_end")){//合同中途终止
				
				RentPlanContrCalDAOImpl rpcd = new RentPlanContrCalDAOImpl();
				TabCalBean tcb = TbBeanTools.getTabInfo(calType);
				tcb.setTableToFormal();
				tcb.setDocIdCoulValue(null);
				tcb.setContOrProjCValue(adb.getPk_clum_v1());
				
				//正式表租金计划
				FundRentPlanBean frp = rpcd.getRentAndDateByTcb(tcb, "1");
				//临时表租金计划
				tcb = TbBeanTools.getTabInfo(calType, adb);
				FundRentPlanBean frpTemp = rpcd.getRentAndDateByTcb(tcb, "1");
				
				//构建一个新的计划对象合计，用于封装买断后的租金计划
				FundRentPlanBean tempPlan_l = frpTemp;
				
				//------------------------------------------------------------------------------------------------------------------------------------------合同本金买断新需求处理开始：
				/*
				 * 之前需求：重新设置租金计划中最后一期利息的值
				 * 2014-07-02 需求变更如下：
				 * 1.买断本金=剩余本金*买断比例
				 * 2.约定终止日（买断日期）与租金现有计划中现有的一期日期重合，则直接在该期日期上做金额累加：本金 = 原有本金 + 买断本金 ， 租金 = 原有租金 + 买断本金
				 * 
				 * 3.大于‘约定终止日（买断日期）’的所有租金计划重新做租金测算操作，操作步骤如下：
				 *   3.0: 总剩余本金 =  大于‘约定终止日（买断日期）’的所有租金计划的本金合计，买断后本金合计= 总剩余本金 - 买断本金
				 *   3.1：剩余比例 = 100 - 提前结清比例(百分比)
				 *   3.2: 每期租金值 =  原本租金值 * （剩余比例/100）
				 *   3.3: 得到期利率：根据商务条件中年利率换算得出   
				 *   3.3: 每期利息值 =  期利率 及 剩余本金换算得出
				 *   3.4：每期本金值 = 租金 - 利息
				 *   3.5：最后一期做差额处理，处理再最后一期的本金值上
				 */
				Double corpusOverage = adb.getCorpusOverage();//未到期业务本金合计
				BigDecimal advance_rate = adb.getAdvance_rate();//提前结清比例(百分比)%
				Double advanceRate_div100 = BigTools.divide(Double.parseDouble(String.valueOf( advance_rate ) ), 100.00, 20);
				
				//1.买断本金  = 剩余本金  * 买断比例
				Double monopolizecorpus = BigTools.multiply(corpusOverage, advanceRate_div100);
				logger.info("买断本金值:"+monopolizecorpus);
				//3.0:  买断后剩余本金合计 = 总剩余本金 - 买断本金
				Double overplusMonopolizecorpus =  BigTools.substract(corpusOverage, monopolizecorpus);
				logger.info("买断后剩余本金合计:"+overplusMonopolizecorpus);
				//3.1：剩余比例 = 100 - 提前结清比例(百分比)
				Double overplusRate = BigTools.substract(1.00, advanceRate_div100);
				
				//3.3: 得到期利率：根据商务条件中年利率换算得出   
				//Double	yearRate = adb.getYearRate();
				//3.3.1: 获得condition表信息
				ConditionBean cdb = new ConditionBean();//交易结构表
				String wheresql = tcb.getCondition_tb()+" where "+tcb.getContOrProjCName()
				+"='"+tcb.getContOrProjCValue()+"' and "+tcb.getDocIdCoulName()
				+"='"+tcb.getDocIdCoulValue()+"'";
				if(adb.getOnHireId()!=null&&!adb.getOnHireId().equals("")){
					wheresql+=" and onHire_id='"+adb.getOnHireId()+"'";
				}
				ConditionDAOImpl cddao = new ConditionDAOImpl();
				cdb = cddao.getConditionBeanByContract(wheresql,tcb);
				//3.3.2: 中的getPreRate得到测算的租金利率
				String incomeNumberYear = cdb.getIncomeNumberYear();
				if (null != cdb.getIncomeNumberYear() && "income_1".equals(cdb.getIncomeNumberYear())) {// 付租类型
					incomeNumberYear = "12";
				} else if (null != cdb.getIncomeNumberYear() && "income_3".equals(cdb.getIncomeNumberYear())) {
					incomeNumberYear = "4";
				} else if (null != cdb.getIncomeNumberYear() && "income_6".equals(cdb.getIncomeNumberYear())) {
					incomeNumberYear = "2";
				} else if (null != cdb.getIncomeNumberYear() && "income_12".equals(cdb.getIncomeNumberYear())) {
					incomeNumberYear = "1";
				} else if (null != cdb.getIncomeNumberYear() && "income_2".equals(cdb.getIncomeNumberYear())) {
					incomeNumberYear = "6";
				}
				String preRate = RateTools.getPreRate(cdb.getYearRate(), incomeNumberYear);
				
				/**
				 * 循环完整的租金计划集合,从买断开始期项开始循环重新计算租金计划
				 * 买断第一期单独处理,处理规则：
				 * a). 约定终止日（买断日期）与租金现有计划中冒一期日期重合，
				 * 则直接在该期日期上做金额累加：本金 = 原有本金 + 买断本金 ， 租金 = 原有租金 + 买断本金，利息 = 原有利息 （买断本金不存在利息值）
				 * b). 约定终止日（买断日期）与租金现有计划中冒一期日期不重合，
				 * 则新增一期租金计划 ：租金 = 买断本金 ，本金 = 买断本金 ，利息 = 0 （买断本金不存在利息值），剩余本金 = 原有本金余额 - 买断本金
				 */
				String sql = "";
				for (int i = adb.getStartList() - 1; i < frpTemp.getRent_list().size(); i++) {
					
					//2. 买断第一期单独处理
					if(i == adb.getStartList() - 1){
						//‘约定终止日（买断日期）’与原租金计划存在相同的日期，则做合并操作
						if(adb.getPaydayAdjust().equals( frp.getPlanDate_list().get(i) ) ){
							
							//修改租金列,租金 = 原有租金 + 买断本金
							tempPlan_l.getRent_list().set(i,NumTools.calculationStr(tempPlan_l.getRent_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.ADD, 0));//2014-08-13需求变更:租金做圆整处理
							//修改业务本金列，业务本金 = 原有业务本金 + 买断本金
							tempPlan_l.getCorpus_list().set(i, NumTools.calculationStr(tempPlan_l.getCorpus_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.ADD, 2));
							//修改业务本金余额列表，业务本金余额 = 原有业务本金余额 - 买断本金
							tempPlan_l.getCorpusOverage_list().set(i, NumTools.calculationStr(tempPlan_l.getCorpusOverage_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.SUBTRACT, 2));
							
							/*德银木有财务计划,都在下方直接用业务的赋值
							//修改财务本金列，财务本金 = 原有财务本金 + 买断本金 //tempPlan_l.getCorpus_finac_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.ADD, 2)
							tempPlan_l.getCorpus_finac_list().set(i, NumTools.calculationStr(tempPlan_l.getCorpus_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.ADD, 2));
							//修改财务本金余额列表，财务本金余额 = 原有财务本金余额 - 买断本金 //tempPlan_l.getCorpusOverage_finac_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.SUBTRACT, 2)
							tempPlan_l.getCorpusOverage_finac_list().set(i, NumTools.calculationStr(tempPlan_l.getCorpusOverage_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.SUBTRACT, 2));
							*/
							
						}else{//否则接着根据买断日期新增一期租金计划
							/*该种直接增加list元素的方式很麻烦，存在一个问题，暂时使用sql方式代替
							//增加一行新的 年利率
							tempPlan_l.getYear_rate_list().add(tempPlan_l.getYear_rate_list_s().get(i).toString());
							//增加一行新的 租金计划日期
							tempPlan_l.getPlanDate_list().add(adb.getPaydayAdjust());
							//增加一行新的 租金值，租金值 = 买断本金值
							tempPlan_l.getRent_list().add(monopolizecorpus);
							//增加一行新的  本金值,业务本金值  = 买断本金值
							tempPlan_l.getCorpus_list().add(monopolizecorpus);
							//增加一行新的 业务利息 ,本期为本金买断情况，因此业务利息置为0
							tempPlan_l.getInterest_list().add("0.00");
							//增加一行新的   业务本金余额,业务本金余额 = 原有业务本金余额 - 买断本金
							tempPlan_l.getCorpusOverage_list().add(NumTools.calculationStr(tempPlan_l.getCorpusOverage_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.SUBTRACT, 2));
							*/
							
							/*德银木有财务计划,都在下方直接用业务的赋值
							//增加一行新的 财务本金列，财务本金 = 原有财务本金 + 买断本金 NumTools.calculationStr(tempPlan_l.getCorpus_finac_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.ADD, 2)
							tempPlan_l.getCorpus_finac_list().add(monopolizecorpus);
							//增加一行新的 利息 ,本期为本金买断情况，因此财务利息置为0
							tempPlan_l.getCorpusOverage_finac_list().add("0.00");
							//增加一行新的 财务本金余额列表，财务本金余额 = 原有财务本金余额 - 买断本金 NumTools.calculationStr(tempPlan_l.getCorpusOverage_finac_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.SUBTRACT, 2)
							tempPlan_l.getCorpusOverage_finac_list().add(NumTools.calculationStr(tempPlan_l.getCorpusOverage_list().get(i).toString(),String.valueOf(monopolizecorpus), NumTools.SUBTRACT, 2));
							*/
							
							/*直接新增一条记录的方式不可取，因为不适合之前正常的变更操作依据做了一条重复的针对本条记录的数据，
							 * 只需要update即可，具体实现见RentChargeServiceImpl类154行代码附件
							sql = "";
							sql = " INSERT INTO " + tcb.getRentPlan_tb() + " (";
							sql += " id,";
							sql += " " + tcb.getDocIdCoulName() + "";
							sql += "," + tcb.getContOrProjCName() + "";
							sql += ",rent_list";
							sql += ",plan_date";
							sql += ",rent";
							sql += ",corpus";
							sql += ",year_rate";
							sql += ",interest";
							sql += ",corpus_overage";
							sql += ",CORPUS_BUSINESS";
							sql += ",INTEREST_BUSINESS";
							sql += ",onhire_id";
							
							sql += ") VALUES (";
							sql += "'" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() + "',";
							sql += "'" + tcb.getDocIdCoulValue() + "',";
							sql += "'" + tcb.getContOrProjCValue() + "',";
							sql += 0 + ",";
							sql += "'" + adb.getPaydayAdjust() + "',";
							sql += NumTools.formatNumberDoubleScale(String.valueOf( monopolizecorpus ),2)+ ",";
							sql += NumTools.formatNumberDoubleScale(String.valueOf( monopolizecorpus ), 2)+ ",";
							sql += NumTools.formatNumberDoubleScale(tempPlan_l.getYear_rate_list_s().get(i).toString(), 8)+ ",";
							sql += NumTools.formatNumberDoubleScale("0.00", 2)+ ",";
							sql += NumTools.formatNumberDoubleScale(String.valueOf( overplusMonopolizecorpus ), 2)+ ",";
							sql += "'" + NumTools.formatNumberDoubleScale(String.valueOf( monopolizecorpus ),2) + "',";
							sql += "'" + NumTools.formatNumberDoubleScale("0.00",2) + "',";
							sql += "'" + tcb.getOnHire_id() + "' ";
							sql += ") ";
							logger.info("insert_sql:"+sql);
							*/
							
							//修改sql
							sql = "";
							sql = " update " + tcb.getRentPlan_tb() + " set  ";
							sql += " plan_date = '" + adb.getPaydayAdjust() + "' ";
							sql += ",rent = " + NumTools.formatNumberDoubleScale(String.valueOf( monopolizecorpus ),0);//2014-08-13需求变更:租金做圆整处理
							sql += ",corpus = " + NumTools.formatNumberDoubleScale(String.valueOf( monopolizecorpus ), 2);
							sql += ",interest = 0.00 ";
							sql += ",corpus_overage = " + NumTools.formatNumberDoubleScale(String.valueOf( overplusMonopolizecorpus ), 2);
							sql += ",CORPUS_BUSINESS = '" + NumTools.formatNumberDoubleScale(String.valueOf( monopolizecorpus ),2) + "'";
							sql += ",INTEREST_BUSINESS = 0.00 ";
							sql += " where id = ( ";
							sql += " select nvl(id,'') from " + tcb.getRentPlan_tb() + "  where " + tcb.getContOrProjCName() + " = '" + tcb.getContOrProjCValue() + "' and " + tcb.getDocIdCoulName() + " = '" + tcb.getDocIdCoulValue() + "' ";
							sql += "	and rent_list = ( ";
							sql += "	    select nvl(min(rent_list),0) from  contract_fund_rent_plan_temp where " + tcb.getContOrProjCName() + " = '" + tcb.getContOrProjCValue() + "' and " + tcb.getDocIdCoulName() + " = '" + tcb.getDocIdCoulValue() + "' ";
							sql += "	    and plan_date > '" + adb.getPaydayAdjust() + "' ";
							sql += "	) ";
							sql += ") ";
							
							/*上方修改sql的原型sql如下：
							select id from contract_fund_rent_plan_temp where contract_Id = 'C3385' and doc_id = '6740793'
							and rent_list = (
							    select nvl(min(rent_list),0) from  contract_fund_rent_plan_temp where contract_Id = 'C3385' and doc_id = '6740793'
							    and plan_date > '2014-07-23' --买断日期
							)
							*/
							logger.info("update_sql:"+sql);
								
						} 
					}else{
						//3.2:每期租金值：原每期租金 * 剩余比例
						Double oneRent = Double.parseDouble( MoneyUtils.getZeroStr(  frpTemp.getRent_list().get(i).toString() ) );
						oneRent = Double.parseDouble(NumTools.calculationStr( String.valueOf(oneRent), String.valueOf( overplusRate ), NumTools.MULTIPLY, 0));//2014-08-13需求变更:租金做圆整处理
						logger.info("每期租金值：原每期租金 * 剩余比例:"+oneRent);
						
						//3.3.3: 每期利息值 =  期利率 及 剩余本金换算得出
						String oneInterest =   MoneyUtils.getZeroStr(  frpTemp.getInterest_list().get(i).toString() ) ; 
						oneInterest = NumTools.calculationStr( String.valueOf(overplusMonopolizecorpus), preRate , NumTools.MULTIPLY, 2);
						logger.info("每期利息值 =  期利率 及 剩余本金换算得出:"+oneInterest);
						
						//3.3.4: 每期本金值 = 每期租金 - 每期利息
						Double corpusTemp =  Double.parseDouble( NumTools.calculationStr( String.valueOf(oneRent), oneInterest , NumTools.SUBTRACT, 2) );
						logger.info("每期本金值 = 每期租金 - 每期利息:"+corpusTemp);
						
						//3.3.5: 剩余本金变量做累减法操作 = 买断后剩余本金合计 - 每期本金
						overplusMonopolizecorpus = Double.parseDouble( NumTools.calculationStr( String.valueOf(overplusMonopolizecorpus), String.valueOf(corpusTemp) , NumTools.SUBTRACT, 2) );
						logger.info("剩余本金变量做累减法操作:"+overplusMonopolizecorpus);
						
						//修改租金列,租金 = 原有租金  * （剩余比例）
						tempPlan_l.getRent_list().set(i,oneRent);
						//修改利息列，利息 = 剩余本金变量 * 期利率
						tempPlan_l.getInterest_list().set(i, oneInterest);
						//修改业务本金列，业务本金 = 每期租金 - 每期利息
						tempPlan_l.getCorpus_list().set(i, corpusTemp);
						//修改业务本金余额列表，业务本金余额 = 本次计算完利息后减去当期本金的本金值
						tempPlan_l.getCorpusOverage_list().set(i, overplusMonopolizecorpus);
						logger.info("--------------------------------------------------------------------------------------------------------");
						
						/*德银木有财务计划,都在下方直接用业务的赋值
						//修改财务本金列，财务本金 = 原有财务本金 + 买断本金
						tempPlan_l.getCorpus_finac_list().set(i, corpusTemp);
						//修改财务本金余额列表，财务本金余额 = 原有财务本金余额 - 买断本金
						tempPlan_l.getCorpusOverage_finac_list().set(i, overplusMonopolizecorpus);
						*/
					}
				}
				
				//3.3.6 最后一期续作倒挤差额处理，本金余额的值应加到利息中，本金余额置为0
				int num = tempPlan_l.getCorpusOverage_list().size() - 1;
				String endInterest = NumTools.calculationStr(tempPlan_l.getInterest_list().get(num).toString(),String.valueOf(tempPlan_l.getCorpusOverage_list().get(num)), NumTools.ADD, 2);
				tempPlan_l.getInterest_list().set(num, endInterest);
				//最后一期业务本金
				tempPlan_l.getCorpus_list().set(num,NumTools.calculationStr(tempPlan_l.getRent_list().get(num).toString(),endInterest, NumTools.SUBTRACT, 2));
				
				//tempPlan_l.getRent_list().set(num,NumTools.calculationStr(tempPlan_l.getRent_list().get(num).toString(),String.valueOf(tempPlan_l.getCorpusOverage_list().get(num)), NumTools.ADD, 0));//2014-08-13需求变更:租金做圆整处理
				tempPlan_l.getCorpusOverage_list().set(num,0);
				
				//3.3.7  德银木有财务计划,在这里直接用业务的赋值
				List	corpus_finac_list			= tempPlan_l.getCorpus_list();	// 财务本金列表
				List	corpusOverage_finac_list	= tempPlan_l.getCorpusOverage_list();	// 财务本金余额列表
				List	interest_finac_list			= tempPlan_l.getInterest_list();	// 财务利息列表
				tempPlan_l.getCorpus_finac_list().add(corpus_finac_list);
				tempPlan_l.getCorpusOverage_finac_list().add(corpusOverage_finac_list);
				tempPlan_l.getInterest_finac_list().add(interest_finac_list);
				
				//logger.info("tcb.getRentPlan_tb():"+tcb.getRentPlan_tb());
				//4.保存租金计划
				//4.1
				rpccdi.deleteRentPlan(tcb.getRentPlan_tb(), tcb, "1");// 删除
				rpccdi.addRentPlanMonopolize(tcb.getRentPlan_tb(), tempPlan_l, tcb, "1", "2");// 添加
				rpccdi.deleteContractFundRentPlan(tcb.getContOrProjCValue(),  tcb.getDocIdCoulValue());//提前终止买断比例为100情况下，后续分摊为0的租金计划做删除操作...
				//4.2 
				if(sql.length() > 0){
					rpccdi.saveDataFromSql(sql);
				}
				
				
				
				
				//5.现金流处理
				InterContBean icb = new InterContBean();
				icb.setStart_list(adb.getStartList().toString());
				//5.1 现金流明细构建 重算IRR
				IrrDetailsServiceByTranImpl idsbti = new IrrDetailsServiceByTranImpl();
				icb = idsbti.processTranCashDetails(cdb, icb, tcb);
				//------------------------------------------------------------------------------------------------------------------------------------------合同本金买断新需求处理结束
				
				/*
				//原本的合同终止计算逻辑
				if(adb.getPaydayAdjust().equals(frp.getPlanDate_list().get(adb.getAdjustList()-1))){//调整的日期在租金计划中是有的
					frpTemp.getInterest_list().set(
						adb.getAdjustList()-1,
						NumTools.calculationStr(frpTemp.getInterest_list().get(adb.getAdjustList()-1).toString(),adb.getAgreedInterest().toString(), NumTools.ADD, 2)
					);
					
				}else{
					frpTemp.getInterest_list().set(adb.getAdjustList()-1,adb.getAgreedInterest().toString());
				}
				
				//重新设置最后一期租金值
				frpTemp.getRent_list().set(
						adb.getAdjustList()-1,
						NumTools.calculationStr(frpTemp.getInterest_list().get(adb.getAdjustList()-1).toString(),frpTemp.getCorpus_list().get(adb.getAdjustList()-1).toString(), NumTools.ADD, 2)
				);
				frpTemp.getColumn_2().set(adb.getAdjustList()-1, frpTemp.getInterest_list().get(adb.getAdjustList()-1));
				//修改租金计划信息
				rpcd.updateDataByRentList(frpTemp, adb, tcb);
				*/
				
			}
			
		}catch (Exception e) {
			ht.put("isSucess", "false");
			error=(List)ht.get("error");
			error.add(e.toString());
			ht.put("error", error);
			logger.info("变更测算出现异常...");
			e.printStackTrace();
		}
		//清除第一个初始化值
		error=(List)ht.get("error");
		if(error!=null&&error.size()>0){
			error.remove(0);
		}
		if(error!=null&&error.size()>0){
			ht.put("error", error);
		}
		return ht;
	}
}
