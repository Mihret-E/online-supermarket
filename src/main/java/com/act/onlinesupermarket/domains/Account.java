package com.act.onlinesupermarket.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
public class Account {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autogenerate Id number
    private Long id;

    @Size(max=15 , min = 3)
    @Column(nullable = false)
    @NotBlank(message = "First Name cannot be empty!")
    private String firstName;

    @Size(max=15 , min = 3)
    @Column(nullable = false)
    @NotBlank(message = "Middle Name cannot be empty!")
    private String middleName;

    @Size(max=15 , min = 3)
    @Column(nullable = false)
    @NotBlank(message = "Last Name cannot be empty!")
    private String lastName;

    @Column(nullable = false)
    @NotNull(message = "Date of Birth cannot be empty!")
    private LocalDate dateOfBirth;

    @Column(nullable = false,unique = true)
    @NotBlank(message = "Phone Number  cannot be empty!")
    private String phoneNumber;

    @Column(nullable = false,unique = true)
    @NotBlank(message = "Email Address cannot be empty!")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "Pin cannot be empty!")
    //@Size(max=6 , min = 4)    it doesnt work for integer
    private Integer pin;

    @Column(nullable = false)
    private Double balance = 0.0;

    @Column(nullable = false)
    private LocalDate openingDate = LocalDate.now();


}
