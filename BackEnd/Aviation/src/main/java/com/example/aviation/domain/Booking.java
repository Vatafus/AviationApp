//package com.example.aviation.domain;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Builder
//@Table(name="booking")
//public class Booking {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id", nullable = false,unique = true)
//    private Long id;
//    private Integer pozitiaX;
//    private Integer pozitiaY;
//    private Integer nrSeat;
//
//    @ManyToOne
//    private User userMapat;
//
//    @ManyToOne
//    private Flights flightsMapat;
//}
