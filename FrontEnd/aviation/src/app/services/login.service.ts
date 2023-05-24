import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserLogin } from '../class/userlogin';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

const TOKEN = 'I_token';
const user = 'I_user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl = "http://localhost:8080/user/login"
  invalidLogin = false

  constructor(private httpclient: HttpClient, private router: Router) { }

  login(authenticationRequest: any): Observable<any> {
    return this.httpclient.post(this.baseUrl, authenticationRequest)
  }


  //Aici se face apelarea catre backend si se seteaza in momentul in care un user este logat in SessionStorage,
  //emailul cu care s-a autentificat userul.
  // loginUser(user: UserLogin): Observable<Object> {
  //   console.log(user);
  //   sessionStorage.setItem('authenticaterUser', user.email);
  //   return this.httpclient.post(`${this.baseUrl}`, user);
  // }
  //Se verifica daca userul este logat.
  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticaterUser');
    return !(user === null);
  }
  //Are loc logout-ul utilizatorului prin inlaturarea token-ului de autentificare de la logare.
  logout() {
    sessionStorage.removeItem('authenticaterUser');
  }
}
