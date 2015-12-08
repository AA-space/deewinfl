package com.business.controller.fundCollection;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.entity.DictionaryData;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankProcess;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.service.BaseService;
import com.google.inject.internal.Maps;
import com.kernal.utils.QueryUtil;

/**
 * 
 * @author 徐云龙
 * @date 2013-4-21上午10:37:13
 * @info 查出这个合同下收款计划和网银余额
 * @Copyright Tenwa
 */
@Controller(value = "FundCheckController")
@RequestMapping(value = "/**/leasing")
public class FundCheckController {
	@Resource(name = "baseService")
	private BaseService baseService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fund/getFundCheckData.action")
	@ResponseBody
	public String getCurrentPlanList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);// 把请求数据转成map
		String contractid = modelData.get("contractid");
		String ebankid = modelData.get("ebankid");
		String paytype = modelData.get("paytype");
		String ebankProcessId = modelData.get("ebankProcess");
		  
		DecimalFormat doubleformat = new DecimalFormat("###0.00");
		String HQL = "";
		BigDecimal lastEbankMoney = BigDecimal.ZERO;
		//BigDecimal rentMoney = BigDecimal.ZERO;
		//BigDecimal fundMoney = BigDecimal.ZERO;
		BigDecimal  processMoeny = BigDecimal.ZERO;
		List<FundEbankData> list_ebank = new ArrayList<FundEbankData>();
		System.out.println(ebankid);
		if (ebankid != null && (!ebankid.equalsIgnoreCase(""))) {
			//资金计划
			/*HQL = "select sum(fc.factMoney) from ContractFundFundCharge as fc where fc.ebankNumber.ebdataId=?";
			List<Object> fundChargeList = this.baseService.findResultsByHSQL(HQL, ebankid);
			if(fundChargeList.size() > 0){
				fundMoney = new BigDecimal(fundChargeList.get(0).toString());
			}
 			
			// 记查网银已核销的资金的金额
			HQL = "select sum(fc.rent+fc.penalty) from ContractFundRentInCome as fc where fc.ebankNumber.ebdataId=?";
			List<Object> rentIncomeList = this.baseService.findResultsByHSQL(HQL, ebankid);
			if(rentIncomeList.size() > 0){
				rentMoney = new BigDecimal(rentIncomeList.get(0).toString());
			}

			*/
			
			HashMap<String, Object> propertiesMap = new HashMap<String, Object>();
			propertiesMap.put("ebdataId", ebankid);
			
			//过程表
			FundEbankProcess ebankProcess = (FundEbankProcess) this.baseService.findEntityByID(FundEbankProcess.class, ebankProcessId);
			processMoeny =  ebankProcess.getProcessAmount();
			
			//网银余额
			list_ebank = this.baseService.findEntityByProperties(FundEbankData.class, propertiesMap);
			FundEbankData fundBank;
			if (list_ebank.size() > 0) {
				fundBank = list_ebank.get(0);
				//lastEbankMoney = fundBank.getFactMoney().subtract(rentMoney).subtract(fundMoney);
				fundBank.initFundEbank();
				lastEbankMoney = fundBank.getMayOpeMoney().add(processMoeny);
				System.out.print(lastEbankMoney);
			}
		}
		HQL = " from DictionaryData AS DD where DD.belongDictionary.code=? ";
		List<DictionaryData> listpayType = new ArrayList<DictionaryData>();
		// 查出资金状态
		listpayType = this.baseService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
		HashMap<String, DictionaryData> mapPayType = new HashMap<String, DictionaryData>();
		for (DictionaryData dd : listpayType) {
			mapPayType.put(dd.getCode(), dd);
		}
		HQL = " from ContractFundFundPlan as fc where fc.contractId.id=? and fc.payType.code=?and fc.invalid=?";
		List<ContractFundFundPlan> fundPlan = new ArrayList<ContractFundFundPlan>();
		fundPlan =  this.baseService.findResultsByHSQL(HQL, contractid, paytype,"0");
		List<ContractFundFundPlan> fundPlanR = new ArrayList<ContractFundFundPlan>();
		List FundDate = new ArrayList<String>();
		if (fundPlan.size() > 0) {
			for (ContractFundFundPlan fplan : fundPlan) {
				fplan.receiverAllMoney(mapPayType);
				FundDate.add("{'paymentid':'" + fplan.getPaymentId() + "','planmoney':'" + doubleformat.format(fplan.getPlanMoney()) + "','receivermoney':'"
						+ doubleformat.format(fplan.getReceiverMoney()) + "','adjustmoney':'" + doubleformat.format(fplan.getAdjustMoney()) + "','lastmoney':'"
						+ doubleformat.format(fplan.getPlanbalance()) + "'}");
			}
		}

		return "{'ebank':[{'ebankid':'" + ebankid + "','mayopemoney':'" + doubleformat.format(lastEbankMoney) + "'}],'fund':" + FundDate.toString() + "}";
	}

	@RequestMapping(value = "/fund/getCanHireMoeny.action")
	@ResponseBody
	public String getCanHireMoeny(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ebankid = request.getParameter("ebankid");
		BigDecimal returnValue = new BigDecimal("-1.00");

		Map<String, Object> properMap = Maps.newHashMap();
		properMap.put("ebdataId", ebankid);
		List<FundEbankData> ebankDataList = this.baseService.findEntityByProperties(FundEbankData.class, properMap);

		if (ebankDataList.size() == 1) {
			FundEbankData ebankData = ebankDataList.get(0);
			ebankData.initFundEbank();
			returnValue = ebankData.getMayOpeMoney();
		}
		return returnValue.toString();
	}

}
