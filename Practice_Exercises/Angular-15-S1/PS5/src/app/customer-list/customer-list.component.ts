import { Component, OnInit } from '@angular/core';
import { Customer } from '../Customer.model';
import { customerOrdersData } from 'src/customerOrdersData';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  isListViewActive: boolean = true;
  customers: Customer[] = [];
  editedCustomer: Customer = {
    id: 0,
    First_Name: '',
    Last_Name: '',
    Address: '',
    City: '',
    State: ''
  };

  constructor() { }

  ngOnInit(): void {
    this.loadCustomers();
  }

  loadCustomers(): void {
    // Load data from localStorage
    const localStorageCustomers = JSON.parse(localStorage.getItem('customers') || '[]');
    this.customers = localStorageCustomers;
  }

  toggleListView(): void {
    this.isListViewActive = true;
  }

  toggleEditForm(): void {
    this.isListViewActive = false;
  }

  submitEditForm(): void {
    const index = this.customers.findIndex(customer =>
      customer.First_Name === this.editedCustomer.First_Name &&
      customer.Last_Name === this.editedCustomer.Last_Name
    );
    if (index !== -1) {
      // Update customer details
      this.customers[index] = { ...this.editedCustomer };
      // Update LocalStorage
      localStorage.setItem('customers', JSON.stringify(this.customers));
      // Reset the form
      this.editedCustomer = {
        id: 0,
        First_Name: '',
        Last_Name: '',
        Address: '',
        City: '',
        State: ''
      };
      // Navigate back to customer list view
      this.isListViewActive = true;
    } else {
      console.error('Customer not found.');
    }
  }

  cancelEdit(): void {
    this.editedCustomer = {
      id: 0,
      First_Name: '',
      Last_Name: '',
      Address: '',
      City: '',
      State: ''
    };
    this.isListViewActive = true;
  }

  deleteCustomer(index: number): void {
    if (confirm('Are you sure you want to delete this customer?')) {
      this.customers.splice(index, 1);
      localStorage.setItem('customers', JSON.stringify(this.customers));
    }
  }
}