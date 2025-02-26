package com.privateclinic.persistence.repository;

import com.privateclinic.persistence.entities.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepositoy extends ListCrudRepository<Patient, Long> {

    List<Patient> findByHasMedicalInsurance(Boolean hasMedicalInsurance);


    Optional<Patient> findByPatientId(Long patientId);

}
