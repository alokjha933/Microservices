package com.springboot.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.controller.EmployeeController;
import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBackendApplicationTests {

	@Autowired
	EmployeeController employeeController;

	@Autowired
	EmployeeRepository empRepo;

	Employee emp;

	@Test
	@Order(1)
	public void saveEmployeeDtls() {

		emp = employeeController.addEmployees(new Employee(1233, "Akoiu", "Joseph", "NA"));
		Employee empDtls = empRepo.getById(emp.getId());
		assertThat(empDtls).isNotNull();
	}

	@Test
	@Order(2)
	public void deleteDtls() {
		employeeController.deleteEmployee(emp.getId());
		Employee empDtls = empRepo.getById(emp.getId());
		assertThat(empDtls).isNull();
	}

	@Test
	@Disabled
	@Order(3)
	public void fetchStudentDtlsById() {
		/*
		 * ResponseEntity<Employee> emp =
		 * employeeController.getOnlyEmployeeDtlsById(123L); emp.getEmailId();
		 * assertThat("alok.digitronics@yahoo.com").isEqualTo(emp.getEmailId());
		 */
	}

}
