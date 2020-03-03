/**
 * 
 */
package com.project.user.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.spacehub.entity.Booking;
import com.project.spacehub.entity.SpaceHubUser;
import com.project.spacehub.service.AdminService;
import com.project.spacehub.service.UserService;

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
	
//	@GetMapping("/home")
//	public String home(Model theModel) {
//		List<Product> theProducts = adminService.getProducts();
//		
//		theModel.addAttribute("products", theProducts);
//		
//		return "home";
//	}
	
//	@RequestMapping("/registration")
//	public String showRegistration(Model theModel) {
//		
//		SpaceHubUser user = new SpaceHubUser();
//		
//		theModel.addAttribute("spacehubuser",user);
//		
//		return "registration";
//	}
	@CrossOrigin
	@PostMapping("/register") 
	public SpaceHubUser registerUser(@RequestBody SpaceHubUser user) {
		
		adminService.saveSpaceHubUser(user);
		
		System.out.println("user: " +user.getFirstName() + " " + user.getLastName());

		
		return user;
	}
	
	@CrossOrigin
	@PostMapping("/book")
	public Booking bookProduct(@RequestBody Booking book) {
		
		userService.bookProduct(book);
		
		
		return book;
		
		
	}
	
	
//	@RequestMapping("/processForm")
//	public String processForm(@ModelAttribute("spacehubuser") SpaceHubUser user) {
//		
//		System.out.println("user: " +user.getFirstName() + " " + user.getLastName());
//		return "confirmation";
//	}

}
