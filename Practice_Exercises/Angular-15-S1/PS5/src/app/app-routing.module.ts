import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { CustomerComponent } from './customer/customer.component';
import { LoginComponent } from './login/login.component';
import { OrdersComponent } from './orders/orders.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AuthGuard } from './auth.guard';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { CustomerListComponent } from './customer-list/customer-list.component';

const routes: Routes = [
  { path: '', component: WelcomeComponent, children: [
    { path: 'customer', component: CustomerComponent },
{ path: 'orders', component: OrdersComponent },
{ path: 'about', component: AboutComponent },
{ path: 'login', component: LoginComponent },
{path: 'add-customer', component: AddCustomerComponent, canActivate: [AuthGuard]},
{ path: 'customer-list', component: CustomerListComponent },
]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
