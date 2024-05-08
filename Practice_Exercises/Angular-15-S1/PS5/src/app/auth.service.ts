import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
    private isAuthenticated: boolean = false;

  constructor() { }

  login(username: string, password: string): boolean {
    // Simulate authentication logic, replace with actual authentication logic
    if (username === 'admin@gmail.com' && password === 'admin123*') {
      this.isAuthenticated = true;
      return true;
    }
    return false;
  }

  logout() {
    this.isAuthenticated = false;
  }

  isAuthenticatedUser(): boolean {
    return this.isAuthenticated;
  }
}