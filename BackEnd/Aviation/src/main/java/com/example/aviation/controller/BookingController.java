package com.example.aviation.controller;

import com.example.aviation.domain.BoardingPass;
import com.example.aviation.domain.Booking;
import com.example.aviation.domain.User;
import com.example.aviation.dto.BookingDTO;
import com.example.aviation.repo.BoardingPassRepo;
import com.example.aviation.repo.BookingRepo;
import com.example.aviation.repo.UserRepo;
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

private UserRepo userRepo;
private BoardingPassRepo boardingPassRepo;
private BookingRepo bookingRepo;

    @Autowired
    public BookingController(UserRepo userRepo, BookingService bookingService, BookingRepo bookingRepo, BoardingPassRepo boardingPassRepo) {
        this.bookingService = bookingService;
        this.userRepo = userRepo;
        this.bookingRepo = bookingRepo;
        this.boardingPassRepo = boardingPassRepo;
    }

    @PostMapping("/{userId}/flights/{flightId}")
    @ResponseBody
    public Booking bookFlight(@PathVariable Long userId, @PathVariable Long flightId) {
        return bookingService.bookFlight(userId, flightId);
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



    @GetMapping("/user/{userId}/bookings")
    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Booking> bookings = bookingService.getBookingsByUserId(user);

        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        }
    }



    @GetMapping("/user/{userId}/bookings-with-boarding-passes")
    public ResponseEntity<List<BookingDTO>> getBookingsWithBoardingPassesByUserId(@PathVariable Long userId) {
        List<BookingDTO> bookings = bookingService.getBookingsWithBoardingPassesByUserId(userId);

        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        }
    }




}
