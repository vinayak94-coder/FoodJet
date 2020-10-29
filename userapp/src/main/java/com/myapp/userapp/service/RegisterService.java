package com.myapp.userapp.service;

import com.myapp.userapp.exception.UserAlreadyExistException;
import com.myapp.userapp.exception.UserNotFoundException;
import com.myapp.userapp.model.UserModel;

public interface RegisterService {
	
    
	UserModel signUpUser(UserModel User) throws UserAlreadyExistException;
	UserModel verifyUser(String username,String password) throws UserNotFoundException;
	String getusername(String id) throws Exception;

}
