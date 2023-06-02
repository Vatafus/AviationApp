import { Component, OnInit } from '@angular/core';
import { FlightSearch } from 'src/app/class/flight-search';

@Component({
  selector: 'app-createflight',
  templateUrl: './createflight.component.html',
  styleUrls: ['./createflight.component.css']
})
export class CreateflightComponent implements OnInit {

  flight: FlightSearch = new FlightSearch();

  constructor() {

  }


  ngOnInit(): void {

  }

  onSubmit() {

  }
}
