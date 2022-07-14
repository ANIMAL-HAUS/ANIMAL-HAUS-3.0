import { HttpClient } from "@angular/common/http";
import { Component,OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import { Cart } from "src/app/models/Cart";
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-checkout',
    templateUrl: './checkout.component.html',
    styleUrls: ['./checkout.component.css']
  })
export class CheckoutComponent implements OnInit{
   carts!: Array<Cart>;
    cart :Cart = {id :0,
        username: "none",
        contractorFirstName: "none",
        contractorLastName: "none",
        service: 0,
        price: 0,
       };
   
   constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
     private _http : HttpClient) { }
    ngOnInit(): void {
    this.cart.username= sessionStorage.getItem("username");
    let response = this._http.post("http://localhost:5000/petgrooming/authcontroller/login",
    this.cart).toPromise().then((data:any) =>{//console.log(data);
      this.carts = data;
      console.log(this.carts);
      
    })
        
      }
}