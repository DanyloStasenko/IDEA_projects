package edu.shop.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.shop.java.dao.RoleDao;
import edu.shop.java.models.Role;

@Repository(value="roleFileDao")
public class RoleFileDao extends FileAbstractDao<Role> implements RoleDao{

	public RoleFileDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role getById() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public String getDatasourceName() {
		// TODO Auto-generated method stub
		return null;
	}

}
