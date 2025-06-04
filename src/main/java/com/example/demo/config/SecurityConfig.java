package com.example.demo.config;

import java.net.ResponseCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.detail.UserDetailsImpl;
import com.example.demo.model.dto.UserCert;
import com.example.demo.service.impl.UserDetailsServiceImpl;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@Configuration  //springboot啟動前會先配置這個功能
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/login", "/logout", "check-login").permitAll()
				.requestMatchers(HttpMethod.GET, "/test/**").permitAll()
				.requestMatchers("/test/home/**").hasAnyRole("USER","1")
				.anyRequest().authenticated()
			)
			.formLogin(form ->form
				.loginProcessingUrl("/login")
				.usernameParameter("userAccount")
				.passwordParameter("password")
				.successHandler((request, response, auth) ->{
					//登入成功時，把資料存到session
					UserDetailsServiceImpl userDetailsServiceImpl = (UserDetailsImpl) auth.getPrincipal();
					HttpSession session = request.getSession();
					session.setAttribute("userCert", 
						new UserCert(userDetailsImpl.getUserID(), userDetailsImpl.getPassword(), userDetailsImpl.getUserRole())
					);
					response.setStatus(HttpServletResponse.SC_OK);
					response.setContentType("application/json");
					response.getWriter().write("{\"code\":200,\"message\":\"登入成功\"}");					
				})
				.failureHandler((request, response, ex) -> {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					response.setContentType("application/json");
					response.getWriter().write("{\"code\":401,\"message\":\"登入失敗\"}");					
				})
			)
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessHandler((request, response, auth) ->{
					response.setStatus(HttpServletResponse.SC_OK);
					response.setContentType("application/json");
					response.getWriter().write("{\"code\":200,\"message\":\"登出成功\"}");					
				})
			)
			.sessionManagement(session -> session
				.maximumSessions(1)
				.maxSessionsPreventsLogin(false)
			);
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
	}
}
