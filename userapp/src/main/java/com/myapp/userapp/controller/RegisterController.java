package com.myapp.userapp.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.userapp.exception.UserAlreadyExistException;
import com.myapp.userapp.exception.UserNotFoundException;
import com.myapp.userapp.model.UserModel;
import com.myapp.userapp.service.RegisterService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@CrossOrigin
@RestController
@RequestMapping("/foodapp")
public class RegisterController {
	
	@Autowired
	RegisterService regservice;

	@PostMapping("/signup")
	  public ResponseEntity<?> adduser(@RequestBody UserModel user) throws UserAlreadyExistException
	  {
		try {
			
			regservice.signUpUser(user);
			return new ResponseEntity<String>("Signed up Successfully",HttpStatus.CREATED);
		}
		
		catch (UserAlreadyExistException e) {
			
			 return new ResponseEntity<String>("User Already Exist",HttpStatus.CONFLICT);
		}
			 	
	
	  }
	
	
	@PostMapping("/login")
	public ResponseEntity<?> validateUser(@RequestBody UserModel user) throws UserNotFoundException
	
	{
		UserModel user12=regservice.verifyUser(user.getMail(), user.getPassword());
		
		    if(user12!=null && user12.getMail()!="" && user12.getPassword()!="")
		     {
		    	String mytoken=generateToken(user12)	;
				 
				 HashMap<String,String> mymap=new HashMap();
				 mymap.put("token",mytoken);
				 mymap.put("username", user12.getName());
				 return new ResponseEntity<HashMap>(mymap,HttpStatus.ACCEPTED);
				 
		 
		     }
		
		    else
			       return new ResponseEntity<String>("Invalid User",HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/username/{id}")
	public ResponseEntity<?> getUserName(@PathVariable String id) throws Exception
	{
		String username=regservice.getusername(id);
		return new ResponseEntity<String>(username,HttpStatus.OK);
	}
		
	public String generateToken(UserModel obj)
	{
		long expiry=10_00_0000;
		  
		return  Jwts.builder().setSubject(obj.getName()).setIssuedAt(new Date(System.currentTimeMillis()))
		  .setExpiration(new Date(System.currentTimeMillis()+expiry)).signWith(SignatureAlgorithm.HS256, "jwtsecret").compact();
		
		
	}
	

}
