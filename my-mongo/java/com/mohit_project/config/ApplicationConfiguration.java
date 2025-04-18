package com.mohit_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mohit_project.Repositry.EmployeeRepo;
import com.mohit_project.Repositry.UserRepo;


@Configuration
public class ApplicationConfiguration {
    //private EmployeeRepo empRepository;
    private final UserRepo userRepository;
    
 
    public ApplicationConfiguration(UserRepo userRepository) {
        this.userRepository = userRepository;
    }
    @Bean
    UserDetailsService userDetailsService() {
		/*
		 * if(empRepository ==null){ return username ->
		 * userRepository.findByEmail(username) .orElseThrow(() -> new
		 * UsernameNotFoundException("User not found")); }else{
		 */
    		return username -> userRepository.findByEmail(username)
    	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    	
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        
        return authProvider;
    }
}