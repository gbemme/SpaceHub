package com.project.spacehub.product.controller.test;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.admin.service.AdminService;

//@ContextConfiguration("classpath:/spacehub-web-servlet.xml")
//
//@RunWith(SpringRunner.class)
public class ProductControllerTest {

	@Autowired 
	private AdminService adminService;
	
	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testAdminServiceObject() {
//	assertNotNull(adminService);
//	}

}
