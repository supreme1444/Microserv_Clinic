package ru.polyclinik.app.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.polyclinik.app.entity.Doctor;
import ru.polyclinik.app.repositories.DoctorRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository repository;

    public Doctor findOne(long id){
        Optional<Doctor> foundedDoctor = repository.findById(id);
        return foundedDoctor.orElse(null);
    }
}
