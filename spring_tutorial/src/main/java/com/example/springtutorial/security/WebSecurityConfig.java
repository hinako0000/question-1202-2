package com.example.springtutorial.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	
	//セキュリティ設定
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		
		//アクセス許可に関する設定
		.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/login","/resources/**").permitAll() //全ユーザーにアクセスを許可するURL
				.anyRequest().authenticated() //上記以外のURLはログインが必要
				)
		
		//ログインに関する設定
		.formLogin((form) -> form
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/adminuser?loggedIn")
				.failureUrl("/login?error")
				.permitAll()
				)
		
		.logout((logout) -> logout
                .logoutSuccessUrl("/?loggedOut")  // ログアウト時のリダイレクト先URL
                .permitAll());
		
		return http.build();
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
