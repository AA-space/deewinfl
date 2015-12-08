package com.business.serviceImpl.vouchersFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.asset.FundEbankData;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.fund.ContractFundFundPayForRent;
import com.business.entity.util.OwnAccount;
import com.business.entity.voucher.InterOrgCode;
import com.business.entity.voucher.IntereasVoucherEntries;
import com.business.entity.voucher.IntereasVoucherHead;
import com.business.entity.voucher.IntereasVoucherasStacts;
import com.business.entity.voucher.VoucherassStactsConfig;
import com.business.exception.BusinessException;
import com.business.service.BaseService;
import com.business.service.voucher.VoucherService;
import com.business.service.vouchersFactory.FundCollectionService;
import com.business.service.vouchersFactory.FundPaymentService;
import com.business.util.Tools;
import com.business.util.WorkflowUtil;
import com.google.inject.internal.Lists;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

@Service(value = "fundPaymentService")
public class FundPaymentServiceImpl implements FundPaymentService {

	@Resource(name = "baseService")
	private BaseService baseService;

	@Resource(name = "voucherService")
	private VoucherService voucherService;

	/* 
	 * 付款凭证: 支付+客户+保证金
	 */
	@Override
	public void createVoucherCautionMoney(ContractInfo cinfo,BigDecimal sum,OwnAccount account, String feeType) throws Exception {
		/** 第一步:建立基本凭证体集合和公用字段字段-开始 */
		List<IntereasVoucherHead> headObjList = new ArrayList<IntereasVoucherHead>();                                                                   //凭证头集合
		List<IntereasVoucherEntries> bodyList = Lists.newArrayList();                                                                                   //凭证体集合
		String currentDate = DateUtil.getSystemDate();                                                                                                  // 当前时间
		User currentUser = SecurityUtil.getPrincipal();                                                                                                 // 当前登录人
		InterOrgCode interOrgCode = this.baseService.findEntityByID(InterOrgCode.class, "inter_orgcode_id_1");                                         //所属公司
		DictionaryData voucherType = this.baseService.findEntityByID(DictionaryData.class, "voucher_type_1");                                          //记账凭证                                                                                                              //凭证字 
		DictionaryData currencyNumber = this.baseService.findEntityByID(DictionaryData.class, "currency_type1");                                       //人民币
		Integer DR = 1;                                                                                                                                 //借
		Integer CR = -1;                                                                                                                                //贷
		/** 公用字段-结束*/

		/************************************** 分割线-以上不动 ***********************************************************/
		
		/** 本凭证-公用字段-开始*/
		String workFlowName = "付款流程"; 
		//流程名称
		/*
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("accNumber", ebankData.getOwnAccNumber());
		OwnAccount ownAccount = this.baseService.findEntityByProperties(OwnAccount.class, propertiesMap).get(0);
		String accSubject = ownAccount.getAccSubject(); */                                                                                                //网银科目
		BigDecimal originalAmount = sum;                                                                                           //原币金额
		VoucherassStactsConfig config_01 = null;    //凭证配置表:其他应付款-保证金
		DictionaryData dict = this.baseService.findEntityByID(DictionaryData.class, feeType);
		
		if (feeType.equals("feetype2")) {//保证金
			config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "228");
		}
		if (feeType.equals("feetype7")) {//保险费
			config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "227");
		}
		if (feeType.equals("feetype15")) {//GPS费用
			config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "226");
		}
		
		
		String voucherAbstract= "支付"+cinfo.getCustId().getCustName()+dict.getName();													//摘要
				
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 其他应付款-保证金-客户*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		
		
		
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(cinfo.getCustId(),null, config_01);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_01 = new IntereasVoucherEntries();
		/**
		 * 凭证体参数构建示例:
		 * 参数1：dictionaryData  币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元    currency_type2 
		 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
		 * 参数3：accountNumber 科目编码 ,已封装成对象
		 * 参数4：originalAmount 原币金额 
		 * 参数5：voucherAbstract 摘要 
		 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
		 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
		 */
		body_01.setAccountNumber(config_01);                 //这个科目
		body_01.setOriginalAmount(originalAmount);      //原币金额 
		body_01.setEntryDC(DR);                            //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 银行存款*/
		/************************************** 凭证体2-分割线-开始 ********************************************************/
//		Map<String, Object> propertiesMap = new HashMap<String, Object>();
//		propertiesMap.put("accNumber", fbd.getOwnAccNumber());
		
		OwnAccount ownAccount = account;
		String accSubject = ownAccount.getAccSubject();             
		Map<String, Object> configMap = new HashMap<String, Object>();
		configMap.put("subjectsCode", accSubject);
		
		VoucherassStactsConfig config_02 = this.baseService.findEntityByProperties(VoucherassStactsConfig.class, configMap).get(0);                          //凭证配置表
		
		//建立辅助账
		
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(cinfo.getCustId(),ownAccount, config_02);                                     //辅助账集合
        
		
		/** 1 :建立凭证体-开始 */
		IntereasVoucherEntries body_02 = new IntereasVoucherEntries();
		/**
		 * 凭证体参数构建示例:
		 * 参数1：dictionaryData  币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元    currency_type2 
		 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
		 * 参数3：accountNumber 科目编码 ,已封装成对象
		 * 参数4：originalAmount 原币金额 
		 * 参数5：voucherAbstract 摘要 
		 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
		 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
		 */
		//币别对象
		//构建凭证体1需要的参数:
		body_02.setAccountNumber(config_02);                       //这个科目对象
		body_02.setOriginalAmount(originalAmount);               //原币金额 
		body_02.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract);            //摘要
		body_02.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/** 第一步:建立凭证头 */
		/************************************** 凭证头-分割线-开始 ********************************************************/
	
		//String ebankDate = ebankData.getFactDate();
		
		/**
		 * 凭证头构建-开始
		 * 参数1：companyNumber 所属公司 取:对应UUID 或 InterOrgCode 中的 orgCode 组织机构代码 注:德银要求不做
		 * 参数2：bizDate 业务发生日期 取:如果是网银,则取网银到账日期,其他留空.待导出本系统时取当时日期, 例: 收款流程 中取网银到账日期
		 * 参数3：bookedDate 财务记账日期 取:同业务发生日期
		 * 参数4：voucherType 凭证字 取: 汉字 "记账凭证"
		 * 参数5：generateDate 凭证发生日期 取: 系统当前时间
		 * 参数6：modleName 业务模块 取:标准当前流程名称(凭证产生的模块流程名称) 例:[收款流程]
		 * 参数7：contract_number 业务合同号 取:当前实例业务合同号(存在则比填，不存在则传空) 例:[德银2013第1号]
		 * 参数8: creator 制单人 取:当前业务人员
		 * 参数9：memo1 备注 取:存在则填，不存在则传空
		 */
		
		IntereasVoucherHead headObj = new IntereasVoucherHead();
	
		headObj.setCompanyNumber(interOrgCode);             //参数1：所属公司组织机构代码
		headObj.setBizDate(currentDate);                       //业务发生日期
		headObj.setBookedDate(currentDate);                    //财务记账日期
		headObj.setVoucherType(voucherType);                 //凭证字
		headObj.setGenerate_date(currentDate);               //凭证发生日期
		headObj.setModleName(workFlowName);                  //当前流程名称
		headObj.setContract_id(cinfo);                        //业务合同号 【德银2013第1号】
		headObj.setCreator(currentUser);                      //制单人
		headObj.setIntereasVoucherEntriesInAction(bodyList);  //保存凭证体
		
		//添加到凭证头集合
		headObjList.add(headObj);
		/** 凭证头构建-结束*/
		
		/************************************** 凭证头-分割线-结束 ********************************************************/

		/************************************** 分割线-以下不动 ***********************************************************/
		
		/** 第三步:保存凭证 */
		voucherService.saveVoucherMain(headObjList);
		
	}
	
	/* 
	 * 付款凭证: 支付+客户+车款
	 */
	@Override
	public void createVoucherEquipMoney(ContractInfo cinfo,BigDecimal sum,OwnAccount account) throws Exception {
		/** 第一步:建立基本凭证体集合和公用字段字段-开始 */
		List<IntereasVoucherHead> headObjList = new ArrayList<IntereasVoucherHead>();                                                                   //凭证头集合
		List<IntereasVoucherEntries> bodyList = Lists.newArrayList();                                                                                   //凭证体集合
		String currentDate = DateUtil.getSystemDate();                                                                                                  // 当前时间
		User currentUser = SecurityUtil.getPrincipal();                                                                                                 // 当前登录人
		InterOrgCode interOrgCode = this.baseService.findEntityByID(InterOrgCode.class, "inter_orgcode_id_1");                                         //所属公司
		DictionaryData voucherType = this.baseService.findEntityByID(DictionaryData.class, "voucher_type_1");                                          //记账凭证                                                                                                              //凭证字 
		DictionaryData currencyNumber = this.baseService.findEntityByID(DictionaryData.class, "currency_type1");                                       //人民币
		Integer DR = 1;                                                                                                                                 //借
		Integer CR = -1;                                                                                                                                //贷
		/** 公用字段-结束*/

		/************************************** 分割线-以上不动 ***********************************************************/
		
		/** 本凭证-公用字段-开始*/
		//流程名称
		String workFlowName = "支付设备款"; 
		BigDecimal originalAmount = sum;                                                                                           //原币金额
		String voucherAbstract = "支付"+cinfo.getCustId().getCustName()+"车款";//摘要
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 预付账款*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		
		VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "216");   //凭证配置表:预付账款
		
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(cinfo.getCustDealer(),null, config_01);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_01 = new IntereasVoucherEntries();
		/**
		 * 凭证体参数构建示例:
		 * 参数1：dictionaryData  币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元    currency_type2 
		 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
		 * 参数3：accountNumber 科目编码 ,已封装成对象
		 * 参数4：originalAmount 原币金额 
		 * 参数5：voucherAbstract 摘要 
		 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
		 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
		 */
		body_01.setAccountNumber(config_01);                 //这个科目
		body_01.setOriginalAmount(originalAmount);      //原币金额 
		body_01.setEntryDC(DR);                            //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 银行存款*/
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		String accSubject = account.getAccSubject();             
		Map<String, Object> configMap = new HashMap<String, Object>();
		configMap.put("subjectsCode", accSubject);
		
		VoucherassStactsConfig config_02 = this.baseService.findEntityByProperties(VoucherassStactsConfig.class, configMap).get(0);                          //凭证配置表
		
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(cinfo.getCustId(),account, config_02);                                     //辅助账集合
        
		
		/** 1 :建立凭证体-开始 */
		IntereasVoucherEntries body_02 = new IntereasVoucherEntries();
		/**
		 * 凭证体参数构建示例:
		 * 参数1：dictionaryData  币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元    currency_type2 
		 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
		 * 参数3：accountNumber 科目编码 ,已封装成对象
		 * 参数4：originalAmount 原币金额 
		 * 参数5：voucherAbstract 摘要 
		 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
		 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
		 */
		//币别对象
		//构建凭证体1需要的参数:
		body_02.setAccountNumber(config_02);                       //这个科目对象
		body_02.setOriginalAmount(originalAmount);               //原币金额 
		body_02.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract);            //摘要
		body_02.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/** 第一步:建立凭证头 */
		/************************************** 凭证头-分割线-开始 ********************************************************/
	
		//String ebankDate = ebankData.getFactDate();
		
		/**
		 * 凭证头构建-开始
		 * 参数1：companyNumber 所属公司 取:对应UUID 或 InterOrgCode 中的 orgCode 组织机构代码 注:德银要求不做
		 * 参数2：bizDate 业务发生日期 取:如果是网银,则取网银到账日期,其他留空.待导出本系统时取当时日期, 例: 收款流程 中取网银到账日期
		 * 参数3：bookedDate 财务记账日期 取:同业务发生日期
		 * 参数4：voucherType 凭证字 取: 汉字 "记账凭证"
		 * 参数5：generateDate 凭证发生日期 取: 系统当前时间
		 * 参数6：modleName 业务模块 取:标准当前流程名称(凭证产生的模块流程名称) 例:[收款流程]
		 * 参数7：contract_number 业务合同号 取:当前实例业务合同号(存在则比填，不存在则传空) 例:[德银2013第1号]
		 * 参数8: creator 制单人 取:当前业务人员
		 * 参数9：memo1 备注 取:存在则填，不存在则传空
		 */
		
		IntereasVoucherHead headObj = new IntereasVoucherHead();
	
		headObj.setCompanyNumber(interOrgCode);             //参数1：所属公司组织机构代码
		headObj.setBizDate(currentDate);                       //业务发生日期
		headObj.setBookedDate(currentDate);                    //财务记账日期
		headObj.setVoucherType(voucherType);                 //凭证字
		headObj.setGenerate_date(currentDate);               //凭证发生日期
		headObj.setModleName(workFlowName);                  //当前流程名称
		headObj.setContract_id(cinfo);                        //业务合同号 【德银2013第1号】
		headObj.setCreator(currentUser);                      //制单人
		headObj.setIntereasVoucherEntriesInAction(bodyList);  //保存凭证体
		
		//添加到凭证头集合
		headObjList.add(headObj);
		/** 凭证头构建-结束*/
		
		/************************************** 凭证头-分割线-结束 ********************************************************/

		/************************************** 分割线-以下不动 ***********************************************************/
		
		/** 第三步:保存凭证 */
		voucherService.saveVoucherMain(headObjList);
		
	}
	
	/* 
	 * 付款凭证: 租金抵扣车款
	 */
	@Override
	public void createVoucherDeduEquipMoney(List<ContractFundFundPayForRent> cflist,OwnAccount account) throws Exception {
		/** 第一步:建立基本凭证体集合和公用字段字段-开始 */
		String currentDate = DateUtil.getSystemDate();                                                                                                  // 当前时间
		User currentUser = SecurityUtil.getPrincipal();                                                                                                 // 当前登录人
		InterOrgCode interOrgCode = this.baseService.findEntityByID(InterOrgCode.class, "inter_orgcode_id_1");                                         //所属公司
		DictionaryData voucherType = this.baseService.findEntityByID(DictionaryData.class, "voucher_type_1");                                          //记账凭证                                                                                                              //凭证字 
		DictionaryData currencyNumber = this.baseService.findEntityByID(DictionaryData.class, "currency_type1");                                       //人民币
		Integer DR = 1;                                                                                                                                 //借
		Integer CR = -1;                                                                                                                                //贷
		/** 公用字段-结束*/

		/************************************** 分割线-以上不动 ***********************************************************/
		for(ContractFundFundPayForRent cf:cflist){
			//有抵扣租金生成虚拟网银
			if(cf.getDeduMoney().compareTo(BigDecimal.ZERO)==1){
				FundEbankData  fd=new FundEbankData();
				//获取网银编号
				String ebdataId = WorkflowUtil.getEbankNoInfoSerialNumber(null,
						this.baseService.getBussinessDao().getHibernateTemplate(), this.baseService
						.getBussinessDao().getJdbcTemplate());
				String custname=cf.getCustId().getCustName();
				fd.setEbdataId(ebdataId);
				fd.setOwnBank(account.getAccBank());
			    fd.setOwnAccount(account.getAccName());
			    fd.setOwnAccNumber(account.getAccNumber());
			    fd.setClientName(custname);
				fd.setClientAccNumber(cf.getClientAccnumber());
				fd.setSummary(custname+"车款抵扣租金");
				fd.setCustId(cf.getCustId());
				//虚拟网银SN
				fd.setSn(ebdataId.replace("E", "XX"));
				fd.setMoneyType("电汇");
				//红冲总金额的绝对值
				fd.setFactMoney(cf.getDeduMoney());
				fd.setNoWithMoney(BigDecimal.ZERO);
				fd.setFactDate(DateUtil.getSystemDate());
				fd.setEnabled(0);
				fd.setInuseflag("0");
				fd.setCreator(SecurityUtil.getPrincipal());
				fd.setCreateDate(DateUtil.getSystemDate());
				this.baseService.saveOrUpdateEntity(fd);
			}
			/** 本凭证-公用字段-开始*/
			List<IntereasVoucherHead> headObjList = new ArrayList<IntereasVoucherHead>();                                                                   //凭证头集合
			List<IntereasVoucherEntries> bodyList = Lists.newArrayList();
			//流程名称
			String workFlowName = "租金抵扣车款"; 
			                                                                                          //原币金额
			String voucherAbstract = "支付"+cf.getAllcustname()+"车款";//摘要
			String voucherAbstract3 = "抵扣租金";//摘要
			/** 本凭证-公用字段-结束*/
			
			
			/** 第一步:建立凭证体 */
			/** 预付账款*/
			/************************************** 凭证体1-分割线-开始 ********************************************************/
			
			VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "216");   //凭证配置表:预付账款
			
			//建立辅助账
			List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(cf.getCustId(),null, config_01);                                     //辅助账集合
	
			/** 1 :建立凭证体1-开始 */
			IntereasVoucherEntries body_01 = new IntereasVoucherEntries();
			/**
			 * 凭证体参数构建示例:
			 * 参数1：dictionaryData  币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元    currency_type2 
			 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
			 * 参数3：accountNumber 科目编码 ,已封装成对象
			 * 参数4：originalAmount 原币金额 
			 * 参数5：voucherAbstract 摘要 
			 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
			 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
			 */
			body_01.setAccountNumber(config_01);                 //这个科目
			body_01.setOriginalAmount(cf.getPlanMoney());      //原币金额 
			body_01.setEntryDC(DR);                            //借贷方向 （DR(1) 借方- CR(1) 贷方）
			body_01.setVoucherAbstract(voucherAbstract);      //摘要
			body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
			body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
			
			/** 建立凭证体1-结束 */
			
			bodyList.add(body_01);
	
			/************************************** 凭证体1-分割线-结束 ********************************************************/
			
			/** 第一步:建立凭证体 */
			/** 银行存款*/
			/************************************** 凭证体2-分割线-开始 ********************************************************/
			String accSubject = account.getAccSubject();             
			Map<String, Object> configMap = new HashMap<String, Object>();
			configMap.put("subjectsCode", accSubject);
			
			VoucherassStactsConfig config_02 = this.baseService.findEntityByProperties(VoucherassStactsConfig.class, configMap).get(0);                          //凭证配置表
			
			//建立辅助账
			List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(cf.getCustId(),account, config_02);                                     //辅助账集合
	        
			
			/** 1 :建立凭证体-开始 */
			IntereasVoucherEntries body_02 = new IntereasVoucherEntries();
			/**
			 * 凭证体参数构建示例:
			 * 参数1：dictionaryData  币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元    currency_type2 
			 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
			 * 参数3：accountNumber 科目编码 ,已封装成对象
			 * 参数4：originalAmount 原币金额 
			 * 参数5：voucherAbstract 摘要 
			 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
			 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
			 */
			//币别对象
			//构建凭证体1需要的参数:
			BigDecimal lastmoney=cf.getPlanMoney().subtract(cf.getDeduMoney()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
			body_02.setAccountNumber(config_02);                       //这个科目对象
			body_02.setOriginalAmount(lastmoney);               //原币金额 
			body_02.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
			body_02.setVoucherAbstract(voucherAbstract);            //摘要
			body_02.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
			body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
			
			/** 建立凭证体1-结束 */
			
			bodyList.add(body_02);
	
			/************************************** 凭证体2-分割线-结束 ********************************************************/
			
			/** 第一步:建立凭证体 */
			/** 银行存款*/
			/************************************** 凭证体3-分割线-开始 ********************************************************/
			VoucherassStactsConfig config_03 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "225");   //凭证配置表:预收账款
			
			//建立辅助账
			List<IntereasVoucherasStacts> stactsList_03 = voucherService.generateVoucherassStacts(cf.getCustId(),null, config_03);                                     //辅助账集合
	        
			
			/** 1 :建立凭证体-开始 */
			IntereasVoucherEntries body_03 = new IntereasVoucherEntries();
			/**
			 * 凭证体参数构建示例:
			 * 参数1：dictionaryData  币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元    currency_type2 
			 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
			 * 参数3：accountNumber 科目编码 ,已封装成对象
			 * 参数4：originalAmount 原币金额 
			 * 参数5：voucherAbstract 摘要 
			 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
			 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
			 */
			//币别对象
			//构建凭证体1需要的参数:
			body_03.setAccountNumber(config_03);                       //这个科目对象
			body_03.setOriginalAmount(cf.getDeduMoney());               //原币金额 
			body_03.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
			body_03.setVoucherAbstract(voucherAbstract3);            //摘要
			body_03.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
			body_03.setIntereasVoucherasStactsInAction(stactsList_03); //保存辅助账
			
			/** 建立凭证体1-结束 */
			
			bodyList.add(body_03);
	
			/************************************** 凭证体3-分割线-结束 ********************************************************/
			
			
			/** 第一步:建立凭证头 */
			/************************************** 凭证头-分割线-开始 ********************************************************/
		
			/**
			 * 凭证头构建-开始
			 * 参数1：companyNumber 所属公司 取:对应UUID 或 InterOrgCode 中的 orgCode 组织机构代码 注:德银要求不做
			 * 参数2：bizDate 业务发生日期 取:如果是网银,则取网银到账日期,其他留空.待导出本系统时取当时日期, 例: 收款流程 中取网银到账日期
			 * 参数3：bookedDate 财务记账日期 取:同业务发生日期
			 * 参数4：voucherType 凭证字 取: 汉字 "记账凭证"
			 * 参数5：generateDate 凭证发生日期 取: 系统当前时间
			 * 参数6：modleName 业务模块 取:标准当前流程名称(凭证产生的模块流程名称) 例:[收款流程]
			 * 参数7：contract_number 业务合同号 取:当前实例业务合同号(存在则比填，不存在则传空) 例:[德银2013第1号]
			 * 参数8: creator 制单人 取:当前业务人员
			 * 参数9：memo1 备注 取:存在则填，不存在则传空
			 */
			
			IntereasVoucherHead headObj = new IntereasVoucherHead();
		
			headObj.setCompanyNumber(interOrgCode);             //参数1：所属公司组织机构代码
			headObj.setBizDate(currentDate);                       //业务发生日期
			headObj.setBookedDate(currentDate);                    //财务记账日期
			headObj.setVoucherType(voucherType);                 //凭证字
			headObj.setGenerate_date(currentDate);               //凭证发生日期
			headObj.setModleName(workFlowName);                  //当前流程名称
			headObj.setContract_id(null);                        //业务合同号 【德银2013第1号】
			headObj.setCreator(currentUser);                      //制单人
			headObj.setIntereasVoucherEntriesInAction(bodyList);  //保存凭证体
			
			//添加到凭证头集合
			headObjList.add(headObj);
			/** 凭证头构建-结束*/
			
			/************************************** 凭证头-分割线-结束 ********************************************************/
	
			/************************************** 分割线-以下不动 ***********************************************************/
			
			/** 第三步:保存凭证 */
			voucherService.saveVoucherMain(headObjList);
		}
		
	}
}
