/**
 * 
 */
package com.project.role.dao;

import java.util.List;

import com.project.role.entity.SpaceHubRole;

/**
 * @author lordsugar
 *
 */
public interface SpaceHubRoleDao {
	
	public SpaceHubRole getRole(int theId);
	
	public List <SpaceHubRole> getRoles();
	
	public void saveRole(SpaceHubRole theRole);

}
