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
import com.business.entity.invoice.vat.InvoiceContractInfo;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;


/**
 * @author rovine
 * @date 2014-06-24下午09:39:31
 * @function 
 */
@Controller(value = "invoiceContractInfo")
@RequestMapping(value = "/**/acl")
public class InvoiceContractInfoController extends BaseController {
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	private Logger logger=Logger.getLogger(InvoiceContractInfoController.class);
	@RequestMapping(value = "/addInvoiceContractInfo.acl")
	@ResponseBody
	public String addInvoiceContractInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			String HQLCondition=" from InvoiceContractInfo as cc where cc.contractId.id=?";
			List<InvoiceContractInfo> cicList=this.baseService.findResultsByHSQL(HQLCondition,model.get("contractid"));
			if(cicList!=null&&cicList.size()>0){
				return "新增失败合同号已经存在";
			}
			
			InvoiceContractInfo cInfo=new InvoiceContractInfo();
			this.baseService.copyAndOverrideExistedValueFromStringMap(model,cInfo, null);
			this.baseService.saveEntity(cInfo);
			if (logger.isInfoEnabled()) {
				logger.info("新增成功!");
			}
			return null;
		
	}
	
	@RequestMapping(value = "/removeInvoiceContractInfo.acl")
	@ResponseBody
	public String removeInvoiceContractInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		if("CUST_INFO_COMPANY".equals(model.get("custclass")) || "".equals(model.get("id"))){
			return "删除失败，法人客户合同不能删除!";
		}
		InvoiceContractInfo cInfo =  this.baseService.findEntityByID(InvoiceContractInfo.class, model.get("id"));
		this.baseService.removeEntity(cInfo);
		if (logger.isInfoEnabled()) {
			logger.info("删除成功!");
		}
		return null;
	}
}
