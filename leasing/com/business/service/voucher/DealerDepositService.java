package com.business.service.voucher;   

import java.math.BigDecimal;

import com.business.entity.cust.CustInfo;
import com.business.entity.dealer.MFundFundCharge;
import com.business.entity.util.OwnAccount;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2014-3-27 上午11:55:01
 * 类说明
 */
public interface DealerDepositService {
	void collectDepositMoney(MFundFundCharge mc)throws Exception;
	void payDepositMoney(MFundFundCharge mc) throws Exception;
}
  
