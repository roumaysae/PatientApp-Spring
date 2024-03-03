package com.example.project_springboot;

import com.example.project_springboot.entities.Patient;
import com.example.project_springboot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
@Bean
CommandLineRunner  start(PatientRepository patientRepository){
            return  args -> {
              //ici je vais gerer les donnees avec ccette composante spring et le contenue de la methode RUN()
                patientRepository.save(new Patient(null,"Roumaysae",new Date(),false,20));
                patientRepository.save(new Patient(null,"Roumaysae",new Date(),false,29));
                patientRepository.save(new Patient(null,"Roumaysae",new Date(),false,24));
                patientRepository.save(new Patient(null,"Roumaysae",new Date(),false,25));
                patientRepository.save(new Patient(null,"Meryem",new Date(),true,22));
                patientRepository.save(new Patient(null,"KAoutar",new Date(),true,19));

                List<Patient> patients = patientRepository.findAll();//il va me retourner une liste de patients
                patients.forEach(patient ->{
                    System.out.println(patient.toString());
                });

                //Je veux consulter un patient : un patient qui a par exemple un id = 3;
              Patient patient = patientRepository.findById(Long.valueOf(3)).get();//j'ai le patient je veux afficher les infos :

                System.out.println("**************************Patient "+patient.getId()+" ********************");
                System.out.println(patient.getName());
                System.out.println(patient.getDateNaissance());
                System.out.println(patient.getScore());

                System.out.println("*************************Les patients qui ont le MEME NOM**********************");
                //chercher un patient FINDBYNAME :
                List<Patient> patients1 = patientRepository.findPatientByName("Roumaysae");//il va me retourner une liste de patients
                patients1.forEach(patient1 ->{
                    System.out.println(patient1.toString());
                });


                //supprimer un patient :
                patientRepository.deleteById(Long.valueOf(1));

               //mettre à jour un patient :
                Long patientIdToUpdate = 5L;
                Optional<Patient> optionalPatient = patientRepository.findById(patientIdToUpdate);

                if (optionalPatient.isPresent()) {
                    // Update the patient's attributes
                    Patient patientToUpdate = optionalPatient.get();
                    patientToUpdate.setName("ANOUAR");
                    patientToUpdate.setDateNaissance(new Date());
                    patientToUpdate.setScore(16);
                    patientToUpdate.setMalade(false);

                    // Save the updated patient back to the repository
                    patientRepository.save(patientToUpdate);

                    System.out.println("Patient updated successfully: " + patientToUpdate);
                } else {
                    System.out.println("Patient with ID " + patientIdToUpdate + " not found");
                }
            };


}
}
