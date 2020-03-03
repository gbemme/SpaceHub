/**
 * 
 */
package com.project.user.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.user.entity.SpaceHubUser;

/**
 * @author lordsugar
 *
 */

@Repository
@Transactional
public class SpaceHubUserDaoImpl implements SpaceHubUserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession() {
		
		return sessionFactory.getCurrentSession();
	}

	@Override
	public SpaceHubUser getUser(String email) {		
		
		SpaceHubUser theEmail = currentSession().get(SpaceHubUser.class, email);
		
		
		return theEmail;
	}

	@Override
	public List<SpaceHubUser> getUsers() {
		
		Query<SpaceHubUser> theQuery = currentSession()
				.createQuery("from SpaceHubUser order by email", SpaceHubUser.class);
		
		List<SpaceHubUser> spaceHubUsers = theQuery.getResultList();
		
		
		return spaceHubUsers;
	}

	@Override
	public void saveSpaceHubUser(SpaceHubUser theSpacehubuser) {

		currentSession().saveOrUpdate(theSpacehubuser);
	}

}
