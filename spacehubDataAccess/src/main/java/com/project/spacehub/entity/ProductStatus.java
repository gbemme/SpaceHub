/**
 * 
 */
package com.project.spacehub.entity;

/**
 * @author gbemisola
 *
 */
public enum ProductStatus {
	
	BOOKED("The space has been book"),
	
	VACANT("Booking Successful");
	
	
	private String description;
	
	ProductStatus(String description){
		
		this.description = description;
	}
	

	public String getDescription() {
		
		return description;
	}
}
