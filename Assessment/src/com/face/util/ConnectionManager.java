package com.face.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager 
{
	static Connection conn = null;

	public static Properties loadPropertiesFile() throws IOException 
	{
		Properties prop = new Properties();
		InputStream in = new FileInputStream("C:\\Users\\user_2\\eclipse-workspace\\Assessment\\resources\\jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}

	// connect to DB
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Properties prop = loadPropertiesFile();
		final String driver = prop.getProperty("driver");
		final String url = prop.getProperty("url");
		final String username = prop.getProperty("username");
		final String password = prop.getProperty("password");

		try 
		{
			Class.forName(driver);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			throw e;
		}

		try 
		{
			conn = DriverManager.getConnection(url, username, password);
		} 
		catch (SQLException e) 
		{
			System.out.println("Connection failed check output console");
			e.printStackTrace();
			throw e;
		}

		return conn;
	}
}
