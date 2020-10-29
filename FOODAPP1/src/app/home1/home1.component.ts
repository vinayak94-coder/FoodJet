import { Component, OnInit } from '@angular/core';
import { FoodieappService } from '../foodieapp.service';
import { Restaurant } from '../Restaurant';
import { RouteserviceService } from '../routeservice.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-home1',
  templateUrl: './home1.component.html',
  styleUrls: ['./home1.component.css']
})
export class Home1Component implements OnInit {

  form : FormGroup;
  newrestaurant: Restaurant[];
  q:any;
  keyword:FormControl;
 
  

  constructor(
    private foodservice: FoodieappService, private routeservice:RouteserviceService
  ) { }

  ngOnInit() {

    this.form=new FormGroup(
      {
        keyword: new FormControl("")
      });

    let restaurantsAPI= 'https://developers.zomato.com/api/v2.1/';
    let restaurantId=28;
    let cityid=3;

    
    //  this.foodservice.getData( restaurantsAPI + "restaurant?res_id=" + restaurantId).subscribe((response: any) => {
      //  setTimeout(() => {
       //  this.newrestaurant = response['cuisines'];
//console.log(response['cuisines']);
      //  });
     // },
//(error) => {
        //  console.log(error);
         // this.toastr.error(error.error.message);
        //});

        this.foodservice.getcollections().subscribe((res)=>{

          setTimeout(()=>{
            this.newrestaurant=res['collections'];
            console.log(res['collections']);

        });
      },
      (error)=>{
        console.log(error);

      });
    }

    routeto()
    {
      this.routeservice.loginpage();

    }
  
  
  }