package com.business.controller.invoice;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.service.Invoice.TaxVatService;
import com.kernal.utils.QueryUtil;


/**
 * @author 姚俊喜
 * @date 2013-10-11下午09:39:31
 * @email toybaby@tenwa.com.cn
 * @function 
 */
@Controller(value = "taxVatInfoController")
@RequestMapping(value = "/**/acl")
public class TaxVatInfoController {
	
	
	private Logger logger=Logger.getLogger(TaxVatInfoController.class);
	@Resource(name = "taxVatService")
	private TaxVatService baseService;
	@RequestMapping(value = "/addTaxVatInfo.acl")
	public String addTaxVatInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.addTaxVatInfo(model);
			if(logger.isInfoEnabled()){
				 logger.info("新增成功!");
			 }
			return null;
		
	}
	
	@RequestMapping(value = "/updateTaxVatInfo.acl")
	public String updateTaxVatInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.updateTaxVatInfo(model);
		if(logger.isInfoEnabled()){
			logger.info("修改成功!");
		}
		return null;
		
	}
	@RequestMapping(value = "/submitTaxVatInfo.acl")
	public String submitTaxVatInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.submitTaxVatInfo(model);
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
		}
		return null;
		
	}
	@RequestMapping(value = "/confirmTaxVatInfo.acl")
	public String confirmTaxVatInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.confirmTaxVatInfo(model);
		if(logger.isInfoEnabled()){
			logger.info("确认成功!");
		}
		return null;
		
	}
	@RequestMapping(value = "/backTaxVatInfo.acl")
	public String backTaxVatInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.backTaxVatInfo(model);
		if(logger.isInfoEnabled()){
			logger.info("确认成功!");
		}
		return null;
		
	}
	
}
