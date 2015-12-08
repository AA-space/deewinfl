package com.business.controller.modelmanger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.User;
import com.business.entity.modelmanager.ModelFieldManager;
import com.business.entity.modelmanager.ModelManager;
import com.business.service.BaseService;
import com.kernal.utils.DateUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.SecurityUtil;
@Controller(value = "modelManagerController")
@RequestMapping(value = "/**/leasing")
public class ModelManagerController  extends BaseController {
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@RequestMapping(value = "/fieldmodel/addbasefieldconfig.action")
	@ResponseBody
	public String addfieldConfig(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> modeldate = QueryUtil.getRequestParameterMapByAjax(request);
		String id="";
		id=modeldate.get("id");
		HashMap<String,Object>propertiesMap=new HashMap<String,Object>();
		ModelManager model;
		propertiesMap.put("id", id);
		User user = (User)SecurityUtil.getPrincipal();
		String systemDate = DateUtil.getSystemDateTime();
		model=(ModelManager)this.baseService.getNewOrUpdateObject(ModelManager.class, propertiesMap);
		this.baseService.copyAndOverrideExistedValueFromMap(modeldate, model);
		if(model.getCreator()==null){
			model.setCreator(user);
			model.setCreateDate(systemDate);
		}else{
			model.setModificator(user);
			model.setCreateDate(systemDate);
		}
		this.baseService.saveOrUpdateEntity(model);
		String fieldJSon=modeldate.get("fielddatasjson");
		this.baseService.updateOneToManyCollections(model, "baseModelFields", ModelFieldManager.class, "modelmanager", fieldJSon,null);
		return null;
	}
	
	@RequestMapping(value = "/fieldmodel/loadbasefieldconfig.action")
	@ResponseBody
	public String loadfieldConfig(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> modeldate = QueryUtil.getRequestParameterMapByAjax(request);
		String id="";
		id=modeldate.get("id");
		HashMap<String,Object>propertiesMap=new HashMap<String,Object>();
		propertiesMap.put("id", id);
		propertiesMap.clear();
		ModelManager model=(ModelManager)this.baseService.findEntityByID(ModelManager.class, id);
		propertiesMap.put("modelmanager", model);
        List modelfields=new ArrayList();
        modelfields= this.baseService.findEntityByProperties(ModelFieldManager.class, propertiesMap);
        System.out.println(modelfields.size());
        return this.baseService.getCollectionEntitiesPropertiesToJsonArrayString(modelfields, null).toString();
	}
	@RequestMapping(value = "/fieldmodel/removemodelManger.action")
	@ResponseBody
	public String deleteModelManager(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> modeldate = QueryUtil.getRequestParameterMapByAjax(request);
		String id="";
		id=modeldate.get("id");
		HashMap<String,Object>propertiesMap=new HashMap<String,Object>();
		propertiesMap.put("id", id);
		
		ModelManager model=(ModelManager)this.baseService.findEntityByID(ModelManager.class, id);
		propertiesMap.clear();
		propertiesMap.put("modelmanager", model);
        List<ModelFieldManager> modelfields=new ArrayList<ModelFieldManager>();
        modelfields=(List<ModelFieldManager>) this.baseService.findEntityByProperties(ModelFieldManager.class, propertiesMap);
        this.baseService.removeAllEntites(modelfields);
        this.baseService.removeEntity(model);
	   return null;	
	}
	

}
