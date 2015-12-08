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
import org.codehaus.jackson.map.ObjectMapper;
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
import com.google.inject.internal.Maps;
import com.kernal.utils.DateUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.SecurityUtil;

/**
 * 
 * @author rovine
 * @date 2013-11-18上午10:55:13
 * @info 信审获取经销商剩余金额Action
 * @Copyright 
 * Tenwa
 */
@Controller(value="getCreditMoneyController")
@RequestMapping(value="/**/leasing")
public class GetCreditMoneyController {
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name = "tableService")
	private TableService tableService;
	
	@RequestMapping(value="/checkMoney/getCreditMoney.action")
	@ResponseBody
	public String getCreditMoney(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);//把请求数据转成map
	    String deptid=modelData.get("deptid");
	  
	    Double plan =0.0;
	    Double charge =0.0 ;
	   // System.out.println("deptid"+deptid);
	    Map<String, String> income = Maps.newHashMap(); 
	     income.put("deptid",deptid);
	    String firstpayment = this.tableService.getJsonArrayData("eleasing/jsp/dealer_manage/dealer_credit_money.xml", income).toString();
	    JSONArray jsonArray = new JSONArray(firstpayment);
	    JSONObject jsonObj = jsonArray.getJSONObject(0);
		//System.out.println(jsonObj.get("lastcreditmoney")); 
		 
		return jsonObj.get("lastcreditmoney").toString();
	
     
	}
}
