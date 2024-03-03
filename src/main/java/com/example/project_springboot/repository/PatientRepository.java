package com.example.project_springboot.repository;

import com.example.project_springboot.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
//c'est spring data qui va gerer les donnees au niveau de la base de donnees save , delete , update ...
   List<Patient> findPatientByName(String Nom);

}
