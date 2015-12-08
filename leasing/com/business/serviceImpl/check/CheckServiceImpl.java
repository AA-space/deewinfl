/**
 * 项目名称：    系统名称
 * 包名：              com.business.serviceImpl.cust
 * 文件名：         CustServiceImpl.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-5-18-下午12:30:07
 * Copyright：2013XX公司-版权所有
 **/

package com.business.serviceImpl.check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.DictionaryData;
import com.business.entity.base.EquipModel;
import com.business.entity.contract.equip.ContractEquip;
import com.business.entity.proj.equip.ProjEquip;
import com.business.service.check.CheckServer;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.google.common.collect.Maps;


/**
 * @author Jason
 * @date 2013-5-21
 * @info 
 */
@Service(value = "checkServer")
public class CheckServiceImpl extends AbstractBaseServiceImpl implements CheckServer {
	@Resource
	private BaseDao baseDao;

	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}

	@Override
	public String checekEquipmentManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 String equipclassname = request.getParameter("equipclassname");
    	 String equiptypename =  request.getParameter("equiptypename");
    	 
    	 Map<String,Object> propertiesMap = Maps.newHashMap();
    	 
    	 DictionaryData classType  = (DictionaryData) this.baseDao.findEntityByID(DictionaryData.class, equipclassname);
    	 DictionaryData equipType  = (DictionaryData) this.baseDao.findEntityByID(DictionaryData.class, equiptypename);
    	 
    	 propertiesMap.put("equipClass", classType);
    	 propertiesMap.put("equipType", equipType);
    	 //List<Object> equipList= this.baseDao.findEntityByProperties(EquipModel.class, propertiesMap);
    	 List<EquipModel> equipList = this.baseDao.findEntityByProperties(EquipModel.class, propertiesMap);
    	 if(equipList.size() > 0){
    		 
    	 }
		
		return null;
	}

	@Override
	public String validateChassisnum(HttpServletRequest request) throws Exception {
		String chassisnum = request.getParameter("chassisnum");
		String queryParam = StringUtils.join(chassisnum.split(","), "','");
		if (chassisnum != null && !chassisnum.trim().equals("")) {
			String sql = "SELECT CHASSIS_NUM FROM contract_equip ce  LEFT JOIN contract_info ci ON ce.contract_id = ci.id  WHERE ci.contract_status < 100 AND CHASSIS_NUM IN ('" + queryParam + "')";
			Map<String, Object> propertiesMap = new HashMap<String, Object>();
			propertiesMap.put("chassisNum", chassisnum);
			List<Map<String, Object>> ContractEquips = this.baseDao.getJdbcTemplate().queryForList(sql);
			List<String> strList = new ArrayList<String>();
			if (ContractEquips.size() > 0) {
				for (int i = 0; i < ContractEquips.size(); i++) {
					strList.add((String) ContractEquips.get(i).get("CHASSIS_NUM"));
				}
				if (strList.size() > 0) {
					chassisnum = strList.toString();
				}
			} else {
				chassisnum = String.valueOf(ContractEquips.size());
			}

		} else {
			chassisnum = "0";
		}
		return chassisnum;
	}

}
