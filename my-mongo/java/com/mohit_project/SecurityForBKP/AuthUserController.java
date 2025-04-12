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
 * import com.mohit_project.Entity.User; import
 * com.mohit_project.Security.LoginResponse; import
 * com.mohit_project.paylode.LoginDto; import com.mohit_project.paylode.UserDto;
 * 
 * @RequestMapping("/user_auth")
 * 
 * @RestController public class AuthUserController {
 * 
 * private final JwtService jwtService;
 * 
 * private final AuthUserService authenticationUserService;
 * 
 * private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
 * 
 * public AuthUserController(JwtService jwtService, AuthUserService
 * authenticationUserService) { this.jwtService = jwtService;
 * this.authenticationUserService = authenticationUserService; }
 * 
 * @PostMapping("/signup") public ResponseEntity<User> register(@RequestBody
 * UserDto registerUserDto) { User registeredUser =
 * authenticationUserService.signup(registerUserDto);
 * 
 * return ResponseEntity.ok(registeredUser); }
 * 
 * @PostMapping("/login") public ResponseEntity<LoginResponse>
 * authenticate(@RequestBody LoginDto user) {
 * this.logger.warn("calling authentication"); User authenticatedUser =
 * authenticationUserService.authenticateUser(user); String jwtToken =
 * jwtService.generateToken(authenticatedUser);
 * 
 * LoginResponse loginResponse = new LoginResponse();
 * loginResponse.setToken(jwtToken);
 * loginResponse.setExpiresIn(jwtService.getExpirationTime());
 * 
 * return ResponseEntity.ok(loginResponse); } }
 */