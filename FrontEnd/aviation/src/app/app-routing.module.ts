import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AircraftComponent } from './aircraft/aircraft.component';
import { Boeng757Component } from './boeng757/boeng757.component';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './register/register.component';
import { RouteGuardService } from './services/route-guard.service';
import { WelcomepageComponent } from './welcomepage/welcomepage.component';
import { FlyComponent } from './fly/fly.component';
import { FoodComponent } from './food/food.component';
import { NewsComponent } from './news/news.component';
import { TravelComponent } from './travel/travel.component';
import { NewsPostComponent } from './news-post/news-post.component';

const routes: Routes = [
  { path: '', component: LoginComponent }, //TO Change with Welcome Component TODO
  { path: 'login', component: LoginComponent },
  { path: 'aircraft', component: AircraftComponent, canActivate: [RouteGuardService] },
  { path: 'boeng757', component: Boeng757Component },
  { path: 'welcome', component: WelcomepageComponent },
  { path: 'fly', component: FlyComponent },
  { path: 'food', component: FoodComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'news', component: NewsComponent },
  { path: 'blog/:id', component: NewsPostComponent },
  { path: 'travel', component: TravelComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
