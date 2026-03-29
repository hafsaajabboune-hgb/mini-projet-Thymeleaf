package com.ecole.musique.ecole_musique;

import com.ecole.musique.ecole_musique.model.Cours;
import com.ecole.musique.ecole_musique.model.Instrument;
import com.ecole.musique.ecole_musique.model.Prof;
import com.ecole.musique.ecole_musique.repository.CoursRepository;
import com.ecole.musique.ecole_musique.repository.InstrumentRepository;
import com.ecole.musique.ecole_musique.repository.ProfRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final InstrumentRepository instrumentRepository;
    private final ProfRepository profRepository;
    private final CoursRepository coursRepository;

    public DataInitializer(InstrumentRepository instrumentRepository,
                           ProfRepository profRepository,
                           CoursRepository coursRepository) {
        this.instrumentRepository = instrumentRepository;
        this.profRepository = profRepository;
        this.coursRepository = coursRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (instrumentRepository.count() == 0) {
            Instrument p1 = new Instrument();
            p1.setNom("Piano Yamaha");
            p1.setFamille("Claviers");
            p1.setDisponibilite(true);

            Instrument g1 = new Instrument();
            g1.setNom("Guitare Classique");
            g1.setFamille("Cordes");
            g1.setDisponibilite(true);

            Instrument v1 = new Instrument();
            v1.setNom("Violon");
            v1.setFamille("Cordes");
            v1.setDisponibilite(false);

            instrumentRepository.saveAll(Arrays.asList(p1, g1, v1));
        }

        if (profRepository.count() == 0) {
            Prof prof1 = new Prof();
            prof1.setNom("Jean Dupont");
            prof1.setSpecialite("Piano");

            Prof prof2 = new Prof();
            prof2.setNom("Marie Curie");
            prof2.setSpecialite("Guitare");

            prof1 = profRepository.save(prof1);
            prof2 = profRepository.save(prof2);

            if (coursRepository.count() == 0) {
                Cours c1 = new Cours();
                c1.setJour("Lundi");
                c1.setHeureDebut(LocalTime.of(10, 0));
                c1.setDureeMin(60);
                c1.setNiveau("Débutant");
                c1.setProf(prof1);

                Cours c2 = new Cours();
                c2.setJour("Mercredi");
                c2.setHeureDebut(LocalTime.of(14, 30));
                c2.setDureeMin(90);
                c2.setNiveau("Intermédiaire");
                c2.setProf(prof2);

                coursRepository.saveAll(Arrays.asList(c1, c2));
            }
        }
    }
}
