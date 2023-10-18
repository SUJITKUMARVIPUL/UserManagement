package com.sujit.UserManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Pattern(regexp = "^[A-Za-z-' ]+$")
    private String userName;

    private LocalDate userDOB;

    private String email;

    @Pattern(regexp = "^\\+\\d{2}\\d{10}$")
    private String phoneNumber;

}
