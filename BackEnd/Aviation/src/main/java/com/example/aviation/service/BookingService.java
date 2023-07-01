package com.example.aviation.service;

import com.example.aviation.domain.*;
import com.example.aviation.dto.BoardingPassDTO;
import com.example.aviation.dto.BookingDTO;
import com.example.aviation.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private UserRepo userRepo;
    private FlightsRepo flightsRepo;

    private BookingRepo bookingRepo;

    private ArchivedRepo archivedRepo;
    private BoardingPassRepo boardingPassRepo;


    @Autowired
    public BookingService(ArchivedRepo archivedRepo,UserRepo userRepository, FlightsRepo flightRepository, BookingRepo bookingRepo,BoardingPassRepo boardingPassRepo) {
        this.userRepo = userRepository;
        this.flightsRepo = flightRepository;
        this.bookingRepo = bookingRepo;
        this.boardingPassRepo = boardingPassRepo;
        this.archivedRepo = archivedRepo;
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
        int nrboardingpass = booking.getBoardingPasses().size();
        flight.setNrseats(currentQuantity - 1 - nrboardingpass);
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

        Flights flightSearch = new Flights();
        flightSearch.setId(flight.getId());
        flightSearch.setLeavingfrom(flight.getLeavingfrom());
        flightSearch.setArrivingat(flight.getArrivingat());
        flightSearch.setLeavingdate(flight.getLeavingdate());
        flightSearch.setIsActive(flight.getIsActive());
        booking.setFlightsid(flightSearch);


        Booking savedBooking = bookingRepo.save(booking);
        Archived archived = new Archived();
        archived.setUserid(user);
        archived.setId(savedBooking.getId());
        archived.setLeavingfrom(savedBooking.getLeavingfrom());
        archived.setArrivingat(savedBooking.getArrivingat());
        archived.setLeavingdate(savedBooking.getLeavingdate());
        archivedRepo.save(archived);
        return savedBooking;
    }



    public List<Booking> getBookingsByUserId(User user){
        return bookingRepo.findByUserid(user);
    }


    public List<BookingDTO> getBookingsWithBoardingPassesByUserId(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Booking> bookings = bookingRepo.findByUserid(user);
        List<BookingDTO> bookingDTOs = new ArrayList<>();

        for (Booking booking : bookings) {
            List<BoardingPass> boardingPasses = booking.getBoardingPasses();

            List<BoardingPassDTO> boardingPassDTOs = new ArrayList<>();
            for (BoardingPass boardingPass : boardingPasses) {
                BoardingPassDTO boardingPassDTO = new BoardingPassDTO();
                boardingPassDTO.setId(boardingPass.getId());
                boardingPassDTO.setName(boardingPass.getName());
                boardingPassDTO.setIdentifycard(boardingPass.getIdentifycard());

                boardingPassDTOs.add(boardingPassDTO);
            }

            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setId(booking.getId());
            bookingDTO.setLeavingfrom(booking.getLeavingfrom());
            bookingDTO.setArrivingat(booking.getArrivingat());
            bookingDTO.setLeavingdate(booking.getLeavingdate());
            bookingDTO.setCanceled(booking.getFlightsid().getIsActive());
            bookingDTO.setBoardingPasses(boardingPassDTOs);

            bookingDTOs.add(bookingDTO);
        }

        return bookingDTOs;
    }


    public void markCanceledBookingsInArchived() {
        List<Archived> archivedBookings = archivedRepo.findAll();
        List<Booking> bookings = bookingRepo.findAll();

        for (Archived archived : archivedBookings) {
            boolean existsInBooking = false;
            for (Booking booking : bookings) {
                if (archived.getId().equals(booking.getId())) {
                    existsInBooking = true;
                    break;
                }
            }
            if (!existsInBooking) {
                archived.setCanceled(true);
                archivedRepo.save(archived);
            }
        }

    }


}
