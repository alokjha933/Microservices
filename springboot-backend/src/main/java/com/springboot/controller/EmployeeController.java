package com.springboot.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Employee;
import com.springboot.model.EmployeeAddress;
import com.springboot.repository.EmployeeRepository;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RestTemplate getRestTemplate;

	// get All Employee details
	@GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() {
		List<Employee> empList = employeeRepository.findAll();
		System.out.println(empList);
		return empList;
	}

	// create Employee
	@PostMapping(value = "/employees")
	public Employee addEmployees(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	// get Employee Details by Id

	@GetMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@HystrixCommand(fallbackMethod = "getOnlyEmployeeDtlsById")
	public ResponseEntity<Employee> getEmployeeDtlsById(@PathVariable Long id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		new HttpEntity<String>(headers);
		/*
		 * only work when we have port EmployeeAddress empAddress = getRestTemplate
		 * .exchange("http://localhost:8080/EmployeeAddress/" + id, HttpMethod.GET,
		 * entity, EmployeeAddress.class) .getBody();
		 */
		EmployeeAddress empAddress = getRestTemplate
				.getForObject("http://Employee-Address-Microservice/EmployeeAddress/" + id, EmployeeAddress.class);

		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee Deatils not avaialble for the entered Id: " + id));

		employee.setEmpAddress(empAddress);
		employee.getEmpAddress().setEmpDtls(empAddress.getEmpDtls());

		return ResponseEntity.ok(employee);
	}

	@GetMapping(value = "/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getOnlyEmployeeDtlsById(@PathVariable Long id) {

		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee Deatils not avaialble for the entered Id: " + id));
		return ResponseEntity.ok(employee);
	}

	// Update Employee Details
	@PutMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable Long id,
			@RequestBody Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee Deatils not avaialble for the entered Id: " + id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setImage(employeeDetails.getImage());
		Employee updateEmployee = employeeRepository.save(employee);

		return ResponseEntity.ok(updateEmployee);
	}

	// delete Employee
	@DeleteMapping(value = "/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee Deatils not avaialble for the entered Id: " + id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	/*
	 * @GetMapping(value="/employees/{id}") public String getImgUrl(@PathVariable
	 * Long id) { return employeeRepository.findById(id).get().getImage(); }
	 */

}
