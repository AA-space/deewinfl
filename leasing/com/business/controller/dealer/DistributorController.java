package com.business.controller.dealer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.dealer.CustInfoDealer;
import com.business.service.dealer.DistributorService;
import com.kernal.utils.QueryUtil;
/**
 * yixiaohui
 * 经销商管理
 */
@Controller(value = "DistributorController")
@RequestMapping(value = "/**/acl")
public class DistributorController extends BaseController {
	@Resource(name = "distributorService")
	private DistributorService baseService;
	
	@RequestMapping(value = "/addDistributor.acl")
	@ResponseBody
	public String addDistributor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.addDistributor(model);
		}catch (Exception e) {
			return "添加失败!["+e.getMessage()+"]";
		}
		return null;
	}
	
	
	@RequestMapping(value = "/updateDistributor.acl")
	@ResponseBody
	public String updateDistributor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.updateDistributor(model);
		}catch (Exception e) {
			return "修改失败!["+e.getMessage()+"]";
		}
		return null;
	}
	
	@RequestMapping(value = "/removeDistributor.acl")
	@ResponseBody
	public String removeDistributor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			this.baseService.removeDistributor(model);
		}catch (Exception e) {
			return "删除失败!["+e.getMessage()+"]";
		}
		return null;
	}

@SuppressWarnings("unchecked")
@RequestMapping(value = "/checkCustdealer.acl")
@ResponseBody
public String checkCustdealer(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
	String custid=model.get("custid");
	String orgcode=model.get("orgcode");
	Map<String,Object> where=new HashMap<String, Object>();
	where.put("orgCode", orgcode);
	List<CustInfoDealer> cicList=(List<CustInfoDealer>)this.baseService.findEntityByProperties(CustInfoDealer.class, where);
	if(cicList!=null&&cicList.size()>0){
		for(CustInfoDealer ci:cicList){
			if(!ci.getCustId().getId().equals(custid)){
				return "与已有客户["+cicList.get(0).getCustId().getCustName()+"]组织机构代码重复!";
			}
		}
		return null;
	}else{
		return null;
		}
	}
}
