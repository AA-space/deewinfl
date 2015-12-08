package com.business.controller.dealer;

import com.business.controller.BaseController;
import com.business.entity.DictionaryData;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.DealerApprovalInfo;
import com.business.entity.dealer.DealerDeptInfo;
import com.business.service.BaseService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.kernal.utils.QueryUtil;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * yixiaohui
 * 经销商账号管理
 */
@Controller(value = "dealerAccountManagerController")
@RequestMapping(value = "/**/acl")
public class DealerAccountManagerController extends BaseController {
	private Logger logger=Logger.getLogger(DealerDeptInfo.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	

	@RequestMapping(value = "/addDealerAccountManager.acl")
	@ResponseBody
	public String addDealerAccountManager(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 DealerDeptInfo info = new DealerDeptInfo();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 Map<String,Object> where = new HashMap<String,Object>();
		 String custid = model.get("custid");
		 CustInfo cid = (CustInfo) this.baseService.findEntityByID(CustInfo.class, custid);
		 where.put("custId", cid);
		 List  listf=new ArrayList ();
			listf= this.baseService.findEntityByProperties(DealerDeptInfo.class, where);
			 if(listf!=null&&listf.size()>0){
				 return "经销商重复！";
			 }else{	 
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		 this.baseService.saveOrUpdateEntity(info);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}
	}

	@RequestMapping(value = "/updateDealerAccountManager.acl")
	@ResponseBody
	public String updateDealerAccountManager(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);	
		
		
		 Map<String,Object> where = new HashMap<String,Object>();
		 String custid = model.get("custid");
		 String id = model.get("id");
		 CustInfo cid = (CustInfo) this.baseService.findEntityByID(CustInfo.class, custid);
		 where.put("custId", cid);
		 List<DealerDeptInfo>  listf=new ArrayList<DealerDeptInfo> (this.baseService.findEntityByProperties(DealerDeptInfo.class, where)); 
		 for (DealerDeptInfo dealerDeptInfo : listf) {
			if(dealerDeptInfo.getId().toLowerCase().equals(id)){
				listf.remove(dealerDeptInfo);
				break;
			}
		}
		 if(listf!=null&&listf.size()>0){			 
			 return "经销商重复！";
		 			 
		 }else{	
		 	 
		 DealerDeptInfo info = new DealerDeptInfo();
		 info=(DealerDeptInfo) this.baseService.findEntityByID(DealerDeptInfo.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.saveOrUpdateEntity(info);
		   if(logger.isInfoEnabled()){
			 logger.info("修改成功!");   
		 }
		return null;
	}
	}
	@RequestMapping(value = "/removeDealerAccountManager.acl")
	@ResponseBody
	public String removeDealerAccountManager(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);		 
		 DealerDeptInfo info = new DealerDeptInfo();
		 info=(DealerDeptInfo) this.baseService.findEntityByID(DealerDeptInfo.class, model.get("id"));
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 //删除时状态设置为禁用
		 info.setEnable("1");
		 this.baseService.removeEntity(info);		 
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
	/**
	 * 
	* @author xuyunlong E-mail: 
	* @version 创建时间：2013-9-9 上午09:48:54 
	* 说明：准入撤销
	 */
	@RequestMapping(value = "/cancelDealerApproval.acl")
	@ResponseBody
	public String updateDealerApproval(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);		 
		String id=model.get("id");
		DealerApprovalInfo di=(DealerApprovalInfo)this.baseService.findEntityByID(DealerApprovalInfo.class, id);
		di.setDealerStatus((DictionaryData)this.baseService.findEntityByID(DictionaryData.class, "dealerApprovalstatus7"));
		this.baseService.saveEntity(di);
		return "操作成功";
	}
	
}


