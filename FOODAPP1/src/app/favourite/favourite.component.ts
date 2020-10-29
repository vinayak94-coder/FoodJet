import { Component, OnInit } from '@angular/core';
import { FavouriteService } from '../favourite.service';
import { RouteserviceService } from '../routeservice.service';
import { FoodieappService } from '../foodieapp.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {

  newfavourites:any;
  q:any;
  name:String;
  message:any;
  username:String;
  constructor(private favservice: FavouriteService, private router:RouteserviceService, private foodservice:FoodieappService) 
  {
    this.name=sessionStorage.getItem("mail");
    this.username=sessionStorage.getItem("name")
   }

  ngOnInit()  {
  
    this.getFavourites();
    

    

   
}

deleteFavourites(id:any)
{
  console.log(id);
  this.favservice.deleteFavourite(id).subscribe(()=>{
   
    Swal.fire('Deleted Successfully'); 

  });
  window.location.reload();
}

getFavourites()
{
 
  this.favservice.getAllFavouites(this.username).subscribe((res)=>{
  
    this.newfavourites=res;
    if (this.newfavourites==null)
    {
      return this.message="Nothing to show here :("
    }
    console.log(this.newfavourites);
  },
  err=>{
    Swal.fire('Sorry! Unable to load your Favourites')
    console.log("not able to view favourites",err); 

});

}

logout() {
  sessionStorage.clear();
  this.router.loginpage();
}
routetodash(){
  this.router.dashboardpage();
}
  }
 
 
