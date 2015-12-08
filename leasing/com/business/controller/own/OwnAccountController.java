package com.business.controller.own;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.business.entity.util.OwnAccount;
import com.business.entity.util.OwnInfo;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;


/**
 * 
 * @author 蔡雅超
 * @date 2013-6-5上午10:55:13
 * @info 本方账号的Action
 * @Copyright 
 * Tenwa
 */

@Controller(value = "OwnAccountController")
@RequestMapping(value = "/**/acl")
public class OwnAccountController {
	private Logger logger=Logger.getLogger(OwnAccountController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	OwnAccount ownAccount=new OwnAccount();
	public OwnAccount getOwnAccount() {
		return ownAccount;
	}

	public void setOwnAccount(OwnAccount ownAccount) {
		this.ownAccount = ownAccount;
	}
	OwnInfo ownInfo=new OwnInfo();
	// #################
	@RequestMapping(value = "/addOwnAccount.acl")
	public String addOwnAccount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 OwnAccount ownAccount=new OwnAccount();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, ownAccount, null);
		 OwnInfo ownId=new OwnInfo();
		 String oidString=model.get("oid").substring(1);
		 ownId.setId(oidString);//要给 oid提供隐藏feildName 
		 ownAccount.setOwnId(ownId);
		 this.baseService.saveEntity(ownAccount);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/updateOwnAccount.acl")
	public String updateOwnAccount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, ownAccount, null);
		 ownInfo=(OwnInfo)this.baseService.findEntityByID(OwnInfo.class,model.get("oid"));
		 ownAccount.setOwnId(ownInfo);
		 ownAccount.setId(model.get("cid"));
		 this.baseService.updateEntity(ownAccount);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/removeOwnAccount.acl")
	public String removeOwnAccount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, ownAccount, null);
		 ownAccount.setId(model.get("cid"));
		 this.baseService.removeEntity(ownAccount);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
}
