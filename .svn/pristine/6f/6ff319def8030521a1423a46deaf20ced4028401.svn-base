package com.business.controller.equip;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.service.equip.ContractEquipDeliveryService;
import com.business.serviceImpl.equip.ContractEquipDeliveryServiceImpl;
import com.kernal.utils.QueryUtil;

/**
 * xml解析，如果传递的是xml，则解析xml，传递的是类名，查询全部数据,type为查询的数据url
 * @author Jason
 *
 */
@Controller("ContractEquipDeliveryController")
@RequestMapping(value = "/**/acl")
public class ContractEquipDeliveryController extends BaseController {

	@Resource(name="contractEquipDeliveryService")
	private ContractEquipDeliveryService contractEquipDeliveryService ;
	
	private Logger logger=Logger.getLogger(ContractEquipDeliveryServiceImpl.class);
	
	@RequestMapping(value="/addContractEquipDelivery.acl")
	@ResponseBody
	public String addContractEquipDelivery(HttpServletRequest request) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		String contractId = model.get("contractid").split("&")[2];
		model.put("contractid", contractId);
		contractEquipDeliveryService.addContractEquipDelivery(model);
		return "";
	}
	
	@RequestMapping(value="/updateContractEquipDelivery.acl")
	@ResponseBody
	public String updateContractEquipDelivery(HttpServletRequest request) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		contractEquipDeliveryService.updateContractEquipDelivery(model);
		return "";
	}


	@RequestMapping(value="/removeContractEquipDelivery.acl")
	@ResponseBody
	public String removeContractEquipDelivery(@RequestParam("id") String id) {
		try {
			contractEquipDeliveryService.removeContractEquipDelivery(id);
			return "删除成功";
		} catch (Exception e) {
			logger.error("删除失败",e);
			return "删除失败";
		}
	}
}