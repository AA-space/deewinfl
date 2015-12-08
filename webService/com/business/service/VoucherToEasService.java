package com.business.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.business.entity.voucher.IntereasVoucherHead;
import com.wsvoucher.client.WSWSVoucher;

/**
 * <p>据根据接口规范文档组装业务系统凭证数据用于导入KINGDEE`EAS。</p>
 * <p>2013-11-16</p>
 * @author sea
 * @version 4.5
 */
public interface VoucherToEasService {

	/**
	  * <p>根据SQL查询需要导入财务系统的凭证数据，默认查询所有未导入EAS的凭证数据。</p>
	  * @author sea
	  * @param hsql 可以为空，空则查询所有未导入EAS的凭证数据,HSQL格式如下：
	  * 	   (from IntereasVoucherHead where status = ? and eas_flag = ?)
	  * 	   HSQL不为空情况下其它条件请拼在	status = ? and eas_flag = ?之前，因为执行方法是：
	  * 	   this.getBussinessDao().findResultsByHSQL(HSQL, "已完整","0")
	  * 	       最后2个条件的参数默认是凭证状态和导出状态为0(表示未导出)	
	  * @return
	 */
	public List<IntereasVoucherHead> queryHead(String hsql) throws Exception; 
	
	/**
	  * <p>根据凭证信息组装EAS所需要的数据格式。</p>
	  * <p>EAS所需要的数据格式为WSWSVoucher对象数组，每个凭证一条分录就是一个WSWSVoucher对象。</p>
	  * @author sea
	  * @param hedObj_l 所有待导入的凭证对象信息集合
	  * @return
	 */
	public WSWSVoucher[] getVouchers(IntereasVoucherHead hedObj_l) throws DataAccessException, Exception;
	
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
	public void saveLog(String[][] logs) throws Exception;
	
	/**
	  * <p>据根据接口规范文档组装业务系统凭证数据用于导入KINGDEE`EAS主执行方法。</p>
	  * @author sea
	  * @param hsql 可以为空，空则查询所有未导入EAS的凭证数据,HSQL格式如下：
	  * 	   (from IntereasVoucherHead where status = ? and eas_flag = ?)
	  * 	   HSQL不为空情况下其它条件请拼在	status = ? and eas_flag = ?之前，因为执行方法是：
	  * 	   this.getBussinessDao().findResultsByHSQL(HSQL, "已完整","0")
	  * 	       最后2个条件的参数默认是凭证状态和导出状态为0(表示未导出)	
	  * @throws Exception
	 */
	public void saveVoucher(String hsql) throws Exception;

	public void saveVoucherByList(List<IntereasVoucherHead> intereasVoucherHeads) throws Exception;
 
}
