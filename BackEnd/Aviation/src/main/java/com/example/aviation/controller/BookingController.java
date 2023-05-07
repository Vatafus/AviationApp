package com.example.aviation.controller;


import com.example.aviation.domain.Booking;
import com.example.aviation.domain.Passenger;
import com.example.aviation.domain.User;
import com.example.aviation.repo.BookingRepo;
import com.example.aviation.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookingController {
    @Autowired
    public BookingService bookingService;

    @Autowired
    public BookingRepo bookingRepo;



    @PostMapping("/BookFlight/{mailId}")
    public String bookFlight(@RequestBody Booking booking, @PathVariable("mailId") String mailId)
    {	log.info("Making the booking  with pnr:"+booking.getId());

        booking.setAmount(setAmount(booking));
        boolean present=bookingRepo.findById(booking.getId()).isPresent();
        if(present==false) {
            log.info("Made the booking  with pnr:"+booking.getId());
            bookingRepo.save(booking);
            /* return "Booking made with PNR:"+booking.getBooking_id(); */

            return bookingService.sendEmail(booking,mailId);}
        log.error("Booking Already present");
        return"Booking Already Made";
    }

    public double setAmount(Booking booking) {
        double tot_sum=0;
        List<Passenger> pas= booking.getPassengers();
        for (Passenger passenger : pas) {
            tot_sum+=passenger.getAmount();

        }
        return tot_sum;
    }
}
