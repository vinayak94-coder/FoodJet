import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { RouteserviceService } from './routeservice.service';





@Injectable({
  providedIn: 'root'
})




export class FoodieappService {

  public baseUrl = "https://developers.zomato.com/api/v2.1/";
 
  
  constructor(private httpService: HttpClient,private router:RouteserviceService) { 
   

   
}
  
    
  

getcollections()
{
  const headers = new HttpHeaders({
    'Content-Type': 'application/json',
    'user-key': `97a3e3c5ac1e5ac6dea6569ea4443b4a`
  })
  return this.httpService.get(this.baseUrl+"collections?city_id="+"3",{headers:headers});
}


}
  
