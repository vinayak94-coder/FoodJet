
import { Injectable } from '@angular/core';
import { Router, Routes } from '@angular/router';




@Injectable({
  providedIn: 'root'
})

  
export class RouteserviceService {
  registeruser(data: any) {
    throw new Error('Method not implemented.');
  }

  constructor(private myroute:Router) { }

  homepage()
  {
    this.myroute.navigate(['home'])
  }
  loginpage()
  {
    this.myroute.navigate(['loginuser'])
  }
  dashboardpage()
  {
    this.myroute.navigate(['dashboard'])
  }
  registerpage()
  {
    this.myroute.navigate(['register'])
  }
  favouritepage()
  {
    this.myroute.navigate(['favourites'])
  }
  searchpage()
  {
    this.myroute.navigate(['search'])
  }
}
