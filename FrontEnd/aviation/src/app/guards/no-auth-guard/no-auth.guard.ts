import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { StorageServiceService } from 'src/app/services/storage-service.service';

@Injectable({
  providedIn: 'root'
})
export class NoAuthGuard implements CanActivate {

  constructor(private router: Router) {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    if (StorageServiceService.hasToken() && StorageServiceService.isUserLoggedIn()) {
      this.router.navigateByUrl("/user/welcome")
      return false;
    } else if (StorageServiceService.hasToken() && StorageServiceService.isAdmingLoggedIn()) {
      this.router.navigateByUrl("/admin/dashboard");
      return false;
    }
    return true;
  }



}
