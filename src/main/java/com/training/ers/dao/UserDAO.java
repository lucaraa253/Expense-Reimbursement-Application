package com.training.ers.dao;

import java.util.List;

import com.training.ers.models.User;


public interface UserDAO {
	public boolean register(User user);
	public boolean validate(String username,String password);
	public List<User> getUsers();
	public User getUsersByUsername(String username);
	public User getUerId(String username);
		
	
}
