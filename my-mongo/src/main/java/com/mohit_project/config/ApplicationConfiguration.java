package com.mohit_project.config;

import com.mohit_project.Entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mohit_project.Repositry.EmployeeRepo;
import com.mohit_project.Repositry.UserRepo;

import java.util.ArrayList;


@Configuration
public class ApplicationConfiguration {
    private final EmployeeRepo empRepository;
    private final UserRepo userRepository;
    
 
    public ApplicationConfiguration(EmployeeRepo empRepository, UserRepo userRepository) {
        this.empRepository = empRepository;
        this.userRepository = userRepository;
    }
    /*@Bean
    UserDetailsService userDetailsService() {
		  return username ->  userRepository.findByEmail(username)
                  .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    		return username -> userRepository.findByEmail(username)
    	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    	
    }*/

    @Bean
    UserDetailsService userDetailsService() {
        return username -> {
            // First, check if the user is in the EmployeeRepo
            Employee employee = empRepository.findByEmail(username);
            if (employee != null) {
                return new User(employee.getEmail(), employee.getPassword(), new ArrayList<>());  // Return employee as UserDetails
            }

            // Otherwise, check the UserRepo
            return userRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        };
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