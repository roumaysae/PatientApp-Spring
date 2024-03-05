package com.example.project_springboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity //creer l'entité au niveau de la base de donnees as well.

@Data // generer les setters et getters
@NoArgsConstructor @AllArgsConstructor @Builder //designpattern qu'on utilise pour emplir les champs de la classe  //ajouter les cosntructeurs avec parametres et sans parametres

public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private  boolean malade;
    private int score;
    @OneToMany(mappedBy = "patient",fetch = FetchType.EAGER) //cette entité doit etre une entite JPA
    private Collection<RendezVous> rendezVousCollection;

}
