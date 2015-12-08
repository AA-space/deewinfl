package com.business.controller.custPerson;

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

import com.business.entity.cust.CustInfoRelatedPerson;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;

/**
 * 
 * @author yuanhx
 * @date 
 * @info 
 * @Copyright Tenwa
 */
@Controller(value = "custPersonController")
@RequestMapping(value = "/**/acl")
public class CustPersonController {
	private Logger logger=Logger.getLogger(CustPersonController.class);
	@Resource(name = "baseService")
	private BaseService baseService;

	// #################
	@RequestMapping(value = "/addCustPerson.acl")
	@ResponseBody
	public String addCustPerson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustInfoRelatedPerson info = new CustInfoRelatedPerson();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
			dictDataClassMapping.put("DictionaryData", "code");
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
	
		 String mainpersonflag=model.get("mainPersonFlag");
		 if(mainpersonflag.equals("0")){
			 String hql=" from CustInfoRelatedPerson crp where crp.mainPersonFlag='0' and crp.custId.id=?)";
			 List<CustInfoRelatedPerson> personinfo=this.baseService.findResultsByHSQL(hql,model.get("custid"));		    
			 if(personinfo.size()>=1){
				 return "只能存在一位主联系人！";
			 }
		 }
		 
		 this.baseService.saveOrUpdateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
			 
		 }
		return null;
	}

	@RequestMapping(value = "/updateCustPerson.acl")
	@ResponseBody
	public String updateCustPerson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);		 
		 CustInfoRelatedPerson info = new CustInfoRelatedPerson();
		 info=(CustInfoRelatedPerson) this.baseService.findEntityByID(CustInfoRelatedPerson.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 
		 String mainpersonflag=model.get("mainPersonFlag");
		 String custid = model.get("id");
		 if(mainpersonflag.equals("0")){
			 String hql=" from CustInfoRelatedPerson crp where crp.mainPersonFlag='0' and crp.custId.id=?)";
			 List<CustInfoRelatedPerson> personinfo=this.baseService.findResultsByHSQL(hql,model.get("custid"));
			 for(CustInfoRelatedPerson custInfoRelatedPerson : personinfo){
				 if(custInfoRelatedPerson.getId().toLowerCase().equals(custid.toLowerCase())){
					 personinfo.remove(custInfoRelatedPerson);
					 break;
				 }
			}if(personinfo.size()>=1){
				 return "只能存在一位主联系人！";
			 }
		 }
		 
		 this.baseService.saveOrUpdateEntity(info);
		   if(logger.isInfoEnabled()){
			 logger.info("修改成功!");   
		 }
		return null;
	}

	@RequestMapping(value = "/removeCustPerson.acl")
	@ResponseBody
	public String removeCustPerson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustInfoRelatedPerson info = new CustInfoRelatedPerson();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.removeEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
}
