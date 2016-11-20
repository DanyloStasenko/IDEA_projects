package edu.shop.java.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.shop.java.dao.ProductDao;
import edu.shop.java.models.Product;

@Repository(value="productFileDao")
public class ProductFileDao extends FileAbstractDao<Product> implements ProductDao{

	public ProductFileDao() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDatasourceName() {
		return null;
	}

}
