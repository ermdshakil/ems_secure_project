package com.mohit_project.Security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mohit_project.Entity.Employee;
import com.mohit_project.Service.EmployeeService;
import com.mohit_project.paylode.EmployeeDto;
import com.mohit_project.paylode.LoginDto;


@RequestMapping("/employee/auth")
@RestController
public class AuthenticationEmpController {
	
    private final JwtService jwtService;
    
    private final AuthEmployeeService authenticationEmpService;
    
    private final PasswordEncoder passwordEncoder;
    
    private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
    
	@Autowired
	private EmployeeService employeeService;
    
    public AuthenticationEmpController(JwtService jwtService, AuthEmployeeService authenticationEmpService, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.authenticationEmpService = authenticationEmpService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<EmployeeDto> register(@RequestBody EmployeeDto registerEmpDto) {
		/*
		 * EmployeeDto registeredEmp = authenticationEmpService.signup(registerEmpDto);
		 * return ResponseEntity.ok(registeredEmp);
		 */
    	registerEmpDto.setPassword(passwordEncoder.encode(registerEmpDto.getPassword()));
        EmployeeDto createEmployeeDto=this.employeeService.createEmployee(registerEmpDto);
		return new ResponseEntity<EmployeeDto>(createEmployeeDto,HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto empuser) {
    	LoginResponse loginResponse = new LoginResponse();
        Employee authenticatedUser = authenticationEmpService.authenticate(empuser);
    	if(authenticatedUser !=null) {
    		logger.info(" Token generating for employee :  {}", empuser.getEmail());
    		String jwtToken = jwtService.generateToken(authenticatedUser);
    		logger.info(" Token generated successfully");
    		//LoginResponse loginResponse = new LoginResponse();
    		loginResponse.setToken(jwtToken);
    		loginResponse.setExpiresIn(jwtService.getExpirationTime());
    		return ResponseEntity.ok(loginResponse);
    		}else
    			return ResponseEntity.ok(loginResponse);
    }
    
	
}
