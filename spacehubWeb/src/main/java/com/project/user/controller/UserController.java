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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.spacehub.service.AdminService;
import com.project.spacehub.service.UserService;
import com.project.spacehub.entity.Product;
import com.project.spacehub.entity.SpaceHubUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.spacehub.entity.Booking;

/**
 * @author gbemisola
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
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
	
	
	@CrossOrigin
	@PostMapping("/register") 
	public SpaceHubUser registerUser(@RequestBody SpaceHubUser user) {
				
		adminService.saveSpaceHubUser(user);

		return user;
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
	
	
	@CrossOrigin
	@PostMapping("/book")
	public Booking bookProduct(@RequestBody Booking book) {
		
		userService.bookProduct(book);
		
		
		return book;
	}
		
	
	
	
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";	
		
		
	}
	
	
}
