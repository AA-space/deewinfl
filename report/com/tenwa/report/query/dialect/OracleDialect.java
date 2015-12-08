package com.tenwa.report.query.dialect;

import java.sql.ResultSet;

import com.tenwa.report.annotation.DialectName;
@DialectName(name="Oracle")
public class OracleDialect extends AbstractSQLDialect {
	@Override
	public String buildPagingQuery(String sql, int start, int limit) {
		start = start + 1;
		return new StringBuffer("SELECT * FROM (SELECT t_.*,ROWNUM row_num_ FROM (")
					.append(sql)
					.append(") t_ where ROWNUM <")
					.append(start + limit)
					.append(" ) WHERE row_num_ >= ")
					.append(start).toString();
	}

	

	@Override
	protected void registerSQLKeyword() {
	}

	@Override
	public ResultSet executeProcdure(String proc) {
		return null;
	}
	
	/**
	 * 
	 * @param t
	 * @param hasApostrophe 是否需要单引号
	 * @return
	 */
	public String to_date(String t,boolean hasApostrophe){
		String apostrophe = "'";
		if(!hasApostrophe)
			apostrophe = "";
		return "to_char(to_date(" + apostrophe + t.substring(0, 10) + apostrophe + ",'yyyy-mm-dd'),'yyyy-mm-dd')";
	}

}
