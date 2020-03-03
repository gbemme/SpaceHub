/**
 * 
 */
package com.project.spacehub.dao;

import java.util.List;

import com.project.spacehub.entity.Product;



/**
 * @author gbemisola
 *
 */
public interface ProductDAO {
	
	public List <Product> getProducts();

	public void addProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);
	
	//public void updateProduct(Product theProduct );
	
	public void updateProductDetails(int id, Product product);


}
