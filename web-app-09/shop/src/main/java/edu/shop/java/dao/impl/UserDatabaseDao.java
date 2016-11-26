package edu.shop.java.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import edu.shop.java.dao.UserDao;
import edu.shop.java.models.User;

@Repository(value="userDatabaseDao")
public class UserDatabaseDao extends HibernateAbstractDao<User> implements UserDao {

	public UserDatabaseDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User getByUsername(String username) {
		
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		
		return (User) criteria.uniqueResult();
	}
	
}
