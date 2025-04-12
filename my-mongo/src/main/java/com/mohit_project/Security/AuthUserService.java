package com.mohit_project.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mohit_project.paylode.LoginDto;
import com.mohit_project.paylode.UserDto;
import com.mohit_project.Entity.User;
import com.mohit_project.Repositry.UserRepo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class AuthUserService {
	@Autowired
	private GlobalExceptionHandler globalExceptionHandler;
	private final UserRepo userRepository;
	private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	public AuthUserService(UserRepo userRepository, AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User signup(UserDto input) {
		User user = new User();
		user.setName(input.getName());
		user.setEmail(input.getEmail());
		user.setRole(input.getRole());
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		//user.setPassword(input.getPassword());

		return userRepository.save(user);
	}

/*	public User authenticateUser(LoginDto input) {
		logger.info("Authenticate User for Username:  {}", input.getEmail());
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
		User user =userRepository.findByEmailAndPassword(input.getEmail(), input.getPassword());//.orElseThrow();
		if(user!= null) {
			logger.info("Authenticated User Successfully.");
			return user;
		}else {
			//globalExceptionHandler.handleSecurityException(userRepository.findByEmail(input.getEmail()).orElseThrow());
		logger.info("User Not Found or The username or password is incorrect!");
		return user;
		//return userRepository.findByEmail(input.getEmail()).orElseThrow();
		}
	}*/
	public User authenticateUser(LoginDto input) { 
		logger.info("Authenticate User for Username:  {}", input.getEmail());
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
		  return userRepository.findByEmail(input.getEmail()).orElseThrow();
		  }
}
