package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet{

	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
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
	  		UserDao userDao = new UserDao();
	  		
	  		UserBean user = new UserBean(); 
	  		user.setFirstName(firstName);
	  		user.setEmail(email);
	  		user.setPassword(password);
	  		 
	  		userDao.addUser(user);
	  		
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);

			//login 
			
		}
		
		 
		 
		
	}
	
}
