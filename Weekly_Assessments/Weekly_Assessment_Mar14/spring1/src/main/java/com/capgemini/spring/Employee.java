package com.capgemini.spring;

public class Employee {
	private int id;
	private String name;
	private String email;
	private double salary;
	private Student student;
	
	public Employee() {
		System.out.println("Employee Constructor");
	}
	
	public Employee(int id, String name, String email, double salary, Student student) {
		System.out.println("Employee All args");
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.student = student;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + ", student="
				+ student + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
