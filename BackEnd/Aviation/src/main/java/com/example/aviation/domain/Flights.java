package com.example.aviation.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="flights")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="leavingfrom")
    private String leavingfrom;

    @Column(name="arrivingat")
    private String arrivingat;

    @Column(name="leavingdate")
    private Date leavingdate;

    @Column(name="hrs")
    private String hrs;

    @Column(name = "NumberOfSeats")
    private Integer nrseats;

    @Column(name = "is_active")
    private Boolean isActive;

    public Flights(String leavingfrom, String arrivingat, Date leavingdate, Integer nrseats,String hrs,Boolean isActive) {
        this.leavingfrom = leavingfrom;
        this.arrivingat = arrivingat;
        this.leavingdate = leavingdate;
        this.nrseats = nrseats;
        this.hrs = hrs;
        this.isActive = isActive;
    }

}
