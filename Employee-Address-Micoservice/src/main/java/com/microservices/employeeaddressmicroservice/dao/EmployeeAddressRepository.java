package com.microservices.employeeaddressmicroservice.dao;

import com.microservices.employeeaddressmicroservice.model.EmployeeAddress;

public interface EmployeeAddressRepository {

	// EmployeeAddress saveAddress(EmployeeAddress emp);

//	EmployeeAddress updateAddress(EmployeeAddress emp);

	// String deleteAddress(long id);

	EmployeeAddress fetchAddressById(long id);

	void addAddress(EmployeeAddress empadd);

	// List<EmployeeAddress> fetchListOfEmployee();
}
