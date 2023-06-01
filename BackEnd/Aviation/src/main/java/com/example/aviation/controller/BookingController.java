//package com.example.aviation.controller;
//
//import com.example.aviation.domain.Booking;
//import com.example.aviation.domain.Flights;
//import com.example.aviation.domain.User;
//import com.example.aviation.dto.BookingDTO;
//import com.example.aviation.service.BookingService;
//import com.example.aviation.service.FlightsService;
//import com.example.aviation.service.UserService;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//import java.io.IOException;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@RequestMapping("/booking")
//@RestController
//@CrossOrigin
//public class BookingController {
//
//    private FlightsService flightsService;
//    private UserService userService;
//
//    private BookingService bookingService;
//
//    private final Map<String, SseEmitter> sseEmitters = new ConcurrentHashMap<>();
//
//    @PostMapping(value = "/booking")
//    public ResponseEntity<BookingDTO> addBooking(@RequestBody ObjectNode objectNode)  {
//
//        Integer pozitieX =  Integer.valueOf(objectNode.get("pozitieX").asText());
//        Integer pozitieY =  Integer.valueOf(objectNode.get("pozitieY").asText());
//        Integer nrSeat =  Integer.valueOf(objectNode.get("nrSeat").asText());
//        Long idFlight =  Long.valueOf(objectNode.get("idFlight").asText());
//        Long idUser = Long.valueOf(objectNode.get("idUser").asText());
//
//        Flights flights = flightsService.getFlights(idFlight);
//        User user = userService.getUserbyId(idUser);
//
//        Booking booking = bookingService.addBooking(Booking.builder()
//                .pozitiaX(pozitieX)
//                .pozitiaY(pozitieY)
//                .nrSeat(nrSeat)
//                .userMapat(user)
//                .flightsMapat(flights)
//                .build());
//        if(booking == null){
//            return new ResponseEntity<>(new BookingDTO(), HttpStatus.BAD_REQUEST);
//        }
//        try {
//            ////// trimitem la fiecare SseEmitter care apartine SpectacolData-ului cu id-ul dat, mesajul de rezervare noua
//            if (sseEmitters.containsKey(idUser)) {
//                try {
//                    for (SseEmitter sseEmitter : this.sseEmitters.values()) {
//                        sseEmitter.send(bookingDtoConverter(booking), MediaType.APPLICATION_JSON);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return new ResponseEntity<>(bookingDtoConverter(booking), HttpStatus.OK);
//    }
//
//    private BookingDTO bookingDtoConverter(Booking booking){
//        return BookingDTO.builder()
//                .pozitieX(booking.getPozitiaX())
//                .pozitieY(booking.getPozitiaY())
//                .nrSeat(booking.getNrSeat())
//                .build();
//    }
//}
