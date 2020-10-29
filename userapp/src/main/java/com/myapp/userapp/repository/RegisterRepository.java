package com.myapp.userapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.userapp.model.UserModel;








@Repository
public interface RegisterRepository extends JpaRepository<UserModel,String>{
	
	UserModel findByMailAndPassword(String uname,String password);	

}
