package edu.shop.java.dao.impl;

import org.springframework.stereotype.Repository;

import edu.shop.java.dao.ProductCategoryDao;
import edu.shop.java.models.ProductCategory;

@Repository(value = "productCategoryDatabaseDao")
public class ProductCategoryDatabaseDao extends HibernateAbstractDao<ProductCategory> implements ProductCategoryDao {

	public ProductCategoryDatabaseDao() {
		// TODO Auto-generated constructor stub
	}

}
