package edu.shop.java.dao;

import edu.shop.java.models.User;

public interface UserDao extends itemDao<User> {
	
	public User getByUsername(String username);
}
