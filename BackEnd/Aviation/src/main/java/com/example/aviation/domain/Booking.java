package com.example.aviation.domain;

import com.example.aviation.dto.BookingDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false,unique = true)
    private Long id;


    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userid;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "flights_id")
    private Flights flightsid;

    @Column(name="leavingfrom")
    private String leavingfrom;

    @Column(name="arrivingat")
    private String arrivingat;

    @Column(name="leavingdate")
    private Date leavingdate;

}
