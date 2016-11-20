package edu.shop.java.models;

import java.io.Serializable;

public class Model implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	
	public Model() {
		
	}

	public Model(Long id) {
			
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
