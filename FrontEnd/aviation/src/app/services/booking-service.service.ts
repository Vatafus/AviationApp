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

  apiUrl = 'http://localhost:8080';

  httpOptions = {
    headers: new HttpHeaders({ responseType: 'text' as 'json', 'Access-Control-Allow-Origin': '*' })
  };

  private itemSubject: BehaviorSubject<Booking[]>;

  constructor(private httpClient: HttpClient, private router: Router) { }

  getBookings(email) {
    return this.httpClient.get<Booking[]>(this.apiUrl + '/bookings/getByUser/' + email);
  }

  endBooking(bookingid) {
    return this.httpClient.get<Boolean>(this.apiUrl + '/bookings/endBooking/' + bookingid);
  }
}