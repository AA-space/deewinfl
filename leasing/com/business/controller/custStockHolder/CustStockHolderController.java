package com.business.controller.custStockHolder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoContact;
import com.business.entity.cust.CustInfoRelatedPerson;
import com.business.entity.cust.CustStockholder;
import com.business.entity.insurance.InsuranceInfo;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;

/**
 * 
 * @author yuanhx
 * @date 
 * @info 
 * @Copyright Tenwa
 */					
@Controller(value = "custStockHolderController")
@RequestMapping(value = "/**/acl")
public class CustStockHolderController {
	private Logger logger=Logger.getLogger(CustStockHolderController.class);
	@Resource(name = "baseService")
	private BaseService baseService;

	// #################
	@RequestMapping(value = "/addCustStockHolder.acl")
	public String addCustStockHolder(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustStockholder info = new CustStockholder();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");

		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/updateCustStockHolder.acl")
	public String updateCustStockHolder(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustStockholder info = new CustStockholder();
		 info=(CustStockholder)this.baseService.findEntityByID(CustStockholder.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.updateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/removeCustStockHolder.acl")
	public String removeCustStockHolder(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustStockholder info = new CustStockholder();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 
		 this.baseService.removeEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
}
