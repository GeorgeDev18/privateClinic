package com.privateclinic.presentation.controller;

import com.privateclinic.presentation.dto.MedicalPackageDTO;
import com.privateclinic.service.implementation.MedicalPackageServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medical-packages")
public class MedicalPackageController {

    private final MedicalPackageServiceImpl medicalPackageService;

    public MedicalPackageController(MedicalPackageServiceImpl medicalPackageService) {
        this.medicalPackageService = medicalPackageService;
    }

    @GetMapping
    public ResponseEntity<List<MedicalPackageDTO>> getAllMedicalPackages() {
        List<MedicalPackageDTO> packages = medicalPackageService.getAllMedicalPackages();
        return packages.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(packages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalPackageDTO> getMedicalPackageById(@PathVariable Long id) {
        Optional<MedicalPackageDTO> medicalPackage = medicalPackageService.getMedicalPackageById(id);
        return medicalPackage.map(pkg -> new ResponseEntity<>(pkg, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MedicalPackageDTO> createMedicalPackage(@Valid @RequestBody MedicalPackageDTO medicalPackageDTO) {
        MedicalPackageDTO savedPackage = medicalPackageService.saveMedicalPackage(medicalPackageDTO);
        return new ResponseEntity<>(savedPackage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalPackageDTO> updateMedicalPackage(@PathVariable Long id, @Valid @RequestBody MedicalPackageDTO medicalPackageDTO) {
        MedicalPackageDTO updatedPackage = medicalPackageService.updateMedicalPackage(id, medicalPackageDTO);
        return new ResponseEntity<>(updatedPackage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalPackage(@PathVariable Long id) {
        medicalPackageService.deleteMedicalPackage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/code/{packageCode}")
    public ResponseEntity<MedicalPackageDTO> getMedicalPackageByCode(@PathVariable String packageCode) {
        Optional<MedicalPackageDTO> medicalPackage = medicalPackageService.findMedicalPackageByCode(packageCode);
        return medicalPackage.map(pkg -> new ResponseEntity<>(pkg, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<MedicalPackageDTO>> getMedicalPackagesByName(@PathVariable String name) {
        List<MedicalPackageDTO> packages = medicalPackageService.findMedicalPackagesByName(name);
        return packages.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(packages, HttpStatus.OK);
    }

    @GetMapping("/max-price/{price}")
    public ResponseEntity<List<MedicalPackageDTO>> getMedicalPackagesByMaxPrice(@PathVariable BigDecimal price) {
        List<MedicalPackageDTO> packages = medicalPackageService.findMedicalPackagesByMaxPrice(price);
        return packages.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(packages, HttpStatus.OK);
    }

    @GetMapping("/min-discount/{discount}")
    public ResponseEntity<List<MedicalPackageDTO>> getMedicalPackagesByDiscount(@PathVariable Integer discount) {
        List<MedicalPackageDTO> packages = medicalPackageService.findMedicalPackagesByDiscount(discount);
        return packages.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(packages, HttpStatus.OK);
    }
}
