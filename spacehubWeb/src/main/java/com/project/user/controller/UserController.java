/**
 * 
 */
package com.project.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gbemisola
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/home")
	public String home() {
		
		
		return "home";
	}

}
