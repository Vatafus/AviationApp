package com.example.aviation.domain;

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
    private Booking booking;


}
