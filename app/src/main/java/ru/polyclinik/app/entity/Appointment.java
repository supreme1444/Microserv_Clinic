package ru.polyclinik.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "startTime", nullable = false)
    private LocalDateTime startTime;

    @PrePersist
    private void onCreate() {
        startTime = LocalDateTime.now();
    }
}
