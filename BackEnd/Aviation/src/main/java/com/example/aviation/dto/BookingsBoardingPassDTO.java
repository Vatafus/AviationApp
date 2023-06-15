package com.example.aviation.dto;


import com.example.aviation.domain.BoardingPass;
import lombok.Data;

import java.util.List;

@Data
public class BookingsBoardingPassDTO {
    private Long bookingId;
    private List<BoardingPass> boardingPassList;

}
