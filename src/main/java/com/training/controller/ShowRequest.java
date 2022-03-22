package com.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.ers.dao.RequestDAO;
import com.training.ers.dao.RequestDAOImpl;
import com.training.ers.dao.UserDAO;
import com.training.ers.dao.UserDAOImpl;
import com.training.ers.models.Request;

/**
 * Servlet implementation class ShowRequest
 */
public class ShowRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int actualId = Integer.parseInt(id);
		boolean result;
		
		
		System.out.println("Number 1 called");
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		
		System.out.println("Number 2 called");
			
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("displaySingleRequest.jsp");
		dispatcher.include(request, response);
			
		System.out.println("Number 3 called");
			
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
