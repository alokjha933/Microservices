package com.microservices.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.microservices.model.EmployeeAddress;

@Repository
public class EmployeeAddressDao implements EmployeeAddressRepository {
	private static final String FETCH_ADDRESS_BY_ID = "SELECT * FROM EmployeeAddress WHERE ID=?";
	private static final String ADD_EMPLOYEE_ADDRESS = "INSERT INTO EmployeeAddress(id,city,postCd,country) VALUES (?,?,?,?)";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public EmployeeAddress fetchAddressById(long id) {
		return jdbcTemplate.queryForObject(FETCH_ADDRESS_BY_ID, new Object[] { id }, new EmployeeAddressRowMapper());

	}

	@Override
	public void addAddress(EmployeeAddress empadd) {
		Object[] args = new Object[] { String.valueOf(empadd.getId()), empadd.getCity(), empadd.getPostCd(),
				empadd.getCountry() };
		jdbcTemplate.update(ADD_EMPLOYEE_ADDRESS, args);

	}
}
