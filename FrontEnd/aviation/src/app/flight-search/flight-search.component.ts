import { Component } from '@angular/core';
import { WelcomepageComponent } from '../welcomepage/welcomepage.component';
import { SearchFlightService } from '../services/search-flight.service';
import { FlightSearch } from '../class/flight-search';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { error } from 'console';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})
export class FlightSearchComponent {

  flight: FlightSearch[] = [];
  displayedColumns: string[] = ['Id', 'leavingfrom', 'arrivingat', 'leavingdate'];
  collapsed = true;
  constructor(private router: Router, private service: SearchFlightService) { }

  ngOnInit(): void {
    this.searchFlight();
  }

  public searchFlight() {
    this.service.searchFlight().subscribe(
      (resp: FlightSearch[]) => {
        console.log(resp);
        this.flight = resp;
      }, (error: HttpErrorResponse) => {
        console.log(error);
      }
    )
  }
}
