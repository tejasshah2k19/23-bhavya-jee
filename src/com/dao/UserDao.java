package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.UserBean;
import com.util.DbConnection;

//data access object --> db 
public class UserDao {

	public void addUser(UserBean user) {
		try {
			Connection connection = DbConnection.getConnection();
			// execute query in db
			PreparedStatement pstmt = connection
					.prepareStatement("insert into users (firstName,email,password) values (?,?,?)");
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());

			pstmt.executeUpdate(); // query run

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
