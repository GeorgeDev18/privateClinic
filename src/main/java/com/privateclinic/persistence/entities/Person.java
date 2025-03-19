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
@DiscriminatorColumn(name = "type")
@SequenceGenerator(name = "person_seq", sequenceName = "person_sequence", allocationSize = 1)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @Column(updatable = false)
    protected Long id;

    @NotNull
    @Column(length = 50)
    protected String name;

    @NotNull
    @Column(length = 50)
    protected String surname;

    @NotNull
    @Column(name = "document_id")
    protected String documentId;

    @NotNull
    @Column(name = "date_of_birth")
    protected LocalDate dateOfBirth;

    @NotNull
    @Column( unique = true)
    protected String email;

    @NotNull
    protected String address;

    @NotNull
    @Column(name = "phone_number")
    protected Long phoneNumber;

}
