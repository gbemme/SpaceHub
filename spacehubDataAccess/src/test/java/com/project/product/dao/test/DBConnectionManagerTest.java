/**
 * 
 */
package com.project.product.dao.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author gbemisola
 *
 */
@ContextConfiguration("classpath:/spacehub-dataaccess-context.xml")
@RunWith(SpringRunner.class)
public class DBConnectionManagerTest {
	
	
	
	@Autowired
	private ComboPooledDataSource dataSource;
	
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	
		@Test
		public void testDataConn() {
			assertNotNull(dataSource);
		}
	
}
