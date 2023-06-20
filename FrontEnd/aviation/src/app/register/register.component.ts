import { Component, OnInit } from '@angular/core';
import { User } from '../class/user';
import { Router } from '@angular/router';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  constructor(private router: Router, private registerService: RegisterService) { }

  ngOnInit(): void {
  }

  userRegister() {

    if (this.user.password !== this.user.cpassword) {
      alert("Password and Confirm Password do not match");
      return;
    }
    console.log(this.user);
    this.registerService.registerUser(this.user).subscribe(data => {
      alert("Successfully User register")
    }, (error: any) => {
      if (error.status === 406) {
        alert("User already exists");
      } else {
        alert("Registration failed. Please try again later!");
      }
    });

  }


}
