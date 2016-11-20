package edu.shop.java.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role extends Model{

	private static final long serialVersionUID = 1L;
	
	private String title;
	private String decsription;
	
	public Role() {
		super();
	}
	
	public Role(Long id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDecsription() {
		return decsription;
	}

	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}

	
}
