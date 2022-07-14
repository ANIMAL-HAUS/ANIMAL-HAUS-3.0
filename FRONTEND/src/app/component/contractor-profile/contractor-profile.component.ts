import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserRole, Users } from '../../models/Users';
import { ServicesService } from 'src/app/service/services.service';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type' : 'application/json',
    'Access-Control-Allow-Headers' : 'Content-type: application/json',
    'Access-Control-Allow-Methods' : 'POST',
    'Access-Control-Allow-Origin' : '*'
  })
};
@Component({
  selector: 'app-contractor-profile',
  templateUrl: './contractor-profile.component.html',
  styleUrls: ['./contractor-profile.component.css']
})
export class ContractorProfileComponent implements OnInit {
  
  users!: Users;
  role!: Array<UserRole>;
  action!: string;
  aboutMe!: any;
  selectedUser!: Users;
  num: any;
  Num!: number;

    
  constructor(private ServicesService: ServicesService ,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private _http : HttpClient,) { }

  ngOnInit() {
    this.refreshData();
    this.aboutMe = sessionStorage.getItem("aboutMe");
    document.getElementById("h6").innerHTML = this.aboutMe;
    
  }
  refreshData() {
    this.ServicesService.getContractors().subscribe(
      response => this.handleSuccessfulResponse(response),
    );

    this.activatedRoute.queryParams.subscribe(
      (params) => {
        this.action = params['action'];
        const selectedUserId = params['id'];
        if (selectedUserId) {
        }
      }
    );
  }
  
  viewContractor(id: number) {
    this.router.navigate(['component', 'contractor-profile'], {queryParams : {id, action: 'view'}});
   
  }
  randomContractor(){
  alert(sessionStorage.getItem("aboutMe"));
  }
  handleSuccessfulResponse(response: Users[]) {
   // this.users = response;
    console.log(this.users);
  }

  addContractor() {
    this.selectedUser = new Users();
    this.router.navigate(['component', 'contractor-profile'], { queryParams: { action: 'add' } });
  }

}