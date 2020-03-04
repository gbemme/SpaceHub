/**
 * 
 */
package com.project.spacehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.spacehub.dao.BookingDAO;
import com.project.spacehub.entity.Booking;

/**
 * @author gbemisola
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private BookingDAO bookingDAO;
	
	
	@Override
	@Transactional
	public void bookProduct(Booking book) {
	
		bookingDAO.bookProduct(book);

	}

}
