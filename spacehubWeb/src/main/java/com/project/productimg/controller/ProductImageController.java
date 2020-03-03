/**
 * 
 */
package com.project.productimg.controller;

import java.io.File;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.project.spacehub.entity.Product;
import com.project.spacehub.service.AdminService;

/**
 * @author gbemisola
 *
 */
@SuppressWarnings("unused")
@RestController
public class ProductImageController {
	
	//private static String UPLOAD_LOCATION="/home/gbemisola/SpaceHub/ProjectSpaceHub/spacehub/spacehubWeb/src/main/webapp/resources/image/";
	
	@Autowired
	private AdminService adminServiceImpl;
	
//	@Autowired
//	FileValidator fileValidator;
	
	
	
//	@Autowired
//	@Qualifier("cloud_name")
//	String myCloudName;
//     
//	@Autowired
//	@Qualifier("api_key")
//	String myCloudKey;
//	
//	
//	@Autowired
//	@Qualifier("api_secret")
//	String myCloudSecret;
	
//	@GetMapping(value="/image")
//    public ResponseEntity< List<String> > get(
//        @RequestParam(value="name", required=false) String aName)
//    {
//        Cloudinary c=new Cloudinary("cloudinary://"+"648151448984285"+":"+"Qq9fMik6OZEwxntXfr8LjJGvuyA"+"@"+"spacehubpictures");
//        List<String> retval=new ArrayList<String>();
//        try
//        {
//            Map response=c.api().resource("", ObjectUtils.asMap("type", "upload"));
//            JSONObject json=new JSONObject(response);
//            JSONArray ja=json.getJSONArray("resources");
//            for(int i=0; i<ja.length(); i++)
//            {
//                JSONObject j=ja.getJSONObject(i);
//                retval.add(j.getString("url"));
//            }
//
//            return new ResponseEntity< List<String> >(retval, HttpStatus.OK);
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity< List<String> >(HttpStatus.BAD_REQUEST);
//        }
//    }
	  Cloudinary c=new Cloudinary("cloudinary://"+"648151448984285"+":"+"Qq9fMik6OZEwxntXfr8LjJGvuyA"+"@"+"spacehubpictures");

    @PostMapping(value="/image")
    public ResponseEntity< String > post(
        @RequestParam(value="upload", required=true) MultipartFile aFile,  int id)
    {
      
        try
        {
        	
            File f = Files.createTempFile("temp", aFile.getOriginalFilename()).toFile();
            
            //convert multipart file type to file because cloudinary does not support multipart file;
            aFile.transferTo(f);
            
         // uplaoad image to cloudinary using the image name as public id
            Map response=c.uploader().upload(f, ObjectUtils.asMap( "public_id", aFile.getOriginalFilename()));
            
            JSONObject json=new JSONObject(response);
            String url=json.getString("url"); 
            
            System.out.println("the picture is :" + f);
            System.out.println("the url is :" + url);
            
            
            Product theProduct= adminServiceImpl.getProduct(id);
            
            theProduct.setProductImg(url);
            
            adminServiceImpl.updateProductDetails(id, theProduct);
            
            return new ResponseEntity<String>("{\"status\":\"OK\", \"url\":\""+response+"\"}", HttpStatus.OK);
           
            
            
        }
        catch(Exception e)
        {
            return new ResponseEntity< String >("", HttpStatus.BAD_REQUEST);
        }
    }
    

}