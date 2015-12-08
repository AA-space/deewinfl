package com.business.service.contractnocar;

import java.util.Map;

public  interface ContractComm {

	/**
	 * @param obj   传projInfo|contractInfo 其他对象会被过滤
	 * @param variablesMap
	 * @return 显示项目(合同)基本信息
	 */
	public void getContractToMapBaseInfo(Object obj,
			Map<String, String> variablesMap);
	
}
