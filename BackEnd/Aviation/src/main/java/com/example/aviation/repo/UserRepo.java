package com.example.aviation.repo;

import com.example.aviation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public User findUserByEmail(String email);

    public List<User> findAll();


//    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
//    public User findByEmail(String email);
//
//    public User findByPasswordToken(String token);
}
