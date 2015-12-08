package com.business.controller.reckon;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.DictionaryData;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.fund.ContractFundFundCharge;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.cash.ContractCashDetailTemp;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanBefore;
import com.business.entity.contract.reckon.fund.ContractFundRentPlanTemp;
import com.business.entity.cust.CustInfo;
import com.business.entity.util.OwnInfo;
import com.business.service.TableService;
import com.business.service.convert.ConvertMapToBeanService;
import com.business.service.reckon.FundFundChargePlanService;
import com.business.service.reckon.RentCalculateService;
import com.business.serviceImpl.reckon.RentCalculateServiceImpl;
import com.business.util.MoneyUtils;
import com.business.util.Tools;
import com.kernal.utils.QueryUtil;
import com.tenwa.leasing.bean.FundFundChargePlanBean;
import com.tenwa.leasing.irr.web.ActuIrrDo;
import com.tenwa.leasing.util.BigTools;
import com.tenwa.leasing.util.LeasingException;
import com.tenwa.leasing.util.leasing.PlanDateTools;

import edu.emory.mathcs.backport.java.util.LinkedList;

/**
 * 
 * @author 孙传良
 * @date 2013-3-19上午10:55:13
 * @info 租金测算模型的实现类 该类的主要功能为接收前台参数做相应的测算.
 * @Copyright Tenwa
 */
@Controller(value = "rentCalculateController")
@RequestMapping(value = "/**/leasing")
public class RentCalculateController extends BaseController {
	
	@Resource(name = "rentCalculateService")
	private RentCalculateService rentCalculateService;
	
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name = "convertMapToBeanService")
	private ConvertMapToBeanService convertMapToBeanService;
	
	@Resource(name = "fundFundChargePlanService")
	private FundFundChargePlanService fundChargePlanService;
	
	Logger	logger	= Logger.getLogger(RentCalculateController.class);
	
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM");

	@RequestMapping(value = "/rentCalculate.action")
	public String rentCalculate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);// 把请求数据转成map
		String ajaxCallBackScript = "";
		try {
			Map<String, Object> returnMap = this.rentCalculateService.calculateRentPlan(modelData);
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString(returnMap);
			ajaxCallBackScript = "<script type='text/javascript'>window.parent.ajaxProjRentCalculateCallBack('" + jsonResult + "');</script>";
		} catch (Exception e) {
			e.printStackTrace();
			ajaxCallBackScript = e.getMessage();
			ajaxCallBackScript = "<script type='text/javascript'>window.parent.alert('" + ajaxCallBackScript + "');window.close();</script>";
		}
		this.ajaxReturn(response, ajaxCallBackScript);
		return null;
	}

	/**
	 * 为了和老的租金测算代码对接写的测算入口类
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/rentCalculateOld.action")
	@ResponseBody
	public String rentCalculateOld(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);// 把请求数据转成map
		String ajaxCallBackScript = "";
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Map<String, Object> rentPlan = new HashMap<String, Object>();
			
			String process = modelData.get("framework_condition.process");
			if(process.equalsIgnoreCase("equip_acceptance_process")||process.equalsIgnoreCase("onhire_process")){//设备验收操作
				rentPlan = getNewRentFundPlanInfoByNewStartDate(modelData);
			} else {
				rentPlan = this.rentCalculateService.calculateRentPlanOld(modelData);
			}
			
			if (rentPlan != null && rentPlan.size() > 0) {
				returnMap.putAll(rentPlan);
				Map<String, Object> fundPlan = new HashMap<String, Object>();
				OwnInfo ownInfo = new OwnInfo();
				ownInfo.setOwnName(rentPlan.get("owninfo").toString());
				fundPlan = this.fundChargePlanService.createFundPlan(modelData, rentPlan.get("enddate").toString(), ownInfo);
				if (fundPlan != null && fundPlan.size() > 0) {
					// System.out.println("成功获得资金计划的数据!");
					returnMap.put("fundchargeplanmsg", "yes");
					returnMap.putAll(fundPlan);
				} else {
					// System.out.println("获取资金计划的数据失败!");
					returnMap.put("fundchargeplanmsg", "no");
				}
				rentPlan.remove("owninfo");// 移除不需要的信息
			}
		} catch (LeasingException e) {
			e.printStackTrace();
			ajaxCallBackScript = "捕获到异常:" + e.getMessage();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			if (ajaxCallBackScript == null || ajaxCallBackScript.equals("")) {
				ajaxCallBackScript = "发现异常但未抛出!";
			}
			returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
		} catch (Exception e) {
			e.printStackTrace();
			ajaxCallBackScript = e.getMessage();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			if (ajaxCallBackScript == null || ajaxCallBackScript.equals("")) {
				ajaxCallBackScript = "测算已经出错,但是没有捕获到错误消息!";
			}
			returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
		}
		if (returnMap == null || returnMap.size() == 0) {
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			returnMap.put("rentcalculatemsg", "测算失败!没有获取测算结果!");
		}
		String jsonResult = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.WRITE_NULL_PROPERTIES, false);// 不写空字符
		try {
			jsonResult = mapper.writeValueAsString(returnMap);
		} catch (Exception e) {
			e.printStackTrace();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			returnMap.put("rentcalculatemsg", "测算失败!构建JSON返回结果出错!");
			jsonResult = mapper.writeValueAsString(returnMap);
		}
		return jsonResult.toLowerCase();
	}

	/**
	 * 租金计划变更的action
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/adjustCalculateOld.action")
	@ResponseBody
	public String adjustCalculateOld(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);// 把请求数据转成map
		String ajaxCallBackScript = "";
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Map<String, Object> rentPlan = new HashMap<String, Object>();
			rentPlan = this.rentCalculateService.adjustCalculateOld(modelData);
			if (rentPlan != null && rentPlan.size() > 0) {
				returnMap.putAll(rentPlan);
			}
		} catch (LeasingException e) {
			e.printStackTrace();
			ajaxCallBackScript = "捕获到异常:" + e.getMessage();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			if (ajaxCallBackScript == null || ajaxCallBackScript.equals("")) {
				ajaxCallBackScript = "发现异常但未抛出!";
			}
			returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
		} catch (Exception e) {
			e.printStackTrace();
			ajaxCallBackScript = e.getMessage();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			if (ajaxCallBackScript == null || ajaxCallBackScript.equals("")) {
				ajaxCallBackScript = "测算已经出错,但是没有捕获到错误消息!";
			}
			returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
		}
		if (returnMap == null || returnMap.size() == 0) {
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			returnMap.put("rentcalculatemsg", "测算失败!没有获取测算结果!");
		} else {
			if (returnMap.get("rentcalculatemsg") == null) {
				returnMap.put("rentcalculatemsg", "租金计划变更测算成功!");
			}
		}
		String jsonResult = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.WRITE_NULL_PROPERTIES, false);// 不写空字符
		try {
			logger.info("returnMap:"+returnMap);
			jsonResult = mapper.writeValueAsString(returnMap);
		} catch (Exception e) {
			e.printStackTrace();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			returnMap.put("rentcalculatemsg", "测算失败!构建JSON返回结果出错!");
			jsonResult = mapper.writeValueAsString(returnMap);
		}
		logger.info("jsonResult:"+jsonResult.toLowerCase());
		return jsonResult.toLowerCase();
	}

	/**
	 * 租金计划修改的action
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/updateCalculateOld.action")
	@ResponseBody
	public String updateCalculateOld(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);// 把请求数据转成map
		String ajaxCallBackScript = "";
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Map<String, Object> rentPlan = new HashMap<String, Object>();
			rentPlan = this.rentCalculateService.updateCalculateOld(modelData);
			if (rentPlan != null && rentPlan.size() > 0) {
				returnMap.putAll(rentPlan);
			}
		} catch (LeasingException e) {
			e.printStackTrace();
			ajaxCallBackScript = "捕获到异常:" + e.getMessage();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			if (ajaxCallBackScript == null || ajaxCallBackScript.equals("")) {
				ajaxCallBackScript = "发现异常但未抛出!";
			}
			returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
		} catch (Exception e) {
			e.printStackTrace();
			ajaxCallBackScript = e.getMessage();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			if (ajaxCallBackScript == null || ajaxCallBackScript.equals("")) {
				ajaxCallBackScript = "测算已经出错,但是没有捕获到错误消息!";
			}
			returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
		}
		if (returnMap == null || returnMap.size() == 0) {
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			returnMap.put("rentcalculatemsg", "测算失败!没有获取测算结果!");
		} else {
			if (returnMap.get("rentcalculatemsg") == null) {
				returnMap.put("rentcalculatemsg", "租金计划变更测算成功!");
			}
		}
		String jsonResult = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.WRITE_NULL_PROPERTIES, false);// 不写空字符
		try {
			jsonResult = mapper.writeValueAsString(returnMap);
		} catch (Exception e) {
			e.printStackTrace();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			returnMap.put("rentcalculatemsg", "测算失败!构建JSON返回结果出错!");
			jsonResult = mapper.writeValueAsString(returnMap);
		}
		return jsonResult.toLowerCase();
	}

	/**
	 * 租金计划变更的action
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/resetAdjust.action")
	@ResponseBody
	public String resetAdjust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);// 把请求数据转成map
		String ajaxCallBackScript = "";
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			Map<String, Object> rentPlan = new HashMap<String, Object>();
			rentPlan = this.rentCalculateService.resetConditionData(modelData.get("fund_rent_adjust.contractid"), modelData.get("fund_rent_adjust.docid"));
			if (rentPlan != null && rentPlan.size() > 0) {
				returnMap.putAll(rentPlan);
			}
		} catch (LeasingException e) {
			e.printStackTrace();
			ajaxCallBackScript = "捕获到异常:" + e.getMessage();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			if (ajaxCallBackScript == null || ajaxCallBackScript.equals("")) {
				ajaxCallBackScript = "发现异常但未抛出!";
			}
			returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
		} catch (Exception e) {
			e.printStackTrace();
			ajaxCallBackScript = e.getMessage();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			if (ajaxCallBackScript == null || ajaxCallBackScript.equals("")) {
				ajaxCallBackScript = "测算已经出错,但是没有捕获到错误消息!";
			}
			returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
		}
		if (returnMap == null || returnMap.size() == 0) {
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			returnMap.put("rentcalculatemsg", "测算失败!没有获取测算结果!");
		} else {
			if (returnMap.get("rentcalculatemsg") == null) {
				returnMap.put("rentcalculatemsg", "撤销成功!");
			}
		}
		String jsonResult = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.WRITE_NULL_PROPERTIES, false);// 不写空字符
		try {
			jsonResult = mapper.writeValueAsString(returnMap);
		} catch (Exception e) {
			e.printStackTrace();
			returnMap = new HashMap<String, Object>();
			returnMap.put("rentcalculaters", "no");
			returnMap.put("rentcalculatemsg", "测算失败!构建JSON返回结果出错!");
			jsonResult = mapper.writeValueAsString(returnMap);
		}
		logger.debug("返回的json字符串："+jsonResult);
		return jsonResult.toLowerCase();
	}

	@RequestMapping(value = "/getActualIRRData.action")
	@ResponseBody
	public String getActualIRRData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		try {
			String idstr = model.get("id").toString() == null ? "" : model.get("id").toString();
			// System.out.println(idstr);
			if (idstr != null) {
				String irr = new ActuIrrDo().calActuIrrByContractId(idstr);
				return irr;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "irr测算为空";
	}

	/**
	 * 合同中途终止的action
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	@RequestMapping(value = "/contractMidwayEnd.action")
	@ResponseBody
	public String contractMidwayEnd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);// 把请求数据转成map
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 获取ajax参数
		String contract_id = modelData.get("contract_id");
		String end_date = modelData.get("end_date");//约定终止日
		String advancerate = MoneyUtils.getZeroStr( modelData.get("advancerate") );//提前结清比例
		if(Tools.isNullOrEmpty(advancerate)){
			advancerate = "0";
		}
		
		Date planDate = null;
		int freeDefaInterDay = 0;// 免罚息天数
		BigDecimal arrangeRentFund = BigDecimal.ZERO;// 已到期未支付租金  小于等于约定终止日应付未付的租金合计
		BigDecimal noArrangeCorpusFund = BigDecimal.ZERO;// 未到期本金
		BigDecimal penaltyMoney = BigDecimal.ZERO;// 逾期罚息
		BigDecimal rate;// 罚息利率
		BigDecimal noInterestFund = BigDecimal.ZERO;// 大于截止日的所有未到期利息合计
		BigDecimal handlingcharge = BigDecimal.ZERO;// 违约手续费
		BigDecimal currentcautionmoney = BigDecimal.ZERO;//剩余保证金
		
		String jsonResult = "";
		Map<String, Object> returnMap = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		// 查出资金状态
		String HQL = " from DictionaryData AS DD where DD.belongDictionary.code=? ";
		List<DictionaryData> listpayType = this.tableService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
		HashMap<String, DictionaryData> mapPayType = new HashMap<String, DictionaryData>();
		for (DictionaryData dd : listpayType) {
			mapPayType.put(dd.getCode(), dd);
		}
		if (contract_id != null && !"".equals(contract_id) && end_date != null && !"".equals(end_date)) {
			Date endDate = dateFormat.parse(end_date);
			//基本合同信息
			ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, contract_id);
			//合同租金计划
			Set<ContractFundRentPlan> contractFundRentPlans = contractInfo.getContractFundRentPlans();
			List<ContractFundRentPlan> rentPlans = new LinkedList(contractFundRentPlans);
			//该合同实际回笼情况
			Set<ContractFundRentInCome>  contractFundRentIncomes = contractInfo.getContractFundRentIncomes();
			List<ContractFundRentInCome> rentinComes = new LinkedList(contractFundRentIncomes);
			
			//资金实收
			Set<ContractFundFundCharge> fundFundCharges = contractInfo.getFundFundCharges();
			List<ContractFundFundCharge> fundFundIncomes = new LinkedList(fundFundCharges);
			
			//租赁物件
			Set<ContractEquip> contractEquips = contractInfo.getContractEquips();
			List<ContractEquip> contractEquip_l = new LinkedList(contractEquips);
			logger.debug("租赁物价条数："+contractEquip_l.size());
			
			ContractCondition condition = contractInfo.getContractCondition();
			freeDefaInterDay = condition.getFreeDefaInterDay() != null ? condition.getFreeDefaInterDay() : 0;
			rate = contractInfo.getContractCondition() != null ? contractInfo.getContractCondition().getPenaRate() : BigDecimal.ZERO;
			for (ContractFundRentPlan contractFundRentPlan : rentPlans) {
				planDate = dateFormat.parse(contractFundRentPlan.getPlanDate());
				if (planDate.getTime() <= endDate.getTime()) {
					arrangeRentFund = arrangeRentFund.add(contractFundRentPlan.getRent());
				} else {
					noArrangeCorpusFund = noArrangeCorpusFund.add(contractFundRentPlan.getCorpus());
					//未到期利息累加
					noInterestFund = noInterestFund.add( contractFundRentPlan.getInterest() );
				}
				contractFundRentPlan.initContractFundRentPlan(mapPayType, modelData.get("end_date"), rate, freeDefaInterDay);
				penaltyMoney = penaltyMoney.add(contractFundRentPlan.getPenaltyOverage());
				//德银需要的是应收罚息
				//penaltyMoney = penaltyMoney.add(contractFundRentPlan.getPenalty());
			}
			logger.debug("未到期利息合计："+noInterestFund);
			
			// 实收租金合计
			BigDecimal incomeRent = BigDecimal.ZERO;
			for(ContractFundRentInCome incomeObj : rentinComes ){
				incomeRent = incomeRent.add(incomeObj.getRent());
			}
			logger.debug("小于等于约定终止日租金合计："+arrangeRentFund);
			logger.debug("实收租金合计："+incomeRent);
			// 已到期未支付租金  小于等于约定终止日应付未付的租金合计
			arrangeRentFund = new BigDecimal( BigTools.substract(Double.parseDouble(String.valueOf(arrangeRentFund)), Double.parseDouble(String.valueOf(incomeRent))) );
				
			//1.买断本金  = 剩余本金  * 买断比例
			Double monopolizecorpusfund =  0.00;//买断本金
			monopolizecorpusfund = BigTools.multiply(Double.parseDouble(String.valueOf( noArrangeCorpusFund ) ), BigTools.divide(Double.parseDouble( advancerate ), 100.00, 20));
			
			/**
			 * 2. 违约手续费分两种情况：
			 * （1）	合同号为：lease_form1 租字第开头的，默认为3000元/台*合同总台数，可以手动调整   
			 * 台数   取非挂车的总值 ，即取数据字典不等于 equip_class_2的台数 contract_equip
			 * select * from contract_equip a where a.contract_id = 'C1386' and a.equip_class <> 'equip_class_2'
			 * （2）	合同号为：lease_form2 回租字第开头的，默认为合同整体剩余利息*20%*提前买断比例，可以手动调整 (大于终止日的所有利息合计)
			 */
			String leas_form = contractInfo.getLeasForm()  != null ? contractInfo.getLeasForm().getCode() : "" ; 
			logger.debug("leas_form："+leas_form);
			//直租
			if("lease_form1".equals(leas_form)){
				 int number = 0;//合同总台数
				 for (ContractEquip equipObj : contractEquip_l) {
					 String equipClass = equipObj.getEquipClass() != null ? equipObj.getEquipClass().getCode() : "";
					if(!"equip_class_2".equals(equipClass)){
						number = number + 1 ;
					}
				 }
				 logger.debug("合同总台数："+number);
				 handlingcharge = new BigDecimal( BigTools.multiply(3000.00, number) );
			}
			//回租
			if("lease_form2".equals(leas_form)){
				Double t_number = BigTools.multiply(0.20, Double.parseDouble( String.valueOf( noInterestFund )  ) );
				handlingcharge = new BigDecimal( BigTools.multiply(t_number, Double.parseDouble(advancerate) ) );
			}
			logger.debug("违约手续费："+handlingcharge);
			
			//3本次抵扣保证金=剩余保证金*提前结清比例     ,剩余保证金=资金实收表中费用类型为保证金收款减付款
			BigDecimal incomeCharge = BigDecimal.ZERO;// 本次抵扣保证金
			BigDecimal income_num = BigDecimal.ZERO;// 保证金实收
			BigDecimal plan_num = BigDecimal.ZERO;// 保证金实付
			for(ContractFundFundCharge fundCharge : fundFundIncomes ){
				String fee_type = fundCharge.getFeeType()  != null ? fundCharge.getFeeType().getCode() : "" ; //费用类型
				String pay_type = fundCharge.getPayType()  != null ? fundCharge.getPayType().getCode() : "" ; //收付方向
				
				if("feetype2".equals(fee_type) && "pay_type_in".equals(pay_type)){//保证金 并且收款
					income_num = income_num.add(fundCharge.getFactMoney());
				}
				
				if("feetype2".equals(fee_type) && "pay_type_out".equals(pay_type)){//保证金 并且付款
					plan_num = plan_num.add(fundCharge.getFactMoney());
				}
			}
			incomeCharge =  new BigDecimal( BigTools.substract(Double.parseDouble(String.valueOf(income_num)), Double.parseDouble(String.valueOf(plan_num))) );
			currentcautionmoney = incomeCharge;
			logger.debug("剩余保证金："+incomeCharge);
			incomeCharge = new BigDecimal( BigTools.multiply(Double.parseDouble(String.valueOf( incomeCharge ) ), BigTools.divide(Double.parseDouble( advancerate ), 100.00, 8)) );
			logger.debug("本次抵扣保证金："+incomeCharge);
			
			//其他应收、其他应退两项，系统自动计算
			Map<String, String> otherInOutMap = this.reCalOtherInOrOut(contract_id, end_date);
			returnMap.put("otherin", otherInOutMap.get("otherin"));
			returnMap.put("otherout", otherInOutMap.get("otherout"));
			
			logger.debug("未到期本金 原值："+noArrangeCorpusFund);
			returnMap.put("arrangerentfund", arrangeRentFund);//已到期未支付租金
			returnMap.put("noarrangecorpusfund", noArrangeCorpusFund);//未到期本金 
			returnMap.put("penaltyoverage", penaltyMoney);//逾期罚息
			returnMap.put("handlingcharge", handlingcharge);//违约手续费
			returnMap.put("incomecharge", incomeCharge);//本次抵扣保证金
			returnMap.put("monopolizecorpusfund", monopolizecorpusfund);//买断本金
			jsonResult = mapper.writeValueAsString(returnMap);//
		}
		return jsonResult.toLowerCase();
	}

	
	/**
	 * 根据新给定的终结日期，计算其他应退和应收 只有客户和租户之间的关系 其他应退：计划应退-实际已退 其他应付：计划应付-实际已付 （不包括设备款）
	 * 
	 * @param contractId
	 * @param stopDate
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> reCalOtherInOrOut(String contractId, String endDate) throws Exception {
		Map<String, String> variablesMap = new HashMap<String, String>();
		ContractInfo contractInfo = (ContractInfo) this.tableService.findEntityByID(ContractInfo.class, contractId);

		if (contractInfo != null) {

			BigDecimal otherin = BigDecimal.ZERO;// 应退=计划退-实际退
			BigDecimal otherout = BigDecimal.ZERO;// 应收=计划收-实际收

			// 资金收款计划
			String HQL = " from ContractFundFundPlan as fc where fc.contractId.contractId=?";
			List<ContractFundFundPlan> fundPlan = new ArrayList<ContractFundFundPlan>();
			fundPlan = this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId());
			for (ContractFundFundPlan fplan : fundPlan) {//保证金不算
				if ("pay_type_in".equalsIgnoreCase(fplan.getPayType().getCode()) && !"feetype2".equals(fplan.getFeeType().getCode())) {
					otherin = otherin.add(fplan.getPlanMoney());
				} else if ("pay_type_out".equalsIgnoreCase(fplan.getPayType().getCode())) {
					if ("feetype10".equalsIgnoreCase(fplan.getFeeType().getCode()) || "feetype2".equals(fplan.getFeeType().getCode())) {
						continue;// 设备款不计算在内  保证金也是
					}
					otherout = otherout.add(fplan.getPlanMoney());
				}
			}

			// 资金收款历史
			List<ContractFundFundCharge> chargeList = new ArrayList<ContractFundFundCharge>();
			HQL = " from ContractFundFundCharge as fc where fc.contractId.contractId=?";
			chargeList = this.tableService.findResultsByHSQL(HQL, contractInfo.getContractId());
			for (ContractFundFundCharge charge : chargeList) {//保证金不算
				if ("pay_type_in".equalsIgnoreCase(charge.getPayType().getCode())  && !"feetype2".equals(charge.getFeeType().getCode()) ) {
					otherin = otherin.subtract(charge.getFactMoney());
				} else if ("pay_type_out".equalsIgnoreCase(charge.getPayType().getCode())) {
					if ("feetype10".equalsIgnoreCase(charge.getFeeType().getCode())  || "feetype2".equals(charge.getFeeType().getCode()) ) {
						continue;// 设备款不计算在内 保证金也是
					}
					otherout = otherout.subtract(charge.getFactMoney());
				}
			}

			variablesMap.put("otherin", otherin.toString());
			variablesMap.put("otherout", otherout.toString());
		}
		return variablesMap;
	}

	
	/**
	 * 商务条件报价查询
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectContractCondition.action")
	public String selectContractCondition(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);// 把请求数据转成map
		String contractid = modelData.get("contractid").toString();
		request.setAttribute("isWhere", "true");
		if (contractid != null && !contractid.isEmpty()) {
			request.setAttribute("isRs", "true");
			ContractInfo cinfo = this.tableService.findEntityByID(ContractInfo.class, contractid);
			if (cinfo != null && !cinfo.getContractId().isEmpty()) {
				request.setAttribute("business_type", cinfo.getBusinessType().getCode());// 设置业务类型
																							// 决定显示那个jsp页面
				// 查询数据
				Map<String, String> variablesMap = new HashMap<String, String>();// 存入租金测算的数据
				if (cinfo.getContractCondition() != null) {
					variablesMap.putAll(this.tableService.getEntityPropertiesToStringMap(cinfo.getContractCondition(), null, "framework_condition"));
				}
				variablesMap.put("framework_condition.contractid", cinfo.getContractId());
				variablesMap.put("framework_condition.process", "cont_ready_process");
				variablesMap.put("framework_condition.custname", cinfo.getCustId().getCustName());
				variablesMap.put("framework_condition.custid", cinfo.getCustId().getId());
				Map<String, String> queryMainObjectMap = new HashMap<String, String>();
				queryMainObjectMap.put("contract_id", contractid);
				if (!cinfo.getContractFundRentPlans().isEmpty()) {// 租金计划
					String json_fund_rent_plan_str = this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_fund_rent_plan.xml", queryMainObjectMap).toString();
					variablesMap.put("json_fund_rent_plan_str", json_fund_rent_plan_str);
				}
				if (!cinfo.getContractCashDetails().isEmpty()) {// 合同现金流
					String json_fund_cash_flow_str = this.tableService.getJsonArrayData("eleasing/workflow/contract/contract_fund_cash_flow.xml", queryMainObjectMap).toString();
					variablesMap.put("json_fund_cash_flow_str", json_fund_cash_flow_str);
				}
				if (!cinfo.getFundFundChargePlans().isEmpty()) {
					String json_fund_charge_plan_str = this.tableService.getJsonArrayData("eleasing/workflow/contract/fund_fund_charge_plan.xml", queryMainObjectMap).toString();
					variablesMap.put("json_fund_fund_charge_str", json_fund_charge_plan_str);
				}
				// 把数据切入到request中
				for (String key : variablesMap.keySet()) {
					request.setAttribute(key, variablesMap.get(key));
				}
			} else {
				request.setAttribute("isRs", "false");
			}
		} else {
			request.setAttribute("isWhere", "false");
		}
		return "solutions/workflow/forms/rent_reckon/rent_reckon/condition_read.jsp";
	}
	
	
	
	/**
	 * 设备验收时更新租金计划日期和资金首付计划日期还有现金流日期
	 * @param modelData
	 * @return
	 */
	public Map<String, Object> getNewRentFundPlanInfoByNewStartDate(Map<String, String> modelData) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 获取商务条件以及其他参数信息
		try {
			
			// 获取合同信息
			Map<String, Object> propertiesMap = new HashMap<String, Object>();
			String contractId = modelData.get("framework_condition.contractid");
			propertiesMap.put("contractId", contractId);
			List<ContractInfo> cis = this.tableService.findEntityByProperties(ContractInfo.class, propertiesMap);
			
			// 原始租金计划
			List<ContractFundRentPlanTemp> fundRentPlanList = new ArrayList<ContractFundRentPlanTemp>();
			if(cis != null && cis.size() > 0){
				ContractInfo ci = cis.get(0);
				Set<ContractFundRentPlanBefore> rentPlanSet = ci.getContractFundRentPlanBefores();
				String json = this.tableService.getCollectionEntitiesPropertiesToJsonArrayString(rentPlanSet, null, "");
				ObjectMapper jsonMapper = new ObjectMapper();
				Map[] newSetMaps = jsonMapper.readValue(json, Map[].class);
				for (int j = 0; j < newSetMaps.length; j++) {
					Map map = newSetMaps[j];
					ContractFundRentPlanTemp temp = new ContractFundRentPlanTemp();
					this.tableService.copyAndOverrideExistedValueFromStringMap(map, temp, null);
					fundRentPlanList.add(temp);
				}
			}
			
			// 获取商务条件
			com.tenwa.leasing.bean.ConditionBean condition = new com.tenwa.leasing.bean.ConditionBean();
			condition = this.convertMapToBeanService.convertContionBean(condition, modelData);
			
			// 重新测算一个日期列表，然后更新租金计划列表
			String incomeNumber = condition.getIncomeNumber();
			String periodType = condition.getPeriodType().replace("period_type_", "");
			String grace = condition.getGrace();
			String issueMonths = (condition.getIncomeNumberYear() + "").trim().toLowerCase().replace("income_", "");
			String startDate = condition.getFirstPlanDate();
			List<String> dateList = PlanDateTools.getPlanDtList(incomeNumber, periodType, grace, issueMonths, startDate);
			if(dateList.size() >= fundRentPlanList.size()){
				for (int i = 0; i < fundRentPlanList.size(); i++) {
					fundRentPlanList.get(i).setPlanDate(dateList.get(i));
				}
			}
			
			// 重算资金收付计划
			List<FundFundChargePlanBean> fundChargePlan = fundChargePlanService.createFundChargePlan(modelData);
			
			// 现金流日期重算
			List<ContractCashDetailTemp> conditionCashFlow = resetFundCashFlowInfo(fundRentPlanList, fundChargePlan);
			
			// 查询客户信息
			String custId = modelData.get("framework_condition.custid");
			CustInfo custInfo = this.tableService.findEntityByID(CustInfo.class, custId);
			
			// 查询融资租赁公司信息
			List<OwnInfo> ownInfos = this.tableService.findEntities(OwnInfo.class);
			OwnInfo ownInfo = new OwnInfo();
			ownInfo.setOwnName("融资租赁公司");
			if(ownInfos != null && ownInfos.size() > 0){
				ownInfo = ownInfos.get(0);
			}
			
			// 重置资金收付计划中收付对象
			for(FundFundChargePlanBean fundCharge : fundChargePlan){
				if("pay_type_out".equalsIgnoreCase(fundCharge.getPayType())){
					fundCharge.setPayObj(ownInfo.getOwnName());
				}
				if("pay_type_in".equalsIgnoreCase(fundCharge.getPayType())){
					fundCharge.setPayObj(custInfo.getCustName());
				}
			}
			
			// 计算结束日期
//			String startDateString = condition.getStartDate();//
//			Date startDateDate = sdf.parse(startDateString);
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(startDateDate);
//			int months = Integer.parseInt(condition.getLeaseTerm());
//			calendar.add(Calendar.MONTH, months);
//			String endDate = sdf.format(calendar.getTime());
			String endDate = dateList.get(dateList.size() - 1);
			
			
			Collections.sort(conditionCashFlow);
			Collections.sort(fundRentPlanList);
			
			resultMap.putAll(modelData);
			resultMap.put("fundchargeplan", fundChargePlan);
			resultMap.put("fundrentplan", fundRentPlanList);
			resultMap.put("finarentplan", null);
			resultMap.put("fundcashdetail", conditionCashFlow);
			resultMap.put("finacashdetail", null);
			resultMap.put("irr", modelData.get("framework_condition.irr"));
			resultMap.put("planIrr", modelData.get("framework_condition.planirr"));
			resultMap.put("renttotalmoney", 0);
			resultMap.put("rentcalculaters", "yes");
			resultMap.put("enddate", endDate);
			resultMap.put("owninfo", ownInfo.getOwnName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	
	/**
	 * 重算现金流
	 * @param fundRentPlanList 租金计划
	 * @param fundChargePlan 资金收付
	 * @throws ParseException 
	 */
	@SuppressWarnings("deprecation")
	private List<ContractCashDetailTemp> resetFundCashFlowInfo(List<ContractFundRentPlanTemp> rentPlanList, List<FundFundChargePlanBean> fundChargePlan) throws ParseException{
		
		// 重组现金流开始第一步，把租金计划当成默认的现金流，后边把资金收付计划合并进来
		List<ContractCashDetailTemp> rentCashFlow = new ArrayList<ContractCashDetailTemp>();
		for(int i = 0; i < rentPlanList.size(); i++){
			ContractFundRentPlanTemp rentPlan = rentPlanList.get(i);
			Date planDate = sdf.parse(rentPlan.getPlanDate());
			ContractCashDetailTemp cashFlow = new ContractCashDetailTemp();
			cashFlow.setId("0");
			cashFlow.setPlanDate(sdm.format(planDate));
			cashFlow.setFundIn(rentPlan.getRent());
			cashFlow.setFundInDetails("租金：" + rentPlan.getRent() + ";");
			cashFlow.setFundOut(new BigDecimal(0));
			cashFlow.setFundOutDetails("");
			cashFlow.setNetFlow(cashFlow.getFundIn().subtract(cashFlow.getFundOut()));
			rentCashFlow.add(cashFlow);
		}
		
		//第二部：合并资金收付计划到现金流中。两层循环，确定资金收付计划在现金流中的位置
		for(int i = 0; i < fundChargePlan.size(); i++){
			
			FundFundChargePlanBean fundFundPlan = fundChargePlan.get(i);
			int monthNew = Integer.parseInt(fundFundPlan.getPlanDate().substring(0,7).replace("-", ""));//2013-03-04 -> 201303
			String month = sdm.format(sdf.parse(fundFundPlan.getPlanDate()));// 看是几月份的收付计划
			
			ContractCashDetailTemp cashFlowNewAdd = new ContractCashDetailTemp();
			int newAddCashFlowLocation = -1;
			
			for(int j = 0; j < rentCashFlow.size(); j++){
				ContractCashDetailTemp cashFlowTemp = rentCashFlow.get(j);
				int monthCash = Integer.parseInt(cashFlowTemp.getPlanDate().replace("-", ""));//2013-03 -> 201303
				
				if (monthNew == monthCash){
					// 和当前的日期相等,合并到现金流中去
					if("pay_type_in".equalsIgnoreCase(fundFundPlan.getPayType())){
						cashFlowTemp.setFundIn(cashFlowTemp.getFundIn().add(new BigDecimal(fundFundPlan.getPlanMoney())));
						cashFlowTemp.setFundInDetails(cashFlowTemp.getFundInDetails() + fundFundPlan.getFeeTypeName() + ":" + fundFundPlan.getPlanMoney() + ";");
					}
					if("pay_type_out".equalsIgnoreCase(fundFundPlan.getPayType())){
						cashFlowTemp.setFundOut(cashFlowTemp.getFundOut().add(new BigDecimal(fundFundPlan.getPlanMoney())));
						cashFlowTemp.setFundOutDetails(cashFlowTemp.getFundOutDetails() + fundFundPlan.getFeeTypeName() + ":" + fundFundPlan.getPlanMoney() + ";");
					}
					cashFlowTemp.setNetFlow(cashFlowTemp.getFundIn().subtract(cashFlowTemp.getFundOut()));
					break;
				} else if(monthNew < monthCash || (monthNew > monthCash && (j+1) == rentCashFlow.size())){
					cashFlowNewAdd.setId("0");
					cashFlowNewAdd.setPlanDate(month);
					if("pay_type_in".equalsIgnoreCase(fundFundPlan.getPayType())){
						cashFlowNewAdd.setFundIn(new BigDecimal(fundFundPlan.getPlanMoney()));
						cashFlowNewAdd.setFundInDetails(fundFundPlan.getFeeTypeName() + ":" + fundFundPlan.getPlanMoney() + ";");
						cashFlowNewAdd.setFundOut(new BigDecimal(0));
						cashFlowNewAdd.setFundOutDetails("");
					}
					if("pay_type_out".equalsIgnoreCase(fundFundPlan.getPayType())){
						cashFlowNewAdd.setFundIn(new BigDecimal(0));
						cashFlowNewAdd.setFundInDetails("");
						cashFlowNewAdd.setFundOut(new BigDecimal(fundFundPlan.getPlanMoney()));
						cashFlowNewAdd.setFundOutDetails(fundFundPlan.getFeeTypeName() + ":" + fundFundPlan.getPlanMoney() + ";");
					}
					cashFlowNewAdd.setNetFlow(cashFlowNewAdd.getFundIn().subtract(cashFlowNewAdd.getFundOut()));
					newAddCashFlowLocation = j;
					break;
				}
			}
			if(newAddCashFlowLocation > -1){
				rentCashFlow.add(newAddCashFlowLocation, cashFlowNewAdd);
			}
		}
		return rentCashFlow;
	}
}
