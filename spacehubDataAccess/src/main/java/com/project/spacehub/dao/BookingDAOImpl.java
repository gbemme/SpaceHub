/**
 * 
 */
package com.project.spacehub.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.spacehub.entity.Booking;

/**
 * @author gbemisola
 *
 */
@Repository
public class BookingDAOImpl implements BookingDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public void bookProduct(Booking book) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		currentSession.save(book);
		
	}

	@Override
	@Transactional
	public Booking getBookingById(int bookingId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Booking theBooking = currentSession.get(Booking.class, bookingId);
		
		return theBooking;
	}

	@Override
	@Transactional
	public List<Booking> allbookings() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Booking> theQuery = currentSession
				.createQuery("from Booking order by bookingId", Booking.class);
	
		List <Booking> book = theQuery.getResultList();
		
		return book;
	}

}
