package com.impetus;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	public static Connection getConnection()
	{
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Successfully Loaded Driver");
			 conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/db1","scott","tiger");
			System.out.println("Successfully connected");
			
			
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
		}

}
