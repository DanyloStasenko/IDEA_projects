package edu.shop.java.dao;

import java.util.List;

import edu.shop.java.models.Model;

public interface itemDao <T extends Model> {

	public List<T> getAll();
	
	public T getById();
	
	public void add(T model);
	
	public void update(T model);
	
	public void remove(Long id);
	
	public void remove(T model);
}
