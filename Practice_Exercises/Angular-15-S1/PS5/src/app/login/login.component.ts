import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm = new FormGroup({
    email: new FormControl(),
    password: new FormControl(),
});


constructor(
  private formBuilder: FormBuilder,
  private authService: AuthService,
  private router: Router
) {}


  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required,Validators.maxLength(10), Validators.minLength(6),this.passwordValidator]]
    });
  }
  
  get formControls() {
    return this.loginForm.controls;
  }

  login() {

    if (this.loginForm.invalid) {
      return;
    }
    console.log('Email:', this.loginForm.value.email);
    console.log('Password:', this.loginForm.value.password);
    
    const username = this.loginForm.value.email;
    const password = this.loginForm.value.password;

    if (this.authService.login(username, password)) {
      console.log('Login Successful');
      this.router.navigateByUrl('/add-customer');

    } else {
      console.log('Invalid credentials');
    }
  }

  passwordValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const password = control.value;
    const hasLetter = /[a-zA-Z]/.test(password);
    const hasNumber = /\d/.test(password);
    const hasSpecialCharacter = /[!@#$%^&*(),.?":{}|<>]/.test(password);

    if (!hasLetter || !hasNumber || !hasSpecialCharacter) {
      return { 'passwordRequirements': true };
    }

    return null;
  }

  

  
}
