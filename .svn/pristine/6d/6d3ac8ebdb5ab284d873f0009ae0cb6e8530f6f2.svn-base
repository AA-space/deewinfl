package com.business.controller.fundOverduerent;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.entity.contract.risk.ContractRiskAdjust;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;

@Controller(value = "ContractRiskAdjustController")
@RequestMapping(value = "/**/acl")
public class ContractRiskAdjustController {
	private Logger logger=Logger.getLogger(FundOverduerentController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@RequestMapping(value = "/addContractRiskAdjust.acl")
	public String addContractRiskAdjust(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		System.out.println(model + "======");
		String formData = model.get("formData");
		String custid=model.get("cust_id");
		System.out.println(formData + "%%%%%%");
		JSONObject jsonObject = new JSONObject(formData);
		String contractids = (String) jsonObject.get("contractids");
		jsonObject.remove("contractids");
		String[] str = contractids.split(",");
		for (String ss : str) {
			jsonObject.put("contractid", ss);
			System.out.println(jsonObject.toString() + "=====");//
			ContractRiskAdjust info = new ContractRiskAdjust();
			Map<String, String> dictDataClassMapping = new HashMap<String, String>();
			dictDataClassMapping.put("DictionaryData", "code");
			this.baseService.copyAndOverrideExistedValueFromStringMap(model,
					info, dictDataClassMapping);
			this.baseService.copyAndOverrideExistedValueFromJSONObject(
					jsonObject, info, dictDataClassMapping, false);
			info.setCustId(custid);
			this.baseService.saveEntity(info);
		}
		if (logger.isInfoEnabled()) {
			logger.info("新增成功!");
		}
		return null;
	}
	
	@RequestMapping(value = "/updateContractRiskAdjust.acl")
	public String updateContractRiskAdjust(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 
		 String formData=model.get("formData");
		 JSONObject jsonObject=new JSONObject(formData);
		 ContractRiskAdjust info = new ContractRiskAdjust();
		 info=(ContractRiskAdjust)this.baseService.findEntityByID(ContractRiskAdjust.class, (String)jsonObject.get("id"));
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		// this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 this.baseService.copyAndOverrideExistedValueFromJSONObject(jsonObject, info, dictDataClassMapping,false);
		 this.baseService.saveOrUpdateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}
	
	@RequestMapping(value = "/removeContractRiskAdjust.acl")
	public String removeContractRiskAdjust(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 String id=model.get("formData");
		 this.baseService.removeEntityById(ContractRiskAdjust.class, id);
		 
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
	
	
	
	
	
}
