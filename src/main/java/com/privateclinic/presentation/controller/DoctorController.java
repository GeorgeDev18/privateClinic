package com.privateclinic.presentation.controller;


import com.privateclinic.presentation.dto.DoctorDTO;
import com.privateclinic.service.implementation.DoctorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private  final DoctorServiceImpl doctorServiceImpl;

    public DoctorController(DoctorServiceImpl doctorServiceImpl){
        this.doctorServiceImpl = doctorServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
        List<DoctorDTO> doctors = doctorServiceImpl.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id) {
        Optional<DoctorDTO> doctor = doctorServiceImpl.getDoctorById(id);
        return doctor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        DoctorDTO savedDoctor = doctorServiceImpl.saveDoctor(doctorDTO);
        return ResponseEntity.ok(savedDoctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) {
        DoctorDTO updatedDoctor = doctorServiceImpl.updateDoctor(id, doctorDTO);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorServiceImpl.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar doctores por especialidad
    @GetMapping("/speciality/{speciality}")
    public ResponseEntity<List<DoctorDTO>> getDoctorsBySpeciality(@PathVariable String speciality) {
        List<DoctorDTO> doctors = doctorServiceImpl.findDoctorsBySpeciality(speciality);
        return ResponseEntity.ok(doctors);
    }

    // Buscar doctores por turno
    @GetMapping("/shift/{shift}")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByShift(@PathVariable String shift) {
        List<DoctorDTO> doctors = doctorServiceImpl.findDoctorsByShift(shift);
        return ResponseEntity.ok(doctors);
    }
}
