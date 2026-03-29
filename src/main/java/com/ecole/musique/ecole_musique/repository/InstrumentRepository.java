package com.ecole.musique.ecole_musique.repository;

import com.ecole.musique.ecole_musique.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    List<Instrument> findByFamille(String famille);
    List<Instrument> findByDisponibilite(Boolean disponibilite);
    List<Instrument> findByFamilleAndDisponibilite(String famille, Boolean disponibilite);
}
