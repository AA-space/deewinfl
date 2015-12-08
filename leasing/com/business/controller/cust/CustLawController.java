package com.business.controller.cust;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.entity.cust.CustInfoCompany;
import com.business.entity.cust.CustInfoPerson;
import com.business.service.cust.CustService;
import com.kernal.utils.QueryUtil;

/**
 * 
 * @author 孙传良
 * @date 2013-4-22上午10:30:01
 * @info 法人客户
 * @Copyright Tenwa
 */
@Controller(value = "CustLawController")
@RequestMapping(value = "/**/acl")
public class CustLawController {
	@Resource(name = "custService")
	private CustService baseService;

	// #################
	@RequestMapping(value = "/addCustLaw.acl")
	@ResponseBody
	public String addCustLaw(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.addCustLaw(model);
		}catch (Exception e) {
			return "添加失败!["+e.getMessage()+"]";
		}
		return null;
	}

	@RequestMapping(value = "/updateCustLaw.acl")
	@ResponseBody
	public String updateCustLaw(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.updateCustLaw(model);
		}catch (Exception e) {
			return "修改失败!["+e.getMessage()+"]";
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/checkCustLaw.acl")
	@ResponseBody
	public String checkCustLaw(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		//当前经销商
		String currentDealerCustInfoId = (String) request.getSession().getAttribute("currentDealerCustInfoId");
		
		String idcardno=model.get("idcardno");
		String orgcode=model.get("orgcode");
		Map<String,Object> where=new HashMap<String, Object>();
		where.put("dealerOrCompany", currentDealerCustInfoId);
		
		if(orgcode != null){
			//添加经销商限制
			where.put("orgCode", orgcode);
			
			List<CustInfoCompany> cicList=(List<CustInfoCompany>)this.baseService.findEntityByProperties(CustInfoCompany.class, where);
			if(cicList!=null&&cicList.size()>0){
				return "与已有客户["+cicList.get(0).getCustId().getCustName()+"]组织机构代码重复!";
			}else{
				return null;
			}
		} else if(idcardno != null){
			where.put("idCardNo", idcardno);
			List<CustInfoPerson> cicList=(List<CustInfoPerson>)this.baseService.findEntityByProperties(CustInfoPerson.class, where);
			if(cicList!=null&&cicList.size()>0){
				return "与已有客户["+cicList.get(0).getCustId().getCustName()+"]身份证重复!";
			}else{
				return null;
			}
		} else {
			return null;
		}
		
	}
	@RequestMapping(value = "/removeCustLaw.acl")
	@ResponseBody
	public String removeCustLaw(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.removeCustLaw(model);
		}catch (Exception e) {
			return "作废失败!["+e.getMessage()+"]";
		}
		return null;
	}
	@RequestMapping(value = "/loadCustLaw.acl")
	@ResponseBody
    public String loadCustLaw(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			System.out.print("xxx");
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			return this.baseService.loadCustLaw(model);
		}catch (Exception e) {
			return "作废失败!["+e.getMessage()+"]";
		}
	}
}
