package com.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.dao.EmployeeAddressDao;
import com.microservices.model.EmployeeAddress;

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
