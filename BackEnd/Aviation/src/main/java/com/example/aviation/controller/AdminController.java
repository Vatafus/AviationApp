package com.example.aviation.controller;


import com.example.aviation.domain.BoardingPass;
import com.example.aviation.domain.Booking;
import com.example.aviation.domain.Flights;
import com.example.aviation.dto.FlightsDTO;
import com.example.aviation.repo.ArchivedRepo;
import com.example.aviation.repo.BoardingPassRepo;
import com.example.aviation.repo.BookingRepo;
import com.example.aviation.repo.FlightsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    FlightsRepo flightsRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ArchivedRepo archivedRepo;

    @Autowired
    BoardingPassRepo boardingPassRepo;

    @PostMapping("/create/flight")
    public Flights createFlight(@RequestBody Flights flights){
        flights.setIsActive(true);
        return flightsRepo.save(flights);
    }


    @PutMapping("/update/flight/{id}")
    public ResponseEntity<Flights> updateFlights(@PathVariable Long id, @RequestBody Flights flightsDetails){
        Flights flights = flightsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Flight does not exist with id" + id));
        flights.setLeavingfrom(flightsDetails.getLeavingfrom());
        flights.setArrivingat(flightsDetails.getArrivingat());
        flights.setNrseats(flightsDetails.getNrseats());
        flights.setLeavingdate(flightsDetails.getLeavingdate());
        flights.setHrs(flightsDetails.getHrs());
        flights.setIsActive(flightsDetails.getIsActive());

        Flights updateFlight = flightsRepo.save(flights);
        return ResponseEntity.ok(updateFlight);
    }

    @DeleteMapping("/delete/flight/{id}")
    public ResponseEntity<Map<String,Boolean>>deleteFlight(@PathVariable Long id){
        Flights flights = flightsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Flight not exist with id" + id));
        List<Booking> bookings = bookingRepo.findByFlightsid(flights);
        for(Booking booking : bookings) {
            Iterator<BoardingPass> iterator = booking.getBoardingPasses().iterator();

            while(iterator.hasNext()) {
                BoardingPass boardingPass = iterator.next();
                iterator.remove();
                boardingPass.setBooking(null);
                boardingPassRepo.delete(boardingPass);
            }
            booking.setCanceled(true); // Setați proprietatea canceled pe true
            bookingRepo.save(booking);
            bookingRepo.delete(booking);
        }
        flightsRepo.delete(flights);
        Map<String,Boolean>response = new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/mark-canceled-bookings")
    public void markCanceledBookingsInArchived() {
        archivedRepo.markCanceledBookings();
    }
}
