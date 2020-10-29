package com.myapp.favourite.service;




import java.util.List;


import com.myapp.favourite.exception.AlreadyExistException;
import com.myapp.favourite.exception.IdNotFoundException;
import com.myapp.favourite.model.Favourites;


public interface FavouriteService {
	
	
	
	
	

	Favourites addFavourite(Favourites fav) throws AlreadyExistException;

	boolean deleteFavouritebyId(String favid) throws IdNotFoundException;


	List<Favourites> getFavByMail(String mail);
	
	


}
 