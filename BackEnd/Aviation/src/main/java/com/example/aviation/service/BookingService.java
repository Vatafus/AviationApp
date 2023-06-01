//package com.example.aviation.service;
//
//import com.example.aviation.domain.Booking;
//import com.example.aviation.domain.User;
//import com.example.aviation.repo.BookingRepo;
//import com.example.aviation.repo.UserRepo;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BookingService {
//
//    private BookingRepo bookingRepo;
//    private UserRepo userRepo;
//
//    public Booking addBooking(Booking booking){
//        for(Booking book : this.bookingRepo.findAll()){
//            if(book.getNrSeat().equals(booking.getNrSeat())
//                    &&book.getFlightsMapat().getLeavingdate().equals(booking.getFlightsMapat().getLeavingdate()))
//                return null;
//        }
//        return bookingRepo.save(booking);
//    }
//
//}
