package com.business.controller.cust;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.entity.cust.CustInfo;
import com.business.exception.BusinessException;
import com.business.service.cust.CustService;
import com.google.inject.internal.Maps;
import com.kernal.utils.QueryUtil;

/**
 * @author Toybaby
 * 2013-5-22下午03:46:19
 * TODO 自然人信息
 * toybaby@tenwa.com.cn
 * Tenwa
 */
@Controller(value = "CustEwlpController")
@RequestMapping(value = "/**/acl")
public class CustEwlpController {
	@Resource(name = "custService")
	private CustService baseService;
	// #################
	
	/**
	 * 获取客户基本信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getCustInfo.acl")
	@ResponseBody
	public String getCustInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CustInfo custInfo = new CustInfo();
		try {
			String custId = request.getParameter("cust_id");
			custInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, custId);
			if(custInfo == null){
				throw new BusinessException("未查到ID为【" +custId+ "】客户记录");
			}
			
		} catch (Exception e) {
			return "查询失败![" + e.getMessage() + "]";
		}
		
		Map<String,String> map = Maps.newHashMap();
		map.put("id", custInfo.getId());
		map.put("custType", custInfo.getCustClass().getCode());
		
		ObjectMapper mapper = new ObjectMapper();
		String custString = mapper.writeValueAsString(map);
		return custString;
	}
	
	
	@RequestMapping(value = "/addCustEwlp.acl")
	@ResponseBody
	public String addCustEwlp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.addCustEwlp(model);
		}catch (Exception e) {
			return "添加失败!["+e.getMessage()+"]";
		}
		return null;
	}

	@RequestMapping(value = "/updateCustEwlp.acl")
	@ResponseBody
	public String updateCustEwlp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.updateCustEwlp(model);
		}catch (Exception e) {
			return "修改失败!["+e.getMessage()+"]";
		}
		return null;
	}

	@RequestMapping(value = "/removeCustEwlp.acl")
	@ResponseBody
	public String removeCustEwlp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.removeCustEwlp(model);
		}catch (Exception e) {
			return "作废失败!["+e.getMessage()+"]";
		}
		return null;
	}
	
	@RequestMapping(value = "/resetCustEwlp.acl")
	@ResponseBody
	public String resetCustEwlp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.resetCustEwlp(model.get("id"));
		}catch (Exception e) {
			return "撤销删除失败!["+e.getMessage()+"]";
		}
		return null;
	}
}
