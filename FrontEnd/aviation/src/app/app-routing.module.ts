import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AircraftComponent } from './aircraft/aircraft.component';
import { Boeng757Component } from './boeng757/boeng757.component';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './register/register.component';
// import { RouteGuardService } from './services/route-guard.service';
import { WelcomepageComponent } from './welcomepage/welcomepage.component';
import { FlyComponent } from './fly/fly.component';
import { FoodComponent } from './food/food.component';
import { NewsComponent } from './news/news.component';
import { TravelComponent } from './travel/travel.component';
import { NewsPostComponent } from './news-post/news-post.component';
import { FlightSearchComponent } from './flight-search/flight-search.component';
import { BookingComponent } from './booking/booking.component';
import { Airbus330Component } from './airbus330/airbus330.component';
import { EconomyclassComponent } from './Travel Classes/Economy Class/economyclass/economyclass.component';
import { BusinessclassComponent } from './Travel Classes/Business Class/businessclass/businessclass.component';
import { PremiumclassComponent } from './Travel Classes/Premium Economy Class/premiumclass/premiumclass.component';
import { CreateflightComponent } from './Admin/CreateFlight/createflight/createflight.component';
import { DashboardComponent } from './Admin/Dashboard/dashboard/dashboard.component';
import { UpdateflightComponent } from './Admin/UpdateFlight/updateflight/updateflight.component';
import { UserGuard } from './guards/user-guard/user.guard';
import { AdminGuard } from './guards/admin-guard/admin.guard';
import { PlanComponent } from './plan/plan.component';


const routes: Routes = [
  { path: '', component: LoginComponent }, //TO Change with Welcome Component TODO
  { path: 'login', component: LoginComponent },
  { path: 'aircraft', component: AircraftComponent },
  { path: 'boeng757', component: Boeng757Component },
  { path: 'welcome', component: WelcomepageComponent },
  { path: 'fly', component: FlyComponent },
  { path: 'food', component: FoodComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'news', component: NewsComponent },
  { path: 'blog/:id', component: NewsPostComponent },
  { path: 'search', component: FlightSearchComponent },
  { path: 'search/:keyword', component: FlightSearchComponent },
  { path: 'travel', component: TravelComponent },
  { path: 'booking/:id/:date', component: BookingComponent },
  { path: 'airbus330', component: Airbus330Component },
  { path: 'mybookings', component: PlanComponent },
  { path: 'economy', component: EconomyclassComponent },
  { path: 'business', component: BusinessclassComponent },
  // { path: 'addFlight', component: CreateflightComponent },
  { path: 'premium', component: PremiumclassComponent },
  // { path: 'update-flight/:id', component: UpdateflightComponent },
  // { path: 'dashboard', component: DashboardComponent },
  { path: 'admin', loadChildren: () => import("src/app/module/adming/adming.module").then(m => m.AdmingModule) },
  { path: 'user', loadChildren: () => import("src/app/module/user/user.module").then(m => m.UserModule) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
