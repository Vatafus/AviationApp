import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserLogin } from 'src/app/class/userlogin';
import { AuthService } from 'src/app/services/auth.service';
import { LoginService } from 'src/app/services/login.service';
import { StorageServiceService } from 'src/app/services/storage-service.service';

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
    private router: Router,
    private storageService: StorageServiceService) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]],
    })
  }

  userLogin() {
    this.loginService.login(this.validateForm.get(['username'])!.value, this.validateForm.get(['password'])!.value).subscribe((res) => {
      // console.log(res);
      // if (this.storageService.isUserLoggedIn()) {
      //   this.router.navigateByUrl('/welcome');
      // }
      console.log(this.storageService.getUser());
    })
  }

}
