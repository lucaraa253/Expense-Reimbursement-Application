package com.training.ers.dao;

import java.util.List;

import com.training.ers.models.Manager;
import com.training.ers.models.User;

public interface ManagerDAO {
	public boolean register(Manager manager);
	public boolean validate(String username,String password);
	public List<Manager> getManagers();
	public List<Manager> getManagerByUsername(String username);
}
