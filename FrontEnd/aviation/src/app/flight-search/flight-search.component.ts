import { Component } from '@angular/core';
import { WelcomepageComponent } from '../welcomepage/welcomepage.component';
import { SearchFlightService } from '../services/search-flight.service';
import { FlightSearch } from '../class/flight-search';
import { Router } from '@angular/router';

@Component({
  selector: 'app-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.css']
})
export class FlightSearchComponent {

  flightSearch!: FlightSearch;
  fromName!: string;
  show: boolean = false;
  constructor(private router: Router, private service: SearchFlightService) { }

  ngOnInit(): void {
    this.flightSearch = new FlightSearch();
  }

  searchFlight(fromName: string): any {
    this.show = true;
    this.service.searchFlight(fromName).subscribe((flightSearch: FlightSearch) => this.flightSearch = flightSearch);
  }


  search() {

    this.router.navigate(['/search-flight/searchFlight']);

  }
}
