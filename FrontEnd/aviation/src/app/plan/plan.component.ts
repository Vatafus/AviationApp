import { Component, OnInit } from '@angular/core';
import { BookingServiceService } from '../services/booking-service.service';
import { StorageServiceService } from '../services/storage-service.service';
import { Booking } from '../class/booking';
import { Boardingpass } from '../class/boardingpass';

@Component({
  selector: 'app-plan',
  templateUrl: './plan.component.html',
  styleUrls: ['./plan.component.css']
})
export class PlanComponent implements OnInit {

  bookings: Booking[] = [];

  constructor(private bookingService: BookingServiceService, private storageService: StorageServiceService) { }

  ngOnInit(): void {

    const userId = this.storageService.getUser();
    this.bookingService.bookings(userId).subscribe(
      (bookings: Booking[]) => {
        this.bookings = bookings;
      },
      (error: any) => {
        console.log(error);
      }
    );


  }

}
