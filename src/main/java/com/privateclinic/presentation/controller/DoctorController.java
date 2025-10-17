package com.privateclinic.presentation.controller;


import com.privateclinic.presentation.dto.DoctorDTO;
import com.privateclinic.service.implementation.DoctorServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private  final DoctorServiceImp doctorServiceImpl;

    public DoctorController(DoctorServiceImp doctorServiceImpl){
        this.doctorServiceImpl = doctorServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
        List<DoctorDTO> doctors = doctorServiceImpl.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id) {
        DoctorDTO doctor = doctorServiceImpl.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        DoctorDTO savedDoctor = doctorServiceImpl.saveDoctor(doctorDTO);
        return new ResponseEntity<>(savedDoctor,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id, @Valid @RequestBody DoctorDTO doctorDTO) {
        DoctorDTO updatedDoctor = doctorServiceImpl.updateDoctor(id, doctorDTO);
        return new ResponseEntity<>(updatedDoctor,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorServiceImpl.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/speciality/{speciality}")
    public ResponseEntity<List<DoctorDTO>> getDoctorsBySpeciality(@PathVariable String speciality) {
        List<DoctorDTO> doctors = doctorServiceImpl.findDoctorsBySpeciality(speciality);
        return ResponseEntity.ok(doctors);
    }


    @GetMapping("/shift/{shift}")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByShift(@PathVariable String shift) {
        List<DoctorDTO> doctors = doctorServiceImpl.findDoctorsByShift(shift);
        return ResponseEntity.ok(doctors);
    }

}