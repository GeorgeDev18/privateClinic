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
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name = "person_seq", allocationSize = 1)
    protected Long id;

    @Column(length = 50)
    protected String name;

    @Column(length = 50)
    protected String surname;

    @Column(name = "document_id")
    protected String documentId;

    @Column(name = "date_of_birth")
    protected LocalDate dateOfBirth;

    @Column( unique = true)
    protected String email;

    protected String address;

    @Column(name = "phone_number")
    protected Long phoneNumber;

}
