import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
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

  // user: UserLogin = new UserLogin();
  validateForm !: FormGroup;

  constructor(private route: Router,
    private loginService: LoginService,
    private authService: AuthService,
    private fb: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]],
    })
  }

  userLogin() {
    this.loginService.login(this.validateForm.get(['username'])!.value, this.validateForm.get(['password'])!.value).subscribe((res) => {
      console.log(res);
    })
  }

}
