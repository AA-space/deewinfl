package com.business.controller.leaseManagement;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.entity.base.EquipModel;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;


@Controller(value = "equipManagementController")
@RequestMapping(value = "/**/acl")
public class EquipManagementController {
	private Logger logger=Logger.getLogger(EquipManagementController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
	
	@RequestMapping(value = "/addEquipManagement.acl")
	@ResponseBody
	public String addEquipManagement(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 EquipModel info = new EquipModel();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 info.setModel(model.get("model"));
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/updateEquipManagement.acl")
	@ResponseBody
	public String updateEquipManagement(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 EquipModel info = new EquipModel();
		 info=(EquipModel)this.baseService.findEntityByID(EquipModel.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.updateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}
	
	
	@RequestMapping(value = "/removeEquipManagement.acl")
	@ResponseBody
	public String removeEquipManagement(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);		 
		EquipModel info = new EquipModel();
		 info=(EquipModel) this.baseService.findEntityByID(EquipModel.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 //删除时状态设置为禁用
		 info.setEnable("1");
		 this.baseService.saveOrUpdateEntity(info);		 
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
}
