import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';
import { RouteserviceService } from '../routeservice.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  mail : FormControl;
  password: FormControl;
  loginform : FormGroup;
  mytoken : any;


  
  constructor(private routobj : RouteserviceService,private authobj:AuthenticationService) {
   

    this.loginform=new FormGroup(
      {
    mail :new FormControl('',Validators.minLength(3)),
    password:new FormControl('',Validators.minLength(3))
   });

  
  

  }
  

  register(e){

    

    this.routobj.registerpage()
    e.preventDefault();
      
  
  }
   
   login()
   {
     

  this.authobj.authenication(this.loginform.value).subscribe(
    (res)=> {    
           let tok=res["token"];
           console.log(res);
            this.authobj.setMytoken(tok);
            sessionStorage.setItem("name",res["username"]);

            sessionStorage.setItem("mail",this.loginform.controls['mail'].value);
          this.routobj.dashboardpage();
          },
    (err)=>
      { 
        Swal.fire('Not a registered user?Sign up Now.')
        console.log("inside failure");
        console.log(err); 
      }
  );

  

   }

  ngOnInit(): void {
  }
 
  
}


