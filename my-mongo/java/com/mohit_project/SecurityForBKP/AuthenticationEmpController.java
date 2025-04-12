/*
 * package com.mohit_project.SecurityForBKP;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import com.mohit_project.Entity.Employee; import
 * com.mohit_project.Entity.User; import com.mohit_project.Security.JwtService;
 * import com.mohit_project.Security.LoginResponse; import
 * com.mohit_project.paylode.EmployeeDto; import
 * com.mohit_project.paylode.LoginDto; import com.mohit_project.paylode.UserDto;
 * 
 * @RequestMapping("/employee_auth")
 * 
 * @RestController public class AuthenticationEmpController {
 * 
 * private final JwtService jwtService;
 * 
 * private final AuthenticationEmpService authenticationEmpService;
 * 
 * private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
 * 
 * public AuthenticationEmpController(JwtService jwtService,
 * AuthenticationEmpService authenticationEmpService) { this.jwtService =
 * jwtService; this.authenticationEmpService = authenticationEmpService; }
 * 
 * @PostMapping("/signup") public ResponseEntity<EmployeeDto>
 * register(@RequestBody EmployeeDto registerEmpDto) { EmployeeDto registeredEmp
 * = authenticationEmpService.signup(registerEmpDto);
 * 
 * return ResponseEntity.ok(registeredEmp); }
 * 
 * @PostMapping("/login") public ResponseEntity<LoginResponse>
 * authenticate(@RequestBody LoginDto empuser) { Employee authenticatedUser =
 * authenticationEmpService.authenticate(empuser); String jwtToken =
 * jwtService.generateToken(authenticatedUser);
 * 
 * LoginResponse loginResponse = new LoginResponse();
 * loginResponse.setToken(jwtToken);
 * loginResponse.setExpiresIn(jwtService.getExpirationTime());
 * 
 * return ResponseEntity.ok(loginResponse); } }
 */