package com.example.aviation.repo;

import com.example.aviation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public User findUserByEmail(String email);

    public List<User> findAll();
}
