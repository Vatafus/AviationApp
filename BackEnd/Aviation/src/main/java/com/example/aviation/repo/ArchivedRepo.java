package com.example.aviation.repo;

import com.example.aviation.domain.Archived;
import com.example.aviation.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface ArchivedRepo extends JpaRepository<Archived,Long> {
    Archived save(Archived archived);

    @Modifying
    @Query("UPDATE Archived a SET a.canceled = true WHERE a.id IN (SELECT b.id FROM Booking b WHERE b.canceled = true)")
    void markCanceledBookings();
}
