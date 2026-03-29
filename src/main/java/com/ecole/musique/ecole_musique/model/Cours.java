package com.ecole.musique.ecole_musique.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String jour;
    
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime heureDebut;
    
    private Integer dureeMin;
    private String niveau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof_id")
    private Prof prof;

    public Cours() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJour() { return jour; }
    public void setJour(String jour) { this.jour = jour; }

    public LocalTime getHeureDebut() { return heureDebut; }
    public void setHeureDebut(LocalTime heureDebut) { this.heureDebut = heureDebut; }

    public Integer getDureeMin() { return dureeMin; }
    public void setDureeMin(Integer dureeMin) { this.dureeMin = dureeMin; }

    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }

    public Prof getProf() { return prof; }
    public void setProf(Prof prof) { this.prof = prof; }
}
