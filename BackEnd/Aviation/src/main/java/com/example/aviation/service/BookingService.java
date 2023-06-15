package com.example.aviation.service;

import com.example.aviation.domain.BoardingPass;
import com.example.aviation.domain.Booking;
import com.example.aviation.domain.Flights;
import com.example.aviation.domain.User;
import com.example.aviation.repo.BoardingPassRepo;
import com.example.aviation.repo.BookingRepo;
import com.example.aviation.repo.FlightsRepo;
import com.example.aviation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private UserRepo userRepo;
    private FlightsRepo flightsRepo;

    private BookingRepo bookingRepo;

    private BoardingPassRepo boardingPassRepo;


    @Autowired
    public BookingService(UserRepo userRepository, FlightsRepo flightRepository, BookingRepo bookingRepo,BoardingPassRepo boardingPassRepo) {
        this.userRepo = userRepository;
        this.flightsRepo = flightRepository;
        this.bookingRepo = bookingRepo;
        this.boardingPassRepo = boardingPassRepo;
    }




    public void addBoardingPassToBooking(Long bookingId, BoardingPass boardingPass) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Rezervarea nu a fost găsită."));

        if (boardingPass.getName()== null || boardingPass.getIdentifycard() == null) {
            throw new RuntimeException("Numele și cardul de identitate sunt obligatorii pentru adăugarea unui boarding pass.");
        }

        boardingPass = boardingPassRepo.save(boardingPass);

        booking.addBoardingPass(boardingPass);
        Flights flight = booking.getFlightsid();
        int currentQuantity = flight.getNrseats();
        flight.setNrseats(currentQuantity - 1 - booking.getBoardingPasses().size());
        bookingRepo.save(booking);
    }

    public Booking bookFlight(Long userId, Long flightId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Flights flight = flightsRepo.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));

        int currentQuantity = flight.getNrseats();
        int occupiedSeats = bookingRepo.countBoardingPassesByFlightsid(flight);
        int availableSeats = currentQuantity - occupiedSeats;
        if (availableSeats <= 0) {
            throw new RuntimeException("Nu mai sunt locuri disponibile pentru acest zbor.");
        }
        Booking booking = new Booking();
        booking.setUserid(user);
        booking.setFlightsid(flight);
        booking.setArrivingat(flight.getArrivingat());
        booking.setLeavingfrom(flight.getLeavingfrom());
        booking.setLeavingdate(flight.getLeavingdate());


        Booking savedBooking = bookingRepo.save(booking);
        return savedBooking;
    }






}
