package com.example.aviation.repo;

import com.example.aviation.domain.Booking;
import com.example.aviation.domain.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
    public Set<Booking> findBookingByUserid(Long id);
}
