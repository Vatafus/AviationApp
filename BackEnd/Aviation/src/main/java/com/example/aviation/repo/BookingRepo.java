package com.example.aviation.repo;

import com.example.aviation.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Long> {

    @Query("from Booking where leavingdate = #{#leavingdate}")
    List<Booking> findByDate(@Param("departure_date") Date departure_date);
}
