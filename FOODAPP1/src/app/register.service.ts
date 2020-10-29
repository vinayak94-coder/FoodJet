import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './User';


@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http : HttpClient) { }

  registeruser(user:User):Observable<any>
  {
    return this.http.post("http://localhost:8080/foodapp/signup",user,{reportProgress:true,responseType:'text'});
  }

}
