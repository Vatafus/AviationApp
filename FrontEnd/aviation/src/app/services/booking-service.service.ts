import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, throwError } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Booking } from '../class/booking';
import { Boardingpass } from '../class/boardingpass';
import { StorageServiceService } from './storage-service.service';

const bookingURL = 'http://localhost:8080/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingServiceService {

  apiUrl = 'http://localhost:8080/booking';


  constructor(private httpClient: HttpClient, private router: Router, public storageService: StorageServiceService) { }

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


  getUserBookingsWithBoardingPasses(userId: number): Observable<any> {
    const url = `${this.apiUrl}/user/${userId}/bookings-with-boarding-passes`;
    const headers = this.createdAuthorizationHeader();
    return this.httpClient.get<any>(url, { headers });
  }


  // getUserBookings(userId: number): Observable<any> {
  //   return this.httpClient.get<any>(`${this.apiUrl}/${userId}/bookings`, { headers: this.createdAuthorizationHeader() });
  // }


  createdAuthorizationHeader(): HttpHeaders {
    let authHeader: HttpHeaders = new HttpHeaders();
    console.log(this.storageService.getToken());
    return authHeader.set(
      "Authorization",
      "Bearer " + this.storageService.getToken()

    )
  }

  markCanceledBookingsInArchived(): Observable<any> {
    const url = `http://localhost:4200/admin/mark-canceled-bookings`;
    return this.httpClient.post(url, null);
  }



}