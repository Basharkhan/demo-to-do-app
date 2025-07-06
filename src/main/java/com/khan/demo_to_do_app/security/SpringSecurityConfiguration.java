package com.khan.demo_to_do_app.security;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	@Bean
	public InMemoryUserDetailsManager creaDetailsManager() {				
		UserDetails userDetails1 = createNewUser("khan", "khan");
		UserDetails userDetails2 = createNewUser("john", "john");
		
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}
	
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER", "ADMIN")
				.build();	
		
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests(auth -> auth.anyRequest().authenticated());
		httpSecurity.formLogin(withDefaults());
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();
		return httpSecurity.build();
	}
}
