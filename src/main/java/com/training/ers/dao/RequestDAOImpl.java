package com.training.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.training.ers.models.Request;
import com.training.ers.models.User;
import com.training.ers.utility.DBConnection;

public class RequestDAOImpl implements RequestDAO {
	
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	Connection connection = DBConnection.getConnection();

	@Override
	public boolean createRequest(Request request, User user) {
		System.out.println("##Adding request :" + request);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			System.out.println("At least it got here");
			statement = connection.prepareStatement("insert into requests values(default,?,?,false,?)");
			statement.setString(1, request.getDescription());
			statement.setInt(2, request.getAmount());
			statement.setInt(3, user.getId());
			
		

			rows = statement.executeUpdate();
			System.out.println();
			System.out.println(rows + " requests created");
			
			statement.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0) {
			System.out.println("Request created");
			logger.info(user.getUsername() + " could not create a request on " + new java.util.Date());
			
			return false;
			
	        
		}
			
		else {
			logger.info(user.getUsername() + " has created a request on " + new java.util.Date());
			
	        
			return true;
		}
	}

	@Override
	public List<Request> viewAllRequests(String username) {
		List<Request> allRequests = new ArrayList<Request>();
		PreparedStatement stat2;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select id from employees2 where username = ?");
			stat.setString(1, username);
			
			
			ResultSet res = stat.executeQuery();
			res.next();
			
			int employeeId = res.getInt(1);
			
			stat2 = connection.prepareStatement("select * from requests where reqid = ?");
			stat2.setInt(1, employeeId);
			ResultSet res2 = stat2.executeQuery();
			
			while(res2.next()) {
				
				Request request = new Request();
				request.setId(res2.getInt(1));
				request.setDescription(res2.getString(2));
				request.setAmount(res2.getInt(3));
				request.setApproved(res2.getBoolean(4));
				request.setReqId(res2.getInt(5));
				
//				
				allRequests.add(request);
//	            
	            
	            
	        }
			res.close();
            stat.close();
            stat.close();
            res2.close();
            stat2.close();
            stat2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return allRequests;
	}

	@Override
	public List<Request> managerViewAll() {
		List<Request> allRequests = new ArrayList<Request>();
		
		Statement stat;
		try {
			
			
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from requests");
			res.next();
			
			while(res.next()) {
				
				Request request = new Request();
				request.setId(res.getInt(1));
				request.setDescription(res.getString(2));
				request.setAmount(res.getInt(3));
				request.setApproved(res.getBoolean(4));
				request.setReqId(res.getInt(5));
				
//				Adding single product into product list
				allRequests.add(request);
//	            System.out.print(res.getInt(1) + "     ");
//	            System.out.print(res.getString(2) + "     ");
//	            System.out.print(res.getInt(3) + "     ");
//	            System.out.println(res.getInt(4) + "     ");
	            
	            
	        }
			res.close();
            stat.close();
            stat.close();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return allRequests;
	}

	@Override
	public Request viewSingleRequest(int id) {
		System.out.println("##Printing search users  ");
		Request request = new Request();

		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from requests where id = " + id);
			while (res.next()) {
				
				request.setId(res.getInt(1));
				request.setDescription(res.getString(2));
				request.setAmount(res.getInt(3));
				request.setApproved(res.getBoolean(4));
				request.setReqId(res.getInt(5));
				

			}
			System.out.println("showing a single request "+ request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return request;
	}

	@Override
	public boolean updateRequest( Request request,int id) {
		System.out.println("Updating Request");
		PreparedStatement statement = null;
		int rows = 0;
		try {
			System.out.println("At least it got here");
			statement = connection.prepareStatement("update requests set description = ?, amount = ? where id = ?");
			statement.setString(1, request.getDescription());
			statement.setInt(2, request.getAmount());
			statement.setInt(3, id);
			
		

			rows = statement.executeUpdate();
			System.out.println();
			System.out.println(rows + " requests created");
			
			statement.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0) {
			System.out.println("Request created");
			
			
			return false;
			
	        
		}
			
		else {
			logger.info("Created a request on " + new java.util.Date());
			
	        
			return true;
		}
	}

	@Override
	public boolean deleteSingleRequest(int id) {
		System.out.println("Deleting Request");
		PreparedStatement statement = null;
		int rows = 0;
		try {
			System.out.println("At least it got here");
			statement = connection.prepareStatement("delete from requests where id = ?");
			
			statement.setInt(1, id);
			
		

			rows = statement.executeUpdate();
			System.out.println();
			System.out.println(rows + " requests deleted");
			
			statement.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0) {
			System.out.println("Request deleted");
			
			
			return false;
			
	        
		}
			
		else {
			logger.info("Created a request on " + new java.util.Date());
			
	        
			return true;
		}
	}

	@Override
	public boolean approveRequest(int id) {
		System.out.println("Approving Request");
		Statement stat;
		
		
		PreparedStatement statement = null;
		int rows = 0;
		try {
			stat = connection.createStatement();
			rows = stat.executeUpdate("update requests set approved = 'true' where id = "+ id);
			System.out.println("This got called");
//			statement = connection.prepareStatement("update requests set approved = "+"'"+"true"+"'"+" where id = ?");
			
//			statement.setInt(1, id);
			
		
			System.out.println("This did too");
//			rows = statement.executeUpdate();
			System.out.println();
			System.out.println(rows + " requests updated");
			
			stat.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0) {
			System.out.println("Request not updated");
			
			
			return false;
			
	        
		}
			
		else {
			logger.info("updated a request on " + new java.util.Date());
			
	        
			return true;
		}
	}

	@Override
	public boolean deleteRequest(int id) {
		System.out.println("Approving Request");
		Statement stat;
		
		
		PreparedStatement statement = null;
		int rows = 0;
		try {
//			stat = connection.createStatement();
//			rows = stat.executeUpdate("delete from requests where id = "+ id);
			
			statement = connection.prepareStatement("delete from requests where id = ?");
			
			statement.setInt(1, id);
			
		
			
			rows = statement.executeUpdate();
			System.out.println();
			System.out.println(rows + " requests deleted");
			
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0) {
			System.out.println("Request not deleted");
			
			
			return false;
			
	        
		}
			
		else {
			logger.info("deleted a request on " + new java.util.Date());
			
	        
			return true;
		}
	}

}
