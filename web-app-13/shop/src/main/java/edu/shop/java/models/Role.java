package edu.shop.java.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="role")
public class Role extends Model{

	private static final long serialVersionUID = 4920250090954381612L;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="title", length=25, insertable=false, updatable=false)
	private RoleList title;
	
	@Column(name="title", length=255)
	private String description;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users = new HashSet<>();
	
	public Role() {
		super();
	}
	
	public Role(Long id) {
		super(id);
	}


	public RoleList getTitle() {
		return title;
	}

	public void setTitle(RoleList title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String decsription) {
		this.description = decsription;
	}

	
}
