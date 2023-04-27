import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SearchFlightService } from '../services/search-flight.service';
import { FlightSearch } from '../class/flight-search';

@Component({
  selector: 'app-welcomepage',
  templateUrl: './welcomepage.component.html',
  styleUrls: ['./welcomepage.component.css']
})
export class WelcomepageComponent implements OnInit {
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
