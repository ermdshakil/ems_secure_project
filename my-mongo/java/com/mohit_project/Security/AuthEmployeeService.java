package com.mohit_project.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mohit_project.Entity.Employee;
import com.mohit_project.Repositry.EmployeeRepo;
import com.mohit_project.paylode.EmployeeDto;
import com.mohit_project.paylode.LoginDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class AuthEmployeeService {
	private final EmployeeRepo empRepository;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;
	private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
    

	public AuthEmployeeService(EmployeeRepo empRepository, AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.empRepository = empRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public EmployeeDto signup(EmployeeDto registerEmpDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee authenticate(LoginDto input) {
		logger.info("Authenticate employee for username:  {}", input.getEmail());
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
		return empRepository.findByEmail(input.getEmail()).orElseThrow();
	}




}
