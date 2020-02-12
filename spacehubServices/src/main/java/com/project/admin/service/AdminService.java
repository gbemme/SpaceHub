/**
 * 
 */
package com.project.admin.service;

import java.util.List;


import com.project.product.entity.Product;
import com.project.user.entity.SpaceHubUser;

/**
 * @author gbemisola
 *
 */
public interface AdminService {

	
	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);
	
//	public SpaceHubUser getUser(String theEmail);
//	
	public void saveSpaceHubUser(SpaceHubUser theUser);
}
