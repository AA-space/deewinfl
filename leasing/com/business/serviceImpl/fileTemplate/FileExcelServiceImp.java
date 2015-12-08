package com.business.serviceImpl.fileTemplate;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.asset.FundEbankData;
import com.business.entity.base.BaseFile;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.equip.gps.GPSInfo;
import com.business.entity.contract.equip.gps.GPSInterfacesInfo;
import com.business.entity.contract.fund.ContractFundFundPayCollect;
import com.business.entity.contract.fund.ContractFundFundPayForRent;
import com.business.entity.contract.fund.ContractFundPayCautionmoney;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.contract.rent.ContractCardRentIncome;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoAccount;
import com.business.entity.invoice.vat.TaxFundInfo;
import com.business.entity.invoice.vat.TaxFundReceiptInfo;
import com.business.entity.invoice.vat.TaxFundUploadInfo;
import com.business.entity.invoice.vat.TaxRentUploadInfo;
import com.business.entity.invoice.vat.TaxVatInfo;
import com.business.entity.invoice.vat.TaxVatUploadInfo;
import com.business.entity.util.OwnAccount;
import com.business.exception.BusinessException;
import com.business.service.TableService;
import com.business.service.fileTemplate.FileExcelService;
import com.business.service.voucher.VoucherService;
import com.business.service.vouchersFactory.EbankImportService;
import com.business.service.vouchersFactory.FundPaymentService;
import com.business.service.vouchersFactory.TaxVatUploadInfoService;
import com.business.util.WorkflowUtil;
import com.kernal.utils.BeanFieldUtil;
import com.kernal.utils.DateUtil;
import com.kernal.utils.MoneyUtil;
import com.kernal.utils.SecurityUtil;
@Service(value="fileExcelService")
public class FileExcelServiceImp implements FileExcelService {
	@Resource(name = "tableService")
	private TableService tableService;
	
	@Resource(name="ebankImportService")
	private EbankImportService ebankImportService;
	
	@Resource(name = "fundPaymentService")
	private FundPaymentService fundPaymentService;
	
	@Resource(name="taxVatUploadInfoService")
	private TaxVatUploadInfoService taxVatUploadInfoService;
	 
	@Override
	public Object initCardHire(ContractCardRentIncome card, Map<String, String> model,Integer rowIndex)throws Exception {
			ContractCardRentIncome ccri;
			try {
				ccri = (ContractCardRentIncome)card;
				String purpose=ccri.getTradePurpose();
				if(!"".equals(purpose)){
					System.out.println(purpose);
					String[]purposes=purpose.split("/");
					if(purposes.length>2){
					ContractInfo ci=new ContractInfo();
					Map<String,Object> propertiesMap=new HashMap<String, Object>();
					propertiesMap.put("contractId",purposes[0]);
					List<ContractInfo> ciList=this.tableService.findEntityByProperties(ContractInfo.class, propertiesMap);
					if(!ciList.isEmpty()){
						ci=ciList.get(0);
					}
					
					Map<String,String> queryMainObjectMap = new HashMap<String,String>();
					queryMainObjectMap.put("contract_id", purposes[0]);
					JSONArray arr=this.tableService.getJsonArrayData("eleasing/workflow/proj_approval/card_onhire_type.xml",queryMainObjectMap);
					//List list = (List)JSONArray.toCollection(jsonarray, Person.class); 

					if (arr.length()<=0){
						throw new BusinessException(purposes[0]+"合同没有导出核销");
					}
					ccri.setContractId(ci);
					ccri.setRentList(Integer.valueOf(purposes[1].toString()));
					ccri.setMoneyType(purposes[2].toString());
					//日期为卡扣核销的日期,此为上传日期
					//String dateStr = DateUtil.getSystemTimeByFormat("yyyy-MM-dd HH:mm:ss");
					
					//日期改成导出日期，根据期项和合同号，查出租金计划，根据计划查出导出的bfile，找出导出日期
					/*
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("contractId", ccri.getContractId());
					map.put("rentList", ccri.getRentList());
					
					List<ContractFundRentPlan> rentList = this.tableService.findEntityByProperties(ContractFundRentPlan.class, map);
					
					if (rentList.size() != 1) {
						throw new BusinessException("在上传卡扣结果过程中，卡扣导出的租金计划有错，查证");
					}
					
					ContractFundRentPlan contractFundRentPlan = rentList.get(0);
					String dateStr = null;
					
					BaseFile baseFile = this.tableService.findEntityByID(BaseFile.class, contractFundRentPlan.getCardExportStatus());
					if (baseFile  == null)  throw new BusinessException("请维护"+purposes[0]+"租金计划里的卡扣状态!");
					dateStr = baseFile.getCreateDate().substring(0, 10);
					*/
					
				/*	if(ccri.getIncomeDate() != null){
						Date date = DateUtil.getTimeByFormat(ccri.getIncomeDate(), "yyyyMMdd");
						dateStr = DateUtil.getDateTime(date);
					}*/
					ccri.setIncomeDate(DateUtil.getSystemDate());
					ccri.setLastMoney(ccri.getIncomeMoney());
					
//					String filenames = baseFile.getFileName();
//					filenames = filenames.substring(0, 2);
					//建行
					if (  "card_hire_bank_construction".equals(ccri.getUpLoadId().getFileFirstKey()))
					{//建行
						 String resultText = ccri.getIncomeText();
						//处理返回信息
						if(resultText != null && !resultText.trim().equals("")){
							if(resultText.trim().equals("成功") || resultText.trim().equals("处理成功")||resultText.trim().equals("交易成功")){
								ccri.setIncomeStatus(0);
							} else if(resultText.trim().equals("失败") || resultText.trim().equals("交易失败")){
								ccri.setIncomeStatus(1);
							}
						} 
					}else{//农行
						if ( ccri!=null && ccri.getIncomeMoney()!=null )//实际卡扣回笼的钱
						{
						  BigDecimal incomeMoney = ccri.getIncomeMoney();
						  if ( incomeMoney.equals(BigDecimal.ZERO) )
							  ccri.setIncomeStatus(1); //实际卡扣回笼的钱 为0
						  else
							  ccri.setIncomeStatus(0);
						}else
						{
							ccri.setIncomeStatus(1);
						}
					}
					//设置处理银行信息，来自数据字典
					ccri.setTradeBank(ccri.getUpLoadId().getFileFirstKey());
					
					
			/*		if(StringUtil.nullToString(ccri.getTradingResults())!=""){
						if(model.containsKey(ccri.getTradingResults())){
							ccri.setIncomeStatus(Integer.valueOf(model.get(ccri.getTradingResults())).intValue());
						}else{
							ccri.setIncomeStatus(0);
						}
					}else{
					   ccri.setIncomeStatus(0);
					}*/
					}else{
						throw new BusinessException("交易用途不全");
					}
				}else{
					throw new BusinessException("交易用途不能为空");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
			    e.printStackTrace();
				throw new BusinessException(e.getMessage());
			}
		 return ccri;
	}
	@Override
	public Object initTaxVatUploadInfo(TaxVatUploadInfo taxVat,Map<String,String> model,Integer rowIndex) throws Exception{
		if("认证相符".equals(taxVat.getCertificationResults()) || "认证不符".equals(taxVat.getCertificationResults())){
			System.out.println("认证结果正确");
		}else{
			throw new BusinessException("第"+rowIndex+"行认证结果不正确");
		}
		if(taxVat.getInvoiceNo() == null || "".equals(taxVat.getInvoiceNo())){
			throw new BusinessException("第"+rowIndex+"行发票号不能为空");
		}else if(taxVat.getCorpusTaxMoney() == null || "".equals(taxVat.getCorpusTaxMoney())){
			throw new BusinessException("第"+rowIndex+"行金额(含税)不能为空");
		}else if(taxVat.getTaxRate() == null || "".equals(taxVat.getTaxRate())){
			throw new BusinessException("第"+rowIndex+"行税率不能为空");
		}else if(taxVat.getTaxMoney() == null || "".equals(taxVat.getTaxMoney())){
			throw new BusinessException("第"+rowIndex+"行税额不能为空");
		}/*else if(taxVat.getCertificationDate() == null || "".equals(taxVat.getCertificationDate())){
			throw new BusinessException("第"+rowIndex+"行认证时间不能为空");
		}*/else if(taxVat.getInvoiceDate() == null || "".equals(taxVat.getInvoiceDate())){
			throw new BusinessException("第"+rowIndex+"行开票时间不能为空");
		}
		//List<ContractInfo> contractInfos = new ArrayList<ContractInfo>();
		List<TaxVatInfo> taxVatInfos = new ArrayList<TaxVatInfo>();
			Map<String, Object>	propertiesMap = new HashMap<String, Object>();
			/*contractInfos = (List<ContractInfo>) this.tableService.findEntityByProperties(ContractInfo.class, propertiesMap);
			if(contractInfos == null || contractInfos.size() == 0){
				throw new BusinessException("第"+rowIndex+"行合同编号不存在");
			}
			//TaxVatInfo 中contractId为对象
			propertiesMap.put("contractId", contractInfos.get(0));*/
			
			propertiesMap.put("invoiceNo", taxVat.getInvoiceNo());
			propertiesMap.put("invoiceStatus", 2);
			
			taxVatInfos = (List<TaxVatInfo>) this.tableService.findEntityByProperties(TaxVatInfo.class, propertiesMap);
			if(taxVatInfos == null || taxVatInfos.size() == 0){
				throw new BusinessException("第【"+rowIndex+"】行，发票号码为【"+taxVat.getInvoiceNo()+"】的合同编不存在");
			}
			ContractInfo contractInfo = taxVatInfos.get(0).getContractId();
			taxVat.setContractId(contractInfo.getId());
			BigDecimal summoney=taxVat.getCorpusTaxMoney();
		/*
		 * 认证导入生成凭证 
		 * */
		 //taxVatUploadInfoService.createVoucherGetList(taxVat);
		 taxVatUploadInfoService.createVoucherTaxVat(contractInfo, summoney);
		 /*生成凭证 结束*/
		 
		 //因不能强制每个合同进项税发票必须全部一次导入，所以不能生产调整凭证。
		 /** 调整客户车款税额尾差额 开始*/
		 
		 //if(taxVat.getTaxType() != null && taxVat.getTaxType().equals("feetype1")){
/*			   DictionaryData dict = this.tableService.findEntityByID(DictionaryData.class, "feetype10");
				
				Map<String, Object> propMap = new HashMap<String, Object>();
				propMap.put("contractId.id", taxVat.getContractId());
				propMap.put("feeType", dict);
				
				List<ContractFundFundCharge> contractFundFundCharges = this.tableService.findEntityByProperties(ContractFundFundCharge.class, propMap);
				BigDecimal originalAmount = BigDecimal.ZERO;                                                                                           //原币金额
				
				for (int i = 0; i < contractFundFundCharges.size(); i++) {
					originalAmount = originalAmount.add(contractFundFundCharges.get(i).getFactMoney());
				}
				if(originalAmount.compareTo(BigDecimal.ZERO) == 1){
					//实际税额 - (计划手续费/1.17*.17)
					originalAmount = taxVat.getTaxMoney().subtract(originalAmount.divide(new BigDecimal(1.17), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(0.17)));
				}
				
				if(originalAmount.compareTo(BigDecimal.ZERO) != 0){
					taxVatUploadInfoService.adjustAmtCharge(taxVat, originalAmount);
				}*/
			 
		 //}
		 /** 生成凭证 结束*/
		 
		 //throw new BusinessException("11111111111");
	 return taxVat;
		
	}
	
	public List taxVatUploadInfoDataCallback(List list) throws Exception{
		
		return null;
	}
	
	
	@Override
	public Object checkFundInvoiceConfirmExp(TaxFundUploadInfo taxFui,
			Map<String, String> model,Integer rowIndex) throws Exception {
		if(taxFui.getOutNo() == null || "".equals(taxFui.getOutNo())){
			throw new BusinessException("第"+rowIndex+"行编号号不能为空");
		}else if(taxFui.getInvoiceNo() == null || "".equals(taxFui.getInvoiceNo())){
			throw new BusinessException("第"+rowIndex+"行发票号不能为空");
		}else if(taxFui.getInvoiceMoney() == null || "".equals(taxFui.getInvoiceMoney())){
			throw new BusinessException("第"+rowIndex+"行发票金额不能为空");
		}else if(taxFui.getInvoiceDate() == null || "".equals(taxFui.getInvoiceDate())){
			throw new BusinessException("第"+rowIndex+"行发票时间不能为空");
		}
		
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		List<TaxFundUploadInfo> taxFundUploadInfos = new ArrayList<TaxFundUploadInfo>();
		propertiesMap.put("invoiceNo", taxFui.getInvoiceNo());
		taxFundUploadInfos = (List<TaxFundUploadInfo>)this.tableService.findEntityByProperties(TaxFundUploadInfo.class, propertiesMap);
		if(taxFundUploadInfos != null){
			if(taxFundUploadInfos.size() > 0){
				throw new BusinessException("第"+rowIndex+"行发票号不能重复上传");
			}
		}
		List<TaxFundInfo> taxFundInfos = new ArrayList<TaxFundInfo>();
		propertiesMap.clear();
		propertiesMap.put("outNo", taxFui.getOutNo());
		taxFundInfos = (List<TaxFundInfo>) this.tableService.findEntityByProperties(TaxFundInfo.class, propertiesMap);
		if(taxFundInfos == null || taxFundInfos.size() == 0){
			throw new BusinessException("第"+rowIndex+"行编号不存在");
		}
		
		/** 调整客户手续费税额尾差-开始*/
		
		//手续费调整凭证
		//调整尾差凭证由甲方财务自己生成
	/*	if(taxFui.getTaxType() != null && taxFui.getTaxType().equals("feetype1")){
		
			DictionaryData dict = this.tableService.findEntityByID(DictionaryData.class, "feetype1");
			
			Map<String, Object> propMap = new HashMap<String, Object>();
			propMap.put("contractId", taxFui.getContractId());
			propMap.put("feeType", dict);
			
			List<ContractFundFundCharge> contractFundFundCharges = this.tableService.findEntityByProperties(ContractFundFundCharge.class, propMap);
			BigDecimal originalAmount = BigDecimal.ZERO;                                                                                           //原币金额
			
			for (int i = 0; i < contractFundFundCharges.size(); i++) {
				originalAmount = originalAmount.add(contractFundFundCharges.get(i).getFactMoney());
			}
			if(originalAmount.compareTo(BigDecimal.ZERO) == 1){
				//实际税额 - (计划手续费/1.17*.17)
				originalAmount = taxFui.getTaxMoney().subtract(originalAmount.divide(new BigDecimal(1.17), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(0.17)));
			}
			
			if(originalAmount.compareTo(BigDecimal.ZERO) != 0){
				taxVatUploadInfoService.adjustFactorageCharge(taxFui, originalAmount);
			}
		}*/
		
		/** 凭证生成-结束*/
		
		
		return taxFui;
	}
	@Override
	public Object checkFundInvoiceEmsConfirmExp(TaxFundUploadInfo taxFui,
			Map<String, String> model,Integer rowIndex) throws Exception {
		String emsNo = taxFui.getEmsNo();
		String sendDate = taxFui.getSendDate();
		User user = (User) SecurityUtil.getPrincipal();
		String nowdate = DateUtil.getSystemDateTime();
		if(taxFui.getOutNo() == null || "".equals(taxFui.getOutNo())){
			throw new BusinessException("第"+rowIndex+"行编号号不能为空");
		}else if(taxFui.getInvoiceNo() == null || "".equals(taxFui.getInvoiceNo())){
			throw new BusinessException("第"+rowIndex+"行发票号不能为空");
		}else if(taxFui.getInvoiceMoney() == null || "".equals(taxFui.getInvoiceMoney())){
			throw new BusinessException("第"+rowIndex+"行发票金额不能为空");
		}else if(taxFui.getInvoiceDate() == null || "".equals(taxFui.getInvoiceDate())){
			throw new BusinessException("第"+rowIndex+"行发票时间不能为空");
		}
		
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		List<TaxFundInfo> taxFundInfos = new ArrayList<TaxFundInfo>();
		propertiesMap.put("outNo", taxFui.getOutNo());
		taxFundInfos = (List<TaxFundInfo>) this.tableService.findEntityByProperties(TaxFundInfo.class, propertiesMap);
		if(taxFundInfos == null || taxFundInfos.size() == 0){
			throw new BusinessException("第"+rowIndex+"行编号不存在");
		}
		List<TaxFundUploadInfo> taxFundUploadInfos = new ArrayList<TaxFundUploadInfo>();
		propertiesMap.clear();
		propertiesMap.put("invoiceNo", taxFui.getInvoiceNo());
		taxFundUploadInfos = (List<TaxFundUploadInfo>)this.tableService.findEntityByProperties(TaxFundUploadInfo.class, propertiesMap);
		if(taxFundUploadInfos != null){
			taxFui = taxFundUploadInfos.get(0);
			taxFui.setEmsNo(emsNo);
			taxFui.setModifyDate(nowdate);
			taxFui.setSendDate(sendDate);
			taxFui.setModificator(user);
		}
		System.out.println(taxFui.getId()+"=-=-=-=-=-==");
		return taxFui;
	}
	@Override
	public Object checkRentInvoiceConfirmExp(TaxRentUploadInfo taxRui,
			Map<String, String> model,Integer rowIndex) throws Exception { 
		if(taxRui.getInvoiceNo() == null || "".equals(taxRui.getInvoiceNo())){
			throw new BusinessException("第"+rowIndex+"行发票号不能为空");
		}else if(taxRui.getInvoiceMoney() == null || "".equals(taxRui.getInvoiceMoney())){
			throw new BusinessException("第"+rowIndex+"行发票金额不能为空");
		}else if(taxRui.getInvoiceDate() == null || "".equals(taxRui.getInvoiceMoney())){
			throw new BusinessException("第"+rowIndex+"行发票时间不能为空");
		}
		
		//** 调整客户租金立项税额尾差-开始*/
		if(taxRui.getInvoiceType() != null && taxRui.getInvoiceType().equals("租金")){
		
			Map<String, Object> propMap = new HashMap<String, Object>();
			
			ContractInfo contractInfo = this.tableService.findEntityByID(ContractInfo.class, taxRui.getContractId());
			
			propMap.put("contractId", contractInfo);
			propMap.put("rentList", taxRui.getRentList());
			
			List<ContractFundRentPlan> contractFundRentPlans = this.tableService.findEntityByProperties(ContractFundRentPlan.class, propMap);
			BigDecimal originalAmount = BigDecimal.ZERO;                                                                                           //原币金额
			ContractFundRentPlan contractFundRentPlan = null;
			if (contractFundRentPlans.size() == 1) {
				 contractFundRentPlan= contractFundRentPlans.get(0);
				 originalAmount = contractFundRentPlan.getRent();
				 //实际税额 - (计划手续费/1.17*.17)
				 originalAmount = taxRui.getTaxMoney().subtract(originalAmount.divide(new BigDecimal(1.17), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(0.17)));
				 
				 if(originalAmount.compareTo(BigDecimal.ZERO) != 0){
					 taxVatUploadInfoService.adjustRent(taxRui, originalAmount);
				 }
			}
			
		}
		
		/** 凭证生成-结束*/
		
		return taxRui;
	}
	@Override
	public Object checkRentInvoiceEmsConfirmExp(TaxRentUploadInfo taxRui,
			Map<String, String> model,Integer rowIndex) throws Exception { 
		String emsNo = taxRui.getEmsNo();
		String sendDate = taxRui.getSendDate();
		User user = (User) SecurityUtil.getPrincipal();
		String nowdate = DateUtil.getSystemDateTime();
		if(taxRui.getInvoiceNo() == null || "".equals(taxRui.getInvoiceNo())){
			throw new BusinessException("第"+rowIndex+"行发票号不能为空");
		}else if(taxRui.getInvoiceMoney() == null || "".equals(taxRui.getInvoiceMoney())){
			throw new BusinessException("第"+rowIndex+"行发票金额不能为空");
		}else if(taxRui.getInvoiceDate() == null || "".equals(taxRui.getInvoiceMoney())){
			throw new BusinessException("第"+rowIndex+"行发票时间不能为空");
		}
		Map<String,Object> propertiesMap = new HashMap<String,Object>();
		List<TaxRentUploadInfo> taxRentUploadInfos = new ArrayList<TaxRentUploadInfo>();
		propertiesMap.put("invoiceNo", taxRui.getInvoiceNo());
		taxRentUploadInfos = (List<TaxRentUploadInfo>)this.tableService.findEntityByProperties(TaxRentUploadInfo.class, propertiesMap);
		if(taxRentUploadInfos != null){
			taxRui = taxRentUploadInfos.get(0);
			taxRui.setEmsNo(emsNo);
			taxRui.setModifyDate(nowdate);
			taxRui.setSendDate(sendDate);
			taxRui.setModificator(user);
		}
		return taxRui;
	}
	@Override
	public Boolean loadOutExcelDataCheck(TableService tableService,
			Map<String, Object> model,Integer rowIndex) throws Exception {
		// TODO Auto-generated method stub
		//如果有错 throw new BusinessException("交易用途不能为空");
		System.out.println("cuitianshuai============");
		return true;
	}
	
	
	
	@Override
	public void forReceiptInfoExportServiceCallback(TableService tableService, Map<String, Object> model, BaseFile baseFile) throws Exception {
		String[] idsArray = model.get("ids").toString().replace("'", "").split(",");
		for (String id : idsArray) {
			TaxFundReceiptInfo tri = this.tableService.findEntityByID(TaxFundReceiptInfo.class, id);
			if(tri != null && tri.getInvoiceStatus() == 3){
				tri.setInvoiceStatus(4);
				this.tableService.updateEntity(tri);
			}
		}
	}
	
	@Override
	public String convertMoneyToChinese(String money){
		return MoneyUtil.amountToChinese(Double.parseDouble(money));
	}
	@Override
	public Object checkGPSImportConfirmExp(GPSInterfacesInfo GPS,
			Map<String, String> model, Integer rowIndex) throws Exception {
		//1.根据车架号 查询设备信息表（CONTRACT_EQUIP）里面的合同id 根据合同id 查询客户
		/**
		 * GPS导入的时候，添加系统客户，提示用户名称不存在，（陈谦），导入不成功，导入按车架号匹配，车架号，名称，时间，状态必填，其他不必填
		 */
		String chassisNum = GPS.getChassisNum();
		String gpsUser = GPS.getGpsUser();
		String carDate = GPS.getCarDate();
		String carStatus = GPS.getCarStatus();
        String HQL="from GPSInfo g where g.equipID.chassisNum=?";
        List<GPSInfo> gpsList=new ArrayList<GPSInfo>();
        if(chassisNum!=""){
	        gpsList=this.tableService.findResultsByHSQL(HQL,chassisNum);
	        System.out.println(gpsList.size());
	        if(null==gpsList||gpsList.size()==0){
	        	throw new BusinessException("第"+rowIndex+"行的车架号("+GPS.getChassisNum()+")没有在设备相关GPS信息中");
	        	
	        }else{
	        	if(gpsUser=="" ||"".equals(gpsUser)||gpsUser==null){
	        		throw new BusinessException("第"+rowIndex+"行的用户名不能为空");
	        	}
	        	if(carDate==""||"".equals(carDate)||carDate==null){
	        		throw new BusinessException("第"+rowIndex+"行的定位时间不能为空");
	        	}
	        	if(carStatus==""||"".equals(carStatus)||carStatus==null){
	        		throw new BusinessException("第"+rowIndex+"行的车辆状态不能为空");
	        	}
	        }
        }else{
        	throw new BusinessException("第"+rowIndex+"行的车架号不能为空");
        }
		return GPS;
	}
	//检查网银数据是否符合
	public Object checkEbankInfoDataImport(FundEbankData fed, Map<String, String> model, Integer rowIndex) throws Exception {
		if (fed.getSn() == null || "".equals(fed.getSn())) {
			throw new BusinessException("第" + rowIndex + "行流水号不能为空");
		} else if (fed.getFactMoney() == null || "".equals(fed.getFactMoney())) {
			throw new BusinessException("第" + rowIndex + "行到账金额不能为空");
		} else if (fed.getFactDate() == null || "".equals(fed.getFactDate())) {
			throw new BusinessException("第" + rowIndex + "行到账时间不能为空");
		} else if (fed.getOwnAccNumber() == null || "".equals(fed.getOwnAccNumber())) {
			throw new BusinessException("第" + rowIndex + "行本方账号不能为空");
		} else if (fed.getEnabled() == null) {
			fed.setEnabled(11);
			fed.setInuseflag("0");
		}
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		List<CustInfoAccount> custInfoAccounts = new ArrayList<CustInfoAccount>();
		List<FundEbankData> feds = new ArrayList<FundEbankData>();
		if (fed.getClientAccNumber() != null && !"".equals(fed.getClientAccNumber())) {
			String acc =fed.getClientAccNumber().trim();
			propertiesMap.put("accNumber", acc);
			System.out.println(acc+"#######################################");
			custInfoAccounts = (List) this.tableService.findEntityByProperties(CustInfoAccount.class, propertiesMap);
			
			System.out.println("#######################################");
			System.out.println("=网银账号:-=-=-=-=-=" + fed.getClientAccNumber()+"###");
			System.out.println("#######################################");
			if(custInfoAccounts.size() > 0){
				CustInfo custInfo = custInfoAccounts.get(0).getCustId();
				fed.setCustId(custInfo);
				System.out.println("网银匹配经销商:-=-=-=-=" + custInfo.getCustName());
			} 
		} /*else if(fed.getEnabled() != null) {
			fed.setEnabled(1);
		}*/
		propertiesMap.clear();
		propertiesMap.put("accNumber", fed.getOwnAccNumber());
		
		
		try {
			OwnAccount  ownAccount = this.tableService.findEntityByProperties(OwnAccount.class, propertiesMap).get(0);
			fed.setOwnAccount(ownAccount.getAccName());
			fed.setOwnBank(ownAccount.getAccBank());
		} catch (Exception e) {
			throw new BusinessException("请维护本方账号！");
		}
		propertiesMap.clear();
		propertiesMap.put("sn", fed.getSn());
		feds = (List<FundEbankData>) this.tableService.findEntityByProperties(FundEbankData.class, propertiesMap);
		if (feds != null && feds.size() > 0) {
			throw new BusinessException("第" + rowIndex + "行流水号不能重复上传");
		}
		String EbankNo = WorkflowUtil.getEbankNoInfoSerialNumber(null, tableService.getBussinessDao().getHibernateTemplate(), tableService.getBussinessDao().getJdbcTemplate());
		fed.setEbdataId(EbankNo);
		
		
		/** 凭证生成-开始*/
		//导入的时候直接到网银导入待确认，所以不生成凭证
	/*	if(fed.getEnabled() == 0 && fed.getCustId() != null){
			ebankImportService.createVoucher(fed);
		}*/
		/** 凭证生成-结束*/
		
		
		return fed;
	}
	
	/* 
	 * 卡扣数据导出的回调
	 * @see com.business.service.fileTemplate.FileExcelService#cardHire(com.business.service.TableService, java.util.Map, com.business.entity.base.BaseFile)
	 */
	@Override
	public Object cardHire(TableService table, Map<String,Object> map, BaseFile bfile) throws DataAccessException, Exception {
		List list = null;//(List) map.get("cardInfos");
		Iterator itMap = map.keySet().iterator();
		String key = null;
		while (itMap.hasNext()) {
			key = (String) itMap.next();
		}
		if(key != null){
			list = (List) map.get(key);
		}
		
		if(list == null || list.size() == 0){
			throw new BusinessException("当前银行模式下数据为空,不在生成文件.");
		}
		
		//建行，农行分别查询
		String templateName = null;
		if (bfile.getTemplateName() !=null) {
			if (bfile.getTemplateName().equals("建行卡扣下载")) {
				templateName = "card_hire_bank_construction";
			} else if(bfile.getTemplateName().equals("农行卡扣下载")){
				templateName = "card_hire_bank_agricultural";
			}
		}
		//查询是否有导出状态小于等于2的
		DetachedCriteria criteria = DetachedCriteria.forClass(BaseFile.class);
		DictionaryData cardupload = this.tableService.findEntityByID(DictionaryData.class, "cardupload");
		criteria.add(Restrictions.le("exportNumber", 1));
		criteria.add(Restrictions.eq("modelName", cardupload));
		if (templateName != null) {
			criteria.add(Restrictions.eq("fileFirstKey", templateName));
		}
		
		
		List<BaseFile> baseFileList = this.tableService.getBussinessDao().getHibernateTemplate().findByCriteria(criteria);
		if(baseFileList.size() > 0){
			throw new BusinessException("当前还有未完成的卡扣,请查证后再导出");
		}
		
		
		//改文件名
		if(bfile.getFileName() != null){
			String fileName = bfile.getFileName();
			String prefix = fileName.substring(0, fileName.lastIndexOf("."));; 
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			SimpleDateFormat currentDateFormate = new SimpleDateFormat("yyyyMMddHHmmss");
			String currentDateTime = currentDateFormate.format(new Date());
			bfile.setFileName(prefix + currentDateTime + suffix);
			this.tableService.saveOrUpdateEntity(bfile);
		}
		
		Iterator it = list.iterator();
		Set<Map<String,String>> setMap = new HashSet<Map<String,String>>();
		while (it.hasNext()) {
			ArrayList<String> object = (ArrayList) it.next();
			int remarkIndex = 0;
			
			for (int i = 0; i < object.size(); i++) {
				if(object.get(i) != null && (object.get(i).contains("租金/租金代扣") || object.get(i).contains("罚息/租金代扣"))){
					remarkIndex = i;
					break;
				}
			}
			
			
			String objectStr = object.get(remarkIndex);
			String[] contractAndrent = objectStr.split("/");
		
			Map<String,String> keyMap = new HashMap<String, String>();
			
			keyMap.put("contract", contractAndrent[0]);
			keyMap.put("rentlist", contractAndrent[1]);
			
			//去除重复添加合同 和租金计划期限
			setMap.add(keyMap);
			//throw new BusinessException("1");
			
		}
		
		//final String id = bfile.getId();
		
		final List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
		listMap.addAll(setMap);
		 
		//卡扣的流程实例为下载的文件的id
		final String workFlowInstance = bfile.getId();
		
		String sql = "UPDATE CONTRACT_FUND_RENT_PLAN T SET CARD_EXPORT_STATUS = ? WHERE T.CONTRACT_ID = (SELECT ID FROM CONTRACT_INFO WHERE CONTRACT_ID = ?) AND T.RENT_LIST = ?";
		
		tableService.getBussinessDao().getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, workFlowInstance);
				ps.setString(2, listMap.get(i).get("contract"));
				ps.setInt(3, Integer.parseInt(listMap.get(i).get("rentlist")));
			}
			@Override
			public int getBatchSize() {
				return listMap.size();
			}
		});

		//将当前期项加入到流程冲突表
		Set<String> cardHireWorkFlagSet = new HashSet<String>();
		for (int i = 0; i < listMap.size(); i++) {
			cardHireWorkFlagSet.add(listMap.get(i).get("contract"));
		}
		
		final List<String> cardHireWorkFlagList = new ArrayList<String>();
		cardHireWorkFlagList.addAll(cardHireWorkFlagSet);
		String workFlowFlagSql = "INSERT INTO T_WORK_FLOW_FLAG (ID, WORK_FLOW_INSTANCE, WORK_FLOW_NAME, WORK_NUMBER, BEGIN_USER, STATUS) VALUES(SYS_GUID(), ?, ?, ?, ?, ?)";
		
		tableService.getBussinessDao().getJdbcTemplate().batchUpdate(workFlowFlagSql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, workFlowInstance);
				ps.setString(2, "租金批量核销(卡扣)");
				ps.setString(3, cardHireWorkFlagList.get(i));
				ps.setString(4, SecurityUtil.getPrincipal().getId());
				ps.setInt(5, 1);
				//System.out.println("卡扣流程冲突id = " +cardHireWorkFlagList.get(i));
			}

			@Override
			public int getBatchSize() {
				return cardHireWorkFlagList.size();
			}
		});
		
		//throw new BusinessException("123");
		return null;
	}
	
	public JSONObject taxUpload(JSONObject jsonObject) throws Exception{
		
		//将税率从%17 转成 0.17
		String taxRate =  jsonObject.optString("taxRate");
		if (StringUtils.isNotBlank(taxRate) && StringUtils.contains(taxRate, "%")) {
			taxRate = taxRate.replace("%", "");
			jsonObject.remove("taxRate");
		}
		Double taxRateValue = Double.valueOf(taxRate) /100; 
		jsonObject.put("taxRate", Double.valueOf(taxRateValue));
		System.out.println(taxRateValue);
		return jsonObject;
	}
	
	
	/**
	 * excelsql数据的回调
	 * @param row
	 * @return
	 */
	@Override
	public List cardDataCallback(List list) throws Exception{
		System.out.println(list);	
		List tempList = new ArrayList();
		
		//超过50000拆分
		for (int i = 0; i < list.size(); i++) {
			Map<String,Object> row = (Map<String, Object>) list.get(i);
			BigDecimal rent = (BigDecimal) row.get("OVRENT");
			BigDecimal leavelRent = BigDecimal.valueOf(50000);
			
			if (rent.compareTo(leavelRent) == 1) {
				Map map = new LinkedCaseInsensitiveMap();
				map = BeanFieldUtil.deepCopyMap(row);
				map.put("OVRENT", leavelRent);
				int floor = rent.divide(leavelRent, 0, BigDecimal.ROUND_FLOOR).intValue();
				for (int j = 0; j < floor; j++) {
					tempList.add(map);
				}
				
				Map map2 = new LinkedCaseInsensitiveMap();
				map2 = BeanFieldUtil.deepCopyMap(row);
				BigDecimal residueRent = rent.subtract(leavelRent.multiply(BigDecimal.valueOf(floor)));
				if(residueRent.compareTo(BigDecimal.ZERO)==1){
				   map2.put("OVRENT", residueRent);
				   tempList.add(map2);
				}
				
			} else {
				tempList.add(list.get(i));
			}
			
			
		}
		list = tempList;
		System.out.println(list);
		return list;
	}
	/*
	 * 放款单导出回调
	 *  (non-Javadoc)
	 * @see com.business.service.fileTemplate.FileExcelService#totalCreditDataCallback(java.util.List)
	 */
	@Override
	public List totalCreditDataCallback(List list) throws Exception{
		
		for (int i = 0; i < list.size(); i++) {
			Map<String,Object> row = (Map<String, Object>) list.get(i);
			if (row.get("ID") != null) {
				ContractFundFundPayCollect entity = this.tableService.findEntityByID(ContractFundFundPayCollect.class, row.get("ID").toString());
				entity.setExportFlag(1);
				this.tableService.updateEntity(entity);
				
			}
		}
		
		return list;
	}
	
	/*
	 * 抵扣明细导出回调
	 *  (non-Javadoc)
	 * @see com.business.service.fileTemplate.FileExcelService#totalCreditDataCallback(java.util.List)
	 */
	@Override
	public List deduDetailListDataCallback(List list) throws Exception{
		
		for (int i = 0; i < list.size(); i++) {
			Map<String,Object> row = (Map<String, Object>) list.get(i);
			if (row.get("ID") != null) {
				ContractFundFundPayForRent entity = this.tableService.findEntityByID(ContractFundFundPayForRent.class, row.get("ID").toString());
				entity.setInvalid("已导出");
				this.tableService.updateEntity(entity);
				
			}
		}
		
		return list;
	}
	
	/*
	 * 放款单导出回调
	 *  (non-Javadoc)
	 * @see com.business.service.fileTemplate.FileExcelService#totalCreditDataCallback(java.util.List)
	 */
	@Override
	public List deduDetailExportDataCallback(List list) throws Exception{
		List<ContractFundFundPayForRent> cflist=new ArrayList<ContractFundFundPayForRent>();
		OwnAccount account=null;
		for (int i = 0; i < list.size(); i++) {
			Map<String,Object> row = (Map<String, Object>) list.get(i);
			if (row.get("ID") != null) {
				ContractFundFundPayForRent entity = this.tableService.findEntityByID(ContractFundFundPayForRent.class, row.get("ID").toString());
				entity.setInvalid("已放款");
				cflist.add(entity);
			}
			//获取放款的本方银行
			if(account==null&&row.get("ACCOUNTID") != null){
				account=this.tableService.findEntityByID(OwnAccount.class, row.get("ACCOUNTID").toString());
			}
		}
		this.tableService.saveOrUpdateAllEntities(cflist);
		this.fundPaymentService.createVoucherDeduEquipMoney(cflist,account);
		return list;
	}
	
	/*
	 * 保证金支付导出回调
	 *  (non-Javadoc)
	 * @see com.business.service.fileTemplate.FileExcelService#totalCreditDataCallback(java.util.List)
	 */
	@Override
	public List CautionMoneyDataCallback(List list) throws Exception{
		
		for (int i = 0; i < list.size(); i++) {
			Map<String,Object> row = (Map<String, Object>) list.get(i);
			if (row.get("ID") != null) {
				ContractFundPayCautionmoney entity = this.tableService.findEntityByID(ContractFundPayCautionmoney.class, row.get("ID").toString());
				entity.setExportFlag(1);
				this.tableService.updateEntity(entity);
				
			}
		}
		
		return list;
	}
	/* 
	 * 导出客户合同
	 * @see com.business.service.fileTemplate.FileExcelService#cardHire(com.business.service.TableService, java.util.Map, com.business.entity.base.BaseFile)
	 */
	@Override
	public Object customerHire(TableService table, Map<String,Object> map, BaseFile bfile) throws DataAccessException, Exception {
		 List list = null;//(List) map.get("cardInfos");
		Iterator itMap = map.keySet().iterator();
		String key = null;
		while (itMap.hasNext()) {
			key = (String) itMap.next();
			//System.out.println(key+"%%%%%%%%%%");
		}
		if(key != null){
			list = (List) map.get(key);
		}
		
		if(list == null || list.size() == 0){
			throw new BusinessException("当前客户新生成的合同模式下数据为空,不在生成文件.");
		}
		
		//改文件名
				if(bfile.getFileName() != null){
					String fileName = bfile.getFileName();
					String prefix = fileName.substring(0, fileName.lastIndexOf("."));; 
					String suffix = fileName.substring(fileName.lastIndexOf("."));
					SimpleDateFormat currentDateFormate = new SimpleDateFormat("yyyyMMddHHmmss");
					String currentDateTime = currentDateFormate.format(new Date());
					bfile.setFileName(prefix + "000"+currentDateTime + suffix);
				}
		Iterator iterator=list.iterator();
		Set<Map<String,String>> mapset=new HashSet<Map<String,String>>();
		while(iterator.hasNext()){
			ArrayList<String> arraylist=(ArrayList<String>)iterator.next();
			/*int flagint=0;
			for(int i=0;i<arraylist.size();i++){
				System.out.println(i+"&&&&&&&&&&&&&&&&&&&&&");
				if(arraylist.get(i)!=null&&arraylist.get(i).contains("/客户编号")){
					flagint=i;
					break;
				}
			}
			String[] str=arraylist.get(flagint).split("/");*/
			
			Map<String,String> mapvalue=new HashMap<String,String>();
			//System.out.println(str[0]+"======");
			mapvalue.put("custid",arraylist.get(0));
			mapset.add(mapvalue);
		}
		final List<Map<String,String>> listMap = new ArrayList<Map<String,String>>();
		listMap.addAll(mapset);
		//客户导出下载的文件的id
		final String workFlowInstance = bfile.getId();
		//System.out.println("workFlowInstance:"+workFlowInstance+"&&&&");
//String sql = "update proj_info proj set proj.proj_export_status=? where proj.id=?";
		String sql ="update cust_info  set cust_export_status= ? where id in "
				+" (select cust.id from  contract_info contract left join cust_info cust " 
				+" on contract.cust_id=cust.id where (cust.cust_export_status='0' or cust.cust_export_status is null) " 
				 +"  and contract.contract_status>=21 and cust.cust_number=?)";
		tableService.getBussinessDao().getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, workFlowInstance);
				ps.setString(2, listMap.get(i).get("custid"));
				//System.out.println(workFlowInstance+"&&&&&&&&&&&&&"+listMap.get(i).get("custid"));
			}
			@Override
			public int getBatchSize() {
				return listMap.size();
			}
		});

		return null;
	}
	
	/* 
	 * 卡扣数据导出的回调
	 * @see com.business.service.fileTemplate.FileExcelService#cardHire(com.business.service.TableService, java.util.Map, com.business.entity.base.BaseFile)
	 */
	@Override
	public Object totalCredit(TableService table, Map<String,Object> map, BaseFile bfile) throws DataAccessException, Exception {
		List list = null;//(List) map.get("cardInfos");
		Iterator itMap = map.keySet().iterator();
		String key = null;
		while (itMap.hasNext()) {
			key = (String) itMap.next();
		}
		if(key != null){
			list = (List) map.get(key);
		}
		
		if(list == null || list.size() == 0){
			throw new BusinessException("当前银行模式下数据为空,不在生成文件.");
		}
		
		//改文件名
		if(bfile.getFileName() != null){
			String fileName = bfile.getFileName();
			String prefix = fileName.substring(0, fileName.lastIndexOf("."));; 
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			SimpleDateFormat currentDateFormate = new SimpleDateFormat("yyyyMMddHHmmss");
			String currentDateTime = currentDateFormate.format(new Date());
			bfile.setFileName(prefix + currentDateTime + suffix);
		}
		return null;
	}
	@Override
	public Object initGYS(TableService table, Map<String, Object> map,
			BaseFile bfile) throws Exception {
		 List list = null; 
		Iterator itMap = map.keySet().iterator();
		String key = null;
		while (itMap.hasNext()) {
			key = (String) itMap.next();
		}
		if(key != null){
			list = (List) map.get(key);
		}
		if(list == null || list.size() == 0){
			throw new BusinessException("当前客户新生成的合同模式下数据为空,不在生成文件.");
		}
		Iterator iterator=list.iterator();
		Set<Map<String,String>> mapset=new HashSet<Map<String,String>>();
		String sql ="update cust_info set cust_export_status= ? where cust_number =?";
		while(iterator.hasNext()){
			ArrayList<String> arraylist=(ArrayList<String>)iterator.next();
			if ( arraylist.size() > 0 && bfile != null )
			{
				tableService.updateBySql(sql,bfile.getId(),arraylist.get(0));
			}
		}

		return "当前导出未标记状态,请与管理员联系!";
	}
	
	
}
