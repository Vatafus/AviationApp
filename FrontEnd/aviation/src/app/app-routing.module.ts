import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AircraftComponent } from './aircraft/aircraft.component';
import { Boeng757Component } from './boeng757/boeng757.component';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './register/register.component';
import { RouteGuardService } from './services/route-guard.service';
import { WelcomepageComponent } from './welcomepage/welcomepage.component';

const routes: Routes = [
  { path: '', component: LoginComponent }, //TO Change with Welcome Component TODO
  { path: 'login', component: LoginComponent },
  { path: 'aircraft', component: AircraftComponent, canActivate: [RouteGuardService] },
  { path: 'boeng757', component: Boeng757Component, canActivate: [RouteGuardService] },
  { path: 'welcome', component: WelcomepageComponent },
  { path: 'register', component: RegisterComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
