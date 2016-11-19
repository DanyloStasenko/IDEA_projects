package edu.shop.java.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends Model{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	
	public User() {
		super();
	}
	
	public User(Long id) {
		super(id);
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
