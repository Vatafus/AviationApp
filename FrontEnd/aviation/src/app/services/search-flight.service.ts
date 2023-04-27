import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchFlightService {

  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8080/flights';

  searchFlight(FromName: string): Observable<any> {
    return this.http.get('${this.baseUrl}/${leavingfrom}');
  }
}

