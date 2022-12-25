package com.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.model.EmployeeOtherDtls;
import com.microservices.repository.EmployeeDtlsDao;

@Service
public class EmployeeOtherDtlsService {
	@Autowired
	EmployeeDtlsDao employeeDtlsDao;

	public EmployeeOtherDtls fetchEmpDtlsByEmployeeId(long id) {
		return employeeDtlsDao.fetchEmpDtlsById(id);
	}

	public void addEmployeeDtls(EmployeeOtherDtls empDtls) {
		employeeDtlsDao.addEmpDtls(empDtls);
	}
}
