package com.business.controller.intereasVoucher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.controller.BaseController;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoAccount;
import com.business.entity.dealer.DealerDeptInfo;
import com.business.entity.voucher.IntereasVoucherEntries;
import com.business.entity.voucher.IntereasVoucherHead;
import com.business.entity.voucher.IntereasVoucherasStacts;
import com.business.entity.voucher.VoucherassStactsInfo;
import com.business.service.BaseService;
import com.business.service.voucher.VoucherService;
import com.kernal.utils.QueryUtil;

@Controller(value = "intereasVoucherModController")
@RequestMapping(value = "/**/leasing")
public class IntereasVoucherModController extends BaseController{
	private static final Logger log = LoggerFactory.getLogger(IntereasVoucherModController.class);
	@Resource(name = "voucherService")
	private VoucherService voucherService;
	
	@Resource(name = "baseService")
	private BaseService baseService;
	
	@RequestMapping(value = "/updateIntereasVoucherMod.action")
	@ResponseBody
	public String updateIntereasVoucherMod(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try{
			Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
			String data = model.get("data");
			this.voucherService.updateVoucherhead(data);
		}catch (Exception e) {
			return "修改失败!["+e.getMessage()+"]";
		}
		return "修改成功！";
	}
		 
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/checkBizDate.acl")
	@ResponseBody
	public Object checkBizDate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		String bizDate=model.get("bizDate");
		System.out.println("bizDate:"+bizDate);
		String sql="select getAccountDay('"+bizDate+"') accountDay from dual";
		System.out.println("sql:"+sql);
		return baseService.getBussinessDao().getJdbcTemplate().queryForList(sql).get(0).get("accountDay").toString();
		 
	}
	
	@RequestMapping(value = "/changeValue.acl")
	public String changeValue(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		String voucherassstacts_info_id = model.get("voucherassstacts_info_id");
		String message = "";
		VoucherassStactsInfo voucherassstactsinfo = this.baseService.findEntityByID(VoucherassStactsInfo.class, voucherassstacts_info_id);
		String returnInfo = this.baseService.getEntityPropertiesToJsonEntity(voucherassstactsinfo, null).toString();
		System.out.println(returnInfo);
		this.output(response, returnInfo);
		/*
		System.out.println("voucherassstacts_info_id=="+voucherassstacts_info_id);
		String message = "";
		if(voucherassstacts_info_id!=null && !"".equals(voucherassstacts_info_id) ){
		
			//VoucherassStactsInfo voucherassstactsinfo = this.baseService.findEntityByID(VoucherassStactsInfo.class, voucherassstacts_info_id);
				String hsql = " from IntereasVoucherasStacts as ivs where ivs.asstActType.id=?";
				String values = voucherassstacts_info_id;
				System.out.println("values="+values);
				List<IntereasVoucherasStacts> intereasvoucherasstacts = this.baseService.findResultsByHSQL(hsql, values);
				
				
				//String values2 = intereasvoucherasstacts.get(0).getId();
				//List<IntereasVoucherEntries> intereasvoucherentries = this.baseService.findResultsByHSQL(hsql2, values2);
				System.out.println("size:"+intereasvoucherasstacts.size());
				if(intereasvoucherasstacts.size()>0){
					Map<String,String> map = new HashMap<String, String>();
					
					map.put("entrySeq.voucherNumber.voucherNumber","entrySeq_voucherNumber_voucherNumber");
					//得到客户编号
					System.out.println("userid=========="+intereasvoucherasstacts.get(0).getCustIdB().getCustNumber());
						//if(!"".equals(intereasvoucherasstacts.get(0).getCustIdB().getCustName() )
					    {
							//map.put("custIdB.custNumber","custIdB_custNumber");
							String returnInfo = this.baseService.getCollectionEntitiesPropertiesToJsonArrayWithOtherEntityFields(intereasvoucherasstacts,null, map).toString();
							System.out.println(returnInfo);
							this.output(response, returnInfo);
						}
					
				}else{
					message = "没有此分类";
				}
		}
		*/
		return message;
		 
	}
	
	@ResponseBody
	@RequestMapping(value = "/removeIntereasVoucherasStacts.acl")
	public String removeIntereasVoucherasStacts(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 String message                                 = "";
		 Map<String,String> model                       = QueryUtil.getRequestParameterMapByAjax(request);
		 String eas_flag                                = model.get("eas_flag");
		// String hsql                                    = " from IntereasVoucherHead ivh where ivh.intereasVoucherEntries.intereasVoucherasStacts.id=?";
		// List<IntereasVoucherHead> intereasvoucherheads = null;
		// if(eas_flag != null && !"".equals(eas_flag)){
			 //intereasvoucherheads = this.baseService.findResultsByHSQL(hsql, id);
			 //if(intereasvoucherheads.size()>0){
				 if(!"1".equals(eas_flag)){
					 message = "该凭证已导入财务系统中，不允许删除，请联系管理员";
					 return message;
				 }else{
					 IntereasVoucherasStacts info = new IntereasVoucherasStacts();
					 this.baseService.copyAndOverrideExistedValueFromStringMap(model, info, null);
					 this.baseService.removeEntity(info);
					 if(log.isInfoEnabled()){
						 log.info("删除成功!");
					 }
					 message = "删除成功!";
				 }
			// }
		// }
		 return message;
	}
	
	
	
	
	
	
}
