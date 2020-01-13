/**
 * 
 */
package com.project.productimg.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.project.productimg.entity.ProductImage;

/**
 * @author gbemisola
 *
 */
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return ProductImage.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ProductImage file =(ProductImage) target;
		
		if(file.getFile()!=null) {
			if (file.getFile().getSize() == 0) {
				errors.rejectValue("file", "missing.file");
			}
		}
	}

}
