package com.privateclinic.persistence.repository;

import com.privateclinic.persistence.entities.Doctor;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DoctorRepository extends ListCrudRepository<Doctor,Long> {

    List<Doctor> findBySpeciality(String speciality);


    List<Doctor> findByShift(String shift);




}
