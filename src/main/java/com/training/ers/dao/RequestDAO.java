package com.training.ers.dao;


import java.util.List;

import com.training.ers.models.Request;
import com.training.ers.models.User;

public interface RequestDAO {
	public boolean createRequest(Request request, User user);
	
	public List<Request> viewAllRequests(String username); 
	public List<Request> managerViewAll();
	public Request viewSingleRequest(int id);
	public boolean updateRequest(Request request,int id);
	public boolean deleteSingleRequest(int id);
	public boolean approveRequest(int id);
	public boolean deleteRequest(int id);
}
