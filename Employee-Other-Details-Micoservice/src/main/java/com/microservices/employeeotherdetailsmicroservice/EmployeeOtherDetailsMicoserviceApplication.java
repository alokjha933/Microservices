package com.microservices.employeeotherdetailsmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.microservices")
@EnableJpaRepositories(basePackages = "com.microservices.dao")
@EntityScan(basePackages = "com.microservices.model")
@EnableAutoConfiguration
@EnableEurekaClient
public class EmployeeOtherDetailsMicoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeOtherDetailsMicoserviceApplication.class, args);
	}

}
