package com.tenwa.report.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.business.daoImpl.AbstractBaseDaoImpl;
import com.tenwa.report.dao.ReportDao;

@Repository("reportDao")
public class ReportDaoImpl extends AbstractBaseDaoImpl implements ReportDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public JdbcTemplate getJdbcTemplate() throws Exception {
		return this.jdbcTemplate;
	}
  
	@Override
	public HibernateTemplate getHibernateTemplate() throws Exception {
		
		return this.hibernateTemplate;
		
	}
}
