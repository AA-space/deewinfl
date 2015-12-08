package com.business.service.vouchersFactory;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.contract.ContractInfo;
import com.business.service.BaseService;

/**
 * 客户资金收款凭证
 * @author Jason
 * @date 2013-11-20
 * @info 
 */
public interface DealerFundCollectionService{
	public void createVoucher(ContractInfo cinfo,BigDecimal sum) throws Exception;
	public void createVoucherNominalPrice(ContractInfo cinfo,BigDecimal sum) throws Exception;
}
