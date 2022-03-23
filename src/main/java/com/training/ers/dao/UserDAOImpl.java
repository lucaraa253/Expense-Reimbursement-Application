package com.training.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.ers.models.User;
import com.training.ers.utility.DBConnection;



public class UserDAOImpl implements UserDAO {

	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	Connection connection = DBConnection.getConnection();
	@Override
	public boolean register(User user) {
		System.out.println("##Adding user :" + user);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into employees2 values(default,?,?,?,?)");
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
		

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
			logger.info(user.getUsername() + " could not be logged in at " + new java.util.Date());
			
			return false;
			
	        
		}
			
		else {
			logger.info(user.getUsername() + " has logged in at " + new java.util.Date());
			
	        
			return true;
		}
			
	}

	@Override
	public boolean validate(String username, String password) {
		boolean userValid = false;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from employees2 where username = ? and password = ? ");
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
	public List<User> getUsers() {
		System.out.println("##Printing all users  ");
		List<User> users = new ArrayList<User>();

		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from employees2");
			while (res.next()) {
				User user = new User();
				user.setId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setFirstName(res.getString(4));
				user.setLastName(res.getString(5));
				
				users.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUsersByUsername(String username) {
		System.out.println("##Printing search users  ");
		User user = new User();

		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from employees2 where username = '"+username+"'");
			while (res.next()) {
				
				user.setId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setFirstName(res.getString(4));
				user.setLastName(res.getString(5));
				

			}
			System.out.println("user coming from UserDAOImpl "+ user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}

	@Override
	public User getUerId(String username) {
		System.out.println("##Printing search users  ");
		User user = new User();

		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select id from employees2 where username = '"+username+"'");
			while (res.next()) {
				
				user.setId(res.getInt(1));
				
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}