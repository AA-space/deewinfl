package com.business.service.convert;

import java.util.Map;

import com.business.entity.contract.reckon.condition.ContractCondition;
import com.business.entity.contract.reckon.condition.ContractConditionTemp;
import com.business.model.ConditionBean;


public interface ConvertMapToBeanService {
	/**
	 * 把传入参数的map对象转化成实体bean数据
	 * @param conditionBean
	 * @param modelData
	 * @return
	 * @throws Exception
	 */
	public ConditionBean convertContionBean(ConditionBean conditionBean,Map<String,String> modelData)  throws Exception;
	/**
	 * 把传入参数的map对象转化成实体bean数据
	 * <BR>重构的此处传入的是老的租金测算中的商务条件实体bean用于和老的实体类做对接
	 * @param conditionBean
	 * @param modelData
	 * @return
	 * @throws Exception
	 */
	public com.tenwa.leasing.bean.ConditionBean convertContionBean(com.tenwa.leasing.bean.ConditionBean conditionBean,Map<String,String> modelData)  throws Exception;
	
	public ContractCondition convertContionBean(ContractCondition conditionBean,Map<String,String> modelData)  throws Exception;
	
	/**
	 * 将condition转换为ConditionBean对象，实现在ConditionBean下作租金测算
	 * 没有的属相无法转换，按ConditionBean中默认值赋值
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public com.tenwa.leasing.bean.ConditionBean convertContionBean(ContractConditionTemp condition)  throws Exception;
}
