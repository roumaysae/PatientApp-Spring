package com.example.project_springboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor


public class Consultation {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date dateConsulation;
    private  String Rapport;

    @OneToOne// se comporte de cle etrangere
    private RendezVous rendezVous;

}