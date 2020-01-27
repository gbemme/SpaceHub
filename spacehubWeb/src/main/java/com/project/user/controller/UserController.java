/**
 * 
 */
package com.project.user.controller;

import java.util.List;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.admin.service.AdminService;
import com.project.product.entity.Product;

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
	
	@GetMapping("/home")
	public String home(Model theModel) {
		List<Product> theProducts = adminService.getProducts();
		
		theModel.addAttribute("products", theProducts);
		
		return "home";
	}

}
