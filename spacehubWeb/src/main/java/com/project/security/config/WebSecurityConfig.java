/**
 * 
 */
package com.project.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author lordsugar
 *
 */

@Configuration
@ComponentScan(basePackages = {"com.project.security.config"})
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ComboPooledDataSource myDataSource;
	
	
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.jdbcAuthentication().dataSource(myDataSource)
		
				.passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select email, password, enabled "
					 + "from spacehubUser "
						+ "where email = ?")
				.authoritiesByUsernameQuery("select spacehubUser_email, role_name "
						+ "from spacehubRole "
						+ "where spacehubUser_email = ?");
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
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	

	
	
	
	
	

}
