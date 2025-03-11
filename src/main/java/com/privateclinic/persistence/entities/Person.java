package com.privateclinic.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    protected Long id;

    @NotNull
    @Column(nullable = false, length = 50)
    protected String name;

    @NotNull
    @Column(nullable = false, length = 50)
    protected String surname;

    @NotNull
    @Column(nullable = false, unique = true)
    protected Long documentId;

    @NotNull
    @Column(nullable = false)
    protected LocalDate dateOfBirth;

    @NotNull
    @Column(nullable = false, unique = true)
    protected String email;

    @NotNull
    @Column(nullable = false)
    protected String address;

    @NotNull
    @Column(nullable = false)
    protected Long phoneNumber;

}
