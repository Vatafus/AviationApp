package com.example.aviation.repo;

import com.example.aviation.domain.BoardingPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardingPassRepo extends JpaRepository<BoardingPass, Long> {
}
