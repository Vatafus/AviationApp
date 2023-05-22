import { Injectable } from '@angular/core';
import { LoginService } from './login.service';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { map, tap } from 'rxjs';


const BASIC_URL = "localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    return this.http.post<[]>(BASIC_URL + "user/" + "login", + {
      username, password
    }, { observe: 'response' })
      .pipe(
        tap(__ => this.log("User Authentication")),
        map((res: HttpResponse<any>) => {
          console.log(res);
        })
      )
  }

  log(message: string): void {
    console.log('User Auth Service: $(message)')
  }
}
