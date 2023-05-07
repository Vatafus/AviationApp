package com.example.aviation.repo;

import com.example.aviation.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {

    @Query("from Booking where leavingdate = #{#leavingdate}")
    List<Booking> findByDate(@Param("leavingdate") Date leavingdate);
}
