package com.business.controller.fundPayForRent;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.own.OwnAccountController;
import com.business.entity.DictionaryData;
import com.business.entity.asset.FundEbankData;
import com.business.entity.asset.FundEbankProcess;
import com.business.entity.contract.fund.ContractFundFundPayForRent;
import com.business.entity.contract.fund.ContractFundFundPlan;
import com.business.entity.util.OwnInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.business.service.fundPayForRent.FundForRentService;
import com.google.inject.internal.Maps;
import com.kernal.utils.QueryUtil;

/**
 * 

 */
@Controller(value = "FundForRentController")
@RequestMapping(value = "/**/acl")
public class FundForRentController {
	@Resource(name = "fundForRentService")
	private FundForRentService fundForRentService;
	
	@Resource(name = "tableService")
	private TableService tableService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/submitFundForRent.action")
	@ResponseBody
	public String submitFundForRent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);// 把请求数据转成map
		fundForRentService.submitFundForRent(modelData);
		return null;
	}
	
	@RequestMapping(value = "/updateFundforRent.acl")
	public String updateOwnAccount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 fundForRentService.submitFundForRentManager(model);
		 return null;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/submitFundForRentManager.action")
	@ResponseBody
	public String submitFundForRentManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);// 把请求数据转成map
		fundForRentService.submitFundForRentManager(modelData);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateFundForRentManager.action")
	@ResponseBody
	public String updateFundForRentManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);// 把请求数据转成map
		fundForRentService.updateFundForRentManager(modelData);
		return null;
	}

}
