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

  httpOptions = {
    headers: new HttpHeaders({ responseType: 'text' as 'json', 'Access-Control-Allow-Origin': '*' })
  };

  private itemSubject: BehaviorSubject<Booking[]>;

  constructor(private httpClient: HttpClient, private router: Router) { }

  addBooking(idFlight: number, nrScaun: number): Observable<Booking> {
    const pozitieX = nrScaun % 7;
    const pozitieY = Math.floor(nrScaun / 14) + 1;

    return this.httpClient.post<Booking>(bookingURL, {
      pozitieX, pozitieY,
      nrScaun
    }, this.httpOptions);
  }
}
