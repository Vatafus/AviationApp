package com.example.aviation.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date leavingdate;

    private LocalDate bookingdate;

    @Column(name="amount")
    private double amount;

    @Column(name="booking_cancelled")
    private boolean booking_cancelled = false;

    @Column(name="checked_in")
    private boolean checked_in = false;

    @Column(name="payment")
    private boolean payment = false;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "id")
    private Set<User> users;

}
