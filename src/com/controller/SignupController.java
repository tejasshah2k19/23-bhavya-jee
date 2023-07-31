package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		PrintWriter out = response.getWriter(); //out -> data -> browser  
		response.setContentType("text/html");//MIME  
		
		out.print("<html><body>");
		if(isError == true) {
			//error 
			out.print(error);
		}else {
			//success
			out.print("FirstName : "+firstName);
			out.print("<br>Email : "+email);
			out.print("<br>Password : "+password);
			
		}
		
		out.print("</body></html>");
		
		 
		
	}
	
}
