package edu.shop.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.shop.java.dao.UserDao;
import edu.shop.java.dao.accessors.FileDatasourceAccessor;
import edu.shop.java.models.User;

@Repository("userFileDao")
public class UserFileDao extends FileDatasourceAccessor implements UserDao{

	public public UserFileDao() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(User model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(User model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDatasourceName() {
		// TODO Auto-generated method stub
		return null;
	}

}
