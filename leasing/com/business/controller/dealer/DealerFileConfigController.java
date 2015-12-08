package com.business.controller.dealer;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.dealer.DealerFileConfig;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;


@Controller(value = "dealerFileConfigController")
@RequestMapping(value = "/**/acl")
public class DealerFileConfigController extends BaseController {
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	private Logger logger=Logger.getLogger(DealerFileConfigController.class);
	@RequestMapping(value = "/addDealerFileConfig.acl")
	@ResponseBody
	public String addDealerFileConfig(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			
			DealerFileConfig fileConfig = new DealerFileConfig();
			this.baseService.copyAndOverrideExistedValueFromStringMap(model,fileConfig, null);
			this.baseService.saveEntity(fileConfig);
			if (logger.isInfoEnabled()) {
				logger.info("新增成功!");
			}
			return null;
		
	}
	@RequestMapping(value = "/updateDealerFileConfig.acl")
	@ResponseBody
	public String updateDealerFileConfig(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		DealerFileConfig fileConfig =  this.baseService.findEntityByID(DealerFileConfig.class, model.get("id"));
		
		this.baseService.copyAndOverrideExistedValueFromStringMap(model,fileConfig, null);
		this.baseService.updateEntity(fileConfig);
		if (logger.isInfoEnabled()) {
			logger.info("修改成功!");
		}
		return null;
	}
	@RequestMapping(value = "/removeDealerFileConfig.acl")
	@ResponseBody
	public String removeDealerFileConfig(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		DealerFileConfig fileConfig =  this.baseService.findEntityByID(DealerFileConfig.class, model.get("id"));
		this.baseService.removeEntity(fileConfig);
		
		if (logger.isInfoEnabled()) {
			logger.info("删除成功!");
		}
		return null;
	}
}
