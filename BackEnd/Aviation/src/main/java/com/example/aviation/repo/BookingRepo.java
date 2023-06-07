package com.example.aviation.repo;

import com.example.aviation.domain.Booking;
import com.example.aviation.domain.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BookingRepo extends JpaRepository<Booking,Long> {
    public Set<Booking> findBookingByUserid(Long id);
}
