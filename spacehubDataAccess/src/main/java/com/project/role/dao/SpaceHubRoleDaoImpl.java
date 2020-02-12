/**
 * 
 */
package com.project.role.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.role.entity.SpaceHubRole;

/**
 * @author lordsugar
 *
 */

@Repository
@Transactional
public class SpaceHubRoleDaoImpl implements SpaceHubRoleDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession() {
		
		
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public SpaceHubRole getRole(int id) {
		SpaceHubRole role = (SpaceHubRole) currentSession().load(SpaceHubRole.class, id);
		
		return role;
	}

	@Override
	public List<SpaceHubRole> getRoles() {
		
		Query<SpaceHubRole> theQuery = currentSession()
				.createQuery("from SpaceHubRole order by id", SpaceHubRole.class);
		
		List<SpaceHubRole> spaceHubRoles = theQuery.getResultList();
		
		
		return spaceHubRoles;
	}
	
//	public void s

}
