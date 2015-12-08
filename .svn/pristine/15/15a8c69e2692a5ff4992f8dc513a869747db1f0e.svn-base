package com.business.controller.invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.controller.fileTemplate.FileTemplateController;
import com.business.entity.invoice.vat.TaxRentInfo;
import com.business.service.Invoice.TaxRentService;
import com.kernal.utils.QueryUtil;


/**
 * @author 姚俊喜
 * @date 2013-10-11下午09:39:31
 * @email toybaby@tenwa.com.cn
 * @function 
 */
@Controller(value = "taxRentInvoiceController")
@RequestMapping(value = "/**/acl")
public class TaxRentInvoiceController {
	
	
	private Logger logger=Logger.getLogger(TaxRentInvoiceController.class);
	@Resource(name = "taxRentService")
	private TaxRentService baseService;
	/**
	 * @param request
	 * @param response
	 * 本金一次性开具
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitRentCorpusOnce.acl")
	public String submitRentCorpusOnce(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.submitRentCorpusOnce(model);
			if(logger.isInfoEnabled()){
				 logger.info("新增成功!");
			 }
			return null;
		
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 * 租金计划开具 （每期租金）
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitRentPlan.acl")
	public String submitRentPlan(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.submitRentPlan(model);
		if(logger.isInfoEnabled()){
			logger.info("新增成功!");
		}
		return null;
		
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 * 租金计划开具 退回 
	 * @throws Exception
	 */
	@RequestMapping(value = "/backRentPlan.acl")
	public String backRentPlan(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.backRentPlan(model);
		if(logger.isInfoEnabled()){
			logger.info("退回成功!");
		}
		return null;
		
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 * 租金罚息实收 提交 
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitRentIncome.acl")
	public String submitRentIncome(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.submitRentIncome(model);
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
		}
		return null;
		
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 * 租金罚息实收 不生成开票清单 
	 * @throws Exception
	 */
	@RequestMapping(value = "/removeRentIncome.acl")
	public String removeRentIncome(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.removeRentIncome(model);
		if(logger.isInfoEnabled()){
			logger.info("不生成开票清单成功!");
		}
		return null;
		
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 * 租金罚息实收 退回 
	 * @throws Exception
	 */
	@RequestMapping(value = "/backRentIncome.acl")
	public String backRentIncome(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.backRentIncome(model);
		if(logger.isInfoEnabled()){
			logger.info("退回成功!");
		}
		return null;
		
	}
	
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 租金开票红冲增加
	 * @throws Exception
	 */
	@RequestMapping(value = "/addTaxRentHcInfo.acl")
	public String addTaxRentHcInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		for(int i=0;i<model.keySet().size();i++){
			System.out.println("==========="+model.keySet());
		}
		this.baseService.addTaxRentHcInfoInvoice(model);
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
		}
		return null;
	}
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 租金计划开票提交（收据）
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitRentPlanReceipt.acl")
	public  String submitRentPlanReceipt(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		for(int i=0;i<model.keySet().size();i++){
			System.out.println("==========="+model.keySet());
		}
		this.baseService.submitRentPlanReceipt(model);
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
		}
		return null;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 租金计划开票退回（收据）
	 * @throws Exception
	 */
	@RequestMapping(value = "/backRentPlanReceipt.acl")
	public  String backRentPlanReceipt(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		for(int i=0;i<model.keySet().size();i++){
			System.out.println("==========="+model.keySet());
		}
		this.baseService.backRentPlanReceipt(model);
		if(logger.isInfoEnabled()){
			logger.info("退回成功!");
		}
		return null;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 租金实收开票提交（收据）
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitRentIncomeReceipt.acl")
	public  String submitRentIncomeReceipt(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		for(int i=0;i<model.keySet().size();i++){
			System.out.println("==========="+model.keySet());
		}
		this.baseService.submitRentIncomeReceipt(model);
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
		}
		return null;
	}
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 租金实收开票退回（收据）
	 * @throws Exception
	 */
	@RequestMapping(value = "/confirmRentIncomeReceipt.acl")
	public  String confirmRentIncomeReceipt(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		
		this.baseService.confirmRentIncomeReceipt(model);
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
		}
		return null;
	}
	
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 租金实收开票退回（收据）
	 * @throws Exception
	 */
	@RequestMapping(value = "/backRentIncomeReceipt.acl")
	public  String backRentIncomeReceipt(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		for(int i=0;i<model.keySet().size();i++){
			System.out.println("==========="+model.keySet());
		}
		this.baseService.backRentIncomeReceipt(model);
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
		}
		return null;
	}
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 租金计划开票
	 * @throws Exception
	 */
	@RequestMapping(value = "/expTaxRentPlanInvoice.acl")
	public  String expTaxRentPlanInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String excelInfo = this.baseService.updateExpTaxRentInvoice(request, response);
		System.out.println(excelInfo+"=-=-=-=-=");
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.updateRentPlanStatus(model);
		if(logger.isInfoEnabled()){
			logger.info("导出成功!");
		}
		return excelInfo;
	}
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 租金实收开票
	 * @throws Exception
	 */
	@RequestMapping(value = "/expTaxRentIncomeInvoice.acl")
	public  String expTaxRentIncomeInvoice(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String excelInfo = this.baseService.updateExpTaxRentInvoice(request, response);
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.updateRentIncomestatus(model);
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
		}
		return excelInfo;
	}
	/**
	 * @param request
	 * @param response
	 * @return 
	 * @function 租金开票EMS
	 * @throws Exception
	 */
	@RequestMapping(value = "/expTaxRentInvoiceEms.acl")
	public  String expTaxRentInvoiceEms(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String excelInfo = this.baseService.updateExpTaxRentInvoice(request, response);
		System.out.println(excelInfo+"=-=-=-=-=");
		if(logger.isInfoEnabled()){
			logger.info("导出成功!");
		}
		return excelInfo;
	}
}
