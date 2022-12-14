import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AircraftComponent } from './aircraft/aircraft.component';
import { Boeng757Component } from './boeng757/boeng757.component';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './register/register.component';
import { NavbarComponent } from './welcome/navbar/navbar.component';

const routes: Routes = [
  { path: '', component: NavbarComponent },
  { path: 'login', component: LoginComponent },
  { path: 'aircraft', component: AircraftComponent },
  { path: 'boeng727', component: Boeng757Component },
  { path: 'register', component: RegisterComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
