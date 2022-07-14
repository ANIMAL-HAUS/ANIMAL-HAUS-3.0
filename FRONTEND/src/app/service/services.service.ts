import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import{Users} from '../models/Users';
import{Cart} from '../models/Cart';
@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  deleteUser: any;
  
  constructor(private httpClient:HttpClient) { }
  getContractors()
  {
    return this.httpClient.get<Users[]>('http://localhost:5000/petgrooming/usercontroller/getallcontractors');
  }

  addContractor(newUser: Users) {
    return this.httpClient.post<Users>('http://localhost:5000/petgrooming/authcontroller/contractoranytimeweekends', newUser);   
  }

  getCustomers()
  {
    return this.httpClient.get<Users[]>('http://localhost:5000/petgrooming/usercontroller/getallcustomers');
  }

  addCustomer(newUser: Users) {
    return this.httpClient.post<Users>('http://localhost:5000/petgrooming/authcontroller', newUser);   
  }

  getCart(cart: Cart){
    return this.httpClient.post<any>('http://localhost:5000/petgrooming/cartcontroller/getCartbyUsername',cart)
    .pipe(map((res:any)=>{
      return res;
    }))

  }

  getContractor(){
    return this.httpClient.get<any>('http://localhost:5000/petgrooming/usercontroller/getallcontractors')
    .pipe(map((res:any)=>{
      return res;
    }))
  }

  
    removeitem(id: number){
      return this.httpClient.post<any>('http://localhost:5000/petgrooming/cartcontroller/removeitem',id)
      .pipe(map((res:any)=>{
        return res;
      }))
  
    }
    removeitems(username: Cart){
      return this.httpClient.post<any>('http://localhost:5000/petgrooming/cartcontroller/clearitems',username)
      .pipe(map((res:any)=>{
        return res;
      }))
  }

}
