package com.springboot.demo.event.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmployeeDetailsEventPublishers {

	private ApplicationEventPublisher applicationEventPublisher;
	public void publishEvent(final String message){
		applicationEventPublisher.publishEvent(new EmployeeDtlsMessage(message));
	}
}
