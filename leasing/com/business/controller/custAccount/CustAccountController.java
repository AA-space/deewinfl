package com.business.controller.custAccount;

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

import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoAccount;
import com.business.entity.cust.CustInfoRelatedPerson;
import com.business.entity.insurance.InsuranceInfo;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;

/**
 * 
 * @author yuanhx
 * @date 
 * @info 
 * @Copyright Tenwa
 */
@Controller(value = "custAccountController")
@RequestMapping(value = "/**/acl")
public class CustAccountController {
	private Logger logger=Logger.getLogger(CustAccountController.class);
	@Resource(name = "baseService")
	private BaseService baseService;

	// #################
	@RequestMapping(value = "/addCustAccount.acl")
	@ResponseBody
	public String addCustAccount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 CustInfoAccount info = new CustInfoAccount();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		
		 String mainpersonflag=model.get("ismain");
		 if(mainpersonflag.equals("0")){
			 String hql=" from CustInfoAccount ca where ca.isMain='0' and ca.custId.id=?)";
			 List<CustInfoAccount> personinfo=this.baseService.findResultsByHSQL(hql,model.get("custid"));
			 if(personinfo.size()>=1){
				 return "只能存在一个主账户！";
			 }
		 }
		 
		 
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/updateCustAccount.acl")
	@ResponseBody
	public String updateCustAccount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustInfoAccount info = new CustInfoAccount();
		 info=(CustInfoAccount)this.baseService.findEntityByID(CustInfoAccount.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		
		 String mainpersonflag=model.get("ismain");
		 String custid=model.get("id");
		 if(mainpersonflag.equals("0")){
			 String hql=" from CustInfoAccount ca where ca.isMain='0' and ca.custId.id=?)";
			 List<CustInfoAccount> personinfo=this.baseService.findResultsByHSQL(hql,model.get("custid"));
			 for(CustInfoAccount custInfoAccount : personinfo){
				 if(custInfoAccount.getId().toLowerCase().equals(custid.toLowerCase())){
					 personinfo.remove(custInfoAccount);
					 break;
				 }
			}
			 if(personinfo.size()>=1){
				 return "只能存在一个主账户！";
			 }
		 }
		 this.baseService.updateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/removeCustAccount.acl")
	public String removeCustAccount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustInfoAccount info = new CustInfoAccount();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.removeEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
}
