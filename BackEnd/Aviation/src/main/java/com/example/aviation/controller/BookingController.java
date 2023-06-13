package com.example.aviation.controller;

import com.example.aviation.domain.BoardingPass;
import com.example.aviation.domain.Booking;
import com.example.aviation.domain.User;
import com.example.aviation.repo.BoardingPassRepo;
import com.example.aviation.repo.BookingRepo;
import com.example.aviation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/booking")
@RestController
@CrossOrigin
public class BookingController {
private BookingService bookingService;

private BoardingPassRepo boardingPassRepo;
private BookingRepo bookingRepo;

    @Autowired
    public BookingController(BookingService bookingService, BookingRepo bookingRepo, BoardingPassRepo boardingPassRepo) {
        this.bookingService = bookingService;
        this.bookingRepo = bookingRepo;
        this.boardingPassRepo = boardingPassRepo;
    }

@PostMapping("/{userId}/flights/{flightId}")
@ResponseBody
public Booking bookFlight(@PathVariable Long userId, @PathVariable Long flightId) {
    return bookingService.bookFlight(userId, flightId);
}

@GetMapping("/get-all-bookings/{userId}")
    public ResponseEntity<List<Booking>> getAllBookins(@PathVariable Long userId){
        User user = new User();
        user.setId(userId);
        List<Booking> bookings = bookingService.getBookingsByUserId(user);
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/{bookingId}/boarding-passes")
    public ResponseEntity<String> addBoardingPassToBooking(
            @PathVariable Long bookingId,
            @RequestBody BoardingPass boardingPass
    ) {
        try {
            bookingService.addBoardingPassToBooking(bookingId, boardingPass);
            return new ResponseEntity<>("Boarding pass added successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
