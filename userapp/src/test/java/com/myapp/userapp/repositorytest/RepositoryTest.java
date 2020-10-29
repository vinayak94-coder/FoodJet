package com.myapp.userapp.repositorytest;




import org.junit.Assert;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.myapp.userapp.model.UserModel;
import com.myapp.userapp.repository.RegisterRepository;

@DataJpaTest
@AutoConfigureTestDatabase 
public class RepositoryTest {

	@Autowired
	private RegisterRepository registerRepo;
    private UserModel user;
   
    
    @BeforeEach
    public void setUp() throws Exception {
    	
    	 user = new UserModel();
    	 user.setName("rohith");
    	 user.setPassword("q1@w#ER4");
    	 user.setMail("rohith@123");
    	 user.setMobile("12334566");
    	 user.setLocation("kochi");
    }
    
    @AfterEach
    public void tearDown() throws Exception {

    	registerRepo.deleteAll();

    }
    
    @Test
    public void createUserTest() {
    	registerRepo.save(user);
        UserModel fetcheduser = registerRepo.findById("rohith@123").get();
        Assert.assertEquals(user.getMail(), fetcheduser.getMail());

    	
    }
}
