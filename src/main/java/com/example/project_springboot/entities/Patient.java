package com.example.project_springboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity //creer l'entité au niveau de la base de donnees as well.

@Data // generer les setters et getters
@NoArgsConstructor @AllArgsConstructor //ajouter les cosntructeurs avec parametres et sans parametres

public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private  boolean malade;
    private int score;
}
