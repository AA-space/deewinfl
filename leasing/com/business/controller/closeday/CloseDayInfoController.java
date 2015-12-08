package com.business.controller.closeday;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.voucher.InterFinanceCloseDay;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;


@Controller(value = "closeDayInfoController")
@RequestMapping(value = "/**/acl")
public class CloseDayInfoController extends BaseController {
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	private Logger logger=Logger.getLogger(CloseDayInfoController.class);
	@RequestMapping(value = "/addCloseDayInfo.acl")
	@ResponseBody
	public String addCloseDayInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			
			InterFinanceCloseDay interFinanceCloseDay = new InterFinanceCloseDay();
			this.baseService.copyAndOverrideExistedValueFromStringMap(model,interFinanceCloseDay, null);
			this.baseService.saveEntity(interFinanceCloseDay);
			if (logger.isInfoEnabled()) {
				logger.info("新增成功!");
			}
			return null;
		
	}
	@RequestMapping(value = "/updateCloseDayInfo.acl")
	@ResponseBody
	public String updateCloseDayInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		InterFinanceCloseDay cInfo =  this.baseService.findEntityByID(InterFinanceCloseDay.class, model.get("id"));
		
		this.baseService.copyAndOverrideExistedValueFromStringMap(model,cInfo, null);
		this.baseService.updateEntity(cInfo);
		if (logger.isInfoEnabled()) {
			logger.info("修改成功!");
		}
		return null;
	}
	@RequestMapping(value = "/removeCloseDayInfo.acl")
	@ResponseBody
	public String removeCloseDayInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		InterFinanceCloseDay cInfo =  this.baseService.findEntityByID(InterFinanceCloseDay.class, model.get("id"));
		this.baseService.removeEntity(cInfo);
		
		if (logger.isInfoEnabled()) {
			logger.info("删除成功!");
		}
		return null;
	}
}
