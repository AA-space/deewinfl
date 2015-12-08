package com.business.controller.reckon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.contract.reckon.condition.ContractConditionTemp;
import com.business.entity.util.OwnInfo;
import com.business.service.TableService;
import com.business.service.reckon.FundFundChargePlanService;
import com.business.service.reckon.RentCalculateService;
import com.kernal.utils.QueryUtil;
import com.tenwa.leasing.util.LeasingException;



/**
 * 
 * @author 孙传良
 * @date 2013-3-19上午10:55:13
 * @info 租金测算模型的实现类 该类的主要功能为接收前台参数做相应的测算.
 * @Copyright 
 * Tenwa
 */
@Controller(value="rentCalculateControllerTmp")
@RequestMapping(value="/**/leasing")
public class RentCalculateControllerTmp extends BaseController {

	   @Resource(name="rentCalculateService")
	   private RentCalculateService rentCalculateService ;
	   
	   @Resource(name = "tableService")
	   private TableService tableService;
	   
	   @Resource(name = "fundFundChargePlanService")
	   private FundFundChargePlanService fundChargePlanService;
	   
	   /**
	    * 为了和老的租金测算代码对接写的测算入口类
	    * @param request
	    * @param response
	    * @return
	    * @throws Exception
	    */
	   @SuppressWarnings("deprecation")
	   @RequestMapping(value="/rentCalculateTmp.action")
	   @ResponseBody
	   public String rentCalculateOldTest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		   Map<String, String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
		   Map<String, Object> modelData2 = new HashMap<String, Object>();
		   for(String key : modelData.keySet()){
			   if(key.equals("docId") || key.equals("contractId")){
				   modelData2.put(key, modelData.get(key));
			   }
		   }
		   String jsonResult = "";
		   
		   Map<String,String> classFild = new HashMap<String, String>();
		   classFild.put("DictionaryData","code");
		   classFild.put("User","id");
		   
		   List<ContractConditionTemp> result = this.tableService.findEntityByProperties(ContractConditionTemp.class, modelData2);
		   for(ContractConditionTemp cci : result){
			   
			   try {
				   Map<String, String> params = this.tableService.getEntityPropertiesToStringMap(cci, classFild, "framework_condition");
				   
				   params.put("framework_condition.id",cci.getId());
				   params.put("framework_condition.contractid",cci.getContractId());
				   params.put("framework_condition.docid",cci.getDocId());
				   params.put("framework_condition.custid","rentcal_4_5");
				   params.put("framework_condition.projid","rentcal_4_5");
				   
				   params.put("framework_condition.enddate",cci.getEndDate());
				   params.put("framework_condition.process","cond_process");//租金测算流程
				   params.put("framework_condition.reckontype","condition");//租金测算
				   
				   rentCalculateOld(params);
				
				} catch (Exception e) {
					jsonResult += cci.getContractId();
				}
		   }
		   return jsonResult;
	   }
	   
	   @SuppressWarnings("deprecation")
	   public String rentCalculateOld(Map<String,String> modelData) throws Exception {
			String ajaxCallBackScript = "";
			Map<String,Object> returnMap=new HashMap<String, Object>();
			try
			{
				Map<String,Object> rentPlan=new HashMap<String, Object>();
				rentPlan = this.rentCalculateService.calculateRentPlanOld(modelData);
				if(rentPlan!=null&&rentPlan.size()>0){
					returnMap.putAll(rentPlan);
					Map<String,Object> fundPlan=new HashMap<String, Object>();
					OwnInfo ownInfo=new OwnInfo();
					ownInfo.setOwnName(rentPlan.get("owninfo").toString());
					fundPlan = this.fundChargePlanService.createFundPlan(modelData,rentPlan.get("enddate").toString(),ownInfo);
					if(fundPlan!=null&&fundPlan.size()>0){
//						System.out.println("成功获得资金计划的数据!");
						returnMap.put("fundchargeplanmsg", "yes");
						returnMap.putAll(fundPlan);
					}else{
//						System.out.println("获取资金计划的数据失败!");
						returnMap.put("fundchargeplanmsg", "no");
					}
					rentPlan.remove("owninfo");//移除不需要的信息
				}
			}catch(LeasingException e)
			{
				e.printStackTrace();
				ajaxCallBackScript ="捕获到异常:"+ e.getMessage();
				returnMap=new HashMap<String, Object>();
				returnMap.put("rentcalculaters", "no");
				if(ajaxCallBackScript==null||ajaxCallBackScript.equals("")){
					ajaxCallBackScript="发现异常但未抛出!";
				}
				returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
			}
			catch(Exception e)
			{
				e.printStackTrace();
				ajaxCallBackScript = e.getMessage();
				returnMap=new HashMap<String, Object>();
				returnMap.put("rentcalculaters", "no");
				if(ajaxCallBackScript==null||ajaxCallBackScript.equals("")){
					ajaxCallBackScript="测算已经出错,但是没有捕获到错误消息!";
				}
				returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
			}
			if(returnMap==null||returnMap.size()==0){
				returnMap=new HashMap<String, Object>();
				returnMap.put("rentcalculaters", "no");
				returnMap.put("rentcalculatemsg", "测算失败!没有获取测算结果!");
			}
			String jsonResult="";
			ObjectMapper mapper = new ObjectMapper(); 
			mapper.configure(Feature.WRITE_NULL_PROPERTIES, false);//不写空字符
			try{
				jsonResult = mapper.writeValueAsString(returnMap);
			}catch (Exception e) {
				e.printStackTrace();
				returnMap=new HashMap<String, Object>();
				returnMap.put("rentcalculaters", "no");
				returnMap.put("rentcalculatemsg", "测算失败!构建JSON返回结果出错!");
				jsonResult = mapper.writeValueAsString(returnMap);
			}
			return jsonResult.toLowerCase();
	   }
	   
	   /**
	    * 为了和老的租金测算代码对接写的测算入口类
	    * @param request
	    * @param response
	    * @return
	    * @throws Exception
	    */
	   @SuppressWarnings("deprecation")
	   public String rentCalculateOld(HttpServletRequest request,HttpServletResponse response) throws Exception
	   {
		    Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);//把请求数据转成map
			String ajaxCallBackScript = "";
			Map<String,Object> returnMap=new HashMap<String, Object>();
			try
			{
				Map<String,Object> rentPlan=new HashMap<String, Object>();
				rentPlan = this.rentCalculateService.calculateRentPlanOld(modelData);
				if(rentPlan!=null&&rentPlan.size()>0){
					returnMap.putAll(rentPlan);
					Map<String,Object> fundPlan=new HashMap<String, Object>();
					OwnInfo ownInfo=new OwnInfo();
					ownInfo.setOwnName(rentPlan.get("owninfo").toString());
					fundPlan = this.fundChargePlanService.createFundPlan(modelData,rentPlan.get("enddate").toString(),ownInfo);
					if(fundPlan!=null&&fundPlan.size()>0){
//						System.out.println("成功获得资金计划的数据!");
						returnMap.put("fundchargeplanmsg", "yes");
						returnMap.putAll(fundPlan);
					}else{
//						System.out.println("获取资金计划的数据失败!");
						returnMap.put("fundchargeplanmsg", "no");
					}
					rentPlan.remove("owninfo");//移除不需要的信息
				}
			}catch(LeasingException e)
			{
				e.printStackTrace();
				ajaxCallBackScript ="捕获到异常:"+ e.getMessage();
				returnMap=new HashMap<String, Object>();
				returnMap.put("rentcalculaters", "no");
				if(ajaxCallBackScript==null||ajaxCallBackScript.equals("")){
					ajaxCallBackScript="发现异常但未抛出!";
				}
				returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
			}
			catch(Exception e)
			{
				e.printStackTrace();
				ajaxCallBackScript = e.getMessage();
				returnMap=new HashMap<String, Object>();
				returnMap.put("rentcalculaters", "no");
				if(ajaxCallBackScript==null||ajaxCallBackScript.equals("")){
					ajaxCallBackScript="测算已经出错,但是没有捕获到错误消息!";
				}
				returnMap.put("rentcalculatemsg", ajaxCallBackScript.replaceAll("'", " ").replaceAll("\"", " "));
			}
			if(returnMap==null||returnMap.size()==0){
				returnMap=new HashMap<String, Object>();
				returnMap.put("rentcalculaters", "no");
				returnMap.put("rentcalculatemsg", "测算失败!没有获取测算结果!");
			}
			String jsonResult="";
			ObjectMapper mapper = new ObjectMapper(); 
			mapper.configure(Feature.WRITE_NULL_PROPERTIES, false);//不写空字符
			try{
				jsonResult = mapper.writeValueAsString(returnMap);
			}catch (Exception e) {
				e.printStackTrace();
				returnMap=new HashMap<String, Object>();
				returnMap.put("rentcalculaters", "no");
				returnMap.put("rentcalculatemsg", "测算失败!构建JSON返回结果出错!");
				jsonResult = mapper.writeValueAsString(returnMap);
			}
			return jsonResult.toLowerCase();
	   }
}
