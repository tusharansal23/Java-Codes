package com.nagarro.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.nagarro.dao.HibernateUtil;
import com.nagarro.model.Image;
import com.nagarro.model.User;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    String s = request.getParameter("imageId");
		    int id = Integer.parseInt(s);
//			int id = (int)s.getAttribute("id");
		    HttpSession session = request.getSession();
			String uname = (String)session.getAttribute("username");
			Session se = HibernateUtil.getSession();
			se.beginTransaction();
			Image image = se.get(Image.class, id);
			User login = se.get(User.class, uname);
			login.getImages().remove(image);
			se.remove(image);
			se.getTransaction().commit();
			getServletContext().getRequestDispatcher("/Image.jsp").forward(
	                request, response);
			
			
		
	}

}
