/**
 * 
 */
package com.project.spacehub.service;

import java.util.Arrays;

import java.util.HashSet;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.spacehub.dao.SpaceHubRoleDao;
import com.project.spacehub.dao.SpaceHubUserDao;
import com.project.spacehub.dao.BookingDAO;
import com.project.spacehub.dao.ProductDAO;
import com.project.spacehub.entity.Booking;
import com.project.spacehub.entity.Product;
import com.project.spacehub.entity.SpaceHubRole;
import com.project.spacehub.entity.SpaceHubUser;


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
	private BookingDAO bookingDAO;
	

	@Autowired
	private SpaceHubUserDao spaceHubUserDao;
	
	@Autowired
	private SpaceHubRoleDao spaceHubRoleDao;
	
	
	
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



	@Override
	@Transactional
	public void saveSpaceHubUser(SpaceHubUser user) {
		
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		user.setRoles(Arrays.asList(new SpaceHubRole("EMPLOYEE")));
		
		spaceHubUserDao.saveSpaceHubUser(user);
		
	}
	



	@Transactional
	public void updateProductDetails(int id, Product product) {
		
		
		productDAO.updateProductDetails(id, product);
	}


	@Override
	@Transactional
	public List<Booking> allBookings() {
		
		List <Booking> bookings = bookingDAO.allbookings();
		
		return bookings;
	}


	@Override
	@Transactional
	public Booking getBookingById(int bookingId) {
	
		return bookingDAO.getBookingById(bookingId);
	}

}
