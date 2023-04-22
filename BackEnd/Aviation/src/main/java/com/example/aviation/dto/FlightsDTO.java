package com.example.aviation.dto;


import com.example.aviation.domain.Flights;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightsDTO {

    @NotBlank(message = "Invalid leavingfrom!")
    private String leavingfrom;

    @NotBlank(message = "Invalid arrivingat!")
    private String arrivingat;

    @NotBlank(message = "Invalid date!")
    private Date leavingdate;

    public FlightsDTO(Flights flights) {
        this.leavingfrom = flights.getLeavingfrom();
        this.arrivingat = flights.getArrivingat();
        this.leavingdate = flights.getLeavingdate();
    }

}
