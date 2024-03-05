package com.example.project_springboot.repository;

import com.example.project_springboot.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
        Medecin findByName(String name);

}
