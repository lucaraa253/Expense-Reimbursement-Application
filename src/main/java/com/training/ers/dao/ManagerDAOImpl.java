package com.training.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.ers.models.Manager;
import com.training.ers.utility.DBConnection;

public class ManagerDAOImpl implements ManagerDAO {
	
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	Connection connection = DBConnection.getConnection();

	@Override
	public boolean register(Manager manager) {
		System.out.println("##Adding user :" + manager);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into manager values(default,?,?,?,?)");
			statement.setString(1, manager.getUsername());
			statement.setString(2, manager.getPassword());
			statement.setString(3, manager.getFirstName());
			statement.setString(4, manager.getLastName());
		

			rows = statement.executeUpdate();
			System.out.println();
			System.out.println(rows + " user(s) registered successfully");
			
			statement.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0) {
			logger.info(manager.getUsername() + " could not be logged in at " + new java.util.Date());
			
			return false;
		}else {
			logger.info(manager.getUsername() + " has logged in at " + new java.util.Date());
			
	        
			return true;
		}
	        
	}

	@Override
	public boolean validate(String username, String password) {
		boolean userValid = false;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from manager where username = ? and password = ? ");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			userValid = res.next();
			res.close();
			stat.close();
//		    stat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userValid;
	}

	@Override
	public List<Manager> getManagers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manager> getManagerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
