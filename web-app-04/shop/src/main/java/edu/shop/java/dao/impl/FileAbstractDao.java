package edu.shop.java.dao.impl;

import edu.shop.java.dao.accessors.FileDatasourceAccessor;
import edu.shop.java.models.Model;

public abstract class FileAbstractDao <T extends Model> extends FileDatasourceAccessor{

	public void add(T model){
		
	}
	
	
	public void update(T model){
		
	}
	
	public void remove(Long id){
	
	}
	
	
	public void remove(T model) {
		this.remove(model.getId());
	}
	

}
