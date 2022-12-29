package com.microservices.employeeaddressmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.employeeaddressmicroservice.dao.EmployeeAddressDao;
import com.microservices.employeeaddressmicroservice.model.EmployeeAddress;

@Service
public class EmployeeAddressService {

	@Autowired
	EmployeeAddressDao employeeAddressDao;

	public EmployeeAddress fetchAddressByEmployeeId(long id) {
		return employeeAddressDao.fetchAddressById(id);
	}

	public void addEmployeeAddress(EmployeeAddress empAddress) {
		employeeAddressDao.addAddress(empAddress);
	}
}
