package com.business.controller.managerDistrict;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.service.managerDistrict.ManagerDistrictService;
import com.kernal.utils.QueryUtil;

@Controller(value = "ManagerDistrictController")
@RequestMapping(value = "/**/acl")
public class ManagerDistrictController extends BaseController {
	@Resource(name = "managerDistrict")
	private ManagerDistrictService baseService;
	
	
	@RequestMapping(value = "/addmanagerDistrict.acl")
	@ResponseBody
	public String addManagerDistrict(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.addManagerDistrict(model);
		}catch (Exception e) {
			return "添加失败!["+e.getMessage()+"]";
		}
		return null;
	}
	
	@RequestMapping(value = "/updatemanagerDistrict.acl")
	@ResponseBody
	public String updateManagerDistrict(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.updateManagerDistrict(model);
		}catch (Exception e) {
			return "修改失败!["+e.getMessage()+"]";
		}
		return null;
	}
	
	@RequestMapping(value = "/removemanagerDistrict.acl")
	@ResponseBody
	public String removeManagerDistrict(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.removeManagerDistrict(model);
		}catch (Exception e) {
			return "删除失败!["+e.getMessage()+"]";
		}
		return null;
	}

}

