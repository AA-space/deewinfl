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

import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.risk.ContractRiskAdjust;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;

@Controller(value = "ContractStatusAdjustController")
@RequestMapping(value = "/**/acl")
public class ContractStatusAdjustController {
	private Logger logger=Logger.getLogger(FundOverduerentController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@RequestMapping(value = "/updateContractStatusAdjust.acl")
	public String updateContractRiskAdjust(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 
		 String formData=model.get("formData");
		 JSONObject jsonObject=new JSONObject(formData);
		 ContractInfo info=new ContractInfo();
		 info=(ContractInfo)this.baseService.findEntityByID(ContractInfo.class, (String)jsonObject.get("id"));
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		// this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 this.baseService.copyAndOverrideExistedValueFromJSONObject(jsonObject, info, dictDataClassMapping,false);
		 this.baseService.saveOrUpdateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("调整成功!");
		 }
		return null;
	}
	
}
