package com.microservices.model;

import java.io.Serializable;

public class EmployeeOtherDetails implements Serializable {

	private int id;

	private String skill;
	private String hobbies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public EmployeeOtherDetails(int id, String skill, String hobbies) {
		this.id = id;
		this.skill = skill;
		this.hobbies = hobbies;
	}

	public EmployeeOtherDetails() {
	}

}