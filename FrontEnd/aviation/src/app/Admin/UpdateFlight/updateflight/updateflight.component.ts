import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { error } from 'console';
import { EROFS } from 'constants';
import { FlightSearch } from 'src/app/class/flight-search';
import { SearchFlightService } from 'src/app/services/search-flight.service';

@Component({
  selector: 'app-updateflight',
  templateUrl: './updateflight.component.html',
  styleUrls: ['./updateflight.component.css']
})
export class UpdateflightComponent implements OnInit {

  flight: FlightSearch = new FlightSearch();
  id: number;

  constructor(private searchflightservice: SearchFlightService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.searchflightservice.getFlightId(this.id).subscribe(data => {
      this.flight = data;
    }, error => console.log(error));
  }

  onSubmit() {
    this.searchflightservice.updateFlight(this.id, this.flight).subscribe(data => {
      this.goToFlightsList();
    }, error => console.log(error));
  }

  goToFlightsList() {
    this.router.navigate(['/dashboard']);
  }

}
