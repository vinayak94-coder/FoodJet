import { Component, OnInit } from '@angular/core';
import { FoodieappService } from '../foodieapp.service';
import { RouteserviceService } from '../routeservice.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private foodservice: FoodieappService, private routeservice:RouteserviceService) { }

  ngOnInit(){

    
  }

}
