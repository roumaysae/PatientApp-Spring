package com.example.project_springboot.service;

import com.example.project_springboot.entities.Consultation;
import com.example.project_springboot.entities.Medecin;
import com.example.project_springboot.entities.Patient;
import com.example.project_springboot.entities.RendezVous;
import com.example.project_springboot.repository.ConsultationRepository;
import com.example.project_springboot.repository.MedecinRepository;
import com.example.project_springboot.repository.PatientRepository;
import com.example.project_springboot.repository.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
        private PatientRepository patientRepository;
        private MedecinRepository medecinRepository;
        private RendezVousRepository rendezVousRepository;
        private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

//on va injecter les dependance en utilisant pas le AUUTOWIRED mais en utilisant le constructeur

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
