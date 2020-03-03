/**
 * 
 */
package com.project.spacehub.dao;

import java.util.List;

import com.project.spacehub.entity.SpaceHubUser;

/**
 * @author lordsugar
 *
 */
public interface SpaceHubUserDao {
	
	public SpaceHubUser getUser(String theEmail);
	
	public List <SpaceHubUser> getUsers();
	
	public void saveSpaceHubUser(SpaceHubUser theSpacehubuser);


}
