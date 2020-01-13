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


	@Override
	public void saveProduct(Product theProduct) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the product
		currentSession.saveOrUpdate(theProduct);
				
	}


	@Override
	public Product getProduct(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve/read from database using the primary key
		
		Product theproduct = currentSession.get(Product.class, theId);
		
		
		return theproduct;
	}


	@Override
	public void deleteProduct(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete the product with primary key
		Query theQuery = currentSession.createQuery("delete from Product where id=:productId");
		
			theQuery.setParameter("productId", theId);
		
		
		theQuery.executeUpdate();
		
	}

}
