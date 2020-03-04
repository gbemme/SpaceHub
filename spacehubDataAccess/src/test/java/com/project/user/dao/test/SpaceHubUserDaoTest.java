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
import com.project.spacehub.dao.SpaceHubUserDao;
import com.project.spacehub.entity.SpaceHubRole;
import com.project.spacehub.entity.SpaceHubUser;

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
			
				
				SpaceHubUser theUser1 = new SpaceHubUser("ken@gmail.com", "kenneth", "ken", "obodo", "07034280038"); 
				
				SpaceHubRole employee = new SpaceHubRole("ROLE_USER");
				
				theUser1.addRole(employee);
				
				logger.info("Saving user to database");
				
				spaceHubUserDao.saveSpaceHubUser(theUser1);

				//spaceHubRoleDao.saveRole(employee);
											
				logger.info("Successfully saved user to database");
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.warn("user not saved");
		}
	}

}
