import { Injectable } from '@angular/core';
import { LoginService } from './login.service';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { map, tap } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor(private http: HttpClient, private loginService: LoginService) { }
}
