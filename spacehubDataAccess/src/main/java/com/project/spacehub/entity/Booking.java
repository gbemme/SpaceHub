/**
 * 
 */
package com.project.spacehub.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author gbemisola
 *
 */
@Entity
@Table(name="spacehubBooking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private int bookingId;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name="duration")
	private int duration;
	
	@OneToOne
	@JoinColumn(name="product_product_id")
	private Product productId;
	
	
	@ManyToOne( cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="spacehubUser_id")
	private SpaceHubUser userId;

	

	public Booking(String email, String name, int duration, Product productId, SpaceHubUser userId) {
		super();
		this.email = email;
		this.name = name;
		this.duration = duration;
		this.productId = productId;
		this.userId = userId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", email=" + email + ", name=" + name + ", duration=" + duration
				+ "]";
	}

	
	
	
	
}
