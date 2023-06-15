package com.example.aviation.repo;

import com.example.aviation.domain.BoardingPass;
import com.example.aviation.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardingPassRepo extends JpaRepository<BoardingPass, Long> {
    List<BoardingPass> findByBooking(Booking booking);
}
