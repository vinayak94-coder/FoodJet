package com.myapp.favourite.controller;

import static org.mockito.ArgumentMatchers.any;
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
import com.myapp.favourite.exception.AlreadyExistException;
import com.myapp.favourite.model.Favourites;
import com.myapp.favourite.service.FavouriteService;

@SpringBootTest
@AutoConfigureMockMvc
public class FavouriteControllerTest {
	
	

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FavouriteService Service;
    private Favourites fav;
    
    @InjectMocks
    UserFavouritesController userController;
    
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        
        fav = new Favourites();
        fav.setMail("abc@123.com");
        fav.setId("q1w2e3");
        fav.setImage_url("image_url");
        fav.setTitle("title");
        fav.setUrl("url");
        fav.setDescription("description");
           
    }
    
    @AfterEach
    public void tearDown() {
    	fav =null;
    }
    
    
    
    private String asJsonString(Favourites user2) {
		 try {
	            return new ObjectMapper().writeValueAsString(user2);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }

	}
    
    @Test
    public void registerUserSuccess() throws Exception {

        when(Service.addFavourite(fav)).thenReturn(fav);
        mockMvc.perform(post("/favourite/add")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(fav)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }
    
    @Test
    public void registerUserFailure() throws Exception {

        when(Service.addFavourite(any())).thenThrow(AlreadyExistException.class);
        mockMvc.perform(post("/favourite/add")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(fav)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());

    }
    

}
