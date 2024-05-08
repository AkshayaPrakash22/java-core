import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { customerOrdersData } from 'src/customerOrdersData';
import { Customer } from '../Customer.model';


@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  customerForm !: FormGroup;
  customers: Customer[] = customerOrdersData; 
  constructor(private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.customerForm = this.formBuilder.group({
      First_Name: ['', Validators.required],
      Last_Name: ['', Validators.required],
      Address: ['', Validators.required],
      City: ['', Validators.required],
      State: ['', Validators.required]
    });
  }

  onSubmit(): void {
      if (this.customerForm.valid) {
        const newCustomer: Customer = {
          id: this.customers.length + 1,
          ...this.customerForm.value
        };
    
        // Save to LocalStorage
        const storedCustomers = JSON.parse(localStorage.getItem('customers') || '[]');
        storedCustomers.push(newCustomer);
        localStorage.setItem('customers', JSON.stringify(storedCustomers));
    
        // Reset form
        this.customerForm.reset();
    
        // Navigate to customer list
        this.router.navigate(['/customer-list']);
      }
    }
      
}

