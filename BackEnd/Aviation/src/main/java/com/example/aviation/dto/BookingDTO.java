package com.example.aviation.dto;

import com.example.aviation.domain.BoardingPass;
import com.example.aviation.domain.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookingDTO {
    private Long userId;
    private List<BoardingPass> boardingPasses;
}
