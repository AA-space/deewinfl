package com.business.controller.dealer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.User;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.CustInfoDealer;
import com.business.entity.dealer.DealerFileConfig;
import com.business.entity.dealer.DealerFileInfo;
import com.business.service.BaseService;
import com.kernal.utils.DateUtil;
import com.kernal.utils.QueryUtil;
import com.kernal.utils.SecurityUtil;
@Controller(value = "dealerFileManagementController")
@RequestMapping(value = "/**/acl")
public class DealerFileManagementController extends BaseController {
	@Resource(name = "baseService")
	private BaseService baseService;
	

	@RequestMapping(value = "/saveDealerFileData.acl")
	@ResponseBody
	public String saveDealerFileData(HttpServletRequest request,HttpServletResponse response) throws Exception {
		User user = (User) SecurityUtil.getPrincipal();
		String date=DateUtil.getSystemDateTime();
		
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 String custid = model.get("data[custid]");
		 CustInfo dealer = (CustInfo) this.baseService.findEntityByID(CustInfo.class, custid);
		 JSONArray fileArray = new JSONArray(model.get("data[jsondata]"));
		 //list
		 List<DealerFileInfo> fileList = new ArrayList<DealerFileInfo>();
		 for(int i = 0;i<fileArray.length();i++){
			 JSONObject jobj=fileArray.getJSONObject(i);
			 DealerFileInfo fileInfo = new DealerFileInfo();
			 String id         = jobj.optString("id");
			 String fileid     = jobj.optString("fileid");
			 if(id!=null && !"".equals(id)){
				 fileInfo = this.baseService.findEntityByID(DealerFileInfo.class, id);
			 }
			 DealerFileConfig fileNameData = this.baseService.findEntityByID(DealerFileConfig.class, fileid);
			 
			 fileInfo.setCustId(dealer);
			 fileInfo.setFileId(fileNameData);
			 fileInfo.setMemo(jobj.optString("memo"));
			 fileInfo.setFileStatus(jobj.optString("filestatus"));
			 fileInfo.setAmount(jobj.optString("filenum"));
			 fileInfo.setCreateDate(date);
			 fileInfo.setCreator(user);
			 fileList.add(fileInfo);
		 }
		 //不合作经销商
		if("1".equals(model.get("data[flag]"))){
			CustInfoDealer dealerInfo = dealer.getCustInfoDealer();
			dealerInfo.setDealerFileStatus("1");
		}else{
			CustInfoDealer dealerInfo = dealer.getCustInfoDealer();
			dealerInfo.setDealerFileStatus("0");
		}
		 this.baseService.saveOrUpdateAllEntities(fileList);
		return "保存成功";
	}

}


