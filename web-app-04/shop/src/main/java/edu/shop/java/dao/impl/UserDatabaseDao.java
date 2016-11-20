package edu.shop.java.dao.impl;

import org.springframework.stereotype.Repository;

import edu.shop.java.dao.UserDao;
import edu.shop.java.models.User;

@Repository(value="userDatabaseDao")
public class UserDatabaseDao extends HibernateAbstractDao<User> implements UserDao {

	public UserDatabaseDao() {
		// TODO Auto-generated constructor stub
	}
	
}
