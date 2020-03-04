/**
 * 
 */
package com.project.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@Column(name="id")
	private int id;
	
	
	@Column(name="email")
	private String email;
	

	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="company_name")
	private String companyName;
	
	@Transient
	private String passwordConfirm;
	
	@OneToMany(mappedBy="users", cascade= {CascadeType.DETACH, CascadeType.MERGE, 
										CascadeType.PERSIST, CascadeType.REFRESH})
	private List<SpaceHubRole> roles;
	
	
	public SpaceHubUser() { 
		
	}
	
	public SpaceHubUser(String email, String password, String firstName, String lastName,
			String phoneNumber) {
		super();
		
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	
	public List<SpaceHubRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SpaceHubRole> roles) {
		this.roles = roles;
	}
	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	
	public void addRole(SpaceHubRole tempRole) {
		
		if(roles == null) {
			roles = new ArrayList<>();
		}
		roles.add(tempRole);
		
		tempRole.setUsers(this);
	}

	
	

	
	
	
	

}
