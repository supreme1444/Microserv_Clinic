package ru.polyclinik.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.polyclinik.app.entity.Appointment;
import ru.polyclinik.app.entity.Doctor;
import ru.polyclinik.app.entity.Patient;
import ru.polyclinik.app.repositories.AppointmentRepository;
import ru.polyclinik.app.repositories.PatientRepository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository repository;
    private final PatientService patientService;
    private final DoctorService doctorService;

    public List<Appointment> findAllFree(long doctorId, Date date) {

        return repository.findAllByDoctorAndAndStartTime(doctorService.findOne(doctorId),
                date);
    }

    public List<Appointment> findAllBusy(long id) {
        return repository.findAllByPatient(patientService.findOne(id));
    }

    public Appointment findOne(long id){
        Optional<Appointment> foundedAppointment = repository.findById(id);
        return foundedAppointment.orElse(null);
    }
}
