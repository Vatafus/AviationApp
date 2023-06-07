package com.example.aviation.service;

import com.example.aviation.domain.Booking;
import com.example.aviation.domain.Flights;
import com.example.aviation.domain.User;
import com.example.aviation.dto.BookingDTO;
import com.example.aviation.dto.FlightsDTO;
import com.example.aviation.dto.UserDTO;
import com.example.aviation.repo.BookingRepo;
import com.example.aviation.repo.FlightsRepo;
import com.example.aviation.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private BookingRepo bookingRepo;
    private UserRepo userRepo;
    private FlightsRepo flightsRepo;


    public Long addBooking(BookingDTO bookingDTO){
        User user = userRepo.findUserById(bookingDTO.getUserId());
        Flights flight = flightsRepo.findFlightsById(bookingDTO.getFlightId());
        Booking newBooking = new Booking(user,flight);

        Long newBookingId = bookingRepo.save(newBooking).getId();

        return newBookingId;
    }


}
