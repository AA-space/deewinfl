package com.business.serviceImpl.Insurance;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.insurance.ContractInsuranceSureInfo;
import com.business.service.Insurance.InsuranceConfirmService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;



/**
 * @author mhy
 * 保险方式确认
 */
@Service(value="insuranceConfirmService")
public class InsuranceConfirmServiceImpl extends AbstractBaseServiceImpl implements InsuranceConfirmService {

	@Resource
    private BaseDao baseDao;
	
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}

	@Override
	public void updateInsurance(Map<String, String> model) throws Exception {
		String [] ids = model.get("ids").split(",");
		Map<String, Object> params = new HashMap<String, Object>();
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		//保险类型数据字典
		DictionaryData Intype=this.baseDao.findEntityByID(DictionaryData.class,model.get("insurerType"));
		
		for(String ciid : ids){
			ContractInfo ci = baseDao.findEntityByID(ContractInfo.class, ciid);
			params.put("contractId.id",ciid);
			List<ContractInsuranceSureInfo> cisis = baseDao.findEntityByProperties(ContractInsuranceSureInfo.class, params);
			if(cisis != null && cisis.size() > 0){
				for(ContractInsuranceSureInfo cisi : cisis){
					if(cisi.getIsSure() == 0){
						cisi.setIsSure(1);
						cisi.setSureUser(user);
						cisi.setSureDate(createDate);
						cisi.setModificator(user);
						cisi.setModifyDate(createDate);
						baseDao.updateEntity(cisi);
					}
				}
			} else {
				ContractInsuranceSureInfo cisi = new ContractInsuranceSureInfo();
				cisi.setContractId(ci);
				cisi.setIsSure(1);
				cisi.setSureUser(user);
				cisi.setSureDate(createDate);
				cisi.setCreator(user);
				cisi.setCreateDate(createDate);
				baseDao.saveEntity(cisi);
			}
			//保存保险方式
			Map<String, Object> propertiesMap = new HashMap<String, Object>();
			propertiesMap.put("contractId", ci);
			List<ContractCondition> cc=this.baseDao.findEntityByProperties(ContractCondition.class, propertiesMap);
			if(cc.size()>0){
				ContractCondition ccon=cc.get(0);
				ccon.setInsurerType(Intype);
				baseDao.saveEntity(ccon);
			}
		}
	}
	

	@Override
	public void updateModifyInsurance(Map<String, String> model)
			throws Exception {
		String [] ids = model.get("ids").split(",");
		Map<String, Object> params = new HashMap<String, Object>();
		User user = (User) SecurityUtil.getPrincipal();
		String createDate = DateUtil.getSystemDateTime();
		//保险类型数据字典
		DictionaryData Intype=this.baseDao.findEntityByID(DictionaryData.class,model.get("insurerType"));
		for(String ciid : ids){
			ContractInfo ci = baseDao.findEntityByID(ContractInfo.class, ciid);
			params.put("contractId.id",ciid);
			//保存保险方式
			Map<String, Object> propertiesMap = new HashMap<String, Object>();
			propertiesMap.put("contractId", ci);
			List<ContractCondition> cc=this.baseDao.findEntityByProperties(ContractCondition.class, propertiesMap);
			if(cc.size()>0){
				ContractCondition ccon=cc.get(0);
				ccon.setInsurerType(Intype);
				baseDao.saveEntity(ccon);
			}
		}
		
		
	}

	@Override
	public <T> T copyAndOverrideExistedValueFromJSONObject(JSONObject jsonObj,
			T targetObject, Map<String, String> classFieldMapping,
			String... entityIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T copyAndOverrideExistedValueFromMap(
			Map<String, ? extends Object> sourceMapModel, T targetObject)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T copyAndOverrideExistedValueFromStringMap(
			Map<String, String> sourceMapModel, T targetObject,
			Map<String, String> classFieldMapping, String... entityIdentifier)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T copyAndOverrideExistedValueFromStringMap(
			Map<String, String> sourceMapModel, T targetObject,
			Map<String, String> classFieldMapping, boolean withUserInfo,
			String... entityIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> findEntityByProperties(Class<T> entityClass,
			Map<String, Object> propertiesMap) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> findEntityByPropertiesPage(Class<T> entityClass,
			Map<String, Object> propertiesMap, int start, int limit)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> JSONArray getCollectionEntitiesPropertiesToJsonArray(
			Collection<T> entities, Map<String, String> fieldClassMapping,
			String... entityIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> String getCollectionEntitiesPropertiesToJsonArrayString(
			Collection<T> entities, Map<String, String> fieldClassMapping,
			String... entityIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> String getCollectionEntitiesPropertiesToJsonArrayStringWithOtherEntityFields(
			Collection<T> entities, Map<String, String> fieldClassMapping,
			Map<String, String> otherEntityFieldsMapping,
			String... entityIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> JSONArray getCollectionEntitiesPropertiesToJsonArrayWithOtherEntityFields(
			Collection<T> entities, Map<String, String> fieldClassMapping,
			Map<String, String> otherEntityFieldsMapping,
			String... entityIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Collection<T> getEntitiesByJSONArrayString(
			Class<T> saveEntityClass, String jsonArrayString,
			Map<String, String> classFieldMapping, String... entityIdentifier)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Integer getEntityByPropertiesRowCount(Class<T> entityClass,
			Map<String, Object> propertiesMap) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> JSONObject getEntityPropertiesToJsonEntity(T entity,
			Map<String, String> fieldClassMapping, String... entityIdentifier)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> JSONObject getEntityPropertiesToJsonEntityWithOtherEntityFields(
			T entity, Map<String, String> fieldClassMapping,
			Map<String, String> otherEntityFieldsMapping,
			String... entityIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Map<String, String> getEntityPropertiesToStringMap(T entity,
			Map<String, String> fieldClassMapping, String... entityIdentifier)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Map<String, String> getEntityPropertiesToStringMapWithOtherEntityFields(
			T entity, Map<String, String> fieldClassMapping,
			Map<String, String> otherEntityFieldsMapping,
			String... entityIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getNewOrUpdateObject(Class<T> clazz,
			Map<String, Object> propertiesMap) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Collection<T> saveOrUpdateEntitiesByJSONArrayString(
			Class<T> saveEntityClass, String jsonArrayString,
			Map<String, String> classFieldMapping, String... entityIdentifier)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T updateMainEntity(Class<T> mainObjectClass,
			Map<String, Object> propertiesMap, Map sourceMapModel,
			Map<String, String> classFieldMapping, String... entityIdentifier)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, V> Collection<V> updateOneToManyCollections(T OneToManyObj,
			String OneToManyFieldName, Class<V> ManyToOneObjClass,
			String ManyToOneFieldName, String jsonArrayStr,
			Map<String, String> classFieldMapping, String... entityIdentifier)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, V> Collection<V> updateOneToManyCollectionsNoRemoved(
			T OneToManyObj, String OneToManyFieldName,
			Class<V> ManyToOneObjClass, String ManyToOneFieldName,
			String jsonArrayStr, Map<String, String> classFieldMapping,
			String... entityIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, V> V updateOneToOneEntity(T mainObject,
			String toUpdatedObjectFieldName, String toMainObjectFieldName,
			Map sourceMapModel, Map<String, String> classFieldMapping,
			String... entityIdentifier) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
