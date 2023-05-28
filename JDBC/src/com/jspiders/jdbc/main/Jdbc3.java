package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Jdbc3 {
	
	static Connection connection;
	static Statement statement;
	static int resultInt;
	static String driverpath="com.mysql.cj.jdbc.Driver";
	static String dbpath="jdbc.mysql://localhost:3306/weje1";
	static String user="root";
	static String password="root";
	static String query="insert into mumbai_indians"+"values(3,'kieron pollard',55)";
	
	public static void main(String[] args) {
		try {
			Class.forName(driverpath);
			connection=DriverManager.getConnection(dbpath,user,password);
			statement=connection.createStatement();
			resultInt=statement.executeUpdate(query);
			
			if(resultInt!=0) {
				System.out.println("Query ok,"+resultInt +"row(s)affected");
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
