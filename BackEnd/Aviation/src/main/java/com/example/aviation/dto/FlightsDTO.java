package com.example.aviation.dto;


import com.example.aviation.domain.Flights;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leavingdate;

    @NotBlank
    private Integer nrseats;

    public FlightsDTO(Flights flights) {
        this.leavingfrom = flights.getLeavingfrom();
        this.arrivingat = flights.getArrivingat();
        this.leavingdate = flights.getLeavingdate();
            this.nrseats = flights.getNrseats();
    }

}
