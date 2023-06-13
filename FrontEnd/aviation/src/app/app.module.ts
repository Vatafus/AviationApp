import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { NavbarComponent } from './welcome/navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
import { AircraftComponent } from './aircraft/aircraft.component';
import { Boeng757Component } from './boeng757/boeng757.component';
import { FlyComponent } from './fly/fly.component';
import { WelcomepageComponent } from './welcomepage/welcomepage.component';
// import { HttpIntercepterService } from './services/http/http-intercepter.service';
import { FooterComponent } from './footer/footer.component';
import { FoodComponent } from './food/food.component';
import { NewsComponent } from './news/news.component';
import { TravelComponent } from './travel/travel.component';
import { NewsPostComponent } from './news-post/news-post.component';
import { MarkdownModule } from 'ngx-markdown';
import { FlightSearchComponent } from './flight-search/flight-search.component';
import { BookingComponent } from './booking/booking.component';
import { Airbus330Component } from './airbus330/airbus330.component';
import { EconomyclassComponent } from './Travel Classes/Economy Class/economyclass/economyclass.component';
import { BusinessclassComponent } from './Travel Classes/Business Class/businessclass/businessclass.component';
import { PremiumclassComponent } from './Travel Classes/Premium Economy Class/premiumclass/premiumclass.component';
import { CreateflightComponent } from './Admin/CreateFlight/createflight/createflight.component';
import { DashboardComponent } from './Admin/Dashboard/dashboard/dashboard.component';
import { UpdateflightComponent } from './Admin/UpdateFlight/updateflight/updateflight.component';
import { SlotComponent } from './slot/slot.component';
import { AdmingModule } from './module/adming/adming.module';
import { UserModule } from './module/user/user.module';
import { UserGuard } from './guards/user-guard/user.guard';
import { AdminGuard } from './guards/admin-guard/admin.guard';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    RegisterComponent,
    AircraftComponent,
    Boeng757Component,
    FlyComponent,
    WelcomepageComponent,
    FooterComponent,
    FoodComponent,
    NewsComponent,
    TravelComponent,
    NewsPostComponent,
    FlightSearchComponent,
    BookingComponent,
    Airbus330Component,
    EconomyclassComponent,
    BusinessclassComponent,
    PremiumclassComponent,
    CreateflightComponent,
    DashboardComponent,
    UpdateflightComponent,
    SlotComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
    MatTableModule,
    MarkdownModule.forRoot(),
    ReactiveFormsModule,
    AdmingModule,
    UserModule
  ],
  providers: [UserGuard, AdminGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
