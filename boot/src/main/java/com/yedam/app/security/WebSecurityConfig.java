package com.yedam.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Bean 등록 방식 //로그인 성공 이후 처리
	@Bean
	AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomSuccessHandler();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(																			//ROLE_ 생략 가능 (DB에는 반드시 넣기)
				(requests) -> requests.antMatchers("/", "/home").permitAll()
				//.antMatchers("/emp/**").hasRole("ADMIN")
				.anyRequest().authenticated())
				.formLogin() //필터?
				.successHandler(authenticationSuccessHandler()) //로그인 성공 이후 처리
				.loginPage("/login")
				.permitAll()
				.and()
				.logout((logout) -> logout.permitAll());

		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("1111")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
}
