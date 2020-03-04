/**
 * 
 */
package com.project.product.dao;

import java.util.List;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.product.entity.Product;

																																	
/**
 * @author gbemisola
 *
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Product> getProducts() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		// create a query
		Query<Product> theQuery = currentSession
				.createQuery("from Product order by productName", Product.class);
		
		
		//execute query and get result list
		List<Product> products = theQuery.getResultList();
		
		// return the results
		return products;
	}


	
	@Transactional
	public void addProduct(Product theProduct) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the product
		currentSession.save(theProduct);
				
	}



	@Transactional
	public Product getProduct(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using the primary key
		
		Product theproduct = currentSession.get(Product.class, theId);
		
		
		return theproduct;
	}


	
	@Transactional
	public void deleteProduct(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		

		Product product = currentSession.byId(Product.class).load(theId);

		currentSession.delete(product);
		
		
		
		
	}


//	@Transactional
//	public void updateProduct(Product theProduct) {
//		
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		currentSession.update(theProduct);
//		
//	}



	@Transactional

	public void updateProductDetails(int id, Product product) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Product newproduct = session.byId(Product.class).load(id);
		
		newproduct.setProductImg(product.getProductImg());
		
		newproduct.setProductName(product.getProductName());
		
		newproduct.setProductPlan(product.getProductPlan());
		
		newproduct.setProductPrice(product.getProductPrice());
		
		session.flush();
		
	}



	

}
