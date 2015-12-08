package com.business.controller.custShareCompany;

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
import com.business.entity.cust.CustShareCompany;
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
@Controller(value = "custShareCompanyController")
@RequestMapping(value = "/**/acl")
public class CustShareCompanyController {
	private Logger logger=Logger.getLogger(CustShareCompanyController.class);
	@Resource(name = "baseService")
	private BaseService baseService;

	// #################
	@RequestMapping(value = "/addCustShareCompany.acl")
	public String addCustShareCompany(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustShareCompany info = new CustShareCompany();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");

		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/updateCustShareCompany.acl")
	public String updateCustShareCompany(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustShareCompany info = new CustShareCompany();
		 info=(CustShareCompany)this.baseService.findEntityByID(CustShareCompany.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 
		 this.baseService.updateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/removeCustShareCompany.acl")
	public String removeCustShareCompany(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustShareCompany info = new CustShareCompany();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 
		 this.baseService.removeEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
}
