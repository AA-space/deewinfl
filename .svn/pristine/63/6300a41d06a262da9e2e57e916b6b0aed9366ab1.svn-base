package com.business.controller.insure;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.service.Insurance.InsuranceService;
import com.kernal.utils.QueryUtil;

/**
 * 
 * @author 孙传良
 * @date 2013-4-22上午10:30:01
 * @info 保险功能
 * @Copyright Tenwa
 */
@Controller(value = "insuranceInfoController")
@RequestMapping(value = "/**/acl")
public class InsuranceInfoController {
	private Logger logger=Logger.getLogger(InsuranceInfoController.class);
	@Resource(name = "insuranceService")
	private InsuranceService baseService;

	// #################
	@RequestMapping(value = "/addInsuranceInfo.acl")
	public String addInsuranceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.addInsurance(model);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/updateInsuranceInfo.acl")
	public String updateInsuranceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 //InsuranceInfo info = new InsuranceInfo();
		 //this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 
		 //this.baseService.updateEntity(info);
		 this.baseService.updateInsurance(model);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/removeInsuranceInfo.acl")
	public String removeInsuranceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 //InsuranceInfo info = new InsuranceInfo();
		// this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		// ContractInfo contractId=new ContractInfo();
		// contractId.setId(model.get("contractid").split("/")[0]);
		 //info.setContractId(contractId);
		 //this.baseService.removeEntity(info);
		 this.baseService.removeInsurance(model);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
}
