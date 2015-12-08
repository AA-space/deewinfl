package com.business.model.database;

public interface DataBasePaging 
{
	public abstract String getPagingSql(String sqlNoPaging,int start,int limit);
}
