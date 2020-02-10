/**
 * 
 */
package com.project.user.entity;

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

import com.project.role.entity.SpaceHubRole;




/**
 * @author lordsugar
 *
 */

@Entity
@Table(name="spacehubUser")
public class SpaceHubUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	private String passwordConfirm;
	
	private Set<SpaceHubRole> roles;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name="user_role",
	joinColumns = {@JoinColumn(name="spacehubUser_email", referencedColumnName="email")},
	inverseJoinColumns = {@JoinColumn(name="spacehubUser_role", referencedColumnName="spacehubRole_id")})
	public Set<SpaceHubRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SpaceHubRole> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	

}
