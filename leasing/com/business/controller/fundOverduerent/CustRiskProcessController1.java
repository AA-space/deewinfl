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

import com.business.controller.BaseController;
import com.business.entity.contract.risk.ContractRiskProcess1;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;

@Controller(value = "CustRiskProcessController1")
@RequestMapping(value = "/**/acl")
public class CustRiskProcessController1 extends BaseController {
	private Logger logger=Logger.getLogger(FundOverduerentController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
	
	@RequestMapping(value = "/addCustRiskProcess1.acl")
	public String addCustRiskProcess1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 
		 
		   String formData=model.get("formData");
			JSONObject jsonObject=new JSONObject(formData);
		String contractids=(String)	jsonObject.get("contractids");
		jsonObject.remove("contractids");
		String[] str =contractids.split(",");
		for(String ss:str){
				jsonObject.put("contractid", ss);
				System.out.println(jsonObject.toString()+"=====");//
				ContractRiskProcess1 info = new ContractRiskProcess1();
			 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
				dictDataClassMapping.put("DictionaryData", "code");
			 this.baseService.copyAndOverrideExistedValueFromJSONObject(jsonObject,info , dictDataClassMapping,false);
			 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
			 this.baseService.saveEntity(info);	
		}
		 
		
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}
	
	@RequestMapping(value = "/updateCustRiskProcess1.acl")
	public String updateCustRiskProcess1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 
		 String formData=model.get("formData");
		 JSONObject jsonObject=new JSONObject(formData);
		 ContractRiskProcess1 info = new ContractRiskProcess1();
		 info=(ContractRiskProcess1)this.baseService.findEntityByID(ContractRiskProcess1.class, (String)jsonObject.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromJSONObject(jsonObject, info, null,false);
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.saveOrUpdateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}
	
	@RequestMapping(value = "/removeCustRiskProcess1.acl")
	public String removeCustRiskProcess1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 String id=model.get("formData");
		 //DunningRecord info = new DunningRecord();
		// this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.removeEntityById(ContractRiskProcess1.class, id);
		 
		/* ContractRiskProcess info = new ContractRiskProcess();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.removeEntity(info);*/
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}

}
