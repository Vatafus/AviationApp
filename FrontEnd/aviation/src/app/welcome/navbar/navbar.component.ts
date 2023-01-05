import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLogin } from 'src/app/class/userlogin';
import { AuthService } from 'src/app/services/auth.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor(private loginService: LoginService) { }
  isUserLoggedIn: boolean = false;
  ngOnInit() {
    this.isUserLoggedIn = this.loginService.isUserLoggedIn();
  }

  userLogout() {
    this.loginService.logout();
  }
}
