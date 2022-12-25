package com.microservices.repository;

import com.microservices.model.EmployeeOtherDtls;

public interface EmployeeOtherDtlsRepository {

	EmployeeOtherDtls fetchEmpDtlsById(long id);

	void addEmpDtls(EmployeeOtherDtls empDtls);

}
