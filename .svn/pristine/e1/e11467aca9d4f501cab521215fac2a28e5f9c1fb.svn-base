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
import com.business.entity.contract.ContractFinstartdate;
import com.business.entity.contract.ContractInfo;
import com.business.entity.contract.reckon.fund.ContractFundRentInCome;
import com.business.entity.contract.reckon.fund.ContractFundRentPlan;
import com.business.entity.cust.CustInfo;
import com.business.entity.util.OwnAccount;
import com.business.entity.voucher.InterOrgCode;
import com.business.entity.voucher.IntereasVoucherEntries;
import com.business.entity.voucher.IntereasVoucherHead;
import com.business.entity.voucher.IntereasVoucherasStacts;
import com.business.entity.voucher.VoucherassStactsConfig;
import com.business.service.BaseService;
import com.business.service.voucher.VoucherService;
import com.business.service.vouchersFactory.ContractOnHireService;
import com.business.util.Tools;
import com.google.inject.internal.Lists;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;

@Service(value = "contractOnHireService")
public class ContractOnHireServiceImpl implements ContractOnHireService {

	@Resource(name = "baseService")
	private BaseService baseService;

	@Resource(name = "voucherService")
	private VoucherService voucherService;

	/* 
	 * 起租凭证  凭证： 确认+客户+车款
	 */
	@Override
	public void createVoucher(ContractInfo contractInfo, ContractFinstartdate finstartdate) throws Exception {
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
		String workFlowName = "合同起租流程";                                                                                                               //流程名称
		BigDecimal originalAmount = finstartdate.getStartMoney();                                                                                         //原币金额
		String voucherAbstract = contractInfo.getContractNumber()+"确认"+contractInfo.getCustId().getCustName()+"车款";//摘要
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		
		//不含税金额
		BigDecimal noTexEquipAmount = originalAmount.divide(new BigDecimal(1.17), 2, BigDecimal.ROUND_HALF_EVEN);   //金额除以1.17
		//融资租赁资产-重卡
		VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "219");                          //凭证配置表
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_01);                                     //辅助账集合

		
		
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
		body_01.setOriginalAmount(noTexEquipAmount );        //原币金额 
		body_01.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		
		
		//其他应收款-本金进项税额
		//税金
		BigDecimal texEquipAmount = originalAmount.subtract(noTexEquipAmount); //originalAmount.multiply(new BigDecimal(0.17)).setScale(2,BigDecimal.ROUND_HALF_UP);   //金额乘以0.17
		
		VoucherassStactsConfig config_02 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "217");                          //凭证配置表
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_02);                                     //辅助账集合


		
		
		/** 1 :建立凭证体1-开始 */
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
		body_02.setAccountNumber(config_02);                 //这个科目
		body_02.setOriginalAmount(texEquipAmount);         //原币金额 
		body_02.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract);      //摘要
		body_02.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/** 第一步:建立凭证体 */
		/** 贷经销商/客户 */
		/************************************** 凭证体3-分割线-开始 ********************************************************/
		
		//预付账款
		VoucherassStactsConfig config_03 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "216");                                 //凭证配置表-预收账款
		List<IntereasVoucherasStacts> stactsList_03 = voucherService.generateVoucherassStacts(contractInfo.getCustDealer(),null, config_03);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_03.setOriginalAmount( originalAmount );               //原币金额 
		body_03.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_03.setVoucherAbstract(voucherAbstract);            //摘要
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
		headObj.setContract_id(contractInfo);                        //业务合同号 【德银2013第1号】
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
	 * 起租凭证  回租凭证： 确认+客户+车款
	 */
	@Override
	public void createVoucherforLeaseback(ContractInfo contractInfo, ContractFinstartdate finstartdate) throws Exception {
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
		String workFlowName = "合同起租流程";                                                                                                               //流程名称
		BigDecimal originalAmount = finstartdate.getStartMoney();                                                                                         //原币金额
		String voucherAbstract = contractInfo.getContractNumber()+"确认"+contractInfo.getCustId().getCustName()+"车款";//摘要
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		
		//融资租赁资产-重卡
		VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "219");                          //凭证配置表
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_01);                                     //辅助账集合

		
		
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
		body_01.setOriginalAmount(originalAmount);        //原币金额 
		body_01.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 贷经销商/客户 */
		/************************************** 凭证体3-分割线-开始 ********************************************************/
		
		//预付账款
		VoucherassStactsConfig config_03 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "216");                                 //凭证配置表-预收账款
		List<IntereasVoucherasStacts> stactsList_03 = voucherService.generateVoucherassStacts(contractInfo.getCustDealer(),null, config_03);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_03.setOriginalAmount( originalAmount );               //原币金额 
		body_03.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_03.setVoucherAbstract(voucherAbstract);            //摘要
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
		headObj.setContract_id(contractInfo);                        //业务合同号 【德银2013第1号】
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
	 * 起租凭证  凭证： 确认+客户+首付款
	 */
	@Override
	public void createVoucherFirstPay(ContractInfo contractInfo,Map<String, String> dataMap,ContractFinstartdate finstartdate) throws Exception {
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
		String workFlowName = "合同起租流程";                                                                                                               //流程名称
		//BigDecimal originalAmount = finstartdate.getStartMoney();                                                                                         //原币金额
		String voucherAbstract = contractInfo.getContractNumber()+"确认"+contractInfo.getCustId().getCustName()+"首付款";//摘要
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		
		//预收账款-客户
		VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "225");                          //凭证配置表
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_01);  //辅助账集合
		BigDecimal total =  new BigDecimal(dataMap.get("firstpaymenttotal"));
		
		/*for (String value : dataMap.values()) {
			if (value != null) {
				total.add(new BigDecimal(value));
			}
		}*/
		
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
		body_01.setOriginalAmount(total);        //原币金额 
		body_01.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 长期应收款-应收融资租赁款-首付款-客户*/
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		String firstpaymentStr = dataMap.get("firstpayment");
		if (firstpaymentStr != null) {
			BigDecimal firstpayment = new BigDecimal(firstpaymentStr);
			if (firstpayment.compareTo(BigDecimal.ZERO) > 0) {

				// 其他应收款-本金进项税额
				VoucherassStactsConfig config_02 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "223"); // 凭证配置表
				// 建立辅助账
				List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_02); // 辅助账集合

				/** 1 :建立凭证体1-开始 */
				IntereasVoucherEntries body_02 = new IntereasVoucherEntries();
				/**
				 * 凭证体参数构建示例: 参数1：dictionaryData 币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元 currency_type2
				 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
				 * 参数3：accountNumber 科目编码 ,已封装成对象 
				 * 参数4：originalAmount 原币金额
				 * 参数5：voucherAbstract 摘要 
				 * 参数6：entryDC 借贷方向 （1 借方-1 贷方） 
				 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
				 */
				body_02.setAccountNumber(config_02); // 这个科目
				body_02.setOriginalAmount(firstpayment); // 原币金额
				body_02.setEntryDC(CR); // 借贷方向 （DR(1) 借方- CR(1) 贷方）
				body_02.setVoucherAbstract(voucherAbstract); // 摘要
				body_02.setCurrencyNumber(currencyNumber); // 币别数据字段对象
				body_02.setIntereasVoucherasStactsInAction(stactsList_02); // 保存辅助账

				/** 建立凭证体1-结束 */

				bodyList.add(body_02);
			}
		}

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/** 第一步:建立凭证体 */
		/* 其他应付款-保证金-客户
		 * 保证金必须大于0，否则不生成该凭证*/
		/************************************** 凭证体3-分割线-开始 ********************************************************/
		
		String cautionmoneyStr = dataMap.get("cautionmoney");
		if (cautionmoneyStr != null) {
			BigDecimal cautionmoney = new BigDecimal(cautionmoneyStr);
			if (cautionmoney.compareTo(BigDecimal.ZERO) > 0) {
					VoucherassStactsConfig config_03 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "228"); // 凭证配置表:其他应付款-保证金
					List<IntereasVoucherasStacts> stactsList_03 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_03); // 辅助账集合

					/** 1 :建立凭证体1-开始 */
					IntereasVoucherEntries body_03 = new IntereasVoucherEntries();
					/**
					 * 凭证体参数构建示例: 参数1：dictionaryData 币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元 currency_type2
					 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
					 * 参数3：accountNumber 科目编码 ,已封装成对象 
					 * 参数4：originalAmount 原币金额
					 * 参数5：voucherAbstract 摘要 
					 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
					 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
					 */
					// 币别对象
					// 构建凭证体1需要的参数:
					body_03.setAccountNumber(config_03); // 这个科目对象
					body_03.setOriginalAmount(cautionmoney); // 原币金额
					body_03.setEntryDC(CR); // 借贷方向 （DR(1) 借方- CR(1) 贷方）
					body_03.setVoucherAbstract(voucherAbstract); // 摘要
					body_03.setCurrencyNumber(currencyNumber); // 币别数据字段对象
					body_03.setIntereasVoucherasStactsInAction(stactsList_03); // 保存辅助账

					/** 建立凭证体1-结束 */

					bodyList.add(body_03);
			}
		}
		/************************************** 凭证体3-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/* 其他应付款-留购价-客户
		 * 留购价必须大于0，否则不生成该凭证*/
		/************************************** 凭证体4-分割线-开始 ********************************************************/
		String nominalpriceStr = dataMap.get("nominalprice");
		if (nominalpriceStr != null) {
			BigDecimal nominalprice = new BigDecimal(nominalpriceStr);
			if (nominalprice.compareTo(BigDecimal.ZERO) == 1) {
				VoucherassStactsConfig config_04 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "229"); // 凭证配置表:其他应付款-留购价
				List<IntereasVoucherasStacts> stactsList_04 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_04); // 辅助账集合

				/** 1 :建立凭证体1-开始 */
				IntereasVoucherEntries body_04 = new IntereasVoucherEntries();
				/**
				 * 凭证体参数构建示例: 参数1：dictionaryData 币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元 currency_type2
				 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 参数3：accountNumber 科目编码 ,已封装成对象 参数4：originalAmount 原币金额
				 * 参数5：voucherAbstract 摘要 参数6：entryDC 借贷方向 （1 借方-1 贷方） 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
				 */
				// 币别对象
				// 构建凭证体1需要的参数:
				body_04.setAccountNumber(config_04); // 这个科目对象
				body_04.setOriginalAmount(nominalprice); // 原币金额
				body_04.setEntryDC(CR); // 借贷方向 （DR(1) 借方- CR(1) 贷方）
				body_04.setVoucherAbstract(voucherAbstract); // 摘要
				body_04.setCurrencyNumber(currencyNumber); // 币别数据字段对象
				body_04.setIntereasVoucherasStactsInAction(stactsList_04); // 保存辅助账

				/** 建立凭证体1-结束 */

				bodyList.add(body_04);
			}
		}
		/************************************** 凭证体4-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/* 其他应付款-GPS-客户
		 * GPS费用必须大于0，否则不生成该凭证*/
		/************************************** 凭证体5-分割线-开始 ********************************************************/
		String gpsmoneyStr = dataMap.get("gpsmoney");
		if (gpsmoneyStr != null) {
			BigDecimal gpsmoney = new BigDecimal(gpsmoneyStr);
			BigDecimal noTaxGpsmoney = gpsmoney.divide(new BigDecimal(1.17),2,BigDecimal.ROUND_HALF_UP);
			if (gpsmoney.compareTo(BigDecimal.ZERO) == 1) {
				VoucherassStactsConfig config_05 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "226"); // 凭证配置表:其他应付款-GPS
				List<IntereasVoucherasStacts> stactsList_05 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_05); // 辅助账集合

				/** 1 :建立凭证体1-开始 */
				IntereasVoucherEntries body_05 = new IntereasVoucherEntries();
				/**
				 * 凭证体参数构建示例: 参数1：dictionaryData 币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元 currency_type2
				 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
				 * 参数3：accountNumber 科目编码 ,已封装成对象 
				 * 参数4：originalAmount 原币金额
				 * 参数5：voucherAbstract 摘要 
				 * 参数6：entryDC 借贷方向 （1 借方-1 贷方） 
				 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
				 */
				// 币别对象
				// 构建凭证体1需要的参数:
				body_05.setAccountNumber(config_05); // 这个科目对象
				body_05.setOriginalAmount(noTaxGpsmoney); // 原币金额
				body_05.setEntryDC(CR); // 借贷方向 （DR(1) 借方- CR(1) 贷方）
				body_05.setVoucherAbstract(voucherAbstract); // 摘要
				body_05.setCurrencyNumber(currencyNumber); // 币别数据字段对象
				body_05.setIntereasVoucherasStactsInAction(stactsList_05); // 保存辅助账

				/** 建立凭证体1-结束 */

				bodyList.add(body_05);
				
				BigDecimal taxMoney = gpsmoney.subtract(noTaxGpsmoney);
				//应交税费-应交增值税-销项税额
				VoucherassStactsConfig config_05_1 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "238"); // 凭证配置表:应交税费-应交增值税-销项税额
				List<IntereasVoucherasStacts> stactsList_05_1 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_05_1); // 辅助账集合

				/** 1 :建立凭证体1-开始 */
				IntereasVoucherEntries body_05_1 = new IntereasVoucherEntries();
				/**
				 * 凭证体参数构建示例: 参数1：dictionaryData 币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元 currency_type2
				 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
				 * 参数3：accountNumber 科目编码 ,已封装成对象 
				 * 参数4：originalAmount 原币金额
				 * 参数5：voucherAbstract 摘要 
				 * 参数6：entryDC 借贷方向 （1 借方-1 贷方） 
				 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
				 */
				// 币别对象
				// 构建凭证体1需要的参数:
				body_05_1.setAccountNumber(config_05_1); // 这个科目对象
				body_05_1.setOriginalAmount(taxMoney); // 原币金额
				body_05_1.setEntryDC(CR); // 借贷方向 （DR(1) 借方- CR(1) 贷方）
				body_05_1.setVoucherAbstract(voucherAbstract); // 摘要
				body_05_1.setCurrencyNumber(currencyNumber); // 币别数据字段对象
				body_05_1.setIntereasVoucherasStactsInAction(stactsList_05_1); // 保存辅助账

				/** 建立凭证体1-结束 */

				bodyList.add(body_05_1);
				
				
			}
		}
		/************************************** 凭证体5-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/* 其他应付款-保险费-客户
		 * 保险费费用必须大于0，否则不生成该凭证*/
		/************************************** 凭证体6-分割线-开始 ********************************************************/
		String insuremoneyStr = dataMap.get("insuremoney");
		if (insuremoneyStr != null) {
			BigDecimal insuremoney = new BigDecimal(insuremoneyStr);
			if (insuremoney.compareTo(BigDecimal.ZERO) == 1) {
				VoucherassStactsConfig config_06 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "227"); // 凭证配置表:保险费
				List<IntereasVoucherasStacts> stactsList_06 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_06); // 辅助账集合

				/** 1 :建立凭证体1-开始 */
				IntereasVoucherEntries body_06 = new IntereasVoucherEntries();
				/**
				 * 凭证体参数构建示例: 参数1：dictionaryData 币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元 currency_type2
				 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
				 * 参数3：accountNumber 科目编码 ,已封装成对象 
				 * 参数4：originalAmount 原币金额
				 * 参数5：voucherAbstract 摘要 
				 * 参数6：entryDC 借贷方向 （1 借方-1 贷方） 
				 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
				 */
				// 币别对象
				// 构建凭证体1需要的参数:
				body_06.setAccountNumber(config_06); // 这个科目对象
				body_06.setOriginalAmount(insuremoney); // 原币金额
				body_06.setEntryDC(CR); // 借贷方向 （DR(1) 借方- CR(1) 贷方）
				body_06.setVoucherAbstract(voucherAbstract); // 摘要
				body_06.setCurrencyNumber(currencyNumber); // 币别数据字段对象
				body_06.setIntereasVoucherasStactsInAction(stactsList_06); // 保存辅助账

				/** 建立凭证体1-结束 */

				bodyList.add(body_06);
				
			
				
				
			}
		}
		/************************************** 凭证体6-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/* 其他应付款-其他-客户
		 * 其他金额必须大于0，否则不生成该凭证*/
		/************************************** 凭证体7-分割线-开始 ********************************************************/
		String otherincomeStr = dataMap.get("otherincome");
		if (otherincomeStr != null) {
			BigDecimal otherincome = new BigDecimal(otherincomeStr);
			if (otherincome.compareTo(BigDecimal.ZERO) == 1) {
				VoucherassStactsConfig config_07 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "241"); // 凭证配置表:其他应付款-其他
				List<IntereasVoucherasStacts> stactsList_07 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_07); // 辅助账集合

				/** 1 :建立凭证体1-开始 */
				IntereasVoucherEntries body_07 = new IntereasVoucherEntries();
				/**
				 * 凭证体参数构建示例: 参数1：dictionaryData 币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元 currency_type2
				 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
				 * 参数3：accountNumber 科目编码 ,已封装成对象 
				 * 参数4：originalAmount 原币金额
				 * 参数5：voucherAbstract 摘要 
				 * 参数6：entryDC 借贷方向 （1 借方-1 贷方） 
				 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
				 */
				// 币别对象
				// 构建凭证体1需要的参数:
				body_07.setAccountNumber(config_07); // 这个科目对象
				body_07.setOriginalAmount(otherincome); // 原币金额
				body_07.setEntryDC(CR); // 借贷方向 （DR(1) 借方- CR(1) 贷方）
				body_07.setVoucherAbstract(voucherAbstract); // 摘要
				body_07.setCurrencyNumber(currencyNumber); // 币别数据字段对象
				body_07.setIntereasVoucherasStactsInAction(stactsList_07); // 保存辅助账

				/** 建立凭证体1-结束 */

				bodyList.add(body_07);
			}
		}
		/************************************** 凭证体7-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/* 主营业务收入-手续费收入
		 * 手续费必须大于0，否则不生成该凭证*/
		/************************************** 凭证体8-分割线-开始 ********************************************************/
		String handlingchargemoneyStr = dataMap.get("handlingchargemoney");
		if (handlingchargemoneyStr != null) {
			BigDecimal handlingchargemoney = new BigDecimal(handlingchargemoneyStr);

			if (handlingchargemoney.compareTo(BigDecimal.ZERO) == 1) {
				BigDecimal noTexhandlingchargemoney = handlingchargemoney.divide(new BigDecimal(1.17), 2, BigDecimal.ROUND_HALF_EVEN); // 金额除以1.17
				VoucherassStactsConfig config_08 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "233"); // 凭证配置表:主营业务收入-手续费收入
				List<IntereasVoucherasStacts> stactsList_08 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_08); // 辅助账集合

				/** 1 :建立凭证体1-开始 */
				IntereasVoucherEntries body_08 = new IntereasVoucherEntries();
				/**
				 * 凭证体参数构建示例: 参数1：dictionaryData 币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元 currency_type2
				 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数)
				 * 参数3：accountNumber 科目编码 ,已封装成对象 
				 * 参数4：originalAmount 原币金额
				 * 参数5：voucherAbstract 摘要 
				 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
				 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
				 */
				// 币别对象
				// 构建凭证体1需要的参数:
				body_08.setAccountNumber(config_08); // 这个科目对象
				body_08.setOriginalAmount(noTexhandlingchargemoney); // 原币金额
				body_08.setEntryDC(CR); // 借贷方向 （DR(1) 借方- CR(1) 贷方）
				body_08.setVoucherAbstract(voucherAbstract); // 摘要
				body_08.setCurrencyNumber(currencyNumber); // 币别数据字段对象
				body_08.setIntereasVoucherasStactsInAction(stactsList_08); // 保存辅助账

				/** 建立凭证体1-结束 */

				bodyList.add(body_08);
			}
		}
		/************************************** 凭证体8-分割线-结束 ********************************************************/
		/** 第一步:建立凭证体 */
		/* 应交税费-应交增值税-销项税额
		 * 销项税金必须大于0，否则不生成该凭证*/
		/************************************** 凭证体9-分割线-开始 ********************************************************/
		if (handlingchargemoneyStr != null) {
			BigDecimal handlingchargemoney = new BigDecimal(handlingchargemoneyStr);
			if (handlingchargemoney.compareTo(BigDecimal.ZERO) == 1) {
				BigDecimal noTexhandlingchargemoney = handlingchargemoney.divide(new BigDecimal(1.17), 2, BigDecimal.ROUND_HALF_EVEN); // 金额除以1.17
				BigDecimal outPutTaxMoney = handlingchargemoney.subtract(noTexhandlingchargemoney); // 金额 - 金额/1.17
				
				VoucherassStactsConfig config_09 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "238"); // 凭证配置表:应交税费-应交增值税-销项税额
				List<IntereasVoucherasStacts> stactsList_09 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_09); // 辅助账集合

				/** 1 :建立凭证体1-开始 */
				IntereasVoucherEntries body_09 = new IntereasVoucherEntries();
				/**
				 * 凭证体参数构建示例: 参数1：dictionaryData 币别数据字段对象 取:数据字典 人民币 currency_type1 || 美元 currency_type2
				 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 参数3：accountNumber 科目编码 ,已封装成对象 参数4：originalAmount 原币金额
				 * 参数5：voucherAbstract 摘要 参数6：entryDC 借贷方向 （1 借方-1 贷方） 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
				 */
				// 币别对象
				// 构建凭证体1需要的参数:
				body_09.setAccountNumber(config_09); // 这个科目对象
				body_09.setOriginalAmount(outPutTaxMoney); // 原币金额
				body_09.setEntryDC(CR); // 借贷方向 （DR(1) 借方- CR(1) 贷方）
				body_09.setVoucherAbstract(voucherAbstract); // 摘要
				body_09.setCurrencyNumber(currencyNumber); // 币别数据字段对象
				body_09.setIntereasVoucherasStactsInAction(stactsList_09); // 保存辅助账

				/** 建立凭证体1-结束 */

				bodyList.add(body_09);
			}
		}
		/************************************** 凭证体9-分割线-结束 ********************************************************/
		
		
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
		headObj.setContract_id(contractInfo);                        //业务合同号 【德银2013第1号】
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
	 * 起租凭证  凭证： 确认+客户+起租租金
	 */
	@Override
	public void createVoucherOnHireRent(ContractInfo contractInfo,Map<String, String> DataMap,ContractFinstartdate finstartdate) throws Exception {
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
		String workFlowName = "合同起租流程";                                                                                                               //流程名称
		String voucherAbstract = contractInfo.getContractNumber()+"确认"+contractInfo.getCustId().getCustName()+"起租租金";																	//摘要
		//BigDecimal originalAmount = finstartdate.getStartMoney();                                                                                         //原币金额
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 融资租赁款
		 * 长期应收款-应收融资租赁款-租金-客户*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		BigDecimal renttotalmoney=new BigDecimal(DataMap.get("renttotalmoney"));//租金总额
		//融资租赁资产-重卡
		VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "222");                          //长期应收款-应收融资租赁款-租金
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_01);                                     //辅助账集合

		
		
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
		body_01.setOriginalAmount(renttotalmoney);        //原币金额 
		body_01.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		
		
		//长期应收款-应收融资租赁款-首付款
		BigDecimal firstpayment=new BigDecimal(DataMap.get("firstpayment"));
		VoucherassStactsConfig config_02 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "223");                          //凭证配置表 长期应收款-应收融资租赁款-首付款
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_02);                                     //辅助账集合
		
		
		/** 1 :建立凭证体1-开始 */
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
		body_02.setAccountNumber(config_02);                 //这个科目
		body_02.setOriginalAmount(firstpayment);         //原币金额 
		body_02.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract);      //摘要
		body_02.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/** 第一步:建立凭证体 */
		/** 融资租赁资产-重卡*/
		/************************************** 凭证体3-分割线-开始 ********************************************************/
		
		BigDecimal equipAmt=new BigDecimal(DataMap.get("equipamt"));
		BigDecimal noTaxEquipAmt = equipAmt.divide(new BigDecimal(1.17), 2, BigDecimal.ROUND_HALF_EVEN);   //不含税设备款
		VoucherassStactsConfig config_03 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "219");                                 //凭证配置表-预收账款
		List<IntereasVoucherasStacts> stactsList_03 = voucherService.generateVoucherassStacts(contractInfo.getCustId(),null, config_03);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_03.setOriginalAmount(noTaxEquipAmt);                 //原币金额 
		body_03.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_03.setVoucherAbstract(voucherAbstract);            //摘要
		body_03.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_03.setIntereasVoucherasStactsInAction(stactsList_03); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_03);

		/************************************** 凭证体3-分割线-结束 ********************************************************/
		
		/** 长期应收款-应收融资租赁款-本金销项税额*/
		/************************************** 凭证体4-分割线-开始 ********************************************************/
		//计算逻辑待确定
		BigDecimal inPutTaxMoney=equipAmt.subtract(noTaxEquipAmt); //税额
		VoucherassStactsConfig config_04 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "218");                                 //凭证配置表-长期应收款-应收融资租赁款-本金销项税额
		List<IntereasVoucherasStacts> stactsList_04 = voucherService.generateVoucherassStacts(contractInfo.getCustId(),null, config_04);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_04 = new IntereasVoucherEntries();
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
		body_04.setAccountNumber(config_04);                       //这个科目对象
		body_04.setOriginalAmount(inPutTaxMoney);               //原币金额 
		body_04.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_04.setVoucherAbstract(voucherAbstract);            //摘要
		body_04.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_04.setIntereasVoucherasStactsInAction(stactsList_04); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_04);

		/************************************** 凭证体4-分割线-结束 ********************************************************/
		
		/** 融资收益，租金利息*/
		/************************************** 凭证体5-分割线-开始 ********************************************************/
		BigDecimal totalInterest=new BigDecimal(DataMap.get("totalInterest"));
		VoucherassStactsConfig config_05 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "224");                                 //凭证配置表-未确认融资收益
		List<IntereasVoucherasStacts> stactsList_05 = voucherService.generateVoucherassStacts(contractInfo.getCustId(),null, config_05);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_05 = new IntereasVoucherEntries();
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
		body_05.setAccountNumber(config_05);                       //这个科目对象
		body_05.setOriginalAmount(totalInterest);               //原币金额 
		body_05.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_05.setVoucherAbstract(voucherAbstract);            //摘要
		body_05.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_05.setIntereasVoucherasStactsInAction(stactsList_05); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_05);

		/************************************** 凭证体5-分割线-结束 ********************************************************/
		
		
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
		headObj.setContract_id(contractInfo);                        //业务合同号 【德银2013第1号】
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
	 * 凭证： 确认+客户+租金利息 (不上牌)
	 */
	@Override
	public void createVoucherInterest(ContractFundRentPlan contractFundRentPlan,BigDecimal rent, BigDecimal interest) throws Exception {
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
//		String workFlowName = "租金回笼";                                                                                                               //流程名称
		String workFlowName = "租金利息";                                                                                                               //流程名称
		CustInfo custInfo = contractFundRentPlan.getContractId().getCustId();
		CustInfo dealer = contractFundRentPlan.getContractId().getCustDealer();
		String contractnumber=  contractFundRentPlan.getContractId().getContractNumber();
		String voucherAbstract = "确认"+dealer.getCustName()+"-"+contractnumber+"-"+custInfo.getCustName()+"第"+ contractFundRentPlan.getRentList() + "期租金利息";//摘要
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 融资租赁款
		 * 预收账款-客户*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "225");      //预收账款
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(custInfo, null, config_01);                                     //辅助账集合

		
		
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
		body_01.setOriginalAmount(rent);        //原币金额 
		body_01.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		
		
		//长期应收款-应收融资租赁款-租金
		VoucherassStactsConfig config_02 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "222");     //凭证配置表 长期应收款-应收融资租赁款-租金
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(custInfo, null, config_02);                                     //辅助账集合
		
		/** 1 :建立凭证体2-开始 */
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
		body_02.setAccountNumber(config_02);                 //这个科目
		body_02.setOriginalAmount(rent);         //原币金额 
		body_02.setEntryDC(CR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract);      //摘要
		body_02.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体2-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/************************************** 凭证体3-分割线-开始 ********************************************************/
		
		VoucherassStactsConfig config_03 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "224");        //凭证配置表-未确认融资收益
		List<IntereasVoucherasStacts> stactsList_03 = voucherService.generateVoucherassStacts(custInfo, null, config_03);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_03.setOriginalAmount(interest);               //原币金额 
		body_03.setEntryDC(DR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_03.setVoucherAbstract(voucherAbstract);            //摘要
		body_03.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_03.setIntereasVoucherasStactsInAction(stactsList_03); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_03);

		/************************************** 凭证体3-分割线-结束 ********************************************************/
		
		/** 主营业务收入-租金利息收入*/
		/************************************** 凭证体4-分割线-开始 ********************************************************/
		//计算逻辑待确定
		BigDecimal interestTax=interest.divide(new BigDecimal(1.17),2,BigDecimal.ROUND_HALF_EVEN);//除以1.17
		VoucherassStactsConfig config_04 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "232");       //凭证配置表-主营业务收入-租金利息收入
		List<IntereasVoucherasStacts> stactsList_04 = voucherService.generateVoucherassStacts(custInfo, null, config_04);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_04 = new IntereasVoucherEntries();
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
		body_04.setAccountNumber(config_04);                       //这个科目对象
		body_04.setOriginalAmount(interestTax);               //原币金额 
		body_04.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_04.setVoucherAbstract(voucherAbstract);            //摘要
		body_04.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_04.setIntereasVoucherasStactsInAction(stactsList_04); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_04);

		/************************************** 凭证体4-分割线-结束 ********************************************************/
		
		/** 应交税费-应交增值税-销项税额*/
		/************************************** 凭证体5-分割线-开始 ********************************************************/
		//计算逻辑待确定
		BigDecimal outPutTaxInterest=interest.subtract(interestTax);
		VoucherassStactsConfig config_05 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "238");    //凭证配置表-应交税费-应交增值税-销项税额
		List<IntereasVoucherasStacts> stactsList_05 = voucherService.generateVoucherassStacts(custInfo,null, config_05);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_05 = new IntereasVoucherEntries();
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
		body_05.setAccountNumber(config_05);                       //这个科目对象
		body_05.setOriginalAmount(outPutTaxInterest);               //原币金额 
		body_05.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_05.setVoucherAbstract(voucherAbstract);            //摘要
		body_05.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_05.setIntereasVoucherasStactsInAction(stactsList_05); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_05);

		/************************************** 凭证体5-分割线-结束 ********************************************************/
		
		
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
		headObj.setContract_id(contractFundRentPlan.getContractId());                        //业务合同号 【德银2013第1号】
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
	 * 凭证： 确认+客户+租金利息(不上牌)
	 */
	@Override
	public void createVoucherInterestNoPlate(ContractFundRentPlan contractFundRentPlan,BigDecimal rent, BigDecimal interest) throws Exception {
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
		String workFlowName = "合同起租流程";                                                                                                               //流程名称
		CustInfo custInfo = contractFundRentPlan.getContractId().getCustId();
		CustInfo dealer = contractFundRentPlan.getContractId().getCustDealer();
		String contractnumber=  contractFundRentPlan.getContractId().getContractNumber();
		String voucherAbstract = "确认"+dealer.getCustName()+"-"+contractnumber+"-"+custInfo.getCustName()+"第"+ contractFundRentPlan.getRentList() + "租金利息";//摘要
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 融资租赁款
		 * 预收账款-客户*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "225");      //预收账款
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(custInfo, null, config_01);                                     //辅助账集合

		
		
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
		body_01.setOriginalAmount(rent);        //原币金额 
		body_01.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		
		
		//长期应收款-应收融资租赁款-租金
		VoucherassStactsConfig config_02 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "222");     //凭证配置表 长期应收款-应收融资租赁款-租金
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(custInfo, null, config_02);                                     //辅助账集合
		
		/** 1 :建立凭证体2-开始 */
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
		body_02.setAccountNumber(config_02);                 //这个科目
		body_02.setOriginalAmount(rent);         //原币金额 
		body_02.setEntryDC(CR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract);      //摘要
		body_02.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体2-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/************************************** 凭证体3-分割线-开始 ********************************************************/
		
		VoucherassStactsConfig config_03 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "224");        //凭证配置表-未确认融资收益
		List<IntereasVoucherasStacts> stactsList_03 = voucherService.generateVoucherassStacts(custInfo, null, config_03);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_03.setOriginalAmount(interest);               //原币金额 
		body_03.setEntryDC(DR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_03.setVoucherAbstract(voucherAbstract);            //摘要
		body_03.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_03.setIntereasVoucherasStactsInAction(stactsList_03); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_03);

		/************************************** 凭证体3-分割线-结束 ********************************************************/
		
		/** 主营业务收入-租金利息收入*/
		/************************************** 凭证体4-分割线-开始 ********************************************************/
		//计算逻辑待确定
		BigDecimal interestTax=interest.divide(new BigDecimal(1.17),2,BigDecimal.ROUND_HALF_EVEN);//除以1.17
		VoucherassStactsConfig config_04 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "232");       //凭证配置表-主营业务收入-租金利息收入
		List<IntereasVoucherasStacts> stactsList_04 = voucherService.generateVoucherassStacts(custInfo, null, config_04);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_04 = new IntereasVoucherEntries();
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
		body_04.setAccountNumber(config_04);                       //这个科目对象
		body_04.setOriginalAmount(interestTax);               //原币金额 
		body_04.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_04.setVoucherAbstract(voucherAbstract);            //摘要
		body_04.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_04.setIntereasVoucherasStactsInAction(stactsList_04); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_04);

		/************************************** 凭证体4-分割线-结束 ********************************************************/
		
		/** 应交税费-应交增值税-销项税额*/
		/************************************** 凭证体5-分割线-开始 ********************************************************/
		//计算逻辑待确定
		BigDecimal outPutTaxInterest=interest.subtract(interestTax);
		VoucherassStactsConfig config_05 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "238");    //凭证配置表-应交税费-应交增值税-销项税额
		//List<IntereasVoucherasStacts> stactsList_05 = voucherService.generateVoucherassStacts(custInfo,null, config_05);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_05 = new IntereasVoucherEntries();
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
		body_05.setAccountNumber(config_05);                       //这个科目对象
		body_05.setOriginalAmount(outPutTaxInterest);               //原币金额 
		body_05.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_05.setVoucherAbstract(voucherAbstract);            //摘要
		body_05.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_05.setIntereasVoucherasStactsInAction(null); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_05);

		/************************************** 凭证体5-分割线-结束 ********************************************************/
		
		/** 长期应收款-应收融资租赁款-本金销项税*/
		/************************************** 凭证体6-分割线-开始 ********************************************************/
		//计算本金		
		BigDecimal principalNoTax=(rent.subtract(interest)).divide(new BigDecimal(1.17),2,BigDecimal.ROUND_HALF_EVEN);//除以1.17
		VoucherassStactsConfig config_06 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "218");       //凭证配置表-主营业务收入-租金利息收入
		List<IntereasVoucherasStacts> stactsList_06 = voucherService.generateVoucherassStacts(custInfo, null, config_06);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_06 = new IntereasVoucherEntries();
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
		body_06.setAccountNumber(config_06);                       //这个科目对象
		body_06.setOriginalAmount(principalNoTax);               //原币金额 
		body_06.setEntryDC(DR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_06.setVoucherAbstract(voucherAbstract);            //摘要
		body_06.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_06.setIntereasVoucherasStactsInAction(stactsList_06); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_06);

		/************************************** 凭证体6-分割线-结束 ********************************************************/
		
		/** 应交税费-应交增值税-销项税额*/
		/************************************** 凭证体7-分割线-开始 ********************************************************/
		BigDecimal principalTax=rent.subtract(interest).subtract(principalNoTax);
		VoucherassStactsConfig config_07 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "238");    //凭证配置表-应交税费-应交增值税-销项税额
		List<IntereasVoucherasStacts> stactsList_07 = voucherService.generateVoucherassStacts(custInfo,null, config_07);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_07 = new IntereasVoucherEntries();
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
		body_07.setAccountNumber(config_07);                       //这个科目对象
		body_07.setOriginalAmount(outPutTaxInterest);               //原币金额 
		body_07.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_07.setVoucherAbstract(voucherAbstract);            //摘要
		body_07.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_07.setIntereasVoucherasStactsInAction(stactsList_07); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_07);

		/************************************** 凭证体7-分割线-结束 ********************************************************/
		
		
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
		headObj.setContract_id(contractFundRentPlan.getContractId());                        //业务合同号 【德银2013第1号】
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
	
	/**
	 * 卡扣核销
	 * @param ebankData
	 * @throws Exception
	 */
	@Override
	public void cardHireVoucher(List<ContractFundRentInCome> incomeList) throws Exception {
		List<IntereasVoucherHead> headObjList = new ArrayList<IntereasVoucherHead>(); 
		IntereasVoucherHead headObj = null;
		List<OwnAccount> ownlist=this.baseService.findEntities(OwnAccount.class);
		HashMap<String,OwnAccount> ownacc=new HashMap<String, OwnAccount>();
		for(OwnAccount own:ownlist){
			ownacc.put(own.getAccNumber(), own);
		}
		for (int i = 0; i < incomeList.size(); i++) {
			ContractFundRentInCome income = incomeList.get(i);
			
			BigDecimal rent = income.getRent();
			BigDecimal penalty = income.getPenalty();
			
			if (rent != null && rent.compareTo(BigDecimal.ZERO) > 0) {//租金
				headObj = this.cardHirePlanVoucher(income,ownacc);
				headObjList.add(headObj);
			} else if (penalty != null && penalty.compareTo(BigDecimal.ZERO) > 0) {//罚息
				//生成收到罚息凭证
				headObj = this.cardHirePlanVoucherForPenalty(income,ownacc);
				headObjList.add(headObj);
				
				//罚息的凭证在销项发票导入后生成
				headObj = this.cardHirePenaltyVoucher(income);
				headObjList.add(headObj);
			}
			
			//添加到凭证头集合
//			if(headObj != null){
//				headObjList.add(headObj);
//			}
		}

		/************************************** 分割线-以下不动 ***********************************************************/
		
		/** 第三步:保存凭证 */
		if(headObjList.size()>0){
			voucherService.saveVoucherMain(headObjList);
		}
	}
	
	/**
	 * 卡扣租金部分
	 * @param incomePlan
	 * @throws Exception
	 */
	public IntereasVoucherHead cardHirePlanVoucher(ContractFundRentInCome incomePlan,HashMap<String,OwnAccount> ownacc) throws Exception {
		/** 第一步:建立基本凭证体集合和公用字段字段-开始 */
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
		String workFlowName = "卡扣";                                                                                                               //流程名称
//		Map<String, Object> propertiesMap = new HashMap<String, Object>();
//		propertiesMap.put("accNumber", incomePlan.getOwnNumber());
//		OwnAccount ownAccount = this.baseService.findEntityByProperties(OwnAccount.class, propertiesMap).get(0);
		
		OwnAccount ownAccount=ownacc.get(incomePlan.getOwnNumber());
		String accSubject = ownAccount.getAccSubject();                                                                                                 //网银科目
		BigDecimal originalAmount = incomePlan.getRent();                                                                                         //原币金额
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		
		Map<String, Object> configMap = new HashMap<String, Object>();
		configMap.put("subjectsCode", accSubject);
		VoucherassStactsConfig config_01 = this.baseService.findEntityByProperties(VoucherassStactsConfig.class, configMap).get(0);                          //凭证配置表
		String voucherAbstract_01 = incomePlan.getHireDate()+"收到"+incomePlan.getContractId().getCustId().getCustName()+"租金";//摘要
		
		//建立辅助账
		
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(null, ownAccount, config_01);                                     //辅助账集合

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
		body_01.setOriginalAmount(originalAmount );      //原币金额 
		body_01.setEntryDC(DR);                            //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract_01);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 贷经销商/客户 */
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		
		VoucherassStactsConfig config_02 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "225");                                 //凭证配置表-预收账款
		//String voucherAbstract_02 = "核销‘"+ebankData.getCustId().getCustName()+"’-款";  //摘要
		
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(incomePlan.getContractId().getCustId(),null, config_02);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_02.setOriginalAmount( originalAmount );               //原币金额 
		body_02.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract_01);            //摘要
		body_02.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/** 第一步:建立凭证头 */
		/************************************** 凭证头-分割线-开始 ********************************************************/
	
		String ebankDate = incomePlan.getHireDate();
		
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
	
		ContractInfo cinfo=incomePlan.getContractId();
		headObj.setCompanyNumber(interOrgCode);             //参数1：所属公司组织机构代码
		headObj.setBizDate(ebankDate);                       //业务发生日期
		headObj.setBookedDate(ebankDate);                    //财务记账日期
		headObj.setVoucherType(voucherType);                 //凭证字
		headObj.setGenerate_date(currentDate);               //凭证发生日期
		headObj.setModleName(workFlowName);                  //当前流程名称
		headObj.setContract_id(cinfo);                        //业务合同号 【德银2013第1号】
		headObj.setCreator(currentUser);                      //制单人
		headObj.setIntereasVoucherEntriesInAction(bodyList);  //保存凭证体
		
		return headObj;
		/** 凭证头构建-结束*/
		
		/************************************** 凭证头-分割线-结束 ********************************************************/

		
	}
	
	/**
	 * 卡扣罚息,生成收到罚息凭证
	 * @param incomePlan
	 * @throws Exception
	 */
	public IntereasVoucherHead cardHirePlanVoucherForPenalty(ContractFundRentInCome incomePlan,HashMap<String,OwnAccount> ownacc) throws Exception {
		/** 第一步:建立基本凭证体集合和公用字段字段-开始 */
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
		String workFlowName = "卡扣";                                                                                                               //流程名称
//		Map<String, Object> propertiesMap = new HashMap<String, Object>();
//		propertiesMap.put("accNumber", incomePlan.getOwnNumber());
//		OwnAccount ownAccount = this.baseService.findEntityByProperties(OwnAccount.class, propertiesMap).get(0);
		
		OwnAccount ownAccount=ownacc.get(incomePlan.getOwnNumber());
		String accSubject = ownAccount.getAccSubject();                                                                                                 //网银科目
		BigDecimal originalAmount = incomePlan.getPenalty();                                                                                         //原币金额
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		
		Map<String, Object> configMap = new HashMap<String, Object>();
		configMap.put("subjectsCode", accSubject);
		VoucherassStactsConfig config_01 = this.baseService.findEntityByProperties(VoucherassStactsConfig.class, configMap).get(0);                          //凭证配置表
		String voucherAbstract_01 = incomePlan.getHireDate()+"收到"+incomePlan.getContractId().getCustId().getCustName()+"租金";//摘要
		
		//建立辅助账
		
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(null, ownAccount, config_01);                                     //辅助账集合

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
		body_01.setOriginalAmount(originalAmount );      //原币金额 
		body_01.setEntryDC(DR);                            //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract_01);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 贷经销商/客户 */
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		
		VoucherassStactsConfig config_02 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "225");                                 //凭证配置表-预收账款
		//String voucherAbstract_02 = "核销‘"+ebankData.getCustId().getCustName()+"’-款";  //摘要
		
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(incomePlan.getContractId().getCustId(),null, config_02);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_02.setOriginalAmount( originalAmount );               //原币金额 
		body_02.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract_01);            //摘要
		body_02.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/** 第一步:建立凭证头 */
		/************************************** 凭证头-分割线-开始 ********************************************************/
	
		String ebankDate = incomePlan.getHireDate();
		
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
	
		ContractInfo cinfo=incomePlan.getContractId();
		headObj.setCompanyNumber(interOrgCode);             //参数1：所属公司组织机构代码
		headObj.setBizDate(ebankDate);                       //业务发生日期
		headObj.setBookedDate(ebankDate);                    //财务记账日期
		headObj.setVoucherType(voucherType);                 //凭证字
		headObj.setGenerate_date(currentDate);               //凭证发生日期
		headObj.setModleName(workFlowName);                  //当前流程名称
		headObj.setContract_id(cinfo);                        //业务合同号 【德银2013第1号】
		headObj.setCreator(currentUser);                      //制单人
		headObj.setIntereasVoucherEntriesInAction(bodyList);  //保存凭证体
		
		return headObj;
		/** 凭证头构建-结束*/
		
		/************************************** 凭证头-分割线-结束 ********************************************************/

		
	}
	
	/**
	 * 卡扣罚息部分
	 * @param incomePlan
	 * @throws Exception
	 */
	public IntereasVoucherHead cardHirePenaltyVoucher(ContractFundRentInCome incomePlan) throws Exception {
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
		String workFlowName ="卡扣"; 
		//流程名称
		/*
		Map<String, Object> propertiesMap = new HashMap<String, Object>();
		propertiesMap.put("accNumber", ebankData.getOwnAccNumber());
		OwnAccount ownAccount = this.baseService.findEntityByProperties(OwnAccount.class, propertiesMap).get(0);
		String accSubject = ownAccount.getAccSubject();                                                                                                 //网银科目
		BigDecimal originalAmount = ebankData.getFactMoney(); */                                                                                          //原币金额
		/** 本凭证-公用字段-结束*/
		//不含税金额
		BigDecimal sum=incomePlan.getPenalty();
		BigDecimal noTexMoney = sum.divide(new BigDecimal(1.17), 2, BigDecimal.ROUND_HALF_EVEN);   //金额除以1.17
		BigDecimal balanceMoney=sum.subtract(noTexMoney).setScale(2, BigDecimal.ROUND_HALF_EVEN);		
		
		ContractInfo cinfo=incomePlan.getContractId();
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		
		//Map<String, Object> configMap = new HashMap<String, Object>();
		//configMap.put("subjectsCode", accSubject);
		
		VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "225");                          //凭证配置表
		String voucherAbstract_01 = "确认"+cinfo.getCustId().getCustName()+"延期利息";//摘要
		
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
		body_01.setOriginalAmount(sum);      //原币金额 
		body_01.setEntryDC(DR);                            //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract_01);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 贷经销商/客户 */
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		
		VoucherassStactsConfig config_02 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "234");                                 //凭证配置表-预收账款
		String voucherAbstract_02 = "确认"+cinfo.getCustId().getCustName()+"延期利息";//摘要
		
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(cinfo.getCustId(),null, config_02);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_02.setOriginalAmount(noTexMoney);               //原币金额 
		body_02.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract_02);            //摘要
		body_02.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
	    /************************************** 凭证体3-分割线-开始 ********************************************************/
		
		VoucherassStactsConfig config_03 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "238");                                 //凭证配置表-预收账款
		String voucherAbstract_03 = "确认"+cinfo.getCustId().getCustName()+"延期利息";//摘要
		
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_03 = voucherService.generateVoucherassStacts(cinfo.getCustId(),null, config_03);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_03.setOriginalAmount(balanceMoney);               //原币金额 
		body_03.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_03.setVoucherAbstract(voucherAbstract_03);            //摘要
		body_03.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_03.setIntereasVoucherasStactsInAction(stactsList_03); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_03);

		/************************************** 凭证体3-分割线-结束 ********************************************************/
		
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

		return headObj;
	}

	
	/* 
	 * 起租凭证   回租凭证： 确认+客户+起租租金
	 */
	@Override
	public void createVoucherOnHireRentforLeaseback(ContractInfo contractInfo,Map<String, String> DataMap,ContractFinstartdate finstartdate) throws Exception {
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
		String workFlowName = "合同起租流程";                                                                                                               //流程名称
		String voucherAbstract = contractInfo.getContractNumber()+"确认"+contractInfo.getCustId().getCustName()+"起租租金";																	//摘要
		//BigDecimal originalAmount = finstartdate.getStartMoney();                                                                                         //原币金额
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 融资租赁款
		 * 长期应收款-应收融资租赁款-租金-客户*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		BigDecimal renttotalmoney=new BigDecimal(DataMap.get("renttotalmoney"));//租金总额
		//融资租赁资产-重卡
		VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "222");                          //长期应收款-应收融资租赁款-租金
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_01);                                     //辅助账集合

		
		
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
		body_01.setOriginalAmount(renttotalmoney);        //原币金额 
		body_01.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		
		
		//长期应收款-应收融资租赁款-首付款
		BigDecimal firstpayment=new BigDecimal(DataMap.get("firstpayment"));
		VoucherassStactsConfig config_02 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "223");                          //凭证配置表 长期应收款-应收融资租赁款-首付款
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(contractInfo.getCustId(), null, config_02);                                     //辅助账集合
		
		
		/** 1 :建立凭证体1-开始 */
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
		body_02.setAccountNumber(config_02);                 //这个科目
		body_02.setOriginalAmount(firstpayment);         //原币金额 
		body_02.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract);      //摘要
		body_02.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/** 第一步:建立凭证体 */
		/** 融资租赁资产-重卡*/
		/************************************** 凭证体3-分割线-开始 ********************************************************/
		
		BigDecimal equipAmt=new BigDecimal(DataMap.get("equipamt"));
		VoucherassStactsConfig config_03 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "219");                                 //凭证配置表-预收账款
		List<IntereasVoucherasStacts> stactsList_03 = voucherService.generateVoucherassStacts(contractInfo.getCustId(),null, config_03);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_03.setOriginalAmount(equipAmt);                 //原币金额 
		body_03.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_03.setVoucherAbstract(voucherAbstract);            //摘要
		body_03.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_03.setIntereasVoucherasStactsInAction(stactsList_03); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_03);

		/************************************** 凭证体3-分割线-结束 ********************************************************/
		
		
		/** 融资收益，租金利息*/
		/************************************** 凭证体5-分割线-开始 ********************************************************/
		BigDecimal totalInterest=new BigDecimal(DataMap.get("totalInterest"));
		VoucherassStactsConfig config_05 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "224");                                 //凭证配置表-未确认融资收益
		List<IntereasVoucherasStacts> stactsList_05 = voucherService.generateVoucherassStacts(contractInfo.getCustId(),null, config_05);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_05 = new IntereasVoucherEntries();
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
		body_05.setAccountNumber(config_05);                       //这个科目对象
		body_05.setOriginalAmount(totalInterest);               //原币金额 
		body_05.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_05.setVoucherAbstract(voucherAbstract);            //摘要
		body_05.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_05.setIntereasVoucherasStactsInAction(stactsList_05); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_05);

		/************************************** 凭证体5-分割线-结束 ********************************************************/
		
		
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
		headObj.setContract_id(contractInfo);                        //业务合同号 【德银2013第1号】
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
	
	/*补租金利息生成*/
	@Override
	public void createVoucherRTInterest(ContractFundRentPlan contractFundRentPlan,BigDecimal rent, BigDecimal interest) throws Exception {
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
		String workFlowName = "租金利息";                                                                                                               //流程名称
		CustInfo custInfo = contractFundRentPlan.getContractId().getCustId();
		CustInfo dealer = contractFundRentPlan.getContractId().getCustDealer();
		String contractnumber=  contractFundRentPlan.getContractId().getContractNumber();
		String voucherAbstract = "补确认"+dealer.getCustName()+"-"+contractnumber+"-"+custInfo.getCustName()+"第"+ contractFundRentPlan.getRentList() + "期租金利息";//摘要
		/** 本凭证-公用字段-结束*/
		
		
		/** 第一步:建立凭证体 */
		/** 融资租赁款
		 * 预收账款-客户*/
		/************************************** 凭证体1-分割线-开始 ********************************************************/
		VoucherassStactsConfig config_01 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "225");      //预收账款
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_01 = voucherService.generateVoucherassStacts(custInfo, null, config_01);                                     //辅助账集合

		
		
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
		body_01.setOriginalAmount(rent);        //原币金额 
		body_01.setEntryDC(DR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_01.setVoucherAbstract(voucherAbstract);      //摘要
		body_01.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_01.setIntereasVoucherasStactsInAction(stactsList_01); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_01);

		/************************************** 凭证体1-分割线-结束 ********************************************************/
		
		/** 第一步:建立凭证体 */
		/** 借银行存款*/
		/************************************** 凭证体2-分割线-开始 ********************************************************/
		
		
		//长期应收款-应收融资租赁款-租金
		VoucherassStactsConfig config_02 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "222");     //凭证配置表 长期应收款-应收融资租赁款-租金
		//建立辅助账
		List<IntereasVoucherasStacts> stactsList_02 = voucherService.generateVoucherassStacts(custInfo, null, config_02);                                     //辅助账集合
		
		/** 1 :建立凭证体2-开始 */
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
		body_02.setAccountNumber(config_02);                 //这个科目
		body_02.setOriginalAmount(rent);         //原币金额 
		body_02.setEntryDC(CR);                              //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_02.setVoucherAbstract(voucherAbstract);      //摘要
		body_02.setCurrencyNumber(currencyNumber);        //币别数据字段对象
		body_02.setIntereasVoucherasStactsInAction(stactsList_02); //保存辅助账
		
		/** 建立凭证体2-结束 */
		
		bodyList.add(body_02);

		/************************************** 凭证体2-分割线-结束 ********************************************************/
		
		
		/************************************** 凭证体3-分割线-开始 ********************************************************/
		
		VoucherassStactsConfig config_03 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "224");        //凭证配置表-未确认融资收益
		List<IntereasVoucherasStacts> stactsList_03 = voucherService.generateVoucherassStacts(custInfo, null, config_03);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
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
		body_03.setOriginalAmount(interest);               //原币金额 
		body_03.setEntryDC(DR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_03.setVoucherAbstract(voucherAbstract);            //摘要
		body_03.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_03.setIntereasVoucherasStactsInAction(stactsList_03); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_03);

		/************************************** 凭证体3-分割线-结束 ********************************************************/
		
		/** 主营业务收入-租金利息收入*/
		/************************************** 凭证体4-分割线-开始 ********************************************************/
		//计算逻辑待确定
		BigDecimal interestTax=interest.divide(new BigDecimal(1.17),2,BigDecimal.ROUND_HALF_EVEN);//除以1.17
		VoucherassStactsConfig config_04 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "232");       //凭证配置表-主营业务收入-租金利息收入
		List<IntereasVoucherasStacts> stactsList_04 = voucherService.generateVoucherassStacts(custInfo, null, config_04);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_04 = new IntereasVoucherEntries();
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
		body_04.setAccountNumber(config_04);                       //这个科目对象
		body_04.setOriginalAmount(interestTax);               //原币金额 
		body_04.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_04.setVoucherAbstract(voucherAbstract);            //摘要
		body_04.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_04.setIntereasVoucherasStactsInAction(stactsList_04); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_04);

		/************************************** 凭证体4-分割线-结束 ********************************************************/
		
		/** 应交税费-应交增值税-销项税额*/
		/************************************** 凭证体5-分割线-开始 ********************************************************/
		//计算逻辑待确定
		BigDecimal outPutTaxInterest=interest.subtract(interestTax);
		VoucherassStactsConfig config_05 = this.baseService.findEntityByID(VoucherassStactsConfig.class, "238");    //凭证配置表-应交税费-应交增值税-销项税额
		List<IntereasVoucherasStacts> stactsList_05 = voucherService.generateVoucherassStacts(custInfo,null, config_05);                                     //辅助账集合

		/** 1 :建立凭证体1-开始 */
		IntereasVoucherEntries body_05 = new IntereasVoucherEntries();
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
		body_05.setAccountNumber(config_05);                       //这个科目对象
		body_05.setOriginalAmount(outPutTaxInterest);               //原币金额 
		body_05.setEntryDC(CR);                                    //借贷方向 （DR(1) 借方- CR(1) 贷方）
		body_05.setVoucherAbstract(voucherAbstract);            //摘要
		body_05.setCurrencyNumber(currencyNumber);                 //币别数据字段对象
		body_05.setIntereasVoucherasStactsInAction(stactsList_05); //保存辅助账
		
		/** 建立凭证体1-结束 */
		
		bodyList.add(body_05);

		/************************************** 凭证体5-分割线-结束 ********************************************************/
		
		
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
		headObj.setBizDate(contractFundRentPlan.getPlanDate());                       //业务发生日期
		headObj.setBookedDate(contractFundRentPlan.getPlanDate());                    //财务记账日期
		headObj.setVoucherType(voucherType);                 //凭证字
		headObj.setGenerate_date(currentDate);               //凭证发生日期
		headObj.setModleName(workFlowName);                  //当前流程名称
		headObj.setContract_id(contractFundRentPlan.getContractId());                        //业务合同号 【德银2013第1号】
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
