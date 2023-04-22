package com.example.aviation.repo;


import com.example.aviation.domain.Flights;
import com.example.aviation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepo extends JpaRepository<Flights,Long> {

    public Flights findFlightsByleavingfrom(String leavingfrom);
}
