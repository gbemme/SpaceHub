/**
 * 
 */
package com.project.product.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.spacehub.entity.Product;
import com.project.spacehub.service.AdminService;
import com.project.spacehub.service.AdminServiceImpl;






/**
 * @author gbemisola
 *
 */



@CrossOrigin
@RestController
public class ProductController {

	
	//inject the product dao service
	@Autowired
	private AdminService adminService;
	
	
//	@GetMapping("/admin")  
//    public String privateHome() {  
//        return "privatePage";  
//    }  
	
	@CrossOrigin
	@GetMapping("/listProduct")
	public List <Product>  listProducts() {
		
		//get products from the service
		
		return adminService.getProducts();
	
	}
	

	@CrossOrigin
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product theProduct)
	{
	
		
		//save the product using the product service
		adminService.addProduct(theProduct);
		
		return theProduct;
	}
	
	
	
	@CrossOrigin
	@GetMapping("/getProduct/{productId}")
	public Product getProduct(@PathVariable int productId) {
		
		return adminService.getProduct(productId);
	}
	
	


	@CrossOrigin
	@PutMapping("/updateProduct/{productId}")
	public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product theProduct) {
		
		adminService.updateProductDetails(productId, theProduct);
	
		
		
		return theProduct;
	
	}
	
//	@CrossOrigin
//	@PutMapping("/changeProduct/{id}")
//	public Product changeProduct(@PathVariable int id, Product newProduct) {
//		adminService.updateProduct(newProduct);
//		
//		return newProduct;
//	}
	
	
	@CrossOrigin
	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		
		// delete the customer
		adminService.deleteProduct(productId);
		
		
	
	}
	
}

