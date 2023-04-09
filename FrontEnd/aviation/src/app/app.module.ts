import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login/login.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { NavbarComponent } from './welcome/navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
import { AircraftComponent } from './aircraft/aircraft.component';
import { Boeng757Component } from './boeng757/boeng757.component';
import { FlyComponent } from './fly/fly.component';
import { WelcomepageComponent } from './welcomepage/welcomepage.component';
import { HttpIntercepterService } from './services/http/http-intercepter.service';
import { FooterComponent } from './footer/footer.component';
import { FoodComponent } from './food/food.component';
import { NewsComponent } from './news/news.component';
import { TravelComponent } from './travel/travel.component';
import { NewsPostComponent } from './news-post/news-post.component';
import { MarkdownModule } from 'ngx-markdown';

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
    NewsPostComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
    MatTableModule,
    MarkdownModule.forRoot()
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpIntercepterService, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
