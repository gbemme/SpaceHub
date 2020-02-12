/**
 * 
 */
package com.project.role.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.user.entity.SpaceHubUser;

/**
 * @author lordsugar
 *
 */

@Entity
@Table(name="spacehubRole")
public class SpaceHubRole {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="spacehubRole_Id")
	private int roleId;
	
	@Column(name="spacehubRole_name")
	private String roleName;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="spacehubUser_email")
	private SpaceHubUser users;

	
	
	public SpaceHubRole(String roleName) {
		super();
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
		
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public SpaceHubUser getUsers() {
		return users;
	}

	public void setUsers(SpaceHubUser users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "SpaceHubRole [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + "]";
	}
	
	

}
