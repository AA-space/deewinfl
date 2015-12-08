package com.business.controller.intereasVoucher;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.controller.BaseController;
import com.business.entity.voucher.IntereasVoucherHead;
import com.business.service.BaseService;
import com.business.service.voucher.IntereasVoucherentriesService;
import com.kernal.utils.QueryUtil;

@Controller(value = "intereasVoucherController")
@RequestMapping(value = "/**/leasing")
public class IntereasVoucherController extends BaseController{
	@Resource(name = "baseService")
	private BaseService baseService;

	@Resource(name = "intereasVoucherentriesService")
	private IntereasVoucherentriesService intereasVoucherentriesService;
	// #################
	@RequestMapping(value = "/addInsuranceInfo.action")
	public String addInsuranceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		String vouchernumber = model.get("vouchernumber");
		IntereasVoucherHead intereasVoucherHead = this.baseService.findEntityByID(IntereasVoucherHead.class, vouchernumber);
		request.setAttribute("intereasVoucherHead", intereasVoucherHead);
		return "solutions/leasing/voucher/voucher_detail.jsp";
	}
	
	
	
	// #################
	@RequestMapping(value = "/updateInsuranceInfo.action")
	public String updateInsuranceInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 IntereasVoucherHead intereasVoucherHead  = this.baseService.findEntityByID(IntereasVoucherHead.class, model.get("id"));
		 request.setAttribute("intereasVoucherHead", intereasVoucherHead);
			System.out.println("#####:"+intereasVoucherHead.getIntereasVoucherEntries());
		 
		return "solutions/leasing/voucher/voucher_mod.jsp";
	}
	
	
	// #################
	@RequestMapping(value = "/toEas.action")
	public String toEas(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,String> model = QueryUtil.getRequestParameterMapByAjax(request);
		
		/* 调用之后会直接导出凭证到EAS系统
		 * 目前尚未完成内容 
		 *  1、到eas之后只有一条分录
		 * 	2、导出成功之后需要在凭证实体中做记录，
		 *  3、不知道什么情况为导出成功，什么情况为导出不成功，需要做判读
		 *  4、导出之后不能再次导出限制
		 *  上述完成之后取消intereasVoucherentriesService.saveToEas(model);注释就导出
		 */
		intereasVoucherentriesService.saveToEas(model);
		return null;
	}
	
	

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public BaseService getBaseService() {
		return baseService;
	}
}