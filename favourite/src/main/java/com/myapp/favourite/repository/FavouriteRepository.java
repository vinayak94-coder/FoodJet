package com.myapp.favourite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.myapp.favourite.model.Favourites;


@Repository
public interface FavouriteRepository extends MongoRepository<Favourites,String>{

	List<Favourites> findByMail(String mail);
	Favourites findByMailAndTitle(String mail,String title);
	Optional<Favourites> findById(String id);


	
	
	
	

}
