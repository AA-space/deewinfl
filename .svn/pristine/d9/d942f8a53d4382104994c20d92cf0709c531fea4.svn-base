package com.business.controller.contractDebit;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.entity.contract.rent.ContractCardForRent;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;

@Controller(value = "contractDebitController")
@RequestMapping(value = "/**/acl")
public class ContractDebitController {
	@Resource(name = "baseService")
	private BaseService baseService;
	
	
	@ResponseBody
	@RequestMapping(value = "/addContractDebit.acl")
	public String addContractDebit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "没有新增";
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateContractDebit.acl")
	public String updateContractDebit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 ContractCardForRent info = new ContractCardForRent();
		 if(model.get("id")!=null){
			 info=(ContractCardForRent)this.baseService.findEntityByID(ContractCardForRent.class, model.get("id"));
		 } 
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.baseService.saveOrUpdateEntity(info);
		return "操作成功!";
	}
		 
	@ResponseBody
	@RequestMapping(value = "/removeContractDebit.acl")
	public String removeContractDebit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "没有删除";
	}
}
