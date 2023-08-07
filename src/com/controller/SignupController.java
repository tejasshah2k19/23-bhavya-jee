package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet{

	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("SignupController...");
		
		//read 
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//validation
		boolean isError = false; 
		String error = "";

		if(firstName == null || firstName.trim().length() == 0 ) {
			isError = true;
			error = error + "<br>Please Enter FirstName"; 
		}
		if(email == null || email.trim().length() == 0 ) {
			isError = true; 
			error = error + "<BR>Please Enter Email";
		}
		
		if(password == null || password.trim().length() ==  0) {
			isError= true;
			error = error + "<br>Please Enter Password";
		}
		
		 
	 	if(isError == true) {
			//error 
	  	}else {
			//success
		 
			//db save 
	  		try {
	  			Connection connection = DbConnection.getConnection(); 
	  			//execute query in db 
	  			PreparedStatement pstmt = connection.prepareStatement("insert into users (firstName,email,password) values (?,?,?)");
	  			pstmt.setString(1, firstName);
	  			pstmt.setString(2, email);
	  			pstmt.setString(3, password);
	  			
	  			pstmt.executeUpdate(); //query run 
	  			
	  			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	  			rd.forward(request, response);
	  			
	  		}catch(Exception e) {
	  			e.printStackTrace();
	  		}
			//login 
			
		}
		
		 
		 
		
	}
	
}
