package com.business.dao;

import com.business.entity.User;


public interface AclDao extends BaseDao
{
	//用户
	public User   findUserByUserName(String username) throws Exception;
	//定位到用户主页
	public String getCurrentUserIndexPageUrl() throws Exception;
}
