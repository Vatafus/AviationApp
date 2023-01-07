import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../class/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  baseUrl = "http://localhost:8080/user/register"

  constructor(private httpclient: HttpClient) { }

  //Aici se face apelarea catre backend pentru inregistrarea unui nou utilizator
  registerUser(user: User): Observable<Object> {
    console.log(user);
    return this.httpclient.post(`${this.baseUrl}`, user);
  }
}
