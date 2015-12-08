package com.business.controller.insure;

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

import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.service.TableService;
import com.business.service.Insurance.InsuranceConfirmService;
import com.kernal.utils.QueryUtil;

/**
 * 
 * @author 孙传良
 * @date 2013-4-22上午10:30:01
 * @info 保险功能
 * @Copyright Tenwa
 */
@Controller(value = "insuranceConfirmController")
@RequestMapping(value = "/**/acl")
public class InsuranceConfirmController {
	
	private Logger logger=Logger.getLogger(InsuranceConfirmController.class);
	
	@Resource(name = "insuranceConfirmService")
	private InsuranceConfirmService baseService;
	
	@Resource(name = "tableService")
	private TableService tableService;

	@RequestMapping(value = "/updateInsuranceConfirm.acl")
	public String updateInsuranceConfirm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 this.baseService.updateInsurance(model);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}
	
	@RequestMapping(value = "/updateModifyInsurance.acl")
	public String updateModifyInsurance(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 this.baseService.updateModifyInsurance(model);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}
	
	@RequestMapping(value = "/addInsuranceConfirm.acl")
	public String addInsuranceInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		String vouchernumber = model.get("vouchernumber");
		String hql ="from ContractEquip where  contractId.id = ?";
		List<ContractEquip> cequip = this.baseService.findResultsByHSQL(hql, vouchernumber);
		if(cequip.size()>0)
		{
		   List list = new ArrayList();
			for(int i=0;i<cequip.size();i++){
				  list.add(cequip.get(i).getChassisNum().toString());
			}
			request.setAttribute("assurornameinfo",list.toString().replace("[", "").replace("]", ""));
		}
		return "solutions/leasing/insure_manage/chassisnum_detail.jsp";
	}
}
