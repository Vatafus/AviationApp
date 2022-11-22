import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogin } from '../class/userlogin';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl = "http://localhost:8080/user/login"
  invalidLogin = false
  constructor(private httpclient: HttpClient, private router: Router) { }

  loginUser(user: UserLogin): Observable<Object> {
    console.log(user);
    sessionStorage.setItem('authenticaterUser', user.email);
    return this.httpclient.post(`${this.baseUrl}`, user);
  }
}
