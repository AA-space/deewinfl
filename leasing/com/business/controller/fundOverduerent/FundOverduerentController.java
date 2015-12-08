package com.business.controller.fundOverduerent;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoContact;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.google.inject.internal.Maps;
import com.kernal.utils.QueryUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

@Controller(value = "FundOverduerentController")
@RequestMapping(value = "/**/acl")
public class FundOverduerentController extends BaseController {
	private Logger logger=Logger.getLogger(FundOverduerentController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@Resource(name = "tableService")
	private TableService tableService;
	
	@RequestMapping(value = "/addFundOverduerent.acl")
	public String addFundOverduerent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustInfoContact info = new CustInfoContact();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
			dictDataClassMapping.put("DictionaryData", "code");
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}
	@RequestMapping(value = "/addFundOverduerent1.acl")
	public String addFundOverduerent1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		  //System.out.println("==========================");
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 String data=model.get("formData");
		 System.out.println(data+"^^^^^^^^^");
		 CustInfoContact info = new CustInfoContact();
		 JSONObject jsonObject=new JSONObject(data);
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
			dictDataClassMapping.put("DictionaryData", "code");
			
		 this.baseService.copyAndOverrideExistedValueFromJSONObject(jsonObject, info, dictDataClassMapping, false);
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}
	
	@RequestMapping(value = "/updateFundOverduerent.acl")
	public String updateFundOverduerent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustInfoContact info = new CustInfoContact();
		 info=(CustInfoContact)this.baseService.findEntityByID(CustInfoContact.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}
	@RequestMapping(value = "/updateFundOverduerent1.acl")
	public String updateFundOverduerent1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 String data=model.get("formData");
		 JSONObject jsonObject=new JSONObject(data);
		 CustInfoContact info = new CustInfoContact();
		 info=(CustInfoContact)this.baseService.findEntityByID(CustInfoContact.class, jsonObject.get("id").toString());
		 this.baseService.copyAndOverrideExistedValueFromJSONObject(jsonObject,info,null, false);
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.saveEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}
	@RequestMapping(value = "/removeFundOverduerent.acl")
	public String removeFundOverduerent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 CustInfoContact info = new CustInfoContact();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.removeEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
	@RequestMapping(value = "/removeFundOverduerent1.acl")
	public String removeFundOverduerent1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 String id=model.get("formData");
		 this.baseService.removeEntityById(CustInfoContact.class, id);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
	
	@RequestMapping(value = "/getCustVisitInfo.acl")
	@ResponseBody
	public String getCustVisitInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String contractid = request.getParameter("contractid");
		String custid = request.getParameter("custid");
        CustInfo cinfo=new CustInfo();
        cinfo=tableService.findEntityByID(CustInfo.class, custid);
        
        
		// 查合同表
		HashMap<String, Object> Map = new HashMap<String, Object>();
		Map.put("contractId", contractid);
		List<ContractInfo> list_cinfo = new ArrayList<ContractInfo>();
		list_cinfo = this.tableService.findEntityByProperties(
				ContractInfo.class, Map);
		ContractInfo coninfo = list_cinfo.get(0);
		List<ContractCondition> list_cc = new ArrayList<ContractCondition>();
		HashMap<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("contractId", coninfo);
		list_cc=this.tableService.findEntityByProperties(
				ContractCondition.class, propertiesMap);
		ContractCondition cc=list_cc.get(0);
		
		 
	     Map<String, String> income = Maps.newHashMap(); 
	     income.put("CONTRACT_ID", contractid);
	     income.put("CUST_ID",custid);
	     
	     String firstpayment = this.tableService.getTableJsonData("eleasing/jsp/fund_overduerent/overdue_visitrecord_rent.xml", income);
	    
	     ObjectMapper mapper1 = new ObjectMapper();
	     mapper1.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
	     List<Object> list=new ArrayList<Object>();
         Map<String, Object> rent=mapper1.readValue(firstpayment, Map.class);
         
	     
		Map<String, Object> map = Maps.newHashMap();
		map.put("custname", cinfo.getCustName());
		map.put("equipamt", cc.getLeaseMoney());
		String money=((ArrayList<HashMap<String, Object>>)rent.get("datas")).get(0).get("rent").toString();
		map.put("incomedata",money);
		
		ObjectMapper mapper = new ObjectMapper();
		String InterestString = mapper.writeValueAsString(map);
		return InterestString;
	}
	
}
