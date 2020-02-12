/**
 * 
 */
package com.project.user.dao.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.project.role.entity.SpaceHubRole;
import com.project.user.dao.SpaceHubUserDao;
import com.project.user.entity.SpaceHubUser;

/**
 * @author lordsugar
 *
 */
@Sql(scripts= {"classpath:spacehubDb.sql"})
@ContextConfiguration(locations= {"classpath:/spacehub-dataaccess-context.xml"})
@RunWith(SpringRunner.class)
public class SpaceHubUserDaoTest {
	

	private Logger logger = Logger.getLogger(SpaceHubUserDao.class.getName());
	
	@Autowired
	private SpaceHubUserDao spaceHubUserDao;
	
	@Autowired
	private ComboPooledDataSource dataSource;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testDataSource() {
		
		assertNotNull(dataSource);
		assertNotNull(sessionFactory);
		assertNotNull(spaceHubUserDao);
	}
	
	
	@Test
	public void addUserToDatabaseTest() {
		
		try {
			logger.info("adding a new user");
				
				SpaceHubRole employee = new SpaceHubRole("EMPLOYEE");
				
				SpaceHubUser theSpaceHubUser = new SpaceHubUser("ken@gmail.com", "kenneth", "ken", "obodo", "07034280038");
				
				theSpaceHubUser.addRole(employee);
				
				logger.info("Saving user to database");
				
				spaceHubUserDao.saveSpaceHubUser(theSpaceHubUser);
				
				logger.info("Successfully saving user to database");
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.warn("user not saved");
		}
	}

}
