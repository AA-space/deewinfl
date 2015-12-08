package com.business.service.vouchersFactory;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankData;
import com.business.entity.contract.ContractInfo;
import com.business.service.BaseService;

/**
 * 合同变更租金利息凭证
 * @author Rovine
 * @date 2013-12-3
 * @info 
 */
public interface ContractChargeService{

	/**
	 * 调整客户租金和利息
	 * @param contractInfo 合同对象
	 * @param changeInterest 利息合计
	 * @throws Exception
	 */
	public void createVoucherInterest(ContractInfo cinfo,BigDecimal sum) throws Exception;

}
