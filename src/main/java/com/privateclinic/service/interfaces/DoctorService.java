package com.privateclinic.service.interfaces;

import com.privateclinic.persistence.entities.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<Doctor> getAllDoctors();

    Optional<Doctor> getDoctorById(Long doctorId);

    Doctor saveDoctor(Doctor doctor);

    Doctor updateDoctor(Long doctorId, Doctor updateDoctor);

    void deleteDoctor(Long doctorId);


    List<Doctor> findDoctorsBySpeciality(String speciality);


    List<Doctor> findDoctorsByShift(String shift);
}
