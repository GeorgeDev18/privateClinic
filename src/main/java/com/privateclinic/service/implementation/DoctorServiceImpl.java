package com.privateclinic.service.implementation;

import com.privateclinic.mapper.DoctorMapper;
import com.privateclinic.persistence.entities.Doctor;
import com.privateclinic.persistence.repository.DoctorRepository;
import com.privateclinic.presentation.dto.DoctorDTO;
import com.privateclinic.service.interfaces.DoctorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DoctorDTO> getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .map(doctorMapper::toDTO);
    }

    @Override
    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toEntity(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDTO(savedDoctor);
    }

    @Override
    @Transactional
    public DoctorDTO updateDoctor(Long doctorId, DoctorDTO updatedDoctorDTO) {
        Doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + doctorId));

//        existingDoctor.setSpeciality(updatedDoctorDTO.getSpeciality());
//        existingDoctor.setShift(updatedDoctorDTO.getShift());
//        existingDoctor.setSalary(updatedDoctorDTO.getSalary());

        Doctor updatedDoctor = doctorRepository.save(existingDoctor);
        return doctorMapper.toDTO(updatedDoctor);
    }

    @Override
    @Transactional
    public void deleteDoctor(Long doctorId) {
        if (!doctorRepository.existsById(doctorId)) {
            throw new EntityNotFoundException("Doctor not found with ID: " + doctorId);
        }
        doctorRepository.deleteById(doctorId);
    }

    @Override
    public List<DoctorDTO> findDoctorsBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality)
                .stream()
                .map(doctorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorDTO> findDoctorsByShift(String shift) {


        return doctorRepository.findByShift(shift)
                .stream()
                .map(doctorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
