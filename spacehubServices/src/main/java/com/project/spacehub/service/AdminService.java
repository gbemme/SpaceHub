/**
 * 
 */
package com.project.spacehub.service;

import java.util.List;

import com.project.spacehub.entity.Booking;
import com.project.spacehub.entity.Product;
import com.project.spacehub.entity.SpaceHubUser;

/**
 * @author gbemisola
 *
 */
public interface AdminService {

	
	public List<Product> getProducts();

	public void addProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);

//	public SpaceHubUser getUser(String theEmail);
//	
	public void saveSpaceHubUser(SpaceHubUser theUser);
	
	public void updateProductDetails(int id, Product product);
	
	// admin can view all the booking made by customers
	public List<Booking> allBookings();
	
	// admin can view booking by booking id
	
	public Booking getBookingById(int bookingId);
}
