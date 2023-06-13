import { Component, Input, OnInit } from '@angular/core';
import { FlightSearch } from '../class/flight-search';
import { Booking } from '../class/booking';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingServiceService } from '../services/booking-service.service';
import { Sits } from '../class/sits';
import { SitsServiceService } from '../services/sits-service.service';
import { SearchFlightService } from '../services/search-flight.service';
import { StorageServiceService } from '../services/storage-service.service';

@Component({
    selector: 'app-booking',
    templateUrl: './booking.component.html',
    styleUrls: ['./booking.component.css']
})
export class BookingComponent {

    userId: number;
    flightId: number;
    arrivingat: string;
    leavingfrom: string;
    flight: FlightSearch = new FlightSearch();

    constructor(private bookingService: BookingServiceService, private route: ActivatedRoute, private router: Router, private searchflightservice: SearchFlightService, private storageService: StorageServiceService) { }

    ngOnInit(): void {
        this.flightId = this.route.snapshot.params['id'];
        this.userId = this.storageService.getUser();
        this.searchflightservice.getFlightId(this.flightId).subscribe(data => {
            this.flight = data;
        }, error => console.log(error));
    }

    onSubmit() {
        this.bookingService.bookFlight(this.userId, this.flightId).subscribe(data => {
            this.goToFlightsList();
            alert("You Booked this flight")
        }, error => console.log(error));
    }

    goToFlightsList() {
        this.router.navigate(['/welcome']);
    }

}
