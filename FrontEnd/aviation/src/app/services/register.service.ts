import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../class/user';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  baseUrl = "http://localhost:8080/user/register"

  constructor(private httpclient: HttpClient) { }

  //Aici se face apelarea catre backend pentru inregistrarea unui nou utilizator
  registerUser(user: User): Observable<Object> {
    console.log(user);
    let HeaderHttp = this.createHeaderHttp();
    let headers = new HttpHeaders({
      Autohorization: HeaderHttp
    })
    return this.httpclient.post(`${this.baseUrl}`, user, { headers });
  }

  createHeaderHttp() {
    let username = 'admin';
    let password = 'admin';
    let basicAuthHeaderString = 'Basic ' + window.btoa(`${username}:${password}`);
    return basicAuthHeaderString;
  }
}
