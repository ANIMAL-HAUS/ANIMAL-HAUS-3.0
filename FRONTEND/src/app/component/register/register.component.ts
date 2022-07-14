
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import {ServiceOffered, Users } from '../../models/Users';
import {UserRole } from '../../models/Users';

import { ServicesService } from 'src/app/service/services.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  firstName!: string;
  lastName!: string;
  userName!: string;
  password!:string;
  role!: UserRole;
  email!: string;
  address!: string;
  aboutMe!: string;
  service!: ServiceOffered;


  @Input()
  user!: Users;
  userRole!: UserRole;
  

  @Output()
  userAddedEvent = new EventEmitter();

  // message!: string;
  // password!: string;
  days = ['Weekdays', 'Weekends', 'Anyday']
  times = ['Morning', 'Afternoon', 'Night', 'Anytime']
  services = ['Walking', 'Grooming', 'Daycare']
  constructor(private ServicesService: ServicesService,
    private router: Router) { }

  ngOnInit(): void {
    
    this.user = new Users();
    console.log('user:', this.user);

    
    

    console.log('userRole:', UserRole);
  }

  addContractor() {
    this.ServicesService.addContractor(this.user).subscribe(
      (user) => {
        this.userAddedEvent.emit();
        this.router.navigate(['component', 'contractor-profile']);
      }
    );
    sessionStorage.setItem("aboutMe", this.user.aboutMe);
  }
 
}