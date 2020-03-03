/**
 * 
 */
package com.project.spacehub.dao;

import java.util.List;

import com.project.spacehub.entity.Booking;

/**
 * @author gbemisola
 *
 */
public interface BookingDAO {
	
	public void bookProduct(Booking book);
	
	public Booking getBookingById (int bookingId);
	
	public List <Booking> allbookings();
	

}
