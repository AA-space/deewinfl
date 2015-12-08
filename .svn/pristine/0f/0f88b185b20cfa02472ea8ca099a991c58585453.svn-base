package com.business.serviceImpl.equip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.ContractEquipDelivery;
import com.business.service.equip.ContractEquipDeliveryService;
import com.business.serviceImpl.AbstractBaseServiceImpl;

@Service(value="contractEquipDeliveryService")
public class ContractEquipDeliveryServiceImpl extends AbstractBaseServiceImpl implements ContractEquipDeliveryService {
	
	@Resource
	private BaseDao baseDao;
	
	private Logger logger=Logger.getLogger(ContractEquipDeliveryServiceImpl.class);

	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}
	
	@Override
	public void addContractEquipDelivery(Map<String,String> model) throws Exception{
		 
		 ContractEquipDelivery info = new ContractEquipDelivery();
		 this.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.saveEntity(info);
		   
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
	}
	
	@Override
	public void updateContractEquipDelivery(Map<String,String> model) throws Exception{
		 ContractEquipDelivery info = new ContractEquipDelivery();
		 Map<String, Object> params = new HashMap<String, Object>();
		 System.out.println(model.get("rawValue_contractid"));
		 params.put("contractId", model.get("rawValue_contractid"));
		 List<ContractInfo> ci = (List<ContractInfo>)this.findEntityByProperties(ContractInfo.class, params);
		 model.put("contractid",ci.get(0).getId());
		 this.copyAndOverrideExistedValueFromStringMap(model, info, null);
		 this.saveOrUpdateEntity(info);
		   
		 if(logger.isInfoEnabled()){
			 logger.info("新增成功!");
		 }
	}
	
	@Override
	public void removeContractEquipDelivery(String id) throws Exception{
		this.removeEntityById(ContractEquipDelivery.class, id);
	}
}
