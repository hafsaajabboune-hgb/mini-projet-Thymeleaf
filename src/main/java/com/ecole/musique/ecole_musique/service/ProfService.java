package com.ecole.musique.ecole_musique.service;

import com.ecole.musique.ecole_musique.model.Prof;
import com.ecole.musique.ecole_musique.repository.ProfRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfService {

    private final ProfRepository profRepository;

    public ProfService(ProfRepository profRepository) {
        this.profRepository = profRepository;
    }

    public List<Prof> findAll() {
        return profRepository.findAll();
    }

    public Optional<Prof> findById(Long id) {
        return profRepository.findById(id);
    }

    public Prof save(Prof prof) {
        return profRepository.save(prof);
    }

    public void deleteById(Long id) {
        profRepository.deleteById(id);
    }
}
