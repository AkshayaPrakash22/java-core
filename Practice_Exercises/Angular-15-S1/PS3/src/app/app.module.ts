import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { CustomerComponent } from './customer/customer.component';
import { OrdersComponent } from './orders/orders.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { PaginationDirective } from './pagination.directive';
import { CardSearchPipe } from 'src/card-search.pipe';



@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    CustomerComponent,
    OrdersComponent,
    AboutComponent,
    LoginComponent,
    PaginationDirective,
    CardSearchPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
