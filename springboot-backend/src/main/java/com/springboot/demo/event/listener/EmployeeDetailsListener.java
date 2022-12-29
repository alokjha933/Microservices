package com.springboot.demo.event.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.springboot.demo.event.publisher.EmployeeDtlsMessage;

@Component
public class EmployeeDetailsListener {

	@EventListener
	@Async
	public void eventListener(EmployeeDtlsMessage employeeDtlsMessage) {
		System.out.println("Event Consumed: "+employeeDtlsMessage.getMessage());
	}
}
