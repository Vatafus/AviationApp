import { Component } from '@angular/core';
import { WelcomepageComponent } from '../welcomepage/welcomepage.component';
import { SearchFlightService } from '../services/search-flight.service';
import { FlightSearch } from '../class/flight-search';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})
export class FlightSearchComponent {

  public confirmClicked: boolean = false;
  public cancelClicked: boolean = false;
  flightSearch!: Observable<FlightSearch[]>;
  fromName!: string;
  constructor(private router: Router, private service: SearchFlightService) { }

  ngOnInit(): void {
    this.service.searchFlight(this.fromName).subscribe(
      (data: Observable<FlightSearch[]>) => this.flightSearch = data
    );
  }

  search() {

    this.router.navigate(['/search-flight/searchFlight']);

  }
}
