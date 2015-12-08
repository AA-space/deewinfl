package com.business.model.database;

public class DB2DataBasePagingImpl implements DataBasePaging {

	@Override
	public String getPagingSql(String sqlNoPaging, int start, int limit) {
		String sqlPaging = sqlNoPaging + " limit "+start+","+limit;
		return sqlPaging;
	}
}
