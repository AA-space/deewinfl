package com.business.controller.checkMoney;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.record.chart.BeginRecord;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.proj.ProjInfo;
import com.business.entity.proj.ProjVote;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.utils.DateUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author rovine
 * @date 2013-11-15上午10:55:13
 * @info 设备验收判断首付款的的Action
 * @Copyright 
 * Tenwa
 */
@Controller(value="CheckMoneyController")
@RequestMapping(value="/**/leasing")
public class CheckMoneyController {
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name = "tableService")
	private TableService tableService;
	
	@RequestMapping(value="/checkMoney/checkMoney.action")
	@ResponseBody
	public String checkMoney(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);//把请求数据转成map
	    String contractid=modelData.get("contract_id");
	    Map<String, String> queryMainObjectMap = new HashMap<String, String>();
		queryMainObjectMap.put("contract_id", contractid);
		
	    Double plan =0.0;
	    Double charge =0.0 ;
	    
	    ContractInfo cinfo=this.baseService.findEntityByID(ContractInfo.class, contractid);
	    if (!cinfo.getFundFundChargePlans().isEmpty()) {// 资金计划
	    	String planstr=this.tableService.getJsonArrayData("eleasing/workflow/contract/fund_fund_charge_plan.xml", queryMainObjectMap).toString();;
	      	JSONArray jsonArray = new JSONArray(planstr);
	      	
	      	for(int i=0;i<jsonArray.length();i++){
				  JSONObject jsonObj = jsonArray.getJSONObject(i);
				  if("pay_type_in".equals(jsonObj.get("paytype")))
				  {
				     plan+=Double.parseDouble(jsonObj.get("planmoney").toString());
					 // System.out.println("plan"+plan);
						
				  }
			}
      }
      
      if (!cinfo.getFundFundCharges().isEmpty()) {// 资金实收
      	String varstr=this.baseService.getCollectionEntitiesPropertiesToJsonArrayString(cinfo.getFundFundCharges(), null, "");
      	JSONArray jsonArray = new JSONArray(varstr);
      	
      	for(int i=0;i<jsonArray.length();i++){
			  JSONObject jsonObj = jsonArray.getJSONObject(i);
			  if("pay_type_in".equals(jsonObj.get("paytype")))
			  {
			    	charge+=Double.parseDouble(jsonObj.get("factmoney").toString());
			    	//System.out.println("charge"+charge);
			  }
		}
      }
      if(plan>charge){
    	  return "首付款没有付清";
      }else{
    	  return "";
      }
	}
}
