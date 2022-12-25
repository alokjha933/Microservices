package com.microservices.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class EmployeeAddress implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String city;
	private String postCd;
	private String country;

	@Transient
	private EmployeeOtherDetails empDtls;

	public EmployeeOtherDetails getEmpDtls() {
		return empDtls;
	}

	public void setEmpDtls(EmployeeOtherDetails empDtls) {
		this.empDtls = empDtls;
	}

	public EmployeeAddress() {
	}

	public EmployeeAddress(String city, String postCd, String country) {
		this.city = city;
		this.postCd = postCd;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCd() {
		return postCd;
	}

	public void setPostCd(String postCd) {
		this.postCd = postCd;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
