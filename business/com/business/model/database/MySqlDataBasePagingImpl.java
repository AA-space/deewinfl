package com.business.model.database;

public class MySqlDataBasePagingImpl implements DataBasePaging {

	@Override
	public String getPagingSql(String sqlNoPaging, int start, int limit) {
		String sqlPaging = sqlNoPaging + " limit "+start+","+limit;
		return sqlPaging;
	}
}
