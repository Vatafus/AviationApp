package com.example.aviation.service;

import com.example.aviation.domain.Role;
import com.example.aviation.repo.RoleRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepo roleRepo;


    public Role createRole(String roleName){
        return roleRepo.save(new Role(roleName));
    }
}
