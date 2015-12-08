package com.business.controller.asset;

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
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.service.BaseService;
import com.kernal.utils.DateUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.StringUtil;

/**
 * 
 * @author 徐云龙
 * @date 2013-4-21上午10:37:13
 * @info 查出这个合同下收款计划和网银余额
 * @Copyright 
 * Tenwa   
 */
@Controller(value="RentCheckController")
@RequestMapping(value="/**/leasing")
public class RentCheckController {
	@Resource(name = "baseService")
	private BaseService baseService;
	@RequestMapping(value="/rent/getRentCheckData.action")
	@ResponseBody
	public String getCurrentPlanList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);//把请求数据转成map
	    String contractid=modelData.get("contractid");
	    String ebankid=modelData.get("ebankid");
	    String rentlist=modelData.get("rentlist");
	    String ebankProcessId = modelData.get("ebankProcess");
	    
	    //流程占用字段
	    FundEbankProcess ebankProcess = (FundEbankProcess) this.baseService.findEntityByID(FundEbankProcess.class, ebankProcessId);
	    BigDecimal  processMoeny =  ebankProcess.getProcessAmount();
	    
	    DecimalFormat   doubleformat   =   new   DecimalFormat("###0.00"); 
	    BigDecimal rate=new BigDecimal("0.00");
	    String HQL="";
	    BigDecimal   lastEbankMoney=BigDecimal.ZERO;
	    Double rentMoney=0.00;
	    Double fundMoney=0.00;
	    List<FundEbankData> list_ebank=new ArrayList<FundEbankData>();
	    if (ebankid!=null && (!ebankid.equalsIgnoreCase(""))){
	    HashMap<String,Object>propertiesMap=new HashMap<String,Object>();
		propertiesMap.put("ebdataId", ebankid);
		list_ebank=this.baseService.findEntityByProperties(FundEbankData.class, propertiesMap);
		FundEbankData fundBank;
			fundBank=list_ebank.get(0);	
			fundBank.initFundEbank();
			//可用金额加上流程占用金额
			lastEbankMoney=fundBank.getMayOpeMoney().add(processMoeny);
	    HQL=" from ContractInfo as c where c.contractId=?";
		ContractInfo contractinfo;            
		contractinfo=(ContractInfo)this.baseService.findResultsByHSQL(HQL, contractid).get(0);
		HQL=" from DictionaryData AS DD where DD.belongDictionary.code=? ";
		List<DictionaryData> listpayType=new ArrayList<DictionaryData>();
		//查出资金状态
		listpayType=this.baseService.findResultsByHSQL(HQL, "PLANMANYSTATUS");
		HashMap<String,DictionaryData> mapPayType=new HashMap<String,DictionaryData>();
		for(DictionaryData dd:listpayType){
			mapPayType.put(dd.getCode(), dd);
		}
	    HQL=" from ContractFundRentPlan as fc where fc.contractId.contractId=? and rentList in("+rentlist+") ";
	    List<ContractFundRentPlan> fundPlan=new ArrayList<ContractFundRentPlan>();
	    fundPlan=this.baseService.findResultsByHSQL(HQL,contractid);
	  //罚息利率
		rate=new BigDecimal(StringUtil.empty2Other(contractinfo.getContractCondition().getPenaRate(), "0.00"));
		//当前时间
		String cur_date= fundBank.getFactDate();
		//免罚息天数 
		int freeDefaInterDay;
		freeDefaInterDay=Integer.parseInt(StringUtil.empty2Other(contractinfo.getContractCondition().getFreeDefaInterDay(), "0")) ;
	    List<ContractFundRentPlan> fundPlanR=new ArrayList<ContractFundRentPlan>();
	    List FundDate=new ArrayList<String>();
	    if(fundPlan.size()>0){
	    for(ContractFundRentPlan fplan:fundPlan){
	    	fplan.initContractFundRentPlan(mapPayType,cur_date,rate,freeDefaInterDay);
	    	String temp="{\"rentlist\":\""+fplan.getRentList()+"\",\"rentov\":\""+doubleformat.format(fplan.getCurRentOverage())+"\",\"corpusov\":\""+doubleformat.format(fplan.getCurCorpusOverage())+"\",\"interestov\":\""+doubleformat.format(fplan.getCurInterestOverage())+"\",\"penaltyov\":\""+doubleformat.format(fplan.getPenaltyOverage())+"\"";
	    	temp=temp+",\"corpus\":\""+doubleformat.format(fplan.getCurCorpusIncome())+"\",\"interest\":\""+doubleformat.format(fplan.getCurinterestIncome())+"\",\"penalty\":\""+doubleformat.format(fplan.getCurpenaltyIncome());
	    	temp=temp+"\",\"interestadjust\":\""+doubleformat.format(fplan.getCurinterestAdjustIncome())+"\",\"penaltyadjust\":\""+doubleformat.format(fplan.getCurpenaltyAdjustIncome())+"\"}";
	    	FundDate.add(temp);
	       }
	    }
	    return "{\"ebank\":[{\"ebankid\":\""+ebankid+"\",\"mayopemoney\":\""+doubleformat.format(lastEbankMoney)+"\"}],\"fund\":"+FundDate.toString()+"}";
	} 
	    return "";
	}
	}
