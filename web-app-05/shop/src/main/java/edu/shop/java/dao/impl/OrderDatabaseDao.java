package edu.shop.java.dao.impl;

import org.springframework.stereotype.Repository;

import edu.shop.java.dao.OrderDao;
import edu.shop.java.models.Order;

@Repository(value="orderDatabaseDao")
public class OrderDatabaseDao extends HibernateAbstractDao<Order> implements OrderDao {

	public OrderDatabaseDao() {
		
	}

}
