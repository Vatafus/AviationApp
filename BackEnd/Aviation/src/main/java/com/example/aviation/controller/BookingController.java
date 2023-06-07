package com.example.aviation.controller;

import com.example.aviation.domain.Booking;
import com.example.aviation.domain.Flights;
import com.example.aviation.domain.User;
import com.example.aviation.dto.BookingDTO;
import com.example.aviation.dto.CreateDTO;
import com.example.aviation.repo.BookingRepo;
import com.example.aviation.repo.UserRepo;
import com.example.aviation.service.BookingService;
import com.example.aviation.service.FlightsService;
import com.example.aviation.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

}
