/**
 * 
 */
package com.project.security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lordsugar
 *
 */
@Controller
public class SecurityController {
	
	
//	@GetMapping("/admin")
//	public String showProducts() {
//		return "products-list";
//	}
	
	@GetMapping("/showLogin")
	public String showLogin() {
		
		return "login";
	}
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}

}
