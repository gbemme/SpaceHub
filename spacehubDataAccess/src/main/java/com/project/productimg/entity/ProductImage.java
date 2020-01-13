/**
 * 
 */
package com.project.productimg.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author gbemisola
 *
 */
public class ProductImage {
	
	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	

}
