package com.Auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringConfig {
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    // In-Memory User Details Service Bean
	    @Bean
	    public UserDetailsService userDetailsService() {
	        UserDetails admin = User.builder()
	                .username("ElonMusk")
	                .password(passwordEncoder().encode("0071"))
	                .roles("ADMIN")
	                .build();

	        UserDetails user = User.builder()
	                .username("John")
	                .password(passwordEncoder().encode("0081"))
	                .roles("USER")
	                .build();

	        return new InMemoryUserDetailsManager(admin, user);
	    }
	    
	    @Bean
	    public SecurityFilterChain securityFilterChain (HttpSecurity security) throws Exception {
	       
	       return security.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(authorize -> authorize
	        		.requestMatchers(HttpMethod.GET).hasAnyRole("ADMIN")
	        		.requestMatchers(HttpMethod.POST).hasAnyRole("USER")
	        		.requestMatchers(HttpMethod.PUT).hasAnyRole("USER")
	        		.requestMatchers(HttpMethod.DELETE).hasAnyRole("USER")
	        		.anyRequest().authenticated())
	        .httpBasic(Customizer.withDefaults())
	        .build();

}
}
