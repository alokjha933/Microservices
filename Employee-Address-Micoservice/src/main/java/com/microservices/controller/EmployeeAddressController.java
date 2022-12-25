package com.microservices.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.model.EmployeeAddress;
import com.microservices.model.EmployeeOtherDetails;
import com.microservices.service.EmployeeAddressService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@CrossOrigin("http://localhost:4200/")
@RestController
public class EmployeeAddressController {

	@Autowired
	EmployeeAddressService employeeAddressService;

	@Autowired
	RestTemplate getRestTemplate;

	@GetMapping("/EmployeeAddress/{id}")
	@HystrixCommand(fallbackMethod = "getOnlyEmployeeAddres")
	public EmployeeAddress getEmployeeAddres(@PathVariable int id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		new HttpEntity<String>(headers);

		/*
		 * EmployeeOtherDetails empDetails = getRestTemplate
		 * .exchange("http://Employee-Other-Details-Microservice/EmployeeDtls/" + id,
		 * HttpMethod.GET, entity, EmployeeOtherDetails.class) .getBody();
		 */
		EmployeeOtherDetails empDetails = getRestTemplate.getForObject(
				"http://Employee-Other-Details-Microservice/EmployeeDtls/" + id, EmployeeOtherDetails.class);

		EmployeeAddress employeeAddress = employeeAddressService.fetchAddressByEmployeeId(id);
		employeeAddress.setEmpDtls(empDetails);
		return employeeAddress;
	}

	public EmployeeAddress getOnlyEmployeeAddres(@PathVariable int id) {
		EmployeeAddress employeeAddress = employeeAddressService.fetchAddressByEmployeeId(id);
		return employeeAddress;
	}

	@PostMapping("/EmployeeAddress")
	public ResponseEntity<EmployeeAddress> saveEmployeeAddress(@RequestBody EmployeeAddress empAddresss) {
		employeeAddressService.addEmployeeAddress(empAddresss);
		return ResponseEntity.ok(empAddresss);

	}
}
