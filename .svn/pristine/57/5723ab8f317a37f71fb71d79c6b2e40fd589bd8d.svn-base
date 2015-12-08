package com.business.controller.interest;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.controller.BaseController;
import com.business.controller.insure.InsuranceInfoController;
import com.business.entity.User;
import com.business.entity.contract.reckon.fund.FundAdjustInterestContractTemp;
import com.business.entity.insurance.InsuranceInfo;
import com.business.entity.interest.FundStandardInterest;
import com.business.service.BaseService;
import com.kernal.utils.DateUtil;
import com.kernal.utils.QueryUtil;

@Controller(value = "fundStandardInterestController")
@RequestMapping(value = "/**/acl")
public class FundStandardInterestController extends BaseController{
	private Logger logger=Logger.getLogger(InsuranceInfoController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@RequestMapping(value = "/addFundStandardInterest.acl")
	public String addFundStandardInterest(HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 FundStandardInterest fsi = new FundStandardInterest();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, fsi, null);
		 fsi.setCreateDate(DateUtil.getSystemDateTime());
		 this.baseService.saveEntity(fsi);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		 return null;
	}
	
	@RequestMapping(value = "/updateFundStandardInterest.acl")
	public String updateFundStandardInterest(HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 System.out.println(model.toString());
		 FundStandardInterest fsi = new FundStandardInterest();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, fsi, null);
		 fsi.setModificator((User)request.getSession().getAttribute("loginUser"));
		 fsi.setModifyDate(DateUtil.getSystemDateTime());
		 this.baseService.updateEntity(fsi);
		 String adjustId = model.get("id");
		 System.out.println("adjustId:"+adjustId);
		 String returnInfo = "";
		 List<FundAdjustInterestContractTemp> tempList = this.baseService.findResultsByHSQL(" from FundAdjustInterestContractTemp where adjust_id=?", adjustId);
		 //如果央行记录调息表 正在调息提示不能修改 央行基准利率表
		 if(!tempList.isEmpty()){
			 returnInfo = "error";
		 }
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		 this.output(response, returnInfo);
		 return null;
	}
	
	@RequestMapping(value = "/removeFundStandardInterest.acl")
	public String removeFundStandardInterest(HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 FundStandardInterest fsi = new FundStandardInterest();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, fsi, null);
		 this.baseService.removeEntity(fsi);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		 return null;
	}
	public static void main(String[] args) {
		System.out.println(DateUtil.getSystemDateTime());
	}

}
