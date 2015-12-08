package com.business.service.tx;

import java.util.Map;


import com.business.service.reckon.ConditionDataToHisService;

public interface AjustInterestService {
	/*
	 * # 调息开始
	 * 1.将央行调息记录临时表表的数据copy到央行调息记录正式表
	 * 2.将租金计划临时表copy到租金计划历史表
	 * 3.将现金流临时表copy到现金流历史表
	 * 4.将交易结构临时表copy到交易就够历史表
	 */
	//1.将央行调息记录临时表表的数据copy到央行调息记录正式表
	public void updateCopyFundAdjustInterestContractTempToRecord(Map<String,String> model) throws Exception;
	
	//2.将租金计划临时表copy到租金计划历史表
	public void updateCopyFundRentPlanFromTempToHis(Map<String,String> model) throws Exception;
	
	//3.将现金流临时表copy到现金流历史表
	public void updateCopyFundRentCashFromTempToHis(Map<String,String> model) throws Exception;
	
	//4.将交易结构临时表copy到交易就够历史表
	public void updateCopyConditionFromTempToHis(Map<String,String> model) throws Exception;
	
	public void updateCopyTxAllTempToHis(Map<String,String> model,ConditionDataToHisService conditionDataToHisService)throws Exception;
	
	
	//1.央行调息记录表（调息前）-->到央行调息临时表FUND_ADJUST_INTEREST_CONTRACT to FUND_ADJUST_INTEREST_C_TEMP
	public void updateCopyFundAdjustInterestContractFromHisToTemp(Map<String,String> model) throws Exception;

	//2.租金计划his表（调息前）-->租金计划temp表 
	public void updateCopyFundRentPlanFromHisToTemp(Map<String,String> model) throws Exception;
	//3.现金流his表（调息前）-->现金流temp表
	public void updateCopyFundRentCashFromHisToTemp(Map<String,String> model)throws Exception;
	
	//	4.交易结构his表（调息前）-->交易结构temp表
	public void updateCopyConditionFromHisToTemp(Map<String,String> model)throws Exception;
	
//	 * #.撤销回滚
//	 * 1.删除 央行调息临时表FUND_ADJUST_INTEREST_C_TEMP
	public void removeFundAdjustInterestCTemp(Map<String,String> model)throws Exception;
//	 * 2.删除租金计划temp表 
	public void removeFundRentPlanFromHisToTemp(Map<String,String> model)throws Exception;
//	 * 3.删除现金流temp表
	public void removeFundRentCashFromHisToTemp(Map<String,String> model)throws Exception;
//	 * 4.删除交易结构temp表
	public void removeConditionFromHisToTemp(Map<String,String> model)throws Exception;
	
	
//	 * #.回滚流程结束
//	 * 1.更新租金计划表成temp表（调息前）数据
	public void updateFundRentPlan(Map<String,String> model)throws Exception;
//	 * 2.更新现金流表成temp表（调息前）数据
	public void updateFundRentCash(Map<String,String> model)throws Exception;
//	 * 3.交易结构表成temp表（调息前）数据
	public void updateCondition(Map<String,String> model)throws Exception;
//	 * 4.更新记录状态？记录状态 ‘已回滚’
	public void updateStatusTo(Map<String,String> model)throws Exception;
	
	//将央行信息记录表 里面 调息的记录回滚
	public void updateFundAdjustInterestContract(Map<String,String> model)throws Exception;

}
