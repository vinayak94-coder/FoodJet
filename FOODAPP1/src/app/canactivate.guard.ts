import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from './authentication.service';
import { RouteserviceService } from './routeservice.service';

@Injectable({
  providedIn: 'root'
})
export class CanactivateGuard implements CanActivate {

  constructor(private userservice:AuthenticationService, private routobj:RouteserviceService)
  {
    
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      let mytoken=this.userservice.getMytoken();
      if(mytoken==null){
        this.routobj.loginpage();
        return false;
      } else {
        return true;
      }
    }
  }





