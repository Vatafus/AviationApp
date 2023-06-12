import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLogin } from 'src/app/class/userlogin';
import { AuthService } from 'src/app/services/auth.service';
import { LoginService } from 'src/app/services/login.service';
import { Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { StorageServiceService } from 'src/app/services/storage-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor(public loginService: LoginService, private router: Router, public storageService: StorageServiceService) { }
  isUserLoggedIn: boolean = false;
  isAdminLoggedIn: boolean = false;
  ngOnInit() {
    this.isUserLoggedIn = this.storageService.isUserLoggedIn();
    this.isAdminLoggedIn = this.storageService.isAdmingLoggedIn();
  }

  userLogout() {
    this.storageService.signOut();
  }

} 
