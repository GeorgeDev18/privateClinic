package com.privateclinic.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Person {

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
