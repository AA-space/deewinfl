package com.business.service.vouchersFactory;   


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.business.entity.asset.FundEbankData;
import com.business.entity.contract.ContractFinstartdate;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2013-11-28 下午2:12:58
 * 类说明
 */
public interface ContractOnHireService  {
	void createVoucher(ContractInfo contractInfo, ContractFinstartdate finstartdate) throws Exception;
	void createVoucherforLeaseback(ContractInfo contractInfo, ContractFinstartdate finstartdate) throws Exception;
	
	void createVoucherFirstPay(ContractInfo contractInfo,Map<String, String> variablesMap, ContractFinstartdate finstartdate) throws Exception;
	void createVoucherOnHireRent(ContractInfo contractInfo,Map<String, String> variablesMap, ContractFinstartdate finstartdate) throws Exception;
	void createVoucherOnHireRentforLeaseback(ContractInfo contractInfo,Map<String, String> variablesMap, ContractFinstartdate finstartdate) throws Exception;
	
	/**
	 * 确认客户租金利息（上牌）
	 * @param contractFundRentPlan
	 * @param rent
	 * @param interest
	 * @throws Exception
	 */
	void createVoucherInterest(ContractFundRentPlan contractFundRentPlan,BigDecimal rent, BigDecimal interest) throws Exception;
	/**
	 * 确认客户租金利息（不上牌）
	 * @param contractFundRentPlan
	 * @param rent
	 * @param interest
	 * @throws Exception
	 */
	void createVoucherInterestNoPlate(ContractFundRentPlan contractFundRentPlan, BigDecimal rent, BigDecimal interest) throws Exception;
	/**
	 * 卡扣核销
	 * @param incomeList
	 * @throws Exception
	 */
	void cardHireVoucher(List<ContractFundRentInCome> incomeList) throws Exception;
	
	/**
	 * 补租金利息凭证
	 * @param contractFundRentPlan
	 * @param rent
	 * @param interest
	 * @throws Exception
	 */
	void createVoucherRTInterest(ContractFundRentPlan contractFundRentPlan,
			BigDecimal rent, BigDecimal interest) throws Exception;
}


