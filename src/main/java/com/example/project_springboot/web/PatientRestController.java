package com.example.project_springboot.web;

import com.example.project_springboot.entities.Patient;
import com.example.project_springboot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired //injection des dependances
    private PatientRepository patientRepository;
    @GetMapping("/patients") // pour ne pas avoir des relations avec les autres relations et entitées je vais utiliser
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
