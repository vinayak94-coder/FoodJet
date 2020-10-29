import { Component, OnInit } from "@angular/core";
import { FoodieappService } from '../foodieapp.service';
import { Restaurant } from '../Restaurant';
import { AuthenticationService } from '../authentication.service';
import { FavouriteService } from '../favourite.service';
import Swal from 'sweetalert2';
import { Observable } from 'rxjs';
import { RouteserviceService } from '../routeservice.service';


@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.css"]
})
export class DashboardComponent implements OnInit {
  
  
  newrestaurant: Restaurant[];
  restaurant:Restaurant = new Restaurant();
  name:string;
  q:any;
  constructor(
    private foodservice: FoodieappService,
    private authservice: AuthenticationService,
    private favservice:FavouriteService,
    private router:RouteserviceService
  ) {
    
    this.name= sessionStorage.getItem("name");
   
  }
   
  

  

  ngOnInit() {

   

    this.foodservice.getcollections().subscribe((res)=>{

          
            this.newrestaurant=res['collections'];
            console.log(res['collections']);

       
      },
      (error)=>{
        Swal.fire('Error in Fetching Data :(')
        console.log(error);

      });

      
    }

   

    addFavourites(Data)
    { 
      this.restaurant.mail=sessionStorage.getItem("name");
      this.restaurant.description=Data.description;
      this.restaurant.image_url=Data.image_url;
      this.restaurant.title=Data.title;
      this.favservice.addfavourite(this.restaurant).subscribe((fav)=>{
        Swal.fire('Added to Favourites')
        console.log(this.restaurant);

      },
      (error)=>{
        Swal.fire('Already added to Favourites')
        console.log(error);

      });
      
    }

    gotofavourite()
    {
      this.router.favouritepage();
  
    }
    logout() {
      sessionStorage.clear();
      this.router.homepage();
    }
    openlink(Data){
      window.open(Data.url)
    }


 
}

