package com.example.aviation.repo;

import com.example.aviation.domain.Booking;
import com.example.aviation.domain.Flights;
import com.example.aviation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
    List<Booking> findByUserid(User userid);

    List<Booking> findByFlightsid(Flights flights);

    @Query("SELECT COUNT(bp) FROM Booking b JOIN b.boardingPasses bp WHERE b.flightsid = :flight")
    int countBoardingPassesByFlightsid(@Param("flight") Flights flight);
}
