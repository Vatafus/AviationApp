package com.example.aviation.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Reference;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
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

    @OneToMany
    private List<Passenger> passengers;

    public Booking() {}
    public Booking(Long id, Date leavingdate, LocalDate bookingdate, double amount, boolean booking_cancelled, boolean checked_in, boolean payment, List<Passenger> passengers) {
        super();
        this.id = id;
        this.leavingdate = leavingdate;
        this.bookingdate = bookingdate;
        this.amount = amount;
        this.booking_cancelled = booking_cancelled;
        this.checked_in = checked_in;
        this.payment = payment;
        this.passengers = passengers;
    }
}
