package com.business.controller.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.insurance.ContractInsuranceSureInfo;
import com.business.service.BaseService;
import com.business.service.TableService;
import com.kernal.utils.QueryUtil;

@Controller(value = "ProjectPutStartFlowCheckControllers")
@RequestMapping(value = "/**/leasing")
public class ProjectPutStartFlowCheckController {
	@Resource(name = "baseService")
	private BaseService baseService;
	@Resource(name = "tableService")
	private TableService tableService;
	
	/**
	 * <b>项目投放流程 发起校验</b><br>
	 * 
	 * 1、起租流程完成之后；<br>
	 * 2、全部资金收款完成；<br>
	 * 3、保险确认完成；<br>
	 * 4、GPS已安装.<br>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/projectPutStartFlowCheck.acl")
	public String projectPutStartFlowCheck(HttpServletRequest request,HttpServletResponse response)  throws Exception {
		Map<String,String> modelData = QueryUtil.getRequestParameterMapByAjax(request);
		String contractId = modelData.get("contract_id");
		System.out.println("项目投放流程 发起校验contractId="+contractId);
		String status        = "";
		/*status=1:起租流程完成之后,status=2:全部资金收款完成,status=3:保险确认完成,status=4:GPS已安装
		 * status=-1:起租未完成，status=-2：全部资金收款未完成，status=-3：保险确认未完成，status=-4：GPS没有安装
		 * status=-5：系统获取合同id错误
		 * */
		if(contractId!="" && !"".equals(contractId) && contractId!=null){
			//1.合同起租流程完成之后	
			status = this.checkOnHireOver(contractId);
				if(status=="1"){
					//2、全部资金收款完成；
					status = this.checkAllFundOver(contractId);
					if(status=="2"){
						//3.保险确认完成
						status = this.checkInsuranceOver(contractId);
						if(status=="3"){
							//4、GPS已安装
							status = this.gpsInstalled(contractId);
							if(status != "4"){
								status = "-4";
							}
						}else{
							status = "-3";
						}
					}else{
						status = "-2";
					}
				}else{
					status = "-1";
				}
		}else{
			status = "-5";
		}
		return status;
	}

	/**
	 * GPS是否安装检测
	 * @param contractId
	 * @return
	 * @throws Exception
	 */
	private String gpsInstalled(String contractId) throws Exception {
		String messge = "";
			String  hsql = "FROM GPSInfo GPS  where 1=1 and GPS.isGPS='0' and GPS.contractId.id=?";
			List<ContractEquip> contractEquipList = this.baseService.findResultsByHSQL(hsql, contractId);
			//该合同没有GPS信息
			if(contractEquipList.isEmpty()){
				messge = "-4";
				return messge;
			}else{
				messge = "4";
				return messge;
			}
	}

	/**
	 * 保险确认完成检测
	 * @param contractId
	 * @return
	 * @throws Exception
	 */
	private String checkInsuranceOver(String contractId) throws Exception {
		String messge = "";
		ContractInsuranceSureInfo contractInsuranceSureInfo = this.baseService.findEntityByID(ContractInsuranceSureInfo.class, contractId);
		
		if(contractInsuranceSureInfo!=null){
			messge = "3";
			return messge;
		}else{
			messge = "-3";
			return messge;
		}
	}

	private String checkAllFundOver(String contractId) throws DataAccessException, Exception {
		Map<String, String> queryMainObjectMap = new HashMap<String, String>();
			queryMainObjectMap.put("contract_id", contractId);
		    Double plan =0.0;
		    Double charge =0.0 ;
		    ContractInfo cinfo=this.baseService.findEntityByID(ContractInfo.class, contractId);
		    if (!cinfo.getFundFundChargePlans().isEmpty()) {// 资金计划
		    	String planstr=this.tableService.getJsonArrayData("eleasing/workflow/contract/fund_fund_charge_plan.xml", queryMainObjectMap).toString();;
		      	JSONArray jsonArray = new JSONArray(planstr);
		      	for(int i=0;i<jsonArray.length();i++){
					  JSONObject jsonObj = jsonArray.getJSONObject(i);
					  if("pay_type_in".equals(jsonObj.get("paytype"))){
					     plan+=Double.parseDouble(jsonObj.get("planmoney").toString());
					  }
				}
	      }
	      if (!cinfo.getFundFundCharges().isEmpty()) {// 资金实收
	      	String varstr=this.baseService.getCollectionEntitiesPropertiesToJsonArrayString(cinfo.getFundFundCharges(), null, "");
	      	JSONArray jsonArray = new JSONArray(varstr);
	      	for(int i=0;i<jsonArray.length();i++){
				  JSONObject jsonObj = jsonArray.getJSONObject(i);
				  if("pay_type_in".equals(jsonObj.get("paytype"))){
				    	charge+=Double.parseDouble(jsonObj.get("factmoney").toString());
				  }
			}
	      }
	      if(plan>charge){
	    	  return "-2";
	      }else{
	    	  return "2";
	      }
		
	}

	/**
	 * 合同起租流程完成之后检测
	 * @param contractId
	 * @return
	 * @throws Exception 
	 */
	private String checkOnHireOver(String contractId) throws Exception {
		String messge = "";
		//流程名称		流程结束后修改对应状态值      流程发起范围
		//合同起租流程	31	                      22	22
		String hsql = "from ContractInfo where id=? and contractStatus>30";
		List<ContractInfo> contractInfo = this.baseService.findResultsByHSQL(hsql, contractId);
		if(contractInfo.isEmpty()){
			messge = "-1";
			return messge;
		}else{
			messge = "1";
			return messge;
		}
	}

}
