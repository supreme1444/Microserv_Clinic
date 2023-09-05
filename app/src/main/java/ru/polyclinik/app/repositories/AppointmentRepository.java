package ru.polyclinik.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polyclinik.app.entity.Appointment;
import ru.polyclinik.app.entity.Doctor;
import ru.polyclinik.app.entity.Patient;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByDoctorAndAndStartTime(Doctor doctor, Date date);
    List<Appointment> findAllByPatient(Patient patient);
}
