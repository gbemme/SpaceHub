/**
 * 
 */
package com.project.user.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.admin.service.AdminService;
import com.project.product.entity.Product;
import com.project.user.entity.SpaceHubUser;

/**
 * @author gbemisola
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/home")
	public String home(Model theModel) {
		List<Product> theProducts = adminService.getProducts();
		
		theModel.addAttribute("products", theProducts);
		
		return "home";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("spacehubuser") SpaceHubUser user) {
		
		System.out.println("user: " +user.getFirstName() + " " + user.getLastName());
		return "confirmation";
	}
	
	@RequestMapping("/register")
	public String showRegistration(Model theModel) {
		
		SpaceHubUser user = new SpaceHubUser();
		
		theModel.addAttribute("spacehubuser",user);
		
		return "register";
	}
	
	
	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("spacehubuser") SpaceHubUser user,
			BindingResult result, Model model) {
		
		if (result.hasErrors()) {
            return "register";
        }
		
		System.out.println("user: " +user.toString());

	
		adminService.saveSpaceHubUser(user);
		
		System.out.println("user: " +user.getFirstName() + " " + user.getLastName());

		
		return "confirmation";
	}
	

	@GetMapping("/showLogin")
	public String showLogin() {
		
		return "login";
	}
	
	
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}

}
