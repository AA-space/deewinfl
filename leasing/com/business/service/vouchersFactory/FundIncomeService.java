package com.business.service.vouchersFactory;   

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.business.entity.JBPMWorkflowHistoryInfo;
import com.business.entity.asset.FundEbankData;
import com.business.entity.contract.ContractInfo;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2013-11-27 下午1:38:07
 * 类说明
 */
public interface FundIncomeService {
	public void createVoucher(ContractInfo cinfo,JSONObject jsonObj,FundEbankData fbd) throws Exception;
	public void createVoucherReceiveRent(ContractInfo cinfo,BigDecimal sum,FundEbankData fbd) throws Exception;
	public void createVoucherForPenalty(ContractInfo cinfo,JSONObject jsonObj,String workname) throws Exception;
	public void createVoucherForPenaltyhx(ContractInfo cinfo, JSONObject jsonObj,FundEbankData fbd) throws Exception;
	
}
  
