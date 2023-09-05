package ru.polyclinik.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polyclinik.app.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
