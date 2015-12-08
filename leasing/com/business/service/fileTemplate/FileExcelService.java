package com.business.service.fileTemplate;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.business.entity.asset.FundEbankData;
import com.business.entity.base.BaseFile;
import com.business.entity.contract.equip.gps.GPSInterfacesInfo;
import com.business.entity.contract.rent.ContractCardRentIncome;
import com.business.entity.cust.CustInfo;
import com.business.entity.invoice.vat.TaxFundUploadInfo;
import com.business.entity.invoice.vat.TaxRentUploadInfo;
import com.business.entity.invoice.vat.TaxVatUploadInfo;
import com.business.service.TableService;

/**
 * 
 * @author XU
 * @version 创建时间：2013-8-9 下午02:34:47
 */
public interface FileExcelService {
	/**
	 * 
	 * @xuyunlong 作者 E-mail:
	 * @version 创建时间：2013-10-15 下午02:35:12 类说明卡扣数据上传初始化
	 */
	
	public Object initCardHire(ContractCardRentIncome card, Map<String, String> model, Integer rowIndex) throws Exception;

	public Object initTaxVatUploadInfo(TaxVatUploadInfo taxVat, Map<String, String> model, Integer rowIndex) throws Exception;

	public Object checkFundInvoiceConfirmExp(TaxFundUploadInfo taxFui, Map<String, String> model, Integer rowIndex) throws Exception;

	public Object checkFundInvoiceEmsConfirmExp(TaxFundUploadInfo taxFui, Map<String, String> model, Integer rowIndex) throws Exception;

	public Object checkRentInvoiceConfirmExp(TaxRentUploadInfo taxRui, Map<String, String> model, Integer rowIndex) throws Exception;

	public Object checkRentInvoiceEmsConfirmExp(TaxRentUploadInfo taxRui, Map<String, String> model, Integer rowIndex) throws Exception;

	/**
	 * 
	* @author 作者 E-mail: 
	* @version 创建时间：2013-10-31 下午06:32:10 
	* 类说明 GPS导入回调
	 */
	public Object checkGPSImportConfirmExp(GPSInterfacesInfo GPS, Map<String, String> model, Integer rowIndex) throws Exception;

	/**
	 * 
	 * @author 作者 E-mail:
	 * @version 创建时间：2013-10-22 上午05:33:27 导出检查
	 */
	public Boolean loadOutExcelDataCheck(TableService tableService, Map<String, Object> model, Integer rowIndex) throws Exception;

	/**
	 * 导出资金开票收据时，回调个人业务
	 * 
	 * @param tableService
	 * @param model
	 * @param baseFile
	 * @throws Exception
	 */
	public void forReceiptInfoExportServiceCallback(TableService tableService, Map<String, Object> model, BaseFile baseFile) throws Exception;

	/**
	 * 导出数据称elx模板时，可以截取sql查询出的数据进行预处理
	 * 
	 * @param money
	 * @return
	 */
	public String convertMoneyToChinese(String money);
	/**
	 * 导入网易数据验证
	 */
	public Object checkEbankInfoDataImport(FundEbankData fed,Map<String,String> model,Integer rowIndex)throws Exception;


	Object cardHire(TableService table, Map<String, Object> map, BaseFile bfile) throws Exception;
	Object initGYS(TableService table, Map<String, Object> map, BaseFile bfile) throws Exception;

	public List cardDataCallback(List list) throws Exception;

	public Object totalCredit(TableService table, Map<String, Object> map, BaseFile bfile) throws DataAccessException, Exception;

	List totalCreditDataCallback(List list) throws Exception;
	List CautionMoneyDataCallback(List list) throws Exception;
  /**
   * 导出客户合同
   * @param table
   * @param map
   * @param bfile
   * @return
   * @throws DataAccessException
   * @throws Exception
   */
	Object customerHire(TableService table, Map<String, Object> map,
			BaseFile bfile) throws DataAccessException, Exception;

	public List deduDetailListDataCallback(List list) throws Exception;

	public List deduDetailExportDataCallback(List list) throws Exception;
}
