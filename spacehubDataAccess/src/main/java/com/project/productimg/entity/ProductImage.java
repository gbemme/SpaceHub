/**
 * 
 */
package com.project.productimg.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author gbemisola
 *
 */
@Component
public class ProductImage {
	
	MultipartFile file;
	
	
	
	String filePath;
	
	
	
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	

}
