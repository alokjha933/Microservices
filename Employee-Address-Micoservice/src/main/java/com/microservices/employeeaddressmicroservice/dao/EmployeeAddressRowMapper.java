package com.microservices.employeeaddressmicroservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.microservices.employeeaddressmicroservice.model.EmployeeAddress;

public class EmployeeAddressRowMapper implements RowMapper<EmployeeAddress> {

	@Override
	public EmployeeAddress mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmployeeAddress eadd = new EmployeeAddress();
		eadd.setId(rs.getInt("id"));
		eadd.setCity(rs.getString("city"));
		eadd.setPostCd(rs.getString("postCd"));
		eadd.setCountry(rs.getString("country"));
		return eadd;
	}

}
