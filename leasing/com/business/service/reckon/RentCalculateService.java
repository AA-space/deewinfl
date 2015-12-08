package com.business.service.reckon;

import java.util.Map;

/**
 * 
 * @author 孙传良
 * @date 2013-3-19上午11:00:32
 * @info 租金测算服务类的主接口
 * @Copyright 
 * Tenwa
 */
public interface RentCalculateService {
	/**
	 * 接收Map型的商务条件做租金计划的测算
	 * @param modelData
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> calculateRentPlan(Map<String,String> modelData)  throws Exception ;
	
	/**
	 * 为了和老的租金测算做对接写的测算入口
	 * @param modelData
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public Map<String, Object> calculateRentPlanOld(Map<String,String> modelData)  throws Exception ;
	
	
	/**
	 * 租金计划变更实现
	 * @param modelData
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public Map<String, Object> adjustCalculateOld(Map<String,String> modelData)  throws Exception ;

	/**
	 * 租金计划修改实现
	 * @param modelData
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public Map<String, Object> updateCalculateOld(Map<String,String> modelData)  throws Exception ;
	/**
	 * 重新把数据从正式表拉到临时表  仅限合同层
	 * @param contractId 合同表的主键ID
	 * @param docId
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> resetConditionData(String contractId,String docId)  throws Exception ;
}
