package com.business.controller.invoice;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.DictionaryData;
import com.business.entity.contract.invoice.ContractInvoiceInfo;
import com.business.entity.invoice.vat.InvoiceContractInfo;
import com.business.service.BaseService;
import com.kernal.utils.DateUtil;
import com.kernal.utils.QueryUtil;

 
@Controller(value = "invoiceInfoController")
@RequestMapping(value = "/**/acl")
public class InvoiceInfoController extends BaseController {
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	private Logger logger=Logger.getLogger(InvoiceInfoController.class);
	 
	
	@RequestMapping(value = "/updateInvoiceWHInfo.acl")
	@ResponseBody
	public String updateInvoiceWHInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		ContractInvoiceInfo cInfo =  this.baseService.findEntityByID(ContractInvoiceInfo.class, model.get("id"));
		cInfo.setTaxNumber(model.get("taxnumber"));
		cInfo.setInvoiceOpenBank(model.get("invoiceopenbank"));
		cInfo.setInvoiceNumber(model.get("invoicenumber"));
		cInfo.setInvoiceAddress(model.get("invoiceaddress"));
		cInfo.setInvoiceTel(model.get("invoicetel"));
		cInfo.setInvoiceType( this.baseService.findEntityByID(DictionaryData.class,model.get("invoicetype")) );
		cInfo.setModifyDate(DateUtil.getSystemDateTime());
		cInfo.setIskfp("0");
		this.baseService.updateEntity(cInfo);
		if (logger.isInfoEnabled()) {
			logger.info("修改成功!");
		}
		return null;
	}
}
