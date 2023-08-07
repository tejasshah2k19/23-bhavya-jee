package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection() {
		// mysql java jdbc driver ,
		// mysql java jdbc database url
		String driver = "com.mysql.cj.jdbc.Driver"; // mysql jar driver name ->
		String url = "jdbc:mysql://localhost:3306/jeebhavya";
		String userName = "root";
		String password = "root";

		try {

			// load driver
			Class.forName(driver);

			Connection connection = DriverManager.getConnection(url, userName, password);
			if (connection == null) {
				System.out.println("Db Not Connected");
			} else {
				System.out.println("Db Connected");
			}
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		DbConnection d = new DbConnection();
		d.getConnection();
	}

}
