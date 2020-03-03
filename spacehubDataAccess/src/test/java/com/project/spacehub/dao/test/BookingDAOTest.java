/**
 * 
 */
package com.project.spacehub.dao.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.spacehub.dao.BookingDAO;
import com.project.spacehub.dao.ProductDAO;
import com.project.spacehub.dao.SpaceHubUserDao;
import com.project.spacehub.entity.Booking;
import com.project.spacehub.entity.Product;
import com.project.spacehub.entity.ProductStatus;
import com.project.spacehub.entity.SpaceHubRole;
import com.project.spacehub.entity.SpaceHubUser;

/**
 * @author gbemisola
 *
 */
@Sql(scripts= {"classpath:spacehubDb.sql"})
@ContextConfiguration(locations= {"classpath:/spacehub-dataaccess-context.xml"})
@RunWith(SpringRunner.class)
public class BookingDAOTest {

	private Logger logger = Logger.getLogger(BookingDAO.class.getName());
	
	@Autowired
	private BookingDAO bookingDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SpaceHubUserDao spaceHubUserDAO;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMyObject() {
		assertNotNull(bookingDAO);
	}
	
	@Test
	public void addBookinDetailsToDatabaseTest() {
		
		try {
			logger.info("adding a new booking details");
				
				
				
				Product product = new Product("Galaxy","Meeting Room",8888.00,ProductStatus.VACANT,"/allpictures");
				productDAO.addProduct(product);
				
				SpaceHubUser theSpaceHubUser = new SpaceHubUser("ken@gmail.com", "kenneth", "ken", "obodo", "07034280038");
				spaceHubUserDAO.saveSpaceHubUser(theSpaceHubUser);
				
				Booking newBooking = new Booking("booking@gmail.com","Semicolon",2,product,theSpaceHubUser);
				logger.info("Saving booking details to database");
				
				bookingDAO.bookProduct(newBooking);
				
				logger.info("Successfully saving user to database");
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.warn("booking not saved");
		}
	}


}
