package org.usco.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	
	public Connection getConnection() {
		Connection con1 = null;
		
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/ecommerce";
		String user = "ecommerce";
		String password = "ecommerce";
		
		try{
			Class.forName(driver);
			con1 = DriverManager.getConnection(url, user, password);
			
		}
		catch(Exception e) {
			System.out.println("Error:" + e.toString());
		}
		return con1;
	}

}
