import { Component } from '@angular/core';
import { BookingServiceService } from '../services/booking-service.service';
import { StorageServiceService } from '../services/storage-service.service';
import { Booking } from '../class/booking';
import { Boardingpass } from '../class/boardingpass';

@Component({
  selector: 'app-plan',
  templateUrl: './plan.component.html',
  styleUrls: ['./plan.component.css']
})
export class PlanComponent {

  bookings: Booking[];
  boardingPasses: Boardingpass[] = [];
  selectedBookingId: number = null;

  constructor(private bookingService: BookingServiceService, private storageService: StorageServiceService) { }

  ngOnInit(): void {
    this.getMyBookings();
  }

  getMyBookings() {
    const userId = this.storageService.getUser();
    this.bookingService.getUserBookings(userId).subscribe((data: any) => {
      this.bookings = data.bookings;
      this.boardingPasses = data.boardingPasses;
    })

  }

  getBoardingPasses(bookingId: number) {
    this.bookingService.getBoardingPasses(bookingId).subscribe((boardingPasses: Boardingpass[]) => {
      // Procesați boarding pass-urile obținute și faceți ceva cu ele, de exemplu, le puteți afișa în consolă sau le puteți utiliza în alt mod în aplicația dvs.
      console.log(boardingPasses);
    });
  }
}
