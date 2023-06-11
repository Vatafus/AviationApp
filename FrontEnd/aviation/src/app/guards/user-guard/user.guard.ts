import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { StorageServiceService } from 'src/app/services/storage-service.service';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {

  constructor(private router: Router, public storageService: StorageServiceService) {

  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    if (this.storageService.isAdmingLoggedIn()) {
      this.router.navigateByUrl("/admin/dashboard");
      return false;
    }
    else if (!this.storageService.hasToken()) {
      this.storageService.signOut;
      this.router.navigateByUrl("/login");
      return false;
    }
    return true;
  }
}

