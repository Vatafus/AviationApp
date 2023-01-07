import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot } from '@angular/router';
import { LoginService } from './login.service';


@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private loginService: LoginService) { }

  //Se foloseste conceptul de route-guard pentru autorizarea accesului in aplicatie.
  //Am folosit functia CanActivate pentru a restrictiona accesul utilizatorilor care nu sunt logati,
  //in diferite parti ale aplicatiei, verificand astfel daca userul este logat prin Injectarea Serviciului de logare.
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.loginService.isUserLoggedIn())
      return true;
    return false;
  }
}
