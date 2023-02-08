package com.madhu.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class TestApp {

	public static void main(String[] args) throws SQLException {
		String configFile= "src\\com\\madhu\\main\\db.properties";
		HikariConfig hikariConfig = new HikariConfig(configFile);
		try(HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig)){
			
			Connection connection = hikariDataSource.getConnection();
			Statement statement= connection.createStatement();
			ResultSet resultSet= statement.executeQuery("select pname,price,qty from products");
			System.out.println("panme\tprice\tqty");
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+"\t"+resultSet.getInt(2)+"\t"+resultSet.getInt(3));
			}
			
			
		}
		
	}

}
