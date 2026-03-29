package com.ecole.musique.ecole_musique.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Prof {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String specialite;

    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    private List<Cours> cours;

    public Prof() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public List<Cours> getCours() { return cours; }
    public void setCours(List<Cours> cours) { this.cours = cours; }
}
