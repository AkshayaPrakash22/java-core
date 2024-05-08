import { Component, OnInit } from '@angular/core';
import { customerOrdersData } from 'src/customerOrdersData';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent {
  customers = customerOrdersData;

  getTotalOrderAmount(customer: any): string {
    let totalAmount = 0;
    for (const order of customer.orders) {
      totalAmount += parseFloat(order.Price.slice(1));
    }
    return '$' + totalAmount.toFixed(2);
  }
}