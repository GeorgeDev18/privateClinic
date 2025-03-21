package com.privateclinic.presentation.controller;


import com.privateclinic.presentation.dto.PatientDTO;
import com.privateclinic.service.implementation.PatientServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/patients")
public class PatientController {

    private  final PatientServiceImp patientServiceImp;

    @Autowired
    public PatientController(PatientServiceImp patientServiceImp){
        this.patientServiceImp = patientServiceImp;
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        List<PatientDTO> patients = patientServiceImp.getAllPatients();
        return patients.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(patients,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById (@PathVariable long id) {
        Optional<PatientDTO> patient = patientServiceImp.getPatientById(id);
        return patient.map(patientDTO -> new ResponseEntity<>(patientDTO, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        PatientDTO savedPatient = patientServiceImp.savePatient(patientDTO);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @Valid @RequestBody PatientDTO patientDTO) {
        PatientDTO updatePatient = patientServiceImp.updatePatient(id,patientDTO);
        return new ResponseEntity<>(updatePatient,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientServiceImp.deletePatient(id);
        return ResponseEntity.noContent().build();
    }





    }


