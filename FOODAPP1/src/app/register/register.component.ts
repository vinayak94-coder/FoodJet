import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';

import { RegisterService } from '../register.service';
import { RouteserviceService } from '../routeservice.service';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form : FormGroup;
  username : FormControl;
  password: FormControl;
  mailid:FormControl;
  mobilenumber:FormControl;
  address:FormControl;
 

  constructor(private registerserve : RegisterService,
              private rout:RouteserviceService,
              private formbuilder:FormBuilder) {}

    



  ngOnInit(){

    this.form=new FormGroup(
      {
        name: new FormControl("",[Validators.required,Validators.minLength(3)]),
        password: new FormControl("",Validators.required),
        mail: new FormControl("",Validators.required),
        location: new FormControl("",Validators.required),
        mobile: new FormControl("",Validators.required),
    
      } 
    );



    


   }

   onregister() {
    console.log(this.form.value)
    this.registerserve.registeruser(this.form.value)

        .subscribe(
            data => {
                
                this.rout.loginpage();
            },
            (err)=>
            { 
              Swal.fire('Registration Failed!')

          
                
            });
}
login(e)
{
  this.rout.loginpage();
  e.preventDefault();
}
    }

   

    
  
  

  

