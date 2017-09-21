package com.ysd.pojo;

import java.io.Serializable;

public class Student implements Serializable {
	
	private String name ;
	private Integer age ;	
	private Grade grade ;
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Grade getGrade() {
		return grade;
	}



	public void setGrade(Grade grade) {
		this.grade = grade;
	}



	public Student() {
		super();
	}



	public Student(String name, Integer age, Grade grade) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
	}



	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + "]";
	}
	
	
	
	

}
