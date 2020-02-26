package com.nagarro.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.nagarro.dao.HibernateUtil;
import com.nagarro.dao.LoginDao;
import com.nagarro.model.Image;

/**
 * Servlet implementation class Update
 */
@WebServlet(description = "update", urlPatterns = { "/update" })
public class Update extends HttpServlet {
	int id;
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

    		String s = request.getParameter("imageId");
    		System.out.println(s);
    		id = Integer.parseInt(s);
    	
		    getServletContext().getRequestDispatcher("/update.jsp").forward(
	                request, response);    	
	}
    	
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
        		String iname = request.getParameter("iname");
        		//String s = request.getParameter("imageId");
        		//System.out.println(s);
        		//int id = Integer.parseInt(s);
        		Session se = HibernateUtil.getSession();
    			se.beginTransaction();
    			Image image = se.get(Image.class, id);
    			image.setImageName(iname);
    		    se.getTransaction().commit();
    		    getServletContext().getRequestDispatcher("/Image.jsp").forward(
    	                request, response);    	
    	}


}
