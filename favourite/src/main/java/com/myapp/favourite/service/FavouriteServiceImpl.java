package com.myapp.favourite.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myapp.favourite.exception.AlreadyExistException;
import com.myapp.favourite.exception.IdNotFoundException;
import com.myapp.favourite.model.Favourites;
import com.myapp.favourite.repository.FavouriteRepository;






@Service
public class FavouriteServiceImpl implements FavouriteService{
	
	@Autowired
	private FavouriteRepository favrepo;
	

	
	
	
	@Override
	public Favourites addFavourite(Favourites fav) throws AlreadyExistException {
		System.out.print("Favourite passed ="+fav);
		Favourites fav1=favrepo.findByMailAndTitle(fav.getMail(),fav.getTitle());
		System.out.println("Favourite finded =" +fav1);
	    if(fav1!=null)
	    {
	    	throw new AlreadyExistException("Favourita Already Exist");
	    }
	    else {
			 favrepo.save(fav);
			 return fav;
	    }
			 
		
			
	}


	@Override
	public boolean deleteFavouritebyId(String favid) throws IdNotFoundException {
		boolean status = false;
		try {
			Favourites fecthedFav = favrepo.findById(favid).get();
			if (fecthedFav != null) {
				favrepo.delete(fecthedFav);
				status = true;
			}
		} catch (NoSuchElementException exception) {
			throw new IdNotFoundException();
		}
		return status;

	}
	
	

	
	@Override
	public List<Favourites> getFavByMail(String mail) {
		return favrepo.findByMail(mail);
	}
	

}
