import { Component, OnInit } from '@angular/core';
import { FlightSearch } from '../class/flight-search';
import { Booking } from '../class/booking';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingServiceService } from '../services/booking-service.service';

@Component({
    selector: 'app-booking',
    templateUrl: './booking.component.html',
    styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

    show: boolean;
    email$ = sessionStorage.getItem('email');
    bookings$: Booking[] = [];

    constructor(private bookingService: BookingServiceService, private router: Router) {
    }

    ngOnInit() {
        this.getBookingById();

    }

    getBookingById() {
        return this.bookingService.getBookings(this.email$)
            .subscribe(data => { this.bookings$ = data, this.checkBookingFn(); })
    }

    endBooking(bookingid) {
        return this.bookingService.endBooking(bookingid)
            .subscribe((data: {}) => {
                alert('Booking Confirmed');
                location.reload();
                this.router.navigate(['dashboard/bookings'])
            })
    }

    checkBookingFn() {
        console.log()
        if (this.bookings$.length == 0) {
            this.show = true
        }
        else {
            this.show = false
        }
    }

    checkLogin() {
        if (sessionStorage.length == 0) {
            this.router.navigate(['login']);
        }
    }



}
