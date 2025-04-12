package com.mohit_project.Security;
/*
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.Employee;
import com.mohit_project.Entity.User;
import com.mohit_project.Repositry.EmployeeRepo;
import com.mohit_project.Repositry.UserRepo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private EmployeeRepo employeeRepository;
    

    public CustomUserDetailsService(UserRepo userRepository, EmployeeRepo employeeRepository) {
		super();
		this.userRepository = userRepository;
		this.employeeRepository = employeeRepository;
	}

	public CustomUserDetailsService() {
		super();
	}

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        if (employee.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                employee.get().getUsername(),
                employee.get().getPassword(),
                List.of(new SimpleGrantedAuthority("EMPLOYEE"))
            );
        }

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                user.get().getUsername(),
                user.get().getPassword(),
                List.of(new SimpleGrantedAuthority(user.get().getRole()))
            );
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
/*
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	    String username = authentication.getName();
	    String password = authentication.getCredentials().toString();

	    // Replace this with your actual user validation logic
	    if ("user".equals(username) && "password".equals(password)) {
	        return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
	    } else {
	        throw new BadCredentialsException("Invalid username or password");
	    }
	}


	@Override
	public boolean supports(Class<?> authentication) {
	    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

    
}*/