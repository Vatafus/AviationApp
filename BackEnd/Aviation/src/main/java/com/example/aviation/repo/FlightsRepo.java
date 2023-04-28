package com.example.aviation.repo;


import com.example.aviation.domain.Flights;
import com.example.aviation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepo extends JpaRepository<Flights,Long> {

    public List<Flights> findFlightsByleavingfrom(String leavingfrom);

    public List<Flights> findAll();

}
