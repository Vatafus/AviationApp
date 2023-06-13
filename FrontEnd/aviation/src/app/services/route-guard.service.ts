// import { Injectable } from '@angular/core';
// import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
// import { LoginService } from './login.service';
// import { StorageServiceService } from './storage-service.service';


// @Injectable({
//   providedIn: 'root'
// })
// export class RouteGuardService implements CanActivate {

//   constructor(private loginService: LoginService, private storageService: StorageServiceService, private router: Router) { }

//Se foloseste conceptul de route-guard pentru autorizarea accesului in aplicatie.
//Am folosit functia CanActivate pentru a restrictiona accesul utilizatorilor care nu sunt logati,
//in diferite parti ale aplicatiei, verificand astfel daca userul este logat prin Injectarea Serviciului de logare.
//   canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
//     if (this.storageService.isAdmingLoggedIn()) {
//       alert('Welcome');
//       this.router.navigate(['/dashboard']);
//       return false;
//     }
//     else if (this.storageService.isUserLoggedIn()) {
//       alert('Nu ai acces aici!');
//       this.router.navigate(['/welcome']);
//       return false;
//     }
//     return true;
//   }
// }
