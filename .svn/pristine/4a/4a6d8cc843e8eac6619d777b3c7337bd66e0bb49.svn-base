package com.business.serviceImpl.contractnocar;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.business.entity.contract.ContractInfo;
import com.business.entity.cust.CustInfo;
import com.business.entity.proj.ProjInfo;
import com.business.service.TableService;
import com.business.service.contractnocar.ContractComm;

@Service(value="contractComm")
public class ContractCommImpl implements ContractComm {

	@Resource(name = "tableService")
	private TableService tableService;
	
	Logger logger =Logger.getLogger(ContractCommImpl.class);
	
	private  ProjInfo projInfo ;
	private  ContractInfo contractInfo ;
	 
	@Override
	public void getContractToMapBaseInfo(Object obj,Map<String, String> variablesMap) 
	{
		this.getEntityStringMap(obj, variablesMap);
	}
	
	/** entity object to map variablesMap   */
	public void getEntityStringMap(Object o,Map<String, String> variablesMap)
	{
		try
		{
			// ProjInfo object information put to variablesMap
			if (o instanceof ProjInfo)
			{
				 
			}
			// ContractInfo object information put to variablesMap
			if (o instanceof ContractInfo)
		    {
		    	contractInfo= (ContractInfo)o; 
		    	variablesMap.putAll(this.tableService
		    			.getEntityPropertiesToStringMap(contractInfo,null, "contract_info"));
		    	
		    	 
		    	System.out.print("出单部门>>"+contractInfo
						.getProjDept().getName());
		    	CustInfo custInfo = contractInfo.getCustId();// get CustInfo Object
		    	
		    	if( null != custInfo )
		    	{
					variablesMap.put("contract_info.custname",custInfo
							.getCustName()==null?"":custInfo.getCustName()); //客户名称
					variablesMap.put("contract_info.custid",custInfo
							.getId()==null?"":custInfo.getId());//客户id
					variablesMap.put("contract_info.custnumber",custInfo
							.getCustNumber()==null?"":custInfo.getCustNumber());//客户编码
				}
		    	
		    }
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}

	
}
