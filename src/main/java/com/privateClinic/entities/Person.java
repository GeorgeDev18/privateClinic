package com.privateClinic.entities;

import java.time.LocalDate;

public abstract class Person {

    protected String name;
    protected String surname;
    protected long documentId;
    protected LocalDate dateOfBirth;
    protected String email;
    protected String address;
    protected long phoneNumber;

}
