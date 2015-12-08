package com.business.service.check;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpRequest;

import com.business.entity.proj.ProjInfo;
import com.business.service.BaseService;


public interface CheckStartingWorkFlowServer extends BaseService {
	/**
	 * 获取流程状态
	 * @param seriesNumber 项目编号，proj_id或contract_id
	 * @return
	 * @throws DataAccessException
	 * @throws Exception
	 */
	List<Map<String, String>> getWorkFlowStatus(String seriesNumber) throws DataAccessException, Exception;

	/**
	 * 通用流程校验
	 * @param request
	 * @return
	 * @throws DataAccessException
	 * @throws Exception
	 */
	Map<String, String> checkWorkFlow(HttpServletRequest request) throws DataAccessException, Exception;

	/**
	 * 合同发起流程校验，
	 * @param request
	 * @return
	 * @throws Exception 
	 * @throws DataAccessException 
	 */
	Map<String, String> checkContractStart(HttpServletRequest request) throws DataAccessException, Exception;
	
	/**
	 * 合同起租发起流程校验，
	 * @param request
	 * @return
	 * @throws Exception 
	 * @throws DataAccessException 
	 */
	Map<String, String> checkContractOnhireStart(HttpServletRequest request) throws DataAccessException, Exception;

	/**
	 * 资金相关流程校验
	 * @param request
	 * @return
	 * @throws DataAccessException
	 * @throws Exception
	 */
	Map<String, String> checkCharge(HttpServletRequest request) throws DataAccessException, Exception;
	
	/**
	 * 租金相关流程校验
	 * @param request
	 * @return
	 * @throws DataAccessException
	 * @throws Exception
	 */
	
	Map<String, String> checkRent(HttpServletRequest request) throws DataAccessException, Exception;
	
	/**
	 * 设备相关流程校验
	 * @param request
	 * @return
	 * @throws DataAccessException
	 * @throws Exception
	 */
	Map<String, String> checkEquip(HttpServletRequest request) throws DataAccessException, Exception;

}
