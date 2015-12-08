package com.business.controller.voucher;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.eas.VoucherToEas;
import com.business.entity.DictionaryData;
import com.business.entity.User;
import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.cust.CustInfoCompany;
import com.business.entity.util.OwnAccount;
import com.business.entity.voucher.IntereasVoucherEntries;
import com.business.entity.voucher.IntereasVoucherHead;
import com.business.entity.voucher.IntereasVoucherasStacts;
import com.business.entity.voucher.VoucherassStactsConfig;
import com.business.entity.voucher.VoucherassStactsInfo;
import com.business.service.VoucherToEasService;
import com.business.service.voucher.VoucherService;
import com.business.util.Tools;
import com.kernal.utils.SecurityUtil;


 

@Controller(value = "VouvherTest")
@RequestMapping(value = "/**/acl")
public class VoucherTest {
	@Resource(name = "voucherService")
	private VoucherService voucherService;
	
	@Resource(name = "voucherToEasService")
	private VoucherToEasService voucherToEasService;
	/**
	 * log4j日志 
	 */
	private static final Logger log = LoggerFactory.getLogger(VoucherTest.class);
	
	@RequestMapping(value = "/voucherDebug.acl")
	@ResponseBody
	public void voucherDebug (HttpServletRequest request, HttpServletResponse response) throws Exception {
		//http://localhost:9088/deewinfl/acl/voucherDebug.acl
		//voucherService.saveVoucher();
		
		voucherToEasService.saveVoucher(""); 
	}
	
	
	/**
	 * 凭证持久化主执行入口
	 * 凭证三张表：
	 * 凭证头：intereas_voucherhead
	 * 凭证体：intereas_voucherentries
	 * 辅助账：intereas_voucherasstacts
	 * 构建三张凭证前需要构建以下4个对象集合：
	 * 对象1：User 构建当前登录人信息对象(或者指定用户对象) 封装入凭证头中的‘制单人’选项中
	 * 对象2：VoucherassStactsInfo 辅助帐类型编码对象(select* from VOUCHERASSSTACTS_INFO)。 封装入：凭证头中‘凭证字’选项中
	 * 对象3：DictionaryData 币别数据字典对象( select * from  t_dicts_datas  where pid_ = 'currency_type';) 最终取的值是CODE_  封装入凭证体中的‘币别’选项中
	 * 对象4：CustInfo 客户对象 ,辅助账为客户情况下构建该对象。法人(或供应商)情况下需同时取出法人信息对象CustInfoCompany    封装入辅助账中‘CUST_ID_B’选项中
	 * 对象5: OwnAccount 本方账户信息对象 （如果对象2为‘03’则这里必须传入该对象信息）
	 * 每个凭证头必须传入参数如下：
	 * 参数1：belongUnit 所属公司对应UUID select * from INTER_ORGCODE
	 * 参数2：bizDate 业务发生日期
	 * 参数3：bookedDate 财务记账日期
	 * 参数4：voucherType 凭证类型（客户/经销商/银行账户/物料）
	 * 参数5：generateDate 凭证发生日期(系统当前时间或者根据客户财务规定的日期计算逻辑)
	 * 参数6：modleName 业务模块(凭证产生的模块流程名称)
	 * 参数7：contract_number 合同号(存在则比填，不存在则传空)
	 * 参数8：memo1 备注(存在则填，不存在则传空)
	 * 每个凭证体必须传入参数如下：
	 * 参数1：dictionaryData  币别数据字段对象
	 * 参数2：num_entrySeq 凭证体分录行号 (递增)
	 * 参数3：accountNumber 科目编码
	 * 参数4：originalAmount 原币金额 
	 * 参数5：voucherAbstract 摘要
	 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
	 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
	 * 每个辅助账必须传入参数如下：
	 * 参数1：voucherassStactsInfo 完整的辅助账类型编码对象
	 * 参数2：custInfo 完整的客户对象
	 * 参数3：intereasVoucherentries 该辅助账对应的凭证体的完整信息
	 * 参数4：headObj 该凭证体对应的凭证头完整的实体对象信息
	 * @author sea
	 * @param intereas_voucherhead 凭证头对象（封装有以上注释中所有参数信息）
	 * @throws Exception 
	 * @throws DataAccessException 
	 * @throws Exception 
	 * @throws DataAccessException 
	 */
	public boolean saveVoucher(HttpServletRequest request, HttpServletResponse response) throws DataAccessException, Exception{
		boolean flag = false;
		//参数通过request获取，或者通过传入也可以
		
		User user = (User) SecurityUtil.getPrincipal();
		//辅助帐类型对象
		/*		
			01	客户
			02	供应商
			03	银行账户
			04	预留
			05	职员
			06	预留
			07	行政组织
		 */
		VoucherassStactsInfo voucherassStactsInfo = new VoucherassStactsInfo();
		String asstActType = "01";
		int num = 0;
		if(!Tools.isNullOrEmpty(asstActType)){
			num = Integer.parseInt(asstActType);
			//根据凭证字获取对应的辅助帐类型对象 
			voucherassStactsInfo.setAsstActType(".....");
			
		}else{
			log.error("凭证字为空无法产生凭证!");
			return flag;
		}
		
		
		/**
		 * 凭证头构建示例：
		 * 参数1：belongUnit 所属公司对应UUID select * from INTER_ORGCODE
		 * 参数2：bizDate 业务发生日期
		 * 参数3：bookedDate 财务记账日期
		 * 参数4：voucherType 凭证字（01/02/03/04...）
		 * 参数5：generateDate 凭证发生日期(系统当前时间或者根据客户财务规定的日期计算逻辑)
		 * 参数6：modleName 业务模块(凭证产生的模块流程名称)
		 * 参数7：contract_number 合同号(存在则比填，不存在则传空)
		 * 参数8：memo1 备注(存在则填，不存在则传空)
		 */
		IntereasVoucherHead headObj = new IntereasVoucherHead();
		headObj.setBelong_unit("58695815-1");//参数1：所属公司组织机构代码
		headObj.setBizDate("2013-11-14");//业务发生日期
		headObj.setBookedDate("2013-11-14");//财务记账日期
		//默认四个字：记账凭证
		DictionaryData obj = new DictionaryData();
		obj.setName("记账凭证");
		headObj.setVoucherType(obj);//凭证字
		
		headObj.setGenerate_date("2013-11-14");//凭证发生日期
		headObj.setModleName("付款流程***付款");
		String contractNumber = "****合同";
		ContractInfo contractObj = new ContractInfo();
		contractObj.setContractNumber(contractNumber);
		headObj.setContract_id(contractObj);//合同号
		
		
		/**
		 * <p>业务用凭证体集合,不存库</p>
		 * @param intereasVoucherEntriesInAction
		 */
		List<IntereasVoucherEntries> IntereasVoucherEntriesInAction  = new ArrayList<IntereasVoucherEntries>();
		/**
		 * 业务用辅助账集合
		 */
		List<IntereasVoucherasStacts> intereasVoucherasStactsInAction  = new ArrayList<IntereasVoucherasStacts>();
		
		
		/**
		 * 凭证体参数构建示例:
		 * 参数1：dictionaryData  币别数据字段对象
		 * 参数2：num_entrySeq 凭证体分录行号 (德银暂时不传入该参数) 
		 * 参数3：accountNumber 科目编码
		 * 参数4：originalAmount 原币金额 
		 * 参数5：voucherAbstract 摘要
		 * 参数6：entryDC 借贷方向 （1 借方-1 贷方）
		 * 参数7：headObj 该凭证体对应的凭证头完整的实体对象信息
		 */
		//币别对象
		DictionaryData dictionaryData = new DictionaryData();
		//人民币 currency_type1 , 美元    currency_type2  (select * from  T_DICTS_DATAS where CODE_ = '')
		dictionaryData.setCode("currency_type1");
		VoucherassStactsConfig accountNumber = new VoucherassStactsConfig();
		accountNumber.setSubjectsCode("1002");
		//构建凭证体1需要的参数:
		IntereasVoucherEntries entrie1 = new IntereasVoucherEntries();
		entrie1.setCurrencyNumber(dictionaryData);//币别数据字段对象
		entrie1.setAccountNumber(accountNumber);//这个科目，姚准备做一个可配置化的表，具体的请咨询姚
		BigDecimal originalAmount = new BigDecimal(1200.00);
		entrie1.setOriginalAmount( originalAmount );//原币金额 
		entrie1.setEntryDC(1);//借贷方向 （1 借方-1 贷方）
		
		//这段代码是否存在替代的可能性，但是凭证辅助账里又要存客户或者银行账号这个对象，所以我想既然要构建这个2个对象为什么不一次构建一个完整的传入
		//但是辅助账存在多个，因此可能存在多个客户，每次辅助账其实都存在构建一个客户对象的概念
		//01/02 客户对象
		CustInfo custInfo = new CustInfo();
		//03 我方银行账户对象
		OwnAccount ownAccount = new OwnAccount();
		//根据凭证字不同获取不同的对象数据及格式
		switch(num) 
		{ 
			case 1://客户
				custInfo.setCustNumber("客户编号");
				//根据客户编号构建完整的客户信息对象
				
			break; 
			case 2://经销商
				custInfo.setCustNumber("客户编号");
				//根据客户编号构建完整的客户信息对象
				
			break; 
			case 3://银行账户
				//根据银行账号什么的构建银行对象
				ownAccount.setAccNumber("");
				
			break; 
			case 4://预留
				log.debug("预留凭证字4"); 
			break; 
			case 5://职员
				log.debug("预留凭证字5"); 
			break; 
			case 6://预留
				log.debug("预留凭证字6"); 
			break; 
			case 7://行政组织
				log.debug("预留凭证字7"); 
			break; 
			default://other
				log.debug("预留凭证字类型"); 
			break; 
		}
		
		String cust_name = "";
		//法人情况下需要获取法人代表名称
		if("CUST_INFO_COMPANY".equals(custInfo.getCustClass().getCode())){
			//获取法人信息
			CustInfoCompany custInfoCompany = custInfo.getCustInfoCompany();
			//法人代表
			cust_name = custInfoCompany.getLegalRepresentative();
		}
		//注意凭证体1的摘要跳到这里获取摘要信息
		//构建摘要
		String voucherAbstract = "确认客户‘"+cust_name+"’-预收账款-首付款‘"+Tools.formatNumberDoubleTwo( String.valueOf(originalAmount) )+"’";
		entrie1.setVoucherAbstract(voucherAbstract);
		//封装凭证体1
		IntereasVoucherEntriesInAction.add(entrie1);
		
		
		/**
		 * 辅助账构建参数示例：
		 * 参数1：voucherassStactsInfo 完整的辅助账类型编码对象
		 * 参数2：custInfo 完整的客户对象
		 * 参数3：intereasVoucherentries 该辅助账对应的凭证体的完整信息
		 * 参数4：headObj 该凭证体对应的凭证头完整的实体对象信息
		 */
		IntereasVoucherasStacts stacts1 = new IntereasVoucherasStacts();
		stacts1.setAsstActType(voucherassStactsInfo);
		stacts1.setCustIdB(custInfo);
		stacts1.setOwnAccount(ownAccount);
		//
		intereasVoucherasStactsInAction.add(stacts1);
		
		
		//构建第二个凭证体开始
		
		//构建第二个辅助账开始
		
		
		//结束
		List<IntereasVoucherHead> list = new ArrayList<IntereasVoucherHead>();
		list.add(headObj);
		//调用主方法
		voucherService.saveVoucherMain(list);
		return flag;
	}
	
}
