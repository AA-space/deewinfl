package com.tenwa.leasing.rentcalc.service.impl.irregularrent;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.tenwa.leasing.bean.ConditionBean;
import com.tenwa.leasing.bean.TabCalBean;
import com.tenwa.leasing.rentcalc.service.RentCalcService;
import com.tenwa.leasing.rentcalc.service.impl.ConditionServiceImpl;
import com.tenwa.leasing.rentcalc.service.impl.evenrent.EvenRentCalcServiceImpl;
import com.tenwa.leasing.util.leasing.TbBeanTools;

/**
 * 
 * @author      SCLICX
 * @version     1.0
 * @copyright   (C) Tenwa 2011
 * @date        Nov 26, 2011
 * @desc        TODO 不规则的租金测算 在测算的时候只是保存 condition 而已 在起租的时候直接提示不允许
 */
public class IrregularRentCalServiceImpl
		implements RentCalcService {
	static Logger	logger	= Logger.getLogger(EvenRentCalcServiceImpl.class);

	/**
	 * 不规则时测算的方法
	 * 不规则的租金测算 只保存交易结果就可以了 租金计划 等一系列的动作 不负责.
	 *  @param cb 
	 *  @param calType
	 *  @param userName
	 *  @param obj
	 */
	public Hashtable<String,String> rentCal(ConditionBean cb, String calType, String userName,
			Object obj,String star_list) throws Exception {
		logger.debug("进入方法:rentCal 进行不规则时测算的方法..");
		// 得到操作表信息
		TabCalBean tcb = TbBeanTools.getTabInfo(calType, cb);
		ConditionServiceImpl csi = new ConditionServiceImpl();
		// 对交易结构信息处理
		boolean add=csi.addConditionByCal(tcb, cb);
		Hashtable<String,String> re_ht = new Hashtable<String,String>();
		re_ht.put("isSucess",add+"");
		if(add){
			re_ht.put("message","不规则租金测算不进行租金计划的构建,请在下面的页面中自行输入租金计划!");
		}else{
			re_ht.put("message","保存商务条件失败!请检查商务条件数据是否符合要求,或者检查网络或者服务器是否异常!然后重试");
		}
		logger.debug("进行不规则时测算的方法:rentCal ..");
		return re_ht;
	}

	/**
	 * 不规则时起租的方法
	 *  @param cb 
	 *  @param calType
	 *  @param userName
	 *  @param obj
	 */
	public Hashtable<String,String> rentCalOnHire(ConditionBean cb, String calType,
			String userName, Object obj) throws Exception {
		// TODO Auto-generated method stub
		Hashtable<String,String> re_ht = new Hashtable<String,String>();
		re_ht.put("isSucess","false");
		re_ht.put("isSucess","不规则的租金测算起租日不允许变更,如果要修改租金计划中的还款日请在租金计划修改中完成!");
		logger.debug("进行不规则时测算的方法:rentCalOnHire ..");
		return re_ht;
	}

}
