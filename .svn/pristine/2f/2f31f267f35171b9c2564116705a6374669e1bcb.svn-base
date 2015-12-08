package com.business.controller.leaseManagement;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.entity.contract.equip.ContractEquipRevoke;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;

@Controller(value = "equipRevokeController")
@RequestMapping(value = "/**/acl")
public class EquipRevokeController {
	private Logger logger=Logger.getLogger(EquipRevokeController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
		@RequestMapping(value = "/addEquipRevoke.acl")
		@ResponseBody
		public String addEquipRevoke(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
			 dictDataClassMapping.put("DictionaryData", "code");
			 ContractEquipRevoke info = new ContractEquipRevoke();
			 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
			 this.baseService.saveEntity(info);
			 if(logger.isInfoEnabled()){
				 logger.info("新增成功!");
			 }
			return null;
		}
		
		@RequestMapping(value = "/updateEquipRevoke.acl")
		@ResponseBody
		public String updateEquipRevoke(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			 ContractEquipRevoke info = new ContractEquipRevoke();
			 info=(ContractEquipRevoke)this.baseService.findEntityByID(ContractEquipRevoke.class, model.get("id"));
			 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
			 this.baseService.updateEntity(info);
			 if(logger.isInfoEnabled()){
				 logger.info("修改成功!");
			 }
			return null;
		}

		@RequestMapping(value = "/removeEquipRevoke.acl")
		public String removeEquipRevoke(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			 ContractEquipRevoke info = new ContractEquipRevoke();
			 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
			 this.baseService.removeEntity(info);
			 if(logger.isInfoEnabled()){
				 logger.info("删除成功!");
			 }
			return null;
		}
}

