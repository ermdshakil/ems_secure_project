package com.mohit_project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeebymohitApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeebymohitApplication.class, args);
		System.out.print("hello employee");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
