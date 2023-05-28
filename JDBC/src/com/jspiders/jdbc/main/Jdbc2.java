package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2 {
	
	static Connection connection;
	static Statement statement;
	static ResultSet resultset;
	static String driverpath="com.mysql.cj.jdbc.Driver";
	static String dbpath="jdbc:mysql://localhost:3306/weje1";
	static String user="root";
	static String password="root";
	static String query="select *from mumbai_indians";
	
	public static void main(String[] args) {
		try {
			Class.forName(driverpath);
			connection=DriverManager.getConnection(dbpath,user,password);
			statement=connection.createStatement();
			resultset=statement.executeQuery(query);
			
			while (resultset.next()) {
				System.out.println(resultset.getString(1)+"|"+resultset.getString(2)+"|"+resultset.getString(3));
				
			}
		}
			catch (ClassNotFoundException e) {
				System.out.println("Driver not loaded");
			}
			catch(SQLException e) {
				System.out.println("Database not found");
			
			
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				}catch(SQLException e) {
					System.out.println("connection not closed");
				}
				
			}
		}
	}

}
