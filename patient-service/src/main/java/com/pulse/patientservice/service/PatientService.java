package com.pulse.patientservice.service;

import com.pulse.patientservice.dto.PatientResponseDTO;
import com.pulse.patientservice.mapper.PatientMapper;
import com.pulse.patientservice.model.Patient;
import com.pulse.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        List<PatientResponseDTO> patientResponseDTOs = patients.stream().map(PatientMapper::toDTO).toList();

        return patientResponseDTOs;
    }
}
