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
  pageSize: number = 5; 
  currentPage: number = 0; 
  searchTerm: string = ''; 

  get paginatedCustomers(): any[] {
    return this.customers.slice(this.firstIndex, this.lastIndex + 1);
  }

  get totalPages(): number {
    return Math.ceil(this.customers.length / this.pageSize);
  }

  // Calculate the index of the first item on the current page
  get firstIndex(): number {
    return this.currentPage * this.pageSize;
  }

  // Calculate the index of the last item on the current page
  get lastIndex(): number {
    return Math.min((this.currentPage + 1) * this.pageSize - 1, this.customers.length - 1);
  }

  // Get the array of visible page numbers
  getVisiblePages(): number[] {
    const visiblePages: number[] = [];
    const startPage = Math.max(0, this.currentPage - 1);
    const endPage = Math.min(this.totalPages - 1, startPage + 2);
    for (let i = startPage; i <= endPage; i++) {
      visiblePages.push(i);
    }
    return visiblePages;
  }

  // Method to navigate to the first page
  goToFirstPage(): void {
    this.currentPage = 0;
  }

  // Method to navigate to the last page
  goToLastPage(): void {
    this.currentPage = this.totalPages - 1;
  }

  // Method to navigate to a specific page
  goToPage(page: number): void {
    this.currentPage = page;
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