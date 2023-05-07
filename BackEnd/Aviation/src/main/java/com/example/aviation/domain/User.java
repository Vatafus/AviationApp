package com.example.aviation.domain;


import com.example.aviation.dto.UserDTO;
import com.example.aviation.exception.UserRegistrationException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="cpassword")
    private String cpassword;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Booking booking;


    public User(UserDTO user) throws UserRegistrationException {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.cpassword = user.getCpassword();
    }


}
