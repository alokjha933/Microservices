package com.microservices.employeeotherdetailsmicroservice.repository;

import com.microservices.employeeotherdetailsmicroservice.model.EmployeeOtherDtls;

public interface EmployeeOtherDtlsRepository {

	EmployeeOtherDtls fetchEmpDtlsById(long id);

	void addEmpDtls(EmployeeOtherDtls empDtls);

}
