import { Component, OnInit } from '@angular/core';
import { BookingServiceService } from '../services/booking-service.service';
import { StorageServiceService } from '../services/storage-service.service';
import { Booking } from '../class/booking';
import { Boardingpass } from '../class/boardingpass';
import { FlightSearch } from '../class/flight-search';

@Component({
  selector: 'app-plan',
  templateUrl: './plan.component.html',
  styleUrls: ['./plan.component.css']
})
export class PlanComponent implements OnInit {

  bookings: any;

  constructor(private bookingService: BookingServiceService, private storageService: StorageServiceService) { }

  ngOnInit(): void {
    const userId = this.storageService.getUser();
    this.getUserBookingsWithBoardingPasses(userId);
  }

  getUserBookingsWithBoardingPasses(userId: number): void {
    this.bookingService.getUserBookingsWithBoardingPasses(userId)
      .subscribe(
        (data: any) => {
          this.bookings = data;
          console.log(data);
        },
        (error: any) => {
          console.error(error);
        }
      );
  }

}
