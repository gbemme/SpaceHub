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
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		
		productDAO.saveProduct(theProduct);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		
		
		return productDAO.getProduct(theId);
		 
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		
		productDAO.deleteProduct(theId);
		
	}

}
