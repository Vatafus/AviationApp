import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { StorageServiceService } from 'src/app/services/storage-service.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(private router: Router, public storageService: StorageServiceService) {

  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    if (this.storageService.isUserLoggedIn) {
      this.router.navigateByUrl("/user/welcome");
      return false;
    }
    else if (!this.storageService.hasToken) {
      this.storageService.signOut;
      this.router.navigateByUrl("/login");
      return false;
    }
    return true;
  }
}
