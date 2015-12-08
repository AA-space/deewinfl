package com.business.service.check;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import com.business.service.BaseService;


public interface CheckServer extends BaseService {
	String checekEquipmentManager(HttpServletRequest request, HttpServletResponse response) throws Exception;
	/**
	 * 验证车架号的唯一性
	 * @param request
	 * @return
	 * @throws Exception
	 */
	String validateChassisnum(HttpServletRequest request) throws Exception;
}
