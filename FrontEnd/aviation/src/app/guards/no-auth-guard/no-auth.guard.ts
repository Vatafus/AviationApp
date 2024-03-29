import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { StorageServiceService } from 'src/app/services/storage-service.service';

@Injectable({
  providedIn: 'root'
})
export class NoAuthGuard implements CanActivate {

  constructor(private router: Router, public storageService: StorageServiceService) {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    if (this.storageService.hasToken() && this.storageService.isUserLoggedIn()) {
      this.router.navigateByUrl("/user/welcome")
      return false;
    } else if (this.storageService.hasToken() && this.storageService.isAdmingLoggedIn()) {
      this.router.navigateByUrl("/admin/dashboard");
      return false;
    }
    return true;
  }



}
