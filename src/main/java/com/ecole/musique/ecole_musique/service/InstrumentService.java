package com.ecole.musique.ecole_musique.service;

import com.ecole.musique.ecole_musique.model.Instrument;
import com.ecole.musique.ecole_musique.repository.InstrumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentService {

    private final InstrumentRepository instrumentRepository;

    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    public List<Instrument> findAll() {
        return instrumentRepository.findAll();
    }

    public Optional<Instrument> findById(Long id) {
        return instrumentRepository.findById(id);
    }

    public Instrument save(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    public void deleteById(Long id) {
        instrumentRepository.deleteById(id);
    }

    public List<Instrument> filter(String famille, Boolean disponibilite) {
        if (famille != null && !famille.isEmpty() && disponibilite != null) {
            return instrumentRepository.findByFamilleAndDisponibilite(famille, disponibilite);
        } else if (famille != null && !famille.isEmpty()) {
            return instrumentRepository.findByFamille(famille);
        } else if (disponibilite != null) {
            return instrumentRepository.findByDisponibilite(disponibilite);
        }
        return findAll();
    }
}
