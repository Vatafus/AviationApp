package com.example.aviation.repo;


import com.example.aviation.domain.Flights;
import com.example.aviation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightsRepo extends JpaRepository<Flights,Long> {

    public List<Flights> findByLeavingfromAndArrivingatAndLeavingdate(String leavingfrom, String arrivingat, Date leavingdate);

    public Flights findFlightsById(long id);
    public List<Flights> findAll();

}
