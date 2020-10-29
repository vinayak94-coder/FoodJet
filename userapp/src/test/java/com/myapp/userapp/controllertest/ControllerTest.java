package com.myapp.userapp.controllertest;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.userapp.controller.RegisterController;
import com.myapp.userapp.exception.UserAlreadyExistException;

import com.myapp.userapp.model.UserModel;
import com.myapp.userapp.service.RegisterService;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	
	
	    @Autowired
        private MockMvc mockMvc;
	
	    @MockBean
	    private RegisterService userService;
	    private UserModel user;
	    
	    @InjectMocks
	    RegisterController userController;
	    
	    
	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	        
	        user = new UserModel();
	        user.setMail("abc@123.com");
	        user.setName("vinayak");
	        user.setMobile("9876543210");
	        user.setLocation("trivandrum");
	        user.setPassword("q@W#E$R%");
	           
	    }
	    
	    @AfterEach
	    public void tearDown() {
	    	user =null;
	    }
	    
	    
	    
	    private String asJsonString(UserModel user2) {
			 try {
		            return new ObjectMapper().writeValueAsString(user2);
		        } catch (Exception e) {
		            throw new RuntimeException(e);
		        }

		}
	    
	    @Test
	    public void registerUserSuccess() throws Exception {

	        when(userService.signUpUser(user)).thenReturn(user);
	        mockMvc.perform(post("/foodapp/signup")
	                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
	                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
	    }
	    
	    @Test
	    public void registerUserFailure() throws Exception {

	        when(userService.signUpUser(any())).thenThrow(UserAlreadyExistException.class);
	        mockMvc.perform(post("/foodapp/signup")
	                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
	                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());

	    }
	    
	   


	   


}
