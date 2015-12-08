package com.business.controller.cardhire;

 

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.base.BaseFile;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.cardhire.ContractCardHireService;
import com.kernal.utils.QueryUtil;

/**
 * 
 * @author 孙传良
 * @date 2013-9-10下午10:25:57
 * @info
 * @Copyright 
 * Tenwa
 */
@Controller(value = "ContractCardHire")
@RequestMapping(value = "/**/acl")
public class ContractCardHireController extends BaseController {

	
	
	@Resource(name="cardHireService")
	private ContractCardHireService cardHireService;
	
	@Resource(name="baseService")
	private BaseService baseService;
	
	@ResponseBody
	@RequestMapping(value = "/deleteUploadCardHire.acl")
	public String deleteUploadCardHire(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String bid = request.getParameter("b_id");
		if ( bid != null )
		{
			String sql = "update contract_fund_rent_income_temp  set up_id='' where up_id=?";
			String sql2 = "update contract_fund_rent_income  set up_id='' where up_id=?";
			String sql3 = "delete from  contract_card_rent_income where upload_id = ?";
			String hsql = "delete from b_file_recorder where base_file=? ";
			String hsql2 = "delete from  b_file where  id=? ";
			this.baseService.updateBySql( sql, bid );
			this.baseService.updateBySql( sql2, bid );
			this.baseService.updateBySql( sql3, bid );
			this.baseService.updateBySql( hsql, bid );
			this.baseService.updateBySql( hsql2,bid );
			return  "yes";
		}
		return "no";
	}

	@ResponseBody
	@RequestMapping(value = "/addUploadCardHire.acl")
	public String addUploadCardHire(HttpServletRequest request,HttpServletResponse response)  throws Exception {
		String message="";
		try{
            message=this.cardHireService.addUploadCardHire(request, response);
		}
		 catch (BusinessException e) {
			 e.printStackTrace();
			message=e.getMessage().toString();
		}catch(Exception e){
			e.printStackTrace();
			message=e.getMessage().toString();
		}
		 message=message.replaceAll("\"", "");
	    String ajaxCallBackScript = "<script type='text/javascript'>window.parent.importEbankCallBack(\""+message+"\");</script>";
		this.ajaxReturn(response, ajaxCallBackScript);
		return  null;
	}
	
	/**
	 * 把勾选的卡扣回盘文件数据核销到临时表中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/addCardHireToIncome.acl")
	public String addCardHireToIncome(HttpServletRequest request,HttpServletResponse response)  throws Exception {
		Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
		String message="";
		message=this.cardHireService.addCardHireToIncome(modelData);
		return message;
	}
	
	/**
	 * 把勾选的卡扣回盘文件数据核销到临时表中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteCardHireToIncome.acl")
	public String deleteCardHireToIncome(HttpServletRequest request,HttpServletResponse response)  throws Exception {
		Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
		String message=this.cardHireService.deleteCardHireToIncomeControl(modelData);
		return message;
	}
}

