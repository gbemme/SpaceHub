/**
 * 
 */
package com.project.admin.service.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.spacehub.entity.Product;
import com.project.spacehub.entity.ProductStatus;
import com.project.spacehub.service.AdminService;

/**
 * @author gbemisola
 *
 */
@ContextConfiguration("classpath:/spacehub-service-context.xml")
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
		
		Product theProduct = new Product("Accurate","Lovely setting",6000.50,ProductStatus.BOOKED,"/home/gbemisola/files/IMG-20200121-WA0006.jpg");
		
	 doNothing().when(adminService).addProduct(isA(Product.class));
	 
	 adminService.addProduct(theProduct);
	 verify(adminService,times(1));
	}

}
