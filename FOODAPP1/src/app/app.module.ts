import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';


import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { NgSelectModule } from '@ng-select/ng-select';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {FoodieappService} from './foodieapp.service';
import { RouterModule, Routes } from '@angular/router';
import {MatInputModule} from '@angular/material/input';
import {MatToolbarModule} from '@angular/material/toolbar';
import { CanactivateGuard } from './canactivate.guard';
import { Home1Component } from './home1/home1.component';
import {MatCardModule} from '@angular/material/card';
import { NgxPaginationModule } from 'ngx-pagination';
import { FavouriteComponent } from './favourite/favourite.component';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { SearchComponent } from './search/search.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { FlexLayoutModule } from '@angular/flex-layout';




const rout : Routes =[

  {
    path:'',
    redirectTo:'home',
    pathMatch:'full'
  },
 
  {
    path:'dashboard',
    component:DashboardComponent,
    canActivate:[CanactivateGuard],
    children:[]
    
  },
  {
    path:'register',
    component:RegisterComponent
  },
 
  {
    path:'home',
    component:Home1Component,
    children:[
      {
        path:'search',
        component:SearchComponent,

      }
    ]
    
    
  },
  {
    path: 'loginuser', 
    component: LoginComponent 
  },
  {
    path: 'favourites', 
    component: FavouriteComponent,
    canActivate:[CanactivateGuard]
  }
  
 
]

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent,
    RegisterComponent,
    Home1Component,
    FavouriteComponent,
    SearchComponent
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgSelectModule,
    RouterModule.forRoot(rout),
    MatInputModule,
    MatToolbarModule,
    MatCardModule,
    NgxPaginationModule,
    MatButtonModule,
    MatIconModule,
    MatExpansionModule,
    FlexLayoutModule
    
    
     
  ],
  providers: [FoodieappService],
  bootstrap: [AppComponent]
  

})
export class AppModule { }
