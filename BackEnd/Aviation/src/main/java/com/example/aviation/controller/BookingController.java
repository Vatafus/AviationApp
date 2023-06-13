package com.example.aviation.controller;

import com.example.aviation.domain.Booking;
import com.example.aviation.domain.User;
import com.example.aviation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/booking")
@RestController
@CrossOrigin
public class BookingController {
private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

@PostMapping("/{userId}/flights/{flightId}")
public void bookFlight(@PathVariable Long userId, @PathVariable Long flightId) {
    bookingService.bookFlight(userId, flightId);
}

@GetMapping("/get-all-bookings/{userId}")
    public ResponseEntity<List<Booking>> getAllBookins(@PathVariable Long userId){
        User user = new User();
        user.setId(userId);
        List<Booking> bookings = bookingService.getBookingsByUserId(user);
        return ResponseEntity.ok(bookings);
    }
}
