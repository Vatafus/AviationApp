package com.example.aviation.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "role")
public enum Role {
    ROLE_USER,
    ROLE_ADMIN
}
