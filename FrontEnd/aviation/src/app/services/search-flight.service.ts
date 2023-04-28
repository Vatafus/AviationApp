import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FlightSearch } from '../class/flight-search';

@Injectable({
  providedIn: 'root'
})
export class SearchFlightService {

  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8080/flights';

  searchFlight() {
    return this.http.get<FlightSearch[]>('${this.baseUrl}/${leavingfrom}');
  }
}

