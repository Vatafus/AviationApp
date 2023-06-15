import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, throwError } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Booking } from '../class/booking';
import { Boardingpass } from '../class/boardingpass';

const bookingURL = 'http://localhost:8080/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingServiceService {

  apiUrl = 'http://localhost:8080/booking';


  constructor(private httpClient: HttpClient, private router: Router) { }

  bookFlight(userId: number, flightId: number): Observable<any> {
    const url = `${bookingURL}/${userId}/flights/${flightId}`;
    return this.httpClient.post<Booking>(url, null);
  }

  addBoardingPassToBooking(bookingId: number, boardingPass: Boardingpass): Observable<Booking> {
    const url = `${this.apiUrl}/${bookingId}/boarding-passes`;
    return this.httpClient.post<Booking>(url, boardingPass).pipe(
      catchError((error) => {
        console.log(error);
        return throwError(error);
      })
    );
  }

  getUserBookings(userId: number): Observable<Booking[]> {
    const url = `${bookingURL}/user/${userId}`;
    return this.httpClient.get<Booking[]>(url);
  }

  getBoardingPasses(bookingId: number): Observable<Boardingpass[]> {
    const url = `${this.apiUrl}/booking/${bookingId}/boarding-passes`;
    return this.httpClient.get<Boardingpass[]>(url);
  }

}