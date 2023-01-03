package com.qsp.prepared_statement_project_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {

	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc-noida-preparedstatement-project";
			String user="root";
			String pass="zAki@1800";
			Connection connection=DriverManager.getConnection(url, user, pass);
			
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
}
