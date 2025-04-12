/*
 * package com.mohit_project.SecurityForBKP;
 * 
 * import org.springframework.security.authentication.AuthenticationManager;
 * import org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Service;
 * 
 * import com.mohit_project.Entity.Employee; import
 * com.mohit_project.Entity.User; import
 * com.mohit_project.Repositry.EmployeeRepo; import
 * com.mohit_project.paylode.EmployeeDto; import
 * com.mohit_project.paylode.LoginDto; import
 * com.mohit_project.serviceIpml.EmployeeServiceImp;
 * 
 * import lombok.Getter; import lombok.Setter;
 * 
 * @Getter
 * 
 * @Setter
 * 
 * @Service public class AuthenticationEmpService { private final EmployeeRepo
 * empRepository;
 * 
 * private final PasswordEncoder passwordEncoder;
 * 
 * private final AuthenticationManager authenticationManager;
 * 
 * public AuthenticationEmpService(EmployeeRepo empRepository,
 * AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder)
 * { this.authenticationManager = authenticationManager; this.empRepository =
 * empRepository; this.passwordEncoder = passwordEncoder; }
 * 
 * public Employee authenticate(LoginDto input) { authenticationManager
 * .authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(),
 * input.getPassword()));
 * 
 * return empRepository.findByEmail(input.getEmail()).orElseThrow(); }
 * 
 * public EmployeeDto signup(EmployeeDto registerEmpDto) { EmployeeServiceImp
 * empService = new EmployeeServiceImp(); return
 * empService.createEmployee(registerEmpDto); } }
 */