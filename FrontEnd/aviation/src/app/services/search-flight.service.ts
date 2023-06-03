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
  CreateFlightApi = 'http://localhost:8080/admin/create/flight';
  GetAllFlights = 'http://localhost:8080/flights/all-flights';
  private getflightid = 'http://localhost:8080/flights/find/flight';
  private updateFlightURL = 'http://localhost:8080/admin/update/flight';
  private deleteFlightURL = 'http://localhost:8080/admin/delete/flight';

  getFlightsList(): Observable<FlightSearch[]> {
    return this.httpClient.get<FlightSearch[]>(this.GetAllFlights);
  }

  public GetFlights(leavingfrom: any, arrivingat: any, leavingdate: any): Observable<FlightSearch[]> {
    return this.httpClient.get<FlightSearch[]>(this.FlightSearchApi + leavingfrom + "/" + arrivingat + "/" + leavingdate);
  }

  createFlight(flight: FlightSearch): Observable<Object> {
    return this.httpClient.post(this.CreateFlightApi, flight);
  }

  getFlightId(id: number): Observable<FlightSearch> {
    return this.httpClient.get<FlightSearch>(`${this.getflightid}/${id}`);
  }

  updateFlight(id: number, flight: FlightSearch): Observable<Object> {
    return this.httpClient.put(`${this.updateFlightURL}/${id}`, flight);
  }

  deleteFlight(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.deleteFlightURL}/${id}`);
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



