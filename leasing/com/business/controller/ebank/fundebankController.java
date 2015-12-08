package com.business.controller.ebank;

 

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.business.controller.BaseController;
import com.business.entity.asset.FundEbankData;
import com.business.entity.base.BaseFile;
import com.business.entity.cust.CustInfo;
import com.business.entity.util.OwnAccount;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.business.service.ebank.EbankService;
import com.business.service.fileTemplate.FileTemplateService;
import com.business.util.WorkflowUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.FileUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.ResourceUtil;
/**
 * xuyunlong
 * 网银管理
 */
@Controller(value = "fundebankController")
@RequestMapping(value = "/**/acl")
public class fundebankController extends BaseController {
	private Logger logger=Logger.getLogger(fundebankController.class);

	@Resource(name="ebankService")
	private EbankService ebankService;
	
	// #################
	@RequestMapping(value = "/addfundebank.acl")
	@ResponseBody
	public String addEbank(HttpServletRequest request,
			HttpServletResponse response)  throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		return ebankService.addEbank(model);
	}
	
	
	@RequestMapping(value = "/updatefundebank.acl")
	@ResponseBody
	public String updateEbank(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		return this.ebankService.updateEbank(model);
	}
	
	@RequestMapping(value = "/updateCancalfundebank.acl")
	@ResponseBody
	public String updateCancalEbank(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		
		this.ebankService.updateCancalEbank(model);
		return null;
	}

	@RequestMapping(value = "/removefundebank.acl")
	@ResponseBody
	public String removeEbank(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> model = QueryUtil.getRequestParameterMapByAjax(request);
		return this.ebankService.removeEbank(model);
	}
	/**
	 * 
	 * @date 2013-5-24
	 * xuyunlong
	 * 模板上传
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addEbankFromUpload.action")
	@ResponseBody
	public String insertEbankFromLoadFile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		MultipartFile  multipartFile = multipartRequest.getFile("tableImportTemplate");
		modelData.put("importExcelColumnStr", modelData.get("parames"));
		String message=this.ebankService.insertEbankFromLoadFile(multipartFile, modelData);
	    String ajaxCallBackScript = "<script type='text/javascript'>window.parent.importEbankCallBack(\""+message+"\");</script>";
		this.ajaxReturn(response, ajaxCallBackScript);
		return  null;
	}
	/**
	 * 是否启用
	 */
	@RequestMapping(value = "/custEbankEnabled.action")
	@ResponseBody
	public String custEbankEnabled(HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map<String,String> modelData = QueryUtil.getRequestParameterMapNoAjax(request);
		String ebankId = modelData.get("ebank_id");
		String ebable_flag_str = modelData.get("enable_flag");
		Integer ebable_flag  = null;
		/*if (ebable_flag_str !=null) {
			ebable_flag = Integer.parseInt(ebable_flag_str);
		} else {
			throw new BusinessException("不能更新，提交选项为空");
		}*/
		if (ebable_flag_str.equals("undefined")|| "".equals(ebable_flag_str))
			ebable_flag = 0;
		else
			ebable_flag = Integer.parseInt(ebable_flag_str);
		return this.ebankService.updateCustEbankData(ebankId, ebable_flag);
	}
}

