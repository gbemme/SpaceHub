/**
 * 
 */
package com.project.admin.service;

import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.product.dao.ProductDAO;
import com.project.product.entity.Product;
import com.project.role.entity.SpaceHubRole;
import com.project.user.dao.SpaceHubUserDao;
import com.project.user.entity.SpaceHubUser;

/**
 * @author gbemisola
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	// inject product dao
	
	
	@Autowired
	private ProductDAO productDAO;
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SpaceHubUserDao spaceHubUserDao;
	
	
	
	
	
	@Override
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


//	@Override
//	public SpaceHubUser getUser(String theEmail) {
//
//		return spaceHubUserDao.getUser(theEmail);
//	}
//	
//	
	@Override
	@Transactional
	public void saveSpaceHubUser(SpaceHubUser account){
		
		 SpaceHubUser  user = new SpaceHubUser();
		 
		 user.setEmail(account.getEmail());
		 
		 user.setPassword(passwordEncoder.encode(account.getPassword()));
		 
		 user.setRoles(Arrays.asList(new SpaceHubRole("ROLE_USER")));
		 
		 user.setFirstName(account.getFirstName());
		 
		 user.setLastName(account.getLastName());
		 
		 user.setCompanyName(account.getCompanyName());
		 
		
		spaceHubUserDao.saveSpaceHubUser(user);
		
	}
	

	
	@Transactional
	public void updateProductDetails(int id, Product product) {
		
		
		productDAO.updateProductDetails(id, product);
	}

}
