package com.business.eas;


import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.business.easEntity.ServiceInfo;
import com.business.entity.User;
import com.business.entity.voucher.IntereasVoucherHead;
import com.business.entity.voucher.IntereasVoucherLog;
import com.business.service.VoucherToEasService;
import com.business.service.voucher.VoucherService;
import com.business.util.Tools;
import com.client.WSContext;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
import com.ormrpc.services.WSWSVoucher.WSWSVoucherSrvProxyServiceLocator;
import com.wsvoucher.client.WSInvokeException;
import com.wsvoucher.client.WSWSVoucher;


/**
 * <p>凭证导入至金蝶EAS财务系统中的接口程序。</p>
 * <p>2013-11-11</p>
 * @author sea
 * @version 4.5
 */
public class VoucherToEas {
	@Resource(name = "voucherToEasService")
	private VoucherToEasService voucherToEasService;
	
	/**
	 * log4j日志 
	 */
	private static final Logger log = LoggerFactory.getLogger(VoucherToEas.class);

	private static ServiceInfo service;
	
	/**
	  * <p>据根据接口规范文档组装业务系统凭证数据用于导入KINGDEE`EAS主执行方法。</p>
	  * @author sea
	  * @param hsql
	  * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public void imVoucher(String hsql) throws Exception{
		WSWSVoucher[] vouchers = null;
		service = new ServiceInfo();
		//获取WEBSERVICE的url地址
		String server = service.getServerName();
		java.net.URL endpiont = null;
		
		int verify = 2;//0 不核销暂存  ， 1核销暂存 ，2不核销提交 ，3 核销提交
		int cashflow = 0;
		//
		WSWSVoucherSrvProxyServiceLocator locator = new WSWSVoucherSrvProxyServiceLocator();
		
		//构建凭证信息
		List<IntereasVoucherHead> hedObj_l = voucherToEasService.queryHead(hsql);
		for(IntereasVoucherHead oneObj : hedObj_l){
			vouchers = voucherToEasService.getVouchers(oneObj);
		}
		
		
		//测试方法
		vouchers = this.getVouchersTest();
		//vouchers = this.getVouchersTest_cust();
		
		//
		try {
			//登陆方式1:
			//EasLogin easLogin = new EasLogin();
			//WSContext cxt = easLogin.doEASLogin(service);
			//登陆方式2:
			LoginTest loginTest = new LoginTest();
			WSContext cxt = loginTest.login();
			if(!"".equals(cxt) && cxt != null){
				log.info("登陆信息:"+cxt);
				log.info(""+cxt.getUserName());
				log.info(""+cxt.getPassword());
				log.info(""+cxt.getSessionId());
			}
			//调用凭证接口
			endpiont = new java.net.URL(server+"WSWSVoucher");
			//[[20131113181578, null, 0, 0, 1001, 凭证20131113181578没有找到公司:58695815-1, null]]
			String[][] ls = locator.getWSWSVoucher().importVoucher(vouchers, verify, cashflow);
			//返回值：宽度是5的字符串数据
			/* [[20131113181578, null, 0, 0, 1001, 凭证20131113181578没有找到公司:58695815-1, null]]
			 * 宽度定义：外部系统凭证号，凭证字，年度，期限，处理信息，异常信息，金蝶返回凭证号
			 * 1：凭证号：第三方系统自身产生的凭证号
			 * 2：凭证字：第三方系统自身产生的凭证字
			 * 3：年度：第三方系统自身产生的会计年度
			 * 4：期间：第三方系统自身产生的会计期间
			 * 5:处理信息：0000表示成功，其余的请看文档，太多不写了！
			 * 6：异常信息isVerify：应该是EAS在保存凭证时产生的异常，如校验不通过产生的提示信息等
			 * 7:金蝶返回的凭证号：EAS产生的凭证号
			*/
			log.info("凭证号："+ls[0][0]);
			log.info("凭证字："+ls[0][1]);
			log.info("年度："+ls[0][2]);
			log.info("期间："+ls[0][3]);
			log.info("处理信息："+ls[0][4]);
			log.info("异常信息："+ls[0][5]);
			log.info("金蝶返回的凭证号："+ls[0][6]);
			//
			voucherToEasService.saveLog(ls);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WSInvokeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	
	
	private WSWSVoucher[] getVouchersTest(){
		WSWSVoucher[] vouchers = new WSWSVoucher[3];
		//凭证头必须传入字段
		String companyNumber = "0101";//公司编码:58695815-1
		String bookedDate = "2013-12-01";//记账日期
		String bizDate = "2013-12-01";//业务日期
		int periodYear = 2013;//会计期间-年
		int periodNumber = 12;//会计期间-月
		String voucherType = "记账凭证";//凭证字
		String voucherNumber = "20131113181578";//凭证号
		String creator = "李光美";//制单人
		
		//艾则孜·塔衣尔 收到徐州昌润汽车贸易有限公司首付款
		//凭证体必须传入字段
		int entrySeq = 1;//分录行号	
		String voucherAbstract = "确认徐州昌润汽车贸易有限公司逾期利息";//摘要	
		String accountNumber = "2203";//科目	
		String currencyNumber = "BB01";//币种	
		int entryDC = 1;//方向	1 借方-1 贷方
		double originalAmount = 0;//原币金额	
		double debitAmount = 0;//借方金额	
		double creditAmount = 0;//贷方金额	
		int asstSeq	= 0;//辅助账行号	否
		
		//辅助账必须传入字段
		String asstActType1	 = "";//核算项目1
		String asstActNumber1 = "";//核算对象编码1
		String asstActName1 = "";//核算对象名称1
		
		WSWSVoucher wswsVoucher1 = new WSWSVoucher();
		//EAS凭证头对象构建
		wswsVoucher1.setCompanyNumber(companyNumber);
		wswsVoucher1.setBookedDate(bookedDate);
		wswsVoucher1.setBizDate(bizDate);
		wswsVoucher1.setPeriodYear(periodYear);
		wswsVoucher1.setPeriodNumber(periodNumber);
		wswsVoucher1.setVoucherType(voucherType);
		wswsVoucher1.setVoucherNumber(voucherNumber);
		wswsVoucher1.setCreator(creator);
		
		//凭证体1：借
		wswsVoucher1.setEntrySeq(1);//分录行号	
		wswsVoucher1.setVoucherAbstract(voucherAbstract);//摘要	
		wswsVoucher1.setAccountNumber("1461.01");//科目	
		wswsVoucher1.setCurrencyNumber(currencyNumber);//币种
		wswsVoucher1.setEntryDC(1);//方向	1 借方-1 贷方
		wswsVoucher1.setOriginalAmount(100);//原币金额	
		wswsVoucher1.setDebitAmount(100);//借方金额	
		wswsVoucher1.setCreditAmount(0);//贷方金额	
		//辅助1：
		wswsVoucher1.setAsstSeq(1);//辅助账行号	否
		wswsVoucher1.setAsstActType1("客户");//核算项目1
		wswsVoucher1.setAsstActNumber1("01000012");//核算对象编码1
		wswsVoucher1.setAsstActName1("徐州昌润汽车贸易有限公司");//核算对象名称1
		
		vouchers[0] = wswsVoucher1;
		
		WSWSVoucher wswsVoucher2 = new WSWSVoucher();
		//EAS凭证头对象构建
		wswsVoucher2.setCompanyNumber(companyNumber);
		wswsVoucher2.setBookedDate(bookedDate);
		wswsVoucher2.setBizDate(bizDate);
		wswsVoucher2.setPeriodYear(periodYear);
		wswsVoucher2.setPeriodNumber(periodNumber);
		wswsVoucher2.setVoucherType(voucherType);
		wswsVoucher2.setVoucherNumber(voucherNumber);
		wswsVoucher2.setCreator(creator);
		//凭证体2：贷
		wswsVoucher2.setEntrySeq(2);
		wswsVoucher2.setVoucherAbstract(voucherAbstract);
		wswsVoucher2.setAccountNumber("6001.03");//
		wswsVoucher2.setCurrencyNumber(currencyNumber);
		wswsVoucher2.setEntryDC(-1);
		wswsVoucher2.setOriginalAmount(50);
		wswsVoucher2.setDebitAmount(0);
		wswsVoucher2.setCreditAmount(50);
		//辅助2：
		wswsVoucher2.setAsstSeq(1);//辅助核算行号
		wswsVoucher2.setAsstActType1("客户");
		wswsVoucher2.setAsstActNumber1("01000012");
		wswsVoucher2.setAsstActName1("徐州昌润汽车贸易有限公司");

		vouchers[1] = wswsVoucher2;
		
		WSWSVoucher wswsVoucher3 = new WSWSVoucher();
		//EAS凭证头对象构建
		wswsVoucher3.setCompanyNumber(companyNumber);
		wswsVoucher3.setBookedDate(bookedDate);
		wswsVoucher3.setBizDate(bizDate);
		wswsVoucher3.setPeriodYear(periodYear);
		wswsVoucher3.setPeriodNumber(periodNumber);
		wswsVoucher3.setVoucherType(voucherType);
		wswsVoucher3.setVoucherNumber(voucherNumber);
		wswsVoucher3.setCreator(creator);
		//凭证体3：贷
		wswsVoucher3.setEntrySeq(3);
		wswsVoucher3.setVoucherAbstract(voucherAbstract);
		wswsVoucher3.setAccountNumber("2221.01.01");
		wswsVoucher3.setCurrencyNumber(currencyNumber);
		wswsVoucher3.setEntryDC(-1);
		wswsVoucher3.setOriginalAmount(50);
		wswsVoucher3.setDebitAmount(0);
		wswsVoucher3.setCreditAmount(50);
		vouchers[2] = wswsVoucher3;
		
		return vouchers;
	}
	
	
	/**
	  * <p>1借1贷不带辅助。</p>
	  * @author sea
	  * @return
	 */
	private WSWSVoucher[] getVouchersTest1(){
		WSWSVoucher[] vouchers = new WSWSVoucher[2];
		//凭证头必须传入字段
		String companyNumber = "0101";//公司编码:58695815-1
		String bookedDate = "2013-11-13";//记账日期
		String bizDate = "2013-11-13";//业务日期
		int periodYear = 2013;//会计期间-年
		int periodNumber = 11;//会计期间-月
		String voucherType = "记账凭证";//凭证字
		String voucherNumber = "20131113181578";//凭证号
		String creator = "李光美";//制单人
		
		//凭证体必须传入字段
		int entrySeq = 1;//分录行号	
		String voucherAbstract = "应交税费-应交增值税-转出未交增值税";//摘要	
		String accountNumber = "2203";//科目	
		String currencyNumber = "BB01";//币种	
		int entryDC = 1;//方向	1 借方-1 贷方
		double originalAmount = 0;//原币金额	
		double debitAmount = 0;//借方金额	
		double creditAmount = 0;//贷方金额	
		int asstSeq	= 0;//辅助账行号	否
		
		//辅助账必须传入字段
		String asstActType1	 = "";//核算项目1
		String asstActNumber1 = "";//核算对象编码1
		String asstActName1 = "";//核算对象名称1
		
		WSWSVoucher wswsVoucher1 = new WSWSVoucher();
		//EAS凭证头对象构建
		wswsVoucher1.setCompanyNumber(companyNumber);
		wswsVoucher1.setBookedDate(bookedDate);
		wswsVoucher1.setBizDate(bizDate);
		wswsVoucher1.setPeriodYear(periodYear);
		wswsVoucher1.setPeriodNumber(periodNumber);
		wswsVoucher1.setVoucherType(voucherType);
		wswsVoucher1.setVoucherNumber(voucherNumber);
		wswsVoucher1.setCreator(creator);
		
		//2221.01.03 应交税费-应交增值税-转出未交增值税
		//凭证体1：借
		wswsVoucher1.setEntrySeq(1);//分录行号	
		wswsVoucher1.setVoucherAbstract(voucherAbstract);//摘要	
		wswsVoucher1.setAccountNumber("2221.01.03");//科目	
		wswsVoucher1.setCurrencyNumber(currencyNumber);//币种
		wswsVoucher1.setEntryDC(1);//方向	1 借方-1 贷方
		wswsVoucher1.setOriginalAmount(488585.58);//原币金额	
		wswsVoucher1.setDebitAmount(488585.58);//借方金额	
		wswsVoucher1.setCreditAmount(0);//贷方金额	
		//wswsVoucher1.setAsstSeq(1);//辅助账行号	否
		vouchers[0] = wswsVoucher1;
		
		//2221.01.04 应交税费-应交增值税-未交增值税
		WSWSVoucher wswsVoucher2 = new WSWSVoucher();
		//EAS凭证头对象构建
		wswsVoucher2.setCompanyNumber(companyNumber);
		wswsVoucher2.setBookedDate(bookedDate);
		wswsVoucher2.setBizDate(bizDate);
		wswsVoucher2.setPeriodYear(periodYear);
		wswsVoucher2.setPeriodNumber(periodNumber);
		wswsVoucher2.setVoucherType(voucherType);
		wswsVoucher2.setVoucherNumber(voucherNumber);
		wswsVoucher2.setCreator(creator);
		//凭证体2：贷
		wswsVoucher2.setEntrySeq(2);
		wswsVoucher2.setVoucherAbstract(voucherAbstract);
		wswsVoucher2.setAccountNumber("2221.01.04");
		wswsVoucher2.setCurrencyNumber(currencyNumber);
		wswsVoucher2.setEntryDC(-1);
		wswsVoucher2.setOriginalAmount(488585.58);
		wswsVoucher2.setDebitAmount(0);
		wswsVoucher2.setCreditAmount(488585.58);
		vouchers[1] = wswsVoucher2;
		
		
		return vouchers;
	}
	
	private WSWSVoucher[] getVouchersTest_bank(){
		WSWSVoucher[] vouchers = new WSWSVoucher[2];
		//凭证头必须传入字段
		String companyNumber = "0101";//公司编码:58695815-1
		String bookedDate = "2013-11-13";//记账日期
		String bizDate = "2013-11-13";//业务日期
		int periodYear = 2013;//会计期间-年
		int periodNumber = 11;//会计期间-月
		String voucherType = "记账凭证";//凭证字
		String voucherNumber = "20131113181578";//凭证号
		String creator = "李光美";//制单人
		
		//凭证体必须传入字段
		int entrySeq = 1;//分录行号	
		String voucherAbstract = "应交税费-应交增值税-转出未交增值税";//摘要	
		String accountNumber = "2203";//科目	
		String currencyNumber = "BB01";//币种	
		int entryDC = 1;//方向	1 借方-1 贷方
		double originalAmount = 0;//原币金额	
		double debitAmount = 0;//借方金额	
		double creditAmount = 0;//贷方金额	
		int asstSeq	= 0;//辅助账行号	否
		
		//辅助账必须传入字段
		String asstActType1	 = "";//核算项目1
		String asstActNumber1 = "";//核算对象编码1
		String asstActName1 = "";//核算对象名称1
		
		WSWSVoucher wswsVoucher1 = new WSWSVoucher();
		//EAS凭证头对象构建
		wswsVoucher1.setCompanyNumber(companyNumber);
		wswsVoucher1.setBookedDate(bookedDate);
		wswsVoucher1.setBizDate(bizDate);
		wswsVoucher1.setPeriodYear(periodYear);
		wswsVoucher1.setPeriodNumber(periodNumber);
		wswsVoucher1.setVoucherType(voucherType);
		wswsVoucher1.setVoucherNumber(voucherNumber);
		wswsVoucher1.setCreator(creator);
		
		//2221.01.03 应交税费-应交增值税-转出未交增值税
		//凭证体1：借
		wswsVoucher1.setEntrySeq(1);//分录行号	
		wswsVoucher1.setVoucherAbstract(voucherAbstract);//摘要	
		wswsVoucher1.setAccountNumber("1002.03");//科目	
		wswsVoucher1.setCurrencyNumber(currencyNumber);//币种
		wswsVoucher1.setEntryDC(1);//方向	1 借方-1 贷方
		wswsVoucher1.setOriginalAmount(100);//原币金额	
		wswsVoucher1.setDebitAmount(100);//借方金额	
		wswsVoucher1.setCreditAmount(0);//贷方金额	
		vouchers[0] = wswsVoucher1;
		
		//辅助1：
		wswsVoucher1.setAsstSeq(1);//辅助账行号	否
		wswsVoucher1.setAsstActType1("银行账户");//核算项目1
		wswsVoucher1.setAsstActNumber1("010101016353");//核算对象编码1
		wswsVoucher1.setAsstActName1("德银上海浦发基本户(6353)");//核算对象名称1
		
		
		//2221.01.04  
		WSWSVoucher wswsVoucher2 = new WSWSVoucher();
		//EAS凭证头对象构建
		wswsVoucher2.setCompanyNumber(companyNumber);
		wswsVoucher2.setBookedDate(bookedDate);
		wswsVoucher2.setBizDate(bizDate);
		wswsVoucher2.setPeriodYear(periodYear);
		wswsVoucher2.setPeriodNumber(periodNumber);
		wswsVoucher2.setVoucherType(voucherType);
		wswsVoucher2.setVoucherNumber(voucherNumber);
		wswsVoucher2.setCreator(creator);
		//凭证体2：贷
		wswsVoucher2.setEntrySeq(2);
		wswsVoucher2.setVoucherAbstract(voucherAbstract);
		wswsVoucher2.setAccountNumber("2221.01.04");
		wswsVoucher2.setCurrencyNumber(currencyNumber);
		wswsVoucher2.setEntryDC(-1);
		wswsVoucher2.setOriginalAmount(100);
		wswsVoucher2.setDebitAmount(0);
		wswsVoucher2.setCreditAmount(100);
		vouchers[1] = wswsVoucher2;
		
		
		return vouchers;
	}
	
	//供应商
	private WSWSVoucher[] getVouchersTest_cust(){
		WSWSVoucher[] vouchers = new WSWSVoucher[2];
		//凭证头必须传入字段
		String companyNumber = "0101";//公司编码:58695815-1
		String bookedDate = "2013-11-13";//记账日期
		String bizDate = "2013-11-13";//业务日期
		int periodYear = 2013;//会计期间-年
		int periodNumber = 11;//会计期间-月
		String voucherType = "记账凭证";//凭证字
		String voucherNumber = "20131113181578";//凭证号
		String creator = "李光美";//制单人
		
		//凭证体必须传入字段
		int entrySeq = 1;//分录行号	
		String voucherAbstract = "应交税费-应交增值税-转出未交增值税";//摘要	
		String accountNumber = "2203";//科目	
		String currencyNumber = "BB01";//币种	
		int entryDC = 1;//方向	1 借方-1 贷方
		double originalAmount = 0;//原币金额	
		double debitAmount = 0;//借方金额	
		double creditAmount = 0;//贷方金额	
		int asstSeq	= 0;//辅助账行号	否
		
		//辅助账必须传入字段
		String asstActType1	 = "";//核算项目1
		String asstActNumber1 = "";//核算对象编码1
		String asstActName1 = "";//核算对象名称1
		
		WSWSVoucher wswsVoucher1 = new WSWSVoucher();
		//EAS凭证头对象构建
		wswsVoucher1.setCompanyNumber(companyNumber);
		wswsVoucher1.setBookedDate(bookedDate);
		wswsVoucher1.setBizDate(bizDate);
		wswsVoucher1.setPeriodYear(periodYear);
		wswsVoucher1.setPeriodNumber(periodNumber);
		wswsVoucher1.setVoucherType(voucherType);
		wswsVoucher1.setVoucherNumber(voucherNumber);
		wswsVoucher1.setCreator(creator);
		
		//2221.01.03 应交税费-应交增值税-转出未交增值税
		//凭证体1：借
		wswsVoucher1.setEntrySeq(1);//分录行号	
		wswsVoucher1.setVoucherAbstract(voucherAbstract);//摘要	
		wswsVoucher1.setAccountNumber("1123");//科目	
		wswsVoucher1.setCurrencyNumber(currencyNumber);//币种
		wswsVoucher1.setEntryDC(1);//方向	1 借方-1 贷方
		wswsVoucher1.setOriginalAmount(100);//原币金额	
		wswsVoucher1.setDebitAmount(100);//借方金额	
		wswsVoucher1.setCreditAmount(0);//贷方金额	
		vouchers[0] = wswsVoucher1;
		
		//辅助1：
		wswsVoucher1.setAsstSeq(1);//辅助账行号	否
		wswsVoucher1.setAsstActType1("供应商");//核算项目1
		wswsVoucher1.setAsstActNumber1("01000012");//核算对象编码1
		wswsVoucher1.setAsstActName1("徐州昌润汽车贸易有限公司");//核算对象名称1
		
		
		//2221.01.04  
		WSWSVoucher wswsVoucher2 = new WSWSVoucher();
		//EAS凭证头对象构建
		wswsVoucher2.setCompanyNumber(companyNumber);
		wswsVoucher2.setBookedDate(bookedDate);
		wswsVoucher2.setBizDate(bizDate);
		wswsVoucher2.setPeriodYear(periodYear);
		wswsVoucher2.setPeriodNumber(periodNumber);
		wswsVoucher2.setVoucherType(voucherType);
		wswsVoucher2.setVoucherNumber(voucherNumber);
		wswsVoucher2.setCreator(creator);
		//凭证体2：贷
		wswsVoucher2.setEntrySeq(2);
		wswsVoucher2.setVoucherAbstract(voucherAbstract);
		wswsVoucher2.setAccountNumber("2221.01.04");
		wswsVoucher2.setCurrencyNumber(currencyNumber);
		wswsVoucher2.setEntryDC(-1);
		wswsVoucher2.setOriginalAmount(1000);
		wswsVoucher2.setDebitAmount(0);
		wswsVoucher2.setCreditAmount(1000);
		vouchers[1] = wswsVoucher2;
		
		
		return vouchers;
	}
	
	public static void main(String[] args) {
		VoucherToEas voucherToEas = new VoucherToEas();
		
		try {
			voucherToEas.imVoucher("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
