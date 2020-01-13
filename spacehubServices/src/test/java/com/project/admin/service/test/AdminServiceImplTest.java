/**
 * 
 */
package com.project.admin.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.admin.service.AdminService;
import com.project.product.entity.Product;

/**
 * @author gbemisola
 *
 */
@ContextConfiguration("classpath:/spacehub-service-servlet.xml")
@RunWith(SpringRunner.class)
public class AdminServiceImplTest {

	@Mock
	private AdminService adminService;
	
	@Before
	public void setUp() throws Exception {
		
		adminService = mock(AdminService.class);
		
	}

	@Test
	public void testAdminServiceNotNull() {
		assertNotNull(adminService);
	}
	
	@Test
	public void addNewProductTest() {
		
		Product theProduct = new Product("Accurate","Lovely setting",6000.50);
		
	 doNothing().when(adminService).saveProduct(isA(Product.class));
	 
	 adminService.saveProduct(theProduct);
	 verify(adminService,times(1));
	}

}
