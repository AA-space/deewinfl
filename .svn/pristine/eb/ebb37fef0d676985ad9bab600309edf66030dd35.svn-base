
 /**
 * 项目名称：    系统名称
 * 包名：              com.business.serviceImpl.cust
 * 文件名：         CustServiceImpl.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-5-18-下午12:30:07
 * Copyright：2013XX公司-版权所有
 **/

package com.business.serviceImpl.cust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.DictionaryData;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.cust.CustInfoPerson;
import com.business.entity.cust.CustTypeInfo;
import com.business.exception.BusinessException;
import com.business.service.cust.CustService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.business.util.WorkflowUtil;
import com.kernal.utils.StringUtil;


 /**
 * 类名称：     CustServiceImpl
 * 类描述：     
 * 创建人：     Administrator
 * 修改人：     Administrator
 * 修改时间：2013-5-18 下午12:30:07
 * 修改备注：
 * @version 1.0.0
 **/
@Service(value="custService")
public class CustServiceImpl extends AbstractBaseServiceImpl implements
		CustService {

	@Resource
    private BaseDao baseDao;
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}
	//orgCode
	@Override
	public void addCustLaw(Map<String, String> model) throws Exception {
			 //构建出法人基本信息
			 CustInfoCompany infoCompany = new CustInfoCompany();
			 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
			 dictDataClassMapping.put("DictionaryData", "code");
			 dictDataClassMapping.put("District", "id");
			 dictDataClassMapping.put("Industry", "id");
			 this.copyAndOverrideExistedValueFromStringMap(model, infoCompany, dictDataClassMapping);
			 //构建客户基本信息主表
			 CustInfo info=new CustInfo();
			 String custNumber=WorkflowUtil.getCustInfoSerialNumber(model,this.getBussinessDao().getHibernateTemplate(), this.getBussinessDao().getJdbcTemplate());
			 info.setCustNumber(custNumber);
			 info.setCustName(model.get("custname"));
			 info.setDraft(model.get("draft"));
			 info.setInvalid(model.get("invalid"));
			 DictionaryData dict=new DictionaryData();
			 Map<String, Object> whereMap=new HashMap<String, Object>();
			 whereMap.put("code", "CUST_INFO_COMPANY");
			 dict=(DictionaryData)this.findEntityByProperties(DictionaryData.class, whereMap).get(0);
			 info.setCustClass(dict);
			 
			 String orgcode=model.get("orgcode");
			 String dealerorcompany = model.get("dealerorcompany");
			 Map<String,Object>propertiesMap=new HashMap<String,Object>();
			 propertiesMap.put("orgCode",orgcode);
			 propertiesMap.put("dealerOrCompany",dealerorcompany);
			 List  listf=new ArrayList ();
			 listf= this.findEntityByProperties(CustInfoCompany.class, propertiesMap);
			 if(listf!=null&&listf.size()>0){
				 throw new BusinessException("组织机构代码重复！");
			 }else{	 
			 this.saveEntity(info);//先保存客户基本信息表
			 //保存客户类别信息
			 String custType=model.get("custtype");
			 if(custType!=null&&!custType.equals("")){
				 String custTypes[]=custType.split(",");
				 List<CustTypeInfo> custTypeInfos=new ArrayList<CustTypeInfo>();
				 for (String temp:custTypes) {
					 CustTypeInfo cti=new CustTypeInfo();
					 whereMap=new HashMap<String, Object>();
					 whereMap.put("code", temp);
					 dict=(DictionaryData)this.findEntityByProperties(DictionaryData.class, whereMap).get(0);
					 cti.setCustId(info);
					 cti.setCustType(dict);
					 custTypeInfos.add(cti);
				}
				 this.saveAllEntities(custTypeInfos);
			 }
			 //处理可提供担保方式
			 infoCompany.setCollateralType("0");
			 infoCompany.setPledgeType("0");
			 infoCompany.setWarranterType("0");
			 String provideAssureType=model.get("provideassuretype");
			 if(provideAssureType!=null&&!provideAssureType.equals("")){
				 String provideAssureTypeS[]=provideAssureType.split(",");
				 for (String temp:provideAssureTypeS) {
					 if(temp.equalsIgnoreCase("collateraltype")){
						 infoCompany.setCollateralType("1");
					 }
					 if(temp.equalsIgnoreCase("pledgetype")){
						 infoCompany.setPledgeType("1");
					 }
					 if(temp.equalsIgnoreCase("warrantertype")){
						 infoCompany.setWarranterType("1");
					 }
				 }
			 }
			 //保存信息到法人客户
			 infoCompany.setCustId(info);
			 this.saveEntity(infoCompany);
		}
	
	 }
	@Override
	public void updateCustLaw(Map<String, String> model) throws Exception {
		//同一经销商时判断组织机构代码是否重复
		 String orgcode = model.get("orgcode");
		 String custId = model.get("id");
		 String dealerorcompany = model.get("dealerorcompany");
		 Map<String,Object>propertiesMap=new HashMap<String,Object>();
		 propertiesMap.put("orgCode",orgcode);
		 propertiesMap.put("dealerOrCompany",dealerorcompany);
		 List<CustInfoCompany>  listf=new ArrayList<CustInfoCompany> (this.findEntityByProperties(CustInfoCompany.class, propertiesMap)); 
		 for (CustInfoCompany custInfoCompany : listf) {
			if(custInfoCompany.getId().toLowerCase().equals(custId.toLowerCase())){
				listf.remove(custInfoCompany);
				break;
			}
		}
		 if(listf!=null&&listf.size()>0){			 
			 throw new BusinessException("组织机构代码重复！");
		 			 
		 }else{	 
		//构建出法人基本信息
		 CustInfoCompany infoCompany = (CustInfoCompany)this.baseDao.findEntityByID(CustInfoCompany.class, model.get("id"));
		 
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 this.copyAndOverrideExistedValueFromStringMap(model, infoCompany, dictDataClassMapping);
		 //构建客户基本信息主表
		 CustInfo info=infoCompany.getCustId();
		 info.setCustName(model.get("custname"));
		 info.setDraft(model.get("draft"));
		 info.setInvalid(model.get("invalid"));
		 this.updateEntity(info);//先保存客户基本信息表
		 //保存信息到法人客户
		 infoCompany.setCustId(info);
		 //处理可提供担保方式
		 infoCompany.setCollateralType("0");
		 infoCompany.setPledgeType("0");
		 infoCompany.setWarranterType("0");
		 String provideAssureType=model.get("provideassuretype");
		 if(provideAssureType!=null&&!provideAssureType.equals("")){
			 String provideAssureTypeS[]=provideAssureType.split(",");
			 for (String temp:provideAssureTypeS) {
				 if(temp.equalsIgnoreCase("collateraltype")){
					 infoCompany.setCollateralType("1");
				 }
				 if(temp.equalsIgnoreCase("pledgetype")){
					 infoCompany.setPledgeType("1");
				 }
				 if(temp.equalsIgnoreCase("warrantertype")){
					 infoCompany.setWarranterType("1");
				 }
			 }
		 }
		 this.updateEntity(infoCompany);
		 //保存客户类别信息
		 Map<String,CustTypeInfo> containMap = new HashMap<String,CustTypeInfo>();
		 for(CustTypeInfo cti : info.getCustType()){
			 containMap.put(cti.getCustType().getCode(),cti); 
		 }
		 String custType=model.get("custtype");
		 JSONArray jArray = new JSONArray();
	     if(!StringUtil.nullToString(custType).trim().isEmpty()){
		     String custTypes[]=custType.split(",");
		     for (String temp:custTypes) {
		    	  JSONObject jobj  = new JSONObject();
		    	  jobj.put("custType", temp);
		    	  if(containMap.containsKey(temp)){
		    		  jobj.put("id", containMap.get(temp).getId());
		    	  }
		    	  jArray.put(jobj);
		     }
	     }

		 this.updateOneToManyCollections(info, "custType", CustTypeInfo.class, "custId", jArray.toString(), dictDataClassMapping);
		
	}
	}

	@Override
	public void removeCustLaw(Map<String, String> model) throws Exception {
		//构建出法人基本信息
		CustInfoCompany infoCompany = (CustInfoCompany)this.baseDao.findEntityByID(CustInfoCompany.class, model.get("id"));
		CustInfo info=infoCompany.getCustId();
		info.setInvalid("0");
		this.updateEntity(info);
	}

	@Override
	public void addCustEwlp(Map<String, String> model) throws Exception {
		 //构建出自然人基本信息
		 CustInfoPerson infoPerson = new CustInfoPerson();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 this.copyAndOverrideExistedValueFromStringMap(model, infoPerson, dictDataClassMapping);		 
		 //构建客户基本信息主表
		 CustInfo info=new CustInfo();
		 String custNumber=WorkflowUtil.getCustInfoSerialNumber(model,this.getBussinessDao().getHibernateTemplate(), this.getBussinessDao().getJdbcTemplate());
		 info.setCustNumber(custNumber);
		 info.setCustName(model.get("custname"));
		 info.setDraft(model.get("draft"));
		 info.setInvalid(model.get("invalid"));
		 DictionaryData dict=new DictionaryData();
		 Map<String, Object> whereMap=new HashMap<String, Object>();
		 whereMap.put("code", "CUST_INFO_PERSON");
		 dict=(DictionaryData)this.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		 info.setCustClass(dict);
		 
		 String idcardno = model.get("idcardno");
		 String dealerorcompany = model.get("dealerorcompany");
		 Map<String,Object>propertiesMap=new HashMap<String,Object>();
		 propertiesMap.put("idCardNo",idcardno);
		 propertiesMap.put("dealerOrCompany",dealerorcompany);
		 List  listf=new ArrayList ();
		 listf= this.findEntityByProperties(CustInfoPerson.class, propertiesMap);
		 if(listf!=null&&listf.size()>0){
			 throw new BusinessException("身份证号码重复！");
		 }else{	 
		 this.saveEntity(info);//先保存客户基本信息表
		 //保存客户类别信息
		 String custType=model.get("custtype");
		 if(custType!=null&&!custType.equals("")){
			 String custTypes[]=custType.split(",");
			 List<CustTypeInfo> custTypeInfos=new ArrayList<CustTypeInfo>();
			 for (String temp:custTypes) {
				 CustTypeInfo cti=new CustTypeInfo();
				 whereMap=new HashMap<String, Object>();
				 whereMap.put("code", temp);
				 dict=(DictionaryData)this.findEntityByProperties(DictionaryData.class, whereMap).get(0);
				 cti.setCustId(info);
				 cti.setCustType(dict);
				 custTypeInfos.add(cti);
			}
			 this.saveAllEntities(custTypeInfos);
		 }		 		 			 
			//保存信息到自然人客户
			 infoPerson.setCustId(info);
			 this.saveEntity(infoPerson);			 
		 }		 		 			
	}


	@Override
	public void updateCustEwlp(Map<String, String> model) throws Exception {
		
		//判断身份证号码是否重复
		 String idcardno = model.get("idcardno");
		 String custId = model.get("id");
		 String dealerorcompany = model.get("dealerorcompany");
		 Map<String,Object>propertiesMap=new HashMap<String,Object>();
		 propertiesMap.put("idCardNo",idcardno);
		 propertiesMap.put("dealerOrCompany",dealerorcompany);
		 List<CustInfoPerson>  listf=new ArrayList<CustInfoPerson> (this.findEntityByProperties(CustInfoPerson.class, propertiesMap)); 
		 for (CustInfoPerson custInfoPerson : listf) {
			if(custInfoPerson.getId().toLowerCase().equals(custId.toLowerCase())){
				listf.remove(custInfoPerson);
				break;
			}
		}
		 if(listf!=null&&listf.size()>0){			 
			 throw new BusinessException("身份证号码重复！");
		 			 
		 }else{	 
		//构建出自然人基本信息
		 CustInfoPerson infoPerson = (CustInfoPerson)this.baseDao.findEntityByID(CustInfoPerson.class, model.get("id"));
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 this.copyAndOverrideExistedValueFromStringMap(model, infoPerson, dictDataClassMapping);
		 //构建客户基本信息主表
		 CustInfo info=infoPerson.getCustId();
		 info.setCustName(model.get("custname"));
		 info.setDraft(model.get("draft"));
		 info.setInvalid(model.get("invalid")); 
		 this.updateEntity(info);//先保存客户基本信息表
		 //保存信息到自然人客户
		 infoPerson.setCustId(info);
		 this.updateEntity(infoPerson);
		 //保存客户类别信息
		 Map<String,CustTypeInfo> containMap = new HashMap<String,CustTypeInfo>();
		 for(CustTypeInfo cti : info.getCustType()){
			 containMap.put(cti.getCustType().getCode(),cti); 
		 }
		 String custType=model.get("custtype");
		 JSONArray jArray = new JSONArray();
	     if(!StringUtil.nullToString(custType).trim().isEmpty()){
		     String custTypes[]=custType.split(",");
		     for (String temp:custTypes) {
		    	  JSONObject jobj  = new JSONObject();
		    	  jobj.put("custType", temp);
		    	  if(containMap.containsKey(temp)){
		    		  jobj.put("id", containMap.get(temp).getId());
		    	  }
		    	  jArray.put(jobj);
		     }
	     }

			 this.updateOneToManyCollections(info, "custType", CustTypeInfo.class, "custId", jArray.toString(), dictDataClassMapping);
		 }
	 }
	
	
	@Override
	public void removeCustEwlp(Map<String, String> model) throws Exception {
		//构建出自然人基本信息
		CustInfoPerson infoPerson = (CustInfoPerson)this.baseDao.findEntityByID(CustInfoPerson.class, model.get("id"));
		CustInfo info=infoPerson.getCustId();
		info.setInvalid("0");
		this.updateEntity(info);
		
	}

	@Override
	public String loadCustLaw(Map<String, String> model) throws Exception {
		// TODO Auto-generated method stub
		CustInfoCompany custinfo=(CustInfoCompany)this.baseDao.findEntityByID(CustInfoCompany.class, model.get("id"));
		Map<String,String>fieldClassMap=new HashMap<String,String>();
		fieldClassMap.put("DictionaryData", "code");
		List<CustInfoCompany> custinfoList=new ArrayList<CustInfoCompany>();
		
		if(custinfo!=null){
			custinfoList.add(custinfo);
			return this.getCollectionEntitiesPropertiesToJsonArray(custinfoList, fieldClassMap).get(0).toString();
		}
		return "";
	}
	@Override
	public void resetCustEwlp(String id) throws Exception {
		CustInfo info = (CustInfo)this.baseDao.findEntityByID(CustInfo.class,id);
		info.setInvalid("1");
		this.updateEntity(info);
	}
	
	
}
