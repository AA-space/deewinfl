package com.business.controller.fundOverduerent;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import com.business.controller.BaseController;
import com.business.entity.dun.DunningRecord;

import org.apache.log4j.Logger;

import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.SecurityUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(value = "DunningRecordController")
@RequestMapping(value = "/**/acl")
public class DunningRecordController extends BaseController {
	private Logger logger=Logger.getLogger(FundOverduerentController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
	
	@RequestMapping(value = "/addDunningRecord.acl")
	public String addDunningRecord(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 DunningRecord info = new DunningRecord();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
			dictDataClassMapping.put("DictionaryData", "code");
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}
	@RequestMapping(value = "/addDunningRecord1.acl")
	public String addDunningRecord1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 System.out.println(model+"===============");
		String formData=model.get("formData");
			JSONObject jsonObject=new JSONObject(formData);
			//jsonObject.put("creator", model.get("login_userid"));//
		String contractids=(String)	jsonObject.get("contractids");
		jsonObject.remove("contractids");
		jsonObject.remove("liaisoner");
		String[] str =contractids.split(",");
		for(String ss:str){
				jsonObject.put("contractid", ss);
				jsonObject.put("liaisoner",SecurityUtil.getPrincipal().getId());
				System.out.println(jsonObject.toString()+"=====");//
			 DunningRecord info = new DunningRecord();
			 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
				dictDataClassMapping.put("DictionaryData", "code");
				this.baseService.copyAndOverrideExistedValueFromJSONObject(jsonObject,info , dictDataClassMapping,false);
			this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
			 
			 this.baseService.saveEntity(info);	
		}
			
		
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}
	@RequestMapping(value = "/updateDunningRecord.acl")
	public String updateDunningRecord(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 DunningRecord info = new DunningRecord();
		 info=(DunningRecord)this.baseService.findEntityByID(DunningRecord.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.saveOrUpdateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}
	@RequestMapping(value = "/updateDunningRecord1.acl")
	public String updateDunningRecord1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 String formData=model.get("formData");
		 JSONObject jsonObject=new JSONObject(formData);
		 DunningRecord info = new DunningRecord();
		 info=(DunningRecord)this.baseService.findEntityByID(DunningRecord.class, (String)jsonObject.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromJSONObject(jsonObject, info, null,false);
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.saveOrUpdateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}
	
	@RequestMapping(value = "/removeDunningRecord.acl")
	public String removeDunningRecord(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 DunningRecord info = new DunningRecord();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.removeEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
	@RequestMapping(value = "/removeDunningRecord1.acl")
	public String removeDunningRecord1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 String id=model.get("formData");
		 //DunningRecord info = new DunningRecord();
		// this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.removeEntityById(DunningRecord.class, id);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
}
