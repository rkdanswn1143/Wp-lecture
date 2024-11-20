package com.wp.eltest;

public class PersonalInfo {

	private String name;
	private char gender;
	private int birth_year;

	public PersonalInfo() {
		// TODO Auto-generated constructor stub
	}

	public PersonalInfo(String name, char gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		setAge(age);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return (new java.util.Date()).getYear() - birth_year;
	}
	
	public void setAge(int age) {
		this.birth_year = (new java.util.Date()).getYear() - age;
	}
	
}
