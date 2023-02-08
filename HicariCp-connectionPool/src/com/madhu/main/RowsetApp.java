package com.madhu.main;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class RowsetApp {

	public static void main(String[] args) throws SQLException {
		RowSetFactory rsf= RowSetProvider.newFactory();
		JdbcRowSet jdbcRowSet = rsf.createJdbcRowSet();
		CachedRowSet cachedRowSet = rsf.createCachedRowSet();
		WebRowSet webRowSet = rsf.createWebRowSet();
		JoinRowSet joinRowSet= rsf.createJoinRowSet();
		FilteredRowSet filteredRowSet = rsf.createFilteredRowSet();
		System.out.println(jdbcRowSet.getClass().getName());
		System.out.println(cachedRowSet.getClass().getName());
		System.out.println(webRowSet.getClass().getName());
		System.out.println(joinRowSet.getClass().getName());
		System.out.println(filteredRowSet.getClass().getName());
		
		

	}

}
