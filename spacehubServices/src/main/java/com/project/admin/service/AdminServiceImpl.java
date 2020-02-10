/**
 * 
 */
package com.project.admin.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.project.product.dao.ProductDAO;
import com.project.product.entity.Product;
import com.project.role.dao.SpaceHubRoleDao;
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
	private SpaceHubUserDao spaceHubUserDao;
	
	@Autowired
	private SpaceHubRoleDao spaceHubRoleDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
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

	@Override
	public SpaceHubUser getUser(String theEmail) {

		return spaceHubUserDao.getUser(theEmail);
	}
	
	
	@Override
	@Transactional
	public void saveSpaceHubUser(SpaceHubUser user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		user.setRoles(new HashSet<>(spaceHubRoleDao.getRoles()));
		
		spaceHubUserDao.saveSpaceHubUser(user);
		
	}
	

}
