package com.business.serviceImpl.managerDistrict;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.base.ManagerDistrict;
import com.business.service.managerDistrict.ManagerDistrictService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
@Service(value="managerDistrict")
public class ManagerDistrictImpl  extends AbstractBaseServiceImpl  implements ManagerDistrictService {
	@Resource
    private BaseDao baseDao;
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}

	@Override
	public void addManagerDistrict(Map<String, String> model) throws Exception {
		//构建出经销商基本信息
		ManagerDistrict managerDistrict = new ManagerDistrict();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 dictDataClassMapping.put("User", "id");
		 dictDataClassMapping.put("Role", "id");
		 this.copyAndOverrideExistedValueFromStringMap(model, managerDistrict, dictDataClassMapping);
		 this.saveEntity(managerDistrict);
	}

	@Override
	public void updateManagerDistrict(Map<String, String> model) throws Exception {	 
		//构建出经销商基本信息
		 ManagerDistrict managerDistrict  = (ManagerDistrict)this.baseDao.findEntityByID(ManagerDistrict.class, model.get("id"));
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 dictDataClassMapping.put("User", "id");
		 dictDataClassMapping.put("Role", "id");
		 this.copyAndOverrideExistedValueFromStringMap(model, managerDistrict, dictDataClassMapping);
		 this.updateEntity(managerDistrict);
			
	}
	@Override
	public void removeManagerDistrict(Map<String, String> model) throws Exception {
		//构建出经销商基本信息
		 ManagerDistrict managerDistrict  = (ManagerDistrict)this.baseDao.findEntityByID(ManagerDistrict.class, model.get("id"));
	     this.removeEntity(managerDistrict);
		
	}
		
}
