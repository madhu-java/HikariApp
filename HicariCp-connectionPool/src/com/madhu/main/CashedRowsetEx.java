package com.madhu.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.mysql.cj.jdbc.result.ResultSetFactory;

public class CashedRowsetEx {

	public static void main(String[] args) throws SQLException {

		
		Connection connection= DriverManager.getConnection("jdbc:mysql:///student","root","root");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select id,name,age,address from student");
		System.out.println("id\tname\tage\taddress");
while(resultSet.next()) {
	System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
}

//System.out.println("print the results again....");
//System.out.println("id\tname\tage\taddress");
//while(resultSet.next()) {
//	System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
//}

RowSetFactory rowSetFactory= RowSetProvider.newFactory();
CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
cachedRowSet.populate(resultSet);
connection.close();
System.out.println("print the results again....");
System.out.println("id\tname\tage\taddress");

while(cachedRowSet.next()) {
	System.out.println(cachedRowSet.getInt(1)+"\t"+cachedRowSet.getString(2)+"\t"+cachedRowSet.getInt(3)+"\t"+cachedRowSet.getString(4));
}

	}

}
