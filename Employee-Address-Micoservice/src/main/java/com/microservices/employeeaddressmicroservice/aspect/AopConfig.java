package com.microservices.employeeaddressmicroservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class AopConfig {

	private Logger log = LoggerFactory.getLogger(AopConfig.class);

	@Before(value = "execution(* com.microservices.employeeaddressmicroservice.controller.EmployeeAddressController.*(..))")
	public void logStatementBefore(JoinPoint joinPoint) {
		log.info("Executing {}", joinPoint);

	}

	@After(value = "execution(* com.microservices.employeeaddressmicroservice.controller.EmployeeAddressController.*(..))")
	public void logStatementAfter(JoinPoint joinPoint) {
		log.info("Executing {}", joinPoint);

	}
}
