package com.example.aviation.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="archived_flights")
public class Archived {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "leavingfrom")
    private String leavingfrom;

    @Column(name = "arrivingat")
    private String arrivingat;

    @Column(name = "leavingdate")
    private Date leavingdate;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userid;


    @Column(name = "canceled")
    private boolean canceled;


}
