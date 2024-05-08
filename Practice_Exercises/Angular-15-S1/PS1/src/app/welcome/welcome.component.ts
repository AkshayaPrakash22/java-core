import { Component, OnInit } from '@angular/core';
import { Routes } from '@angular/router';
import { CustomerComponent } from '../customer/customer.component';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})

export class WelcomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
