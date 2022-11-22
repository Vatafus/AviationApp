import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserLogin } from 'src/app/class/userlogin';
import { AuthService } from 'src/app/services/auth.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: UserLogin = new UserLogin();

  constructor(private route: Router,
    private loginService: LoginService,
    private authService: AuthService) { }

  ngOnInit(): void {
  }

  userLogin() {
    console.log(this.user)
    this.loginService.loginUser(this.user).subscribe(value => {
      this.route.navigate(['/welcome'])
    }, error => alert("Sorry please enter a valid Email")
    );
  }

}
