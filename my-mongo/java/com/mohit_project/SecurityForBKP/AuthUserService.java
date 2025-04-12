/*
 * package com.mohit_project.SecurityForBKP;
 * 
 * import org.springframework.security.authentication.AuthenticationManager;
 * import org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Service;
 * 
 * import com.mohit_project.Entity.User; import
 * com.mohit_project.Repositry.UserRepo; import
 * com.mohit_project.paylode.LoginDto; import com.mohit_project.paylode.UserDto;
 * 
 * import lombok.Getter; import lombok.Setter;
 * 
 * @Getter
 * 
 * @Setter
 * 
 * @Service public class AuthUserService { private final UserRepo
 * userRepository;
 * 
 * private final PasswordEncoder passwordEncoder;
 * 
 * private final AuthenticationManager authenticationManager;
 * 
 * public AuthUserService(UserRepo userRepository, AuthenticationManager
 * authenticationManager, PasswordEncoder passwordEncoder) {
 * this.authenticationManager = authenticationManager; this.userRepository =
 * userRepository; this.passwordEncoder = passwordEncoder; }
 * 
 * public User signup(UserDto input) { User user = new User();
 * user.setName(input.getName()); user.setRole(input.getRole());
 * user.setEmail(input.getEmail());
 * user.setPassword(passwordEncoder.encode(input.getPassword()));
 * 
 * return userRepository.save(user); }
 * 
 * public User authenticateUser(LoginDto input) { authenticationManager
 * .authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(),
 * input.getPassword()));
 * 
 * return userRepository.findByEmail(input.getEmail()).orElseThrow(); }
 * 
 * }
 */