package com.example.aviation.domain;


import com.example.aviation.dto.UserDTO;
import com.example.aviation.exception.UserRegistrationException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false,unique = true)
    private Long id;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="cpassword")
    private String cpassword;

    @Column(name="user_role", length=45)
    @Enumerated(EnumType.ORDINAL)
    private UserRole userRole;


    public UserRole getRole() {
        return userRole;
    }

    public User(String email, String password, String cpassword, UserRole userRole) {
        this.email = email;
        this.password = password;
        this.cpassword = cpassword;
        this.userRole = userRole;
    }

    public void setRole(UserRole role) {
        this.userRole = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }



    public UserDTO mapUsertoUserDto() {
        return new UserDTO(email, password, cpassword, userRole );
    }

    public User(UserDTO user) throws UserRegistrationException {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.cpassword = user.getCpassword();
        this.userRole = user.getUserRole();
    }


}
