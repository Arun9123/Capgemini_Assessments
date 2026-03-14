package com.capgemini.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	@Value("12")
	private int id;
	
	@Value("Mike")
	private String name;
	
	@Value("Male")
	private String gender;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
	
	
}
