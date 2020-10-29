package com.myapp.favourite.controller;



import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.favourite.exception.AlreadyExistException;
import com.myapp.favourite.exception.IdNotFoundException;
import com.myapp.favourite.model.Favourites;
import com.myapp.favourite.service.FavouriteService;


@RestController
@CrossOrigin
@RequestMapping("/favourite")
public class UserFavouritesController {
	
	
	@Autowired
	FavouriteService favservice;
	
	@PostMapping("/add")
	public  ResponseEntity<?> addFavourite(@RequestBody Favourites fav){
		System.out.print(fav);
		
		try {
			Favourites favadd=favservice.addFavourite(fav)	;
		return new ResponseEntity<Favourites>(favadd,HttpStatus.OK);
	  }
		catch(AlreadyExistException e) {
			return new ResponseEntity<String>("Favourite Already exist",HttpStatus.CONFLICT);
		}
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String favid) {
		try {
			favservice.deleteFavouritebyId(favid);
			return new ResponseEntity<String>("Successfully Deleted Favourite with id: " + favid, HttpStatus.OK);
		} catch (IdNotFoundException exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	

	
	@GetMapping("/email/{mail}")
	public ResponseEntity<?> favouritesByMail(@PathVariable("mail") String mail) {
		List<Favourites> favsbymail=favservice.getFavByMail(mail);
			return new ResponseEntity<List>(favsbymail,HttpStatus.OK);

	}


}
