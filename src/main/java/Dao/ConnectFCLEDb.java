package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectFCLEDb {

	public Connection cn;
	public void ketnoi() throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://LAPTOP-GAPEQK7M\\SQLEXPRESS02:1433;databaseName=FCLEDb;user=sa;password=123";
		cn = DriverManager.getConnection(url);
		System.out.println("Connected FCLE Db");
	}

}
