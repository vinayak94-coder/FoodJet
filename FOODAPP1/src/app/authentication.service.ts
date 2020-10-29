import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { RouteserviceService } from './routeservice.service';



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  

  constructor(private httpclient:HttpClient,private router:RouteserviceService) { 

  }

  
  private mail    = new BehaviorSubject<string>(localStorage.getItem('mail'));
  




  authenication(user)
  {
    return this.httpclient.post('http://localhost:8080/foodapp/login',user);
  }

 
  setMytoken(tok)
   {
     sessionStorage.setItem("mytoken",tok);
     localStorage.setItem
   }
   getMytoken() :any
   {
   return sessionStorage.getItem("mytoken");
   }

  
    
    
    get currentUserName() 
    {
        return this.mail.asObservable();
    }

 
   

   }


