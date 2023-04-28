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

  constructor(private router: Router, private service: SearchFlightService) { }

  ngOnInit(): void {
  }


}
