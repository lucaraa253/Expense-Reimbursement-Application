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
import com.training.ers.models.User;

/**
 * Servlet implementation class ExecuteUpdateController
 */
public class ExecuteUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id3 = (String) request.getParameter("id");
		

		String description = (String) request.getParameter("description");
		String ammount = (String) request.getParameter("ammount");
		int thisId = Integer.parseInt(id3);
		int ammount2 = Integer.parseInt(ammount);
		
		
		
		Request req = new Request(description, ammount2);
		
		
		
		boolean result;
		
		RequestDAO reqDAO = new RequestDAOImpl();
		
		result = reqDAO.updateRequest(req, thisId);
		
		
		
		if (result) {
			
			System.out.println("Congratulations : your request has been updated");
			
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
