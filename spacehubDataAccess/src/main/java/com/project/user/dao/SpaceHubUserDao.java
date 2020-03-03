/**
 * 
 */
package com.project.user.dao;

import java.util.List;

import com.project.user.entity.SpaceHubUser;

/**
 * @author lordsugar
 *
 */
public interface SpaceHubUserDao {
	
	public SpaceHubUser getUser(String theEmail);
	
	public List <SpaceHubUser> getUsers();
	
	public void saveSpaceHubUser(SpaceHubUser theSpacehubuser);


}
