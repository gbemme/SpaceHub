package com.project.product.dao.test;

import static org.junit.Assert.*;



import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
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
import com.project.product.dao.ProductDAO;
import com.project.product.entity.Product;

@Sql(scripts= {"classpath:spacehubDb.sql"})
@ContextConfiguration(locations= {"classpath:/spacehub-dataaccess-context.xml"})
@RunWith(SpringRunner.class)
public class ProductDAOTest {
	
private Logger logger = Logger.getLogger(ProductDAO.class.getName());
	
	@Autowired
	private ProductDAO productDAO;
	

	@Autowired
	private ComboPooledDataSource dataSource;
	
	@Autowired
	private SessionFactory sessionFactory;

//	@Before
//	public void setUp() throws Exception{
//		String username = "gbemiSpace";
//		String password = "@GoogleGbemi94";
//		String jdbcDriver = "com.mysql.jdbc.Driver" ;
//		String DBUrl = "jdbc:mysql://localhost:3306/spacehub?serverTimezone=UTC";
//		Connection conn = null;
//		QueryRunner queryRunner = new QueryRunner(dataSource);
//		DbUtils.loadDriver(jdbcDriver);
//		conn = DriverManager.getConnection(DBUrl,username,password);
//		queryRunner.update("drop database spacehub");
//		
//		queryRunner.update("create database spacehub");
//		
//		queryRunner.update("use spacehub");
//		
//		queryRunner.update("CREATE TABLE `product` (\n" + 
//				"  `id` int(11) NOT NULL AUTO_INCREMENT,\n" + 
//				"  `product_name` varchar(100) DEFAULT NULL,\n" + 
//				"  `product_plan` varchar(100) DEFAULT NULL,\n" + 
//				"  `product_price` double DEFAULT NULL,\n" + 
//				"  `product_img` varchar(100) DEFAULT NULL,\n" + 
//				
//				"  PRIMARY KEY (`id`)\n" + 
//				") ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;");
//		DbUtils.close(conn);
//		
//	}
//	
	
	@Test
	public void testDataSource() {
		assertNotNull(dataSource);
		assertNotNull(sessionFactory);
		assertNotNull(productDAO);
		
	}

	
	@Test
	public void addProductToDatabaseTest() {
		try {
			logger.info("creating new product");
			
				Product theProduct = new Product("Accurate","Lovely setting",6000.50,"/home/gbemisola/files/IMG-20200121-WA0006.jpg");
				
						logger.info("Storing product to the database");
						
				productDAO.saveProduct(theProduct);
				
				logger.info("Successfully saving product to the database");
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.warn("data not stored in database");
	
		}
	}
}
