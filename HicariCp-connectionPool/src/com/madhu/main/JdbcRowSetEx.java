package com.madhu.main;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetEx {

	public static void main(String[] args) throws Exception {

RowSetFactory rowSetFactory = RowSetProvider.newFactory();

JdbcRowSet jdbcRowSet = rowSetFactory.createJdbcRowSet();
//setting url, name, password

jdbcRowSet.setUrl("jdbc:mysql:///student");
		jdbcRowSet.setUsername("root");
		jdbcRowSet.setPassword("root");
		//setting the command for execution
		
		jdbcRowSet.setCommand("select id,name,age,address from student");
		jdbcRowSet.execute();
		
		//retrieving the results
		System.out.println("retrieving records in forward direction");
		System.out.println("id\tname\tage\taddress");
		while(jdbcRowSet.next()) {
			System.out.println(jdbcRowSet.getInt(1)+"\t"+jdbcRowSet.getString(2)+"\t"+jdbcRowSet.getInt(3)+"\t"+jdbcRowSet.getString(4));
			
		}
		
		System.out.println("retrieving records in backward direction");
		System.out.println("id\tname\tage\taddress");
		while(jdbcRowSet.previous()) {
			System.out.println(jdbcRowSet.getInt(1)+"\t"+jdbcRowSet.getString(2)+"\t"+jdbcRowSet.getInt(3)+"\t"+jdbcRowSet.getString(4));
			
		}
		
		
		System.out.println("accessing records randomly...");
		jdbcRowSet.absolute(4);
		System.out.println("id\tname\tage\taddress");
		System.out.println(jdbcRowSet.getInt(1)+"\t"+jdbcRowSet.getString(2)+"\t"+jdbcRowSet.getInt(3)+"\t"+jdbcRowSet.getString(4));
		
		
		System.out.println("accessing records randomly...");
		jdbcRowSet.relative(2);
		System.out.println("id\tname\tage\taddress");
		System.out.println(jdbcRowSet.getInt(1)+"\t"+jdbcRowSet.getString(2)+"\t"+jdbcRowSet.getInt(3)+"\t"+jdbcRowSet.getString(4));
		
		
		//inserting a record....
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter id...");
	int id = scanner.nextInt();
	System.out.println("enter name...");
	String name= scanner.next();
	System.out.println("enter agr...");
	int age = scanner.nextInt();
	System.out.println("enter addres...");
	String addres= scanner.next();
	
	jdbcRowSet.moveToInsertRow();
	jdbcRowSet.updateInt(1, id);
	jdbcRowSet.updateString(2, name);
	jdbcRowSet.updateInt(3, age);
	jdbcRowSet.updateString(4, addres);
	
	jdbcRowSet.insertRow();
	System.out.println("Record inserted successfully...");
	}

}
