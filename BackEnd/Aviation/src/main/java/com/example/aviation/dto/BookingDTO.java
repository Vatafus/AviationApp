package com.example.aviation.dto;

import com.example.aviation.domain.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookingDTO {
    private Long userId;
    private Long flightId;
}
