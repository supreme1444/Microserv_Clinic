package ru.polyclinik.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.polyclinik.app.entity.Patient;
import ru.polyclinik.app.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository repository;

    public List<Patient> findAll(){
        return repository.findAll();
    }
    public Patient findOne(long id){
        Optional<Patient> foundedPatient = repository.findById(id);
        return foundedPatient.orElse(null);
    }

}
