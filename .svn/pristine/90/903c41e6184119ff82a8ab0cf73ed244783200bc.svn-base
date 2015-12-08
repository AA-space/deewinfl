package com.business.serviceImpl.dealer;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.entity.DictionaryData;
import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.CustInfoDealer;
import com.business.service.dealer.DistributorService;
import com.business.serviceImpl.AbstractBaseServiceImpl;
import com.business.util.WorkflowUtil;

/**
 * 
 * @author yixiaohui
 * 类名称：     CustServiceImpl
 * 
 */

@Service(value="distributorService")
public class DistributorServiceImpl extends AbstractBaseServiceImpl implements DistributorService{

	@Resource
    private BaseDao baseDao;
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}

	@Override
	public void addDistributor(Map<String, String> model) throws Exception {
		//构建出经销商基本信息
		 CustInfoDealer custInfoDealer = new CustInfoDealer();
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 this.copyAndOverrideExistedValueFromStringMap(model, custInfoDealer, dictDataClassMapping);
		 //构建客户基本信息主表
		 CustInfo info=new CustInfo();
		 String custNumber=WorkflowUtil.getDealerInfoSerialNumber(model,this.getBussinessDao().getHibernateTemplate(), this.getBussinessDao().getJdbcTemplate());
		 info.setCustNumber(custNumber);
		 info.setCustName(model.get("custname"));
		 info.setDraft(model.get("draft"));
		 info.setInvalid(model.get("invalid"));
		 DictionaryData dict=new DictionaryData();
		 Map<String, Object> whereMap=new HashMap<String, Object>();
		 whereMap.put("code", "CUST_INFO_DEALER");
		 dict=(DictionaryData)this.findEntityByProperties(DictionaryData.class, whereMap).get(0);
		 info.setCustClass(dict);
		 this.saveEntity(info);//先保存客户基本信息表
		 //custInfoDealer.setContractNum(custNumber);经销商合作编号不默认值
		 //保存信息到经销商
		 custInfoDealer.setCustId(info);
		 //custInfoDealer.setDealerCode(WorkflowUtil.getDealerInfoSerialNumber(model,this.getHibernateTemplate(), this.getJdbcTemplate()));
		 this.saveEntity(custInfoDealer);
	}

	@Override
	public void updateDistributor(Map<String, String> model) throws Exception {	 
		//构建出经销商基本信息
		CustInfoDealer custInfodealer = (CustInfoDealer)this.baseDao.findEntityByID(CustInfoDealer.class, model.get("id"));
		 Map<String,String> dictDataClassMapping = new HashMap<String,String>();
		 dictDataClassMapping.put("DictionaryData", "code");
		 this.copyAndOverrideExistedValueFromStringMap(model, custInfodealer, dictDataClassMapping);
		 //构建客户基本信息主表
		 CustInfo info=custInfodealer.getCustId();
		 info.setDraft(model.get("draft"));
		 info.setInvalid(model.get("invalid"));
		 info.setCustName(model.get("custname"));
		 this.updateEntity(info);//先保存客户基本信息表
		 //保存信息到经销商
		 custInfodealer.setCustId(info);
		 this.updateEntity(custInfodealer);
			
	}
	
		 

	@Override
	public void removeDistributor(Map<String, String> model) throws Exception {
		//构建出经销商基本信息
		CustInfoDealer custinfodealer = (CustInfoDealer)this.baseDao.findEntityByID(CustInfoDealer.class, model.get("id"));
		CustInfo info=custinfodealer.getCustId();
		info.setInvalid("0");
		this.updateEntity(info);
		
	}
		
		
	}

