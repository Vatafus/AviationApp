import { Component } from '@angular/core';
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
export class BookingComponent {

    flight: FlightSearch;
    posibleBooking: Booking;
    listaRezervariDorite: Array<number>;
    listaRezervariFacute: Array<Booking>;
    idFlight: number;

    constructor(private bookingService: BookingServiceService, private router: Router) {
    }

    //   mouseEnter(nrScaun: number) {
    //     console.log('mouse enter : ' + nrScaun);
    //     const pozX = nrScaun % 7 + 1;
    //     const pozY = Math.floor(nrScaun / 14) + 1;
    //     this.posibleBooking = new Booking(pozX, pozY, nrScaun);
    //   }

    //   verificaDacaExistaDorit(idDiv: number): boolean {
    //     for (let i = 0; i < this.listaRezervariDorite.length; i++) {
    //       if (this.listaRezervariDorite[i] === idDiv) {
    //         return true;
    //       }
    //     }
    //     return false;
    //   }

    //   verificaDacaExistaRezervat(idDiv: number): boolean {
    //     for (let i = 0; i < this.listaRezervariFacute.length; i++) {
    //       if (this.listaRezervariFacute[i].nrScaun === idDiv) {
    //         return true;
    //       }
    //     }
    //     return false;
    //   }

    //   addToList(idDiv: number) {
    //     if (!this.verificaDacaExistaDorit(idDiv) && !this.verificaDacaExistaRezervat(idDiv)) {
    //       this.listaRezervariDorite.push(idDiv);
    //       const myId = idDiv.toString();
    //       document.getElementById(myId).style.background = 'pink';
    //     } else if (!this.verificaDacaExistaRezervat(idDiv)) {
    //       for (let i = this.listaRezervariDorite.length - 1; i >= 0; i--) {
    //         if (this.listaRezervariDorite[i] === idDiv) {
    //           this.listaRezervariDorite.splice(i, 1);
    //           const myId = idDiv.toString();
    //           document.getElementById(myId).style.background =
    //             'linear-gradient(to top, #761818, #761818, #761818, #761818, #761818, #B54041,  #F3686A)';
    //         }
    //       }
    //     }
    //   }

    //   booking() {
    //     for (let i = 0; i < this.listaRezervariDorite.length; i++) {
    //       console.log('Id Flight ', this.idFlight);
    //       console.log('Nr seat', this.listaRezervariDorite[i]);
    //       this.bookingService.addBooking(this.idFlight, this.listaRezervariDorite[i])
    //         .subscribe(rez => {
    //         }, err => {
    //           console.log(err);
    //           alert('seat nr ' + this.listaRezervariDorite[i] + ' already reservated');
    //         });
    //     }
    //     this.coloreazaScaune();
    //   }

    //   coloreazaScaune() {
    //     for (let i = 0; i < this.listaRezervariDorite.length; i++) {
    //       const myId = this.listaRezervariDorite[i].toString();
    //       document.getElementById(myId).style.background = 'rgba(255, 255, 255, 1)';
    //     }
    //     this.listaRezervariDorite = new Array<number>();
    //   }


}
