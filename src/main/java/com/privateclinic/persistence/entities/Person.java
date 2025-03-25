package com.privateclinic.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


import java.time.LocalDate;


@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

    @Column(nullable = false, length = 50)
    protected String name;

    @Column(nullable = false, length = 50)
    protected String surname;

    @Column(name = "document_id", nullable = false, unique = true)
    protected String documentId;

    @Column(name = "date_of_birth", nullable = false)
    protected LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    protected String email;

    @Column(nullable = false)
    protected String address;

    @Column(name = "phone_number", nullable = false)
    protected Long phoneNumber;

}
