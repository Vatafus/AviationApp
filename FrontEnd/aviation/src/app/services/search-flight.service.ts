import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FlightSearch } from '../class/flight-search';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SearchFlightService {


  constructor(private httpClient: HttpClient) { }

  FlightSearchApi = 'http://localhost:8080/flights/find/';

  GetFlights(leavingfrom: any): Observable<FlightSearch[]> {
    return this.httpClient.get<FlightSearch[]>(this.FlightSearchApi + leavingfrom)

  }

  // public getAllFlights() {
  //   return this.httpClient.get<FlightSearch[]>("http://localhost:8080/flights/all-flights")
  // }

  // public getFlightsAfterLeavingLocation(leavingfrom: string) {
  //   return this.httpClient.get<FlightSearch[]>("http://localhost:8080/flights/" + leavingfrom);
  // }

  // searchFlights(theKeyword: string): Observable<FlightSearch[]> {
  //   const searchFlights = 'http://localhost:8080/flights/${theKeyword}';
  //   return this.getFlights(searchFlights);
  // }

  // private getFlights(searchUrl: string): Observable<FlightSearch[]> {
  //   return this.httpClient.get<GetResponseFlights>(searchUrl).pipe(map(response => response._embedded.flights));
  // }
}
// interface GetResponseFlights {
//   _embedded: {
//     flights: FlightSearch[];
//   }
// }



