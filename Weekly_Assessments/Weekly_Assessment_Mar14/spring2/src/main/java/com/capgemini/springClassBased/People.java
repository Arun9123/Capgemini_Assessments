package com.capgemini.springClassBased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class People {
	private int id;
	private String name;
	private String gender;
	
	public People(@Value("456") int id, @Value("Tarak") String name, @Value("Male") String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
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
		return "People [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
	
}
