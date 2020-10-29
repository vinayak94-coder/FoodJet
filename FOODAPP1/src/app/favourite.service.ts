import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restaurant } from './Restaurant';
import { AuthenticationService } from './authentication.service';


@Injectable({
  providedIn: 'root'
})
export class FavouriteService {

  constructor(private http : HttpClient, private authserv:AuthenticationService) { }

  addfavourite(fav:Restaurant):Observable<any>
  {
    let token=this.authserv.getMytoken();
    console.log(token);
    return this.http.post("http://localhost:8085/favourite/add",fav,
    {headers: new HttpHeaders().set('Authorization',`Bearer ${token}`)});

  }
  getAllFavouites(mail:any){
    let tok=this.authserv.getMytoken();
    return this.http.get("http://localhost:8085/favourite/email/"+mail,
    {
      headers: new HttpHeaders().set('Authorization',`Bearer ${tok}`)
    }
    );

  }

  deleteFavourite(id:any){
    let tok=this.authserv.getMytoken();
    return this.http.delete("http://localhost:8085/favourite/delete/"+id,
    {
      headers: new HttpHeaders().set('Authorization',`Bearer ${tok}`)
    }
    );
  }

  getMovieById(id){
    let tok=this.authserv.getMytoken();
    return this.http.get("http://localhost:8085/favourite/add"+id,
    {
      headers: new HttpHeaders().set('Authorization',`Bearer ${tok}`)
    }
    );
  }
     
}
