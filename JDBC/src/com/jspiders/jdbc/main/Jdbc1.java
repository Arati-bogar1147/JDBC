package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Jdbc1 {
	
	public static void main(String[] args) {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weje1","root","root");
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet=statement.executeQuery("select * from mumbai_indians");
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+"|"+resultSet.getString(2)+"|"+resultSet.getString(3));
				
			}
		}
			catch (ClassNotFoundException e) {
				System.out.println("Driver not loaded");
			}
			catch(SQLException e) {
				System.out.println("Database not found");
				
			
			
			
			
		}
	}
}


