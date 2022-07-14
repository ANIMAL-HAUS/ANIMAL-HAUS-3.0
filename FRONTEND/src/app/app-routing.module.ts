import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllLoginComponent } from './component/all-login/all-login.component';
import { ContractorProfileComponent } from './component/contractor-profile/contractor-profile.component';

import { DashboardComponent } from './component/dashboard/dashboard.component';
import { GroomingComponent } from './component/grooming/grooming.component';

import { RegisterComponent } from './component/register/register.component';
import {CheckoutComponent} from './component/checkout/checkout.component';
import {CheckoutsComponentsComponent} from './checkouts-components/checkouts-components.component';
import { PaymentComponent } from './payment/payment.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'component/dashboard', component: DashboardComponent },
  {path: 'component/register', component:RegisterComponent},
  {path: 'component/checkout', component:CheckoutComponent},
  {path: 'component/contractor-profile', component: ContractorProfileComponent},
   {path: 'component/grooming', component: GroomingComponent},
  {path: 'checkouts', component: CheckoutsComponentsComponent},
  {path: 'component/all-login', component: AllLoginComponent},
 {path: 'payment', component: PaymentComponent}

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
