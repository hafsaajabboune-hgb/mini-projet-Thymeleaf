package com.ecole.musique.ecole_musique.service;

import com.ecole.musique.ecole_musique.model.Cours;
import com.ecole.musique.ecole_musique.repository.CoursRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursService {

    private final CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public List<Cours> findAll() {
        return coursRepository.findAll();
    }

    public Optional<Cours> findById(Long id) {
        return coursRepository.findById(id);
    }

    public Cours save(Cours cours) {
        return coursRepository.save(cours);
    }

    public void deleteById(Long id) {
        coursRepository.deleteById(id);
    }

    public List<Cours> filter(String niveau, String jour) {
        if (niveau != null && !niveau.isEmpty() && jour != null && !jour.isEmpty()) {
            return coursRepository.findByNiveauAndJour(niveau, jour);
        } else if (niveau != null && !niveau.isEmpty()) {
            return coursRepository.findByNiveau(niveau);
        } else if (jour != null && !jour.isEmpty()) {
            return coursRepository.findByJour(jour);
        }
        return findAll();
    }
}
