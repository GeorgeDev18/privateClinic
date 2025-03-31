package com.privateclinic.presentation.controller;

import com.privateclinic.presentation.dto.MedicalServiceDTO;
import com.privateclinic.service.implementation.MedicalServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medical-services")
public class MedicalServiceController {

    private final MedicalServiceImpl medicalServiceService;

    public MedicalServiceController(MedicalServiceImpl medicalServiceService) {
        this.medicalServiceService = medicalServiceService;
    }

    @GetMapping
    public ResponseEntity<List<MedicalServiceDTO>> getAllMedicalServices() {
        List<MedicalServiceDTO> services = medicalServiceService.getAllMedicalServices();
        return services.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalServiceDTO> getMedicalServiceById(@PathVariable Long id) {
        Optional<MedicalServiceDTO> service = medicalServiceService.getMedicalServiceById(id);
        return service.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MedicalServiceDTO> createMedicalService(@Valid @RequestBody MedicalServiceDTO medicalServiceDTO) {
        MedicalServiceDTO savedService = medicalServiceService.saveMedicalService(medicalServiceDTO);
        return new ResponseEntity<>(savedService, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalServiceDTO> updateMedicalService(@PathVariable Long id, @Valid @RequestBody MedicalServiceDTO medicalServiceDTO) {
        MedicalServiceDTO updatedService = medicalServiceService.updateMedicalService(id, medicalServiceDTO);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalService(@PathVariable Long id) {
        medicalServiceService.deleteMedicalService(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/code/{serviceCode}")
    public ResponseEntity<MedicalServiceDTO> getMedicalServiceByCode(@PathVariable String serviceCode) {
        Optional<MedicalServiceDTO> service = medicalServiceService.findMedicalServiceByCode(serviceCode);
        return service.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<MedicalServiceDTO>> getMedicalServicesByName(@PathVariable String name) {
        List<MedicalServiceDTO> services = medicalServiceService.findMedicalServicesByName(name);
        return services.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/max-price/{price}")
    public ResponseEntity<List<MedicalServiceDTO>> getMedicalServicesByMaxPrice(@PathVariable BigDecimal price) {
        List<MedicalServiceDTO> services = medicalServiceService.findMedicalServicesByMaxPrice(price);
        return services.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(services, HttpStatus.OK);
    }
}

