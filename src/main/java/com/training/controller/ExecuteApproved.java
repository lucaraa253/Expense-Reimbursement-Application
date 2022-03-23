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


/**
 * Servlet implementation class ExecuteApproved
 */
public class ExecuteApproved extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteApproved() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		String id3 = (String) session.getAttribute("id");
		int id2= Integer.parseInt(id);;
		
		boolean result;
		RequestDAO reqDAO = new RequestDAOImpl();
		
		result = reqDAO.approveRequest(id2);
		
		
		
		if (result) {
			
			System.out.println("Congratulations : your request has been approved");
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.include(request, response);
			
			
			
		}
			
		else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html><body>");
			out.println("Your request was not updated " );
			
		
			out.println("</html></body>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
