package com.mohit_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mohit_project.Security.JwtAuthenticationFilter;





@Configuration
public class SecurityConfiguration {
	
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfiguration(
        JwtAuthenticationFilter jwtAuthenticationFilter,
        AuthenticationProvider authenticationProvider
    ) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


   @Bean
   SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.csrf(csrf -> csrf.disable())
              .authorizeHttpRequests(auth->auth
                      .requestMatchers("/auth/welcome","/employee/auth/signup","/employee/auth/login","/user/auth/signup","/user/auth/login")
                      .permitAll()
                      .anyRequest().authenticated())
             .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             .authenticationProvider(authenticationProvider)
              .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
              return http.build(); 
  }
	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity
	 * httpSecurity) throws Exception { //cofigaration
	 * 
	 * httpSecurity.authorizeHttpRequests(authorize->
	 * authorize.requestMatchers("/auth/welcome","/auth/signup","/auth/login",
	 * "/home","/adminlogin","/adminregistration","/api/user/login")
	 * .permitAll().requestMatchers("/api/**").authenticated().anyRequest().
	 * permitAll());
	 * httpSecurity.sessionManagement(session->session.sessionCreationPolicy(
	 * SessionCreationPolicy.STATELESS))
	 * .authenticationProvider(authenticationProvider)
	 * .addFilterBefore(jwtAuthenticationFilter,
	 * UsernamePasswordAuthenticationFilter.class);
	 * 
	 * 
	 * httpSecurity.formLogin(formLogin->{
	 * 
	 * formLogin.loginPage("/login"); formLogin.loginProcessingUrl("/authenticate");
	 * formLogin.successForwardUrl("/dashboard");
	 * formLogin.failureForwardUrl("/login?error=true");
	 * formLogin.usernameParameter("email");
	 * formLogin.passwordParameter("password"); });
	 * 
	 * return httpSecurity.build(); }
	 */

/*
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity
 * httpSecurity) throws Exception{
 * httpSecurity.csrf(AbstractHttpConfigurer::disable)
 * .cors(Customizer.withDefaults()) .authorizeHttpRequests(request->
 * request.requestMatchers("/auth/**", "/public/**").permitAll()
 * .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
 * .requestMatchers("/user/**").hasAnyAuthority("USER")
 * .requestMatchers("/adminuser/**").hasAnyAuthority("ADMIN", "USER")
 * .anyRequest().authenticated())
 * .sessionManagement(manager->manager.sessionCreationPolicy(
 * SessionCreationPolicy.STATELESS))
 * .authenticationProvider(authenticationProvider()).addFilterBefore(
 * jwtAuthFilter, UsernamePasswordAuthenticationFilter.class ); return
 * httpSecurity.build(); }
 */
  
}
