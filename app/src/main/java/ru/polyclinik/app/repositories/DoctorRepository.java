package ru.polyclinik.app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polyclinik.app.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>  {

}
