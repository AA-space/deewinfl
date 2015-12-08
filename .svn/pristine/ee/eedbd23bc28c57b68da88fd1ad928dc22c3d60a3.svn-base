package com.business.serviceImpl.Insurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.business.dao.BaseDao;
import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.insurance.InsuranceInfo;
import com.business.entity.insurance.InsurancePrice;
import com.business.entity.proj.ProjInfo;
import com.business.service.Insurance.InsuranceService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.business.util.WorkflowUtil;
@Service(value="insuranceService")
public class InsuranceServiceImpl extends AbstractBaseServiceImpl implements InsuranceService {

	@Resource
    private BaseDao baseDao;
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}
	
	@Override
	public void addInsurance(Map<String, String> model) throws Exception {
		InsuranceInfo info = new InsuranceInfo();
		InsurancePrice insurancePrice = new InsurancePrice();
		ContractInfo contractId=new ContractInfo();
		ProjInfo projInfo = new ProjInfo();
		CustInfo dealer = new CustInfo();
		
		//获得保险单编号insuranceId
		String insuranceId = WorkflowUtil.getInsurInfoSerialNumber(model,
				this.getBussinessDao().getHibernateTemplate(), this.getBussinessDao().getJdbcTemplate());
		//获得合同编号
		 contractId.setId(model.get("chassisnum").split("/")[2]);
		 projInfo.setId(model.get("chassisnum").split("/")[3]);
		 //System.out.println("合同编号="+model.get("contractid"));
		 System.out.println("合同编号="+model.get("chassisnum").split("/")[0]);
		 //获得经销商编号
		 dealer.setId(model.get("dealerorcompany"));
		 //转换数据字典类型
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 model.put("insuranceId", insuranceId);
		 //info.setInsurancePrice(insurancePrice);
		 //自动给InsuranceInfo进行转换赋值 
		 this.copyAndOverrideExistedValueFromStringMap(model,info,dictDataClassMapping);
		 //给InsuranceInfo相关引用字段进行赋值
		 info.setContractId(contractId);
		 //info.setInsuranceId(insuranceId);
		 info.setDealer(dealer);
		 info.setProjID(projInfo);
		 info.setChassisNo(model.get("chassisnum").split("/")[0]);
		 //保存InsuranceInfo
		 this.saveEntity(info);
//		 //根据insuranceId反查出id
		 Map<String,Object> propertiesMap=new HashMap<String,Object>();
		 propertiesMap.put("insuranceId",insuranceId);
		 info= (InsuranceInfo)this.findEntityByProperties(InsuranceInfo.class, propertiesMap).get(0);
		 
		 //根据车架号判断是否新投保或是续保
		 Map<String,Object> propertiesMap2=new HashMap<String,Object>();
		 propertiesMap2.put("chassisNo", model.get("chassisnum").split("/")[0]);
		 List<InsuranceInfo> listInsuranceInfo= (List<InsuranceInfo>)this.findEntityByProperties(InsuranceInfo.class, propertiesMap2);
		   //# modify by caiyc 2014-4-3
		 if (listInsuranceInfo.size() > 1)
		 {
			 info.setInitInsurType("续保");
		 }
		 else
		 {
			 info.setInitInsurType("新投保");
		 }
		 
		 //dictDataClassMapping.put("InsuranceInfo", "insuranceId");
		 //自动给insurancePrice进行转换赋值 
		 this.copyAndOverrideExistedValueFromStringMap(model, insurancePrice, dictDataClassMapping);
		 //给insurancePrice进行相关字段赋值
		 insurancePrice.setInsurID(info);
		 insurancePrice.setContractId(contractId);
		 insurancePrice.setProjID(projInfo);
		 //保存insurancePrice
		 this.saveEntity(insurancePrice);
	}

	

	@Override
	public void updateInsurance(Map<String, String> model) throws Exception {
		InsuranceInfo info = (InsuranceInfo)this.baseDao.findEntityByID(InsuranceInfo.class, model.get("id"));
		InsurancePrice insurancePrice = new InsurancePrice();
		ContractInfo contractInfo = new ContractInfo();
		ProjInfo projInfo = new ProjInfo();
		
		contractInfo=info.getContractId();
		projInfo = info.getProjID();
		System.out.println("isinsurance1="+model.get("isinsurance1"));
		
		Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		Map<String,Object> propertiesMap=new HashMap<String,Object>();
		dictDataClassMapping.put("DictionaryData", "code");
		propertiesMap.put("insurID",info);
		insurancePrice = this.baseDao.findEntityByProperties(InsurancePrice.class, propertiesMap).get(0);
		
		this.copyAndOverrideExistedValueFromStringMap(model, info, dictDataClassMapping);
		System.out.println("22222");
		model.remove("id");
		this.copyAndOverrideExistedValueFromStringMap(model, insurancePrice, dictDataClassMapping);
		System.out.println("3333");
		info.setProjID(projInfo);;
		info.setContractId(contractInfo);
		System.out.println("isinsurance1="+model.get("isinsurance1"));
		this.updateEntity(info);
		this.updateEntity(insurancePrice);
		
	}

	@Override
	public void removeInsurance(Map<String, String> model) throws Exception {
		InsuranceInfo info = (InsuranceInfo)this.baseDao.findEntityByID(InsuranceInfo.class, model.get("id"));
		info.setInvalid("0");
		InsurancePrice insurancePrice = new InsurancePrice();
		Map<String,Object> propertiesMap=new HashMap<String,Object>();
		propertiesMap.put("insurID",info);
		insurancePrice = this.baseDao.findEntityByProperties(InsurancePrice.class, propertiesMap).get(0);
		//this.updateEntity(info);
		this.removeEntity(insurancePrice);
		this.removeEntity(info);
	}
	

}
