package com.example.aviation.domain;

import com.example.aviation.dto.BookingDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany
    @JoinColumn(name ="booking")
    @JsonBackReference
    private List<BoardingPass> boardingPasses = new ArrayList<>();

    @Column(name="leavingfrom")
    private String leavingfrom;

    @Column(name="arrivingat")
    private String arrivingat;

    @Column(name="leavingdate")
    private Date leavingdate;

    @Column(name = "canceled") // Adăugăm proprietatea canceled
    private boolean canceled;

    public void addBoardingPass(BoardingPass boardingPass){
        if(boardingPasses.size() >= 10){
            throw  new RuntimeException("Nu se pot adauga mai mult de 3 boarding passuri");
        }
        boardingPasses.add(boardingPass);
        boardingPass.setBooking(this);
    }

    public List<BoardingPass> getBoardingPasses() {
        return boardingPasses;
    }

    public void removeBoardingPass(BoardingPass boardingPass){
        boardingPasses.remove(boardingPass);
        boardingPass.removeBooking();
    }


}
