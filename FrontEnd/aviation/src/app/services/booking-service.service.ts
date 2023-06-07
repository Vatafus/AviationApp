import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Booking } from '../class/booking';

const bookingURL = 'http://localhost:8080/bookign/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingServiceService {

  apiUrl = 'http://localhost:8080/booking';


  constructor(private httpClient: HttpClient, private router: Router) { }

  bookFlight(userId: number, flightId: number) {
    return this.httpClient.post(`${this.apiUrl}/${userId}/flights/${flightId}`, null);
  }

}