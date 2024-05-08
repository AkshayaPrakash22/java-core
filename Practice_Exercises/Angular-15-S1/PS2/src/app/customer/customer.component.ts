import { Component, OnInit } from '@angular/core';
import { customerOrdersData } from 'src/customerOrdersData';


@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
})
export class CustomerComponent {
  customers = customerOrdersData;
  selectedCustomer: any;
  isListViewActive: boolean = false;
  pageIndex = 0;
  pageSize = 5;

  getLastIndex(): number {
    const lastIndex = (this.pageIndex + 1) * this.pageSize;
    return lastIndex > this.customers.length ? this.customers.length : lastIndex;
  }
  goToPreviousPage() {
    this.pageIndex--;
  }
  
  goToNextPage() {
    this.pageIndex++;
  }
  getPageNumbers(): number[] {
    const totalPages = Math.ceil(this.customers.length / this.pageSize);
    return Array(totalPages).fill(0).map((x, i) => i);
  }
  goToPage(page: number) {
    this.pageIndex = page;
  }

  toggleListView(): void {
    this.isListViewActive = !this.isListViewActive;
  }

  showOrderDetails(customer: any) {
      this.selectedCustomer = customer;
  }

  getTotalOrderAmount(customer: any): string {
    let totalAmount = 0;
    for (const order of customer.orders) {
        totalAmount += parseFloat(order.Price.slice(1));
    }
    return '$' + totalAmount.toFixed(2);
}

}