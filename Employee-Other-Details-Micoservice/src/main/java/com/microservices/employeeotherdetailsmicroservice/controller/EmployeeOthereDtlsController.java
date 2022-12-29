package com.microservices.employeeotherdetailsmicroservice.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.employeeotherdetailsmicroservice.model.EmployeeOtherDtls;
import com.microservices.employeeotherdetailsmicroservice.service.EmployeeOtherDtlsService;

@CrossOrigin("http://localhost:4200/")
@RestController
public class EmployeeOthereDtlsController {

	private static final Logger logger = Logger.getLogger(EmployeeOthereDtlsController.class.getName());
	@Autowired
	EmployeeOtherDtlsService employeeOthereDtlsService;

	@GetMapping("/EmployeeDtls/{id}")
	public EmployeeOtherDtls getEmployeeAddres(@PathVariable int id) {
		logger.log(Level.INFO, "Fetching Employee Address By ID:  "+id);
		return employeeOthereDtlsService.fetchEmpDtlsByEmployeeId(id);
	}

	@PostMapping("/EmployeeDtls")
	public ResponseEntity<EmployeeOtherDtls> saveEmployeeAddress(@RequestBody EmployeeOtherDtls empAddresss) {
		logger.log(Level.INFO, "Saving Employee Address By ID:  "+empAddresss.getSkill());

		employeeOthereDtlsService.addEmployeeDtls(empAddresss);
		return ResponseEntity.ok(empAddresss);

	}
}
