package com.myapp.userapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.userapp.exception.UserAlreadyExistException;
import com.myapp.userapp.exception.UserNotFoundException;
import com.myapp.userapp.model.UserModel;
import com.myapp.userapp.repository.RegisterRepository;








@Service
public class RegisterServiceImplementation implements RegisterService{
	
	@Autowired
	RegisterRepository regrepo;

	@Override
	public UserModel signUpUser(UserModel user) throws UserAlreadyExistException 
	{
		 Optional<UserModel> user1=regrepo.findById(user.getMail());
		 if(user1.isPresent())
		   {
			   throw new UserAlreadyExistException("User Already Exist");
		   }
		 else
			 regrepo.save(user);
		 return user;
		
		
	}
	

	@Override
	public UserModel verifyUser(String username, String password) throws UserNotFoundException {
		UserModel userverify =regrepo.findByMailAndPassword(username, password);
		return userverify;
	}


	@Override
	public String getusername(String id) throws Exception {
		
		try {
		Optional<UserModel>user=regrepo.findById(id);
	
			 String username=user.get().getName();
			 return username;
		
		}catch(Exception e) {
			throw new Exception("User Not Found");
		}
		
		
	}



}
