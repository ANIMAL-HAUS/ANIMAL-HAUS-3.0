import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { Cart } from "src/app/models/Cart";

import { HttpClient } from "@angular/common/http";
import { ServicesService } from 'src/app/service/services.service';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-checkouts-components',
  templateUrl: './checkouts-components.component.html',
  styleUrls: ['./checkouts-components.component.css']
})
export class CheckoutsComponentsComponent implements OnInit {

  carts!: Array<Cart> | undefined;
  total :number = 0;
  cart!:Cart;
  id!: number;
 
 constructor(private ServicesService: ServicesService, 
  private router: Router,
  private activatedRoute: ActivatedRoute,
   private _http : HttpClient) { }
  ngOnInit(): void {
  this.cart = new Cart();
  this.cart.username= sessionStorage.getItem("username");
  console.log(this.cart);
  this.ServicesService.getCart(this.cart)
   .subscribe(res=>{
     this.carts = res;
     for (let i =0 ; i < this.carts.length; i++){
      this.total  += this.carts[i].price;
       } 
     console.log(this.carts);

   })
     
     
    }
    checkout(){

      this.ServicesService.removeitems(this.cart)
      .subscribe(res=>{
       location.reload();
      })
      //location.reload();
      this.router.navigate(['payment']);
    }


    remove(c: Cart){
      this.id = c.id;
      console.log(this.id);
      this.ServicesService.removeitem(this.id)
   .subscribe(res=>{
    location.reload();
   })
   location.reload();
    }

}
