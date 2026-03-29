package com.ecole.musique.ecole_musique.repository;

import com.ecole.musique.ecole_musique.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
    List<Cours> findByNiveau(String niveau);
    List<Cours> findByJour(String jour);
    List<Cours> findByNiveauAndJour(String niveau, String jour);
    List<Cours> findByProfId(Long profId);
}
