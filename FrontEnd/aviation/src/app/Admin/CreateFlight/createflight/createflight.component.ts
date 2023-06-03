import { Component, OnInit } from '@angular/core';
import { RouteReuseStrategy, Router } from '@angular/router';
import { error } from 'console';
import { FlightSearch } from 'src/app/class/flight-search';
import { SearchFlightService } from 'src/app/services/search-flight.service';

@Component({
  selector: 'app-createflight',
  templateUrl: './createflight.component.html',
  styleUrls: ['./createflight.component.css']
})
export class CreateflightComponent implements OnInit {

  flight: FlightSearch = new FlightSearch();

  constructor(private flightService: SearchFlightService, private router: Router) {

  }


  ngOnInit(): void {

  }

  saveFlight() {
    this.flightService.createFlight(this.flight).subscribe(data => {
      alert("Flight Created with Successs")
      this.goToFlightsList();
    });
  }

  goToFlightsList() {
    this.router.navigate(['/dashboard']);
  }

  onSubmit() {
    console.log(this.flight);
    this.saveFlight();
  }
}
