package com.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.ers.dao.UserDAO;
import com.training.ers.dao.UserDAOImpl;
import com.training.ers.models.User;


/**
 * Servlet implementation class LogIn2Controller
 */
public class LogIn2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogIn2Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		boolean result;
		
		
		UserDAO userDAO = new UserDAOImpl();
		
		result = userDAO.validate(uname, pwd);
		
		HttpSession session = request.getSession();
		session.setAttribute("username", uname);
		
		if (result) {
			session.setAttribute("message", "Valid User");
			System.out.println("Congratulations : " + uname + " you are now logged in");
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcomeEmployee.jsp");
			dispatcher.include(request, response);
			
			
			
		}
			
		else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html><body>");
			out.println("You could not be logged in " );
			
		
			out.println("</html></body>");
		}
			
	}

}
