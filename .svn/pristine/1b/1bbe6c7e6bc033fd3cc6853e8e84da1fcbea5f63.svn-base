package com.business.controller.financeReport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.exception.BusinessException;
import com.business.service.financeReport.FinanceReportService;
@Controller(value = "financeReportImportController")
@RequestMapping(value = "/**/leasing")
public class FinanceReportImportController extends BaseController{
   
	@Resource(name="financeReportService")
	private FinanceReportService financeReportService;
	@RequestMapping(value = "/finance/importFinacne.acl")
	@ResponseBody
	public String imprtFinance(HttpServletRequest request,
			HttpServletResponse response)  throws Exception {
		String message="";
		try {
			message=this.financeReportService.insertFinanceReport(request, response);
		}catch(BusinessException b){
			message=b.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 throw new BusinessException("没有上传财务报表");
		}
	    String ajaxCallBackScript = "<script type='text/javascript'>window.parent.importEbankCallBack(\""+message+"\");</script>";
		this.ajaxReturn(response, ajaxCallBackScript);
		return  null;
		
	}
}
