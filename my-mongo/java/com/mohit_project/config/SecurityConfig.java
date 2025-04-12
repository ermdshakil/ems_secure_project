//package com.mohit_project.config;
//
//import org.springframework.context.annotation.Configuration;
//
//
////
////
////import org.springframework.beans.factory.annotation.Autowired;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.authentication.AuthenticationProvider;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
////import org.springframework.security.config.http.SessionCreationPolicy;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
////
////import com.employee.serviceImpl.SecurityCustomUserDetailsServise;
////
//////import com.employee.service.UserSetailsService;
//
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.employee.filter.JwtFilter;
//import com.employee.service.UserInfoService;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private JwtFilter jwtFilter;
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new UserInfoService();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.csrf(csrf->csrf.disable())
//                .authorizeHttpRequests(auth->auth
//                        .requestMatchers("/auth/welcome","/auth/addUser","/auth/login")
//                        .permitAll()
//                        .anyRequest().authenticated())
//                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//
//}
//
//
//	
////	@Autowired
////	private SecurityCustomUserDetailsServise securityCustomUserDetailsServise;
////
//////    @Autowired
//////    private UserSetailsService userSetailsService;
//////    @Autowired
//////    private JWTAuthFilter jwtAuthFilter;
////	
//////	private InMemoryUserDetailsManager inMemoryUserDetailsManager;
////	
//////	@Bean
//////	public UserDetailsService userDetailsService() {
//////		
//////		UserDetails userDetails=User
//////				.withDefaultPasswordEncoder()
//////				.username("admin123")
//////				.password("admin123")
//////				.roles("ADMIN","USER")
//////				.build();
//////		
//////		var inMemoryUserDetailsManager= new InMemoryUserDetailsManager(userDetails);
//////		return inMemoryUserDetailsManager;
//////	}
//////	
////
////	@Bean
////	public DaoAuthenticationProvider authenticationProvider() {
////		
////		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
//////		user details service ka object
////		daoAuthenticationProvider.setUserDetailsService(securityCustomUserDetailsServise);
//////		password encoder ka object
////		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
////		return daoAuthenticationProvider;
////	}
////	
////	
////	@Bean
////	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
////		//cofigaration
////		
////		httpSecurity.authorizeHttpRequests(authorize->{
//////			authorize.requestMatchers("/home","/adminlogin","/adminregistration","/employee_login").permitAll();
////			authorize.requestMatchers("/api/**").authenticated();
////			authorize.anyRequest().permitAll();
////		});
//////		httpSecurity.formLogin(formLogin->{
//////			
//////			formLogin.loginPage("/login");
//////			formLogin.loginProcessingUrl("/authenticate");
//////			formLogin.successForwardUrl("/dashboard");
//////			formLogin.failureForwardUrl("/login?error=true");
//////			formLogin.usernameParameter("email");
//////			formLogin.passwordParameter("password");
//////			
//////			
//////			
//////		});
////		
////		return httpSecurity.build();
////	}
////	
////	
////	
////	@Bean
////	public PasswordEncoder passwordEncoder() {
////		return new BCryptPasswordEncoder();
////	}
////	
//////
//////    @Bean
//////    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//////        httpSecurity.csrf(AbstractHttpConfigurer::disable)
//////                .cors(Customizer.withDefaults())
//////                .authorizeHttpRequests(request-> request.requestMatchers("/auth/**", "/public/**").permitAll()
//////                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
//////                        .requestMatchers("/user/**").hasAnyAuthority("USER")
//////                        .requestMatchers("/adminuser/**").hasAnyAuthority("ADMIN", "USER")
//////                        .anyRequest().authenticated())
//////                .sessionManagement(manager->manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//////                .authenticationProvider(authenticationProvider()).addFilterBefore(
//////                        jwtAuthFilter, UsernamePasswordAuthenticationFilter.class
//////                );
//////        return httpSecurity.build();
//////    }
//////    @Bean
//////    public AuthenticationProvider authenticationProvider(){
//////        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//////        daoAuthenticationProvider.setUserDetailsService(userSetailsService);
//////        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//////        return daoAuthenticationProvider;
//////    }
//////
//////    @Bean
//////    public PasswordEncoder passwordEncoder(){
//////        return new BCryptPasswordEncoder();
//////    }
//////
//////    @Bean
//////    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
//////        return authenticationConfiguration.getAuthenticationManager();
//////    }
//////
////}
////
