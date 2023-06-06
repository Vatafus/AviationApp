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
export class BookingComponent implements OnInit {

    load: boolean;
    sits$: Sits[];

    @Input() bookingdetails = {
        'email': '',
        'locationid': '',
        'sit_type': '',
        'duration': 0,
        'time': '',
        'slotid': '',
        'date': '',
        'vehicle_no': '',
    }

    constructor(private bookingService: BookingServiceService, private router: Router,
        private actRoute: ActivatedRoute, private sitService: SitsServiceService) {
    }

    ngOnInit(): void {
        this.load = false;
        this.getSits();
    }


    getSits() {
        return this.sitService.getSits()
            .subscribe(data => this.sits$ = data)
    }

    addBooking() {
        if (this.bookingdetails.sit_type == '' || this.bookingdetails.slotid == '' || this.bookingdetails.duration == 0) {
            alert('Kindly fill all the data')
            return
        }
        this.load = true;
        this.bookingService.addBooking(this.bookingdetails)
            .subscribe((data: {}) => {
                alert('Show Booked');
                this.router.navigate(['/dashboard/bookings'])
            })
    }


    // ngOnInit() {
    //     this.getBookingById();

    // }

    // getBookingById() {
    //     return this.bookingService.getBookings(this.email$)
    //         .subscribe(data => { this.bookings$ = data, this.checkBookingFn(); })
    // }

    // endBooking(bookingid) {
    //     return this.bookingService.endBooking(bookingid)
    //         .subscribe((data: {}) => {
    //             alert('Booking Confirmed');
    //             location.reload();
    //             this.router.navigate(['dashboard/bookings'])
    //         })
    // }

    // checkBookingFn() {
    //     console.log()
    //     if (this.bookings$.length == 0) {
    //         this.show = true
    //     }
    //     else {
    //         this.show = false
    //     }
    // }

    // checkLogin() {
    //     if (sessionStorage.length == 0) {
    //         this.router.navigate(['login']);
    //     }
    // }



}
