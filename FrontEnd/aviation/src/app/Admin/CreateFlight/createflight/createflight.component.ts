import { Component, OnInit } from '@angular/core';
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

  constructor(private flightService: SearchFlightService) {

  }


  ngOnInit(): void {

  }

  saveFlight() {
    this.flightService.createFlight(this.flight).subscribe(data => {
      alert("Flight Created with Successs")
    });
  }

  onSubmit() {
    console.log(this.flight);
    this.saveFlight();
  }
}
