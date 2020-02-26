package com.nagarro.validator;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.nagarro.dao.LoginDao;


@WebServlet("/Login")
public class Validator extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String uname = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession s = req.getSession();
		s.setAttribute("username", uname);
		System.out.println(uname+" "+password);
		if(LoginDao.getCredintials(uname, password)) {
			System.out.println("True");
			res.sendRedirect("Image.jsp");
		}else {
			System.out.println("false");
			res.sendRedirect("Login.jsp");
		}
	

}
}
