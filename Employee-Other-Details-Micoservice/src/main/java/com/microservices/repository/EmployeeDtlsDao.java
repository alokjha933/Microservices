package com.microservices.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.microservices.model.EmployeeOtherDtls;

@Repository
public class EmployeeDtlsDao implements EmployeeOtherDtlsRepository {
	private static final String FETCH_ADDRESS_BY_ID = "SELECT * FROM EmployeeOtherDtls WHERE ID=?";
	private static final String ADD_EMPLOYEE_OTHERS_DETAIL = "INSERT INTO EmployeeOtherDtls(id,skill,hobbies) VALUES (?,?,?)";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public EmployeeOtherDtls fetchEmpDtlsById(long id) {
		return jdbcTemplate.queryForObject(FETCH_ADDRESS_BY_ID, new Object[] { id }, new EmployeeDtlsRowMapper());

	}

	@Override
	public void addEmpDtls(EmployeeOtherDtls empDtls) {
		Object[] args = new Object[] { String.valueOf(empDtls.getId()), empDtls.getSkill(), empDtls.getHobbies() };
		jdbcTemplate.update(ADD_EMPLOYEE_OTHERS_DETAIL, args);

	}
}
