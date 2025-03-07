package com.privateclinic.service.interfaces;

import com.privateclinic.persistence.entities.Doctor;
import com.privateclinic.presentation.dto.DoctorDTO;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<DoctorDTO> getAllDoctors();

    Optional<DoctorDTO> getDoctorById(Long doctorId);

    DoctorDTO saveDoctor(DoctorDTO doctorDTO);

    DoctorDTO updateDoctor(Long doctorId, DoctorDTO updatedDoctorDTO);

    void deleteDoctor(Long doctorId);

    List<DoctorDTO> findDoctorsBySpeciality(String speciality);

    List<DoctorDTO> findDoctorsByShift(String shift);
}
