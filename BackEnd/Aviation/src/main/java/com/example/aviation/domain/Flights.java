package com.example.aviation.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Flights(String leavingfrom, String arrivingat, Date leavingdate) {
        this.leavingfrom = leavingfrom;
        this.arrivingat = arrivingat;
        this.leavingdate = leavingdate;
    }
}
