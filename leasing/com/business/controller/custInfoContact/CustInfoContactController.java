package com.business.controller.custInfoContact;

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
@Controller(value = "custInfoContactController")
@RequestMapping(value = "/**/acl")
public class CustInfoContactController {
	private Logger logger=Logger.getLogger(CustInfoContactController.class);
	@Resource(name = "baseService")
	private BaseService baseService;

	// #################
	@RequestMapping(value = "/addCustInfoContact.acl")
	public String addCustInfoContact(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustInfoContact info = new CustInfoContact();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
			dictDataClassMapping.put("DictionaryData", "code");
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 CustInfo cInfo=new CustInfo();
		 cInfo.setId(model.get("custId"));
		 info.setCustId(cInfo);
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/updateCustInfoContact.acl")
	public String updateCustInfoContact(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustInfoContact info = new CustInfoContact();
		 info=(CustInfoContact)this.baseService.findEntityByID(CustInfoContact.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.updateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/removeCustInfoContact.acl")
	public String removeCustInfoContact(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustInfoContact info = new CustInfoContact();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.removeEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
}
