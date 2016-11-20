package edu.shop.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.shop.java.dao.OrderDao;
import edu.shop.java.models.Order;

@Repository(value = "orderFileDao")
public class OrderFileDao extends FileAbstractDao<Order> implements OrderDao {

	public OrderFileDao() {
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDatasourceName() {
		// TODO Auto-generated method stub
		return null;
	}
}
