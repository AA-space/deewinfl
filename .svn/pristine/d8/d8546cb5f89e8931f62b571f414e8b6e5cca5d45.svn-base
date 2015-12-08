package com.business.serviceImpl;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.business.dao.BaseDao;
import com.business.eas.LoginTest;
import com.business.easEntity.ServiceInfo;
import com.business.entity.User;
import com.business.entity.util.OwnAccount;
import com.business.entity.voucher.IntereasVoucherEntries;
import com.business.entity.voucher.IntereasVoucherHead;
import com.business.entity.voucher.IntereasVoucherLog;
import com.business.entity.voucher.IntereasVoucherasStacts;
import com.business.service.VoucherToEasService;
import com.business.service.voucher.IntereasVoucherheadService;
import com.business.util.Tools;
import com.client.WSContext;
import com.kernal.utils.DateUtil;
import com.kernal.utils.SecurityUtil;
import com.ormrpc.services.WSWSVoucher.WSWSVoucherSrvProxyServiceLocator;
import com.wsvoucher.client.WSInvokeException;
import com.wsvoucher.client.WSWSVoucher;


@Service(value="voucherToEasService")
public class VoucherToEasServiceImpl extends AbstractBaseServiceImpl  implements VoucherToEasService {
	
	/**
	 * 记录log4j
	 */
	private Logger log = Logger.getLogger(VoucherToEasServiceImpl.class);
	/**
	 * 持久化服务
	 */
	@Resource
	private BaseDao baseDao;
	
	@Override
	public BaseDao getBussinessDao() throws Exception {
		return baseDao;
	}
	/**
	 * 金蝶EAS系统登陆信息
	 */
	private static ServiceInfo service;
	
	/**
	 * 注入凭证头服务接口
	 */
	@Resource(name="intereasVoucherheadService")
	private IntereasVoucherheadService intereasVoucherheadService;
	
	/*
	 * @author sea
	 */
	public List<IntereasVoucherHead> queryHead(String hsql) throws Exception{
		List<IntereasVoucherHead> head_l = new ArrayList<IntereasVoucherHead>();
		if(Tools.isNullOrEmpty(hsql)){
			//查询所有未导出的
			hsql = " from IntereasVoucherHead where status = ? and eas_flag = ?  ";
		}
		//查询所有待导出的凭证对象信息
		head_l = this.getBussinessDao().findResultsByHSQL(hsql, "已完整","0");
		
		return head_l;
	}
	
	/*
	 * @author sea
	 */
	public WSWSVoucher[] getVouchers(IntereasVoucherHead hedObj) throws DataAccessException, Exception{
		User currentUser = SecurityUtil.getPrincipal();   
		WSWSVoucher[] vouchers = null;
		if(hedObj == null){
			log.error("不存在凭证导入数据信息!");
			return vouchers;
		}else{
			vouchers = null;
		}
		//取出每一个凭证头对象信息
		IntereasVoucherHead tempHeadObj = hedObj;
		
		//凭证头下属凭证体信息集合
		Set<IntereasVoucherEntries> tempEntries_l = tempHeadObj.getIntereasVoucherEntries();
		if(tempEntries_l.size() > 0){
			vouchers = new  WSWSVoucher[tempEntries_l.size()];
			//取出每个对应的下属凭证体
			int i = 0;
			for (IntereasVoucherEntries tempEntries : tempEntries_l ) {
				/**
				 * 金蝶系统的原则是每一行凭证体表示一个完整的凭证分录，必须要把凭证头带入每个分录的最前方,才算完整的分录信息
				 */
				//EAS提供的对象封装方法
				WSWSVoucher wswsVoucher = new WSWSVoucher();
				//科目中有银行存款或摘要中有首付款附件数为1，其他为0
				if(tempEntries.getAccountNumber().getSubjectsName().contains("银行存款")||tempEntries.getVoucherAbstract().contains("首付款")){
					wswsVoucher.setAttaches(1);
				}else{
					wswsVoucher.setAttaches(0);
				}
				
				//EAS凭证头对象构建
				wswsVoucher.setCompanyNumber(tempHeadObj.getCompanyNumber().getOrgCode());//公司编码
				//全部取记账日期（业务日期）
				wswsVoucher.setBookedDate(Tools.getDBDateStr( tempHeadObj.getBizDate() ) );//记账日期
				wswsVoucher.setBizDate(Tools.getDBDateStr( tempHeadObj.getBizDate() ) );//业务日期
				wswsVoucher.setPeriodYear( Integer.parseInt( tempHeadObj.getPeriodYear() ) );//会计期间-年
				wswsVoucher.setPeriodNumber( Integer.parseInt( tempHeadObj.getPeriodNumber() ) );//会计期间-月
				wswsVoucher.setVoucherType(tempHeadObj.getVoucherType().getName());//凭证字(凭证类型)
				wswsVoucher.setVoucherNumber(tempHeadObj.getVoucherNumber());//凭证号
				//TODO:制单人这里是传入用户名称还是用户编号 待确定?
				//wswsVoucher.setCreator(tempHeadObj.getCreator().getUsername());//制单人
				//wswsVoucher.setCreator(tempHeadObj.getCreator().getRealname());//制单人
				wswsVoucher.setCreator(currentUser.getRealname());//制单人,谁导出谁是制单人 edit by jason 2014年4月15日
				//凭证体封装开始：
				wswsVoucher.setEntrySeq(Integer.parseInt( tempEntries.getEntrySeq() ));//分录行号	
				wswsVoucher.setVoucherAbstract(tempEntries.getVoucherAbstract());//摘要	
				wswsVoucher.setAccountNumber(tempEntries.getAccountNumber().getSubjectsCode());//科目	
				wswsVoucher.setCurrencyNumber(tempEntries.getCurrencyNumber().getDescription());//币种
				wswsVoucher.setEntryDC(tempEntries.getEntryDC());//方向	1 借方-1 贷方
				wswsVoucher.setOriginalAmount(Double.parseDouble(String.valueOf( tempEntries.getOriginalAmount() )) );//原币金额	
				wswsVoucher.setDebitAmount(Double.parseDouble(String.valueOf( tempEntries.getDebitAmount() )) );//借方金额	
				wswsVoucher.setCreditAmount(Double.parseDouble(String.valueOf( tempEntries.getCreditAmount() )) );//贷方金额	
				
//					/*****************现金流******************/
//				   int itemflag = tempEntries.getItemflag();//1情况下方字段请填写，0情况下方这10个值都为空
//				   //TODO:现金流暂时无法传入，金蝶问题
//				   itemflag = 0;
//				   
//				   int localAccountSeq = 0;//借是1，贷是2 
//				   int oppAccountSeq = 0;//借是1，贷是2 
//				   String primaryItem = "";//对方分录号是1时：01.01.01；对方分录号是2时：01.02.01
//				   String supplyItem = "";
//				   BigDecimal cashflowAmountOriginal = new BigDecimal("0");//取银行数
//				   BigDecimal cashflowAmountLocal = new BigDecimal("0");//取银行数
//				   BigDecimal cashflowAmountRpt = new BigDecimal("0");//取银行数
//				   int primaryCoef = 0;//默认值1
//				   int supplyCoef = 0;//默认值0
//				   String cashflowProperties = "";//取汉字 “外部”
//				   if(itemflag == 1){
//					    localAccountSeq = tempEntries.getLocalAccountSeq();//借是1，贷是2 
//					    oppAccountSeq = tempEntries.getOppAccountSeq();//借是1，贷是2 
//					    primaryItem = tempEntries.getPrimaryItem();//对方分录号是1时：01.01.01；对方分录号是2时：01.02.01
//					    supplyItem = tempEntries.getSupplyItem();
//					    cashflowAmountOriginal = tempEntries.getCashflowAmountOriginal();//取银行数
//					    cashflowAmountLocal = tempEntries.getCashflowAmountLocal();//取银行数
//					    cashflowAmountRpt = tempEntries.getCashflowAmountRpt();//取银行数
//					    primaryCoef = tempEntries.getPrimaryCoef();//默认值1
//					    supplyCoef = tempEntries.getSupplyCoef();//默认值0
//					    cashflowProperties = tempEntries.getCashflowProperties();//取汉字 “外部”
//					    //
//					    wswsVoucher.setItemFlag(itemflag);
//					    wswsVoucher.setOppAccountSeq(oppAccountSeq);
//					    wswsVoucher.setPrimaryItem(primaryItem);
//					    wswsVoucher.setSupplyItem(supplyItem);
//					    wswsVoucher.setCashflowAmountOriginal(Double.parseDouble(String.valueOf(  cashflowAmountOriginal  )));
//					    wswsVoucher.setCashflowAmountLocal(Double.parseDouble(String.valueOf(  cashflowAmountLocal  )));
//					    wswsVoucher.setCashflowAmountRpt(Double.parseDouble(String.valueOf(  cashflowAmountRpt  )));
//					    wswsVoucher.setPrimaryCoef(primaryCoef);
//					    wswsVoucher.setSupplyCoef(supplyCoef);
//				   }else{//为空情况
//					   //ITEMFLAG为0表示不传现金流流量信息
//				   }
//				   /*****************现金流******************/
			   
				//方式2：凭证体下属辅助账集合
				//Set<IntereasVoucherasStacts> tempStacts_l = tempEntries.getIntereasVoucherasStacts();
				//List<IntereasVoucherasStacts> intereasVoucherasStactsInAction = tempEntries.getIntereasVoucherasStactsInAction();
			   List<IntereasVoucherasStacts> intereasVoucherasStactsInAction = new ArrayList<IntereasVoucherasStacts>();
			   
			   intereasVoucherasStactsInAction.addAll(tempEntries.getIntereasVoucherasStacts());
			   
				for (int j = 0; j < intereasVoucherasStactsInAction.size(); j++) {
					//取出凭证体对应的每一个辅助集合
					IntereasVoucherasStacts tempStacts = intereasVoucherasStactsInAction.get(j);
					
					//辅助账必须传入字段
					String asstActType	 = tempStacts.getAsstActTypeName();//核算项目  :客户/银行账户/供应商 
					String asstActNumber = "";//核算对象编码:客户编号/银行账号/供应商编码等等
					String asstActName = "";//核算对象名称:客户名称/银行名称/供应商名称 asstActNumber
					
					String asstActTypes = tempStacts.getAsstActType().getAsstActType();//VOUCHERASSSTACTS_INFO表-辅助账类型编号-asstActType
					//CustInfo custInfo = this.getBussinessDao().findEntityByID(CustInfo.class, tempStacts.getAsstActNumber());
					if("01".equals(asstActTypes) || "02".equals(asstActTypes)){//客户  经销商
						//查询客户对象
						asstActNumber = tempStacts.getCustIdB().getCustNumber();
						asstActName = tempStacts.getCustIdB().getCustName();
						
					}else if("03".equals(asstActTypes)){//银行账户
						OwnAccount account = this.getBussinessDao().findEntityByID(OwnAccount.class, tempStacts.getAsstActNumber());
						//asstActNumber = account.getAccNumber();
						//银行账户对应的财务账户信息,而不是直接去业务银行账号信息
						asstActNumber = account.getAccCode();
						asstActName = account.getAccName();
					}else if("04".equals(asstActTypes)){//待定
						
					}else if("05".equals(asstActTypes)){//职员
						//预留接口，目前无该种方式的凭证处理模式
					}
					else if("07".equals(asstActTypes)){//行政组织
						//预留接口，目前无该种方式的凭证处理模式
					}
					else{
						//do nothing 预留
					}
					
					switch(j+1) 
					{ 
						case 1://辅助账1封装
							wswsVoucher.setAsstSeq(1);//辅助账行号	否
							wswsVoucher.setAsstActType1(asstActType);//核算项目1      辅助帐类型编码 
							wswsVoucher.setAsstActNumber1(asstActNumber);//核算对象编码1     辅助帐类型编码 
							wswsVoucher.setAsstActName1(asstActName);//核算对象名称1  
							
							/*wswsVoucher1.setAsstActType1("客户");//核算项目1
							wswsVoucher1.setAsstActNumber1("01000012");//核算对象编码1
							wswsVoucher1.setAsstActName1("徐州昌润汽车贸易有限公司");//核算对象名称1
							 */								
						break; 
						case 2://辅助账2封装
							wswsVoucher.setAsstSeq(2);//辅助账行号	否
							wswsVoucher.setAsstActType2(asstActType);//核算项目1      辅助帐类型编码 
							wswsVoucher.setAsstActNumber2(asstActNumber);//核算对象编码1     辅助帐类型编码 
							wswsVoucher.setAsstActName2(asstActName);//核算对象名称1  
						break; 
						case 3://辅助账3封装
							wswsVoucher.setAsstSeq(3);//辅助账行号	否
							wswsVoucher.setAsstActType3(asstActType);//核算项目1      辅助帐类型编码 
							wswsVoucher.setAsstActNumber3(asstActNumber);//核算对象编码1     辅助帐类型编码 
							wswsVoucher.setAsstActName3(asstActName);//核算对象名称1  
						break; 
						case 4://辅助账4封装
							wswsVoucher.setAsstSeq(4);//辅助账行号	否
							wswsVoucher.setAsstActType4(asstActType);//核算项目1      辅助帐类型编码 
							wswsVoucher.setAsstActNumber4(asstActNumber);//核算对象编码1     辅助帐类型编码 
							wswsVoucher.setAsstActName4(asstActName);//核算对象名称1  
						break; 
						case 5://辅助账5封装
							wswsVoucher.setAsstSeq(5);//辅助账行号	否
							wswsVoucher.setAsstActType5(asstActType);//核算项目1      辅助帐类型编码 
							wswsVoucher.setAsstActNumber5(asstActNumber);//核算对象编码1     辅助帐类型编码 
							wswsVoucher.setAsstActName5(asstActName);//核算对象名称1  
						break; 
						case 6://辅助账6封装
							wswsVoucher.setAsstSeq(6);//辅助账行号	否
							wswsVoucher.setAsstActType6(asstActType);//核算项目1      辅助帐类型编码 
							wswsVoucher.setAsstActNumber6(asstActNumber);//核算对象编码1     辅助帐类型编码 
							wswsVoucher.setAsstActName6(asstActName);//核算对象名称1  
						break; 
						case 7://辅助账7封装
							wswsVoucher.setAsstSeq(7);//辅助账行号	否
							wswsVoucher.setAsstActType7(asstActType);//核算项目1      辅助帐类型编码 
							wswsVoucher.setAsstActNumber7(asstActNumber);//核算对象编码1     辅助帐类型编码 
							wswsVoucher.setAsstActName7(asstActName);//核算对象名称1  
						break; 
						case 8://辅助账8封装
							wswsVoucher.setAsstSeq(8);//辅助账行号	否
							wswsVoucher.setAsstActType8(asstActType);//核算项目1      辅助帐类型编码 
							wswsVoucher.setAsstActNumber8(asstActNumber);//核算对象编码1     辅助帐类型编码 
							wswsVoucher.setAsstActName8(asstActName);//核算对象名称1  
							break; 
						default://other
							log.error("EAS规定一个凭证体最多只能存在8个与之对应辅助核算!");
						break; 
					}
				}//辅助账循环结束
				
				//接口的规则是每个凭证体就需要传入一次
				vouchers[i] = wswsVoucher;
				i = i + 1;
			}
		}else{
			log.error("凭证号："+tempHeadObj.getVoucherNumber()+"不存在凭证体数据信息,无法生成完整的凭证信息!");
			vouchers = null;
		}
		System.out.println("vouchers.length:"+vouchers.length);
		return vouchers;
	}
	
	/**
	  * <p>将金蝶EAS返回的凭证是否录入信息存入数据库中做记录。</p>
	  * [[20131113181578, null, 0, 0, 1001, 凭证20131113181578没有找到公司:58695815-1, null]]
	  * 宽度定义：外部系统凭证号，凭证字，年度，期限，处理信息，异常信息，金蝶返回凭证号
	  * 1：凭证号：第三方系统自身产生的凭证号
	  * 2：凭证字：第三方系统自身产生的凭证字
	  * 3：年度：第三方系统自身产生的会计年度
	  * 4：期间：第三方系统自身产生的会计期间
	  * 5:处理信息：0000表示成功，其余的请看文档，太多不写了！
	  * 6：异常信息isVerify：应该是EAS在保存凭证时产生的异常，如校验不通过产生的提示信息等
	  * 7:金蝶返回的凭证号：EAS产生的凭证号
	  * @author sea
	  * @param log
	  * @return
	 * @throws Exception 
	 */
	public void saveLog(String[][] logs) throws Exception{
		boolean flag = false;
		if(logs.length <= 0){
			log.error("EAS无任何返回记录，无法做日志存档操作");
		}
		User user = (User) SecurityUtil.getPrincipal();
		//循环记录凭证导入后日志记录
		for (int i = 0; i < logs.length; i++) {
			String[] one_log = logs[i];
			log.info("凭证号："+one_log[0]);
			log.info("凭证字："+one_log[1]);
			log.info("年度："+one_log[2]);
			log.info("期间："+one_log[3]);
			log.info("处理信息："+one_log[4]);
			log.info("异常信息："+one_log[5]);
			log.info("金蝶返回的凭证号："+one_log[6]);
			//封装
			IntereasVoucherLog logObj = new IntereasVoucherLog();
			logObj.setEleasingVouchernumber(one_log[0]);//租赁系统自身产生的凭证号
			logObj.setMemo("凭证字:"+one_log[1]+",年度:"+one_log[2]+",期间:"+one_log[3]+",处理信息："+one_log[4]);
			logObj.setMessage("异常信息："+one_log[5]);
			logObj.setEasVouchernumber(one_log[6]);//异常信息
			logObj.setCreator(user);
			logObj.setCreateDate(DateUtil.getSystemDate());//系统当前时间
			//将日志记录持久化操作
			this.baseDao.saveEntity(logObj);
			//修改凭证头表中对应的导入状态
			this.updateStatus(one_log[0], one_log[5], one_log[4]);
		}
		
	}
	/**
	  * <p>根据凭证导入信息,更新凭证头中导入EAS状态备注等。</p>
	  * @author sea
	  * @param voucherNumber
	  * @param eas_memo
	  * @param num
	  * @throws DataAccessException
	  * @throws Exception
	 */
	private void updateStatus(String voucherNumber,String eas_memo,String num) throws DataAccessException, Exception{
		//update intereas_voucherhead set eas_flag = '1',eas_memo = '"+eas_memo+"' where voucherNumber = '凭证号'
		String eas_flag = "0";
		if("0000".equals(num)){
			eas_flag = "1";
		}
		intereasVoucherheadService.updateEasStatus(voucherNumber, eas_flag, eas_memo);
	}
	
	/**
	  * <p>据根据接口规范文档组装业务系统凭证数据用于导入KINGDEE`EAS主执行方法。</p>
	  * @author sea
	  * @param hsql
	  * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public void saveVoucher(String hsql) throws Exception{
		WSWSVoucher[] vouchers = null;
		service = new ServiceInfo();
		//获取WEBSERVICE的url地址
		String server = service.getServerName();
		@SuppressWarnings("unused")
		java.net.URL endpiont = null;
		
		int verify = 0;//0 不核销暂存  ， 1核销暂存 ，2不核销提交 ，3 核销提交
		int cashflow = 0;//是否引入现金流流量 0 不是 ，1是
		//
		WSWSVoucherSrvProxyServiceLocator locator = new WSWSVoucherSrvProxyServiceLocator();
		/*
		//构建凭证信息
		List<IntereasVoucherHead> hedObj_l = voucherToEasService.queryHead(hsql);
		vouchers = voucherToEasService.getVouchers(hedObj_l);
		*/
		//测试方法
		vouchers = this.getVouchersTest1();
//		for (int i = 0; i < vouchers.length; i++) {
//			int itemFlag = vouchers[i].getItemFlag();
//			if(itemFlag == 1){
//				log.debug("现金流流量需传入!itemFlag="+itemFlag);
//				break;
//			}
//		}
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
			log.debug("凭证号："+ls[0][0]);
			log.debug("凭证字："+ls[0][1]);
			log.debug("年度："+ls[0][2]);
			log.debug("期间："+ls[0][3]);
			log.debug("处理信息："+ls[0][4]);
			log.debug("异常信息："+ls[0][5]);
			log.debug("金蝶返回的凭证号："+ls[0][6]);
			//
			this.saveLog(ls);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (WSInvokeException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		 
	}

	/**
	 * <p>1借2贷带辅助核算-客户。</p>
	 * @author sea
	 * @return
	 */
	private WSWSVoucher[] getVouchersTest(){
		WSWSVoucher[] vouchers = new WSWSVoucher[3];
		//凭证头必须传入字段
		String companyNumber = "0101";//公司编码:58695815-1
		String bookedDate = "2014-02-13";//记账日期
		String bizDate = "2014-02-13";//业务日期
		int periodYear = 2014;//会计期间-年
		int periodNumber = 02;//会计期间-月
		String voucherType = "记账凭证";//凭证字
		String voucherNumber = "20131113181578";//凭证号
		String creator = "李光美";//制单人
		//凭证体必须传入字段
		int entrySeq = 1;//分录行号	 
		String voucherAbstract = "确认刘贺逾期利息";//摘要	
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
		wswsVoucher1.setAccountNumber("2203");//科目	
		wswsVoucher1.setCurrencyNumber(currencyNumber);//币种
		wswsVoucher1.setEntryDC(1);//方向	1 借方-1 贷方
		wswsVoucher1.setOriginalAmount(246);//原币金额	
		wswsVoucher1.setDebitAmount(246);//借方金额	
		wswsVoucher1.setCreditAmount(0);//贷方金额	
		wswsVoucher1.setAsstSeq(1);//辅助账行号	否
		
		//辅助1：
		wswsVoucher1.setAsstActType1("客户");//核算项目1
		wswsVoucher1.setAsstActNumber1("010000001");//核算对象编码1
		wswsVoucher1.setAsstActName1("刘贺");//核算对象名称1 010000001
		//
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
		wswsVoucher2.setAccountNumber("6001.03");
		wswsVoucher2.setCurrencyNumber(currencyNumber);
		wswsVoucher2.setEntryDC(-1);
		wswsVoucher2.setOriginalAmount(210.26);
		wswsVoucher2.setDebitAmount(0);
		wswsVoucher2.setCreditAmount(210.26);
		wswsVoucher2.setAsstSeq(1);
/*		*//*****************现金流******************//*
	   int itemflag = 1;//1情况下方字段请填写，0情况下方这10个值都为空
	   int oppAccountSeq = 2;//借是1，贷是2 
	   String primaryItem = "01.02.01";//对方分录号是1时：01.01.01；对方分录号是2时：01.02.01
	   String supplyItem = "";
	   BigDecimal cashflowAmountOriginal = new BigDecimal("210.26");//取银行数
	   BigDecimal cashflowAmountLocal = new BigDecimal("210.26");//取银行数
	   BigDecimal cashflowAmountRpt = new BigDecimal("210.26");//取银行数
	   int primaryCoef = 1;//默认值1
	   int supplyCoef = 0;//默认值0
	    //
	    wswsVoucher2.setItemFlag(itemflag);
	    wswsVoucher2.setOppAccountSeq(oppAccountSeq);
	    wswsVoucher2.setPrimaryItem(primaryItem);
	    wswsVoucher2.setSupplyItem(supplyItem);
	    wswsVoucher2.setCashflowAmountOriginal(Double.parseDouble(String.valueOf(  cashflowAmountOriginal  )));
	    wswsVoucher2.setCashflowAmountLocal(Double.parseDouble(String.valueOf(  cashflowAmountLocal  )));
	    wswsVoucher2.setCashflowAmountRpt(Double.parseDouble(String.valueOf(  cashflowAmountRpt  )));
	    wswsVoucher2.setPrimaryCoef(primaryCoef);
	    wswsVoucher2.setSupplyCoef(supplyCoef);
	    *//*****************现金流******************//*
		    */
		//辅助2：
		wswsVoucher2.setAsstActType1("客户");
		wswsVoucher2.setAsstActNumber1("010000001");
		wswsVoucher2.setAsstActName1("刘贺");
		//
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
		wswsVoucher3.setOriginalAmount(35.74);
		wswsVoucher3.setDebitAmount(0);
		wswsVoucher3.setCreditAmount(35.74);
		wswsVoucher3.setAsstSeq(1);
		//
		vouchers[2] = wswsVoucher3;
		
		return vouchers;
	}
	
	/**
	  * <p>1借1贷不带辅助核算。</p>
	  * @author sea
	  * @return
	 */
	private WSWSVoucher[] getVouchersTest1(){
		WSWSVoucher[] vouchers = new WSWSVoucher[2];
		//凭证头必须传入字段
		String companyNumber = "0101";//公司编码:58695815-1
		String bookedDate = "2014-02-24";//记账日期
		String bizDate = "2014-02-24";//业务日期
		int periodYear = 2014;//会计期间-年
		int periodNumber = 2;//会计期间-月
		String voucherType = "记账凭证";//凭证字
		String voucherNumber = "20131113181589";//凭证号
		String creator = "李光美";//制单人
		//凭证体必须传入字段
		int entrySeq = 1;//分录行号	 
		String voucherAbstract = "确认现金";//摘要	
		String accountNumber = "1001";//科目	
		String currencyNumber = "BB01";//币种	
		int entryDC = 1;//方向	1 借方-1 贷方
		double originalAmount = 0;//原币金额	
		double debitAmount = 0;//借方金额	
		double creditAmount = 0;//贷方金额	
		int asstSeq	= 0;//辅助账行号	否
		
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
		wswsVoucher1.setAccountNumber("1001");//科目	
		wswsVoucher1.setCurrencyNumber(currencyNumber);//币种
		wswsVoucher1.setEntryDC(1);//方向	1 借方-1 贷方
		wswsVoucher1.setOriginalAmount(1000);//原币金额	
		wswsVoucher1.setDebitAmount(1000);//借方金额	
		wswsVoucher1.setCreditAmount(0);//贷方金额	
		
		//
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
		wswsVoucher2.setAccountNumber("2221.01.01");
		wswsVoucher2.setCurrencyNumber(currencyNumber);
		wswsVoucher2.setEntryDC(-1);
		wswsVoucher2.setOriginalAmount(1000);
		wswsVoucher2.setDebitAmount(0);
		wswsVoucher2.setCreditAmount(1000);
		//
		vouchers[1] = wswsVoucher2;
		 
		return vouchers;
	}
	
	
	/**
	  * <p>据根据接口规范文档组装业务系统凭证数据用于导入KINGDEE`EAS主执行方法。</p>
	  * @author sea
	  * @param hsql
	  * @throws Exception
	 */
	@Override
	@SuppressWarnings("static-access")
	public void saveVoucherByList(List<IntereasVoucherHead> intereasVoucherHeads) throws Exception{
		WSWSVoucher[] vouchers = null;
		service = new ServiceInfo();
		//获取WEBSERVICE的url地址
		String server = service.getServerName();
		@SuppressWarnings("unused")
		java.net.URL endpiont = null;
		
		int verify = 1;//0 不核销暂存  ， 1核销暂存 ，2不核销提交 ，3 核销提交
		int cashflow = 0;//是否引入现金流流量 0 不是 ，1是
		//
		WSWSVoucherSrvProxyServiceLocator locator = new WSWSVoucherSrvProxyServiceLocator();
		//构建凭证信息
		//List<IntereasVoucherHead> hedObj_l = voucherToEasService.queryHead(hsql);
		
		for (IntereasVoucherHead headObj:intereasVoucherHeads) {
			vouchers = this.getVouchers(headObj);
			
			//测试方法 1借1贷不带辅助核算
			//vouchers = this.getVouchersTest();
			//
			try {
				//登陆方式1:
				//EasLogin easLogin = new EasLogin();
				//WSContext cxt = easLogin.doEASLogin(service);
				//登陆方式2:
				LoginTest loginTest = new LoginTest();
				WSContext cxt = loginTest.login();
				if(!"".equals(cxt) && cxt != null){
					System.out.println("登陆信息:"+cxt);
					System.out.println(""+cxt.getUserName());
					System.out.println(""+cxt.getPassword());
					System.out.println(""+cxt.getSessionId());
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
				System.out.println("凭证号："+ls[0][0]);
				System.out.println("凭证字："+ls[0][1]);
				System.out.println("年度："+ls[0][2]);
				System.out.println("期间："+ls[0][3]);
				System.out.println("处理信息："+ls[0][4]);
				System.out.println("异常信息："+ls[0][5]);
				System.out.println("金蝶返回的凭证号："+ls[0][6]);
				//
				this.saveLog(ls);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (WSInvokeException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		 
	}
}
