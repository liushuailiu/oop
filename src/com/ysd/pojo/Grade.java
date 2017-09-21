package com.ysd.pojo;

import java.io.Serializable;

public class Grade implements Serializable{
	
	private Integer id;
	private String name;
	
	public Grade() {
		super();
	}

	public Grade(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
