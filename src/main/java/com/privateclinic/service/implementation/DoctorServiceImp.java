package com.privateclinic.service.implementation;

import com.privateclinic.exception.error.ElementNotFoundException;
import com.privateclinic.exception.error.NoContentException;
import com.privateclinic.exception.error.NoDataFoundException;
import com.privateclinic.mapper.DoctorMapper;
import com.privateclinic.persistence.entities.Doctor;
import com.privateclinic.persistence.repository.DoctorRepository;
import com.privateclinic.presentation.dto.DoctorDTO;
import com.privateclinic.service.interfaces.DoctorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorServiceImp implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private static final  String MESSAGE = "Doctor not found with ID: %s";

    @Autowired
    public DoctorServiceImp(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        List<DoctorDTO>doctors = doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toDTO)
                .toList();

        if(doctors.isEmpty()){
            throw new NoDataFoundException("No doctors found");
        }

        return doctors;
    }

    @Override
    public DoctorDTO getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .map(doctorMapper::toDTO)
                .orElseThrow(() -> new ElementNotFoundException(String.format(MESSAGE,doctorId)));
    }


    @Override
    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
        if (doctorDTO == null) {
            throw new IllegalArgumentException("doctor must not be null");
        }
        Doctor doctor = doctorMapper.toEntity(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDTO(savedDoctor);
    }

    @Override
    @Transactional
    public DoctorDTO updateDoctor(Long doctorId, DoctorDTO updatedDoctorDTO) {
        Doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ElementNotFoundException(String.format(MESSAGE, doctorId ) ));

        existingDoctor.setName(updatedDoctorDTO.getName());
        existingDoctor.setSurname(updatedDoctorDTO.getSurname());
        existingDoctor.setDocumentId(updatedDoctorDTO.getDocumentId());
        existingDoctor.setDateOfBirth(updatedDoctorDTO.getDateOfBirth());
        existingDoctor.setEmail(updatedDoctorDTO.getEmail());
        existingDoctor.setAddress(updatedDoctorDTO.getAddress());
        existingDoctor.setPhoneNumber(updatedDoctorDTO.getPhoneNumber());
        existingDoctor.setSpeciality(updatedDoctorDTO.getSpeciality());
        existingDoctor.setSalary(updatedDoctorDTO.getSalary());
        existingDoctor.setShift(updatedDoctorDTO.getShift());


        Doctor updatedDoctor = doctorRepository.save(existingDoctor);
        return doctorMapper.toDTO(updatedDoctor);
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        if (!doctorRepository.existsById(doctorId)) {
            throw  new ElementNotFoundException(String.format(MESSAGE, doctorId));
        }
        doctorRepository.deleteById(doctorId);
    }

    @Override
    public List<DoctorDTO> findDoctorsBySpeciality(String speciality) {
        List<Doctor> doctors = doctorRepository.findBySpecialityIgnoreCase(speciality);

        if (doctors.isEmpty()) {
            throw new NoContentException("No doctors found for speciality: " + speciality);
        }

        return doctors.stream()
                .map(doctorMapper::toDTO)
                .toList();
    }


    @Override
    public List<DoctorDTO> findDoctorsByShift(String shift) {
        List<Doctor> doctors = doctorRepository.findByShiftIgnoreCase(shift);

        if (doctors.isEmpty()) {
            throw new NoContentException("No doctors found for shift: " + shift);
        }

        return doctors.stream()
                .map(doctorMapper::toDTO)
                .toList();
    }

}
