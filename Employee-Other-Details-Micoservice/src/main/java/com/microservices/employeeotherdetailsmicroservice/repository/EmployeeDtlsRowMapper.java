package com.microservices.employeeotherdetailsmicroservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.microservices.employeeotherdetailsmicroservice.model.EmployeeOtherDtls;

public class EmployeeDtlsRowMapper implements RowMapper<EmployeeOtherDtls> {

	@Override
	public EmployeeOtherDtls mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmployeeOtherDtls eadd = new EmployeeOtherDtls();
		eadd.setId(rs.getInt("id"));
		eadd.setSkill(rs.getString("skill"));
		eadd.setHobbies(rs.getString("hobbies"));
		return eadd;
	}

}
