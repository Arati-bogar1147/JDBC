package com.jspiders.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Jdbc {
	
	public static void main(String[] args) {
		try {
			//step 1:Load the driver class.
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2:open connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weje1?user=root&paassword=root");
			
			//Step 3:prepare statement
			
			Statement createstatement=connection.createStatement();
			
			//step 4:process the result
			
			ResultSet resultset=createstatement.executeQuery("select * from mumbai_indians");
			
			while(resultset.next()) {
				System.out.println(resultset.getInt(1)+"|"+resultset.getString(2)+"|"+resultset.getInt(3));
			}
			
			//step 5:close connection
			if (connection !=null) {
				connection.close();
				
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		}
		catch(SQLException e) {
			System.out.println("Database not found");
			
			
		}
		
	}

}
