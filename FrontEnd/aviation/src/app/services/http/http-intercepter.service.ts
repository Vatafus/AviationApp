import { Injectable } from '@angular/core';
import { HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterService implements HttpInterceptor {

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let username = 'admin';
    let password = 'admin';
    let basicAuthHeaderString = 'Basic ' + window.btoa(`${username}:${password}`);
    req = req.clone({
      setHeaders: {
        Authorization: basicAuthHeaderString
      }
    })
    return next.handle(req);
  }
}
