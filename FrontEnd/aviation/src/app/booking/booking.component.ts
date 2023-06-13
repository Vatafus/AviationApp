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
import { Boardingpass } from '../class/boardingpass';

@Component({
    selector: 'app-booking',
    templateUrl: './booking.component.html',
    styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

    userId: number;
    flightId: number;
    arrivingat: string;
    leavingfrom: string;
    flight: FlightSearch = new FlightSearch();
    boardingPasses: Boardingpass[] = [];


    constructor(private bookingService: BookingServiceService,
        private route: ActivatedRoute,
        private router: Router,
        private searchflightservice: SearchFlightService,
        private storageService: StorageServiceService) { }

    ngOnInit(): void {
        this.flightId = this.route.snapshot.params['id'];
        this.userId = this.storageService.getUser();
        this.searchflightservice.getFlightId(this.flightId).subscribe(data => {
            this.flight = data;
        }, error => console.log(error));
    }

    onSubmit() {
        this.bookingService.bookFlight(this.userId, this.flightId).subscribe((data: any) => {
            if (data && data.id) {
                this.addBoardingPassToBooking(data.id);
                this.goToFlightsList();
                alert("You Booked this flight")
            } else { console.log("Invalid response data:", data); }
        }, error => console.log(error));
    }

    goToFlightsList() {
        this.router.navigate(['/welcome']);
    }

    addBoardingPass() {
        if (this.boardingPasses.length < 3) {
            this.boardingPasses.push(new Boardingpass());
        } else {
            alert("Cannot add more than 3 boarding passes.");
        }
    }



    removeBoardingPass(index: number) {
        this.boardingPasses.splice(index, 1);
    }

    addBoardingPassToBooking(bookingId: number) {
        for (const boardingPass of this.boardingPasses) {
            if (boardingPass.name && boardingPass.identifycard) {
                const newBoardingPass: Boardingpass = {
                    name: boardingPass.name,
                    identifycard: boardingPass.identifycard
                };
                this.bookingService.addBoardingPassToBooking(bookingId, newBoardingPass).subscribe(
                    () => {
                        console.log("Boarding pass added successfully");
                    },
                    (error) => {
                        console.log(error);
                    }
                );
            } else {
                console.log("Numele și cardul de identitate sunt obligatorii pentru adăugarea unui boarding pass.");
            }
        }
    }
}
