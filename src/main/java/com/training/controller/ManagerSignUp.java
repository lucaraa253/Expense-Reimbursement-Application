package com.training.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.ers.dao.ManagerDAO;
import com.training.ers.dao.ManagerDAOImpl;

import com.training.ers.models.Manager;


/**
 * Servlet implementation class ManagerSignUp
 */
public class ManagerSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
//		out.println("<html><body>");
//		out.println("Welcome : " + uname);
//		out.println("Password is : " + pwd);
//		
//		out.println("</html></body>");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		Manager manager = new Manager(username, password, firstName, lastName);
		ManagerDAO managerDAO = new ManagerDAOImpl();
		managerDAO.register(manager);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginManager.html");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
