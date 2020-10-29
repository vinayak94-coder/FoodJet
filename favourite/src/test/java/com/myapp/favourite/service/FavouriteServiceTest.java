package com.myapp.favourite.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.myapp.favourite.exception.AlreadyExistException;
import com.myapp.favourite.exception.IdNotFoundException;
import com.myapp.favourite.model.Favourites;
import com.myapp.favourite.repository.FavouriteRepository;

public class FavouriteServiceTest {
	
	 @Mock
	    FavouriteRepository favRepo;


	    Favourites fav;

	    @InjectMocks
	    FavouriteServiceImpl favService;

	    List<Favourites> allfav = null;
	    Optional<Favourites> options;

	    
	    @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);

	        fav = new Favourites();
	         fav.setMail("abc@123.com");
	         fav.setId("q1w2e3");
	         fav.setImage_url("image_url");
	         fav.setTitle("title");
	         fav.setUrl("url");
	         fav.setDescription("description");
	        allfav = new ArrayList<>();
	        allfav.add(fav);

	        options = Optional.of(fav);
	        
	       
	    }
	    
	    @Test
	    public void createFavouriteSuccess() throws AlreadyExistException {
	        when(favRepo.save((Favourites) any())).thenReturn(fav);
	        Favourites movieadded = favService.addFavourite(fav);
	        assertEquals(fav, movieadded);
	  	
	    }
	    
	    @Test
	    public void createFavouriteFailure() throws AlreadyExistException {
	        when(favRepo.save((Favourites) any())).thenReturn(null);
	        Favourites movieadded = favService.addFavourite(fav);
	        assertEquals(fav, movieadded);

	    }
	    
	    @Test
	    public void deleteFavSuccess() throws IdNotFoundException {
	    	when(favRepo.findById(fav.getId())).thenReturn(options);
	    	boolean flag=favService.deleteFavouritebyId(fav.getId());
	    	assertEquals(true, flag);
	    }

	    
	 
	    	
	    }
	    
	    


