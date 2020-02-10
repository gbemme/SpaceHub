/**
 * 
 */
package com.project.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * @author lordsugar
 *
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("Gbemi").password("12345678").roles("ADMIN"));
		
		auth.inMemoryAuthentication()
		    .withUser(users.username("Ken").password("12345678").roles("MANAGER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/**").permitAll()
		.and()
		.formLogin()
			.loginPage("/showLogin")
			.loginProcessingUrl("/authenticateTheUser")
			.defaultSuccessUrl("/")
			.permitAll()
			
		.and()
		.logout().permitAll();
	}
	
	


	
	
	
	
	

}
