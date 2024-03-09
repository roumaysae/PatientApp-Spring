package com.example.project_springboot;

import com.example.project_springboot.entities.*;
import com.example.project_springboot.repository.ConsultationRepository;
import com.example.project_springboot.repository.MedecinRepository;
import com.example.project_springboot.repository.PatientRepository;
import com.example.project_springboot.repository.RendezVousRepository;
import com.example.project_springboot.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class ProjectSpringbootApplication {

    //en utilise l'injection de dependance pour dire au spring de m'injecter
    // un objet de type patientRepositorty au nivea de partientRepository;:
  //  @Autowired private PatientRepository patientRepository ;
    public static void main(String[] args) {

        SpringApplication.run(ProjectSpringbootApplication.class, args);//spring qui va demarerr
        // l'app spring boot (celui qui configurer JPA,scanner les classes,les annotations,et l'inversion de control)
    }
//pour ajouter des donnees et les enregistrer au niveau de la DB on va implementer
// l'interface commandlinerunner tout en utilisant la methode run
// qui va executer apres LE DEMARRage de spring //pour gerer les donnees on va utiliser spring data :
@Bean //every method va executer durant le demarage de l'app et il va creer un objet // injection des dependances laiiser sspring cherche l'implementation de l'interface jpae et l'injecter c'est ca le metier dde spring c'est du code technique
CommandLineRunner  start(IHospitalService HospitalService,PatientRepository patientRepository,MedecinRepository medecinRepository,RendezVousRepository rendezVousRepository){//pour faciliter de ne pas creer plsieurs objet de chaque classe on va creer un couche service contient tous
        //on va utiliser directement la couche service (metier) dans la pratique avant de creer un objet il y a des traitement à faire
        return  args -> {
                //tous ce code va executer au demarage de app //ici je vais gerer les donnees avec cette composante spring et le contenue de la methode RUN()
                //je vais creer le constructeur vide puis avoir set toutes les attributs : // la classe patient on va creer une boucle stream of
//patients
                Stream.of("Hassan","roumaysae","anouar").
                        forEach(name ->{
                    Patient patient = new Patient();
                    patient.setName(name);
                    patient.setDateNaissance(new Date());
                    patient.setMalade(true);
                    HospitalService.savePatient(patient);
                  //  patientRepository.save(patient);
                });
//medecin
                Stream.of("mohamed","aymane","yasmine").
                        forEach(name ->{
                            Medecin medecin = new Medecin();
                            medecin.setName(name);
                            medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                            medecin.setEmail(name+"@gmail.com");
                            HospitalService.saveMedecin(medecin);
                        });
                //Je veux consulter un patient : un patient qui a par exemple un id = 3;
                Patient patient3 = patientRepository.findById(Long.valueOf(3)).get();//j'ai le patient je veux afficher les infos

                System.out.println("**************************Patient "+patient3.getId()+" ********************");
                System.out.println(patient3.getName());
                System.out.println(patient3.getDateNaissance());
                System.out.println(patient3.getScore());

                Medecin medecin = medecinRepository.findByName("yasmine");
                //creer un rendezvous :
                RendezVous rendezVous = new RendezVous();
                rendezVous.setDate(new Date());
                rendezVous.setStatus(StatusRDV.PENDING);
                rendezVous.setPatient(patient3);
                rendezVous.setMedecin(medecin);
                HospitalService.saveRendezVous(rendezVous);


                //creer une consultation mais on veut le meme date du rendez vous :// je vais selectionenr le rendez vous d'abord :
                RendezVous rendezVous1 = rendezVousRepository.findById(1L).get();

                Consultation consultation = new Consultation();
                consultation.setDateConsulation(rendezVous1.getDate());
                consultation.setRapport("*****Rapport de consultation.........****");
                consultation.setRendezVous(rendezVous1);
                HospitalService.saveConsultation(consultation);
            };


}
}

