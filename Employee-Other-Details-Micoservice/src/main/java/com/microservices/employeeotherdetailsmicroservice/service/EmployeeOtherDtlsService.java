package com.microservices.employeeotherdetailsmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.employeeotherdetailsmicroservice.model.EmployeeOtherDtls;
import com.microservices.employeeotherdetailsmicroservice.repository.EmployeeDtlsDao;

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
