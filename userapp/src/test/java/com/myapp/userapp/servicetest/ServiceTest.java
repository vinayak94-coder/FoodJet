package com.myapp.userapp.servicetest;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myapp.userapp.exception.UserAlreadyExistException;
import com.myapp.userapp.model.UserModel;
import com.myapp.userapp.repository.RegisterRepository;
import com.myapp.userapp.service.RegisterServiceImplementation;

public class ServiceTest {
	
	@Mock
	RegisterRepository repo;
	
	UserModel user;
	
	@InjectMocks
	RegisterServiceImplementation registerService;
	
	
 
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        user = new UserModel();
   	    user.setName("rohith");
   	    user.setPassword("q1@w#ER4");
        user.setMail("rohith@123");
   	    user.setMobile("12334566");
   	    user.setLocation("kochi");
   	
      
}
    @Test
    @DisplayName("Testing create user Method in User service")
    public void createUserSuccess() throws UserAlreadyExistException{
   	 when(repo.save((UserModel) any())).thenReturn(user);
   	UserModel usersaved = registerService.signUpUser(user);
   	 assertEquals(user,usersaved);
   	
   }
    @Test
    public void createUserFailure() throws UserAlreadyExistException{
   	 when(repo.save((UserModel) any())).thenReturn(null);
   	UserModel usersaved = registerService.signUpUser(user);
   	 assertEquals(user,usersaved);
   	
   }
    


}
