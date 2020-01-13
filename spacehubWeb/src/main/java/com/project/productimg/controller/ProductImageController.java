/**
 * 
 */
package com.project.productimg.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.project.productimg.entity.ProductImage;

/**
 * @author gbemisola
 *
 */
@Controller
public class ProductImageController {
	
	private static String UPLOAD_LOCATION="/home/gbemisola/files/";
	
	@Autowired
	FileValidator fileValidator;
	
	
	@InitBinder("productImage")
	 protected void initBinderFileBucket(WebDataBinder binder) {
	  binder.setValidator(fileValidator);
	 }

	
	
	@GetMapping("/singleUpload")
	 public String getSingleUploadPage(ModelMap model) {
	 ProductImage productImg = new ProductImage();
	  model.addAttribute("productImage", productImg);
	  return "singleFileUploader";
	 }
	
	
	@PostMapping("/singleUpload")
	 public String singleFileUpload(@Valid ProductImage productImage,
	   BindingResult result, ModelMap model) throws IOException {

	  if (result.hasErrors()) {
	   System.out.println("validation errors");
	   return "singleFileUploader";
	  } else {
	   System.out.println("Fetching file");
	   MultipartFile multipartFile = productImage.getFile();

	   // Now do something with file...
	   FileCopyUtils.copy(productImage.getFile().getBytes(), new File( UPLOAD_LOCATION + productImage.getFile().getOriginalFilename()));
	   String fileName = multipartFile.getOriginalFilename();
	   model.addAttribute("fileName", fileName);
	   return "success";
	  }
	 }
	
}
