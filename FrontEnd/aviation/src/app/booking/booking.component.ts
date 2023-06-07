import { Component, Input, OnInit } from '@angular/core';
import { FlightSearch } from '../class/flight-search';
import { Booking } from '../class/booking';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingServiceService } from '../services/booking-service.service';
import { Sits } from '../class/sits';
import { SitsServiceService } from '../services/sits-service.service';

@Component({
    selector: 'app-booking',
    templateUrl: './booking.component.html',
    styleUrls: ['./booking.component.css']
})
export class BookingComponent {

    userId: number;
    flightId: number;

    constructor(private bookingService: BookingServiceService) { }

    bookFlight() {
        this.bookingService.bookFlight(this.userId, this.flightId)
            .subscribe(() => {
                console.log('Booking successful');
                // Puteți adăuga alte acțiuni după rezervare (ex. afișare mesaj de succes)
            }, (error) => {
                console.error('Booking error:', error);
                // Puteți trata erorile aici (ex. afișare mesaj de eroare)
            });
    }

}
