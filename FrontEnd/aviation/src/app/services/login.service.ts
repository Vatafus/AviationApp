import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { UserLogin } from '../class/userlogin';
import { Router } from '@angular/router';
import { Observable, map, tap } from 'rxjs';
import { StorageServiceService } from './storage-service.service';

export const AUTH_HEADER = "authorization";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl = "http://localhost:8080/user/login"
  invalidLogin = false

  constructor(private httpclient: HttpClient, private router: Router, private storageService: StorageServiceService) { }

  login(username: string, password: string): any {
    console.log(username, password)
    return this.httpclient.post<[]>(this.baseUrl,
      { username, password },
      { observe: 'response' })
      .pipe(
        tap(_ => this.log("User Authentication")),
        map((res: HttpResponse<any>) => {
          this.storageService.saveUserId(res.body.userId);
          this.storageService.saveUserRole(res.body.role);
          const tokenLength = res.headers.get(AUTH_HEADER).length;
          const bearerToken = res.headers.get(AUTH_HEADER).substring(7, tokenLength);
          this.storageService.saveToken(bearerToken);
          return res;
        })
      )
  }

  log(message: string): void {
    console.log(`User Auth Service: ${message}`)
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
