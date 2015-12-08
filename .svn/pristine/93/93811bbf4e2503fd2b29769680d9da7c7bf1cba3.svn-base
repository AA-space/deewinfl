package com.business.controller.fundOverduerent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.dun.DunningNotice;
import com.business.service.BaseService;
import com.google.inject.internal.Maps;
import com.kernal.utils.JacksonUtil;
import com.kernal.utils.QueryUtil;

@Controller(value = "OverdueRentLetterinfoController")
@RequestMapping(value = "/**/acl")
public class OverdueRentLetterinfoController {
	private Logger logger=Logger.getLogger(FundOverduerentController.class);
	@Resource(name = "baseService")
	private BaseService baseService;
	
	
	@RequestMapping(value = "/addOverdueRentLetterinfo.acl")
	@ResponseBody
	public String addOverdueRentLetterinfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 
		 List<DunningNotice> list = new ArrayList<DunningNotice>();

		 JSONArray jsonArray = new JSONArray(model.get("dunningnotice"));
		 
		 for(int i = 0; i<jsonArray.length();i++){
			 DunningNotice info = new DunningNotice();
			 
			 JSONObject dunningNoticeJson = jsonArray.optJSONObject(i);
			 info.setCustIsPrint(0);//"承租人导出标记"默认为未导出
			 info.setAssurorIsPrint(0);//"担保人导出标记"默认为未导出
			 ContractInfo contractInfo = (ContractInfo) this.baseService.findEntityByID(ContractInfo.class, dunningNoticeJson.optString("contractid"));
			 CustInfo custInfo = (CustInfo) this.baseService.findEntityByID(CustInfo.class, dunningNoticeJson.optString("custid"));
			 info.setSendDate(dunningNoticeJson.optString("senddate"));
			 if(contractInfo != null){
				 info.setContractId(contractInfo);
			 }
			 if(custInfo !=null){
				 info.setCustId(custInfo);
			 }
			 this.baseService.saveOrUpdateEntity(info);
		 }
		 if(logger.isInfoEnabled()){
			 logger.info("保存成功!"); 
		 }
		return null;
	}
}

