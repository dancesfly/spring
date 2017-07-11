package model;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	int id;
	String name;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@NotEmpty(message="不能为空")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
