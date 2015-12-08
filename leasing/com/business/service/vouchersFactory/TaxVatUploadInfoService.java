package com.business.service.vouchersFactory;

import java.math.BigDecimal;

import com.business.entity.contract.ContractInfo;
import com.business.entity.invoice.vat.TaxFundUploadInfo;
import com.business.entity.invoice.vat.TaxRentUploadInfo;
import com.business.entity.invoice.vat.TaxVatUploadInfo;

/**
 * 合同中途终止凭证
 * @author Rovine
 * @date 2013-12-5
 * @info 
 */
public interface TaxVatUploadInfoService{
	public void createVoucherTaxVat(ContractInfo cinfo,BigDecimal sum) throws Exception;
	/**
	 * 手续费调整凭证
	 * @param originalAmount 
	 * @throws Exception
	 */
	public void adjustFactorageCharge(TaxFundUploadInfo taxFundUploadInfo, BigDecimal originalAmount) throws Exception;
	/**
	 * 调整客户车款税额尾差
	 * @param taxVat
	 * @param originalAmount
	 * @throws Exception 
	 */
	public void adjustAmtCharge(TaxVatUploadInfo taxVat, BigDecimal originalAmount) throws Exception;
	/**
	 * 调整月租金尾差
	 * @param taxRui
	 * @param originalAmount
	 * @throws Exception
	 */
	public void adjustRent(TaxRentUploadInfo taxRui, BigDecimal originalAmount) throws Exception;
}
