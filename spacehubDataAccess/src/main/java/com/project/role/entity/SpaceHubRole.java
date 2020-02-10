/**
 * 
 */
package com.project.role.entity;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

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
	
	private Set<SpaceHubUser> users;

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

	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="user_role",
	joinColumns = {@JoinColumn(name="spacehubUser_role", referencedColumnName="spacehubRole_id")},
	inverseJoinColumns = {@JoinColumn(name="spacehubUser_email", referencedColumnName="email")})
	public Set<SpaceHubUser> getUsers() {
		return users;
	}

	public void setUsers(Set<SpaceHubUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "SpaceHubRole [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + "]";
	}
	
	

}
