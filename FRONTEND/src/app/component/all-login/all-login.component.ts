import { Users } from 'src/app/models/Users';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { HttpHeaders } from '@angular/common/http';

import { Router } from '@angular/router';
import { NONE_TYPE } from '@angular/compiler';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type' : 'application/json',
    'Access-Control-Allow-Headers' : 'Content-type: application/json',
    'Access-Control-Allow-Methods' : 'POST',
    'Access-Control-Allow-Origin' : '*'
  })
};


@Component({
  selector: 'app-all-login',
  templateUrl: './all-login.component.html',
  styleUrls: ['./all-login.component.css']
})
export class AllLoginComponent implements OnInit {
  userName!:string;
  password!:string;
  result!:boolean;
 user!: Users;
  Credentials = {withCredentials:true};
  response:any;
  msgError!: any;
  
  
  constructor(private _http : HttpClient, private router : Router) { }

  ngOnInit(): void {

  }

  onSubmit() {
     this.user ={id:0,
                userName: this.userName,
                password: this.password,
                role: 0,
                firstName: "no user",
                lastName: "no user",
                email: "no user",
                address: "no address",
                aboutMe: "none",
                time: 0,
                day: 0,
               service: 0,
                price: 0,
                description: ""
              };
    let Credentials = {withCredentials:true};
    console.log(this.userName);
    console.log(this.password);
    console.log(this.user);
    console.log(Credentials);

    
    //   let response = this._http.post<any>("http://localhost:5000/petgrooming/authcontroller/login",
    // this.user, httpOptions).subscribe({
    //   next:(_v:1) => this.router.navigate(['component/contractor-profile']),
    //   error:(_e:0) => console.error(this.msgError="Invalid Credentials, Please Enter a Valid User Name and/or Password"),
    //   complete: () => window.localStorage.setItem("userName", this.userName)
    // });
    let response = this._http.post("http://localhost:5000/petgrooming/authcontroller/login",
    this.user).toPromise().then((data:any) =>{//console.log(data);
      this.user = data;
     // console.log(this.users.id);
      if (this.user.id ==0){
        document.getElementById("wrong").innerHTML = "wrong username or password";
      }
      else{
        this.router.navigate(['component/contractor-profile']);
        sessionStorage.setItem("aboutMe",this.user.aboutMe);
        sessionStorage.setItem("username", this.user.userName);
      }
    })
  }
}