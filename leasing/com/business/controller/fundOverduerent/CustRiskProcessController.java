package com.business.controller.fundOverduerent;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.controller.BaseController;
import com.business.entity.contract.risk.ContractRiskProcess;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;

@Controller(value = "CustRiskProcessController")
@RequestMapping(value = "/**/acl")
public class CustRiskProcessController extends BaseController {
	private Logger logger=Logger.getLogger(FundOverduerentController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
	
	@RequestMapping(value = "/addCustRiskProcess.acl")
	public String addCustRiskProcess(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 ContractRiskProcess info = new ContractRiskProcess();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
			dictDataClassMapping.put("DictionaryData", "code");
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}
	
	@RequestMapping(value = "/updateCustRiskProcess.acl")
	public String updateCustRiskProcess(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 ContractRiskProcess info = new ContractRiskProcess();
		 info=(ContractRiskProcess)this.baseService.findEntityByID(ContractRiskProcess.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.saveOrUpdateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}
	
	@RequestMapping(value = "/removeCustRiskProcess.acl")
	public String removeCustRiskProcess(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 ContractRiskProcess info = new ContractRiskProcess();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.removeEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}

}
