package com.example.project_springboot.service;

import com.example.project_springboot.entities.Consultation;
import com.example.project_springboot.entities.Medecin;
import com.example.project_springboot.entities.Patient;
import com.example.project_springboot.entities.RendezVous;

public interface IHospitalService {

    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
