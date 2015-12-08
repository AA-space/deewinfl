package com.business.controller.invoice;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.service.Invoice.TaxFundReceiptService;
import com.kernal.utils.QueryUtil;


/**
 * @author mhy
 * @date 2013-10-11下午09:39:31
 * @email toybaby@tenwa.com.cn
 * @function 
 */
@Controller(value = "taxFundReceiptController")
@RequestMapping(value = "/**/acl")
public class TaxFundReceiptController {
	
	
	private Logger logger=Logger.getLogger(TaxFundReceiptController.class);
	
	
	@Resource(name = "taxFundReceiptService")
	private TaxFundReceiptService baseService;
	
	
	/**
	 * @return 
	 * @function 企划确认收据
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitFundReceipt1.acl")
	public String submitFundReceipt1(HttpServletRequest request, HttpServletResponse response) throws Exception{
			Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.updateFundReceipt1(model);
			if(logger.isInfoEnabled()){
				 logger.info("确认成功!");
				 logger.info(model.get("ids"));
			}
			return null;
	}
	
	
	/**
	 * @return 
	 * @function 财务提交收据
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitFundReceipt2.acl")
	public String submitFundReceipt2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.updateFundReceipt2(model);
		if(logger.isInfoEnabled()){
			logger.info("提交成功!");
			logger.info(model.get("ids"));
		}
		return null;
	}
	
	
	/**
	 * @return
	 * @function 导出收据
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportFundReceipt.acl")
	public void exportFundReceipt(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.updateFundReceipt3(request, response);
		if(logger.isInfoEnabled()){
			logger.info("导出成功!");
			logger.info(model.get("ids"));
		}
	}
	
	/**
	 * @return
	 * @function 退回上一层
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateFundReceiptForReturn.acl")
	public String updateFundReceiptForReturn(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
		this.baseService.updateFundReceiptForReturn(model);
		if(logger.isInfoEnabled()){
			logger.info("退回成功!");
			logger.info(model.get("ids"));
		}
		return null;
	}
}
