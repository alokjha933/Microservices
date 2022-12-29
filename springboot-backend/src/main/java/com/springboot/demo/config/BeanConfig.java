package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

@Configuration
public class BeanConfig {

	@Bean
	public Gson gsonBean() {
		return new Gson();
	}
}
