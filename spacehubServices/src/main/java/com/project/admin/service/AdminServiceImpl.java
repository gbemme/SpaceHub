/**
 * 
 */
package com.project.admin.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.product.dao.ProductDAO;
import com.project.product.entity.Product;

/**
 * @author gbemisola
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	// inject product dao
	
	
	@Autowired
	private ProductDAO productDAO;
	

	@Transactional
	public List<Product> getProducts() {
		
		List <Product> theProduct = productDAO.getProducts();
		
		return theProduct;
	}


	@Transactional
	public void addProduct(Product theProduct) {
		
		productDAO.addProduct(theProduct);
	}

	
	@Transactional
	public Product getProduct(int theId) {
		
		
		return productDAO.getProduct(theId);
		 
	}


	@Transactional
	public void deleteProduct(int theId) {
		
		productDAO.deleteProduct(theId);
		
	}

//	@Transactional
//	public void updateProduct(Product theProduct) {
//		
//		
//		 productDAO.updateProduct(theProduct);
//	}
	
	@Transactional
	public void updateProductDetails(int id, Product product) {
		
		
		productDAO.updateProductDetails(id, product);
	}
}
