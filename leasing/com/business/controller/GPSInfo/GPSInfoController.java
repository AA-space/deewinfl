package com.business.controller.GPSInfo;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.contract.equip.gps.GPSInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.util.OwnInfo;
import com.business.service.BaseService;
import com.kernal.utils.QueryUtil;
/**
 * 
 * @author lyh
 * @date 2013-6-5上午10:55:13
 * @info 本方信息的Action
 * @Copyright 
 * Tenwa
 */
@Controller(value = "GPSInfoController")
@RequestMapping(value = "/**/acl")
public class GPSInfoController {
	private Logger logger=Logger.getLogger(GPSInfoController.class);
	@Resource(name = "baseService")
	private BaseService baseService;

	// #################
	@RequestMapping(value = "/addGPSInfo.acl")
	public String addGPSInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 GPSInfo ownInfo=new GPSInfo();
		 String custid = model.get("cust_name");
		 String dealerid = model.get("dealer_name");
		 String contractid = model.get("contract_number");
		 String equipid = model.get("chassisnum");
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, ownInfo, null);
		 ownInfo.setId(model.get("id"));
		 //获取承租人
		 if(custid!=null&&!"".equals(custid)&&""!=custid){
			 CustInfo cust = this.baseService.findEntityByID(CustInfo.class, custid);
			 ownInfo.setCustId(cust);
		 }
		 //获取经销商
		 if(dealerid!=null&&!"".equals(dealerid)&&""!=dealerid){
			 CustInfo dealer = this.baseService.findEntityByID(CustInfo.class, dealerid);
			 ownInfo.setCustDealer(dealer);
		 }
		//获取合同
		 if(contractid!=null&&!"".equals(contractid)&&""!=contractid){
			 ContractInfo contract = this.baseService.findEntityByID(ContractInfo.class, contractid);
			 ownInfo.setContractId(contract);
		 }
		 
		 //车架号
		 if(equipid!=null&&!"".equals(equipid)&&""!=equipid){
			 ContractEquip  equip = this.baseService.findEntityByID(ContractEquip .class, equipid);
			 ownInfo.setEquipID(equip);
		 }
		 this.baseService.saveEntity(ownInfo);
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/updateGPSInfo.acl")
	public String updateGPSInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 GPSInfo ownInfo=new GPSInfo();
		 String custid = model.get("cust_name");
		 String dealerid = model.get("dealer_name");
		 String contractid = model.get("contract_number");
		 String equipid = model.get("chassisnum");
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, ownInfo, null);
		 ownInfo.setId(model.get("id"));
		 //获取承租人
		 if(custid!=null&&!"".equals(custid)&&""!=custid){
			 CustInfo cust = this.baseService.findEntityByID(CustInfo.class, custid);
			 ownInfo.setCustId(cust);
		 }
		 //获取经销商
		 if(dealerid!=null&&!"".equals(dealerid)&&""!=dealerid){
			 CustInfo dealer = this.baseService.findEntityByID(CustInfo.class, dealerid);
			 ownInfo.setCustDealer(dealer);
		 }
		//获取合同
		 if(contractid!=null&&!"".equals(contractid)&&""!=contractid){
			 ContractInfo contract = this.baseService.findEntityByID(ContractInfo.class, contractid);
			 ownInfo.setContractId(contract);
		 }
		 
		 //车架号
		 if(equipid!=null&&!"".equals(equipid)&&""!=equipid){
			 ContractEquip  equip = this.baseService.findEntityByID(ContractEquip .class, equipid);
			 ownInfo.setEquipID(equip);
		 }
		 this.baseService.updateEntity(ownInfo);
		 if(logger.isInfoEnabled()){
			 logger.info("修改成功!");
		 }
		return null;
	}

	@RequestMapping(value = "/removeGPSInfo.acl")
	public String removeGPSInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 Map<String,String> model =QueryUtil.getRequestParameterMapByAjax(request);
		 GPSInfo ownInfo=new GPSInfo();
		 this.baseService.copyAndOverrideExistedValueFromStringMap(model, ownInfo, null);
		 //ownInfo.setId(model.get("id"));
		 ownInfo=(GPSInfo)this.baseService.findEntityByID(GPSInfo.class, model.get("id"));
	//	 Iterator<OwnAccount> set=ownInfo.getOwnAccounts().iterator();
//		 while(set.hasNext()){
//			 OwnAccount s =set.next();
//			 this.baseService.removeEntity(s);
//		 }
//		 this.baseService.removeAllEntites(ownInfo.getOwnAccounts());
		 this.baseService.removeEntity(ownInfo);
		 if(logger.isInfoEnabled()){
			 logger.info("删除成功!");
		 }
		return null;
	}
}

