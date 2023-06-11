import { HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FlightSearch } from 'src/app/class/flight-search';
import { SearchFlightService } from 'src/app/services/search-flight.service';
import { StorageServiceService } from 'src/app/services/storage-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  flights: FlightSearch[];

  constructor(private searchflightservice: SearchFlightService, private router: Router, private storageService: StorageServiceService) { }

  ngOnInit(): void {
    this.getFlights();
  }

  private getFlights() {
    this.searchflightservice.getFlightsList().subscribe(data => {
      this.flights = data;
    })
  }

  updateFlight(id: number) {
    this.router.navigate(["update-flight", id]);
  }

  deleteFlight(id: number) {
    this.searchflightservice.deleteFlight(id).subscribe(data => {
      alert("Flight successfully deleted")
      this.getFlights();
    })
  }
}
