package com.mohit_project.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mohit_project.paylode.LoginDto;
import com.mohit_project.paylode.UserDto;
import com.mohit_project.Entity.User;


@RequestMapping("/user/auth")

@RestController
public class AuthenticationUserController {

	private final JwtService jwtService;

	private final AuthUserService authenticationService;

	private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);

	public AuthenticationUserController(JwtService jwtService, AuthUserService authenticationService) {
		this.jwtService = jwtService;
		this.authenticationService = authenticationService;
	}

	@PostMapping("/signup")
	public ResponseEntity<User> register(@RequestBody UserDto registerUserDto) {
		User registeredUser = authenticationService.signup(registerUserDto);

		return ResponseEntity.ok(registeredUser);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto loginUser) {
		LoginResponse loginResponse = new LoginResponse();
		User authenticatedUser = authenticationService.authenticateUser(loginUser);
		if(authenticatedUser !=null) {
		logger.info(" Token generating for User :  {}", loginUser.getEmail());
		String jwtToken = jwtService.generateToken(authenticatedUser);
		logger.info(" Token Generated Successfully");
		//LoginResponse loginResponse = new LoginResponse();
		loginResponse.setToken(jwtToken);
		loginResponse.setExpiresIn(jwtService.getExpirationTime());
		return ResponseEntity.ok(loginResponse);
		}else
			return ResponseEntity.ok(loginResponse);
		}
	

}
