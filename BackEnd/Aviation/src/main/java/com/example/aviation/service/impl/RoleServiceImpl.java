//package com.example.aviation.service.impl;
//
//
//import com.example.aviation.domain.Role;
//import com.example.aviation.repo.RoleRepo;
//import com.example.aviation.service.RoleService;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//public class RoleServiceImpl implements RoleService {
//
//    private RoleRepo roleRepo;
//
//    public RoleServiceImpl(RoleRepo roleRepo) {
//        this.roleRepo = roleRepo;
//    }
//
//    @Override
//    public Role createRole(String roleName){
//        return roleRepo.save(new Role(roleName));
//    }
//}
