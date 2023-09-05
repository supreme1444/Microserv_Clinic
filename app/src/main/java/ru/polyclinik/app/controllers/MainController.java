package ru.polyclinik.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.polyclinik.app.entity.Appointment;
import ru.polyclinik.app.service.AppointmentService;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/appointment")
public class MainController {
    private final AppointmentService service;

    @GetMapping("/{id}")
    public Appointment findAppointment(@PathVariable long id){
        return service.findOne(id);
    }

    @GetMapping("/doctor/{id}")
    public @ResponseBody List<Appointment> findAppointmentByDoctorAndDate(
            @PathVariable long id,
            @RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate
    ) {
        return service.findAllFree(id, fromDate);
    }

    @GetMapping("/patient/{id}")
    public List<Appointment> findAllByPatient(@PathVariable long id){
        return service.findAllBusy(id);
    }
}
