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
    console.log(this.user);
    this.registerService.registerUser(this.user).subscribe(data => {
      alert("Successfully User register")
    });

  }


}
