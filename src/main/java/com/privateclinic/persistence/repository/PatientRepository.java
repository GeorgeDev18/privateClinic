package com.privateclinic.persistence.repository;

import com.privateclinic.persistence.entities.Patient;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends ListCrudRepository<Patient, Long> {

    List<Patient> findByHasMedicalInsurance(Boolean hasMedicalInsurance);




}
