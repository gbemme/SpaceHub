/**
 * 
 */
package com.project.product.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.admin.service.AdminService;
import com.project.product.entity.Product;






/**
 * @author gbemisola
 *
 */
@Controller
@RequestMapping("/")
public class ProductController {

	
	//inject the product dao service
	@Autowired
	private AdminService adminService;
	
	
	@GetMapping("/admin")  
    public String privateHome() {  
        return "privatePage";  
    }  
	
	
	@GetMapping("/product-list")
	public String listProducts(Model theModel) {
		//get products from the service
		
		List<Product> theProducts = adminService.getProducts();
		
		
		// add the product to the model
		theModel.addAttribute("products", theProducts);
		
		return "products-list";
	}
	
	@GetMapping("/addProductForm")
	public String addProduct(Model theModel) {
		
		// model attribute to bind form data
		
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		
		return "product-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct( @ModelAttribute("product") Product theProduct)
	{
		
		
		//save the product using the product service
		adminService.saveProduct(theProduct);
		
		return "redirect:/product-list";
	}
	
	


	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpadte(@RequestParam("productId") int theId, Model theModel) {
		
	//get product from the service
		
		Product theProduct = adminService.getProduct(theId);
		
		// set product as a model attribute to pre-populate the form
		
		theModel.addAttribute("product", theProduct);
		
		
		//send over to our form
		
		
		return "product-form";
	
	}
	
	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		// delete the customer
		adminService.deleteProduct(theId);
		
		
		return "redirect:/product-list";
	}
	
}

