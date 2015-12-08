package com.business.controller.doc;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.service.TableService;
import com.business.service.contract.ContractServer;
import com.google.inject.internal.Maps;

/**
 * 
 * @author 徐云龙
 * @date 2013-4-21上午10:37:13
 * @info 查出这个合同下收款计划和网银余额
 * @Copyright 
 * Tenwa   
 */
@Controller(value="docController")
@RequestMapping(value="/**/leasing")
public class docController {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name="contractServer")
	private ContractServer contractServer;
	
	@RequestMapping(value="/docSendCheckNew.action")
	@ResponseBody
	public String getCurrentPlanList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		return this.contractServer.getCurrentPlanList(request, response);
		
	}
	@RequestMapping(value="/docSendSave.action")
	@ResponseBody
	public String docSendSave(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String str = this.contractServer.saveDocSend(request, response);
		return str;
	}
	@RequestMapping(value="/docSendSave2.action")
	@ResponseBody
	public String docSendSave2(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String contract_id = request.getParameter("contract_id");
		String docnumber = request.getParameter("docNumber");
		System.out.println(contract_id+"@@@@@@"+docnumber);
		String sql="update contract_doc_send_info doc set doc.doc_number=? where doc.contract_id=?";
		if (    StringUtils.isNotEmpty(contract_id) 
				&& StringUtils.isNotEmpty(docnumber) )
		{
			this.tableService.updateBySql(sql,docnumber,contract_id);
			return "yes";
		}
		else
		{	
			return "no";
		}
	}
	
	@RequestMapping(value="/docReturn.action")
	@ResponseBody
	public String docReturn(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		String str = this.contractServer.saveDocReturn(request, response);
		return str;
	}
	
}
