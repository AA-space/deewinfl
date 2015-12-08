package com.business.controller.invoice;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.service.Invoice.TaxFundService;
import com.business.service.Invoice.TaxRentService;
import com.kernal.utils.QueryUtil;


/**
 * @author 姚俊喜
 * @date 2013-10-11下午09:39:31
 * @email toybaby@tenwa.com.cn
 * @function 
 */
@Controller(value = "taxFundInvoiceController")
@RequestMapping(value = "/**/acl")
public class TaxFundInvoiceController {
	
	
	private Logger logger=Logger.getLogger(TaxFundInvoiceController.class);
	@Resource(name = "taxFundService")
	private TaxFundService baseService;
	
	@Resource(name = "taxRentService")
	private TaxRentService taxRentService;
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 资金计划开票  提交
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitFundPlanInvoice.acl")
	public String submitFundPlanInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.submitFundPlanInvoice(model);
			if(logger.isInfoEnabled()){
				 logger.info("提交成功!");
			 }
			return null;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 资金开票红冲增加
	 * @throws Exception
	 */
	@RequestMapping(value = "/addTaxFundHcInfo.acl")
	public String addTaxFundHcInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		for(int i=0;i<model.keySet().size();i++){
			System.out.println(model.keySet());
		}
		this.baseService.addTaxFundHcInfoInvoice(model);
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
		}
		return null;
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 * @function 资金计划开票 退回
	 * @throws Exception
	 */
	@RequestMapping(value = "/backFundPlanInvoice.acl")
	public String backFundPlanInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.backFundPlanInvoice(model);
		if(logger.isInfoEnabled()){
			logger.info("退回成功!");
		}
		return null;
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 * @function 资金实收开票 提交
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitFundChargeInvoice.acl")
	@ResponseBody
	public String submitFundChargeInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		try {
			this.baseService.submitFundChargeInvoice(model);
		} catch (Exception e) {
			return "提交失败！"+e.getMessage();
		}
		
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
		}
		return null;
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 * @function 资金实收开票   不开票
	 * @throws Exception
	 */
	@RequestMapping(value = "/removeFundChargeInvoice.acl")
	public String removeFundChargeInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.removeFundChargeInvoice(model);
		if(logger.isInfoEnabled()){
			logger.info("不开票成功!");
		}
		return null;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 * @function 资金实收开票   
	 * @throws Exception
	 */
	@RequestMapping(value = "/backFundChargeInvoice.acl")
	public String backFundChargeInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.backFundChargeInvoice(model);
		if(logger.isInfoEnabled()){
			logger.info("退回成功!");
		}
		return null;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 资金计划开票
	 * @throws Exception
	 */
	@RequestMapping(value = "/expTaxFundInvoice.acl")
	public  String expTaxRentPlanInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String excelInfo = this.taxRentService.updateExpTaxRentInvoice(request, response);
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.updateFundstatus(model);
		if(logger.isInfoEnabled()){
			logger.info("导出成功!");
		}
		return excelInfo;
	}
	
}
