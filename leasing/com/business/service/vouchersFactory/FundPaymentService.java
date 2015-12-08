package com.business.service.vouchersFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankData;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundPayForRent;
import com.business.entity.util.OwnAccount;
import com.business.service.BaseService;

/**
 * 资金付款凭证
 * @author Rovine
 * @date 2013-12-2
 * @info 
 */
public interface FundPaymentService{
	public void createVoucherCautionMoney(ContractInfo cinfo,BigDecimal sum,OwnAccount account,String feeType) throws Exception;
	public void createVoucherEquipMoney(ContractInfo cinfo,BigDecimal sum,OwnAccount account) throws Exception;
	public void createVoucherDeduEquipMoney(List<ContractFundFundPayForRent> cflist,OwnAccount account)
			throws Exception;
}
