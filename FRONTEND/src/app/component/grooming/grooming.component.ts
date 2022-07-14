import { Component, OnInit } from '@angular/core';
import { ServicesService } from 'src/app/service/services.service';
import { Router, ActivatedRoute } from '@angular/router';
import {  Users } from '../../models/Users';
import { Cart} from '../../models/Cart';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common'

@Component({
  selector: 'app-grooming',
  templateUrl: './grooming.component.html',
  styleUrls: ['./grooming.component.css']
})


export class GroomingComponent implements OnInit {
  users!: Array<Users>;
 // role!: Array<Role>;
  action!: string;
  cart!: Cart ;
 
  selectedUser!: Users;
  

  constructor(private ServicesService: ServicesService, 
    private router: Router,
    private activatedRoute: ActivatedRoute,
     private _http : HttpClient) { }

  ngOnInit(): void {
    //this.refreshData();
    this.cart = new Cart();
   this.ServicesService.getContractor()
   .subscribe(res=>{
     this.users = res;
   })
   console.log(this.users);
  } 
  
  bookNow(user: Users): void{
    this.cart.username = sessionStorage.getItem("username");
     this.cart.contractorFirstName = user.firstName;
     this.cart.contractorLastName = user.lastName;
     this.cart.service = user.service;
     this.cart.price = user.price;
     this.cart.id = 0;
    let response = this._http.post("http://localhost:5000/petgrooming/cartcontroller/insertproducttocart",
    this.cart).toPromise().then((data:any) =>{//console.log(data);
      //this.cart = data;
      alert("added to cart!");})
    }
    }
  

