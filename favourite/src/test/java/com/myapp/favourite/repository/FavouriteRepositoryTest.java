package com.myapp.favourite.repository;









import java.util.List;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.myapp.favourite.model.Favourites;





@RunWith(SpringRunner.class)
@DataMongoTest
public class FavouriteRepositoryTest {
	
	@Autowired 
	FavouriteRepository Repo;
	
    private Favourites fav;
   
    
    @Before
    public void setUp() throws Exception {
    	
    	 fav = new Favourites();
         fav.setMail("abc@123.com");
         fav.setId("q1w2e3");
         fav.setImage_url("image_url");
         fav.setTitle("title");
         fav.setUrl("url");
         fav.setDescription("description");
    }
    
    @After
    public void tearDown() throws Exception {

    	Repo.deleteAll();

    }
    
    @Test
    public void createFavouriteTest() {
    	Repo.save(fav);
    	Favourites fetcheduser = Repo.findByMailAndTitle("abc@123.com", "title");
        Assert.assertEquals(fav.getTitle(), fetcheduser.getTitle());

    	
    }
    @Test(expected = NoSuchElementException.class)
    public void deleteFavTest() {
    	Repo.save(fav);
    	Favourites fetcheduser = Repo.findById("q1w2e3").get();
        Repo.delete(fetcheduser);
        fetcheduser = Repo.findById("q1w2e3").get();

    }
    
    @Test
    public void getFavByUserTest() {
    	Repo.save(fav);
  	  List<Favourites> favouritelist = Repo.findByMail("abc@123.com");
  	  Assert.assertEquals(1,favouritelist.size());
    }

}
