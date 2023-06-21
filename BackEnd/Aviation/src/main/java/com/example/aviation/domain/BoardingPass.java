package com.example.aviation.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="boardingpass")
public class BoardingPass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="name")
    public String name;

    @Column(name="identifycard")
    public Long identifycard;

    @ManyToOne
    @JoinColumn(name= "booking_id")
    @JsonBackReference
    private Booking booking;

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void removeBooking() {
        this.booking = null;
    }



}
